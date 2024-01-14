/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Config.Koneksi;
import Model.Ruangan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class RuanganController implements Ruangan{
    Connection konek;
        Statement st;
        ResultSet rs;
        String query;
        Koneksi con;
    @Override
    public void Simpan(String kode, String nama, int jumlah, Object kondisi) {
        con = new Koneksi();
        konek = con.getConnection();
        try{
            st = konek.createStatement();
            query = "INSERT INTO ruangan VALUES('"+kode+"','"+nama+"',"+jumlah+",'"+kondisi+"')";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan !");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan ! \n"+e);

        }
    }

    @Override
    public void Edit(String kode, String nama, int jumlah, Object kondisi) {
    con = new Koneksi();
        konek = con.getConnection();
        try{
            st = konek.createStatement();
            query = "UPDATE ruangan SET kode_ruangan = '"+kode+"',"
                    + " nama_ruangan = '"+nama+"', "
                    + "jumlah = "+jumlah+","
                    + "kondisi = '"+kondisi+"' WHERE kode_ruangan = '"+kode+"'";
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
            query = "DELETE FROM ruangan WHERE kode_ruangan= '"+kode+"'";
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
        query = "SELECT * FROM ruangan";
        try{
            st = konek.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                String[] data ={
                    rs.getString("kode_ruangan"),
                    rs.getString("nama_ruangan"),
                    rs.getString("jumlah"),
                    rs.getString("kondisi")
                };
                model.addRow(data);
            }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        }
    }
}

   
    

