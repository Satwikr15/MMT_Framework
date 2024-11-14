package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
         //Object created to make access of non-static method in static method
        Operations operations=new Operations();
      System.out.println(operations.read("Emp_Details","Emp_name","Satwik"));

      operations.deleterow("Emp_Details","Rahul");

      operations.aboutvalue("Emp_Details","Emp_name","Satwik","Emp_id");

    }

}