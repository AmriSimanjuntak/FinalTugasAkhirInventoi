-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 05 Jul 2020 pada 11.37
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
-- Database: `inventori`
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
(5, 'A-005', 'Xiaomi TV', 1, 'Buah', 62),
(7, 'S-022', 'LG', 1, 'Buah', 10),
(9, 'S-021', 'Samsung 21 Inch', 1, 'Buah', 80),
(10, 'A-011', 'Toshiba 20 Inch', 1, 'Buah', 10),
(11, '90AB', 'LCD TV Samsung', 1, 'Buah', 90),
(12, 'F-010', 'Samsung 24 Inch', 1, 'Buah', 80),
(13, 'A-001', 'Simbada', 3, 'Buah', 70),
(14, 'M-001', 'MacBook Pro 15 Inch', 6, 'Buah', 14),
(15, 'M-002', 'MacBook Pro 17 Inch', 6, 'Buah', 19),
(16, 'C-001', 'Acer Aspire One 15 Inch', 8, 'Buah', 15),
(17, 'C-002', 'Acer Aspire One 18 Inch', 8, 'Buah', 6),
(18, 'A-002', 'Simbada Type C3', 3, 'Buah', 68);

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
(1, 'TV', 1),
(2, 'DVD', 2),
(3, 'Sound System', 10),
(4, 'Joy Stick', 5),
(5, 'MacBook', 3),
(6, 'MacBook Pro', 3),
(7, 'MacBook Air', 3),
(8, 'Laptop', 4);

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
(7, 'Januar Tampubolon', 'januar', '72bb2753c84f7e4cc8b665df471aa9c7283fe88c', 'aktif');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tmuser`
--

CREATE TABLE `tmuser` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `unit` enum('dosen','staff') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `trbarang_keluar`
--

CREATE TABLE `trbarang_keluar` (
  `id` int(11) NOT NULL,
  `tgl` date NOT NULL,
  `id_petugas` int(11) NOT NULL,
  `id_pelanggan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `trbarang_keluar`
--

INSERT INTO `trbarang_keluar` (`id`, `tgl`, `id_petugas`, `id_pelanggan`) VALUES
(1, '2016-12-19', 2, 1),
(2, '2016-12-19', 2, 1),
(3, '2016-12-19', 2, 1),
(4, '2016-12-19', 2, 1),
(5, '2016-12-19', 2, 2),
(6, '2016-12-22', 2, 1),
(7, '2016-12-22', 2, 2),
(8, '2020-07-02', 2, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `trbarang_keluar_detail`
--

CREATE TABLE `trbarang_keluar_detail` (
  `id` int(11) NOT NULL,
  `id_barang_keluar` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `trbarang_keluar_detail`
--

INSERT INTO `trbarang_keluar_detail` (`id`, `id_barang_keluar`, `id_barang`, `jumlah`) VALUES
(1, 1, 14, 10),
(2, 1, 15, 11),
(3, 2, 14, 5),
(4, 2, 15, 6),
(5, 3, 14, 5),
(6, 3, 15, 6),
(7, 4, 14, 10),
(8, 4, 15, 11),
(9, 5, 16, 10),
(10, 5, 17, 11),
(11, 6, 13, 10),
(12, 6, 18, 12),
(13, 7, 5, 15),
(14, 8, 5, 3);

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
-- Indeks untuk tabel `tmpetugas`
--
ALTER TABLE `tmpetugas`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tmuser`
--
ALTER TABLE `tmuser`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `trbarang_keluar`
--
ALTER TABLE `trbarang_keluar`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `trbarang_keluar_detail`
--
ALTER TABLE `trbarang_keluar_detail`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tmbarang`
--
ALTER TABLE `tmbarang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT untuk tabel `tmkategori`
--
ALTER TABLE `tmkategori`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `tmpetugas`
--
ALTER TABLE `tmpetugas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `tmuser`
--
ALTER TABLE `tmuser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `trbarang_keluar`
--
ALTER TABLE `trbarang_keluar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `trbarang_keluar_detail`
--
ALTER TABLE `trbarang_keluar_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tmbarang`
--
ALTER TABLE `tmbarang`
  ADD CONSTRAINT `myKey` FOREIGN KEY (`id_kategori`) REFERENCES `tmkategori` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
