package com.brunotonia.piscicultura.bo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.dao.DatabaseHelper;
import com.brunotonia.piscicultura.dao.UsuarioDAO;
import com.brunotonia.piscicultura.vo.SessaoVO;
import com.brunotonia.piscicultura.vo.UsuarioVO;

import java.io.Serializable;
import java.util.List;

public class UsuarioBO implements Serializable {

    /* Singleton */
    private static UsuarioBO instance = null;

    private UsuarioDAO usuarioDAO = null;

    private UsuarioBO() {
        usuarioDAO = new UsuarioDAO();
    }

    public static UsuarioBO getInstance() {
        if (instance == null) {
            instance = new UsuarioBO();
        }
        return instance;
    }

    public SessaoVO login(Context context, String usuario, String senha) throws Exception{

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        SessaoVO sessaoVO = new SessaoVO(-1L, "Erro", -1);

        try {
            db.beginTransaction();
            sessaoVO = usuarioDAO.login(db, usuario, senha);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            throw e;
        } finally {
            db.endTransaction();
            helper.close();
        }
        return sessaoVO;
    }

    public boolean adicionar(Context context, UsuarioVO usuarioVO) throws Exception {
        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;

        try {
            db.beginTransaction();
            b = usuarioDAO.adicionar(db, usuarioVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            throw e;
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public boolean editar(Context context, UsuarioVO usuarioVO) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;
        try {
            db.beginTransaction();
            b = usuarioDAO.editar(db, usuarioVO);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public boolean alterarSenha(Context context, Long id, String senhaAtual, String senhaNova) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        boolean b = false;
        try {
            db.beginTransaction();
            b = usuarioDAO.alterarSenha(db, id, senhaAtual, senhaNova);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            helper.close();
        }

        return b;
    }

    public List<UsuarioVO> selecionar(Context context) throws Exception {

        /* Variáveis do BD */
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.open();

        /* Variáveis do Método*/
        List<UsuarioVO> usuarios = null;

        try {
            db.beginTransaction();
            usuarios = usuarioDAO.selecionar(db);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            throw e;
        } finally {
            db.endTransaction();
            helper.close();
        }

        return usuarios;
    }

}
