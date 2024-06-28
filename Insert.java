
package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Insert {

    static String url = "jdbc:derby://localhost:1527/sample";
    static String uid = "app";
    static String pwd = "app";
    static Connection con;
    static PreparedStatement ps;
   
    static int id;
    static String fname;
    static String lname;
    static long mobinum;
    static String query;
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        int n=0;
        Scanner scn=new Scanner(System.in);
        try{
            System.out.println("Connecting to Database..");
            con=DriverManager.getConnection(url, uid, pwd);
            System.out.println("Connected");
            
            System.out.println("Enter id,fname,lname, mobinum: ");
            id=scn.nextInt();
            fname=scn.next();
            lname=scn.next();
            mobinum=scn.nextLong();
            
            query="insert into mytable values(?,?,?,?)";
            ps=con.prepareStatement(query);
            
            ps.setInt(1,id);
            ps.setString(2,fname);
            ps.setString(3,lname);
            ps.setLong(4,mobinum);
            
            n=ps.executeUpdate();
            if(n!=0)
                System.out.println("! RECORD INSERTED");
            else
                System.out.println("Unable to insert");
            con.close();
        }
        catch(SQLException e){
            System.out.println("SQLException " + e);
        }
    }
    
}
