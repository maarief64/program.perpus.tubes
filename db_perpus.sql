-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2017 at 06:22 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_perpus`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_anggota`
--

CREATE TABLE IF NOT EXISTS `tb_anggota` (
  `nim` varchar(8) NOT NULL,
  `nama` varchar(60) DEFAULT NULL,
  `jenis_kelamin` varchar(10) DEFAULT NULL,
  `jurusan` varchar(30) DEFAULT NULL,
  `no_hp` varchar(12) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_anggota`
--

INSERT INTO `tb_anggota` (`nim`, `nama`, `jenis_kelamin`, `jurusan`, `no_hp`) VALUES
('10114455', 'Saeful Rahman', 'Laki-laki', 'Teknik Informatika', '085603168547'),
('10114458', 'Achmad maarief', 'Laki-laki', 'Teknik Informatika', '085723933112'),
('10114475', 'Eka Sugih Nurjaman', 'Laki-laki', 'Teknik Informatika', '085645890878'),
('10114497', 'Iqram Anwar', 'Laki-laki', 'Teknik Informatika', '085604567900'),
('10114451', 'Agris Grisnando', 'Laki-laki', 'Teknik Informatika', '089899900099'),
('10116783', 'Ujang Sutisna', 'Laki-laki', 'Teknik Informatika', '089786900676');

-- --------------------------------------------------------

--
-- Table structure for table `tb_buku`
--

CREATE TABLE IF NOT EXISTS `tb_buku` (
  `kode_buku` char(3) NOT NULL,
  `judul` varchar(60) DEFAULT NULL,
  `penerbit` varchar(30) DEFAULT NULL,
  `pengarang` varchar(60) NOT NULL,
  `stok` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_buku`
--

INSERT INTO `tb_buku` (`kode_buku`, `judul`, `penerbit`, `pengarang`, `stok`) VALUES
('A01', 'Algoritma dan Pemrogramman', 'Informatika', 'Rinaldi Muni', 58),
('A02', 'Aplikasi IT I', 'Informatika', 'Taryana', 41),
('A03', 'Aplikasi IT II', 'Informatika', 'Taryana', 3),
('S01', 'Struktur Data', 'Informatika', 'Rinaldi Muni', 10),
('B02', 'Bahasa Indonesia II', 'Gramedia', 'Ir. Umina Tia', 7);

-- --------------------------------------------------------

--
-- Table structure for table `tb_pegawai`
--

CREATE TABLE IF NOT EXISTS `tb_pegawai` (
  `nip` varchar(8) NOT NULL,
  `nama` varchar(60) DEFAULT NULL,
  `jenis_kelamin` varchar(10) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `no_hp` varchar(12) DEFAULT NULL,
  `username` varchar(10) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `hak_akses` varchar(8) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pegawai`
--

INSERT INTO `tb_pegawai` (`nip`, `nama`, `jenis_kelamin`, `alamat`, `no_hp`, `username`, `pass`, `hak_akses`) VALUES
('10115567', 'Agung ', 'Laki-laki', 'Coblong, Bandung', '08256789900', 'admin', '123', 'Admin'),
('10118990', 'Siti Nurlela', 'Laki-laki', 'Ujungberung, Bandung', '086390576789', 'operator', '123', 'Operator'),
('1011446', 'Eka Sugih Nurjaman', 'Laki-laki', 'malang	', '089232323900', 'eka', 'eka', 'Admin'),
('10114455', 'Saeful Rahman', 'Perempuan', 'Garut', '085603168547', 'eful', 'eful', 'Operator'),
('10114499', 'Iqram Anwar', 'Laki-laki', 'Garut', '085603168547', 'iqram', 'iqram', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `tb_peminjaman`
--

CREATE TABLE IF NOT EXISTS `tb_peminjaman` (
`id_pinjam` int(11) NOT NULL,
  `tgl_pinjam` date DEFAULT NULL,
  `tgl_kembali` date DEFAULT NULL,
  `kode_buku` char(3) DEFAULT NULL,
  `nim` varchar(8) DEFAULT NULL,
  `nip` varchar(8) DEFAULT NULL,
  `denda` float DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `tb_peminjaman`
--

INSERT INTO `tb_peminjaman` (`id_pinjam`, `tgl_pinjam`, `tgl_kembali`, `kode_buku`, `nim`, `nip`, `denda`) VALUES
(4, '2016-07-21', '2016-07-21', 'S01', '10114497', '10114499', 0),
(5, '2016-07-21', '2016-07-31', 'S01', '10114455', '10114499', 3000),
(6, '2016-07-01', '2016-07-02', 'B02', '10114475', '10114499', 0),
(7, '2016-07-01', '2016-10-13', 'B02', '10114455', '10114499', 97000),
(8, '2016-08-10', '2016-08-17', 'A02', '10114458', '10115567', 0),
(9, '2016-10-04', '2016-10-13', 'A02', '10114455', '10114499', 2000),
(16, '2017-06-01', '2017-06-10', 'A01', '10114458', '10118990', 2000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_anggota`
--
ALTER TABLE `tb_anggota`
 ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `tb_buku`
--
ALTER TABLE `tb_buku`
 ADD PRIMARY KEY (`kode_buku`);

--
-- Indexes for table `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
 ADD PRIMARY KEY (`nip`);

--
-- Indexes for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
 ADD PRIMARY KEY (`id_pinjam`), ADD KEY `kode_buku` (`kode_buku`), ADD KEY `nim` (`nim`), ADD KEY `nip` (`nip`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
MODIFY `id_pinjam` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
