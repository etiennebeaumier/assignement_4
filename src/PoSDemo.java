// ---------------------------------------------------------
// Assignment 4
// Written by: Etienne Beaumier - 40211362
// For COMP 248 Section T – Fall 2023
// ---------------------------------------------------------

import java.util.Scanner;

public class PoSDemo {
    public static void main(String[] args) {
        // Welcome message

        Scanner scn = new Scanner(System.in);

        String type, ID_CardHolder;
        int expDay, expMonth, add_jun, add_teen, add_med, add_big, add_fam, choice;
        PrePaiCard card;


        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("| \tWelcome to Concordia CostLessBites Catering Sales Counter Application       |");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        // Create Sales configurations
        Sales sales1 = new Sales(0, 0, 0, 0, 11); // Same distribution for PoS 1 and 2
        Sales sales2 = new Sales(0, 10, 5, 0, 3); // Different configuration, same total $ amount as sales1
        Sales sales3 = new Sales(2, 1, 2, 1, 2); // Same breakdown for PoS 4 and 5, different from others

        // Create PrePaiCard arrays
        PrePaiCard[] cards1 = {
                new PrePaiCard("Standard", "123", 11, 10),
                new PrePaiCard("Premium", "456", 20, 12)
        };
        PrePaiCard[] cards2 = {
                new PrePaiCard("Standard", "123", 11, 10),
                new PrePaiCard("Premium", "456", 14, 12)
        };

        PrePaiCard[] cards3 = {
                new PrePaiCard("Standard", "789", 10, 10),
                new PrePaiCard("Premium", "101", 20, 9),
                new PrePaiCard("Deluxe", "112", 25, 8)
        }; // For PoS 3


        PrePaiCard[] cards4 = {};
        PrePaiCard[] cards5 = {}; // For PoS 4 and 5

        // Create PoS objects
        PoS pos1 = new PoS(sales1, cards1); // Same as PoS 2
        PoS pos2 = new PoS(new Sales(sales1), cards2); // Same as PoS 1
        PoS pos3 = new PoS(sales2, cards3); // Different sales configuration, same total $ amount as pos1
        PoS pos4 = new PoS(sales3, cards4); // Same sales as PoS 5, no prepaid cards
        PoS pos5 = new PoS(new Sales(sales3), cards5); // Clone to ensure separate objects
        PoS[] allPoSs = {pos1, pos2, pos3, pos4, pos5};


        while (true) {
            strChoice();

            choice = scn.nextInt();

            switch (choice) {

                case 0:
                    System.out.println("Thank you for using Concordia CostLessBites Catering Sales Counter Application!!");
                    System.exit(0);
                case 1:
                    System.out.println();
                    System.out.println("Content of each PoS:\n" +
                            "---------------------");
                    System.out.println(pos1);
                    System.out.println(pos2);
                    System.out.println(pos3);
                    System.out.println(pos4);
                    System.out.println(pos5);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Which PoS you want to see the content of? (Enter number 1 to 5): ");
                    choice = scn.nextInt();
                    System.out.println();
                    while (choice < 1 || choice > 5) {
                        System.out.println("Sorry but there is no PoS number" +choice+"\n");
                        System.out.print("--> Try again: (Enter number 1 to 5):");
                        choice = scn.nextInt();
                    }
                    switch (choice) {
                        case 1:
                            System.out.println(pos1);
                            System.out.println();
                            break;
                        case 2:
                            System.out.println(pos2);
                            System.out.println();
                            break;
                        case 3:
                            System.out.println(pos3);
                            System.out.println();
                            break;
                        case 4:
                            System.out.println(pos4);
                            System.out.println();
                            break;
                        case 5:
                            System.out.println(pos5);
                            System.out.println();
                            break;
                    }

                    break;
                case 3:
                    System.out.println("List of PoSs with same total $ Sales: \n");


                    for (int i = 0; i < allPoSs.length; i++) {
                        for (int j = i + 1; j < allPoSs.length; j++) {
                            if (allPoSs[i].equalValue(allPoSs[j])) {
                                System.out.println("PoS " + (i + 1) + " and PoS " + (j + 1) +
                                        " both have " +
                                        allPoSs[i].totalSales());
                            }
                        }
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("List of PoSs with same Sales categories:\n");
                    for (int i = 0; i < allPoSs.length; i++) {
                        for (int j = i + 1; j < allPoSs.length; j++) {
                            if (allPoSs[i].equalQty(allPoSs[i], allPoSs[j])) {
                                System.out.println("PoS " + (i + 1) + " and PoS " + (j + 1) + " both have " + allPoSs[i].salesBreakdown());
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("List of PoSs with same $ amount of sales and same number of Prepaid cards:\n");
                    for (int i = 0; i < allPoSs.length; i++) {
                        for (int j = i + 1; j < allPoSs.length; j++) {
                            if (allPoSs[i].equalValue(allPoSs[j]) && allPoSs[i].nbPrepaiCard() == allPoSs[j].nbPrepaiCard()) {
                                System.out.println("PoS " + (i + 1) + " and PoS " + (j + 1));
                            }
                        }
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    System.out.print("Which PoS would you like to add a Prepaid card to? ");
                    choice = scn.nextInt();
                    while (choice < 1 || choice > 5) {
                        System.out.println("Operation not supported\n");
                        System.out.print("Which PoS would you like to add a Prepaid card to? ");
                        choice = scn.nextInt();
                    }
                    switch (choice) {
                        case 1:
                            System.out.println("Input the type of the card, the ID of the cardholder, the expiry day and the expiry month ");
                            type = scn.next();
                            ID_CardHolder = scn.next();
                            expDay = scn.nextInt();
                            expMonth = scn.nextInt();
                            card = new PrePaiCard(type, ID_CardHolder, expDay, expMonth);
                            pos1.addPrePaiCard(card);
                            break;
                        case 2:
                            System.out.println("Input the type of the card, the ID of the cardholder, the expiry day and the expiry month");
                            type = scn.next();
                            ID_CardHolder = scn.next();
                            expDay = scn.nextInt();
                            expMonth = scn.nextInt();
                            card = new PrePaiCard(type, ID_CardHolder, expDay, expMonth);
                            pos2.addPrePaiCard(card);
                            break;
                        case 3:
                            System.out.println("Input the type of the card, the ID of the cardholder, the expiry day and the expiry month");
                            type = scn.next();
                            ID_CardHolder = scn.next();
                            expDay = scn.nextInt();
                            expMonth = scn.nextInt();
                            card = new PrePaiCard(type, ID_CardHolder, expDay, expMonth);
                            pos3.addPrePaiCard(card);
                            break;
                        case 4:
                            System.out.println("Input the type of the card, the ID of the cardholder, the expiry day and the expiry month");
                            type = scn.next();
                            ID_CardHolder = scn.next();
                            expDay = scn.nextInt();
                            expMonth = scn.nextInt();
                            card = new PrePaiCard(type, ID_CardHolder, expDay, expMonth);
                            pos4.addPrePaiCard(card);
                            break;
                        case 5:
                            System.out.println("Input the type of the card, the ID of the cardholder, the expiry day and the expiry month");
                            type = scn.next();
                            ID_CardHolder = scn.next();
                            expDay = scn.nextInt();
                            expMonth = scn.nextInt();
                            card = new PrePaiCard(type, ID_CardHolder, expDay, expMonth);
                            pos5.addPrePaiCard(card);
                            break;
                    }
                    break;
                case 7:
                    System.out.println();
                    System.out.print("Which PoS would you like to remove a Prepaid card to?");
                    choice = scn.nextInt();
                    while (choice < 1 || choice > 5) {
                        System.out.println("Operation not supported\n");
                        System.out.print("Which PoS would you like to remove a Prepaid card to?");
                        choice = scn.nextInt();
                    }
                    switch (choice) {
                        case 1:
                            System.out.println("Input the index of the card you want to remove");
                            choice = scn.nextInt();
                            while (choice < 0 || choice > pos1.nbPrepaiCard()) {
                                System.out.println("Invalid index");
                                System.out.println("Input the index of the card you want to remove");
                                choice = scn.nextInt();
                            }
                            pos1.removePrePaiCard(choice);
                            break;
                        case 2:
                            System.out.println("Input the index of the card you want to remove");
                            choice = scn.nextInt();
                            while (choice < 0 || choice > pos2.nbPrepaiCard()) {
                                System.out.println("Invalid index");
                                System.out.println("Input the index of the card you want to remove");
                                choice = scn.nextInt();
                            }
                            pos2.removePrePaiCard(choice);
                            break;
                        case 3:
                            System.out.println("Input the index of the card you want to remove");
                            choice = scn.nextInt();
                            while (choice < 0 || choice > pos3.nbPrepaiCard()) {
                                System.out.println("Invalid index");
                                System.out.println("Input the index of the card you want to remove");
                                choice = scn.nextInt();
                            }
                            pos3.removePrePaiCard(choice);
                            break;
                        case 4:
                            System.out.println("Input the index of the card you want to remove");
                            choice = scn.nextInt();
                            while (choice < 0 || choice > pos4.nbPrepaiCard()) {
                                System.out.println("Invalid index");
                                System.out.println("Input the index of the card you want to remove");
                                choice = scn.nextInt();
                            }
                            pos4.removePrePaiCard(choice);
                            break;
                        case 5:
                            System.out.println("Input the index of the card you want to remove");
                            choice = scn.nextInt();
                            while (choice < 0 || choice > pos5.nbPrepaiCard()) {
                                System.out.println("Invalid index");
                                System.out.println("Input the index of the card you want to remove");
                                choice = scn.nextInt();
                            }
                            pos5.removePrePaiCard(choice);
                            break;
                    }
                    break;
                case 8:
                    System.out.println();
                    System.out.print("Which PoS would you like to update the expiry date of a Prepaid card to?");
                    choice = scn.nextInt();
                    while (choice < 1 || choice > 5) {
                        System.out.println("Operation not supported\n");
                        System.out.print("Which PoS would you like to update the expiry date of a Prepaid card to?");
                        choice = scn.nextInt();
                    }
                    switch (choice) {
                        case 1:
                            if (pos1.nbPrepaiCard() == 0) {
                                System.out.println("No cards to update");
                                break;
                            }
                            System.out.println("Input the index of the card you want to update");
                            choice = scn.nextInt();
                            while (choice < 0 || choice > pos1.nbPrepaiCard() - 1) {
                                System.out.println("Invalid index");
                                System.out.println("Input the index of the card you want to update");
                                choice = scn.nextInt();
                            }
                            System.out.println("Input the new expiry day and month");
                            expDay = scn.nextInt();
                            expMonth = scn.nextInt();
                            pos1.updateExpiryDate(choice, expDay, expMonth);
                            break;
                        case 2:
                            if (pos2.nbPrepaiCard() == 0) {
                                System.out.println("No cards to update");
                                break;
                            }
                            System.out.println("Input the index of the card you want to update");
                            choice = scn.nextInt();
                            while (choice < 0 || choice > pos2.nbPrepaiCard() - 1) {
                                System.out.println("Invalid index");
                                System.out.println("Input the index of the card you want to update");
                                choice = scn.nextInt();
                            }
                            System.out.println("Input the new expiry day and month");
                            expDay = scn.nextInt();
                            expMonth = scn.nextInt();
                            pos2.updateExpiryDate(choice, expDay, expMonth);
                            break;
                        case 3:
                            if (pos3.nbPrepaiCard() == 0) {
                                System.out.println("No cards to update");
                                break;
                            }
                            System.out.println("Input the index of the card you want to update");
                            choice = scn.nextInt();
                            while (choice < 0 || choice > pos3.nbPrepaiCard() - 1) {
                                System.out.println("Invalid index");
                                System.out.println("Input the index of the card you want to update");
                                choice = scn.nextInt();
                            }
                            System.out.println("Input the new expiry day and month");
                            expDay = scn.nextInt();
                            expMonth = scn.nextInt();
                            pos3.updateExpiryDate(choice, expDay, expMonth);
                            break;
                        case 4:
                            if (pos4.nbPrepaiCard() == 0) {
                                System.out.println("No cards to update");
                                break;
                            }
                            System.out.println("Input the index of the card you want to update");
                            choice = scn.nextInt();
                            while (choice < 0 || choice > pos4.nbPrepaiCard() - 1) {
                                System.out.println("Invalid index");
                                System.out.println("Input the index of the card you want to update");
                                choice = scn.nextInt();
                            }
                            System.out.println("Input the new expiry day and month");
                            expDay = scn.nextInt();
                            expMonth = scn.nextInt();
                            pos4.updateExpiryDate(choice, expDay, expMonth);
                            break;
                        case 5:
                            if (pos5.nbPrepaiCard() == 0) {
                                System.out.println("No cards to update");
                                break;
                            }
                            System.out.println("Input the index of the card you want to update");
                            choice = scn.nextInt();
                            while (choice < 0 || choice > pos5.nbPrepaiCard() - 1) {
                                System.out.println("Invalid index");
                                System.out.println("Input the index of the card you want to update");
                                choice = scn.nextInt();
                            }
                            System.out.println("Input the new expiry day and month");
                            expDay = scn.nextInt();
                            expMonth = scn.nextInt();
                            pos5.updateExpiryDate(choice, expDay, expMonth);
                            break;
                    }
                    break;
                case 9:
                    System.out.println();
                    System.out.print("Which PoS would you like to add sales to? ");
                    choice = scn.nextInt();
                    while (choice < 1 || choice > 5) {
                        System.out.println("Operation not supported\n");
                        System.out.print("Which PoS would you like to add sales to? ");
                        choice = scn.nextInt();
                    }
                    switch (choice) {
                        case 1:
                            System.out.print("Input the number of sales for each size of meal: ");
                            add_jun = scn.nextInt();
                            add_teen = scn.nextInt();
                            add_med = scn.nextInt();
                            add_big = scn.nextInt();
                            add_fam = scn.nextInt();
                            pos1.addSales(add_jun, add_teen, add_med, add_big, add_fam);
                            break;
                        case 2:
                            System.out.print("Input the number of sales for each size of meal: ");
                            add_jun = scn.nextInt();
                            add_teen = scn.nextInt();
                            add_med = scn.nextInt();
                            add_big = scn.nextInt();
                            add_fam = scn.nextInt();
                            pos2.addSales(add_jun, add_teen, add_med, add_big, add_fam);
                            break;
                        case 3:
                            System.out.print("Input the number of sales for each size of meal: ");
                            add_jun = scn.nextInt();
                            add_teen = scn.nextInt();
                            add_med = scn.nextInt();
                            add_big = scn.nextInt();
                            add_fam = scn.nextInt();
                            pos3.addSales(add_jun, add_teen, add_med, add_big, add_fam);
                            break;
                        case 4:
                            System.out.print("Input the number of sales for each size of meal: ");
                            add_jun = scn.nextInt();
                            add_teen = scn.nextInt();
                            add_med = scn.nextInt();
                            add_big = scn.nextInt();
                            add_fam = scn.nextInt();
                            pos4.addSales(add_jun, add_teen, add_med, add_big, add_fam);
                            break;
                        case 5:
                            System.out.print("Input the number of sales for each size of meal: ");
                            add_jun = scn.nextInt();
                            add_teen = scn.nextInt();
                            add_med = scn.nextInt();
                            add_big = scn.nextInt();
                            add_fam = scn.nextInt();
                            pos5.addSales(add_jun, add_teen, add_med, add_big, add_fam);
                            break;
                    }
                    break;
                default:
                    System.out.println("Sorry that is not a valid choice.Try again.");
                    break;

            }


        }
    }


    private static void strChoice() {
        System.out.println("| What would you like to do?                                                    |");
        System.out.println("| 1  >> See the content of all PoSs                                             |");
        System.out.println("| 2  >> See the content of one PoS                                              |");
        System.out.println("| 3  >> List PoSs with same $ amount of sales                                   |");
        System.out.println("| 4  >> List PoS with same number of Sales categories                           |");
        System.out.println("| 5  >> List PoSs with same $ amount of Sales and same number of Prepaid cards  |");
        System.out.println("| 6  >> Add a Prepaid card to an existing PoS                                   |");
        System.out.println("| 7  >> Remove an existing Prepaid card from a PoS                              |");
        System.out.println("| 8  >> Update the expiry date of an existing Prepaid card                      |");
        System.out.println("| 9  >> Add sales to a PoS                                                      |");
        System.out.println("| 0  >> To quit                                                                 |");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.print("Please enter your choice and press <Enter>: ");
    }
}
