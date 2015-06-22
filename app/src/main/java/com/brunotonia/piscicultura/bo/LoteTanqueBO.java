package com.brunotonia.piscicultura.bo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.dao.DatabaseHelper;
import com.brunotonia.piscicultura.dao.LoteTanqueDAO;
import com.brunotonia.piscicultura.dao.TanqueDAO;
import com.brunotonia.piscicultura.vo.LoteTanqueVO;

import java.util.List;

public class LoteTanqueBO {

    /* Singleton */
    private static LoteTanqueBO instance = null;

    private LoteTanqueDAO loteTanqueDAO = null;

    private LoteTanqueBO() {
        loteTanqueDAO = new LoteTanqueDAO();
    }

    public static LoteTanqueBO getInstance() {
        if (instance == null) {
            instance = new LoteTanqueBO();
        }
        return instance;
    }

    public boolean adicionar(Context context, LoteTanqueVO loteTanqueVO) throws Exception {
        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;

        try {
            db.beginTransaction();
            b = loteTanqueDAO.adicionar(db, loteTanqueVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            throw e;
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public boolean editar(Context context, LoteTanqueVO loteTanqueVO) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;
        try {
            db.beginTransaction();
            b = loteTanqueDAO.editar(db, loteTanqueVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public List<LoteTanqueVO> selecionar(Context context) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        List<LoteTanqueVO> loteTanques = null;

        try {
            db.beginTransaction();
            loteTanques = loteTanqueDAO.selecionar(db);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            throw e;
        } finally {
            db.endTransaction();
            helper.close();
        }

        return loteTanques;
    }

}
