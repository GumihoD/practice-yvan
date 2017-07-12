package com.yvan.practice.test.forkjoin;

import com.google.common.collect.Lists;
import com.yvan.practice.dto.FinancierInfoDto;
import com.yvan.practice.dto.InvestorInfoDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by yvan on 2017/4/12.
 */
public class ForkJoinInvest extends RecursiveTask<List<InvestorInfoDto>> {


    List<InvestorInfoDto> investorInfoDtos;
    List<FinancierInfoDto> financierInfoDtos;

    public ForkJoinInvest(List<InvestorInfoDto> investorInfoDtos, List<FinancierInfoDto> financierInfoDtos) {
        this.investorInfoDtos = investorInfoDtos;
        this.financierInfoDtos = financierInfoDtos;
    }

    @Override
    protected List<InvestorInfoDto> compute() {
        int split = 0;
        List<InvestorInfoDto> investorInfoDtoList = Lists.newArrayList();
        if (investorInfoDtos.size() < 10) {
            //计算
            return distribute(investorInfoDtos, financierInfoDtos);
        } else {
            int middle = investorInfoDtos.size() / 2;
            //TODO
            List<InvestorInfoDto> leftDto = investorInfoDtos.subList(0, middle);
            List<InvestorInfoDto> rightDto = investorInfoDtos.subList(middle, investorInfoDtos.size());
            ForkJoinInvest left = new ForkJoinInvest(leftDto, financierInfoDtos);
            ForkJoinInvest right = new ForkJoinInvest(rightDto, financierInfoDtos);
            left.fork();
            right.fork();
            investorInfoDtoList.addAll(left.join());
            investorInfoDtoList.addAll(right.join());
        }
        return investorInfoDtoList;
    }

    /**
     * 投资人的钱均分给融资人
     *
     * @param InvestorInfoDtos
     * @param financierInfoDtos
     * @return
     */
    public static List<InvestorInfoDto> distribute(List<InvestorInfoDto> InvestorInfoDtos, List<FinancierInfoDto> financierInfoDtos) {
        int index = 0;
        for (InvestorInfoDto investorInfoDto : InvestorInfoDtos) {
            BigDecimal financierSize = new BigDecimal(financierInfoDtos.size());
            BigDecimal divide = investorInfoDto.getFunds().divide(financierSize,
                    0, RoundingMode.DOWN);
            BigDecimal remainder = investorInfoDto.getFunds().remainder(financierSize);

            //未超出
            int intRemainder = remainder.intValue();
            int intFinancierSize = financierSize.intValue();
            if (intRemainder == 0) {
                for (FinancierInfoDto financierInfoDto : financierInfoDtos) {
                    investorInfoDto.getMap().put(financierInfoDto.getUsername(), divide);
                }
            } else if (index + intRemainder < intFinancierSize) {
                for (int num = index; num < intRemainder + index; num++) {
                    investorInfoDto.getMap().put(financierInfoDtos.get(num).getUsername(), divide.add(BigDecimal.ONE));
                }
                for (int num = intRemainder + index; num < intFinancierSize; num++) {
                    investorInfoDto.getMap().put(financierInfoDtos.get(num).getUsername(), divide);
                }
                for (int num = 0; num < index; num++) {
                    investorInfoDto.getMap().put(financierInfoDtos.get(num).getUsername(), divide);
                }
                //下一次存放位置
                index = (index + intRemainder) % intFinancierSize == 0 ? 0 : index + intRemainder;
            } else if (index + intRemainder >= intFinancierSize) {
                for (int num = index; num < intFinancierSize; num++) {
                    investorInfoDto.getMap().put(financierInfoDtos.get(num).getUsername(), divide.add(BigDecimal.ONE));
                }
                int newIndex = intRemainder - intFinancierSize + index;
                for (int num = 0; num < newIndex; num++) {
                    investorInfoDto.getMap().put(financierInfoDtos.get(num).getUsername(), divide.add(BigDecimal.ONE));
                }
                for (int num = newIndex; num < index; num++) {
                    investorInfoDto.getMap().put(financierInfoDtos.get(num).getUsername(), divide);
                }
                index = newIndex;
            }
        }
        return InvestorInfoDtos;
    }

    /**
     * 逐一用投资人人的钱的满足融资人
     *
     * @param InvestorInfoDtos
     * @param financierInfoDtos
     * @return
     */
    public static List<InvestorInfoDto> distributeOneByOne(List<InvestorInfoDto> InvestorInfoDtos, List<FinancierInfoDto> financierInfoDtos) {
        for (InvestorInfoDto investorInfoDto : InvestorInfoDtos) {
            BigDecimal funds = investorInfoDto.getFunds();
            //逐一分配投资人的投资资金
            for (FinancierInfoDto financierInfoDto : financierInfoDtos) {
                BigDecimal currentBalance = financierInfoDto.getCurrentBalance() == null ? BigDecimal.ZERO :
                        financierInfoDto.getCurrentBalance();
                BigDecimal balance = financierInfoDto.getBalance();
                int compareResult = currentBalance.compareTo(balance);
                if (compareResult == 1) {                //融资人已分配的资金大于所需投资 不存在的情况 异常
                    throw new RuntimeException("Wrong distrubute!");
                } else if (compareResult == 0) {                //融资人已分配的资金等于所需投资 融资已满 跳出此次循环
                    continue;
                } else if (compareResult == -1) {                //融资人已分配的资金小于所需投资 融资未满 继续分配资金
                    /**
                     * 1 融资人已分配资金加上投资人未分配的资金大于所需融资 则分满融资金额 修改剩余资金数额
                     * 2 融资人已分配资金加上投资人未分配的资金等于所需融资 恰巧分满 开始处理下一个投资人的资金
                     * 3 融资人已分配资金加上投资人未分配的资金小于所需融资 用完剩余资金 修改融资人已分配的资金
                     */
                    if (currentBalance.add(funds).compareTo(balance) == 1) {
                        financierInfoDto.setCurrentBalance(balance);
                        funds = funds.add(currentBalance).subtract(balance);
                        investorInfoDto.getMap().put(financierInfoDto.getUsername(), balance.subtract(currentBalance));
                    } else if (currentBalance.add(funds).compareTo(balance) == -1
                            || currentBalance.add(funds).compareTo(balance) == 0) {
                        financierInfoDto.setCurrentBalance(currentBalance.add(funds));
                        investorInfoDto.getMap().put(financierInfoDto.getUsername(), funds);
                        break;
                    }
                }
            }
        }
        return InvestorInfoDtos;
    }
}
