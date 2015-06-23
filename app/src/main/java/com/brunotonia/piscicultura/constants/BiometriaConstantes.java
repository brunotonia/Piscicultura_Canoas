package com.brunotonia.piscicultura.constants;

public interface BiometriaConstantes {

    String TABLE_NAME      = "biometria";
    String COLUMN_ID       = "id";
    String COLUMN_LTANQUE  = "lote_tanque";
    String COLUMN_DATA     = "data";
    String COLUMN_A1_IND   = "a1_especimes";
    String COLUMN_A1_PESO  = "a1_peso";
    String COLUMN_A2_IND   = "a2_especimes";
    String COLUMN_A2_PESO  = "a2_peso";
    String COLUMN_A3_IND   = "a3_especimes";
    String COLUMN_A3_PESO  = "a3_peso";
    String COLUMN_A4_IND   = "a4_especimes";
    String COLUMN_A4_PESO  = "a4_peso";
    String COLUMN_RESP     = "responsavel";

    String CREATE_TABLE = "CREATE TABLE [" + TABLE_NAME + "] ( " +
            "[" + COLUMN_ID      + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
            "[" + COLUMN_LTANQUE + "] INTEGER NOT NULL, " +
            "[" + COLUMN_DATA    + "] STRING NOT NULL, " +
            "[" + COLUMN_A1_IND  + "] INTEGER NOT NULL, " +
            "[" + COLUMN_A1_PESO + "] REAL NOT NULL, " +
            "[" + COLUMN_A2_IND  + "] INTEGER NOT NULL, " +
            "[" + COLUMN_A2_PESO + "] REAL NOT NULL, " +
            "[" + COLUMN_A3_IND  + "] INTEGER NOT NULL, " +
            "[" + COLUMN_A3_PESO + "] REAL NOT NULL, " +
            "[" + COLUMN_A4_IND  + "] INTEGER NOT NULL, " +
            "[" + COLUMN_A4_PESO + "] NUMERIC NOT NULL, " +
            "[" + COLUMN_RESP      + "] INTEGER NOT NULL, " +
            "FOREIGN KEY([" + COLUMN_LTANQUE +"]) REFERENCES " + LoteTanqueConstantes.TABLE_NAME +
            "(" +  LoteTanqueConstantes.COLUMN_ID + ")," +
            "FOREIGN KEY([" + COLUMN_RESP +"]) REFERENCES " + UsuarioConstantes.TABLE_NAME +
            "(" +  UsuarioConstantes.COLUMN_ID + "))";

    String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
