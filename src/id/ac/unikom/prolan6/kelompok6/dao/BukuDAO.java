/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.kelompok6.dao;

import id.ac.unikom.prolan6.kelompok6.entity.Buku;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Iqram
 */
public interface BukuDAO {

    ArrayList<Buku> getBuku();

    ArrayList<Buku> getBuku(String judul);

    boolean ubahStok(Buku buku);

    boolean tambahBuku(Buku buku);

    boolean hapusBuku(String kodeBuku);

    boolean ubahBuku(Buku buku);
}
