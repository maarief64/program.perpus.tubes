/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.kelompok6.daoimpl;

import id.ac.unikom.prolan6.kelompok6.dao.AnggotaDAO;
import id.ac.unikom.prolan6.kelompok6.entity.Anggota;
import id.ac.unikom.prolan6.kelompok6.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iqram
 */
public class AnggotaDAOImpl implements AnggotaDAO {

    private final Connection conn;

    public AnggotaDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Anggota> getAnggota() {
        return getAnggota(null);
    }

    @Override
    public ArrayList<Anggota> getAnggota(String nama) {
        ArrayList<Anggota> arrayAnggota = null;
        PreparedStatement state = null;

        boolean isSearching = nama != null && !nama.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT * FROM tb_anggota WHERE nama LIKE ?";
        } else {
            SELECT = "SELECT * FROM tb_anggota";
        }

        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, "%" + nama + "%");
            }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayAnggota = new ArrayList<>();

                while (result.next()) {
                    Anggota a = new Anggota();
                    a.setNim(result.getString(1));
                    a.setNama(result.getString(2));
                    a.setJenisKelamin(result.getString(3));
                    a.setJurusan(result.getString(4));
                    a.setNoHp(result.getString(5));

                    arrayAnggota.add(a);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnggotaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        return arrayAnggota;

    }

    @Override
    public boolean tambahAnggota(Anggota anggota) {
        String INSERT = "INSERT INTO tb_anggota (nim, nama, jenis_kelamin, jurusan, "
                + "no_hp) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, anggota.getNim());
            state.setString(2, anggota.getNama());
            state.setString(3, anggota.getJenisKelamin());
            state.setString(4, anggota.getJurusan());
            state.setString(5, anggota.getNoHp());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean hapusAnggota(String nim) {
        String DELETE = "DELETE FROM tb_anggota "
                + "WHERE nim = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);
            state.setString(1, nim);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean ubahAnggota(Anggota anggota) {
        String UPDATE = "UPDATE tb_anggota "
                + "SET nama = ?, jenis_kelamin = ?, jurusan = ?,  "
                + "no_hp = ? WHERE "
                + "nim = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(1, anggota.getNama());
            state.setString(2, anggota.getJenisKelamin());
            state.setString(3, anggota.getJurusan());
            state.setString(4, anggota.getNoHp());
            state.setString(5, anggota.getNim());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
