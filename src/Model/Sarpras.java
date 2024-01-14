/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public interface Sarpras {
    void Simpan(String kode,String nama, int jumlah, Object kondisi,Object jenis);
    void Edit(String kode,String nama, int jumlah, Object kondisi,Object jenis);
    void Hapus(String kode);
    void GetAll(DefaultTableModel model);
}
