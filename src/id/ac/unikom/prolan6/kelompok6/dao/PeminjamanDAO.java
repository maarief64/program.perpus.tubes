/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.kelompok6.dao;

import id.ac.unikom.prolan6.kelompok6.entity.Peminjaman;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Iqram
 */
public interface PeminjamanDAO {

    // menampilkan data anggota yg sudah
    // meminjam buku

    ArrayList<Peminjaman> getPeminjaman();
    
    ArrayList<Peminjaman> getRiwayat();
    
    //Pencarian berdasarkan nama
    ArrayList<Peminjaman> cariPeminjaman(String keyword);
    
    //Pencarian berdasarkan nama
    ArrayList<Peminjaman> cariPengembalian(String keyword);

    // proses peminjaman
    boolean pinjam(String nim, String kodeBuku, Calendar tglPinjam, String nip);
    
    //proses pengembalian
    boolean kembali(int id_pinjam, Calendar tglKembali, float denda);

}
