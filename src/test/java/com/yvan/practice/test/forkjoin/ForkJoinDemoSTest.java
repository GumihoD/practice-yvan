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
public class ForkJoinDemoSTest {

    @Test
    public void test() {
        System.out.println("beginning-----------------");
    }

    @Test
    public void testDistribute() {
        ArrayList<InvestorInfoDto> investorInfoDtos = Lists.newArrayList();
        ArrayList<FinancierInfoDto> financierInfoDtoArrayList = Lists.newArrayList();
        pacage(investorInfoDtos, financierInfoDtoArrayList);
        ForkJoinDemoS.distribute(investorInfoDtos, financierInfoDtoArrayList);
        for (InvestorInfoDto investorInfo : investorInfoDtos) {
            System.out.println("=====================投资人" + investorInfo.getUsername() + " 资金:" + investorInfo.getFunds());
            for (String key : investorInfo.getMap().keySet()) {
                System.out.println("融资人：" + key + " 获得融资 " + investorInfo.getMap().get(key));
            }
        }
    }

    @Test
    public void testForkJoinDemo() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();//对线程池的扩展
        ArrayList<InvestorInfoDto> investorInfoDtos = Lists.newArrayList();
        ArrayList<FinancierInfoDto> financierInfoDtoArrayList = Lists.newArrayList();
        pacage(investorInfoDtos, financierInfoDtoArrayList);
        Future<List<InvestorInfoDto>> result = forkJoinPool.submit(new ForkJoinDemoS(investorInfoDtos, financierInfoDtoArrayList));
        for (InvestorInfoDto investorInfo : result.get()) {
            System.out.println("=====================投资人" + investorInfo.getUsername() + " 资金:" + investorInfo.getFunds());
            for (String key : investorInfo.getMap().keySet()) {
                System.out.println("融资人：" + key + " 获得融资 " + investorInfo.getMap().get(key));
            }
        }
    }



    public void pacage(ArrayList<InvestorInfoDto> investorInfoDtos,ArrayList<FinancierInfoDto> financierInfoDtoArrayList){
        Random random = new Random(10);
        Random random2 = new Random(30);
        for (int i = 0; i < 3000; i++) {
            InvestorInfoDto investorInfoDto = new InvestorInfoDto();
            investorInfoDto.setUsername("investor" + i);
            investorInfoDto.setFunds(new BigDecimal(random.nextInt(20000)));
            investorInfoDtos.add(investorInfoDto);

            FinancierInfoDto financierInfoDto = new FinancierInfoDto();
            financierInfoDto.setUsername("financier" + i);
            financierInfoDto.setBalance(new BigDecimal(random2.nextInt(10000)));
            financierInfoDtoArrayList.add(financierInfoDto);
        }
    }



}