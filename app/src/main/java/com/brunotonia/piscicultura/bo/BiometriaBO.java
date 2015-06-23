package com.brunotonia.piscicultura.bo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.dao.BiometriaDAO;
import com.brunotonia.piscicultura.dao.DatabaseHelper;
import com.brunotonia.piscicultura.dao.FornecedorDAO;
import com.brunotonia.piscicultura.vo.BiometriaVO;
import java.util.List;

public class BiometriaBO {
    /* Singleton */
    private static BiometriaBO instance = null;

    private BiometriaDAO biometriaDAO = null;

    private BiometriaBO() {
        biometriaDAO = new BiometriaDAO();
    }

    public static BiometriaBO getInstance() {
        if (instance == null) {
            instance = new BiometriaBO();
        }
        return instance;
    }

    public boolean adicionar(Context context, BiometriaVO biometriaVO) throws Exception {
        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;

        try {
            db.beginTransaction();
            b = biometriaDAO.adicionar(db, biometriaVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public boolean editar(Context context, BiometriaVO biometriaVO) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;
        try {
            db.beginTransaction();
            b = biometriaDAO.editar(db, biometriaVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public List<BiometriaVO> selecionar(Context context) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        List<BiometriaVO> biometrias = null;

        try {
            db.beginTransaction();
            biometrias = biometriaDAO.selecionar(db);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return biometrias;
    }
}
