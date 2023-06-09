package org.example;

import java.util.Scanner;

public class AddressBookMain {


    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("  ::>>>Welcome AdressBook<<<::  ");

            System.out.println("1.Add New Contcat");
            System.out.println("2.View All Contacts");
            System.out.println("3.Edit Contacts");
            System.out.println("4.Delete Contact");
            System.out.println("5.Add New AddressBook ");
            System.out.println("6.show all AddressBooks ");
            System.out.println("7.serach by city ");
            System.out.println("8.search by state ");
            System.out.println("9.sort ");
            System.out.println("10.write to file");
            System.out.println("11.Read from file");



            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addressBook.add();
                    break;
                case 2:
                    addressBook.display1();
                    break;
                case 3:
                    addressBook.Edit1();
                    break;
                case 4:
                    addressBook.delete1();
                    break;
                case 5:
                    addressBook.AddAddressbook();
                    break;
                case 6:
                    addressBook.displayAllAddressbook();
                    break;
                case 7:
                    System.out.println(" Enter City:: ");
                    addressBook.searchBycity();
                    break;
                case 8:
                    System.out.println(" Enter state:: ");
                    addressBook.searchByState();
                    break;
                case 9:
                    addressBook.sort();
                    break;
                case 10:
                    addressBook.writeToFile();
                    break;

                case 11:
                    addressBook.readFromFile();
                    break;
                default:
                    System.out.println("Enter Option Between 1 To 7");

            }
        }
    }

}