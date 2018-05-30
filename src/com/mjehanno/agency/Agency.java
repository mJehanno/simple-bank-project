package com.mjehanno.agency;

import com.mjehanno.account.Account;

import java.util.ArrayList;
import java.util.List;

public class Agency {

    private static int code = 0;
    private String address;
    private List<Account> listAccount = new ArrayList<>();
    private int codeAgence;


    public Agency(String address) {
        codeAgence = code;
        code ++;
        this.address = address;

    }

    public int getCodeAgence() {
        return codeAgence;
    }

    public void setCodeAgence(int codeAgence) {
        this.codeAgence = codeAgence;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getListAccount() {
        return listAccount;
    }

    public void setListAccount(List<Account> listAccount) {
        this.listAccount = listAccount;
    }
}
