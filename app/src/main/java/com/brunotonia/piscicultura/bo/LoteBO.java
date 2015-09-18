package com.brunotonia.piscicultura.bo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.dao.DatabaseHelper;
import com.brunotonia.piscicultura.dao.LoteDAO;
import com.brunotonia.piscicultura.vo.LoteVO;

import java.util.List;
public class LoteBO {

    /* Singleton */
    private static LoteBO instance = null;

    private LoteDAO loteDAO = null;

    private LoteBO() {
        loteDAO = new LoteDAO();
    }

    public static LoteBO getInstance() {
        if (instance == null) {
            instance = new LoteBO();
        }
        return instance;
    }

    public Long adicionar(Context context, LoteVO loteVO) throws Exception {
        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        Long b = -1L;

        try {
            db.beginTransaction();
            b = loteDAO.adicionar(db, loteVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public boolean validaAdicao (Long resultadoAdicionar) {
        return resultadoAdicionar  != -1L;
    }

    public boolean editar(Context context, LoteVO loteVO) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;
        try {
            db.beginTransaction();
            b = loteDAO.editar(db, loteVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public List<LoteVO> selecionarTodos(Context context) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        List<LoteVO> lotes = null;

        try {
            db.beginTransaction();
            lotes = loteDAO.selecionarTodos(db);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return lotes;
    }

    public List<LoteVO> selecionarConcluidos(Context context) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        List<LoteVO> lotes = null;

        try {
            db.beginTransaction();
            lotes = loteDAO.selecionarConcluidos(db);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return lotes;
    }

    public List<LoteVO> selecionarAtivos(Context context) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        List<LoteVO> lotes = null;

        try {
            db.beginTransaction();
            lotes = loteDAO.selecionarAtivos(db);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return lotes;
    }
}
