/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Select {

    static String url="jdbc:derby://localhost:1527/sample";
    static String uid="app";
    static String pwd="app";
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    
    static int id;
    static long mobinum;
    static String fname;
    static String lname;
    static String query;
    
    public static void main(String[] args) {
        // TODO code application logic here
        int n=0;
        Scanner scn=new Scanner(System.in);
        try{
            System.out.println("Connecting to Database...");
            con=DriverManager.getConnection(url, uid, pwd);
            
            System.out.println("Connected");;
            
            
            query="select * from mytable";
            ps=con.prepareStatement(query);
            
            rs=ps.executeQuery();
            
            while(rs.next())
                System.out.println("id: "+rs.getInt("id")+"     fname: "+rs.getString("fname")+"    lname: "+rs.getString("lname")+"    Mobile Number : "+rs.getLong("mobinum"));
            con.close();
        }
        catch(SQLException e){
            System.out.println("SQLException : "+e);
        }
    }
    
}
