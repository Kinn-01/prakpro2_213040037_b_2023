/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan.pkg07;

// Import semua class dari javax.swing.table
import javax.swing.table.*;
// Import class ArrayList dari java.util
import java.util.ArrayList;
// Import class List dari java.util
import java.util.List;

/**
 *
 * @author Gilman Arief
 */

// Membuat Class MyTableModel yang mewarisi Class AbstractTableModel
public class MyTableModel extends AbstractTableModel {
    
    // Membuat Array dengan nama columNames bertipe String untuk menyimpan nama-nama kolom
    private String[] columnNames = { "Nama", "Nomor HP", "Jenis Kelamin", "Alamat" };
    
    // Membuat ArrayList dengan nama data yang berisi ArrayList dengan tipe String untuk menyimpan data dari input
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
    // Function untuk menambahkan jumlah kolom
    public int getColumnCount() {
        // Kembalikan panjang/ukuran dari array columnNames
        return columnNames.length;
    }
    
    //Function untuk menambahkan Jumlah Baris
    public int getRowCount() {
        // Kembalikan jumlah data yang diterima/panjang dari ArrayList data
        return data.size();
    }
     
    //
    public int getColCount(int col) {
        // Kembalikan jumlah data yang diterima/panjang dari ArrayList data
        return data.get(col).size();
    }
    
    //Function untuk mengambil nama dari kolom yang dipilih dari parameter
    public String getColumnName(int col) {
        // Kembalikan elemen columnNames dengan index col
        return columnNames[col];
    }
    
    //Function untuk mengambil nilai dari baris dan kolom tertentu
    public Object getValueAt(int row, int col) {
        // Menyimpan elemen dari ArrayList data dari baris yang dipilih ke List rowItem
        List<String> rowItem = data.get(row);
        // Kembalikan elemen rowItem dari index col
        return rowItem.get(col);
    }
    
    // Function untuk mengatur apakah cell bisa diedit atau tidak
    public boolean isCellEditable(int row, int col) {
        // Kembalikan nilai false
        return row >= 0 && col >= 0;
    }
     
    // Function untuk mengubah nilai drai baris dan kolom tertentu
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Menyimpan elemen dari ArrayList data dari baris yang dipilih ke List rowItem
        List<String> rowItem = data.get(rowIndex);
        // Mengubah nilai dari elemen rowItem dengan index columnIndex dengan nilai
        // aValue
        rowItem.set(columnIndex, (String) aValue);
        // Memanggil fungsi fireTableCellUpdated untuk mengubah nilai dari baris dan
        // kolom
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    // Function untuk menghapus nilai dri baris tertentu
    public void remove(int row) {
        // Menghapus elemen dari ArrayList data dengan index row
        data.remove(row);
        // Memanggil fungsi fireTableRowsDeleted untuk menghapus nilai dari baris dan
        // kolom
        fireTableRowsDeleted(row, row);
    }
    
    //Function untuk mengatasi error saat menghapus baris
    void removeRow(int selectedRow) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // Method untuk menambah nilai ke table
    public void add(ArrayList<String> value) {
        // Menambahkan input user ke ArrayList data
        data.add(value);
        // Menambahkan elemen-elemen ArrayList data ke table
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
    
}
