package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
        private String AddressbookName;

        public String getAddressbookName() {
            return AddressbookName;
        }

        public void setAddressbookName(String addressbookName) {
            AddressbookName = addressbookName;
        }

        ArrayList<Contact> contactList = new ArrayList<>();

        public ArrayList<Contact> getContactList() {
            return contactList;
        }

        public void setContactBook(ArrayList<Contact> contactBook) {
            this.contactList = contactBook;
        }

        public void addContact() {
            Scanner sc = new Scanner(System.in);
            Contact contact = new Contact();
            System.out.print("Enter First name :");
            String firstname = sc.next();
            contact.setFirstName(firstname);
            System.out.print("Enter last name :");
            String lastname = sc.next();
            contact.setLastName(lastname);
            System.out.print("Enter Address :");
            String address = sc.next();
            contact.setAddress(address);
            System.out.print("Enter City :");
            String city = sc.next();
            contact.setCity(city);
            System.out.print("Enter State :");
            String state = sc.next();
            contact.setState(state);
            System.out.print("Enter zip code :");
            String zip = sc.next();
            contact.setZip(zip);
            System.out.print("Enter phone number : ");
            String phone = sc.next();
            contact.setPhoneNumber(phone);
            System.out.print("Enter Email :");
            String email = sc.next();
            contact.setEmail(email);
            contactList.add(contact);
            System.out.println("Contact added Successfully!!!");
        }

        public void display() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter name of the contact : ");
            String name = sc.next();
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(contactList.get(i));
            }
        }

        public void Edit() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name of the contact which you want to edit");
            String name = sc.next();
            for (int i = 0; i < contactList.size(); i++) {
                Contact contact = contactList.get(i);
                if (contact.getFirstName().equals(name)) {
                    System.out.println("Contact Found!!");
                    System.out.println("Please update the details");
                    System.out.print("Enter First name :");
                    String firstname = sc.next();
                    contact.setFirstName(firstname);
                    System.out.print("Enter last name :");
                    String lastname = sc.next();
                    contact.setLastName(lastname);
                    System.out.print("Enter Address :");
                    String address = sc.next();
                    contact.setAddress(address);
                    System.out.print("Enter City :");
                    String city = sc.next();
                    contact.setCity(city);
                    System.out.print("Enter State :");
                    String state = sc.next();
                    contact.setState(state);
                    System.out.print("Enter zip code :");
                    String zip = sc.next();
                    contact.setZip(zip);
                    System.out.print("Enter phone number : ");
                    String phone = sc.next();
                    contact.setPhoneNumber(phone);
                    System.out.print("Enter Email :");
                    String email = sc.next();
                    contact.setEmail(email);
                    System.out.println("Contact Edited Successfully");
                } else {
                    System.out.println("Enter valid contact name");
                    Edit();
                }
            }
        }

        public void delete() {
            System.out.println("Enter name of the contact which you want to delete: ");
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            for (int i = 0; i < contactList.size(); i++) {
                Contact contact = contactList.get(i);
                if (contact.getFirstName().equals(name)) {
                    contactList.remove(contact);
                }
            }
            System.out.println("Contact deleted!!!!");
        }


        HashMap<String, AddressBook> hashMap = new HashMap<String, AddressBook>();

        public void AddAddressbook() {
            AddressBook addressBook = new AddressBook();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name of the AddressBook");
            String name = sc.next();
            if (hashMap.containsKey(name)) {
                System.out.println("Enter different name for the AddressBook");
                AddAddressbook();
            } else {
                addressBook.setAddressbookName(name);
                hashMap.put(addressBook.getAddressbookName(), addressBook);
                System.out.println("Address book added!!");
            }
        }

        public void add() {
            if (hashMap.isEmpty()) {
                System.out.println("Your address book is empty first please add new Addressbook");
                AddAddressbook();
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name of the addressbok in which you want to add contact: ");
            String name = sc.next();
            if (hashMap.containsKey(name)) {
                AddressBook temp = hashMap.get(name);
                temp.addContact();
            }
        }

        public void display1() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name of the addressbok in which you want to display contact: ");
            String name = sc.next();
            if (hashMap.containsKey(name)) {
                AddressBook temp = hashMap.get(name);
                temp.display();
            }
        }

        public void delete1() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name of the addressbok in which you want to Delete contact: ");
            String name = sc.next();
            if (hashMap.containsKey(name)) {
                AddressBook temp = hashMap.get(name);
                temp.delete();
            }
        }

        public void Edit1() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name of the addressbok in which you want to Edit contact: ");
            String name = sc.next();
            if (hashMap.containsKey(name)) {
                AddressBook temp = hashMap.get(name);
                temp.Edit();
            }
        }

        public void displayAllAddressbook() {
            System.out.println("Displaying all addressbook");
            if (hashMap.isEmpty()) {
                System.out.println("Addressbook is empty");
            } else {
                System.out.println(hashMap);
            }
        }

        public void searchBycity() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the name of the city which you want to show");
            String cityname = sc.next();
            List<Contact> citylist = new ArrayList<>();
            hashMap.values().stream().forEach(addressBook -> {
                citylist.addAll(addressBook.getContactList().
                        stream().filter(contact -> contact.getCity().equalsIgnoreCase(cityname)).sorted(Comparator.comparing(Contact::getCity)).collect(Collectors.toList()));
            });
            int count = citylist.size();
            System.out.println(count + " Person Found!!! which belongs to " + cityname + " city");
            System.out.println(citylist);
        }

        public void searchByState() {

            System.out.println("Enter the name of the city which you want to show");
            Scanner sc = new Scanner(System.in);

            List<Contact> Statelist = new ArrayList<>();
            String statename = sc.next();

            hashMap.values().stream().forEach(addressBook -> {
                Statelist.addAll(addressBook.getContactList().
                        stream().filter(contact -> contact.getCity().equalsIgnoreCase(statename)).sorted(Comparator.comparing(Contact::getState)).collect(Collectors.toList()));
            });
            int count = Statelist.size();
            System.out.println("Total number of contact person");
            System.out.println(count + " Person Found!!! which belongs to " + statename + " city");
            System.out.println(Statelist);
        }
        public void sort() {
            List<Contact> citylist = new ArrayList<>();
            hashMap.values().stream().forEach(addressBook -> {
                citylist.addAll(addressBook.getContactList().
                        stream().sorted(Comparator.comparing(Contact::getFirstName)).collect(Collectors.toList()));
            });
            System.out.println(citylist);
        }
    public void writeToFile() {
        String path = "C:\\Users\\Teju Reddy\\IdeaProjects\\Day-13\\src\\main\\java\\org\\Address_book.txt";
        StringBuffer addressBookBuffer = new StringBuffer();
        hashMap.values().stream().forEach(contact -> {
            String personDataString = contact.toString().concat("\n");
            addressBookBuffer.append(personDataString);
        });
        try {
            Files.write(Paths.get(path), addressBookBuffer.toString().getBytes());
        }
        catch (IOException e) {
            System.out.println("Catch block");
        }
    }

    public void readFromFile() {
        String path = "C:\\Users\\Teju Reddy\\IdeaProjects\\Day-13\\src\\main\\java\\org\\Address_book.txt";
        System.out.println("Reading from : " + path + "\n");
        try {
            Files.lines(new File(path).toPath()).forEach(employeeDetails -> System.out.println(employeeDetails));
        }
        catch(IOException e){
            System.out.println("Catch block");
        }
    }

    @Override
        public String toString() {
            return "AddressBook{" +
                    "AddressbookName='" + AddressbookName + '\'' +
                    ", contactList=" + contactList +
                    '}';
        }

}
