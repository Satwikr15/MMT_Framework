package org.example;

public class Main {

    public static void main(String[] args) {
        Operations operations=new Operations();
        System.out.println(operations.read("Emp_Details","emp_name","Satwik"));
        operations.aboutvalue("Emp_Details","emp_name","Satwik","emp_id");
        operations.deleterow("Emp_Details","Rahul");

    }

}