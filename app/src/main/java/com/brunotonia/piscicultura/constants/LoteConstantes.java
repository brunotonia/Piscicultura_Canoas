package com.brunotonia.piscicultura.constants;

public interface LoteConstantes {
    String TABLE_NAME        = "lote";
    String COLUMN_ID         = "id";
    String COLUMN_NUMERO     = "numero";
    String COLUMN_ESPECIE    = "especie";
    String COLUMN_FORNECEDOR = "fornecedor";
    String COLUMN_ETAPA      = "etapa";
    String COLUMN_IND_INICIO = "inicio_individuos";
    String COLUMN_INICIO     = "inicio_data";
    String COLUMN_IND_FINAL  = "final_individuos";
    String COLUMN_FINAL      = "final_data";

    String CREATE_TABLE = "CREATE TABLE [" + TABLE_NAME + "] ( " +
            "[" + COLUMN_ID         + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
            "[" + COLUMN_NUMERO     + "] INTEGER UNIQUE NOT NULL, " +
            "[" + COLUMN_ESPECIE    + "] INTEGER NOT NULL, " +
            "[" + COLUMN_FORNECEDOR + "] INTEGER NOT NULL, " +
            "[" + COLUMN_ETAPA      + "] INTEGER NOT NULL, " +
            "[" + COLUMN_IND_INICIO + "] INTEGER NOT NULL, " +
            "[" + COLUMN_INICIO     + "] TEXT NOT NULL, " +
            "[" + COLUMN_IND_FINAL  + "] INTEGER, " +
            "[" + COLUMN_FINAL      + "] TEXT, " +
            "FOREIGN KEY([" + COLUMN_ESPECIE    +"]) REFERENCES " + LoteEspecieConstantes.TABLE_NAME +
            "(" +  LoteEspecieConstantes.COLUMN_ID + "), " +
            "FOREIGN KEY([" + COLUMN_FORNECEDOR +"]) REFERENCES " + FornecedorConstantes.TABLE_NAME +
            "(" +  FornecedorConstantes.COLUMN_ID + "), " +
            "FOREIGN KEY([" + COLUMN_ETAPA      +"]) REFERENCES " + LoteEtapaConstantes.TABLE_NAME +
            "(" +  LoteEtapaConstantes.COLUMN_ID + "))";

    String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
