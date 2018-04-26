package com.yvan.practice.test.forkjoin;

import com.google.common.collect.Lists;
import com.yvan.practice.dto.FinancierInfoDto;
import com.yvan.practice.dto.InvestorInfoDto;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * Created by yvan on 2017/4/12.
 */
public class ForkJoinInvestTest {

    @Test
    public void test() {
        System.out.println("beginning-----------------");
    }

    @Test
    public void testDistribute() {
        ArrayList<InvestorInfoDto> investorInfoDtos = Lists.newArrayList();
        ArrayList<FinancierInfoDto> financierInfoDtos = Lists.newArrayList();
        pacage(investorInfoDtos, financierInfoDtos);
        Long start = System.currentTimeMillis();
        ForkJoinInvest.distribute(investorInfoDtos, financierInfoDtos);
        System.out.println("================消耗时间：" + (System.currentTimeMillis() - start));
//        for (InvestorInfoDto investorInfo : investorInfoDtos) {
//            System.out.println("=====================投资人" + investorInfo.getUsername() + " 资金:" + investorInfo.getFunds());
//            for (String key : investorInfo.getMap().keySet()) {
//                System.out.println("融资人：" + key + " 获得融资 " + investorInfo.getMap().get(key));
//            }
//        }
    }

    @Test
    public void testForkJoinInvest() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();//对线程池的扩展
        ArrayList<InvestorInfoDto> investorInfoDtos = Lists.newArrayList();
        ArrayList<FinancierInfoDto> financierInfoDtos = Lists.newArrayList();
        pacage(investorInfoDtos, financierInfoDtos);
        Long start = System.currentTimeMillis();
        Future<List<InvestorInfoDto>> result = forkJoinPool.submit(new ForkJoinInvest(investorInfoDtos, financierInfoDtos));
        result.get();
        System.out.println("================消耗时间：" + (System.currentTimeMillis() - start));
//        for (InvestorInfoDto investorInfo : result.get()) {
//            System.out.println("=====================投资人" + investorInfo.getUsername() + " 资金:" + investorInfo.getFunds());
//            for (String key : investorInfo.getMap().keySet()) {
//                System.out.println("融资人：" + key + " 获得融资 " + investorInfo.getMap().get(key));
//            }
//        }
    }

    @Test
    public void testdistributeOneByOne() {
        ArrayList<InvestorInfoDto> investorInfoDtos = Lists.newArrayList();
        ArrayList<FinancierInfoDto> financierInfoDtos = Lists.newArrayList();
        pacage(investorInfoDtos, financierInfoDtos);
        Long start = System.currentTimeMillis();
        ForkJoinInvest.distributeOneByOne(investorInfoDtos, financierInfoDtos);
        Long time = System.currentTimeMillis() - start;
        for (FinancierInfoDto financierInfoDto : financierInfoDtos) {
            System.out.println("融资人：" + financierInfoDto.getUsername() + "需融资 ：" + financierInfoDto.getBalance());
        }
        for (InvestorInfoDto investorInfo : investorInfoDtos) {
            System.out.println("=====================投资人" + investorInfo.getUsername() + " 资金:" + investorInfo.getFunds());
            for (String key : investorInfo.getMap().keySet()) {
                System.out.println("融资人：" + key + " 获得融资 " + investorInfo.getMap().get(key));
            }
        }
        System.out.println("================消耗时间：" + time);
    }


    public void pacage(ArrayList<InvestorInfoDto> investorInfoDtos, ArrayList<FinancierInfoDto> financierInfoDtoArrayList) {
        Random random = new Random(101);
        Random random2 = new Random(30);
        for (int i = 0; i < 7; i++) {
            InvestorInfoDto investorInfoDto = new InvestorInfoDto();
            investorInfoDto.setUsername("investor" + i);
            investorInfoDto.setFunds(new BigDecimal(random.nextInt(30000)));
            investorInfoDtos.add(investorInfoDto);

            FinancierInfoDto financierInfoDto = new FinancierInfoDto();
            financierInfoDto.setUsername("financier" + i);
            financierInfoDto.setBalance(new BigDecimal(random2.nextInt(10000)));
            financierInfoDtoArrayList.add(financierInfoDto);
        }
    }




}