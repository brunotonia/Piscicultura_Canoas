package com.brunotonia.piscicultura.constants;

public interface FornecedorConstantes {

    String TABLE_NAME      = "fornecedor";
    String COLUMN_ID       = "id";
    String COLUMN_NOME     = "nome";
    String COLUMN_CPF      = "cpf_cnpj";
    String COLUMN_EMAIL    = "email";
    String COLUMN_DDD      = "ddd";
    String COLUMN_TELEFONE = "telefone";
    String COLUMN_CONTATO  = "contato";

    String CREATE_TABLE =
            "CREATE TABLE [" + TABLE_NAME + "] ( " +
                    "[" + COLUMN_ID       + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_NOME     + "] TEXT UNIQUE NOT NULL, " +
                    "[" + COLUMN_CPF      + "] TEXT UNIQUE NOT NULL, " +
                    "[" + COLUMN_EMAIL    + "] TEXT, " +
                    "[" + COLUMN_DDD      + "] TEXT NOT NULL, " +
                    "[" + COLUMN_TELEFONE + "] TEXT NOT NULL, " +
                    "[" + COLUMN_CONTATO  + "] TEXT )";

    String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

}


