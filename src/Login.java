package login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shubham
 */
public class Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login log = new Login();
        log.createConnection();
    }
    
    
    void createConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjunah", "root","Arjun@9769");
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM USERS");
            while(rs.next()){
                String username = rs.getString("username");
                String pass = rs.getString("pass");
                System.out.println(username);
                
            }
            System.out.println("Database Connection Success");
            //f2 fl = new f2();
            //fl.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
