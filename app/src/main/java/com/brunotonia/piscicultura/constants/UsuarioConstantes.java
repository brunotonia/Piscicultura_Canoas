package com.brunotonia.piscicultura.constants;

public interface UsuarioConstantes {
    String TABLE_NAME     = "usuario";
    String COLUMN_ID      = "id";
    String COLUMN_NOME    = "nome";
    String COLUMN_USUARIO = "login";
    String COLUMN_SENHA   = "senha";
    String COLUMN_NIVEL   = "nivel";
    String COLUMN_ESTADO = "estado";

    String CREATE_TABLE =
            "CREATE TABLE [" + TABLE_NAME + "] ( " +
                    "[" + COLUMN_ID      + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_NOME    + "] TEXT NOT NULL, " +
                    "[" + COLUMN_USUARIO + "] TEXT UNIQUE NOT NULL, " +
                    "[" + COLUMN_SENHA   + "] TEXT NOT NULL, " +
                    "[" + COLUMN_NIVEL   + "] INTEGER NOT NULL, " +
                    "[" + COLUMN_ESTADO  + "] INTEGER NOT NULL, " +
                    "FOREIGN KEY([" + COLUMN_NIVEL +"]) REFERENCES " + UsuarioNivelConstantes.TABLE_NAME +
                    "(" +  UsuarioNivelConstantes.COLUMN_ID + "), " +
                    "FOREIGN KEY([" + COLUMN_ESTADO +"]) REFERENCES " + UsuarioEstadoConstantes.TABLE_NAME +
                    "(" +  UsuarioEstadoConstantes.COLUMN_ID + "))";

    String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    String INSERT_ROOT = "INSERT INTO " + TABLE_NAME + " values (" +
            DatabaseConstantes.DADO_NULO + ",  \"Root\", \"root\", \"root\", " +
            UsuarioNivelConstantes.VETOR_NIVEIS[0] + ", " + UsuarioEstadoConstantes.VETOR_ESTADOS[0] + ")";
    String INSERT_OPR = "INSERT INTO " + TABLE_NAME + " values (" +
            DatabaseConstantes.DADO_NULO + ",  \"Operacional\", \"operacional\", \"operacional\"," +
            UsuarioNivelConstantes.VETOR_NIVEIS[1] + ", " + UsuarioEstadoConstantes.VETOR_ESTADOS[0] + ")";
    String INSERT_PRC = "INSERT INTO " + TABLE_NAME + " values (" +
            DatabaseConstantes.DADO_NULO + ",  \"Parceiro\", \"parceiro\", \"parceiro\"," +
            UsuarioNivelConstantes.VETOR_NIVEIS[2] + ", " + UsuarioEstadoConstantes.VETOR_ESTADOS[0] + ")";
}
