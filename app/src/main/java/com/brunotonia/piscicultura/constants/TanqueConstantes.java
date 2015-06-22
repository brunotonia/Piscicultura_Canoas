package com.brunotonia.piscicultura.constants;

public interface TanqueConstantes {
    String TABLE_NAME    = "tanque";
    String COLUMN_ID     = "id";
    String COLUMN_NUMERO = "numero";
    String COLUMN_ETAPA  = "etapa_lote";
    String COLUMN_ESTADO = "estado";
    String COLUMN_LINHA  = "posicao_linha";
    String COLUMN_COLUNA = "posicao_coluna";

    String CREATE_TABLE = "CREATE TABLE [" + TABLE_NAME + "] ( " +
                    "[" + COLUMN_ID     + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_NUMERO + "] INTEGER UNIQUE NOT NULL, " +
                    "[" + COLUMN_ETAPA  + "] INTEGER NOT NULL, " +
                    "[" + COLUMN_ESTADO + "] INTEGER NOT NULL, " +
                    "[" + COLUMN_LINHA  + "] INTEGER NOT NULL, " +
                    "[" + COLUMN_COLUNA + "] INTEGER NOT NULL, " +
                    "FOREIGN KEY([" + COLUMN_ETAPA  +"]) REFERENCES " + LoteEtapaConstantes.TABLE_NAME +
                    "(" +  LoteEtapaConstantes.COLUMN_ID + "), " +
                    "FOREIGN KEY([" + COLUMN_ESTADO +"]) REFERENCES " + TanqueEstadoContantes.TABLE_NAME +
                    "(" +  TanqueEstadoContantes.COLUMN_ID + "))";

    String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

}
