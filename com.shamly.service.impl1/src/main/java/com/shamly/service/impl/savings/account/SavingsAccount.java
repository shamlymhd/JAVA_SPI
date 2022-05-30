package com.shamly.service.impl.savings.account;

import com.shamly.service.api.account.Account;

public class SavingsAccount implements Account {

    public String getAccountType() {
        return "SavingsAccount";
    }

    public String getAccountId() {

        return "1";
    }

}
