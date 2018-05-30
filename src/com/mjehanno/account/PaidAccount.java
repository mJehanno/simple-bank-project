package com.mjehanno.account;

public class PaidAccount extends Account {

    public PaidAccount(int codeAgence, double solde){
        super(codeAgence, solde);
    }

    @Override
    public void versement(double montant) {
        this.solde = montant - 0.05 * montant;
    }

    @Override
    public void retrait(double montant) {
        this.solde -= (montant + 0.05 * montant);
    }
}
