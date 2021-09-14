package main;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String university;
    private String email;
    private String emailuse;
    private int mailboxCapacity;
    private final int passwordLength=10;
    private String alternateEmail;

    public Email(String firstname, String lastname){
        this.firstname=firstname;
        this.lastname=lastname;
        System.out.println("New email created: "+this.firstname+" "+this.lastname);
        this.password=randomPassword(passwordLength);
        this.emailuse=setEmail();
        email=this.firstname.toLowerCase(Locale.ROOT)+"."+this.lastname.toLowerCase(Locale.ROOT)+"@"+emailuse+".com";
        this.showInformation();
        showMenu();
    }

    private String setEmail(){
        System.out.println("Enter the name of the organization\n");
        Scanner in=new Scanner(System.in);
        String name=in.nextLine();
        return name;
    }
    //Generate a random password
    private String randomPassword(int length){
        String passwordSet="0123456789ABCDEFGHIJKLMNOPQRSTUWXYZ";
        char[] password=new char[length];
        for(int i=0;i<length;i++){
            int rand=(int)(Math.random()* passwordSet.length());
            password[i]=passwordSet.charAt(rand);
        }
        return new String(password);

    }

    //Set the alternate email
    public void setAlternateEmail(String email){
        this.alternateEmail=email;
    }

    //Change the password
    public void changePassword(String password){
        this.password=password;
    }

    //set the mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity){
        this.mailboxCapacity=mailboxCapacity;
    }
    public void showInformation(){
        System.out.println("Your password is: "+ this.password);
        System.out.println("Your email is: "+this.email);
        System.out.println("Your mailbox capacity is: "+this.mailboxCapacity);
        if(this.alternateEmail!=null)
            System.out.println("Your alternate email is: "+this.alternateEmail);
    }

    public void showMenu(){
        int choice;
        do {
            System.out.printf("\nWhat would you like to do? ");
            System.out.println();
            System.out.println("1 - show information\n2 - set alternate email\n3 - change password\n4 - set mailbox capacity\n5 - quit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            if(choice<1 || choice>5){
                System.out.println("Invalid choice, try again");
            }
        }while(choice<1 || choice>5);
            switch (choice) {
                case 1: {
                    showInformation();
                    break;
                }
                case 2: {
                    System.out.println("Enter alternate email\n");
                    Scanner scanner = new Scanner(System.in);
                    String email = scanner.nextLine();
                    setAlternateEmail(email);
                    break;
                }
                case 3: {
                    System.out.println("Enter new password\n");
                    Scanner scanner = new Scanner(System.in);
                    String password = scanner.nextLine();
                    changePassword(password);
                    break;
                }
                case 4: {
                    System.out.println("Enter mailbox capacity\n");
                    Scanner scanner = new Scanner(System.in);
                    int capacity = scanner.nextInt();
                    setMailboxCapacity(capacity);
                    break;
                }
                case 5: {
                    Scanner scanner = new Scanner(System.in);
                    scanner.nextLine();
                    break;
                }
                default: {
                    System.out.println("Incorrect number");
                }
                if(choice!=5)
                    showMenu();
            }

    }


}
