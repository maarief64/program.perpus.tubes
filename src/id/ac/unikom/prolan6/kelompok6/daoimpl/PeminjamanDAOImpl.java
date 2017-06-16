/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.kelompok6.daoimpl;

import id.ac.unikom.prolan6.kelompok6.dao.PeminjamanDAO;
import id.ac.unikom.prolan6.kelompok6.entity.Peminjaman;
import id.ac.unikom.prolan6.kelompok6.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iqram
 */
public class PeminjamanDAOImpl implements PeminjamanDAO {

    private final Connection conn;

    public PeminjamanDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Peminjaman> getPeminjaman() {

        ArrayList<Peminjaman> arrayPeminjaman = null;
        String SELECT = "SELECT "
                + "tb_peminjaman.id_pinjam, "
                + "tb_peminjaman.tgl_pinjam, "
                + "tb_peminjaman.tgl_kembali, "
                + "tb_buku.judul, "
                + "tb_peminjaman.denda, "
                + "tb_anggota.nama "
                + "FROM tb_peminjaman, tb_buku, tb_anggota "
                + "WHERE tb_peminjaman.kode_buku = tb_buku.kode_buku AND "
                + "tb_peminjaman.nim = tb_anggota.nim"
                + " AND tb_peminjaman.tgl_kembali IS NULL";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPeminjaman = new ArrayList<>();

                while (result.next()) {
                    Peminjaman p = new Peminjaman();
                    p.setIdPinjam(result.getInt(1));
                    p.setTglPinjam(result.getDate(2));
                    p.setTglKembali(result.getDate(3));
                    p.setJudul(result.getString(4));
                    p.setDenda(result.getFloat(5));
                    p.setNama(result.getString(6));

                    arrayPeminjaman.add(p);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PeminjamanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return arrayPeminjaman;
    }

    @Override
    public boolean pinjam(String nim, String kodeBuku, Calendar tglPinjam, String nip) {
        String INSERT = "INSERT INTO tb_peminjaman "
                + "(nim, kode_buku, tgl_pinjam, nip) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, nim);
            state.setString(2, kodeBuku);
            state.setDate(3, new Date(tglPinjam.getTimeInMillis()));
            state.setString(4, nip);

            int result = state.executeUpdate();
            return result > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PeminjamanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return false;
    }

    @Override
    public boolean kembali(int id_pinjam, Calendar tglKembali, float denda) {
        String UPDATE = "UPDATE tb_peminjaman "
                + "SET tgl_kembali = ?, denda = ? "
                + "WHERE id_pinjam = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setDate(1, new Date(tglKembali.getTimeInMillis()));
            state.setFloat(2, denda);
            state.setInt(3, id_pinjam);

            int result = state.executeUpdate();
            return result > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PeminjamanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return false;
    }

    @Override
    public ArrayList<Peminjaman> getRiwayat() {

        ArrayList<Peminjaman> arrayPeminjaman = null;
        String SELECT = "SELECT "
                + "tb_peminjaman.id_pinjam, "
                + "tb_peminjaman.tgl_pinjam, "
                + "tb_peminjaman.tgl_kembali, "
                + "tb_buku.judul, "
                + "tb_peminjaman.denda, "
                + "tb_anggota.nama "
                + "FROM tb_peminjaman, tb_buku, tb_anggota "
                + "WHERE tb_peminjaman.kode_buku = tb_buku.kode_buku AND "
                + "tb_peminjaman.nim = tb_anggota.nim"
                + " AND tb_peminjaman.tgl_kembali IS NOT NULL";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPeminjaman = new ArrayList<>();

                while (result.next()) {
                    Peminjaman p = new Peminjaman();
                    p.setIdPinjam(result.getInt(1));
                    p.setTglPinjam(result.getDate(2));
                    p.setTglKembali(result.getDate(3));
                    p.setJudul(result.getString(4));
                    p.setDenda(result.getFloat(5));
                    p.setNama(result.getString(6));

                    arrayPeminjaman.add(p);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PeminjamanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return arrayPeminjaman;
    }

    @Override
    public ArrayList<Peminjaman> cariPeminjaman(String keyword) {
        ArrayList<Peminjaman> arrayPeminjaman = null;
        PreparedStatement state = null;

        boolean isSearching = keyword != null && !keyword.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT "
                    + "tb_peminjaman.id_pinjam, "
                    + "tb_peminjaman.tgl_pinjam, "
                    + "tb_peminjaman.tgl_kembali, "
                    + "tb_buku.judul, "
                    + "tb_peminjaman.denda, "
                    + "tb_anggota.nama "
                    + "FROM tb_peminjaman, tb_buku, tb_anggota "
                    + "WHERE tb_peminjaman.kode_buku = tb_buku.kode_buku AND "
                    + "tb_peminjaman.nim = tb_anggota.nim AND "
                    + "tb_peminjaman.tgl_kembali IS NULL AND "
                    + "tb_anggota.nama LIKE ?";
        } else {
            SELECT = "SELECT * FROM tb_peminjaman";
        }

        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, "%" + keyword + "%");
            }

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPeminjaman = new ArrayList<>();

                while (result.next()) {
                    Peminjaman p = new Peminjaman();
                    p.setIdPinjam(result.getInt(1));
                    p.setTglPinjam(result.getDate(2));
                    p.setTglKembali(result.getDate(3));
                    p.setJudul(result.getString(4));
                    p.setDenda(result.getFloat(5));
                    p.setNama(result.getString(6));
                    arrayPeminjaman.add(p);
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

        return arrayPeminjaman;
    }

    @Override
    public ArrayList<Peminjaman> cariPengembalian(String keyword) {
        ArrayList<Peminjaman> arrayPeminjaman = null;
        PreparedStatement state = null;

        boolean isSearching = keyword != null && !keyword.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT "
                    + "tb_peminjaman.id_pinjam, "
                    + "tb_peminjaman.tgl_pinjam, "
                    + "tb_peminjaman.tgl_kembali, "
                    + "tb_buku.judul, "
                    + "tb_peminjaman.denda, "
                    + "tb_anggota.nama "
                    + "FROM tb_peminjaman, tb_buku, tb_anggota "
                    + "WHERE tb_peminjaman.kode_buku = tb_buku.kode_buku AND "
                    + "tb_peminjaman.nim = tb_anggota.nim AND "
                    + "tb_peminjaman.tgl_kembali IS NOT NULL AND "
                    + "tb_anggota.nama LIKE ?";
        } else {
            SELECT = "SELECT * FROM tb_peminjaman";
        }

        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, "%" + keyword + "%");
            }

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPeminjaman = new ArrayList<>();

                while (result.next()) {
                    Peminjaman p = new Peminjaman();
                    p.setIdPinjam(result.getInt(1));
                    p.setTglPinjam(result.getDate(2));
                    p.setTglKembali(result.getDate(3));
                    p.setJudul(result.getString(4));
                    p.setDenda(result.getFloat(5));
                    p.setNama(result.getString(6));
                    arrayPeminjaman.add(p);
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

        return arrayPeminjaman;
    }
}
