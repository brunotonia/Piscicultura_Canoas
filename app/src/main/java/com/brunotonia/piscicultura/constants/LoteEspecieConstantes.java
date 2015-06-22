package com.brunotonia.piscicultura.constants;

public interface LoteEspecieConstantes {
    String TABLE_NAME  = "lote_especie";
    String COLUMN_ID   = "id";
    String COLUMN_ESPECIE = "especie";

    String CREATE_TABLE =
            "CREATE TABLE [" + TABLE_NAME + "] ( " +
                    "[" + COLUMN_ID      + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_ESPECIE + "] TEXT NOT NULL UNIQUE" +
                    " )";

    String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    Integer VETOR_ESPECIES[] = {0, 1, 2};
    String VETOR_DESCRICOES[] = {"Tilápia do Nilo", "Tilápia Rendali ", "Tilápia Zanzibar"};

    String INSERT_ESPECIE1 = "INSERT INTO " + TABLE_NAME + " VALUES ("
            + VETOR_ESPECIES[0].toString() + ", \""+ VETOR_DESCRICOES[0] + "\")";
    String INSERT_ESPECIE2 = "INSERT INTO " + TABLE_NAME + " VALUES ("
            + VETOR_ESPECIES[1].toString() + ", \""+ VETOR_DESCRICOES[1] + "\")";
    String INSERT_ESPECIE3 = "INSERT INTO " + TABLE_NAME + " VALUES ("
            + VETOR_ESPECIES[2].toString() + ", \""+ VETOR_DESCRICOES[2] + "\")";

}
