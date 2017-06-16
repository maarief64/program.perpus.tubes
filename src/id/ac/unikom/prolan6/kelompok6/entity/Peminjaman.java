/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.kelompok6.entity;

import java.sql.Date;

/**
 *
 * @author Iqram
 */
public class Peminjaman {

    private int idPinjam;
    private Date tglPinjam;
    private Date tglKembali;
    private String kodeBuku;
    private String nim;
    private String nip;
    private float denda;
    private String judul;
    private String nama;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getIdPinjam() {
        return idPinjam;
    }

    public void setIdPinjam(int idPinjam) {
        this.idPinjam = idPinjam;
    }

    public Date getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(Date tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public Date getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(Date tglKembali) {
        this.tglKembali = tglKembali;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public float getDenda() {
        return denda;
    }

    public void setDenda(float denda) {
        this.denda = denda;
    }

}
