-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS IglesiaDB;
USE IglesiaDB;

-- Tabla de Miembros
CREATE TABLE Miembros (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    fecha_nacimiento DATE,
    genero VARCHAR(10),
    direccion VARCHAR(100),
    correo_electronico VARCHAR(100),
    telefono VARCHAR(15),
    fecha_bautismo DATE, -- Nuevo campo para registrar la fecha de bautismo
    asistio_culto boolean -- Nuevo campo para registrar la asistencia a los cultos
);

-- Tabla de Relaciones entre Miembros
CREATE TABLE Relaciones (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    miembro1_id INT,
    miembro2_id INT,
    tipo_relacion VARCHAR(50),
    FOREIGN KEY (miembro1_id) REFERENCES Miembros(ID),
    FOREIGN KEY (miembro2_id) REFERENCES Miembros(ID)
);

-- Tabla de Ministerios
CREATE TABLE Ministerios (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT
);

-- Tabla de Asignaciones de Ministerio
CREATE TABLE Asignaciones (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    miembro_id INT,
    ministerio_id INT,
    fecha_inicio DATE,
    fecha_fin DATE,
    FOREIGN KEY (miembro_id) REFERENCES Miembros(ID),
    FOREIGN KEY (ministerio_id) REFERENCES Ministerios(ID)
);

-- Tabla de Eventos de la Iglesia
CREATE TABLE Eventos_Iglesia (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    nombre_evento VARCHAR(100),
    descripcion TEXT,
    fecha_evento DATE,
    tipo_evento VARCHAR(50) -- Nuevo campo para identificar el tipo de evento (por ejemplo, "Bautismo")
);

-- Tabla de Asistencia a Eventos
CREATE TABLE Asistencia_Eventos (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    miembro_id INT,
    evento_id INT,
    asistio boolean,
    FOREIGN KEY (miembro_id) REFERENCES Miembros(ID),
    FOREIGN KEY (evento_id) REFERENCES Eventos_Iglesia(ID)
);

-- Tabla de Diezmos
CREATE TABLE Diezmos (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    miembro_id INT,
    monto DECIMAL(10, 2),
    fecha_pago DATE,
    FOREIGN KEY (miembro_id) REFERENCES Miembros(ID)
);

-- Tabla de Ofrendas
CREATE TABLE Ofrendas (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    miembro_id INT,
    monto DECIMAL(10, 2),
    fecha_pago DATE,
    FOREIGN KEY (miembro_id) REFERENCES Miembros(ID)
);

-- Trigger para actualizar la fecha de bautismo del miembro cuando se crea un evento de bautismo
DELIMITER $$
CREATE TRIGGER Actualizar_Fecha_Bautismo
AFTER INSERT ON Eventos_Iglesia
FOR EACH ROW
BEGIN
    IF NEW.tipo_evento = 'Bautismo' THEN
        UPDATE Miembros
        SET fecha_bautismo = NEW.fecha_evento
        WHERE ID = NEW.ID;
    END IF;
END$$
DELIMITER ;
