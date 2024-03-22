-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-07-2023 a las 07:25:54
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_dc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cedula` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Telefono` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Servicio` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Descripcion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Direccion` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `CedulaDoc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ID` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`Nombre`, `Cedula`, `Telefono`, `Fecha`, `Servicio`, `Descripcion`, `Direccion`, `CedulaDoc`, `ID`) VALUES
('Juan Pablo Montero', '23009883', '04242874436', '15-07-2023', 'Colocacion De Corona', 'Corona de base de resina. Fabricada en China.', 'Valle Arriba', '35431315', '1'),
('Samuel Torre', '22222222', '04149997766', '14-07-2023', 'NULL', 'NULL', 'Montalban', '65221165', '3'),
('Santiago Perez', '12345678', '04127894561', '10-11-2003', 'NULL', 'NULL', 'La guaira', '65221165', '4'),
('Andre Carolina', '66666666', '02124566666', '08-08-2025', 'LaLOOOOOO', 'Y buenooo', 'Puente Barbula', '68464647', '620173063'),
('Juan Pablo', '30210488', '04142874436', '14-07-2023', 'Colocacion De Corona', 'Corona de base de resina. Fabricada en China.', 'Valle Abajo', '65221165', '507817402');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cobros`
--

CREATE TABLE `cobros` (
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cedula` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Direccion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Telefono` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ServicioAplicado` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TipoPago` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NumT` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MontoCobrado` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Nota` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `FechaCobro` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `cobros`
--

INSERT INTO `cobros` (`Nombre`, `Cedula`, `Direccion`, `Telefono`, `ServicioAplicado`, `TipoPago`, `NumT`, `MontoCobrado`, `Nota`, `FechaCobro`) VALUES
('Alex Mateo', '29899989', 'Caracas', '04148589686', 'Ortodoncia y restauracion dental', 'Tarjeta', '956768070988008079', '1240', 'Ninguna', '2023-06-17'),
('Jose Perez', '11258255', 'Cafetal', '04243245657', 'Restauracion dental', 'Efectivo', 'No Aplica', '10', 'Ninguna', '2023-06-17'),
('Giovanna Perez', '24543535', 'Las Mercedes', '04248734687', 'Ortodoncia', 'Transferencia', '211254546', '560', 'Pago por Mercantil', '2023-06-17');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historias`
--

CREATE TABLE `historias` (
  `cedula_paciente` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `nombre_contacto` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `telefono_contacto` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `parentesco_contacto` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `RB1` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ESP1` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `RB2` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ESP2` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `RB3` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ESP3` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `RB4` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ESP4` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `RB5` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ESP5` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `RB6` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ESP6` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `RB7` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `RB8` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `RB9` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `RBA` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `RBB` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `text_habito` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `text_motivo` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `check_boca` tinyint(1) NOT NULL,
  `check_cara` tinyint(1) NOT NULL,
  `check_cuello` tinyint(1) NOT NULL,
  `check_ortodoncia` tinyint(1) NOT NULL,
  `check_cirugia` tinyint(1) NOT NULL,
  `check_periodoncia` tinyint(1) NOT NULL,
  `check_implantes` tinyint(1) NOT NULL,
  `check_endodoncia` tinyint(1) NOT NULL,
  `check_restauracion` tinyint(1) NOT NULL,
  `text_otras_obs` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `historias`
--

INSERT INTO `historias` (`cedula_paciente`, `nombre_contacto`, `telefono_contacto`, `parentesco_contacto`, `RB1`, `ESP1`, `RB2`, `ESP2`, `RB3`, `ESP3`, `RB4`, `ESP4`, `RB5`, `ESP5`, `RB6`, `ESP6`, `RB7`, `RB8`, `RB9`, `RBA`, `RBB`, `text_habito`, `text_motivo`, `check_boca`, `check_cara`, `check_cuello`, `check_ortodoncia`, `check_cirugia`, `check_periodoncia`, `check_implantes`, `check_endodoncia`, `check_restauracion`, `text_otras_obs`) VALUES
('12339004', 'Maria Lopez', '02123448899', 'Hermana', 'No', '', 'Si', 'Parto.', 'No', '', 'No', '', 'Si', 'Maní y Nueces.', 'No', '', 'No', 'Si', 'No', 'Si', 'Si', 'No hay otro.', 'Dolor de muela y de cachete derecho.', 0, 1, 0, 1, 0, 0, 0, 0, 0, 'Cuarta prueba, esta es una nueva observacion.'),
('19880992', 'Carolina Robinson', '04149872344', 'Esposa', 'Si', 'Covid-19', 'No', '', 'No', '', 'No', '', 'Si', 'Acetaminofén.', 'No', '', 'Si', 'Si', 'No', 'Si', 'Si', 'Consume chimó.', 'Dos años sin asistir al odontólogo.', 0, 0, 0, 1, 0, 0, 1, 0, 0, 'Prueba dos, esto es una nueva observación.'),
('23009883', 'Jorge Logan', '04122831735', 'Roomie', 'No', '', 'Si', 'Cirugía por fractura de tobillo.', 'No', '', 'Si', 'Leche y queso.', 'No', '', 'No', '', 'Si', 'Si', 'Si', 'No', 'No', 'No.', 'Dientes amarillos y resina rota.', 1, 0, 0, 0, 0, 0, 1, 1, 1, 'Prueba cinco, esta es la quinta observación.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `odontologos`
--

CREATE TABLE `odontologos` (
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cedula` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Direccion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Telefono` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Correo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cargo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Usuario` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Clave` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha_Ingreso` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Especialidad` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Observaciones` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `odontologos`
--

