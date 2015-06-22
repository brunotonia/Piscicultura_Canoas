package com.brunotonia.piscicultura.constants;

public interface TanqueEstadoContantes {
    String TABLE_NAME  = "tanque_estado";
    String COLUMN_ID   = "id";
    String COLUMN_ESTADO = "estado";

    String CREATE_TABLE =
            "CREATE TABLE [" + TABLE_NAME + "] ( " +
                    "[" + COLUMN_ID     + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_ESTADO + "] TEXT NOT NULL UNIQUE" +
                    " )";

    String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    Integer VETOR_ESTADO[] = {0, 1, 2};
    String  VETOR_DESCRICOES[] = {"Disponível", "Em Produção", "Em Manutenção"};

    String INSERT_ESTADO1 = "INSERT INTO " + TABLE_NAME + " VALUES ("
            + VETOR_ESTADO[0].toString() + ", \""+ VETOR_DESCRICOES[0] + "\")";
    String INSERT_ESTADO2 = "INSERT INTO " + TABLE_NAME + " VALUES ("
            + VETOR_ESTADO[1].toString() + ", \""+ VETOR_DESCRICOES[1] + "\")";
    String INSERT_ESTADO3 = "INSERT INTO " + TABLE_NAME + " VALUES ("
            + VETOR_ESTADO[2].toString() + ", \""+ VETOR_DESCRICOES[2] + "\")";

}
