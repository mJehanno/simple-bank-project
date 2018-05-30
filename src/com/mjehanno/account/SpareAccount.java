package com.mjehanno.account;

public class SpareAccount extends Account{

    private float tauxInteret;

    public SpareAccount(int codeAgence, double solde) {
        super(codeAgence, solde);
    }

    public void calculInteret(){
        this.solde += this.solde * this.tauxInteret;
    }

}
