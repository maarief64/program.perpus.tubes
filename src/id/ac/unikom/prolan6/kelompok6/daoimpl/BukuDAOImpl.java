/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.kelompok6.daoimpl;

import id.ac.unikom.prolan6.kelompok6.dao.BukuDAO;
import id.ac.unikom.prolan6.kelompok6.entity.Buku;

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
public class BukuDAOImpl implements BukuDAO {

    private final Connection conn;

    public BukuDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Buku> getBuku() {
        return null;
    }

    @Override
    public ArrayList<Buku> getBuku(String judul) {

        ArrayList<Buku> arrayBuku = null;
        PreparedStatement state = null;

        boolean isSearching = judul != null && !judul.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT * FROM tb_buku WHERE judul LIKE ?";
        } else {
            SELECT = "SELECT * FROM tb_buku";
        }

        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, "%" + judul + "%");
            }

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayBuku = new ArrayList<>();
                while (result.next()) {
                    Buku b = new Buku();
                    b.setKodeBuku(result.getString(1));
                    b.setJudul(result.getString(2));
                    b.setPenerbit(result.getString(3));
                    b.setPengarang(result.getString(4));
                    b.setStok(result.getInt(5));
                    arrayBuku.add(b);

                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(BukuDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BukuDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        return arrayBuku;

    }

    @Override
    public boolean ubahStok(Buku buku) {
        String UpdateStok = "UPDATE tb_buku SET stok = ? WHERE kode_buku = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UpdateStok);
            state.setInt(1, buku.getStok());
            state.setString(2, buku.getKodeBuku());
            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BukuDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean tambahBuku(Buku buku) {
        String INSERT = "INSERT INTO tb_buku (kode_buku, judul, penerbit, pengarang, "
                + "stok) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, buku.getKodeBuku());
            state.setString(2, buku.getJudul());
            state.setString(3, buku.getPenerbit());
            state.setString(4, buku.getPengarang());
            state.setInt(5, buku.getStok());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean hapusBuku(String kodeBuku) {
        String DELETE = "DELETE FROM tb_buku "
                + "WHERE kode_buku = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);
            state.setString(1, kodeBuku);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean ubahBuku(Buku buku) {
        String UPDATE = "UPDATE tb_buku "
                + "SET judul = ?, penerbit = ?, pengarang = ?,  "
                + "stok = ? WHERE "
                + "kode_buku = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(1, buku.getJudul());
            state.setString(2, buku.getPenerbit());
            state.setString(3, buku.getPengarang());
            state.setInt(4, buku.getStok());
            state.setString(5, buku.getKodeBuku());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
