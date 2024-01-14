/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Koneksi {
    Connection conn;
    public Koneksi(){
        String db = "jdbc:mysql://localhost/inventaris_java";
        String username = "root";
        String password = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db, username, password);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Koneksi Gagal !"+e);
        }
    }
    public Connection getConnection(){
        return conn;
    }
    public static void main(String[] aksi){
        Koneksi kon = new Koneksi();
    }
}
