/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.kelompok6.tabelmodel;

import id.ac.unikom.prolan6.kelompok6.entity.Anggota;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iqram
 */
public class AnggotaTM extends AbstractTableModel {

    private ArrayList<Anggota> arrayAnggota;

    public void setArrayAnggota(ArrayList<Anggota> arrayAnggota) {
        this.arrayAnggota = arrayAnggota;
    }

    @Override
    public int getRowCount() {
        return this.arrayAnggota.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayAnggota.get(rowIndex).getNim();
            case 1:
                return arrayAnggota.get(rowIndex).getNama();
            case 2:
                return arrayAnggota.get(rowIndex).getJenisKelamin();
            case 3:
                return arrayAnggota.get(rowIndex).getJurusan();
            case 4:
                return arrayAnggota.get(rowIndex).getNoHp();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NIM";
            case 1:
                return "Nama";
            case 2:
                return "Jenis Kelamin";
            case 3:
                return "Jurusan";
            case 4:
                return "No Hp";

        }
        return null;

    }

}
