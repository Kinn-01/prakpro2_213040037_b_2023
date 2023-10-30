/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan.pkg07;

// Import semua ArrayList dari java.util.ArrayList
import java.util.ArrayList;
/**
 *
 * @author Gilman Arief
 */
public class dataTable {
    
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
    
    public void setData(ArrayList<String> data) {
        this.data.add(data);
    }
    
    public void remove(int row) {
        this.data.remove(row);
    }
    
    public String getData(int row, int col) {
        // Mengembalikan data dari ArrayList data
        return data.get(row).get(col);
    }
    
    public ArrayList<String> getDataRow(int row) {
        // Mengembalikan data dalam 1 baris dari ArrayList data
        return data.get(row);
    }
    
    public void setDataRow(int row, int col, String value) {
        // Mengubah data dalam 1 baris dari ArrayList data
        data.get(row).set(col, value);
    }
    
     public int getSize(int row) {
        // Mengembalikan jumlah kolom dari ArrayList data
        return data.get(row).size();
    }
     
    public int getSizeAll() {
        // Mengembalikan jumlah baris dari ArrayList data
        return data.size();
    }

    
}
