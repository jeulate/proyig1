package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MiembrosDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/iglesiadb";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public void agregarMiembro(Miembros miembros){
        try (Connection conexion = DriverManager.getConnection(URL,USUARIO,CONTRASENA)) {
            String query = "INSERT INTO miembros (id,nombre,apellido,fecha_nacimiento,genero,direccion,correo_electronico,telefono) VALUES (?,?,?,?,?,?,?,?)";

            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setString(1, miembros.getId());
                statement.setString(2, miembros.getNombre());
                statement.setString(3, miembros.getApellido());
                statement.setString(4, miembros.getFnaci().toString());
                statement.setString(5,miembros.getGenero());
                statement.setString(6,miembros.getDireccion());
                statement.setString(7,miembros.getEmail());
                statement.setString(8, miembros.getTelefono());

                statement.execute();
                System.out.println("Datos registrados correctamente en " + URL);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
