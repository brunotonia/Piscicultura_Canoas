package com.brunotonia.piscicultura.constants;

public interface LoteTanqueConstantes {
    String TABLE_NAME        = "lote_tanque";
    String COLUMN_ID         = "id";
    String COLUMN_LOTE       = "lote";
    String COLUMN_TANQUE     = "tanque";
    String COLUMN_INICIO     = "inicio_data";
    String COLUMN_FINAL      = "final_data";

    String CREATE_TABLE = "CREATE TABLE [" + TABLE_NAME + "] ( " +
            "[" + COLUMN_ID     + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
            "[" + COLUMN_LOTE   + "] INTEGER UNIQUE NOT NULL, " +
            "[" + COLUMN_TANQUE + "] INTEGER NOT NULL, " +
            "[" + COLUMN_INICIO + "] TEXT NOT NULL, " +
            "[" + COLUMN_FINAL  + "] TEXT, " +
            "FOREIGN KEY([" + COLUMN_LOTE   +"]) REFERENCES " + LoteConstantes.TABLE_NAME +
            "(" +  LoteConstantes.COLUMN_ID + "), " +
            "FOREIGN KEY([" + COLUMN_TANQUE +"]) REFERENCES " + TanqueConstantes.TABLE_NAME +
            "(" +  TanqueConstantes.COLUMN_ID + "))";

    String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
