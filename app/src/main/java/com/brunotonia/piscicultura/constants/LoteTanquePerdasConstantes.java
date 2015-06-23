package com.brunotonia.piscicultura.constants;

public interface LoteTanquePerdasConstantes {
    String TABLE_NAME      = "lote_tanque_perdas";
    String COLUMN_ID       = "id";
    String COLUMN_UNIDADES = "unidades";
    String COLUMN_LTANQUE  = "lote_tanque";
    String COLUMN_DATA     = "data";
    String COLUMN_OBS      = "observacao";

    String CREATE_TABLE = "CREATE TABLE [" + TABLE_NAME + "] ( " +
            "[" + COLUMN_ID       + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
            "[" + COLUMN_UNIDADES + "] INTEGER NOT NULL, " +
            "[" + COLUMN_LTANQUE  + "] INTEGER NOT NULL, " +
            "[" + COLUMN_DATA     + "] TEXT NOT NULL, " +
            "[" + COLUMN_OBS      + "] TEXT, " +
            "FOREIGN KEY([" + COLUMN_LTANQUE +"]) REFERENCES " + LoteTanqueConstantes.TABLE_NAME +
            "(" +  TanqueEstadoContantes.COLUMN_ID + "))";

    String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
