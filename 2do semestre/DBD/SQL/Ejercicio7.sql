/*
Club = (codigoClub, nombre, anioFundacion, codigoCiudad(FK))
Ciudad = (codigoCiudad, nombre)
Estadio = (codigoEstadio, codigoClub(FK), nombre, direccion)
Jugador = (DNI, nombre, apellido, edad, codigoCiudad(FK))
ClubJugador = (codigoClub (FK), DNI (FK), desde, hasta)

8. Reportar el nombre y apellido de aquellos jugadores que hayan jugado en todos los clubes de la
ciudad de Córdoba.
*/

USE comunicaciones;


-- Tabla de Modos de Comunicación
CREATE TABLE Modos (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Nombre VARCHAR(20) NOT NULL UNIQUE
);


-- Tabla de Servicios
CREATE TABLE Servicios (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Nombre VARCHAR(20) NOT NULL UNIQUE
);


-- Tabla de Niveles RX
CREATE TABLE NivelesRX (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Nivel VARCHAR(10) NOT NULL UNIQUE
);


-- Tabla de Grupos de Obtención
CREATE TABLE GruposOBT (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Nombre VARCHAR(20) NOT NULL UNIQUE
);


-- Tabla de Organizaciones
CREATE TABLE Organizaciones (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL UNIQUE,
    Descripcion TEXT
);


-- Tabla de Partes
CREATE TABLE Partes (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Parte TEXT NOT NULL,
    Frecuencia FLOAT NOT NULL,
    ModoID INT NOT NULL,
    ServicioID INT NOT NULL,
    Red VARCHAR(20) NOT NULL,
    OperadorID INT NOT NULL,
    GrupoOBTID INT NOT NULL,
    PaisID INT NOT NULL,
    OrganizacionID INT NOT NULL,
    EquipoYAntenas TEXT NOT NULL,
    NumeroOrden INT NOT NULL,
    NivelRXID INT,
    Observaciones TEXT,
    FechaHora DATETIME NOT NULL,
    GraficoRed VARCHAR(500),
    Audio VARCHAR(500),
    FOREIGN KEY (ModoID) REFERENCES Modos(ID),
    FOREIGN KEY (ServicioID) REFERENCES Servicios(ID),
    FOREIGN KEY (OperadorID) REFERENCES Operadores(ID),
    FOREIGN KEY (GrupoOBTID) REFERENCES GruposOBT(ID),
    FOREIGN KEY (PaisID) REFERENCES Paises(ID),
    FOREIGN KEY (OrganizacionID) REFERENCES Organizaciones(ID),
    FOREIGN KEY (EquipoYAntenas) REFERENCES Equipos(ID),
    FOREIGN KEY (NivelRXID) REFERENCES NivelesRX(ID)
);


-- Tabla de Indicadores (más flexible)
CREATE TABLE TiposIndicador (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Nombre VARCHAR(10) NOT NULL UNIQUE  -- TX, RX, etc.
);


CREATE TABLE Indicadores (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    TipoIndicadorID INT NOT NULL,
    Codigo VARCHAR(5) NOT NULL,
    Referencia VARCHAR(100),
    FOREIGN KEY (TipoIndicadorID) REFERENCES TiposIndicador(ID),
    UNIQUE (TipoIndicadorID, Codigo)
);


-- Tabla intermedia Partes-Indicadores
CREATE TABLE PartesIndicadores (
    ParteID INT NOT NULL,
    IndicadorID INT NOT NULL,
    FOREIGN KEY (ParteID) REFERENCES Partes(ID),
    FOREIGN KEY (IndicadorID) REFERENCES Indicadores(ID),
    PRIMARY KEY (ParteID, IndicadorID)
);