package com.example.demo;

import com.shamly.service.api.account.Account;

import java.util.ServiceLoader;

public class AccountService {

    private static AccountService service;
    private ServiceLoader<Account> loader;

    private AccountService(){
        loader=ServiceLoader.load(Account.class);
    }

    public static synchronized AccountService getInstance() {
        if (service == null) {
            service = new AccountService();
        }
        return service;
    }

    public ServiceLoader<Account> getLoader() {
        return loader;
    }

    public void setLoader(ServiceLoader<Account> loader) {
        this.loader = loader;
    }


}
