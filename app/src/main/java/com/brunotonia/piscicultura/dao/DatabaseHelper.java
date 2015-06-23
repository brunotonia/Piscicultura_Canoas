package com.brunotonia.piscicultura.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.brunotonia.piscicultura.constants.BiometriaConstantes;
import com.brunotonia.piscicultura.constants.DatabaseConstantes;
import com.brunotonia.piscicultura.constants.FornecedorConstantes;
import com.brunotonia.piscicultura.constants.LoteConstantes;
import com.brunotonia.piscicultura.constants.LoteEspecieConstantes;
import com.brunotonia.piscicultura.constants.LoteEtapaConstantes;
import com.brunotonia.piscicultura.constants.LoteTanqueConstantes;
import com.brunotonia.piscicultura.constants.LoteTanquePerdasConstantes;
import com.brunotonia.piscicultura.constants.TanqueConstantes;
import com.brunotonia.piscicultura.constants.TanqueEstadoContantes;
import com.brunotonia.piscicultura.constants.UsuarioEstadoConstantes;
import com.brunotonia.piscicultura.constants.UsuarioConstantes;
import com.brunotonia.piscicultura.constants.UsuarioNivelConstantes;

import java.io.Serializable;

public class DatabaseHelper implements Serializable {

    private DBHelper helper = null;
    private SQLiteDatabase db = null;

    private static final long serialVersionUID = 1L;

    public DatabaseHelper(Context context) {
        helper = new DBHelper(context);
    }

    public SQLiteDatabase open() {
        return db = helper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DatabaseConstantes.DB_NAME, null, DatabaseConstantes.VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(UsuarioEstadoConstantes.CREATE_TABLE);
            db.execSQL(UsuarioEstadoConstantes.INSERT_ESTADO1);
            db.execSQL(UsuarioEstadoConstantes.INSERT_ESTADO2);

            db.execSQL(UsuarioNivelConstantes.CREATE_TABLE);
            db.execSQL(UsuarioNivelConstantes.INSERT_NIVEL1);
            db.execSQL(UsuarioNivelConstantes.INSERT_NIVEL2);
            db.execSQL(UsuarioNivelConstantes.INSERT_NIVEL3);

            db.execSQL(UsuarioConstantes.CREATE_TABLE);
            db.execSQL(UsuarioConstantes.INSERT_ROOT);
            db.execSQL(UsuarioConstantes.INSERT_OPR);
            db.execSQL(UsuarioConstantes.INSERT_PRC);

            db.execSQL(FornecedorConstantes.CREATE_TABLE);

            db.execSQL(LoteEspecieConstantes.CREATE_TABLE);
            db.execSQL(LoteEspecieConstantes.INSERT_ESPECIE1);
            db.execSQL(LoteEspecieConstantes.INSERT_ESPECIE2);
            db.execSQL(LoteEspecieConstantes.INSERT_ESPECIE3);

            db.execSQL(LoteEtapaConstantes.CREATE_TABLE);
            db.execSQL(LoteEtapaConstantes.INSERT_ETAPA1);
            db.execSQL(LoteEtapaConstantes.INSERT_ETAPA2);
            db.execSQL(LoteEtapaConstantes.INSERT_ETAPA3);
            db.execSQL(LoteEtapaConstantes.INSERT_ETAPA4);

            db.execSQL(LoteConstantes.CREATE_TABLE);

            db.execSQL(TanqueEstadoContantes.CREATE_TABLE);
            db.execSQL(TanqueEstadoContantes.INSERT_ESTADO1);
            db.execSQL(TanqueEstadoContantes.INSERT_ESTADO2);
            db.execSQL(TanqueEstadoContantes.INSERT_ESTADO3);

            db.execSQL(TanqueConstantes.CREATE_TABLE);

            db.execSQL(LoteTanqueConstantes.CREATE_TABLE);
            db.execSQL(BiometriaConstantes.CREATE_TABLE);
            db.execSQL(LoteTanquePerdasConstantes.CREATE_TABLE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(BiometriaConstantes.DROP_TABLE);
            db.execSQL(UsuarioConstantes.DROP_TABLE);
            db.execSQL(UsuarioEstadoConstantes.DROP_TABLE);
            db.execSQL(UsuarioNivelConstantes.DROP_TABLE);
            db.execSQL(LoteTanquePerdasConstantes.DROP_TABLE);
            db.execSQL(LoteEspecieConstantes.DROP_TABLE);
            db.execSQL(LoteEtapaConstantes.DROP_TABLE);
            //db.execSQL(RacaoTipoConstantes.DROP_TABLE);
            //db.execSQL(ArracoamentoTanqueConstantes.DROP_TABLE);
            //db.execSQL(ArracoamentoConstantes.DROP_TABLE);
            db.execSQL(TanqueEstadoContantes.DROP_TABLE);
            db.execSQL(TanqueConstantes.DROP_TABLE);
            db.execSQL(LoteTanqueConstantes.DROP_TABLE);
            db.execSQL(LoteConstantes.DROP_TABLE);
            db.execSQL(FornecedorConstantes.DROP_TABLE);

            onCreate(db);
        }

    }

}