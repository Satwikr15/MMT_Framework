package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operations {

    public boolean read(String fileName,String columnName, String inputValue){
        String File=fileName+".csv";
        String line;
        boolean found = false;
        try(BufferedReader reader=new BufferedReader(new FileReader(File))){
            String headerLine= reader.readLine();
            String[] header=headerLine.split(",");

            Map<String,Integer> columnMap=new HashMap<>();
            for(int i=0;i< header.length;i++){
                columnMap.put(header[i].trim().toLowerCase(),i);
            }
            int columnindex= columnMap.get(columnName.toLowerCase());

            while((line= reader.readLine())!=null){
                String[] row=line.split(",");
                //System.out.println(row[0]);  // writtens all name column
                if(row[columnindex].equalsIgnoreCase(inputValue)){
                    //System.out.println("found your name: "+ inputValue+" in column : "+ columnName);
                    found=true;
                    break;
                }
            }
            if(!found)
                System.out.println("not found name in "+columnName+ " column");
        }catch (Exception E){
            E.printStackTrace();
        }
        return found;

    }
    public boolean read(String fileName,String columnName, String inputValue,String Targetcolumn){

        String File = fileName+".csv"; //path of file
        BufferedReader reader=null;
        String line="";
        boolean found = false;
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
            int targetcolumnIndex=columnMap.getOrDefault(Targetcolumn.toLowerCase(),-1);
            // Search for the input value in the selected column

            while((line= reader.readLine())!=null){
                String[] row=line.split(",");
                //System.out.println(row[0]);  // writtens all name column
                if(row[columnIndex].equalsIgnoreCase(inputValue)){
                    System.out.println("found your name: "+ inputValue+" in column : "+ columnName);
                    System.out.println(row[targetcolumnIndex]); // to print details of that person
                    found=true;
                    break;
                }
            }
            if(!found)
                System.out.println("not found name in "+columnName+ " column");
        }catch (Exception E){
            E.printStackTrace();
        }
        return found;
    }
    public void deleterow(String filename,String emp_name){
    String fileName = filename+".csv"; // path of required file
    List<String> rows = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String headerLine = reader.readLine();
        rows.add(headerLine); // Save the header

        String[] header = headerLine.split(","); //separate columns
        Map<String, Integer> columnMap = new HashMap<>();
        for (int i = 0; i < header.length; i++) {
            columnMap.put(header[i].trim().toLowerCase(), i);
        }

        // Identify the column index for emp_name
        int empNameIndex = columnMap.getOrDefault("emp_name", -1);
        if (empNameIndex == -1) {
            System.out.println("Column 'emp_name' not found in the file.");
        }

        // Read each row and keep only those that don't match the emp_name to be deleted
        String line;
        boolean deleted = false;
        while ((line = reader.readLine()) != null) {
            String[] row = line.split(",");
            if (row[empNameIndex].equalsIgnoreCase(emp_name)) {
                deleted = true;
                continue; // Skip the row that matches emp_name
            }
            rows.add(line); // Add other rows to list
        }

        if (!deleted) {
            System.out.println("Employee name '" + emp_name + "' not found.");
        }

        // Rewrite the file with remaining rows
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String row : rows) {
                writer.write(row);
                writer.newLine();
            }
            System.out.println("Row with employee name '" + emp_name + "' deleted.");
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public void aboutvalue(String filename,String columnname,String name,String Targetcolumn){
    String fileName = filename+".csv"; // path of required file
    List<String> rows = new ArrayList<>();
    try(BufferedReader reader=new BufferedReader(new FileReader(fileName))){
        String headerLine = reader.readLine();
        rows.add(headerLine);

        String[] header = headerLine.split(","); //separate columns
        Map<String, Integer> columnMap = new HashMap<>();
        for (int i = 0; i < header.length; i++) {
            columnMap.put(header[i].trim().toLowerCase(), i);
        }
        System.out.println();
        int empNameIndex = columnMap.getOrDefault(columnname.toLowerCase(), -1);
        int targetcolumnIndex=columnMap.getOrDefault(Targetcolumn.toLowerCase(),-1);
        if (empNameIndex == -1 || targetcolumnIndex == -1) {
            System.out.println("Required columns not found in the file.");
            return;
        }
        String line;
        Boolean get=false;
        while((line=reader.readLine())!=null){
            String[] row = line.split(",");
            if (row[empNameIndex].equalsIgnoreCase(name)) {
                System.out.println(row[targetcolumnIndex]);
                get=true;
                break; // if found it , breaks the loop
            }
        }
        if(!get){
            System.out.println("not found in the file");
        }

    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

}