import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in); // creates scanner object

        LinkedList<Control> contact = new LinkedList<>(); // creates linkedlist object

        while (true) { //Menu
            System.out.println("********************************");
            System.out.println("[A]dd");
            System.out.println("[D]elete");
            System.out.println("[E]mail Search");
            System.out.println("[P]rint List");
            System.out.println("[S]earch");
            System.out.println("[Q]uit");
            System.out.println("********************************");

            System.out.println();
            System.out.println("Please pick an option: ");
            String control = scr.nextLine();

            switch (control) { //switch-case to control the methods for the options
                case "A":
                    System.out.println("Please enter name: ");
                    String inputName = scr.nextLine();
                    System.out.println("Please enter email: ");
                    String inputEmail = scr.nextLine();
                    System.out.println("Please enter number: ");
                    String inputNum = scr.nextLine();

                    contact.add(new Control(inputName, inputEmail, inputNum)); // adds new object to a node on the linkedlist
                    System.out.println("Contact added successfully!");
                    System.out.println();
                    break;

                case "D": 
                    System.out.println("Please enter name: ");
                    String rmvName = scr.nextLine();

                    boolean rmv = contact.removeIf(c -> c.getName().equalsIgnoreCase(rmvName)); // set value of rmv as the action of removing the name the node from the linked list

                    if (rmv) { // checks if the rmv condition is met
                        System.out.println("Contact removed successfully");
                    } else {
                        System.out.println("Contact doesn't exist");
                        break;
                    }
                    break;

                case "E":
                    System.out.println("Enter Email: ");
                    String email = scr.nextLine();

                    boolean foundEmail = false; // default value for foundEmail

                    for (Control c : contact) {
                        if (c.getEmail().equalsIgnoreCase(email)) { // checks if the email is equal to the one listed
                            System.out.println("Email found: ");
                            System.out.println();
                            System.out.println("Name: " + c.getName());
                            System.out.println("Email: " + c.getEmail());
                            System.out.println("Contact: " + c.getPhoneNum());
                            foundEmail = true; // foundEmail becomes true when the email is found
                            System.out.println();
                            break;
                        }
                    }
                    if(!foundEmail){
                            System.out.println("Email doesn't exist!"); // returns this when the email is not found
                        }
                        System.out.println();
                        break;

                case "P":
                    if(contact.isEmpty()){ // checks if contact is empty
                        System.out.println("Your contact list is empty!");
                        System.out.println();
                    }
                    else{
                        System.out.println("Name / Email / Phone Number");
                        System.out.println();
                        for(Control c : contact){
                            System.out.println(c.getName() + "/" + c.getEmail() + "/" + c.getPhoneNum());
                        }
                    }
                    System.out.println();
                    break;

                case "S":
                    System.out.println("Enter Name: ");
                    String name = scr.nextLine();

                    boolean foundName = false; // default value for foundName

                    for(Control c : contact) {
                        if (c.getName().equalsIgnoreCase(name)) {
                            System.out.println("Name Found");
                            System.out.println();
                            System.out.println("Name: " + c.getName());
                            System.out.println("Contact: " + c.getPhoneNum());
                            foundName = true; // foundName becomes true once name is found
                            System.out.println();
                            break;
                        }
                    }
                    if(!foundName){
                        System.out.println("Name doesn't exist!"); // if found name remains false, it will print this
                        }
                        System.out.println();
                        break;

                case "Q":
                    System.out.println("Exiting...");
                    scr.close(); // closes the scanner
                    return; // closes the program

                default: // the case when the input is invalid
                    System.out.println("Invalid input, must be uppercase, try again.");
                    System.out.println();
                }
            }
        }
    }
