/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.kelompok6.tabelmodel;

import id.ac.unikom.prolan6.kelompok6.entity.Buku;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iqram
 */
public class BukuTM extends AbstractTableModel {

    private ArrayList<Buku> arrayBuku;

    public void setArrayBuku(ArrayList<Buku> arrayBuku) {
        this.arrayBuku = arrayBuku;
    }

    @Override
    public int getRowCount() {
        return arrayBuku.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayBuku.get(rowIndex).getKodeBuku();
            case 1:
                return arrayBuku.get(rowIndex).getJudul();
            case 2:
                return arrayBuku.get(rowIndex).getPenerbit();
            case 3:
                return arrayBuku.get(rowIndex).getPengarang();
            case 4:
                return arrayBuku.get(rowIndex).getStok();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Buku";
            case 1:
                return "Judul";
            case 2:
                return "Penerbit";
            case 3:
                return "Pengarang";
            case 4:
                return "Stok";
        }
        return null;
    }

}
