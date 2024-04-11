package utils;

import MVC.modelo.conector.ConexionBD;

import java.sql.Connection;

public class CConexionBD {
    public static void main(String[] args) {
        Connection conexion = ConexionBD.establecerConexion();
    }
}
