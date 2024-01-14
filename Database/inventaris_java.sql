-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Jan 2024 pada 15.32
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventaris_java`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `ruangan`
--

CREATE TABLE `ruangan` (
  `kode_ruangan` varchar(10) NOT NULL,
  `nama_ruangan` varchar(35) NOT NULL,
  `jumlah` int(5) NOT NULL,
  `kondisi` enum('Bagus','Sedang diperbaiki','Rusak') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `ruangan`
--

INSERT INTO `ruangan` (`kode_ruangan`, `nama_ruangan`, `jumlah`, `kondisi`) VALUES
('RGN002', 'Rektorat', 1, 'Bagus'),
('RGN003', 'Lab Komputer', 2, 'Bagus');

-- --------------------------------------------------------

--
-- Struktur dari tabel `sarana`
--

CREATE TABLE `sarana` (
  `kd_srp` varchar(10) NOT NULL,
  `nama_srp` varchar(35) NOT NULL,
  `jumlah` int(5) NOT NULL,
  `kondisi` enum('Bagus','Rusak sedang','Rusak Parah') NOT NULL,
  `jenis` enum('Elektronik','Non-Elektronik') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `sarana`
--

INSERT INTO `sarana` (`kd_srp`, `nama_srp`, `jumlah`, `kondisi`, `jenis`) VALUES
('SRP001', 'LCD Proyektor', 10, 'Bagus', 'Elektronik'),
('SRP002', 'Komputer', 40, 'Bagus', 'Elektronik'),
('SRP003', 'Kursi', 10, 'Rusak sedang', 'Non-Elektronik'),
('SRP004', 'meja', 20, 'Rusak Parah', 'Non-Elektronik'),
('SRP005', 'papan tulis', 25, 'Bagus', 'Non-Elektronik');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `email` varchar(50) NOT NULL,
  `username` varchar(35) NOT NULL,
  `password` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`email`, `username`, `password`) VALUES
('botol@gmail.com', 'botol', '12345'),
('firman@gmail.com', 'Firman', 'firman123');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `ruangan`
--
ALTER TABLE `ruangan`
  ADD PRIMARY KEY (`kode_ruangan`);

--
-- Indeks untuk tabel `sarana`
--
ALTER TABLE `sarana`
  ADD PRIMARY KEY (`kd_srp`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
