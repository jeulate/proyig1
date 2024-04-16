package MVC.modelo;

import MVC.modelo.conector.ConexionBD;

import java.nio.file.attribute.UserPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseDAO<T> {
  public Connection obtenerConexion() throws SQLException {
    return ConexionBD.establecerConexion();
  }

  public boolean insertar(String tabla, Map<String, Object> campos) {
    String columnas = String.join(", ", campos.keySet());
    String valoresMarcadores = String.join(", ", campos.keySet().stream().map(key -> "?").toList());

    String sql = "INSERT INTO " + tabla + " (" + columnas + ") VALUES (" + valoresMarcadores + ")";

    try (Connection conexion = obtenerConexion();
        PreparedStatement statement = conexion.prepareStatement(sql)) {
      int index = 1;
      for (Object valor : campos.values()) {
        statement.setObject(index++, valor);
      }
      return statement.executeUpdate() > 0;
    } catch (SQLException e) {
      System.err.println("Error al insertar en la tabla" + tabla + ": "+e.getMessage());
      return false;
    }
  }

  public boolean actualizar(String tabla, Map<String, Object> campos, String condicion) {
    String setClause =
        campos.keySet().stream().map(key -> key + " = ?").collect(Collectors.joining(", "));

    String sql = "UPDATE " + tabla + " SET " + setClause + " WHERE " + condicion;

    try (Connection conexion = obtenerConexion();
        PreparedStatement statement = conexion.prepareStatement(sql)) {
      int index = 1;
      for (Object valor : campos.values()) {
        statement.setObject(index++, valor);
      }
      return statement.executeUpdate() > 0;
    } catch (SQLException e) {
      System.err.println("Error al actualizar la tabla "+ tabla + ": " + e.getMessage());
      return false;
    }
  }

  // Ejemplo de método para obtener datos, este deberá ser ajustado según necesidades específicas
  public T obtener(String tabla, String condicion, RowMapper<T> rowMapper) throws SQLException {
    String sql = "SELECT * FROM " + tabla + " WHERE " + condicion;
    try (Connection conexion = obtenerConexion();
         PreparedStatement statement = conexion.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {
      return rowMapper.mapRow(resultSet);
    } catch (SQLException e) {
      System.err.println("Error al obtener datos de la tabla " + tabla + ": " + e.getMessage());
      return null;
    }
  }

  public List<T> obtenerTodos(String tabla, RowMapper<T> rowMapper) {
    String query = "SELECT * FROM " + tabla;
    List<T> resultados = new ArrayList<>();
    try (Connection conexion = obtenerConexion();
        PreparedStatement statement = conexion.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery()) {

      while (resultSet.next()) {
        resultados.add(rowMapper.mapRow(resultSet));
      }
    } catch (SQLException e) {
      System.err.println("Error al obtener todos los datos de la tabla " + tabla + ": " + e.getMessage());
    }
    return resultados;
  }

  @FunctionalInterface
  public interface RowMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
  }
}
