/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.kelompok6.dao;

import id.ac.unikom.prolan6.kelompok6.entity.Pegawai;
import java.util.ArrayList;

/**
 *
 * @author Saeful Rahman
 */
public interface PegawaiDAO {

    ArrayList<Pegawai> getPegawai();

    ArrayList<Pegawai> getPegawai(String nama);
    
    Pegawai login(String username, String password, String hakAkses);

    boolean tambahPegawai(Pegawai pegawai);

    boolean hapusPegawai(String nip);

    boolean ubahPegawai(Pegawai pegawai);
}
