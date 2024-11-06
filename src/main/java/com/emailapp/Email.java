package com.emailapp;

import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com" ;

    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

        this.department = setDepartment();

        this.password = randomPassword (defaultPasswordLength);

        email = firstname.toLowerCase() + " " + lastname.toLowerCase() + "@" + department + "." + companySuffix;
    }

    private String setDepartment() {
        System.out.println("New worker: " + firstname + ". Department Codes:\n1 for Sales\n2 for Development\n3forAccounting\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "development";
        } else if (depChoice == 3) {
            return "accounting";
        } else {
            return "";
        }
    }

    private String randomPassword(int length) {
    String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%^&*()-_=+{};:'";
    char[] password = new char [length];
    for (int i=0; i<length; i++) {
        int rand = (int) (Math.random() * passwordSet.length());
        password[i] = passwordSet.charAt(rand);

    }
    return new String(password);
    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public int getMailboxCapacity() { return mailboxCapacity;}
    public String getAlternateEmail() { return alternateEmail;}
    public String getPassword() { return password; }

    public String showInfo() {
        return "DISPLAY NAME: " + firstname + " " + lastname +
                "COMPANY EMAIL: " + email +
                "MAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }


}

