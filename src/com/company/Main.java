package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //TODO: Move to separate methods (sorry)
        Scanner scanner;
        String[] arrayProductNames = {
                "Tractor",
                "Shed",
                "Handbag"
        };
        // Print options
        System.out.println("------------------");
        System.out.println("FarmEssentials.com");
        System.out.println("------------------");
        System.out.println();
        System.out.println("Please make a selection from the following products");
        System.out.println("1: Tractor");
        System.out.println("2: Shed");
        System.out.println("3: Handbag");

        // Intake user choice
        System.out.println("Enter the number that corresponds to your choice:");

        boolean boolInputNotInt;
        int intOrderChoice = 0;
        do {
            do {
                try {
                    boolInputNotInt = false;
                    scanner = new Scanner(System.in);
                    intOrderChoice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("That is not a number! Please retry");
                    boolInputNotInt = true;
                }
            } while (boolInputNotInt);
            if (intOrderChoice < 1 || intOrderChoice > arrayProductNames.length) {
                System.out.println("Input doesn't match product index");
            }
        } while (intOrderChoice < 1 || intOrderChoice > arrayProductNames.length);


            System.out.println("You input: " + intOrderChoice);

            // Request order amount
            int intOrderAmount = 0;
            do {
                System.out.println("How many products would you like to order?");
                do {
                    try {
                        boolInputNotInt = false;
                        scanner = new Scanner(System.in);
                        intOrderAmount = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("That is not a number! Please retry");
                        boolInputNotInt = true;
                    }
                } while (boolInputNotInt);
                System.out.println("You input: " + String.valueOf(intOrderAmount));

                if (intOrderAmount > 5) {
                    System.out.println("You can only order up to five items at a time");
                    System.out.println("Please retry");
                } else if (intOrderAmount < 1) {
                    System.out.println("You must order at least one item");
                    System.out.println("Please retry");
                }
            } while (intOrderAmount > 5 || intOrderAmount < 1);

            scanner = new Scanner(System.in);
            // Create array
            String[] arrayAddressInput = new String[intOrderAmount];
            // Request addresses
            for (int i = 0; i < intOrderAmount; i++) {
                System.out.println("Enter the address for order " + (i + 1) + " of " + intOrderAmount + ":");
                String stringAddressInputCurrent = scanner.nextLine();
                System.out.println("You input: " + stringAddressInputCurrent);
                arrayAddressInput[i] = stringAddressInputCurrent;
            }
            // Output thanks
            System.out.println("Thanks!");
            System.out.println("You have ordered: " + intOrderAmount + " " + arrayProductNames[intOrderChoice - 1] + "(s)");
            System.out.println("For the following address(es):");
            for (int i = 0; i < intOrderAmount; i++) {
                System.out.print((i + 1) + ": ");
                System.out.println(arrayAddressInput[i]);
            }
            System.out.println("Thank you for your order!");
        }
    }

