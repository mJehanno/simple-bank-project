package com.mjehanno.account;

public abstract class Account {

    protected double solde;
    protected static  int code = 0;
    protected int codeAgence;
    protected int codeCompte;

    public Account(int codeAgence, double solde) {
        this.codeAgence = codeAgence;
        this.codeCompte = code;
        code ++;
        this.solde = solde;
    }


    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getCodeAgence() {
        return codeAgence;
    }

    public void setCodeAgence(int codeAgence) {
        this.codeAgence = codeAgence;
    }

    public int getCodeCompte() {
        return codeCompte;
    }

    public void setCodeCompte(int codeCompte) {
        this.codeCompte = codeCompte;
    }

    public void versement(double montant) {this.solde += montant;}
    public void retrait(double montant){ this.solde -= montant;}

    public String toString() {
        return String.format("Code : %c, Solde : %s", codeCompte, solde);
    }



}
