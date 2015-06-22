package com.brunotonia.piscicultura.constants;

public interface UsuarioEstadoConstantes {
    String TABLE_NAME   = "usuario_estado";
    String COLUMN_ID    = "id";
    String COLUMN_ESTADO = "estado";

    String CREATE_TABLE =
            "CREATE TABLE [" + TABLE_NAME + "] ( " +
                    "[" + COLUMN_ID     + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_ESTADO + "] TEXT NOT NULL UNIQUE" +
                    " )";

    String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    Integer VETOR_ESTADOS[] = {0, 1};
    String VETOR_DESCRICOES[] = {"Ativo", "Inativo"};

    String INSERT_ESTADO1 = "INSERT INTO " + TABLE_NAME + " VALUES (" + VETOR_ESTADOS[0].toString() + ", \"" + VETOR_DESCRICOES[0] + "\")";
    String INSERT_ESTADO2 = "INSERT INTO " + TABLE_NAME + " VALUES (" + VETOR_ESTADOS[1].toString() + ", \"" + VETOR_DESCRICOES[1] + "\")";
}
