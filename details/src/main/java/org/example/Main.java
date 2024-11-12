package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main obj=new Main(); //Object created to make access of non-static method in static method
        obj.read("Emp_Details","Emp_name","rao"); //Emp_Details or Player_Details , Emp_name , satwik
    }
    public void read(String fileName,String columnName, String inputValue){

        String File = fileName+".csv";
        BufferedReader reader=null;
        String line="";
        try{
            reader=new BufferedReader(new FileReader(File));
            // Read the header to map column names to their indexes
            String headerLine = reader.readLine();
            String[] header = headerLine.split(",");

            // Create a map of column names to their index positions
            Map<String, Integer> columnMap = new HashMap<>();
            for (int i = 0; i < header.length; i++) {
                columnMap.put(header[i].trim().toLowerCase(), i);
            }
            int columnIndex = columnMap.get(columnName.toLowerCase());// assigning columnindex to columnname

            // Search for the input value in the selected column
            boolean found = false;
            while((line= reader.readLine())!=null){
                String[] row=line.split(",");
                //System.out.println(row[0]);  // writtens name of column
                if(row[columnIndex].equalsIgnoreCase(inputValue)){
                    System.out.println("found your name: "+ inputValue+" in column "+ columnName);
                    //System.out.println(row[1]); // to print details of that person
                    found=true;
                    break;
                }
            }
            if(!found)
                System.out.println("not found name in "+columnName+ " column");
        }catch (Exception E){
                E.printStackTrace();
        }

    }
}
