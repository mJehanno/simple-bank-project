package com.mjehanno.menu;

import com.mjehanno.agency.Agency;

import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    public ConsoleMenu(List<Agency> agencies, Scanner sc){
        this.agencies = agencies;
        this.sc = sc;
    }

    private Scanner sc;
    private List<Agency> agencies;


    public int entityChoice() {

        System.out.println("Quelle entité souhaitez vous manager :");
        System.out.println("1) Gérer les agences");
        if(!this.agencies.isEmpty()) {
            System.out.println("2) Gérer les comptes d'une agence");
        }
        return Integer.parseInt(sc.nextLine());
    }

    public int agencyManagement(){
        System.out.println("1) Créer une agence");
        System.out.println("2) Afficher les agences");
        System.out.println("3) Supprimer une agence");
        System.out.println("4) Modifier une agence");

        return Integer.parseInt((sc.nextLine()));
    }

    public int accountManagement(){
        System.out.println("1) Créer un compte");
        System.out.println("2) Afficher les compte");
        System.out.println("3) Supprimer un compte");
        System.out.println("4) Modifier un compte");

        return Integer.parseInt((sc.nextLine()));
    }

    public int typeAccount() {
        System.out.println("1) Simple Account");
        System.out.println("2) Spare Account");
        System.out.println("3) Paid Account");

        return Integer.parseInt((sc.nextLine()));
    }


}
