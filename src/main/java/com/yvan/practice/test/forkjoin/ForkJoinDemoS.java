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
public class ForkJoinDemoS extends RecursiveTask<List<InvestorInfoDto>> {


    List<InvestorInfoDto> investorInfoDtos;
    List<FinancierInfoDto> financierInfoDtos;

    public ForkJoinDemoS(List<InvestorInfoDto> investorInfoDtos, List<FinancierInfoDto> financierInfoDtos) {
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
            ForkJoinDemoS left = new ForkJoinDemoS(leftDto,financierInfoDtos);
            ForkJoinDemoS right = new ForkJoinDemoS(rightDto,financierInfoDtos);
            left.fork();
            right.fork();
            investorInfoDtoList.addAll(left.join());
            investorInfoDtoList.addAll(right.join());
        }
        return investorInfoDtoList;
    }

    public static List<InvestorInfoDto> distribute(List<InvestorInfoDto> investorInfoDtos, List<FinancierInfoDto> financierInfoDtoArrayList) {
        int index = 0;
        for (InvestorInfoDto investorInfoDto : investorInfoDtos) {
            BigDecimal financierSize = new BigDecimal(financierInfoDtoArrayList.size());
            BigDecimal divide = investorInfoDto.getFunds().divide(financierSize,
                    0, RoundingMode.DOWN);
            BigDecimal remainder = investorInfoDto.getFunds().remainder(financierSize);

            //未超出
            int intRemainder = remainder.intValue();
            int intFinancierSize = financierSize.intValue();
            if (intRemainder == 0) {
                for (FinancierInfoDto financierInfoDto : financierInfoDtoArrayList) {
                    investorInfoDto.getMap().put(financierInfoDto.getUsername(), divide);
                }
            } else if (index + intRemainder < intFinancierSize) {
                for (int num = index; num < intRemainder + index; num++) {
                    investorInfoDto.getMap().put(financierInfoDtoArrayList.get(num).getUsername(), divide.add(BigDecimal.ONE));
                }
                for (int num = intRemainder + index; num < intFinancierSize; num++) {
                    investorInfoDto.getMap().put(financierInfoDtoArrayList.get(num).getUsername(), divide);
                }
                for (int num = 0; num < index; num++) {
                    investorInfoDto.getMap().put(financierInfoDtoArrayList.get(num).getUsername(), divide);
                }
                //下一次存放位置
                index = (index + intRemainder) % intFinancierSize == 0 ? 0 : index + intRemainder;
            } else if (index + intRemainder >= intFinancierSize) {
                for (int num = index; num < intFinancierSize; num++) {
                    investorInfoDto.getMap().put(financierInfoDtoArrayList.get(num).getUsername(), divide.add(BigDecimal.ONE));
                }
                int newIndex = intRemainder - intFinancierSize + index;
                for (int num = 0; num < newIndex; num++) {
                    investorInfoDto.getMap().put(financierInfoDtoArrayList.get(num).getUsername(), divide.add(BigDecimal.ONE));
                }
                for (int num = newIndex; num < index; num++) {
                    investorInfoDto.getMap().put(financierInfoDtoArrayList.get(num).getUsername(), divide);
                }
                index = newIndex;
            }
        }
        return investorInfoDtos;
    }
}