INSERT INTO `odontologos` (`Nombre`, `Cedula`, `Direccion`, `Telefono`, `Correo`, `Cargo`, `Usuario`, `Clave`, `Fecha_Ingreso`, `Especialidad`, `Observaciones`) VALUES
('Rodolfo Perez', '68464647', 'dgsrgrg', '04144561561', 'dr@gmail.com', 'Odontologo', 'f', 'f', '2023-06-10', 'Hot', 'drhdrth'),
('Jose Lopez', '65221165', '3020234Av LOC', '04125643213', 'dewf@gmail.com', 'Odontologo', 'lopez', 'lopez', '2023-07-06', 'Muerto de HAmbre', 'null'),
('Yustin Biber', '35431315', 'De arriba', '04126543513', 'yuuDegringolandia@gmail.com', 'Odontologo', 'Yustin', 'Yustin', '2023-07-08', 'LOCAAA LOCAAA', 'null');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cedula` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Direccion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Telefono` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Correo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Edad` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Sexo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Observaciones` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`Nombre`, `Cedula`, `Direccion`, `Telefono`, `Correo`, `Edad`, `Sexo`, `Observaciones`) VALUES
('Julia Perez', '12339004', 'Los Samanes', '04129902834', 'juliap@hotmail.com', '30', 'Femenino', 'Se observaron caries en la última consulta.'),
('Samuel Torrealba', '19880992', 'Montalban', '04149997766', 'samtor@gmail.com', '22', 'Masculino', 'Sin observaciones.'),
('Juan Pablo Montero', '23009883', 'Valle Arriba', '04242874436', 'juanpimontero@ucab.ve', '28', 'Masculino', 'a');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `secretarias`
--

CREATE TABLE `secretarias` (
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cedula` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Direccion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Telefono` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Correo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cargo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Usuario` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Clave` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha_Ingreso` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `secretarias`
--

INSERT INTO `secretarias` (`Nombre`, `Cedula`, `Direccion`, `Telefono`, `Correo`, `Cargo`, `Usuario`, `Clave`, `Fecha_Ingreso`) VALUES
('Santi', '30210488', 'Valenciano', '04244593634', 'spenadeA@gmail.com', 'Secretaria', 'Santi', 'Santi', '2023-07-08'),
('Sofia Arasme', '30345311', 'DeAndrea', '04121351351', 'Soara@gmail.com', 'Secretaria', 'ss', 'ss', '2023-06-18'),
('Andrea Reis', '51313135', 'DeShofi', '02125123423', 'AaacedeS@gmail.com', 'Secretaria', 'Andi', 'Andi', '2023-06-06'),
('Mateo Delgado', '44435135', 'Caraca', '04121651313', 'alllvv@gmail.com', 'Secretaria', 'Alex', 'Alex', '2023-07-08'),
('Yustin Chacon', '29845663', 'Los Caobos', '04129904110', 'ychacon1905@gmail.com', 'Secretaria', 'Yustin1905', '1234', '2023-07-03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `Nombre` text NOT NULL,
  `Precio` float NOT NULL,
  `Descripcion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`Nombre`, `Precio`, `Descripcion`) VALUES
('Colocacion De Corona', 70.21, 'Corona de base de resina. Fabricada en China.');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
