-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-06-2024 a las 06:01:30
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbiglesia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaciones`
--

CREATE TABLE `asignaciones` (
  `ID` int(11) NOT NULL,
  `miembro_id` int(11) DEFAULT NULL,
  `ministerio_id` int(11) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia_eventos`
--

CREATE TABLE `asistencia_eventos` (
  `ID` int(11) NOT NULL,
  `miembro_id` int(11) DEFAULT NULL,
  `evento_id` int(11) DEFAULT NULL,
  `asistio` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `asistencia_eventos`
--

INSERT INTO `asistencia_eventos` (`ID`, `miembro_id`, `evento_id`, `asistio`) VALUES
(1, 1, 2, 1),
(2, 3, 3, 1),
(3, 7, 1, 0),
(4, 4, 4, 1),
(5, 5, 2, 0),
(6, 2, 3, 1),
(7, 1, 4, 0),
(8, 1, 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diezmos`
--

CREATE TABLE `diezmos` (
  `ID` int(11) NOT NULL,
  `miembro_id` int(11) DEFAULT NULL,
  `monto` decimal(10,2) DEFAULT NULL,
  `fecha_pago` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos_iglesia`
--

CREATE TABLE `eventos_iglesia` (
  `ID` int(11) NOT NULL,
  `nombre_evento` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `fecha_evento` date DEFAULT NULL,
  `tipo_evento` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `eventos_iglesia`
--

INSERT INTO `eventos_iglesia` (`ID`, `nombre_evento`, `descripcion`, `fecha_evento`, `tipo_evento`) VALUES
(1, 'Culto Matutino', 'Culto de 6 a 7 am', '2024-04-14', 'Cultos'),
(2, 'Escuela 903', 'Graduacion de la escuela 903', '2024-04-13', 'Graduacion'),
(3, 'Bautismo Macrocelula m12', 'bautismo del equipo de la macrocelula del pastor joaquin', '2024-04-20', 'Bautismo'),
(4, 'Culto Noche', 'Culto de 7 a 9 pm', '2024-04-21', 'Cultos'),
(5, 'Red de Jovenes', 'culto de jovenes', '2024-06-15', 'Cultos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `miembros`
--

CREATE TABLE `miembros` (
  `ID` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `genero` varchar(10) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `correo_electronico` varchar(100) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `fecha_bautismo` date DEFAULT NULL,
  `asistio_culto` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `miembros`
--

INSERT INTO `miembros` (`ID`, `nombre`, `apellido`, `fecha_nacimiento`, `genero`, `direccion`, `correo_electronico`, `telefono`, `fecha_bautismo`, `asistio_culto`) VALUES
(1, 'Juan Antonio', 'Eulate', '1990-11-29', 'M', 'Ucebol', 'juan@gmail.com', '76653715', '1990-11-29', 0),
(2, 'Julio', 'Paz', '1990-01-01', 'M', 'Santos dumont', 'julio@gmail.com', '7894512', '1990-01-01', 0),
(3, 'gerardo', 'copa', '1992-04-20', 'M', 'radial 10', 'gerardo@gmail.com', '78945120', '1992-04-20', 0),
(4, 'Silvana Daniela', 'padilla de vargas', '1993-08-22', 'F', 'pedro velez', 'silvana@gmail.com', '78945123', '1993-08-22', 0),
(5, 'Karla crespa', 'padilla', '1986-04-12', 'F', 'pedro velez', 'karla@gmail.com', '78945123', '1986-04-12', 0),
(6, 'Eve', 'padilla', '1986-04-12', 'F', 'pedro velez', 'eve@gmail.com', '78945123', '1986-04-12', 0),
(7, 'Raul David', 'Nota Mercado', '1987-04-23', 'M', 'zona norte', ' ', '7986510', '1987-04-23', 0),
(8, 'Josue', 'Veizaga', '1989-04-19', 'M', 'zona norte', 'email@uagrm.edu', '78945123', '1989-04-19', 0),
(9, 'Fabiola', 'Gonzales', '1987-05-20', 'F', 'pirai', 'fgonzales@gmail.com', '70012345', '1987-05-20', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ministerios`
--

CREATE TABLE `ministerios` (
  `ID` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `ministerios`
--

INSERT INTO `ministerios` (`ID`, `nombre`, `descripcion`) VALUES
(1, 'Multimedia', 'Equipo de multimedia, camaras y edicion'),
(2, 'Alabanza', 'Cantantes para cada culto'),
(3, 'Danza', 'Equipo de bailarines'),
(4, 'Intersesion', 'Equipo de intersesion para los cultos'),
(5, 'Seguridad', 'Equipo de seguridad MBI'),
(6, 'Protocolo', 'Guias dentro de la iglesia'),
(7, 'Editores', 'editores de fotos y video'),
(9, 'Fotografos', 'equipo de fotografos'),
(10, 'Camarografos', 'solo equipo de camarografos'),
(11, 'Infantil', 'equipo para niños'),
(12, 'Medico', 'Descripcion por defecto'),
(13, 'Pintores', 'grupo de pintores'),
(14, 'Coro', 'Equipo de coristas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofrendas`
--

CREATE TABLE `ofrendas` (
  `ID` int(11) NOT NULL,
  `miembro_id` int(11) DEFAULT NULL,
  `monto` double(10,2) DEFAULT NULL,
  `fecha_pago` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `relaciones`
--

CREATE TABLE `relaciones` (
  `ID` int(11) NOT NULL,
  `miembro1_id` int(11) DEFAULT NULL,
  `miembro2_id` int(11) DEFAULT NULL,
  `tipo_relacion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `relaciones`
--

INSERT INTO `relaciones` (`ID`, `miembro1_id`, `miembro2_id`, `tipo_relacion`) VALUES
(1, 1, 3, 'Hermano'),
(2, 2, 6, 'Padre'),
(3, 4, 5, 'Hermana'),
(4, 2, 3, 'Padre'),
(5, 4, 6, 'Hermana'),
(6, 4, 2, 'Madre');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignaciones`
--
ALTER TABLE `asignaciones`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `miembro_id` (`miembro_id`),
  ADD KEY `ministerio_id` (`ministerio_id`);

--
-- Indices de la tabla `asistencia_eventos`
--
ALTER TABLE `asistencia_eventos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `miembro_id` (`miembro_id`),
  ADD KEY `evento_id` (`evento_id`);

--
-- Indices de la tabla `diezmos`
--
ALTER TABLE `diezmos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `miembro_id` (`miembro_id`);

--
-- Indices de la tabla `eventos_iglesia`
--
ALTER TABLE `eventos_iglesia`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `miembros`
--
ALTER TABLE `miembros`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `ministerios`
--
ALTER TABLE `ministerios`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `ofrendas`
--
ALTER TABLE `ofrendas`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `miembro_id` (`miembro_id`);

--
-- Indices de la tabla `relaciones`
--
ALTER TABLE `relaciones`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `miembro1_id` (`miembro1_id`),
  ADD KEY `miembro2_id` (`miembro2_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignaciones`
--
ALTER TABLE `asignaciones`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `asistencia_eventos`
--
ALTER TABLE `asistencia_eventos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `diezmos`
--
ALTER TABLE `diezmos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `eventos_iglesia`
--
ALTER TABLE `eventos_iglesia`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `miembros`
--
ALTER TABLE `miembros`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `ministerios`
--
ALTER TABLE `ministerios`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `ofrendas`
--
ALTER TABLE `ofrendas`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `relaciones`
--
ALTER TABLE `relaciones`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignaciones`
--
ALTER TABLE `asignaciones`
  ADD CONSTRAINT `asignaciones_ibfk_1` FOREIGN KEY (`miembro_id`) REFERENCES `miembros` (`ID`),
  ADD CONSTRAINT `asignaciones_ibfk_2` FOREIGN KEY (`ministerio_id`) REFERENCES `ministerios` (`ID`);

--
-- Filtros para la tabla `asistencia_eventos`
--
ALTER TABLE `asistencia_eventos`
  ADD CONSTRAINT `asistencia_eventos_ibfk_1` FOREIGN KEY (`miembro_id`) REFERENCES `miembros` (`ID`),
  ADD CONSTRAINT `asistencia_eventos_ibfk_2` FOREIGN KEY (`evento_id`) REFERENCES `eventos_iglesia` (`ID`);

--
-- Filtros para la tabla `diezmos`
--
ALTER TABLE `diezmos`
  ADD CONSTRAINT `diezmos_ibfk_1` FOREIGN KEY (`miembro_id`) REFERENCES `miembros` (`ID`);

--
-- Filtros para la tabla `ofrendas`
--
ALTER TABLE `ofrendas`
  ADD CONSTRAINT `ofrendas_ibfk_1` FOREIGN KEY (`miembro_id`) REFERENCES `miembros` (`ID`);

--
-- Filtros para la tabla `relaciones`
--
ALTER TABLE `relaciones`
  ADD CONSTRAINT `relaciones_ibfk_1` FOREIGN KEY (`miembro1_id`) REFERENCES `miembros` (`ID`),
  ADD CONSTRAINT `relaciones_ibfk_2` FOREIGN KEY (`miembro2_id`) REFERENCES `miembros` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
