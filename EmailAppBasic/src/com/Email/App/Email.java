package com.Email.App;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private Integer mailBoxCapacity = 500;
    private Integer defaultPasswordLength = 10;
    private String alternateEmail;
    private String email;
    private String companySuffix = "myEmailApp.com";

    //  Constructor for receiving the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //  Call a method to ask for a department and return it
        this.department = setDepartment();

        //  Call a method to receive a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your random password is: " + this.password);

        //  Generate email from info
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    //  Ask for department
    private String setDepartment() {
        System.out.println("New agent: " + firstName + ", DEPARTMENT CODES\n1 for PR&Marketing\n2 for HR\n3 for Economical\n0 for none\nEnter department code:");
        Scanner scanner = new Scanner(System.in);
        Integer departmentChoice = scanner.nextInt();
        switch (departmentChoice) {
            case 1:
                return "pr";
            case 2:
                return "hr";
            case 3:
                return "eco";
            default:
                return "";
        }
    }

    //  Generate a random password for email
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@$%&_";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //  Set the mailbox capacity
    public void setMailBoxCapacity(Integer mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    //  Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    //  Change password
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getPassword() {
        return password;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }
}
