package com.brunotonia.piscicultura.constants;

public interface LoteEtapaConstantes {
    String TABLE_NAME   = "lote_etapa";
    String COLUMN_ID    = "id";
    String COLUMN_ETAPA = "etapa";

    String CREATE_TABLE =
            "CREATE TABLE [" + TABLE_NAME + "] ( " +
                    "[" + COLUMN_ID    + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_ETAPA + "] TEXT NOT NULL UNIQUE" +
                    " )";

    String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    Integer VETOR_ETAPAS[]     = {0, 1, 2, 3};
    String  VETOR_DESCRICOES[] = {"Inicial", "Intermediária", "Final", "Concluído"};

    String INSERT_ETAPA1 = "INSERT INTO " + TABLE_NAME + " VALUES ("
            + VETOR_ETAPAS[0].toString() + ", \""+ VETOR_DESCRICOES[0] + "\")";
    String INSERT_ETAPA2 = "INSERT INTO " + TABLE_NAME + " VALUES ("
            + VETOR_ETAPAS[1].toString() + ", \""+ VETOR_DESCRICOES[1] + "\")";
    String INSERT_ETAPA3 = "INSERT INTO " + TABLE_NAME + " VALUES ("
            + VETOR_ETAPAS[2].toString() + ", \""+ VETOR_DESCRICOES[2] + "\")";
    String INSERT_ETAPA4 = "INSERT INTO " + TABLE_NAME + " VALUES ("
            + VETOR_ETAPAS[3].toString() + ", \""+ VETOR_DESCRICOES[3] + "\")";

}
