-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-02-2022 a las 22:30:33
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `buffette`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `abogado`
--

CREATE TABLE `abogado` (
  `id_abogado` int(11) NOT NULL,
  `paterno` varchar(50) DEFAULT NULL,
  `materno` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `RFC` varchar(50) DEFAULT NULL,
  `cedula` varchar(50) DEFAULT NULL,
  `id_grado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `abogado`
--

INSERT INTO `abogado` (`id_abogado`, `paterno`, `materno`, `nombre`, `RFC`, `cedula`, `id_grado`) VALUES
(1, 'Herrera', 'Torres', 'Juan', 'HTJ10547HM', '1243567', 1),
(2, 'Corona', 'Navarro', 'Leonardo', 'CNL32546NM', '7689764', 1),
(3, 'Ruiz', 'Valdes', 'Maria', 'RVM21678HM', '2313567', 2),
(4, 'Guzman', 'Acosta', 'Sebastian', 'GAS7865HM6', '9867546', 3),
(5, 'Hernandez', 'Aguilar', 'Santiago', 'HAS9854JK4', '2156787', 4),
(6, 'Carrillo', 'Aguirre', 'Daniel', 'CAD56435HM', '3427865', 4),
(7, 'Antuna', 'Alvarado', 'Ruben', 'AAR19286CM', '5678765', 3),
(8, 'Cordova', 'Leon', 'Elizabeth', 'CLE20450FM', '1829919', 3),
(9, 'Martinez', 'Manjarrez', 'Lizbeth', 'MML00912JM', '2003456', 4),
(10, 'Ochoa', 'Olague', 'Isabel', 'OOI7876HCC', '3096542', 4);

--
-- Disparadores `abogado`
--
DELIMITER $$
CREATE TRIGGER `abogado_actualiza` AFTER UPDATE ON `abogado` FOR EACH ROW BEGIN
INSERT INTO audita_abogado(operacion, usuario, fecha,  new_id_abogado, new_paterno,  new_materno, new_nombre,  new_RFC,  new_id_grado, old_id_abogado, old_paterno, old_materno,  old_nombre,  old_RFC, old_id_grado )
VALUES ('Actualizado', current_user(), now(), new.id_abogado, new.paterno,  new.materno, new.nombre,  new.RFC,  new.id_grado, old.id_abogado, old.paterno, old.materno,  old.nombre,  old.RFC, old.id_grado);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `abogado_elimina` AFTER DELETE ON `abogado` FOR EACH ROW BEGIN
INSERT INTO audita_abogado (operacion, usuario, fecha, old_id_abogado, old_paterno, old_materno,  old_nombre,  old_RFC, old_id_grado  )
VALUES ('Eliminado', current_user(), now(), old.id_abogado, old.paterno, old.materno,  old.nombre,  old.RFC, old.id_grado  );
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `abogado_inserta` AFTER INSERT ON `abogado` FOR EACH ROW BEGIN
INSERT INTO audita_abogado (operacion, usuario, fecha,  new_id_abogado, new_paterno,  new_materno, new_nombre,  new_RFC,  new_id_grado)
VALUES ('insertar', current_user(), now(), new.id_abogado, new.paterno,  new.materno, new.nombre,  new.RFC,  new.id_grado);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asesora`
--

CREATE TABLE `asesora` (
  `id_asesoria` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `tema` varchar(70) DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `id_asunto` int(11) DEFAULT NULL,
  `asesor` int(11) DEFAULT NULL,
  `asesorado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `asesora`
--

INSERT INTO `asesora` (`id_asesoria`, `fecha`, `tema`, `hora`, `id_asunto`, `asesor`, `asesorado`) VALUES
(1, '2017-11-05', 'Divorcios', '13:00:00', 4, 1, 7),
(2, '2019-06-17', 'Testamentos', '10:00:00', 2, 2, 6),
(3, '2016-07-23', 'Juicios', '09:00:00', 5, 3, 5),
(4, '2018-08-27', 'Regularizacion de propiedades ', '14:00:00', 3, 4, 4),
(5, '2019-04-05', 'Cumplimientos de pensiones alimenticias', '15:00:00', 1, 5, 3);

--
-- Disparadores `asesora`
--
DELIMITER $$
CREATE TRIGGER `asesora_actualiza` AFTER UPDATE ON `asesora` FOR EACH ROW BEGIN
INSERT INTO audita_asesora(operacion, usuario, fecha,  new_fecha, new_tema, new_hora,  new_id_asunto, new_asesor,  new_asesorado, old_fecha,  old_tema, old_hora, old_id_asunto, old_asesor,  old_asesorado )
VALUES ('Actualizado', current_user(), now(),  new.fecha, new.tema, new.hora,  new.id_asunto, new.asesor,  new.asesorado, old.fecha,  old.tema, old.hora, old.id_asunto, old.asesor,  old.asesorado );
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `asesora_elimina` AFTER DELETE ON `asesora` FOR EACH ROW BEGIN
INSERT INTO audita_asesora (operacion, usuario, fecha, old_fecha,  old_tema, old_hora, old_id_asunto, old_asesor,  old_asesorado)
VALUES ('Eliminado', current_user(), now(), old.fecha, old.tema, old.hora, old.id_asunto, old.asesor, old.asesorado);  
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `asesora_inserta` AFTER INSERT ON `asesora` FOR EACH ROW BEGIN
INSERT INTO audita_asesora (operacion, usuario, fecha, new_fecha, new_tema, new_hora,  new_id_asunto, new_asesor,  new_asesorado)
VALUES ('insertar', current_user(), now(), new.fecha, new.tema, new.hora,  new.id_asunto, new.asesor,  new.asesorado);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asunto`
--

CREATE TABLE `asunto` (
  `id_asunto` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_demandado` int(11) DEFAULT NULL,
  `id_estado` int(11) DEFAULT NULL,
  `id_tipo_asu` int(11) DEFAULT NULL,
  `id_abogado` int(11) DEFAULT NULL,
  `F_inicio` date DEFAULT NULL,
  `F_final` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `asunto`
--

INSERT INTO `asunto` (`id_asunto`, `id_cliente`, `id_demandado`, `id_estado`, `id_tipo_asu`, `id_abogado`, `F_inicio`, `F_final`) VALUES
(1, 4, 6, 1, 5, 1, '2019-04-03', '2020-05-29'),
(2, 5, 5, 1, 4, 2, '2019-06-15', '2020-03-23'),
(3, 7, 2, 3, 7, 3, '2018-08-25', '2019-09-06'),
(4, 2, 1, 2, 6, 4, '2017-11-02', '2019-10-18'),
(5, 3, 6, 1, 1, 5, '2016-07-21', '2018-08-16');

--
-- Disparadores `asunto`
--
DELIMITER $$
CREATE TRIGGER `asunto_actualiza` AFTER UPDATE ON `asunto` FOR EACH ROW BEGIN
INSERT INTO audita_asunto(operacion, usuario, fecha, new_id_asunto, new_id_cliente, new_id_demandado, new_id_estado, new_id_tipo_asu,  new_id_abogado, new_f_inicio, new_f_final, old_id_asunto, old_id_cliente, old_id_demandado, old_id_estado, old_id_tipo_asu,  old_id_abogado, old_f_inicio, old_f_final)
VALUES ('Actualizado', current_user(), now(), new.id_asunto, new.id_cliente, new.id_demandado, new.id_estado, new.id_tipo_asu,  new.id_abogado, new.f_inicio, new.f_final,  old.id_asunto, old.id_cliente, old.id_demandado, old.id_estado, old.id_tipo_asu,  old.id_abogado, old.f_inicio, old.f_final);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `asunto_elimina` AFTER DELETE ON `asunto` FOR EACH ROW BEGIN
INSERT INTO audita_asunto (operacion, usuario, fecha, old_id_asunto, old_id_cliente, old_id_demandado, old_id_estado, old_id_tipo_asu,  old_id_abogado, old_f_inicio, old_f_final)  
VALUES ('Eliminado', current_user(), now(), old.id_asunto, old.id_cliente, old.id_demandado, old.id_estado, old.id_tipo_asu,  old.id_abogado, old.f_inicio, old.f_final);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `asunto_inserta` AFTER INSERT ON `asunto` FOR EACH ROW BEGIN
INSERT INTO audita_asunto (operacion, usuario, fecha,  new_id_asunto, new_id_cliente, new_id_demandado, new_id_estado, new_id_tipo_asu,  new_id_abogado, new_f_inicio, new_f_final)
VALUES ('insertar', current_user(), now(), new.id_asunto, new.id_cliente, new.id_demandado, new.id_estado, new.id_tipo_asu,  new.id_abogado, new.f_inicio, new.f_final);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audiencia`
--

CREATE TABLE `audiencia` (
  `id_audiencia` int(11) NOT NULL,
  `id_lugar` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `resolucion` varchar(50) DEFAULT NULL,
  `id_asunto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audiencia`
--

INSERT INTO `audiencia` (`id_audiencia`, `id_lugar`, `fecha`, `hora`, `resolucion`, `id_asunto`) VALUES
(1, 5, '2020-01-10', '13:00:00', 'sestencia', 1),
(2, 1, '2018-02-24', '10:00:00', 'autos', 4),
(3, 6, '2017-10-02', '15:00:00', 'decretos', 5),
(4, 4, '2018-10-28', '09:00:00', 'decretos', 3),
(5, 3, '2020-09-10', '12:00:00', 'autos', 2);

--
-- Disparadores `audiencia`
--
DELIMITER $$
CREATE TRIGGER `audiencia_actualiza` AFTER UPDATE ON `audiencia` FOR EACH ROW BEGIN
INSERT INTO audita_audiencia(operacion, usuario, fecha, new_id_audiencia, new_id_lugar, new_fecha,  new_hora, new_resolucion, new_id_asunto, old_id_audiencia,  old_id_lugar, old_fecha,  old_hora,  old_resolucion, old_id_asunto)
VALUES ('Actualizado', current_user(), now(), new.id_audiencia, new.id_lugar, new.fecha,  new.hora, new.resolucion, new.id_asunto, old.id_audiencia,  old.id_lugar, old.fecha,  old.hora,  old.resolucion, old.id_asunto);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `audiencia_elimina` AFTER DELETE ON `audiencia` FOR EACH ROW BEGIN
INSERT INTO audita_audiencia (operacion, usuario, fecha,  old_id_audiencia,  old_id_lugar, old_fecha,  old_hora,  old_resolucion, old_id_asunto)
VALUES ('Eliminado', current_user(), now(), old.id_audiencia,  old.id_lugar, old.fecha,  old.hora,  old.resolucion, old.id_asunto);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `audiencia_inserta` AFTER INSERT ON `audiencia` FOR EACH ROW BEGIN
INSERT INTO audita_audiencia (operacion, usuario, fecha, new_id_audiencia, new_id_lugar, new_fecha,  new_hora, new_resolucion, new_id_asunto)
VALUES ('insertar', current_user(), now(), new.id_audiencia, new.id_lugar, new.fecha,  new.hora, new.resolucion, new.id_asunto);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_abogado`
--

CREATE TABLE `audita_abogado` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_abogado` int(11) DEFAULT NULL,
  `new_paterno` varchar(50) DEFAULT '--------',
  `new_materno` varchar(50) DEFAULT '--------',
  `new_nombre` varchar(50) DEFAULT '--------',
  `new_RFC` varchar(50) DEFAULT '--------',
  `new_id_grado` int(11) DEFAULT NULL,
  `old_id_abogado` int(11) DEFAULT NULL,
  `old_paterno` varchar(50) DEFAULT '--------',
  `old_materno` varchar(50) DEFAULT '--------',
  `old_nombre` varchar(50) DEFAULT '--------',
  `old_RFC` varchar(50) DEFAULT '--------',
  `old_id_grado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_abogado`
--

INSERT INTO `audita_abogado` (`operacion`, `usuario`, `fecha`, `new_id_abogado`, `new_paterno`, `new_materno`, `new_nombre`, `new_RFC`, `new_id_grado`, `old_id_abogado`, `old_paterno`, `old_materno`, `old_nombre`, `old_RFC`, `old_id_grado`) VALUES
('Eliminado', 'root@localhost', '2022-01-05 04:09:20', NULL, '--------', '--------', '--------', '--------', NULL, 10, 'Ochoa', 'Olague', 'Isabel', 'OOI7876HCC', 4),
('insertar', 'root@localhost', '2022-01-05 05:57:46', 11, 'Gonzalez', 'Medina', 'Elizabeth', 'GME092423', 2, NULL, '--------', '--------', '--------', '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:25:56', 1, 'Herrera', 'Torres', 'Juan', 'HTJ10547HM', 1, NULL, '--------', '--------', '--------', '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:25:56', 2, 'Corona', 'Navarro', 'Leonardo', 'CNL32546NM', 1, NULL, '--------', '--------', '--------', '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:25:56', 3, 'Ruiz', 'Valdes', 'Maria', 'RVM21678HM', 2, NULL, '--------', '--------', '--------', '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:25:56', 4, 'Guzman', 'Acosta', 'Sebastian', 'GAS7865HM6', 3, NULL, '--------', '--------', '--------', '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:25:56', 5, 'Hernandez', 'Aguilar', 'Santiago', 'HAS9854JK4', 4, NULL, '--------', '--------', '--------', '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:25:56', 6, 'Carrillo', 'Aguirre', 'Daniel', 'CAD56435HM', 4, NULL, '--------', '--------', '--------', '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:25:56', 7, 'Antuna', 'Alvarado', 'Ruben', 'AAR19286CM', 3, NULL, '--------', '--------', '--------', '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:25:56', 8, 'Cordova', 'Leon', 'Elizabeth', 'CLE20450FM', 3, NULL, '--------', '--------', '--------', '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:25:56', 9, 'Martinez', 'Manjarrez', 'Lizbeth', 'MML00912JM', 4, NULL, '--------', '--------', '--------', '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:25:56', 10, 'Ochoa', 'Olague', 'Isabel', 'OOI7876HCC', 4, NULL, '--------', '--------', '--------', '--------', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_asesora`
--

CREATE TABLE `audita_asesora` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_fecha` date DEFAULT NULL,
  `new_tema` varchar(70) DEFAULT '--------',
  `new_hora` time DEFAULT NULL,
  `new_id_asunto` int(11) DEFAULT NULL,
  `new_asesor` int(11) DEFAULT NULL,
  `new_asesorado` int(11) DEFAULT NULL,
  `old_fecha` date DEFAULT NULL,
  `old_tema` varchar(70) DEFAULT '--------',
  `old_hora` time DEFAULT NULL,
  `old_id_asunto` int(11) DEFAULT NULL,
  `old_asesor` int(11) DEFAULT NULL,
  `old_asesorado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_asesora`
--

INSERT INTO `audita_asesora` (`operacion`, `usuario`, `fecha`, `new_fecha`, `new_tema`, `new_hora`, `new_id_asunto`, `new_asesor`, `new_asesorado`, `old_fecha`, `old_tema`, `old_hora`, `old_id_asunto`, `old_asesor`, `old_asesorado`) VALUES
('insertar', 'root@localhost', '2022-01-05 03:48:42', '2022-01-26', 'Testamento', '03:48:42', 2, 7, 1, NULL, '--------', NULL, NULL, NULL, NULL),
('Eliminado', 'root@localhost', '2022-01-05 03:52:18', NULL, '--------', NULL, NULL, NULL, NULL, '2022-01-15', 'Penal', '03:45:03', 2, 4, 2),
('Eliminado', 'root@localhost', '2022-01-05 03:52:21', NULL, '--------', NULL, NULL, NULL, NULL, '2022-01-26', 'Testamento', '03:48:42', 2, 7, 1),
('Eliminado', 'root@localhost', '2022-01-05 03:52:23', NULL, '--------', NULL, NULL, NULL, NULL, '2022-01-21', 'Divorcio', '03:45:41', 1, 2, 5),
('insertar', 'root@localhost', '2022-01-05 04:01:42', '2022-01-21', 'Demanda', '14:01:16', 2, 5, 2, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 13:29:54', '2022-01-15', 'Divorcio', '13:29:25', 3, 6, 2, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:26:38', '2017-11-05', 'Divorcios', '13:00:00', 4, 1, 7, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:26:38', '2019-06-17', 'Testamentos', '10:00:00', 2, 2, 6, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:26:38', '2016-07-23', 'Juicios', '09:00:00', 5, 3, 5, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:26:38', '2018-08-27', 'Regularizacion de propiedades ', '14:00:00', 3, 4, 4, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:26:38', '2019-04-05', 'Cumplimientos de pensiones alimenticias', '15:00:00', 1, 5, 3, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:26:56', '2017-11-05', 'Divorcios', '13:00:00', 4, 1, 7, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:26:56', '2019-06-17', 'Testamentos', '10:00:00', 2, 2, 6, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:26:56', '2016-07-23', 'Juicios', '09:00:00', 5, 3, 5, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:26:56', '2018-08-27', 'Regularizacion de propiedades ', '14:00:00', 3, 4, 4, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:26:56', '2019-04-05', 'Cumplimientos de pensiones alimenticias', '15:00:00', 1, 5, 3, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:31:32', '2017-11-05', 'Divorcios', '13:00:00', 4, 1, 7, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:31:32', '2019-06-17', 'Testamentos', '10:00:00', 2, 2, 6, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:31:32', '2016-07-23', 'Juicios', '09:00:00', 5, 3, 5, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:31:32', '2018-08-27', 'Regularizacion de propiedades ', '14:00:00', 3, 4, 4, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:31:32', '2019-04-05', 'Cumplimientos de pensiones alimenticias', '15:00:00', 1, 5, 3, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:32:10', '2017-11-05', 'Divorcios', '13:00:00', 4, 1, 7, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:32:10', '2019-06-17', 'Testamentos', '10:00:00', 2, 2, 6, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:32:10', '2016-07-23', 'Juicios', '09:00:00', 5, 3, 5, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:32:10', '2018-08-27', 'Regularizacion de propiedades ', '14:00:00', 3, 4, 4, NULL, '--------', NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:32:10', '2019-04-05', 'Cumplimientos de pensiones alimenticias', '15:00:00', 1, 5, 3, NULL, '--------', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_asunto`
--

CREATE TABLE `audita_asunto` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_asunto` int(11) DEFAULT NULL,
  `new_id_cliente` int(11) DEFAULT NULL,
  `new_id_demandado` int(11) DEFAULT NULL,
  `new_id_estado` int(11) DEFAULT NULL,
  `new_id_tipo_asu` int(11) DEFAULT NULL,
  `new_id_abogado` int(11) DEFAULT NULL,
  `new_f_inicio` date DEFAULT NULL,
  `new_f_final` date DEFAULT NULL,
  `old_id_asunto` int(11) DEFAULT NULL,
  `old_id_cliente` int(11) DEFAULT NULL,
  `old_id_demandado` int(11) DEFAULT NULL,
  `old_id_estado` int(11) DEFAULT NULL,
  `old_id_tipo_asu` int(11) DEFAULT NULL,
  `old_id_abogado` int(11) DEFAULT NULL,
  `old_f_inicio` date DEFAULT NULL,
  `old_f_final` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_asunto`
--

INSERT INTO `audita_asunto` (`operacion`, `usuario`, `fecha`, `new_id_asunto`, `new_id_cliente`, `new_id_demandado`, `new_id_estado`, `new_id_tipo_asu`, `new_id_abogado`, `new_f_inicio`, `new_f_final`, `old_id_asunto`, `old_id_cliente`, `old_id_demandado`, `old_id_estado`, `old_id_tipo_asu`, `old_id_abogado`, `old_f_inicio`, `old_f_final`) VALUES
('insertar', 'root@localhost', '2022-01-04 19:02:11', 2, 4, 1, 2, 2, 7, '2021-12-08', '2022-01-05', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-05 04:05:25', 3, 5, 1, 1, 3, 7, '2022-01-13', '2022-01-15', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:24:07', 9, 4, 6, 1, 5, 1, '2019-04-03', '2020-05-29', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:24:07', 10, 5, 5, 1, 4, 2, '2019-06-15', '2020-03-23', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:24:07', 11, 7, 2, 3, 7, 3, '2018-08-25', '2019-09-06', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:24:07', 12, 2, 1, 2, 6, 4, '2017-11-02', '2019-10-18', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:24:07', 13, 3, 6, 1, 1, 5, '2016-07-21', '2018-08-16', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:24:31', 1, 4, 6, 1, 5, 1, '2019-04-03', '2020-05-29', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:24:31', 2, 5, 5, 1, 4, 2, '2019-06-15', '2020-03-23', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:24:31', 3, 7, 2, 3, 7, 3, '2018-08-25', '2019-09-06', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:24:31', 4, 2, 1, 2, 6, 4, '2017-11-02', '2019-10-18', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 16:24:31', 5, 3, 6, 1, 1, 5, '2016-07-21', '2018-08-16', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_audiencia`
--

CREATE TABLE `audita_audiencia` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_audiencia` int(11) DEFAULT NULL,
  `new_id_lugar` int(11) DEFAULT NULL,
  `new_fecha` date DEFAULT NULL,
  `new_hora` time DEFAULT NULL,
  `new_resolucion` varchar(50) DEFAULT '--------',
  `new_id_asunto` int(11) DEFAULT NULL,
  `old_id_audiencia` int(11) DEFAULT NULL,
  `old_id_lugar` int(11) DEFAULT NULL,
  `old_fecha` date DEFAULT NULL,
  `old_hora` time DEFAULT NULL,
  `old_resolucion` varchar(50) DEFAULT '--------',
  `old_id_asunto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_audiencia`
--

INSERT INTO `audita_audiencia` (`operacion`, `usuario`, `fecha`, `new_id_audiencia`, `new_id_lugar`, `new_fecha`, `new_hora`, `new_resolucion`, `new_id_asunto`, `old_id_audiencia`, `old_id_lugar`, `old_fecha`, `old_hora`, `old_resolucion`, `old_id_asunto`) VALUES
('insertar', 'root@localhost', '2022-01-06 13:24:19', 1, 2, '2022-01-13', '17:23:00', 'Penal', 2, NULL, NULL, NULL, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:28:41', 1, 5, '2020-01-10', '13:00:00', 'sestencia', 1, NULL, NULL, NULL, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:28:41', 2, 1, '2018-02-24', '10:00:00', 'autos', 4, NULL, NULL, NULL, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:28:41', 3, 6, '2017-10-02', '15:00:00', 'decretos', 5, NULL, NULL, NULL, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:28:41', 4, 4, '2018-10-28', '09:00:00', 'decretos', 3, NULL, NULL, NULL, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:28:41', 5, 3, '2020-09-10', '12:00:00', 'autos', 2, NULL, NULL, NULL, NULL, '--------', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_cliente`
--

CREATE TABLE `audita_cliente` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_cliente` int(11) DEFAULT NULL,
  `new_paterno` varchar(50) DEFAULT '--------',
  `new_materno` varchar(50) DEFAULT '--------',
  `new_nombre` varchar(50) DEFAULT '--------',
  `new_CURP` varchar(50) DEFAULT '--------',
  `new_RFC` varchar(50) DEFAULT '--------',
  `old_id_cliente` int(11) DEFAULT NULL,
  `old_paterno` varchar(50) DEFAULT '--------',
  `old_materno` varchar(50) DEFAULT '--------',
  `old_nombre` varchar(50) DEFAULT '--------',
  `old_CURP` varchar(50) DEFAULT '--------',
  `old_RFC` varchar(50) DEFAULT '--------'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_cliente`
--

INSERT INTO `audita_cliente` (`operacion`, `usuario`, `fecha`, `new_id_cliente`, `new_paterno`, `new_materno`, `new_nombre`, `new_CURP`, `new_RFC`, `old_id_cliente`, `old_paterno`, `old_materno`, `old_nombre`, `old_CURP`, `old_RFC`) VALUES
('insertar', 'root@localhost', '2022-01-05 01:03:18', 16, 'Saldana', 'Samperio', 'Alicia', 'SSALONR130798MMCLIE', 'SSAMPORRD', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 16:36:03', 1, 'Hernandez', 'Monterrosa', 'Adriana Carolina', 'HEMA991201MDFRND05', 'HEMA991201', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 16:36:03', 2, 'Carvajal', ' Vargas', 'Alexander', 'CAVA950518HDFRRL12', 'CAVA950518', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 16:36:03', 3, 'Rodr?guez ', 'Botero', 'Camilo', 'ROBC870810HDFDTM25', 'ROBC870810', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 16:36:03', 4, 'Castiblanco ', 'Salgado', 'Daniel Andr?s', 'CASD850912HDFSLN02', 'CASD850912', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 16:36:03', 5, 'Lopez', ' Rodriguez', 'Diana carolina', 'LORD920515MDFPDN08', 'LORD920515', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 16:36:03', 6, 'Camargo', ' Vargas', 'Hugo andr?s', 'CAVH820130HDFMRG28', 'CAVH820130', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 16:36:03', 7, 'Marin', ' Zubieta', 'Jose Guillermo', 'MAZJ860218HDFRBS15', 'MAZJ860218', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 16:36:03', 8, 'Nieto', ' Bustos', 'Maria Camila', 'NIBM950728MDFTSR03', 'NIBM950728', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 16:36:03', 9, 'Perez', ' Moreno', 'Maria Margarita', 'PEMM880524MDFRRR09', 'PEMM880524', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 16:36:03', 10, 'Castellanos', ' Rojas', 'Oscar Fabian', 'CARO890830HDFSJS10', 'CARO890830', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:27:25', 1, 'Hernandez', 'Monterrosa', 'Adriana Carolina', 'HEMA991201MDFRND05', 'HEMA991201', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:27:25', 2, 'Carvajal', ' Vargas', 'Alexander', 'CAVA950518HDFRRL12', 'CAVA950518', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:27:25', 3, 'Rodr?guez ', 'Botero', 'Camilo', 'ROBC870810HDFDTM25', 'ROBC870810', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:27:25', 4, 'Castiblanco ', 'Salgado', 'Daniel Andr?s', 'CASD850912HDFSLN02', 'CASD850912', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:27:25', 5, 'Lopez', ' Rodriguez', 'Diana carolina', 'LORD920515MDFPDN08', 'LORD920515', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:27:25', 6, 'Camargo', ' Vargas', 'Hugo andr?s', 'CAVH820130HDFMRG28', 'CAVH820130', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:27:25', 7, 'Marin', ' Zubieta', 'Jose Guillermo', 'MAZJ860218HDFRBS15', 'MAZJ860218', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:27:25', 8, 'Nieto', ' Bustos', 'Maria Camila', 'NIBM950728MDFTSR03', 'NIBM950728', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:27:25', 9, 'Perez', ' Moreno', 'Maria Margarita', 'PEMM880524MDFRRR09', 'PEMM880524', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:27:25', 10, 'Castellanos', ' Rojas', 'Oscar Fabian', 'CARO890830HDFSJS10', 'CARO890830', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:40:40', 1, 'Hernandez', 'Monterrosa', 'Adriana Carolina', 'HEMA991201MDFRND05', 'HEMA991201', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:42:18', 2, 'Carvajal', ' Vargas', 'Alexander', 'CAVA950518HDFRRL12', 'CAVA950518', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:42:18', 3, 'Rodr?guez ', 'Botero', 'Camilo', 'ROBC870810HDFDTM25', 'ROBC870810', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:42:18', 4, 'Castiblanco ', 'Salgado', 'Daniel Andr?s', 'CASD850912HDFSLN02', 'CASD850912', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:42:18', 5, 'Lopez', ' Rodriguez', 'Diana carolina', 'LORD920515MDFPDN08', 'LORD920515', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:42:18', 6, 'Camargo', ' Vargas', 'Hugo andr?s', 'CAVH820130HDFMRG28', 'CAVH820130', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:42:18', 7, 'Marin', ' Zubieta', 'Jose Guillermo', 'MAZJ860218HDFRBS15', 'MAZJ860218', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:42:18', 8, 'Nieto', ' Bustos', 'Maria Camila', 'NIBM950728MDFTSR03', 'NIBM950728', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:42:18', 9, 'Perez', ' Moreno', 'Maria Margarita', 'PEMM880524MDFRRR09', 'PEMM880524', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 21:42:18', 10, 'Castellanos', ' Rojas', 'Oscar Fabian', 'CARO890830HDFSJS10', 'CARO890830', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 22:33:17', 11, 'Garcia', 'Silverio', 'Esther', 'GSIEGTEDMMLIV', 'SIEGTYDVGJD34', NULL, '--------', '--------', '--------', '--------', '--------'),
('insertar', 'root@localhost', '2022-01-06 22:36:57', 12, 'Garcia', 'Silverio', 'Alberto', 'ABSEGTEDMMLIV', 'ABSGTYDVGJD34', NULL, '--------', '--------', '--------', '--------', '--------');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_contacto`
--

CREATE TABLE `audita_contacto` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_contacto` int(11) DEFAULT NULL,
  `new_id_cliente` int(11) DEFAULT NULL,
  `new_id_medio` int(11) DEFAULT NULL,
  `old_id_contacto` int(11) DEFAULT NULL,
  `old_id_cliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_contacto`
--

INSERT INTO `audita_contacto` (`operacion`, `usuario`, `fecha`, `new_id_contacto`, `new_id_cliente`, `new_id_medio`, `old_id_contacto`, `old_id_cliente`) VALUES
('insertar', 'root@localhost', '2022-01-05 01:03:20', 7, 16, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:40:41', 1, 1, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:43:24', 2, 2, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:43:24', 3, 3, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:43:24', 4, 4, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:43:24', 5, 5, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:43:24', 6, 6, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:43:24', 7, 7, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:43:24', 8, 8, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:43:24', 9, 9, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:43:24', 10, 10, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 22:33:18', 11, 11, NULL, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 22:36:58', 12, 12, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_correo`
--

CREATE TABLE `audita_correo` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_contacto` int(11) DEFAULT NULL,
  `new_cuenta` int(11) DEFAULT NULL,
  `old_id_contacto` int(11) DEFAULT NULL,
  `old_cuenta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_correo`
--

INSERT INTO `audita_correo` (`operacion`, `usuario`, `fecha`, `new_id_contacto`, `new_cuenta`, `old_id_contacto`, `old_cuenta`) VALUES
('insertar', 'root@localhost', '2022-01-05 01:03:20', 7, 0, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:40:41', 1, 0, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:44:33', 2, 0, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:44:33', 3, 0, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:44:33', 4, 0, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:44:33', 5, 0, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:44:33', 6, 0, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:44:33', 7, 0, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:44:33', 8, 0, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:44:33', 9, 0, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 21:44:33', 10, 0, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 22:33:18', 11, 0, NULL, NULL),
('insertar', 'root@localhost', '2022-01-06 22:36:58', 12, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_demandado`
--

CREATE TABLE `audita_demandado` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_demandado` int(11) DEFAULT NULL,
  `new_direccion` varchar(50) DEFAULT '--------',
  `new_id_tipo` int(11) DEFAULT NULL,
  `old_id_demandado` int(11) DEFAULT NULL,
  `old_direccion` varchar(50) DEFAULT '--------',
  `old_id_tipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_demandado`
--

INSERT INTO `audita_demandado` (`operacion`, `usuario`, `fecha`, `new_id_demandado`, `new_direccion`, `new_id_tipo`, `old_id_demandado`, `old_direccion`, `old_id_tipo`) VALUES
('insertar', 'root@localhost', '2022-01-04 19:00:10', 1, 'calle huanacatl mz29 lt 15 barrio herreros', 3, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-05 20:07:02', 2, '', 1, NULL, '--------', NULL),
('Eliminado', 'root@localhost', '2022-01-05 20:07:24', NULL, '--------', NULL, 2, '', 1),
('insertar', 'root@localhost', '2022-01-05 23:09:19', 4, 'Av 24 Lt 59 Mz 23', 2, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:15:39', 11, 'calle huanacatl mz29 lt 15 barrio herreros', 1, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:15:39', 12, 'calle azul mz 23 lt 67 barrio carpintero', 1, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:15:39', 13, 'calle benito juarez mz 23 lt 15 venustiano carranz', 3, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:15:39', 14, 'calle vicente mz 30 lt 34  san juan ', 5, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:15:39', 15, 'calle pajaro mz12 lt 56 san pedro', 5, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:15:39', 16, 'calle tomacatli mz 15 lt 76  san miguel', 3, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:15:39', 17, 'calle manzano mz 16 lt 43 castillo', 2, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:15:39', 18, 'calle san miguel mz30 lt 87  aragon', 3, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:15:39', 19, 'calle  sor juana mz 23 lt 45   vicente', 4, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:15:39', 20, 'calle tetocani mz 12 lt 15 herreros', 5, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:18:26', 1, 'calle huanacatl mz29 lt 15 barrio herreros', 1, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:18:26', 2, 'calle azul mz 23 lt 67 barrio carpintero', 1, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:18:26', 3, 'calle benito juarez mz 23 lt 15 venustiano carranz', 3, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:18:26', 4, 'calle vicente mz 30 lt 34  san juan ', 5, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:18:26', 5, 'calle pajaro mz12 lt 56 san pedro', 5, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:18:26', 6, 'calle tomacatli mz 15 lt 76  san miguel', 3, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:18:26', 7, 'calle manzano mz 16 lt 43 castillo', 2, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:18:26', 8, 'calle san miguel mz30 lt 87  aragon', 3, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:18:26', 9, 'calle  sor juana mz 23 lt 45   vicente', 4, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 16:18:26', 10, 'calle tetocani mz 12 lt 15 herreros', 5, NULL, '--------', NULL),
('insertar', 'root@localhost', '2022-01-06 22:41:06', 11, 'C Azucena Mz 29 Lt 3', 3, NULL, '--------', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_empresa`
--

CREATE TABLE `audita_empresa` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_demandado` int(11) DEFAULT NULL,
  `new_razon_social` varchar(50) DEFAULT '--------',
  `old_id_demandado` int(11) DEFAULT NULL,
  `old_razon_social` varchar(50) DEFAULT '--------'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_empresa`
--

INSERT INTO `audita_empresa` (`operacion`, `usuario`, `fecha`, `new_id_demandado`, `new_razon_social`, `old_id_demandado`, `old_razon_social`) VALUES
('insertar', 'root@localhost', '2022-01-06 16:20:21', 4, 'Banamex', NULL, '--------'),
('insertar', 'root@localhost', '2022-01-06 16:20:21', 5, 'Coca cola', NULL, '--------'),
('insertar', 'root@localhost', '2022-01-06 16:20:21', 7, 'Bimbo', NULL, '--------'),
('insertar', 'root@localhost', '2022-01-06 16:20:21', 8, 'Uber ', NULL, '--------'),
('insertar', 'root@localhost', '2022-01-06 16:20:21', 10, 'Cinemex', NULL, '--------'),
('insertar', 'root@localhost', '2022-01-06 22:27:14', 1, ' ', NULL, '--------'),
('insertar', 'root@localhost', '2022-01-06 22:27:14', 2, '  ', NULL, '--------'),
('insertar', 'root@localhost', '2022-01-06 22:27:14', 3, '  ', NULL, '--------'),
('insertar', 'root@localhost', '2022-01-06 22:27:14', 6, '  ', NULL, '--------'),
('insertar', 'root@localhost', '2022-01-06 22:27:14', 9, ' ', NULL, '--------'),
('insertar', 'root@localhost', '2022-01-06 22:41:07', 11, '', NULL, '--------');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_estado`
--

CREATE TABLE `audita_estado` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_estado` int(11) DEFAULT NULL,
  `new_descripcion` varchar(70) DEFAULT '--------',
  `old_id_estado` int(11) DEFAULT NULL,
  `old_descripcion` varchar(70) DEFAULT '--------'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_estudio`
--

CREATE TABLE `audita_estudio` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_grado` int(11) DEFAULT NULL,
  `new_descripcion` varchar(70) DEFAULT '--------',
  `old_id_grado` int(11) DEFAULT NULL,
  `old_descripcion` varchar(70) DEFAULT '--------'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_facebook`
--

CREATE TABLE `audita_facebook` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_contacto` int(11) DEFAULT NULL,
  `new_usuario` varchar(50) DEFAULT '--------',
  `old_id_contacto` int(11) DEFAULT NULL,
  `old_usuario` varchar(50) DEFAULT '--------'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_facebook`
--

INSERT INTO `audita_facebook` (`operacion`, `usuario`, `fecha`, `new_id_contacto`, `new_usuario`, `old_id_contacto`, `old_usuario`) VALUES
('Insertar', 'root@localhost', '2022-01-05 01:03:20', 7, 'Alicia S', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 21:40:41', 1, 'Adriana Hernandez', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 21:45:06', 2, 'Alex Vargas', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 21:45:06', 3, 'Camilo Rodr?guez ', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 21:45:06', 4, 'Dani Salgado', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 21:45:06', 5, 'Carolina Lopez ', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 21:45:06', 6, 'Camargo  Vargas', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 21:45:06', 7, 'Guillermo Zubieta', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 21:45:06', 8, 'Maria Bustos', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 21:45:06', 9, 'Mari Moreno', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 21:45:06', 10, 'Oscar Rojas', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 22:33:18', 11, '', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 22:36:58', 12, 'Albert Mtz', NULL, '--------');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_gente`
--

CREATE TABLE `audita_gente` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_gente` int(11) DEFAULT NULL,
  `new_paterno` varchar(70) DEFAULT '--------',
  `new_materno` varchar(70) DEFAULT '--------',
  `new_nombre` varchar(70) DEFAULT '--------',
  `old_id_gente` int(11) DEFAULT NULL,
  `old_paterno` varchar(70) DEFAULT '--------',
  `old_materno` varchar(70) DEFAULT '--------',
  `old_nombre` varchar(70) DEFAULT '--------'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_gente`
--

INSERT INTO `audita_gente` (`operacion`, `usuario`, `fecha`, `new_id_gente`, `new_paterno`, `new_materno`, `new_nombre`, `old_id_gente`, `old_paterno`, `old_materno`, `old_nombre`) VALUES
('Insertar', 'root@localhost', '2022-01-05 21:22:00', 1, 'Ramirez', 'Perez', 'Abigail', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-05 21:22:00', 2, 'Ayala', 'Gomez', 'Karen', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-05 21:22:00', 3, 'Rodriguez', 'Navarrete', 'Daniela', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-05 21:22:00', 4, 'Gomez', 'Olivarez ', 'Luis', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-05 21:22:00', 5, 'Galindo', 'Aguirre', 'Ricardo', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-06 17:07:04', 6, 'Hernandez', 'Cabrera', 'Fransisco', NULL, '--------', '--------', '--------'),
('Eliminado', 'root@localhost', '2022-01-06 17:07:14', NULL, '--------', '--------', '--------', 6, 'Hernandez', 'Cabrera', 'Fransisco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_lugar`
--

CREATE TABLE `audita_lugar` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_lugar` int(11) DEFAULT NULL,
  `new_descripcion` varchar(70) DEFAULT '--------',
  `old_id_lugar` int(11) DEFAULT NULL,
  `old_descripcion` varchar(70) DEFAULT '--------'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_lugar`
--

INSERT INTO `audita_lugar` (`operacion`, `usuario`, `fecha`, `new_id_lugar`, `new_descripcion`, `old_id_lugar`, `old_descripcion`) VALUES
('Insertar', 'root@localhost', '2022-01-05 19:47:45', 1, 'Oficina del ministerio p?blico Neza', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-05 19:47:45', 2, 'Oficina del ministerio p?blico Chimalhuacan', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-05 19:47:45', 3, 'Oficina del ministerio p?blico Los reyes ', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-05 19:47:45', 4, 'Oficina del ministerio p?blico Chalco', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-05 19:47:45', 5, 'Oficina del ministerio p?blico Xochimilco ', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-05 19:47:45', 6, 'Oficina del ministerio p?blico CDMX', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:27:37', 1, 'Oficina del ministerio publico Neza', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:27:37', 2, 'Oficina del ministerio publico Chimalhuacan', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:27:37', 3, 'Oficina del ministerio publico Los reyes ', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:27:37', 4, 'Oficina del ministerio publico Chalco', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:27:37', 5, 'Oficina del ministerio publico Xochimilco ', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:27:37', 6, 'Oficina del ministerio publico CDMX', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 19:45:47', 7, 'Oficinas Toluca', NULL, '--------');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_persona`
--

CREATE TABLE `audita_persona` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_demandado` int(11) DEFAULT NULL,
  `new_paterno` varchar(50) DEFAULT '--------',
  `new_materno` varchar(50) DEFAULT '--------',
  `new_nombre` varchar(50) DEFAULT '--------',
  `old_id_demandado` int(11) DEFAULT NULL,
  `old_paterno` varchar(50) DEFAULT '--------',
  `old_materno` varchar(50) DEFAULT '--------',
  `old_nombre` varchar(50) DEFAULT '--------'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_persona`
--

INSERT INTO `audita_persona` (`operacion`, `usuario`, `fecha`, `new_id_demandado`, `new_paterno`, `new_materno`, `new_nombre`, `old_id_demandado`, `old_paterno`, `old_materno`, `old_nombre`) VALUES
('Insertar', 'root@localhost', '2022-01-04 19:00:10', 1, 'Hernandez', 'Monterrosa', 'Adriana Carolina', NULL, '--------', '--------', '--------'),
('Eliminado', 'root@localhost', '2022-01-05 20:05:49', NULL, '--------', '--------', '--------', 1, 'Hernandez', 'Monterrosa', 'Adriana Carolina'),
('Insertar', 'root@localhost', '2022-01-05 23:09:19', 4, 'Martinez', 'Hernandez', 'Josias', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:19:09', 1, 'Acosta', 'Torres', 'Laura Susana', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:19:09', 2, 'Aguayo', 'Gonzalez', 'Alvaro', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:19:09', 3, 'Aguilar', 'Navarro', 'Sara Gloria', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:19:09', 4, 'Aguirre', 'Cruz', 'Carlos Alberto', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:19:09', 5, 'Almeda', ' Valdes', 'Jose Alvaro', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:19:09', 6, 'Alvarado', 'Cabrero', 'Maria Lucinda', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:19:09', 7, 'Alvarez', 'Cordero', 'Jesus', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:19:09', 8, '?ngeles', 'Angeles', 'Josefina Mar?a', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:19:09', 9, 'Araico', 'Laguillo', 'Maria Dolores ', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:19:09', 10, 'Arcila', 'Herrera', 'Manuel', NULL, '--------', '--------', '--------'),
('Insertar', 'root@localhost', '2022-01-06 22:41:06', 11, 'Martinez', 'Martinez', 'Oseas', NULL, '--------', '--------', '--------');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_prefiere`
--

CREATE TABLE `audita_prefiere` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_abogado` int(11) DEFAULT NULL,
  `new_id_tipo_asu` int(11) DEFAULT NULL,
  `old_id_abogado` int(11) DEFAULT NULL,
  `old_id_tipo_asu` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_prefiere`
--

INSERT INTO `audita_prefiere` (`operacion`, `usuario`, `fecha`, `new_id_abogado`, `new_id_tipo_asu`, `old_id_abogado`, `old_id_tipo_asu`) VALUES
('Insertar', 'root@localhost', '2022-01-06 20:27:22', 1, 5, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 20:27:22', 2, 4, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 20:27:22', 3, 3, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 20:27:22', 4, 7, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 20:27:22', 5, 5, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 20:27:22', 6, 1, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 20:27:22', 7, 3, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 20:27:22', 8, 2, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 20:27:22', 9, 8, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 20:27:22', 10, 9, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 21:10:12', 10, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_telefono`
--

CREATE TABLE `audita_telefono` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_contacto` int(11) DEFAULT NULL,
  `new_numero` int(11) DEFAULT NULL,
  `old_id_contacto` int(11) DEFAULT NULL,
  `old_numero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_telefono`
--

INSERT INTO `audita_telefono` (`operacion`, `usuario`, `fecha`, `new_id_contacto`, `new_numero`, `old_id_contacto`, `old_numero`) VALUES
('Insertar', 'root@localhost', '2022-01-05 01:03:20', 7, 74539746, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 21:45:38', 2, 2147483647, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 21:45:38', 3, 2147483647, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 21:45:38', 4, 2147483647, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 21:45:38', 5, 2147483647, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 21:45:38', 6, 2147483647, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 21:45:38', 7, 2147483647, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 21:45:38', 8, 2147483647, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 21:45:38', 9, 2147483647, NULL, NULL),
('Insertar', 'root@localhost', '2022-01-06 21:45:38', 10, 2147483647, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_tipo`
--

CREATE TABLE `audita_tipo` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_tipo` int(11) DEFAULT NULL,
  `new_descripcion` varchar(50) DEFAULT '--------',
  `old_id_tipo` int(11) DEFAULT NULL,
  `old_descripcion` varchar(50) DEFAULT '--------'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_tipo_asunto`
--

CREATE TABLE `audita_tipo_asunto` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_tipo_asunto` int(11) DEFAULT NULL,
  `new_descripcion` varchar(70) DEFAULT '--------',
  `old_id_tipo_asunto` int(11) DEFAULT NULL,
  `old_descripcion` varchar(70) DEFAULT '--------'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `audita_tipo_asunto`
--

INSERT INTO `audita_tipo_asunto` (`operacion`, `usuario`, `fecha`, `new_id_tipo_asunto`, `new_descripcion`, `old_id_tipo_asunto`, `old_descripcion`) VALUES
('Insertar', 'root@localhost', '2022-01-06 16:21:56', 1, 'Juicios laborales', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:21:56', 2, 'Asuntos penales Diversos', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:21:56', 3, 'Elaboracion de todo tipo de contrato', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:21:56', 4, 'Juicios para asuntos testamentarios o intestamentarios', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:21:56', 5, 'Cumplimientos de pensiones alimenticias', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:21:56', 6, 'Divorcios', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:21:56', 7, 'Regularizacion de propiedades', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:21:56', 8, 'Cobranzas de pagar?s y otros titulos de credito', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 16:21:56', 9, 'Controversias familiares ociviles de cualquier tipo', NULL, '--------'),
('Insertar', 'root@localhost', '2022-01-06 21:10:38', 10, 'Deudas', NULL, '--------');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `audita_tipo_medio`
--

CREATE TABLE `audita_tipo_medio` (
  `operacion` varchar(30) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `new_id_medio` int(11) DEFAULT NULL,
  `new_descripcion` varchar(50) DEFAULT '--------',
  `old_id_medio` int(11) DEFAULT NULL,
  `old_descripcion` varchar(50) DEFAULT '--------'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `paterno` varchar(50) DEFAULT NULL,
  `materno` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `CURP` varchar(50) DEFAULT NULL,
  `RFC` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `paterno`, `materno`, `nombre`, `CURP`, `RFC`) VALUES
(1, 'Hernandez', 'Monterrosa', 'Adriana Carolina', 'HEMA991201MDFRND05', 'HEMA991201'),
(2, 'Carvajal', ' Vargas', 'Alexander', 'CAVA950518HDFRRL12', 'CAVA950518'),
(3, 'Rodr?guez ', 'Botero', 'Camilo', 'ROBC870810HDFDTM25', 'ROBC870810'),
(4, 'Castiblanco ', 'Salgado', 'Daniel Andr?s', 'CASD850912HDFSLN02', 'CASD850912'),
(5, 'Lopez', ' Rodriguez', 'Diana carolina', 'LORD920515MDFPDN08', 'LORD920515'),
(6, 'Camargo', ' Vargas', 'Hugo andr?s', 'CAVH820130HDFMRG28', 'CAVH820130'),
(7, 'Marin', ' Zubieta', 'Jose Guillermo', 'MAZJ860218HDFRBS15', 'MAZJ860218'),
(8, 'Nieto', ' Bustos', 'Maria Camila', 'NIBM950728MDFTSR03', 'NIBM950728'),
(9, 'Perez', ' Moreno', 'Maria Margarita', 'PEMM880524MDFRRR09', 'PEMM880524'),
(10, 'Castellanos', ' Rojas', 'Oscar Fabian', 'CARO890830HDFSJS10', 'CARO890830'),
(11, 'Garcia', 'Silverio', 'Esther', 'GSIEGTEDMMLIV', 'SIEGTYDVGJD34'),
(12, 'Garcia', 'Silverio', 'Alberto', 'ABSEGTEDMMLIV', 'ABSGTYDVGJD34');

--
-- Disparadores `cliente`
--
DELIMITER $$
CREATE TRIGGER `cliente_actualiza` AFTER UPDATE ON `cliente` FOR EACH ROW BEGIN
INSERT INTO audita_cliente(operacion, usuario, fecha, new_id_cliente, new_paterno, new_materno, new_nombre, new_CURP, new_RFC )
VALUES ('Actualizado', current_user(), now(), new.id_cliente, new.paterno, new.materno, new.nombre, new.CURP, new.RFC, old.id_cliente, old.paterno, old.materno,  old.nombre, old.CURP, old.RFC);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `cliente_elimina` AFTER DELETE ON `cliente` FOR EACH ROW BEGIN
INSERT INTO audita_cliente (operacion, usuario, fecha, old_id_cliente, old_paterno, old_materno,  old_nombre, old_CURP, old_RFC)
VALUES ('Eliminado', current_user(), now(), old.id_cliente, old.paterno, old.materno,  old.nombre, old.CURP, old.RFC);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `cliente_inserta` AFTER INSERT ON `cliente` FOR EACH ROW BEGIN
INSERT INTO audita_cliente (operacion, usuario, fecha, new_id_cliente, new_paterno, new_materno, new_nombre, new_CURP, new_RFC )
VALUES ('insertar', current_user(), now(), new.id_cliente, new.paterno, new.materno, new.nombre, new.CURP, new.RFC );
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto`
--

CREATE TABLE `contacto` (
  `id_contacto` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `contacto`
--

INSERT INTO `contacto` (`id_contacto`, `id_cliente`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12);

--
-- Disparadores `contacto`
--
DELIMITER $$
CREATE TRIGGER `contacto_actualiza` AFTER UPDATE ON `contacto` FOR EACH ROW BEGIN
INSERT INTO audita_contacto(operacion, usuario, fecha,  new_id_contacto,  new_id_cliente,  old_id_contacto, old_id_cliente)
VALUES ('Actualizado', current_user(), now(), new.id_contacto,  new.id_cliente,  old.id_contacto, old.id_cliente);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `contacto_elimina` AFTER DELETE ON `contacto` FOR EACH ROW BEGIN
INSERT INTO audita_contacto (operacion, usuario, fecha, old_id_contacto, old_id_cliente) 
VALUES ('Eliminado', current_user(), now(), old.id_contacto, old.id_cliente);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `contacto_inserta` AFTER INSERT ON `contacto` FOR EACH ROW BEGIN
INSERT INTO audita_contacto (operacion, usuario, fecha,  new_id_contacto,  new_id_cliente)
VALUES ('insertar', current_user(), now(), new.id_contacto,  new.id_cliente);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `correo`
--

CREATE TABLE `correo` (
  `id_contacto` int(11) DEFAULT NULL,
  `cuenta` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `correo`
--

INSERT INTO `correo` (`id_contacto`, `cuenta`) VALUES
(1, 'hernan_adriana@gmail.com'),
(2, 'varga_alex@gmail.com'),
(3, 'rodriguez_bo_cam@gmail.com'),
(4, 'salga_dani@gmail.com'),
(5, 'diana_perez@gmail.com'),
(6, 'hugo_andres_vargas@gmail.com'),
(7, 'joss_marin_@gmail.com'),
(8, 'mari.nieto@gmail.com'),
(9, 'moreno.mar_perez@gmail.com'),
(10, 'castellano_oscar@gmail.com'),
(11, 'esther_mtx@gmail.com'),
(12, '');

--
-- Disparadores `correo`
--
DELIMITER $$
CREATE TRIGGER `correo_actualiza` AFTER UPDATE ON `correo` FOR EACH ROW BEGIN
INSERT INTO audita_correo(operacion, usuario, fecha, new_id_contacto, new_cuenta, old_id_contacto, old_cuenta)
VALUES ('Actualizado', current_user(), now(), new.id_contacto, new.cuenta, old.id_contacto, old.cuenta);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `correo_elimina` AFTER DELETE ON `correo` FOR EACH ROW BEGIN
INSERT INTO audita_correo(operacion, usuario, fecha,  old_id_contacto, old_cuenta)
VALUES ('Eliminado', current_user(), now(),  old.id_contacto, old.cuenta);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `correo_inserta` AFTER INSERT ON `correo` FOR EACH ROW BEGIN
INSERT INTO audita_correo (operacion, usuario, fecha, new_id_contacto, new_cuenta)
VALUES ('insertar', current_user(), now(), new.id_contacto, new.cuenta);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `demandado`
--

CREATE TABLE `demandado` (
  `id_demandado` int(11) NOT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `id_tipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `demandado`
--

INSERT INTO `demandado` (`id_demandado`, `direccion`, `id_tipo`) VALUES
(1, 'calle huanacatl mz29 lt 15 barrio herreros', 1),
(2, 'calle azul mz 23 lt 67 barrio carpintero', 1),
(3, 'calle benito juarez mz 23 lt 15 venustiano carranza', 3),
(4, 'calle vicente mz 30 lt 34  san juan ', 5),
(5, 'calle pajaro mz12 lt 56 san pedro', 5),
(6, 'calle tomacatli mz 15 lt 76  san miguel', 3),
(7, 'calle manzano mz 16 lt 43 castillo', 2),
(8, 'calle san miguel mz30 lt 87  aragon', 3),
(9, 'calle  sor juana mz 23 lt 45   vicente', 4),
(10, 'calle tetocani mz 12 lt 15 herreros', 5),
(11, 'C Azucena Mz 29 Lt 3', 3);

--
-- Disparadores `demandado`
--
DELIMITER $$
CREATE TRIGGER `demandado_actualiza` AFTER UPDATE ON `demandado` FOR EACH ROW BEGIN
INSERT INTO audita_demandado(operacion, usuario, fecha,  new_id_demandado, new_direccion, new_id_tipo,  old_id_demandado, old_direccion,  old_id_tipo)
VALUES ('Actualizado', current_user(), now(), new.id_demandado, new.direccion, new.id_tipo, old.id_demandado, old.direccion,  old.id_tipo);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `demandado_elimina` AFTER DELETE ON `demandado` FOR EACH ROW BEGIN
INSERT INTO audita_demandado(operacion, usuario, fecha,  old_id_demandado, old_direccion,  old_id_tipo)
VALUES ('Eliminado', current_user(), now(),  old.id_demandado, old.direccion,  old.id_tipo);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `demandado_inserta` AFTER INSERT ON `demandado` FOR EACH ROW BEGIN
INSERT INTO audita_demandado (operacion, usuario, fecha,  new_id_demandado, new_direccion, new_id_tipo)
VALUES ('insertar', current_user(), now(), new.id_demandado, new.direccion, new.id_tipo);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `id_demandado` int(11) DEFAULT NULL,
  `razon_social` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`id_demandado`, `razon_social`) VALUES
(4, 'Banamex'),
(5, 'Coca cola'),
(7, 'Bimbo'),
(8, 'Uber '),
(10, 'Cinemex'),
(1, ' '),
(2, '  '),
(3, '  '),
(6, '  '),
(9, ' '),
(11, '');

--
-- Disparadores `empresa`
--
DELIMITER $$
CREATE TRIGGER `empresa_actualiza` AFTER UPDATE ON `empresa` FOR EACH ROW BEGIN
INSERT INTO audita_empresa(operacion, usuario, fecha, new_id_demandado, new_razon_social, old_id_demandado, old_razon_social)  
VALUES ('Actualizado', current_user(), now(), new.id_demandado, new.razon_social, old.id_demandado, old.razon_social); 
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `empresa_elimina` AFTER DELETE ON `empresa` FOR EACH ROW BEGIN
INSERT INTO audita_empresa(operacion, usuario, fecha,  old_id_demandado, old_razon_social)
VALUES ('Eliminado', current_user(), now(), old.id_demandado, old.razon_social); 
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `empresa_inserta` AFTER INSERT ON `empresa` FOR EACH ROW BEGIN
INSERT INTO audita_empresa (operacion, usuario, fecha,  new_id_demandado, new_razon_social)
VALUES ('insertar', current_user(), now(), new.id_demandado, new.razon_social);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `id_estado` int(11) NOT NULL,
  `descripcion` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id_estado`, `descripcion`) VALUES
(2, 'Archivado'),
(1, 'En tramite'),
(3, 'Tranferido');

--
-- Disparadores `estado`
--
DELIMITER $$
CREATE TRIGGER `estado_actualiza` AFTER UPDATE ON `estado` FOR EACH ROW BEGIN
INSERT INTO audita_estado(operacion, usuario, fecha,  new_id_estado,  new_descripcion, old_id_estado,  old_descripcion)
VALUES ('Actualizado', current_user(), now(), new.id_estado,  new.descripcion, old.id_estado,  old.descripcion);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `estado_elimina` AFTER DELETE ON `estado` FOR EACH ROW BEGIN
INSERT INTO audita_estado(operacion, usuario, fecha, old_id_estado,  old_descripcion) 
VALUES ('Eliminado', current_user(), now(),  old.id_estado,  old.descripcion);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `estado_inserta` AFTER INSERT ON `estado` FOR EACH ROW BEGIN
INSERT INTO audita_estado(operacion, usuario, fecha,  new_id_estado,  new_descripcion)
                VALUES ('Insertar', current_user(), now(), new.id_estado,  new.descripcion);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudio`
--

CREATE TABLE `estudio` (
  `id_grado` int(11) NOT NULL,
  `descripcion` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estudio`
--

INSERT INTO `estudio` (`id_grado`, `descripcion`) VALUES
(3, 'Doctorado'),
(2, 'Maestria'),
(4, 'Posgrado'),
(1, 'Universidad');

--
-- Disparadores `estudio`
--
DELIMITER $$
CREATE TRIGGER `estudio_actualiza` AFTER UPDATE ON `estudio` FOR EACH ROW BEGIN
INSERT INTO audita_estudio(operacion, usuario, fecha, new_id_grado,  new_descripcion,  old_id_grado,  old_descripcion)
VALUES ('Actualizado', current_user(), now(),  new.id_grado,  new.descripcion, old.id_grado,  old.descripcion);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `estudio_elimina` AFTER DELETE ON `estudio` FOR EACH ROW BEGIN
INSERT INTO audita_estudio(operacion, usuario, fecha, old_id_grado,  old_descripcion)
VALUES ('Eliminado', current_user(), now(), old.id_grado,  old.descripcion);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `estudio_inserta` AFTER INSERT ON `estudio` FOR EACH ROW BEGIN
INSERT INTO audita_estudio(operacion, usuario, fecha,   new_id_grado,  new_descripcion)
                VALUES ('Insertar', current_user(), now(), new.id_grado,  new.descripcion);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facebook`
--

CREATE TABLE `facebook` (
  `id_contacto` int(11) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `facebook`
--

INSERT INTO `facebook` (`id_contacto`, `usuario`) VALUES
(1, 'Adriana Hernandez'),
(2, 'Alex Vargas'),
(3, 'Camilo Rodr?guez '),
(4, 'Dani Salgado'),
(5, 'Carolina Lopez '),
(6, 'Camargo  Vargas'),
(7, 'Guillermo Zubieta'),
(8, 'Maria Bustos'),
(9, 'Mari Moreno'),
(10, 'Oscar Rojas'),
(11, ''),
(12, 'Albert Mtz');

--
-- Disparadores `facebook`
--
DELIMITER $$
CREATE TRIGGER `facebook_actualiza` AFTER UPDATE ON `facebook` FOR EACH ROW BEGIN
INSERT INTO audita_facebook(operacion, usuario, fecha, new_id_contacto,  new_usuario, old_id_contacto,  old_usuario)
VALUES ('Actualizado', current_user(), now(), new.id_contacto,  new.usuario, old.id_contacto,  old.usuario);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `facebook_elimina` AFTER DELETE ON `facebook` FOR EACH ROW BEGIN
INSERT INTO audita_facebook(operacion, usuario, fecha, old_id_contacto,  old_usuario)
VALUES ('Eliminado', current_user(), now(), old.id_contacto,  old.usuario);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `facebook_inserta` AFTER INSERT ON `facebook` FOR EACH ROW BEGIN
INSERT INTO audita_facebook(operacion, usuario, fecha,  new_id_contacto,  new_usuario)
                VALUES ('Insertar', current_user(), now(),  new.id_contacto,  new.usuario);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gente`
--

CREATE TABLE `gente` (
  `id_gente` int(11) NOT NULL,
  `paterno` varchar(70) DEFAULT NULL,
  `materno` varchar(70) DEFAULT NULL,
  `nombre` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `gente`
--

INSERT INTO `gente` (`id_gente`, `paterno`, `materno`, `nombre`) VALUES
(1, 'Ramirez', 'Perez', 'Abigail'),
(2, 'Ayala', 'Gomez', 'Karen'),
(3, 'Rodriguez', 'Navarrete', 'Daniela'),
(4, 'Gomez', 'Olivarez ', 'Luis'),
(5, 'Galindo', 'Aguirre', 'Ricardo');

--
-- Disparadores `gente`
--
DELIMITER $$
CREATE TRIGGER `gente_actualizar` AFTER UPDATE ON `gente` FOR EACH ROW BEGIN
INSERT INTO audita_gente(operacion, usuario, fecha, ew_id_gente,  new_paterno, new_materno, new_nombre,old_id_gente, old_paterno ,old_materno,  old_nombre)
VALUES ('Actualizado', current_user(), now(), new.id_gente,  new.paterno, new.materno,  new.nombre,old.id_gente, old.paterno ,old.materno,  old.nombre);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `gente_elimina` AFTER DELETE ON `gente` FOR EACH ROW BEGIN
INSERT INTO audita_gente(operacion, usuario, fecha, old_id_gente, old_paterno ,old_materno,  old_nombre)
VALUES ('Eliminado', current_user(), now(),  old.id_gente, old.paterno,old.materno,  old.nombre);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `gente_inserta` AFTER INSERT ON `gente` FOR EACH ROW BEGIN
INSERT INTO audita_gente(operacion, usuario, fecha, new_id_gente,  new_paterno, new_materno,    new_nombre)
                VALUES ('Insertar', current_user(), now(), new.id_gente,  new.paterno, new.materno,    new.nombre);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugar`
--

CREATE TABLE `lugar` (
  `id_lugar` int(11) NOT NULL,
  `descripcion` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lugar`
--

INSERT INTO `lugar` (`id_lugar`, `descripcion`) VALUES
(6, 'Oficina del ministerio publico CDMX'),
(4, 'Oficina del ministerio publico Chalco'),
(2, 'Oficina del ministerio publico Chimalhuacan'),
(3, 'Oficina del ministerio publico Los reyes '),
(1, 'Oficina del ministerio publico Neza'),
(5, 'Oficina del ministerio publico Xochimilco '),
(7, 'Oficinas Toluca');

--
-- Disparadores `lugar`
--
DELIMITER $$
CREATE TRIGGER `lugar_actualizar` AFTER UPDATE ON `lugar` FOR EACH ROW BEGIN
INSERT INTO audita_lugar(operacion, usuario, fecha, new_id_lugar,  new_descripcion,  old_id_lugar,  old_descripcion)
VALUES ('Actualizado', current_user(), now(),  new.id_lugar,  new.descripcion, old.id_lugar,  old.descripcion);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `lugar_eliminar` AFTER DELETE ON `lugar` FOR EACH ROW BEGIN
INSERT INTO audita_lugar(operacion, usuario, fecha, old_id_lugar,  old_descripcion)
VALUES ('Eliminado', current_user(), now(), old.id_lugar,  old.descripcion);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `lugar_insertar` AFTER INSERT ON `lugar` FOR EACH ROW BEGIN
INSERT INTO audita_lugar(operacion, usuario, fecha,   new_id_lugar,  new_descripcion)
                VALUES ('Insertar', current_user(), now(), new.id_lugar,  new.descripcion);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participan`
--

CREATE TABLE `participan` (
  `id_audiencia` int(11) DEFAULT NULL,
  `id_gente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `participan`
--

INSERT INTO `participan` (`id_audiencia`, `id_gente`) VALUES
(1, 3),
(3, 1),
(4, 5),
(2, 2),
(3, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id_demandado` int(11) DEFAULT NULL,
  `paterno` varchar(50) DEFAULT NULL,
  `materno` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id_demandado`, `paterno`, `materno`, `nombre`) VALUES
(1, 'Acosta', 'Torres', 'Laura Susana'),
(2, 'Aguayo', 'Gonzalez', 'Alvaro'),
(3, 'Aguilar', 'Navarro', 'Sara Gloria'),
(4, 'Aguirre', 'Cruz', 'Carlos Alberto'),
(5, 'Almeda', ' Valdes', 'Jose Alvaro'),
(6, 'Alvarado', 'Cabrero', 'Maria Lucinda'),
(7, 'Alvarez', 'Cordero', 'Jesus'),
(8, '?ngeles', 'Angeles', 'Josefina Mar?a'),
(9, 'Araico', 'Laguillo', 'Maria Dolores '),
(10, 'Arcila', 'Herrera', 'Manuel'),
(11, 'Martinez', 'Martinez', 'Oseas');

--
-- Disparadores `persona`
--
DELIMITER $$
CREATE TRIGGER `persona_actualizar` AFTER UPDATE ON `persona` FOR EACH ROW BEGIN
INSERT INTO audita_persona (operacion, usuario, fecha, new_id_demandado, new_paterno, new_materno, new_nombre, old_id_demandado, old_paterno, old_materno, old_nombre)
VALUES ('Actualizado', current_user(), now(), new.id_demandado, new.paterno, new.materno, new.nombre,old.id_demandado, old.paterno, old.materno, old.nombre);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `persona_eliminar` AFTER DELETE ON `persona` FOR EACH ROW BEGIN
INSERT INTO audita_persona (operacion, usuario, fecha,  old_id_demandado, old_paterno, old_materno, old_nombre)
VALUES ('Eliminado', current_user(), now(),  old.id_demandado, old.paterno, old.materno, old.nombre);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `persona_insertar` AFTER INSERT ON `persona` FOR EACH ROW BEGIN
INSERT INTO audita_persona (operacion, usuario, fecha, new_id_demandado, new_paterno, new_materno, new_nombre)
                VALUES ('Insertar', current_user(), now(),new.id_demandado, new.paterno, new.materno, new.nombre);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prefiere`
--

CREATE TABLE `prefiere` (
  `id_abogado` int(11) DEFAULT NULL,
  `id_tipo_asu` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prefiere`
--

INSERT INTO `prefiere` (`id_abogado`, `id_tipo_asu`) VALUES
(1, 5),
(2, 4),
(3, 3),
(4, 7),
(5, 5),
(6, 1),
(7, 3),
(8, 2),
(9, 8),
(10, 9),
(10, 2);

--
-- Disparadores `prefiere`
--
DELIMITER $$
CREATE TRIGGER `prefiere_actualizar` AFTER UPDATE ON `prefiere` FOR EACH ROW BEGIN
INSERT INTO audita_prefiere (operacion, usuario, fecha,  new_id_abogado,  new_id_tipo_asu,old_id_abogado,  old_id_tipo_asu)
VALUES ('Actualizado', current_user(), now(),new.id_abogado,  new.id_tipo_asu, old.id_abogado, old.id_tipo_asu);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `prefiere_eliminar` AFTER DELETE ON `prefiere` FOR EACH ROW BEGIN
INSERT INTO audita_prefiere(operacion, usuario, fecha,  old_id_abogado,  old_id_tipo_asu)
VALUES ('Eliminado', current_user(), now(),  old.id_abogado,  old.id_tipo_asu);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `prefiere_insertar` AFTER INSERT ON `prefiere` FOR EACH ROW BEGIN
INSERT INTO audita_prefiere (operacion, usuario, fecha,  new_id_abogado,  new_id_tipo_asu)
                VALUES ('Insertar', current_user(), now(),new.id_abogado,  new.id_tipo_asu);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefono`
--

CREATE TABLE `telefono` (
  `id_contacto` int(11) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `telefono`
--

INSERT INTO `telefono` (`id_contacto`, `numero`) VALUES
(1, '5522325324'),
(2, '5527335424'),
(3, '5564665425'),
(4, '5626755426'),
(5, '5522395427'),
(6, '5522835428'),
(7, '5534343429'),
(8, '5529534330'),
(9, '5524055401'),
(10, '551035432'),
(11, '545035432'),
(12, '551000432');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `id_tipo` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo`
--

INSERT INTO `tipo` (`id_tipo`, `descripcion`) VALUES
(4, 'Asalto'),
(2, 'Corrupcion'),
(3, 'Estafa'),
(5, 'Fuga'),
(1, 'Pension');

--
-- Disparadores `tipo`
--
DELIMITER $$
CREATE TRIGGER `tipo_actualizar` AFTER UPDATE ON `tipo` FOR EACH ROW BEGIN
INSERT INTO audita_tipo (operacion, usuario, fecha,  new_id_tipo,new_descripcion, old_id_tipo, old_descripcion)
VALUES ('Actualizado', current_user(), now(),new.id_tipo,new.descripcion,old.id_tipo, old.descripcion);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tipo_eliminar` AFTER DELETE ON `tipo` FOR EACH ROW BEGIN
INSERT INTO audita_tipo(operacion, usuario, fecha, old_id_tipo, old_descripcion)
VALUES ('Eliminado', current_user(), now(), old.id_tipo, old.descripcion);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tipo_insertar` AFTER INSERT ON `tipo` FOR EACH ROW BEGIN
INSERT INTO audita_tipo (operacion, usuario, fecha,  new_id_tipo,new_descripcion)
                VALUES ('Insertar', current_user(), now(), new.id_tipo,new.descripcion);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_asunto`
--

CREATE TABLE `tipo_asunto` (
  `id_tipo_asunto` int(11) NOT NULL,
  `descripcion` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_asunto`
--

INSERT INTO `tipo_asunto` (`id_tipo_asunto`, `descripcion`) VALUES
(2, 'Asuntos penales Diversos'),
(8, 'Cobranzas de pagar?s y otros titulos de credito'),
(9, 'Controversias familiares ociviles de cualquier tipo'),
(5, 'Cumplimientos de pensiones alimenticias'),
(10, 'Deudas'),
(6, 'Divorcios'),
(3, 'Elaboracion de todo tipo de contrato'),
(1, 'Juicios laborales'),
(4, 'Juicios para asuntos testamentarios o intestamentarios'),
(7, 'Regularizacion de propiedades');

--
-- Disparadores `tipo_asunto`
--
DELIMITER $$
CREATE TRIGGER `tipo_asunto_actualizar` AFTER UPDATE ON `tipo_asunto` FOR EACH ROW BEGIN
INSERT INTO audita_tipo_asunto (operacion, usuario, fecha,  new_id_tipo_asunto,new_descripcion, old_id_tipo_asunto, old_descripcion)
VALUES ('Actualizado', current_user(), now(),new.id_tipo_asunto, new.descripcion, old.id_tipo_asunto, old.descripcion);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tipo_asunto_eliminar` AFTER DELETE ON `tipo_asunto` FOR EACH ROW BEGIN
INSERT INTO audita_tipo_asunto(operacion, usuario, fecha, old_id_tipo_asunto, old_descripcion)
VALUES ('Eliminado', current_user(), now(), old.id_tipo_asunto, old.descripcion);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tipo_asunto_insertar` AFTER INSERT ON `tipo_asunto` FOR EACH ROW BEGIN
INSERT INTO audita_tipo_asunto (operacion, usuario, fecha,  new_id_tipo_asunto,new_descripcion)
                VALUES ('Insertar', current_user(), now(), new.id_tipo_asunto,new.descripcion);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_medio`
--

CREATE TABLE `tipo_medio` (
  `id_medio` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Disparadores `tipo_medio`
--
DELIMITER $$
CREATE TRIGGER `tipo_medio_actualizar` AFTER UPDATE ON `tipo_medio` FOR EACH ROW BEGIN
INSERT INTO audita_tipo_medio (operacion, usuario, fecha,  new_id_medio,new_descripcion, old_id_medio, old_descripcion)
VALUES ('Actualizado', current_user(), now(),new.id_medio,new.descripcion,old.id_medio, old.descripcion);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tipo_medio_eliminar` AFTER DELETE ON `tipo_medio` FOR EACH ROW BEGIN
INSERT INTO audita_tipo_medio(operacion, usuario, fecha, old_id__medio, old_descripcion)
VALUES ('Eliminado', current_user(), now(), old.id_medio, old.descripcion);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tipo_medio_insertar` AFTER INSERT ON `tipo_medio` FOR EACH ROW BEGIN
INSERT INTO audita_tipo_medio (operacion, usuario, fecha,  new_id_medio,new_descripcion)
                VALUES ('Insertar', current_user(), now(), new.id_medio,new.descripcion);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `n_usuario` varchar(50) DEFAULT NULL,
  `u_password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `n_usuario`, `u_password`) VALUES
(1, 'JaredAg', '241101'),
(2, 'JimT', '1234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `abogado`
--
ALTER TABLE `abogado`
  ADD PRIMARY KEY (`id_abogado`),
  ADD UNIQUE KEY `RFC` (`RFC`),
  ADD KEY `id_grado` (`id_grado`);

--
-- Indices de la tabla `asesora`
--
ALTER TABLE `asesora`
  ADD PRIMARY KEY (`id_asesoria`),
  ADD KEY `id_asunto` (`id_asunto`),
  ADD KEY `asesor` (`asesor`),
  ADD KEY `asesorado` (`asesorado`);

--
-- Indices de la tabla `asunto`
--
ALTER TABLE `asunto`
  ADD PRIMARY KEY (`id_asunto`),
  ADD KEY `id_abogado` (`id_abogado`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_demandado` (`id_demandado`),
  ADD KEY `id_estado` (`id_estado`),
  ADD KEY `id_tipo_asu` (`id_tipo_asu`);

--
-- Indices de la tabla `audiencia`
--
ALTER TABLE `audiencia`
  ADD PRIMARY KEY (`id_audiencia`),
  ADD KEY `id_asunto` (`id_asunto`),
  ADD KEY `id_lugar` (`id_lugar`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `CURP` (`CURP`),
  ADD UNIQUE KEY `RFC` (`RFC`);

--
-- Indices de la tabla `contacto`
--
ALTER TABLE `contacto`
  ADD PRIMARY KEY (`id_contacto`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `correo`
--
ALTER TABLE `correo`
  ADD UNIQUE KEY `cuenta` (`cuenta`),
  ADD KEY `id_contacto` (`id_contacto`);

--
-- Indices de la tabla `demandado`
--
ALTER TABLE `demandado`
  ADD PRIMARY KEY (`id_demandado`),
  ADD UNIQUE KEY `direccion` (`direccion`),
  ADD KEY `id_tipo` (`id_tipo`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD KEY `id_demandado` (`id_demandado`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id_estado`),
  ADD UNIQUE KEY `descripcion` (`descripcion`);

--
-- Indices de la tabla `estudio`
--
ALTER TABLE `estudio`
  ADD PRIMARY KEY (`id_grado`),
  ADD UNIQUE KEY `descripcion` (`descripcion`);

--
-- Indices de la tabla `facebook`
--
ALTER TABLE `facebook`
  ADD UNIQUE KEY `usuario` (`usuario`),
  ADD KEY `id_contacto` (`id_contacto`);

--
-- Indices de la tabla `gente`
--
ALTER TABLE `gente`
  ADD PRIMARY KEY (`id_gente`);

--
-- Indices de la tabla `lugar`
--
ALTER TABLE `lugar`
  ADD PRIMARY KEY (`id_lugar`),
  ADD UNIQUE KEY `descripcion` (`descripcion`);

--
-- Indices de la tabla `participan`
--
ALTER TABLE `participan`
  ADD KEY `id_audiencia` (`id_audiencia`),
  ADD KEY `id_gente` (`id_gente`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD KEY `id_demandado` (`id_demandado`);

--
-- Indices de la tabla `prefiere`
--
ALTER TABLE `prefiere`
  ADD KEY `id_abogado` (`id_abogado`),
  ADD KEY `id_abogado_2` (`id_abogado`),
  ADD KEY `id_tipo_asu` (`id_tipo_asu`);

--
-- Indices de la tabla `telefono`
--
ALTER TABLE `telefono`
  ADD UNIQUE KEY `numero` (`numero`),
  ADD KEY `id_contacto` (`id_contacto`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`id_tipo`),
  ADD UNIQUE KEY `descripcion` (`descripcion`);

--
-- Indices de la tabla `tipo_asunto`
--
ALTER TABLE `tipo_asunto`
  ADD PRIMARY KEY (`id_tipo_asunto`),
  ADD UNIQUE KEY `descripcion` (`descripcion`);

--
-- Indices de la tabla `tipo_medio`
--
ALTER TABLE `tipo_medio`
  ADD PRIMARY KEY (`id_medio`),
  ADD UNIQUE KEY `descripcion` (`descripcion`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `abogado`
--
ALTER TABLE `abogado`
  MODIFY `id_abogado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `asesora`
--
ALTER TABLE `asesora`
  MODIFY `id_asesoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `asunto`
--
ALTER TABLE `asunto`
  MODIFY `id_asunto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `audiencia`
--
ALTER TABLE `audiencia`
  MODIFY `id_audiencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `contacto`
--
ALTER TABLE `contacto`
  MODIFY `id_contacto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `demandado`
--
ALTER TABLE `demandado`
  MODIFY `id_demandado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `id_estado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `estudio`
--
ALTER TABLE `estudio`
  MODIFY `id_grado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `gente`
--
ALTER TABLE `gente`
  MODIFY `id_gente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `lugar`
--
ALTER TABLE `lugar`
  MODIFY `id_lugar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tipo_asunto`
--
ALTER TABLE `tipo_asunto`
  MODIFY `id_tipo_asunto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `tipo_medio`
--
ALTER TABLE `tipo_medio`
  MODIFY `id_medio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `abogado`
--
ALTER TABLE `abogado`
  ADD CONSTRAINT `abogado_ibfk_1` FOREIGN KEY (`id_grado`) REFERENCES `estudio` (`id_grado`);

--
-- Filtros para la tabla `asesora`
--
ALTER TABLE `asesora`
  ADD CONSTRAINT `asesora_ibfk_1` FOREIGN KEY (`id_asunto`) REFERENCES `asunto` (`id_asunto`),
  ADD CONSTRAINT `asesora_ibfk_2` FOREIGN KEY (`asesor`) REFERENCES `abogado` (`id_abogado`),
  ADD CONSTRAINT `asesora_ibfk_3` FOREIGN KEY (`asesorado`) REFERENCES `abogado` (`id_abogado`);

--
-- Filtros para la tabla `asunto`
--
ALTER TABLE `asunto`
  ADD CONSTRAINT `asunto_ibfk_1` FOREIGN KEY (`id_abogado`) REFERENCES `abogado` (`id_abogado`),
  ADD CONSTRAINT `asunto_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `asunto_ibfk_3` FOREIGN KEY (`id_demandado`) REFERENCES `demandado` (`id_demandado`),
  ADD CONSTRAINT `asunto_ibfk_4` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`),
  ADD CONSTRAINT `asunto_ibfk_5` FOREIGN KEY (`id_tipo_asu`) REFERENCES `tipo_asunto` (`id_tipo_asunto`);

--
-- Filtros para la tabla `audiencia`
--
ALTER TABLE `audiencia`
  ADD CONSTRAINT `audiencia_ibfk_1` FOREIGN KEY (`id_asunto`) REFERENCES `asunto` (`id_asunto`),
  ADD CONSTRAINT `audiencia_ibfk_2` FOREIGN KEY (`id_lugar`) REFERENCES `lugar` (`id_lugar`);

--
-- Filtros para la tabla `contacto`
--
ALTER TABLE `contacto`
  ADD CONSTRAINT `contacto_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Filtros para la tabla `correo`
--
ALTER TABLE `correo`
  ADD CONSTRAINT `correo_ibfk_1` FOREIGN KEY (`id_contacto`) REFERENCES `contacto` (`id_contacto`);

--
-- Filtros para la tabla `demandado`
--
ALTER TABLE `demandado`
  ADD CONSTRAINT `demandado_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo` (`id_tipo`);

--
-- Filtros para la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD CONSTRAINT `empresa_ibfk_1` FOREIGN KEY (`id_demandado`) REFERENCES `demandado` (`id_demandado`);

--
-- Filtros para la tabla `facebook`
--
ALTER TABLE `facebook`
  ADD CONSTRAINT `facebook_ibfk_1` FOREIGN KEY (`id_contacto`) REFERENCES `contacto` (`id_contacto`);

--
-- Filtros para la tabla `participan`
--
ALTER TABLE `participan`
  ADD CONSTRAINT `participan_ibfk_1` FOREIGN KEY (`id_audiencia`) REFERENCES `audiencia` (`id_audiencia`),
  ADD CONSTRAINT `participan_ibfk_2` FOREIGN KEY (`id_gente`) REFERENCES `gente` (`id_gente`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`id_demandado`) REFERENCES `demandado` (`id_demandado`);

--
-- Filtros para la tabla `prefiere`
--
ALTER TABLE `prefiere`
  ADD CONSTRAINT `prefiere_ibfk_1` FOREIGN KEY (`id_abogado`) REFERENCES `abogado` (`id_abogado`),
  ADD CONSTRAINT `prefiere_ibfk_2` FOREIGN KEY (`id_tipo_asu`) REFERENCES `tipo_asunto` (`id_tipo_asunto`);

--
-- Filtros para la tabla `telefono`
--
ALTER TABLE `telefono`
  ADD CONSTRAINT `telefono_ibfk_1` FOREIGN KEY (`id_contacto`) REFERENCES `contacto` (`id_contacto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
