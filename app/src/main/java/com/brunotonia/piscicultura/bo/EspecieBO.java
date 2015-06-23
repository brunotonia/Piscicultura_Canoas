package com.brunotonia.piscicultura.bo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.dao.DatabaseHelper;
import com.brunotonia.piscicultura.dao.EspecieDAO;
import com.brunotonia.piscicultura.vo.EspecieVO;

import java.util.List;

public class EspecieBO {
    /* Singleton */
    private static EspecieBO instance = null;

    private EspecieDAO especieDAO = null;

    private EspecieBO() {
        especieDAO = new EspecieDAO();
    }

    public static EspecieBO getInstance() {
        if (instance == null) {
            instance = new EspecieBO();
        }
        return instance;
    }

    public boolean adicionar(Context context, EspecieVO especieVO) throws Exception {
        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;

        try {
            db.beginTransaction();
            b = especieDAO.adicionar(db, especieVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public boolean editar(Context context, EspecieVO especieVO) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;
        try {
            db.beginTransaction();
            b = especieDAO.editar(db, especieVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public List<EspecieVO> selecionar(Context context) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        List<EspecieVO> especies = null;

        try {
            db.beginTransaction();
            especies = especieDAO.selecionar(db);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return especies;
    }
}
