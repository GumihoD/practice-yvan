package com.yvan.practice.dto;

import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by yvan on 2017/4/11.
 */
public class InvestorInfoDto {

    /**
     * 投资人ID
     **/
    private Long userId;
    /**
     * 投资人姓名
     **/
    private String username;
    /**
     * 投资人账户余额
     **/
    private BigDecimal funds;
    /**
     * 投资人资金去向 分配明细
     **/
    private List<FinancierInfoDto> financierInfoDtoList;

    private Map<String, Object> map = Maps.newHashMap();

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getFunds() {
        return funds;
    }

    public void setFunds(BigDecimal funds) {
        this.funds = funds;
    }

    public List<FinancierInfoDto> getFinancierInfoDtoList() {
        return financierInfoDtoList;
    }

    public void setFinancierInfoDtoList(List<FinancierInfoDto> financierInfoDtoList) {
        this.financierInfoDtoList = financierInfoDtoList;
    }
}
