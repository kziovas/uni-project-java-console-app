package com.MyTutorial;
import java.util.*;


public class ContactBook {
    public ContactBook(){
        Contact empty= new Contact("The contact does not exist");
        empty.setPhoneNumber("The contact does not exist");
        this.CB.add(empty);

    };

    public List<Contact> CB= new LinkedList<Contact>();


    public List<Contact> getCB() {
        return CB;
    }


    public boolean addContact(Contact contact){

        if(existsContact(contact.Name)){

            System.out.println("This contact already exists!");
            return  false;
        }
        else{

            if( this.CB.add(contact)){
                System.out.println("Contact was added successfully");
                return true;
            }

            else{
                System.out.println("Something went wrong! Contact was not added.");
                return  false;
            }
        }


    };

    public Boolean deleteContact(Contact contact){

        if(existsContact(contact.Name)){

            if( this.CB.remove(contact)){

                return true;
            }

            else{

                return  false;
            }
        }
        else{

            return  false;
        }






    };

    public String deleteByName(String name){

        if(existsContact(name)){

            boolean test=this.CB.removeIf(contact -> contact.Name.equals(name));

            if( test){

                return "Contact was deleted successfully";
            }

            else{

                return  "Something went wrong! Contact was not deleted.";
            }

        }
        else{

            return  "This contact does not exist!";
        }

    };


    public Contact getByName(String name){
        Contact matchContact=this.CB.get(0);
        if(existsContact(name)){
            ListIterator<Contact> iterator = this.CB.listIterator();
            while(iterator.hasNext()){
                Contact localContact=iterator.next();
                if(localContact.Name.equals(name)) {
                    matchContact= localContact;
                    return matchContact;
                }
            }
            return matchContact;

        }
        else{

            return matchContact;
        }
    };

    public Contact getByNumber(String phoneNumber){

        Contact matchContact=this.CB.get(0);
        ListIterator<Contact> iterator = this.CB.listIterator();
        while(iterator.hasNext()){
            Contact localContact=iterator.next();
            if(localContact.PhoneNumber.equals(phoneNumber)) {
                matchContact= localContact;
                return matchContact;
            }

        }
        matchContact.PhoneNumber=matchContact.Name;
        return matchContact;
    };


    private boolean existsContact(String name){
        boolean test=false;
        ListIterator<Contact> iterator = this.CB.listIterator();
        while(iterator.hasNext()){
            Contact localContact=iterator.next();
            if(localContact.Name.equals(name)) {
                test=true;
                return test;
            }

        }
        return test;

    };

    public void displayContact(Contact contact){
        System.out.println("-----------------------------");
        System.out.println(contact.getName());
        System.out.println(contact.getPhoneNumber());
        System.out.println(contact.getEmail());
        System.out.println(contact.getAddress());
        System.out.println(contact.getCompany());
        System.out.println(contact.getCountry());
        System.out.println("-----------------------------");
    };

    public void displayBook(){

        ListIterator<Contact> iterator = this.CB.listIterator();
        while(iterator.hasNext()){
            Contact localContact=iterator.next();
            if(!localContact.Name.equals("The contact does not exist")){
                displayContact(localContact);
            }
        }
    };
}
