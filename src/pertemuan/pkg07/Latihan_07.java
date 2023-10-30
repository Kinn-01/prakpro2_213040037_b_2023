/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pertemuan.pkg07;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;
/**
 *
 * @author Gilman Arief
 */
public class Latihan_07 extends JFrame {
    
    private dataTable dt = new dataTable();
    
    public Latihan_07() {
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        
        JLabel labelHeader = new JLabel("Form Biodata", JLabel.CENTER);
        
        labelHeader.setBounds(0,20,350,10);
        
        
        JLabel labelNama = new JLabel("Nama : ");
        
        labelNama.setBounds(15,40,350,10);
        
        JTextField textFieldNama = new JTextField();
        
        textFieldNama.setBounds(15,60,350,30);
        
        
        JLabel labelHP = new JLabel("Nomor Hp : ");
        
        labelHP.setBounds(15,100,350,10);
        
        
        JTextField textFieldHP = new JTextField();
        
        textFieldHP.setBounds(15,120,350,30);
        
        
        JLabel labelRadio = new JLabel("Jenis Kelamin : ");
        
        labelRadio.setBounds(15,160,350,10);
        
        
       JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true); 
        
       radioButton1.setBounds(15, 180, 350, 30);

       
       JRadioButton radioButton2 = new JRadioButton("Perempuan");
       
       radioButton2.setBounds(15, 210, 350, 30);
       
       
       ButtonGroup bg = new ButtonGroup();
       
       bg.add(radioButton1);
       
       bg.add(radioButton2);
       
       JLabel labelAlamat = new JLabel("Alamat : ");
       labelAlamat.setBounds(15,240, 350, 30);
       
       JTextArea txtOutput = new JTextArea("");
       
       txtOutput.setBounds(15,270,350,100);
       
       
       JButton button = new JButton("Simpan");
       button.setBounds(15,380,100,40);
       
       JButton buttonUbah = new JButton("Ubah");
       buttonUbah.setBounds(125,380,100,40);
       
       JButton buttonHapus = new JButton("Hapus");
        // Atur ukuran panjang dan lebar serta posisi x dan y
       buttonHapus.setBounds(235, 380, 100, 40);
       
       JButton buttonFile = new JButton("Simpan ke File");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        buttonFile.setBounds(345, 380, 150, 40);
       
        
        JTable table = new JTable();
       
        JScrollPane scrollableTable = new JScrollPane(table);
       
        scrollableTable.setBounds(15,440,500,200);
        
        
        MyTableModel tableModel = new MyTableModel();
        
