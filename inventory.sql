-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 19 Jul 2020 pada 16.15
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.3.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tmbarang`
--

CREATE TABLE `tmbarang` (
  `id` int(11) NOT NULL,
  `kode` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `satuan` varchar(20) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tmbarang`
--

INSERT INTO `tmbarang` (`id`, `kode`, `nama`, `id_kategori`, `satuan`, `stok`) VALUES
(22, 'AA', 'Kursi', 14, 'Buah', 200),
(23, 'BB', 'Tisu', 13, 'Buah', 300);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tmkategori`
--

CREATE TABLE `tmkategori` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_rak` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tmkategori`
--

INSERT INTO `tmkategori` (`id`, `nama`, `no_rak`) VALUES
(13, 'Barang Habis Pakai', 1),
(14, 'Barang Tidak Habis Pakai', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tmpermintaan`
--

CREATE TABLE `tmpermintaan` (
  `id` int(11) NOT NULL,
  `tgl` date NOT NULL,
  `id_user` int(11) NOT NULL,
  `status_permintaan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tmpermintaan`
--

INSERT INTO `tmpermintaan` (`id`, `tgl`, `id_user`, `status_permintaan`) VALUES
(14, '2020-07-16', 2, 3),
(15, '2020-07-19', 2, 1),
(16, '2020-07-19', 2, 3),
(17, '2020-07-19', 7, 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tmpermintaan_detail`
--

CREATE TABLE `tmpermintaan_detail` (
  `id` int(11) NOT NULL,
  `id_permintaan` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tmpermintaan_detail`
--

INSERT INTO `tmpermintaan_detail` (`id`, `id_permintaan`, `id_barang`, `jumlah`) VALUES
(13, 14, 7, 2),
(14, 15, 21, 2),
(15, 16, 21, 4),
(16, 17, 21, 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tmpetugas`
--

CREATE TABLE `tmpetugas` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` enum('aktif','nonaktif') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tmpetugas`
--

INSERT INTO `tmpetugas` (`id`, `nama`, `username`, `password`, `status`) VALUES
(6, 'Amri Simanjuntak', 'amri', '2b482f311c959b5ffa8011fb8064b92dcaae85fc', 'aktif'),
(7, 'Januar Tampubolon', 'januar', '72bb2753c84f7e4cc8b665df471aa9c7283fe88c', 'aktif'),
(8, 'Melisa', 'melisa', '97d170e1550eee4afc0af065b78cda302a97674c', 'nonaktif');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tmstatus`
--

CREATE TABLE `tmstatus` (
  `id_status_permintaan` int(11) NOT NULL,
  `status` varchar(100) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tmstatus`
--

INSERT INTO `tmstatus` (`id_status_permintaan`, `status`) VALUES
(1, 'Menunggu'),
(2, 'Disetujui'),
(3, 'Ditolak');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tmuser`
--

CREATE TABLE `tmuser` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `unit` varchar(100) NOT NULL,
  `status` enum('aktif','nonaktif') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tmuser`
--

INSERT INTO `tmuser` (`id`, `nama`, `username`, `password`, `unit`, `status`) VALUES
(2, 'Melisa', 'melisa', '6d764e0722cf4852e77ac22bf76c97f9114d2d57', 'Dosen FITE', 'aktif'),
(6, 'test', 'test', '495094f85ae8073b456c4b74a16feabbf8f1f0cc', 'dosen', 'aktif'),
(7, 'herna', 'herna', 'c692b6e83d26e31d507049765d2e4b57976840a3', 'Dosen FITE', 'aktif'),
(8, 'Togu', 'togu', '97d170e1550eee4afc0af065b78cda302a97674c', 'DosenFITE', 'nonaktif'),
(9, 'Ike', 'ike', '97d170e1550eee4afc0af065b78cda302a97674c', 'Dosen FITE', 'nonaktif');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tmbarang`
--
ALTER TABLE `tmbarang`
  ADD PRIMARY KEY (`id`),
  ADD KEY `myKey` (`id_kategori`);

--
-- Indeks untuk tabel `tmkategori`
--
ALTER TABLE `tmkategori`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tmpermintaan`
--
ALTER TABLE `tmpermintaan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `status_permintaan` (`status_permintaan`);

--
-- Indeks untuk tabel `tmpermintaan_detail`
--
ALTER TABLE `tmpermintaan_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_permintaan` (`id_permintaan`);

--
-- Indeks untuk tabel `tmpetugas`
--
ALTER TABLE `tmpetugas`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tmstatus`
--
ALTER TABLE `tmstatus`
  ADD PRIMARY KEY (`id_status_permintaan`);

--
-- Indeks untuk tabel `tmuser`
--
ALTER TABLE `tmuser`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tmbarang`
--
ALTER TABLE `tmbarang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT untuk tabel `tmkategori`
--
ALTER TABLE `tmkategori`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `tmpermintaan`
--
ALTER TABLE `tmpermintaan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT untuk tabel `tmpermintaan_detail`
--
ALTER TABLE `tmpermintaan_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT untuk tabel `tmpetugas`
--
ALTER TABLE `tmpetugas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `tmstatus`
--
ALTER TABLE `tmstatus`
  MODIFY `id_status_permintaan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `tmuser`
--
ALTER TABLE `tmuser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tmbarang`
--
ALTER TABLE `tmbarang`
  ADD CONSTRAINT `myKey` FOREIGN KEY (`id_kategori`) REFERENCES `tmkategori` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tmpermintaan`
--
ALTER TABLE `tmpermintaan`
  ADD CONSTRAINT `tmpermintaan_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `tmuser` (`id`),
  ADD CONSTRAINT `tmpermintaan_ibfk_3` FOREIGN KEY (`status_permintaan`) REFERENCES `tmstatus` (`id_status_permintaan`);

--
-- Ketidakleluasaan untuk tabel `tmpermintaan_detail`
--
ALTER TABLE `tmpermintaan_detail`
  ADD CONSTRAINT `tmpermintaan_detail_ibfk_1` FOREIGN KEY (`id_permintaan`) REFERENCES `tmpermintaan` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
