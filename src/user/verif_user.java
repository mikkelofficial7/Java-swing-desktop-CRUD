package user;

import user.home_user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mikkel
 */
public class verif_user {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private String status;
    public verif_user()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/project_java","root","12345678");
            st = con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e);
        }
    }
    public void getDataUser(String user, String password)
    {
        try
        {
            String query = "SELECT * FROM user";
            rs = st.executeQuery(query);
            while(rs.next())
            {
                String uname = rs.getString("username");
                String pass = rs.getString("password");
                if(uname.equals(user) || pass.equals(password))
                {
                    status = "true";
                    JOptionPane.showMessageDialog(null, "Login Successful");  
                }
                else
                {
                    status = "Invalid username/password";
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public String validasi()
    {
        return status;
    }
}
    
