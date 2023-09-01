-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-09-2023 a las 18:21:18
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `productos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registroproductos`
--

CREATE TABLE `registroproductos` (
  `codigo` varchar(30) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `valor` varchar(30) NOT NULL,
  `caracteristicasfisicas` varchar(30) NOT NULL,
  `caracteristicasfabricacion` varchar(30) NOT NULL,
  `documento` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `registroproductos`
--

INSERT INTO `registroproductos` (`codigo`, `tipo`, `nombre`, `valor`, `caracteristicasfisicas`, `caracteristicasfabricacion`, `documento`) VALUES
('123456', 'comestible', 'azucar', '1200', 'granulado, azucar morena', 'proceso, en bolsa', 1006460117),
('654321', 'no comestible', 'reloj', '100000', 'Acero inoxidable', 'emsamblaje del mecanismo', 1006460117);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `registroproductos`
--
ALTER TABLE `registroproductos`
  ADD PRIMARY KEY (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
