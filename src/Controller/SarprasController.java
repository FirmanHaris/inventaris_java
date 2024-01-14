/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Config.Koneksi;
import Model.Sarpras;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class SarprasController implements Sarpras{
    Connection konek;
        Statement st;
        ResultSet rs;
        String query;
        Koneksi con;
        
        
        
    @Override
    public void Simpan(String kode, String nama, int jumlah, Object kondisi, Object jenis) {
        con = new Koneksi();
        konek = con.getConnection();
        try{
            st = konek.createStatement();
            query = "INSERT INTO sarana VALUES('"+kode+"','"+nama+"',"+jumlah+",'"+kondisi+"','"+jenis+"')";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan !");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan ! \n"+e);

        }
    }

    @Override
    public void Edit(String kode, String nama, int jumlah, Object kondisis, Object jenis) {
        con = new Koneksi();
        konek = con.getConnection();
        try{
            st = konek.createStatement();
            query = "UPDATE sarana SET kd_srp = '"+kode+"',"
                    + " nama_srp = '"+nama+"', "
                    + "jumlah = "+jumlah+","
                    + "kondisi = '"+kondisis+"',"
                    + "jenis = '"+jenis+"' WHERE kd_srp = '"+kode+"'";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, " Data berhasil edit");
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);

        }
    }

    @Override
    public void Hapus(String kode) {
        con = new Koneksi();
        konek = con.getConnection();
        try{
            st=konek.createStatement();
            query = "DELETE FROM sarana WHERE kd_srp= '"+kode+"'";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus !");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @Override
    public void GetAll(DefaultTableModel model) {
        con = new Koneksi();
        konek = con.getConnection();
        query = "SELECT * FROM sarana";
        try{
            st = konek.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                String[] data ={
                    rs.getString("kd_srp"),
                    rs.getString("nama_srp"),
                    rs.getString("jumlah"),
                    rs.getString("kondisi"),
                    rs.getString("jenis")  
                };
                model.addRow(data);
            }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        }
    }
    
}
