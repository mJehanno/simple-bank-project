package com.mjehanno;

import com.mjehanno.account.Account;
import com.mjehanno.account.PaidAccount;
import com.mjehanno.account.SimpleAccount;
import com.mjehanno.account.SpareAccount;
import com.mjehanno.agency.Agency;
import com.mjehanno.menu.ConsoleMenu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Agency> agencies = new ArrayList<>();
        ConsoleMenu menu = new ConsoleMenu(agencies, sc);
        int choice1, choice2;


        // TODO : Refacto using ConsoleMenu to generate menu
        while(true) {

            choice1 = menu.entityChoice();

            System.out.println("Quelle opération souhaitez vous réaliser :");
            switch (choice1){
                // Agency Management
                case 1:
                default:
                    choice2 = menu.agencyManagement();
                    switch (choice2){
                        // Create agency
                        case 1:
                            System.out.println("adresse ?");
                            agencies.add(new Agency(sc.nextLine()));
                            break;
                        // List agencies
                        case 2:
                            for (Agency agency: agencies){
                                System.out.println(String.format("address : %s ; code agence : %d", agency.getAddress(), agency.getCodeAgence()));
                                System.out.println();
                            }
                            break;
                        // Delete agency
                        case 3:
                            System.out.println("code agence ?");
                            int codeToDelete = Integer.parseInt(sc.nextLine());
                            Iterator<Agency> iterator = agencies.iterator();

                            while(iterator.hasNext()){
                                Agency agency = iterator.next();
                                if(agency.getCodeAgence() == codeToDelete){
                                    iterator.remove();
                                }
                            }
                            break;
                        // Update agency
                        case 4:
                            System.out.println("code agence ?");
                            int codeToUpdate = Integer.parseInt(sc.nextLine());
                            System.out.println("Nouvelle adresse ?");
                            Iterator<Agency> iterator2 = agencies.iterator();
                            while(iterator2.hasNext()){
                                Agency agency = iterator2.next();
                                if(agency.getCodeAgence() == codeToUpdate){
                                    agency.setAddress(sc.nextLine());
                                }
                            }


                            break;
                    }

                    break;
                // Account Management
                case 2:
                    choice2 = menu.accountManagement();
                    switch (choice2){
                        // Create account
                        case 1:
                            Account newAccount;
                            System.out.println("code agence ?");
                            int codeAgence = Integer.parseInt(sc.nextLine());
                            System.out.println("Quel solde ?");
                            double solde = Double.parseDouble(sc.nextLine());
                            System.out.println("Quel type de compte : ");
                            int choiceTypeAccount = menu.typeAccount();
                            switch (choiceTypeAccount){
                                // Simple account
                                case 1:
                                default:
                                    newAccount = new SimpleAccount(codeAgence,solde);
                                    break;
                                // Spare account
                                case 2:
                                    newAccount = new SpareAccount(codeAgence, solde);
                                    break;
                                // Paid account
                                case 3:
                                    newAccount = new PaidAccount(codeAgence, solde);
                                    break;
                            }
                            Iterator<Agency> iterator3 = agencies.iterator();
                            while(iterator3.hasNext()){
                                Agency agency = iterator3.next();
                                if(agency.getCodeAgence() == codeAgence){
                                    agency.getListAccount().add(newAccount);
                                }
                            }
                            break;
                        // List account for agence
                        case 2:
                            System.out.println("code agence ?");
                            int codeAgenceToFind = Integer.parseInt(sc.nextLine());

                            for(Agency agency: agencies){
                                if(agency.getCodeAgence() == codeAgenceToFind) {
                                    for(Account account : agency.getListAccount()){
                                        System.out.println(String.format("Account => %s", account.toString()));
                                    }
                                }
                            }
                            break;
                        // Delete account
                        case 3:
                            System.out.println("code agence ?");
                            codeAgenceToFind = Integer.parseInt(sc.nextLine());
                            System.out.println("code compte ?");
                            int codeCompteToDelete = Integer.parseInt(sc.nextLine());
                            for(Agency agency: agencies){
                                if(agency.getCodeAgence() == codeAgenceToFind) {
                                    Iterator<Account> iteratorAccount = agency.getListAccount().iterator();
                                    while(iteratorAccount.hasNext()){
                                        Account account = iteratorAccount.next();
                                        if(account.getCodeCompte() == codeCompteToDelete){
                                            iteratorAccount.remove();
                                        }
                                    }
                                }
                            }
                            break;
                        // Update account
                        case 4:
                            System.out.println("code agence ?");
                            codeAgenceToFind = Integer.parseInt(sc.nextLine());
                            System.out.println("code compte ?");
                            int codeCompteToUpdate = Integer.parseInt(sc.nextLine());
                            System.out.println("quelle opération ?");
                            System.out.println("1) Retrait");
                            System.out.println("2) Virement");
                            int operation = Integer.parseInt(sc.nextLine());
                            System.out.println("montant ?");
                            double montant = Double.parseDouble(sc.nextLine());

                            for(Agency agency: agencies){
                                if(agency.getCodeAgence() == codeAgenceToFind) {
                                    Iterator<Account> accountIterator = agency.getListAccount().iterator();
                                    while (accountIterator.hasNext()){
                                        Account account = accountIterator.next();

                                        if(account.getCodeCompte() == codeCompteToUpdate){
                                            switch (operation){
                                                case 1:
                                                default:
                                                    account.retrait(montant);
                                                    break;
                                                case 2:
                                                    account.versement(montant);
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }



                            break;
                    }
                    break;
            }


        }
    }
}
