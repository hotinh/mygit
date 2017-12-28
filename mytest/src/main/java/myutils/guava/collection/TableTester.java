package myutils.guava.collection;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TableTester {

    public static void main(String[] args) {
      //Table<R,C,V> == Map<R,Map<C,V>>
        /*
        *  Company: IBM, Microsoft, TCS
        *  IBM        -> {101:Mahesh, 102:Ramesh, 103:Suresh}
        *  Microsoft  -> {101:Sohan, 102:Mohan, 103:Rohan } 
        *  TCS        -> {101:Ram, 102: Shyam, 103: Sunil } 
        * 
        * */
        //create a table
        Table<String, String, String> employeeTable = HashBasedTable.create();

        //initialize the table with employee details
        employeeTable.put("IBM", "101","Mahesh");
        employeeTable.put("IBM", "102","Ramesh");
        employeeTable.put("IBM", "103","Suresh");

        employeeTable.put("Microsoft", "111","Sohan");
        employeeTable.put("Microsoft", "112","Mohan");
        employeeTable.put("Microsoft", "113","Rohan");

        employeeTable.put("TCS", "121","Ram");
        employeeTable.put("TCS", "122","Shyam");
        employeeTable.put("TCS", "123","Sunil");

        //get Map corresponding to IBM
        Map<String,String> ibmEmployees =  employeeTable.row("IBM");

        System.out.println("List of IBM Employees");
        ibmEmployees.forEach((k,v) -> {
            System.out.println("Emp Id: " + k + ", Name: " + v);
        });

        //get all the unique keys of the table
        Set<String> employers = employeeTable.rowKeySet();
        System.out.print("Employers: ");
        employers.forEach(e -> {
            System.out.println(e);
        });

        //get a Map corresponding to 102
        Map<String,String> EmployerMap =  employeeTable.column("102");
        EmployerMap.forEach((k,v) -> {
            System.out.println("Employer: " + k + ", Name: " + v);
        });
    }

}
