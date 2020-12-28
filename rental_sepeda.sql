-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Des 2020 pada 08.25
-- Versi server: 10.1.32-MariaDB
-- Versi PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental_sepeda`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_peminjaman`
--

CREATE TABLE `tbl_peminjaman` (
  `id` int(11) NOT NULL,
  `sepeda_id` int(11) NOT NULL,
  `nama_peminjam` varchar(30) NOT NULL,
  `nik` varchar(30) NOT NULL,
  `harga_total` int(11) NOT NULL,
  `lama_pinjam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_peminjaman`
--

INSERT INTO `tbl_peminjaman` (`id`, `sepeda_id`, `nama_peminjam`, `nik`, `harga_total`, `lama_pinjam`) VALUES
(5, 1, 'zyx', '1900101', 4000, 4),
(6, 3, 'yoni', '19010102', 30000, 10);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_sepeda`
--

CREATE TABLE `tbl_sepeda` (
  `id` int(11) NOT NULL,
  `nama` varchar(225) NOT NULL,
  `status` varchar(30) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_sepeda`
--

INSERT INTO `tbl_sepeda` (`id`, `nama`, `status`, `harga`) VALUES
(1, 'bmx', 'Keluar', 1000),
(2, 'pixi', 'Tersedia', 2000),
(3, 'ontel', 'Keluar', 3000),
(4, 'ontel 1997', 'Tersedia', 2000),
(5, 'sepeda lipat 1990', 'Tersedia', 50000),
(6, 'yamaha ncx', 'Tersedia', 10000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_user`
--

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` text NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_user`
--

INSERT INTO `tb_user` (`id`, `nama`, `alamat`, `username`, `password`) VALUES
(1, 'MUHAMMAD ZIAD ALFIAN', 'LEMBAR', 'ziad', 'ziad'),
(2, 'YUSUF HIJRIAH', 'GERUNG', 'yusuf', 'yusuf'),
(3, 'wawan', 'loteng\n', 'wawan', 'wawan');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_peminjaman`
--
ALTER TABLE `tbl_peminjaman`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sepeda_id` (`sepeda_id`);

--
-- Indeks untuk tabel `tbl_sepeda`
--
ALTER TABLE `tbl_sepeda`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbl_peminjaman`
--
ALTER TABLE `tbl_peminjaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `tbl_sepeda`
--
ALTER TABLE `tbl_sepeda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tbl_peminjaman`
--
ALTER TABLE `tbl_peminjaman`
  ADD CONSTRAINT `tbl_peminjaman_ibfk_1` FOREIGN KEY (`sepeda_id`) REFERENCES `tbl_sepeda` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
