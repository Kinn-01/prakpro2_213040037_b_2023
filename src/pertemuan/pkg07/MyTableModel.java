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
public class MyTableModel extends AbstractTableModel {
    
    private String[] columnNames = { "Nama", "Nomor HP", "Jenis Kelamin", "Alamat" };
    
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
    
    public int getColumnCount() {
        // Kembalikan panjang/ukuran dari array columnNames
        return columnNames.length;
    }
    
    public int getRowCount() {
        // Kembalikan jumlah data yang diterima/panjang dari ArrayList data
        return data.size();
    }
     
    public int getColCount(int col) {
        // Kembalikan jumlah data yang diterima/panjang dari ArrayList data
        return data.get(col).size();
    }
    
    public String getColumnName(int col) {
        // Kembalikan elemen columnNames dengan index col
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) {
        // Menyimpan elemen dari ArrayList data dari baris yang dipilih ke List rowItem
        List<String> rowItem = data.get(row);
        // Kembalikan elemen rowItem dari index col
        return rowItem.get(col);
    }
    
     public boolean isCellEditable(int row, int col) {
        // Kembalikan nilai false
        return row >= 0 && col >= 0;
    }
     
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
    
    public void remove(int row) {
        // Menghapus elemen dari ArrayList data dengan index row
        data.remove(row);
        // Memanggil fungsi fireTableRowsDeleted untuk menghapus nilai dari baris dan
        // kolom
        fireTableRowsDeleted(row, row);
    }
    
    void removeRow(int selectedRow) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void add(ArrayList<String> value) {
        // Menambahkan input user ke ArrayList data
        data.add(value);
        // Menambahkan elemen-elemen ArrayList data ke table
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
    
}
