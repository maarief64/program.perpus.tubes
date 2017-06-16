/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.kelompok6.tabelmodel;

import id.ac.unikom.prolan6.kelompok6.entity.Peminjaman;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iqram
 */
public class RiwayatTM extends AbstractTableModel{
    private ArrayList<Peminjaman> arrayPeminjaman;

    public void setArrayPeminjaman(ArrayList<Peminjaman> arrayPeminjaman) {
        this.arrayPeminjaman = arrayPeminjaman;
    }

    @Override
    public int getRowCount() {
        return arrayPeminjaman.size();

    }

    @Override
    public int getColumnCount() {
        return 7;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        switch (columnIndex) {
            case 0:
                return arrayPeminjaman.get(rowIndex).getNama();
            case 1:
                return arrayPeminjaman.get(rowIndex).getIdPinjam();
            case 2:
                String tglPinjam = formatter.format(arrayPeminjaman.get(rowIndex).getTglPinjam());
                return tglPinjam;
            case 3:
                Date dateKembali = arrayPeminjaman.get(rowIndex).getTglKembali();
                String tglKembali = null;
                if (dateKembali != null) {
                    tglKembali = formatter.format(arrayPeminjaman.get(rowIndex).getTglKembali());
                }
                return tglKembali;
            case 4:
                return arrayPeminjaman.get(rowIndex).getJudul();
            case 5:
                return "Rp. " + String.valueOf(arrayPeminjaman.get(rowIndex).getDenda());
            case 6:
                return arrayPeminjaman.get(rowIndex).getNama();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nama Operator";
            case 1:
                return "Id Pinjam";
            case 2:
                return "Tanggal Pinjam";
            case 3:
                return "Tanggal Kembali";
            case 4:
                return "Judul";
            case 5:
                return "Denda";
            case 6:
                return "Nama Anggota";
        }
        return null;
    }
}
