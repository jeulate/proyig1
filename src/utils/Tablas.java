package utils;

public enum Tablas {
  ASIGNACIONES("Asignaciones"),
  ASISTENCIA_EVENTOS("Asistencia_Eventos"),
  DIEZMOS("Diezmos"),
  EVENTOS_IGLESIA("Eventos_Iglesia"),
  MIEMBROS("Miembros"),
  MINISTERIOS("Ministerios"),
  OFRENDAS("Ofrendas"),
  RELACIONES("Relaciones");

  final String tableName;

  Tablas(String tableName) {
    this.tableName = tableName;
  }

  public String getTableName() {
    return tableName;
  }
}
