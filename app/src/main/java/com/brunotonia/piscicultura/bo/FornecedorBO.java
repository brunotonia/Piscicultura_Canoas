package com.brunotonia.piscicultura.bo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.dao.DatabaseHelper;
import com.brunotonia.piscicultura.dao.FornecedorDAO;
import com.brunotonia.piscicultura.vo.FornecedorVO;

import java.util.List;

public class FornecedorBO {

    /* Singleton */
    private static FornecedorBO instance = null;

    private FornecedorDAO fornecedorDAO = null;

    private FornecedorBO() {
        fornecedorDAO = new FornecedorDAO();
    }

    public static FornecedorBO getInstance() {
        if (instance == null) {
            instance = new FornecedorBO();
        }
        return instance;
    }

    public boolean adicionar(Context context, FornecedorVO fornecedorVO) throws Exception {
        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;

        try {
            db.beginTransaction();
            b = fornecedorDAO.adicionar(db, fornecedorVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            throw e;
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public boolean editar(Context context, FornecedorVO fornecedorVO) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;
        try {
            db.beginTransaction();
            b = fornecedorDAO.editar(db, fornecedorVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public List<FornecedorVO> selecionar(Context context) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        List<FornecedorVO> fornecedores = null;

        try {
            db.beginTransaction();
            fornecedores = fornecedorDAO.selecionar(db);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            throw e;
        } finally {
            db.endTransaction();
            helper.close();
        }

        return fornecedores;
    }

}