        table.setModel(tableModel);
        
        
         button.addActionListener(new ActionListener() {
            // Method untuk menerima event
            public void actionPerformed(ActionEvent e) {
                // Variable jenisKelamin untuk menyimpan nilai radio button yang diklik (jenis
                // kelamin)
                String jenisKelamin = "";

                // Jika radioButton1 diklik
                if (radioButton1.isSelected()) {
                    // Maka jenisKelamin akan bernilai Laki-Laki
                    jenisKelamin = radioButton1.getText();
                    // Kembalikan radio button ke kondisi semula
                    radioButton1.setSelected(false);
                }
                // Jika radioButton2 diklik
                if (radioButton2.isSelected()) {
                    // Maka jenisKelamin akan bernilai Perempuan
                    jenisKelamin = radioButton2.getText();
                    // Kembalikan radio button ke kondisi semula
                    radioButton2.setSelected(false);
                }

                // Variable nama untuk menyimpan nilai dari objek textFieldNama (nama)
                String nama = textFieldNama.getText();
                // Variable telepon untuk menyimpan nilai dari objek textFieldTelepon (telepon)
                String telepon = textFieldHP.getText();
                // Variable alamat untuk menyimpan nilai dari objek txtOutput (alamat)
                String alamat = txtOutput.getText();

                // Jika nama, telepon dan alamat bernilai kosong
                if (nama.equalsIgnoreCase("") && telepon.equalsIgnoreCase("") && alamat.equalsIgnoreCase("")) {
                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                    // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(Latihan_07.this, "Nama, telepon dan alamat belum terisi", "Perhatian",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    // Jika nama bernilai kosong
                    if (nama.equalsIgnoreCase("")) {
                        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                        // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                        JOptionPane.showMessageDialog(Latihan_07.this, "Nama belum terisi", "Perhatian",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    // Jika telepon bernilai kosong
                    if (telepon.equalsIgnoreCase("")) {
                        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                        // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                        JOptionPane.showMessageDialog(Latihan_07.this, "Telepon belum terisi", "Perhatian",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    // Jika alamat bernilai kosong
                    if (alamat.equalsIgnoreCase("")) {
                        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                        // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                        JOptionPane.showMessageDialog(Latihan_07.this, "Alamat belum terisi", "Perhatian",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }

                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(Latihan_07.this,
                        "Apakah anda yakin ingin menyimpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                // Jika confirmation berinilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Tambahkan variable nama, telepon, jenisKelamin, dan wna ke objek ArrayList
                    // dan dikirim lagi ke objek tableModel dan dt melalui method add
                    tableModel.add(new ArrayList<>(Arrays.asList(nama, telepon, jenisKelamin, alamat)));
                    dt.setData(new ArrayList<>(Arrays.asList(nama, telepon, jenisKelamin, alamat)));
                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                    // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(Latihan_07.this, "Data tersimpan", "Perhatian",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                // Jika confirmation nilai opsi no
                else {
                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                    // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(Latihan_07.this, "Data tidak tersimpan", "Perhatian",
                            JOptionPane.ERROR_MESSAGE);
                }
                // Kembalikan isi textFieldNama ke kondisi kosong
                textFieldNama.setText("");
                // Kembalikan isi textFieldTelepon ke kondisi kosong
                textFieldHP.setText("");
                // Kembalikan isi textare ke kondisi kosong
                txtOutput.setText("");
            }
        });
         
         
        
         buttonUbah.addActionListener(new ActionListener() {
            // Method untuk menerima event
            public void actionPerformed(ActionEvent e) {
                // Jika table sedang diedit dan user mengklik button ubah
                if (table.isEditing()) {
                    // Hentikan editing pada table
                    table.getCellEditor().stopCellEditing();
                }

                // Variable row untuk menyimpan nilai baris yang dipilih
                int row = table.getSelectedRow();
                // Variable column untuk menyimpan nilai kolom yang dipilih
                int column = table.getSelectedColumn();
                // Variable newValue untuk menyimpan nilai dari table yang diedit
                String newValue = (String) table.getModel().getValueAt(row, column);

                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(Latihan_07.this,
                        "Apakah anda yakin ingin mengubah data?",
                        "Form Biodata",
                        JOptionPane.YES_NO_OPTION);

                // Jika confirmation bernilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Ubah nilai dari tableModel dan dt dengan nilai newValue pada baris dan kolom
                    // yang dipilih
                    tableModel.setValueAt(newValue, row, column);
                    dt.setDataRow(row, column, newValue);
                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                    // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(Latihan_07.this, "Data berhasil diubah", "Perhatian",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Jika batal diubah, kembalikan nilai dari tableModel dan dt ke kondisi semula
                    for (int i = 0; i < dt.getSize(row); i++) {
                        tableModel.setValueAt(dt.getData(row, i),
                                row,
                                i);
                    }
                }
            }
        });
         
         
         buttonHapus.addActionListener(new ActionListener() {
            // Method untuk menerima event
            public void actionPerformed(ActionEvent e) {
                // Variable row untuk menyimpan nilai baris yang dipilih
                int row = table.getSelectedRow();
                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(Latihan_07.this,
                        "Apakah anda yakin ingin menghapus data?",
                        "Form Biodata",
                        JOptionPane.YES_NO_OPTION);

                // Jika confirmation bernilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Hapus baris yang dipilih dari tableModel dan dt
                    tableModel.remove(row);
                    dt.remove(row);

                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                    // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                    JOptionPane.showMessageDialog(Latihan_07.this, "Data berhasil dihapus", "Perhatian",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
         
         
        buttonFile.addActionListener(new ActionListener() {
            // Method untuk menerima event
            public void actionPerformed(ActionEvent e) {
                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(Latihan_07.this,
                        "Apakah anda yakin ingin menyimpan data ke file?",
                        "Form Biodata",
                        JOptionPane.YES_NO_OPTION);

                // Jika confirmation bernilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Instansiasi JFileChooser dengan nama fileChooser
                    JFileChooser fileChooser = new JFileChooser();
                    // Atur title dari fileChooser
                    fileChooser.setDialogTitle("Simpan Data ke File");
                    // Atur filter dari fileChooser
                    fileChooser.setFileFilter(new FileNameExtensionFilter("File Teks", "txt"));
                    // Variable userSelection untuk menyimpan nilai dari fileChooser
                    int userSelection = fileChooser.showSaveDialog(Latihan_07.this);

                    // Jika userSelection bernilai opsi approve
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        try {
                            // Instansiasi FileWriter dengan nama writer
                            FileWriter writer = new FileWriter("data.txt");

                            // Dapatkan data dari baris dt
                            for (int i = 0; i < dt.getSizeAll(); i++) {
                                // Dapatkan data dari kolom dt
                                for (int j = 0; j < dt.getSize(i); j++) {
                                    if (j == 3) {
                                        // Tulis data dari dt ke file, jika j == 3 maka tambahkan baris baru
                                        writer.write(dt.getData(i, j).toString() + "\n");
                                    } else {
                                        // Tulis data dari dt ke file, jika j != 3 maka tambahkan koma
                                        writer.write(dt.getData(i, j).toString() + ",");
                                    }
                                }
                            }

                            // Tutup file
                            writer.close();

                            // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                            // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                            JOptionPane.showMessageDialog(Latihan_07.this, "Data berhasil disimpan ke file",
                                    "Perhatian",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } catch (IOException ex) {
                            // Tampilkan error pada console
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        
        
         this.addWindowListener(new WindowAdapter() {
            // Override method windowClosing dari WindowAdapter
            public void windowClosing(WindowEvent e) {
                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(Latihan_07.this,
                        "Apakah anda yakin ingin keluar aplikasi?\nSemua data yang belum disimpan, tidak akan tersimpan.",
                        "Form Biodata",
                        JOptionPane.YES_NO_OPTION);

                // Jika confirmation bernilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Dapatkan data dari baris tableModel
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        // Dapatkan data dari kolom tableModel
                        for (int j = 0; j < tableModel.getColCount(i); j++) {
                            // Tulis data dari tableModel dari dt
                            tableModel.setValueAt(dt.getData(i, j),
                                    i,
                                    j);
                        }
                    }
                    // Keluar dari aplikasi
                    System.exit(0);
                } else {
                    // Jika batal keluar, kembalikan frame ke kondisi semula
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
         
         
        // Menambahkan objek labelHeader ke frame
        this.add(labelHeader);
        // Menambahkan objek labelNama ke frame
        this.add(labelNama);
        // Menambahkan objek textFieldNama ke frame
        this.add(textFieldNama);
        // Menambahkan objek labelTelepon ke frame
        this.add(labelHP);
        // Menambahkan objek textFieldTelepon ke frame
        this.add(textFieldHP);
        // Menambahkan objek labelRadio ke frame
        this.add(labelRadio);
        // Menambahkan objek radioButton1 ke frame
        this.add(radioButton1);
        // Menambahkan objek radioButton2 ke frame
        this.add(radioButton2);
        // Menambahkan objek checkBox ke frame
        this.add(labelAlamat);
        // Menambahkan objek txtOutput ke frame
        this.add(txtOutput);
        // Menambahkan objek button ke frame
        this.add(button);
        // Menambahkan objek buttonUbah ke frame
        this.add(buttonUbah);
        // Menambahkan objek buttonHapus ke frame
        this.add(buttonHapus);
        // Menambahkan objek buttonFile ke frame
        this.add(buttonFile);
        // Menambahkan objek scrollableTable ke frame
        this.add(scrollableTable);

        // Atur ukuran frame menjadi 400 x 600
        this.setSize(550, 1000);
        // Atur layout frame menjadi null
        this.setLayout(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SwingUtilities.invokeLater(new Runnable() {
            // Override method run dari Runnable
            public void run() {
                // Instansiasi StudiKasus dengan nama h
                Latihan_07 h = new Latihan_07();
                // Tampilkan objek h dengan method setVisible dan parameternya true
                h.setVisible(true);
            }
        });
    }
    
}
