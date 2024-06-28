
package update;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

    static String url="jdbc:derby://localhost:1527/sample";
    static String uid="app";
    static String pwd="app";
    static Connection con;
    static PreparedStatement ps;
    
    static int id;
    static long mobinum;
    static String query;
    
    public static void main(String[] args) {
        // TODO code application logic here
        int n=0;
        Scanner scn=new Scanner(System.in);
        try{
            System.out.println("Connecting to Database...");
            con=DriverManager.getConnection(url, uid, pwd);
            
            System.out.println("Connected");;
            System.out.println("Enter id and mobinum : ");
            id=scn.nextInt();
            mobinum=scn.nextLong();
            
            query="update mytable set mobinum=? where id=?";
            ps=con.prepareStatement(query);
            
            ps.setLong(1,mobinum);
            ps.setInt(2,id);
            
            n=ps.executeUpdate();
            if(n!=0)
                System.out.println("! RECORD UPDATED");
            else
                System.out.println("Unable to update");
          
            con.close();
        }
        catch(SQLException e){
            System.out.println("SQLException : "+e);
        }
        
    }
    
}
