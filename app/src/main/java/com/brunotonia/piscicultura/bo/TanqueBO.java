package com.brunotonia.piscicultura.bo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.dao.DatabaseHelper;
import com.brunotonia.piscicultura.dao.TanqueDAO;
import com.brunotonia.piscicultura.vo.TanqueVO;

import java.util.List;

public class TanqueBO {

    /* Singleton */
    private static TanqueBO instance = null;

    private TanqueDAO tanqueDAO = null;

    private TanqueBO() {
        tanqueDAO = new TanqueDAO();
    }

    public static TanqueBO getInstance() {
        if (instance == null) {
            instance = new TanqueBO();
        }
        return instance;
    }

    public boolean adicionar(Context context, TanqueVO tanqueVO) throws Exception {
        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;

        try {
            db.beginTransaction();
            b = tanqueDAO.adicionar(db, tanqueVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            throw e;
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public boolean alterarEstado(Context context, Long id, Long novoEstado) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;
        try {
            db.beginTransaction();
            b = tanqueDAO.alterarEstado(db, id, novoEstado);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public boolean editar(Context context, TanqueVO tanqueVO) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;
        try {
            db.beginTransaction();
            b = tanqueDAO.editar(db, tanqueVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public List<TanqueVO> selecionar(Context context) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        List<TanqueVO> tanques = null;

        try {
            db.beginTransaction();
            tanques = tanqueDAO.selecionar(db);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            throw e;
        } finally {
            db.endTransaction();
            helper.close();
        }

        return tanques;
    }

    public List<TanqueVO> selecionarDisponiveis(Context context, Long etapa) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        List<TanqueVO> tanques = null;

        try {
            db.beginTransaction();
            tanques = tanqueDAO.selecionarDisponiveis(db, etapa);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            throw e;
        } finally {
            db.endTransaction();
            helper.close();
        }

        return tanques;
    }

    public TanqueVO selecionar(Context context, Integer numero) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        TanqueVO tanqueVO = null;

        try {
            db.beginTransaction();
            tanqueVO = tanqueDAO.selecionar(db, numero);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            throw e;
        } finally {
            db.endTransaction();
            helper.close();
        }

        return tanqueVO;
    }
}
