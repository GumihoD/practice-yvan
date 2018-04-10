package com.yvan.practice.dto;

import java.math.BigDecimal;

/**
 * Created by yvan on 2017/4/11.
 */
public class FinancierInfoDto {

    /** 融资人ID **/
    private Long userId;
    /** 融资人姓名 **/
    private String username;
    /** 融资人账户余额 **/
    private BigDecimal balance;

    /** 集齐标识 **/
    private Boolean fullStatus;

    private BigDecimal currentBalance;

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Boolean getFullStatus() {
        return fullStatus;
    }

    public void setFullStatus(Boolean fullStatus) {
        this.fullStatus = fullStatus;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
