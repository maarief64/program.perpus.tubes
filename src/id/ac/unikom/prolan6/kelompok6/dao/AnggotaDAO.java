/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.kelompok6.dao;

import id.ac.unikom.prolan6.kelompok6.entity.Anggota;
import java.util.ArrayList;

/**
 *
 * @author Iqram
 */
public interface AnggotaDAO {
    ArrayList<Anggota> getAnggota();
    
    ArrayList<Anggota> getAnggota(String nama);
    
    boolean tambahAnggota(Anggota anggota);

    boolean hapusAnggota(String nim);

    boolean ubahAnggota(Anggota anggota);
}
