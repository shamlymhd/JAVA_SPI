package com.shamly.service.impl.current.account;

import com.shamly.service.api.account.Account;

public class CurrentAccount implements Account {

    public String getAccountType() {

        return "CurrentAccount";
    }

    public String getAccountId() {

        return "2";
    }

}
