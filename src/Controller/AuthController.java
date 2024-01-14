/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Config.Koneksi;
import Model.Auth;
import View.Login;
import View.MainApp;
import View.register;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class AuthController implements Auth {
        Connection konek;
        Statement st;
        ResultSet rs;
        String query;
        Koneksi con;


    @Override
    public void LoginAuth(String username, String password) {
        con = new Koneksi();
        konek = con.getConnection();
        try{
           query = "SELECT * FROM user WHERE username = '"+username +"' AND password ='"+password+"'";
           st = konek.createStatement();
           rs = st.executeQuery(query);
           if(rs.next()){
               if(username.equals(rs.getString("username"))&& password.equals(rs.getString("password"))){
                   MainApp r = new MainApp();
                   r.setVisible(true);
                   JOptionPane.showMessageDialog(null,"selamat datang '"+username+"' !");
                    
                   
//                   Login l = new Login();
//                   l.setVisible(false);
               }
               }else{
                   JOptionPane.showMessageDialog(null, "username atau password salah !");
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void Register(String email, String username, String password) {
        con = new Koneksi();
        konek = con.getConnection();
        try{
            st = konek.createStatement();
            query = "INSERT INTO user VALUES ('"+email+"','"+username+"','"+password+"')";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Registrasi Berhasil !");
            Login login = new Login();
            login.setVisible(true);
            register reg = new register();
            reg.dispose();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Registrasi Gagal ! \n"+e);
        }
    }
}
