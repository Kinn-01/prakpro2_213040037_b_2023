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

// Membuat Class dataTable untuk menyimpan data dari input
public class dataTable {
    // Membuat ArrayList diberi nama data yang berisi sebuah ArrayList dengan tipe String
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
    // Sebuah Function untuk menambah data ke dalam ArrayList
    public void setData(ArrayList<String> data) {
        // Menambahkan data ke ArrayList data
        this.data.add(data);
    }
    
    // Function untuk menghapus data dari ArrayList
    public void remove(int row) {
        // Menghapus data dari ArrayList data
        this.data.remove(row);
    }
    
    //Function untuk mengambil data dari ArrayList
    public String getData(int row, int col) {
        // Mengembalikan data dari ArrayList data
        return data.get(row).get(col);
    }
    
    //Function untuk mengambil data dalam 1 baris dari ArrayList
    public ArrayList<String> getDataRow(int row) {
        // Mengembalikan data dalam 1 baris dari ArrayList data
        return data.get(row);
    }
    
    //Function untuk mengubah data dalam satu baris dalam ArrayList
    public void setDataRow(int row, int col, String value) {
        // Mengubah data dalam 1 baris dari ArrayList data
        data.get(row).set(col, value);
    }
    
    //Function untuk mengambil jumlah kolom dari ArrayList
     public int getSize(int row) {
        // Mengembalikan jumlah kolom dari ArrayList data
        return data.get(row).size();
    }
     
    //Function untuk mendapatkan Jumlah Baris dari ArrayList
    public int getSizeAll() {
        // Mengembalikan jumlah baris dari ArrayList data
        return data.size();
    }

    
}
