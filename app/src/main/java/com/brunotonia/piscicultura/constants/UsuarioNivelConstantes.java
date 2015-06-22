package com.brunotonia.piscicultura.constants;

public interface UsuarioNivelConstantes {
    String TABLE_NAME  = "usuario_nivel";
    String COLUMN_ID   = "id";
    String COLUMN_TIPO = "nivel";

    String CREATE_TABLE =
            "CREATE TABLE [" + TABLE_NAME + "] ( " +
                    "[" + COLUMN_ID +    "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_TIPO +  "] TEXT NOT NULL UNIQUE" +
                    " )";

    String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    Integer VETOR_NIVEIS[] = {0, 1, 2};
    String VETOR_DESCRICOES[] = {"Administrador", "Operacional", "Parceiro"};

    String INSERT_NIVEL1 = "INSERT INTO " + TABLE_NAME + " VALUES ("
            + VETOR_NIVEIS[0].toString() + ", \""+ VETOR_DESCRICOES[0] + "\")";
    String INSERT_NIVEL2 = "INSERT INTO " + TABLE_NAME + " VALUES ("
            + VETOR_NIVEIS[1].toString() + ", \""+ VETOR_DESCRICOES[1] + "\")";
    String INSERT_NIVEL3 = "INSERT INTO " + TABLE_NAME + " VALUES ("
            + VETOR_NIVEIS[2].toString() + ", \""+ VETOR_DESCRICOES[2] + "\")";
}
