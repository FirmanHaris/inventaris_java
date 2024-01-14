/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import javax.swing.table.DefaultTableModel;


public interface Ruangan {
    void Simpan(String kode,String nama, int jumlah, Object kondisi);
    void Edit(String kode,String nama, int jumlah, Object kondisi);
    void Hapus(String kode);
    void GetAll(DefaultTableModel model);
}
