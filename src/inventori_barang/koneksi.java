/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventori_barang;

/**
 *
 * @author amris
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class koneksi {
    public Connection conn;
    public koneksi(){}

    public Connection openkoneksi() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory?user=root&pass=");
            return conn;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Tidak ada koneksi yang terbuka.");
            return null;
        }
    }
    
    public void closekoneksi() throws SQLException{
        try{
            if(conn != null){
                System.out.print("Tutup Koneksi\n");
            }
        }catch(Exception ex){
        }
    } 
}
