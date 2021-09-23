package com.MyTutorial;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {
        //Here we declare our running flag
        boolean runFlag=true;


        //Here we create some contacts to start with so we have something in our contact book
        Contact contact1= new Contact("Nikos");
        Contact contact2= new Contact("Paulos");
        Contact contact3= new Contact("Euthimios");
        Contact contact4= new Contact("Maria");
        Contact contact5= new Contact("Eleni");

        contact1.PhoneNumber="6945673421";
        contact2.PhoneNumber="6983487430";
        contact3.PhoneNumber="6939034412";
        contact4.PhoneNumber="6947823688";
        contact5.PhoneNumber="6989020715";

        //Here we create a contact book and populate it with the contacts from above
        ContactBook myBook= new ContactBook();
        myBook.addContact(contact1);
        myBook.addContact(contact2);
        myBook.addContact(contact3);
        myBook.addContact(contact4);
        myBook.addContact(contact5);


        //Here we display the initial menu to the user
        while(runFlag) {
            displayMenu();

            //Here we start a scanner to read user input
            Scanner scan = new Scanner(System.in);
            try {
                int input= scan.nextInt();
                switch (input){
                    case 1:
                        //Here we display our contact book using the ContactBook own method that we build
                        myBook.displayBook();
                        break;
                    case 2:
                        //Here we add a new contact using the ContactBook own method that we build
                        myBook=addNewContact(scan,myBook);
                        break;
                    case 3:
                        //Here we display a contact by name
                        showContactByName(scan,myBook);
                        break;
                    case 4:
                        //Here we display a contact by number
                        showContactByNumber(scan,myBook);
                        break;
                    case 5:
                        //Here we update a contact by name
                        //First we display the current info
                        Contact oldContact=showContactByName(scan,myBook);
                        //Then we update the ContactBook
                        myBook=updateContact(scan,myBook,oldContact);
                        //Finally we display the new contact
                        showNewContact(myBook,oldContact.Name);
                        break;
                    case 6:
                        //Here we delete a contact by name
                        myBook=deleteContactByName(scan,myBook);
                        //Then we show the new Contact Book
                        myBook.displayBook();
                        break;
                    case 7:
                        runFlag=false;
                        break;
                    default:
                        runFlag=true;
                }
                System.out.print("Press any key to continue . . . \n");
                scan.nextLine();
                scan.nextLine();

            }
            catch(Exception e) {
                System.out.println("Something went wrong with the input you provided");
            }
        }







    }




    private static void displayMenu(){
        System.out.println("!Welcome the your Contact Book Java App!");
        System.out.println("This app was developed by K.Ziovas AM:18072");
        System.out.println("Press a number to choose one of the following options:");
        System.out.println("1: View the entire contact book");
        System.out.println("2: Add new contact");
        System.out.println("3: Search contact by name");
        System.out.println("4: Search contact by number");
        System.out.println("5: Update contact by name");
        System.out.println("6: Delete contact by name");
        System.out.println("7: Exit the app");

    }


    private static ContactBook addNewContact(Scanner scan,ContactBook myBook){

        System.out.println("Please give a name \n" );
        scan.nextLine();
        String newName=scan.nextLine();
        Contact newContact= new Contact(newName);
        System.out.println("Please give an Email \n");
        String newEmail=scan.nextLine();
        newContact.setEmail(newEmail);
        System.out.println("Please give a Phone Number \n");
        String newNumber=scan.nextLine();
        newContact.setPhoneNumber(newNumber);
        System.out.println("Please give an Address \n");
        String newAddress=scan.nextLine();
        newContact.setAddress(newAddress);
        System.out.println("Please give a Country \n");
        String newCountry=scan.nextLine();
        newContact.setCountry(newCountry);
        System.out.println("Please give a Company \n");
        String newCompany=scan.nextLine();
        newContact.setCompany(newCompany);
        myBook.addContact(newContact);

        return myBook;

    }

    private static Contact showContactByName(Scanner scan,ContactBook myBook){

        System.out.println("Please give a name \n" );
        scan.nextLine();
        String newName=scan.nextLine();
        myBook.displayContact(myBook.getByName(newName));
        return myBook.getByName(newName);
    }

    private static Contact showContactByNumber(Scanner scan,ContactBook myBook){
        System.out.println("Please give a number \n" );
        scan.nextLine();
        String newNumber=scan.nextLine();
        myBook.displayContact(myBook.getByNumber(newNumber));
        return myBook.getByNumber(newNumber);
    }


    private static ContactBook updateContact(Scanner scan,ContactBook myBook,Contact oldContact){

        Contact newContact= new Contact(oldContact.Name);
        System.out.println("Please give a new Email \n");
        String newEmail=scan.nextLine();
        newContact.setEmail(newEmail);
        System.out.println("Please give a  new Phone Number \n");
        String newNumber=scan.nextLine();
        newContact.setPhoneNumber(newNumber);
        System.out.println("Please give a new Address \n");
        String newAddress=scan.nextLine();
        newContact.setAddress(newAddress);
        System.out.println("Please give a new Country \n");
        String newCountry=scan.nextLine();
        newContact.setCountry(newCountry);
        System.out.println("Please give a new Company \n");
        String newCompany=scan.nextLine();
        newContact.setCompany(newCompany);
        myBook.deleteContact(oldContact);
        myBook.addContact(newContact);

        return myBook;

    }

    private static Contact showNewContact( ContactBook myBook, String newName){
        myBook.displayContact(myBook.getByName(newName));
        return myBook.getByName(newName);
    }

    private static ContactBook deleteContactByName(Scanner scan,ContactBook myBook){

        System.out.println("Please give the name of the contact that you want to delete: \n" );
        scan.nextLine();
        String newName=scan.next();
        myBook.deleteByName(newName);
        return myBook;
    }
}
