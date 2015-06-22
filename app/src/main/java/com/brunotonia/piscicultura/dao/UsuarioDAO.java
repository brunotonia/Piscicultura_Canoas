package com.brunotonia.piscicultura.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.constants.UsuarioConstantes;
import com.brunotonia.piscicultura.vo.SessaoVO;
import com.brunotonia.piscicultura.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {


    public boolean adicionar(SQLiteDatabase db, UsuarioVO usuarioVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(UsuarioConstantes.COLUMN_NOME, usuarioVO.getNome());
        values.put(UsuarioConstantes.COLUMN_USUARIO, usuarioVO.getUsuario());
        values.put(UsuarioConstantes.COLUMN_SENHA, usuarioVO.getSenha());
        values.put(UsuarioConstantes.COLUMN_NIVEL, usuarioVO.getNivel());
        values.put(UsuarioConstantes.COLUMN_ESTADO, usuarioVO.getAtivo());

        Long l = db.insert(UsuarioConstantes.TABLE_NAME, null, values);

        return (l != -1L);
    }

    public boolean editar(SQLiteDatabase db, UsuarioVO usuarioVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(UsuarioConstantes.COLUMN_ID, usuarioVO.getId());
        values.put(UsuarioConstantes.COLUMN_NOME, usuarioVO.getNome());
        values.put(UsuarioConstantes.COLUMN_USUARIO, usuarioVO.getUsuario());
        values.put(UsuarioConstantes.COLUMN_SENHA, usuarioVO.getSenha());
        values.put(UsuarioConstantes.COLUMN_NIVEL, usuarioVO.getNivel());
        values.put(UsuarioConstantes.COLUMN_ESTADO, usuarioVO.getAtivo());

        String busca = UsuarioConstantes.COLUMN_ID + "= ?";
        String[] dados = new String[] {usuarioVO.getId().toString()};

        Integer l = db.update(UsuarioConstantes.TABLE_NAME, values, busca, dados);

        return (l > 0);
    }

    public boolean alterarSenha(SQLiteDatabase db, Long id, String senhaAtual, String senhaNova) throws Exception {

        ContentValues values = new ContentValues();
        values.put(UsuarioConstantes.COLUMN_SENHA, senhaNova);

        String busca = UsuarioConstantes.COLUMN_ID + "= ? AND " + UsuarioConstantes.COLUMN_SENHA + " = ?";
        String[] dados = new String[] {id.toString(), senhaAtual};

        Integer l = db.update(UsuarioConstantes.TABLE_NAME, values, busca, dados);

        return (l > 0);
    }

    public SessaoVO login(SQLiteDatabase db, String usuario, String senha) throws Exception {

        SessaoVO sessaoVO = new SessaoVO(-1L, "Erro", -1);

        String colunas[] = {UsuarioConstantes.COLUMN_ID, UsuarioConstantes.COLUMN_NOME, UsuarioConstantes.COLUMN_NIVEL};
        String selecao = UsuarioConstantes.COLUMN_USUARIO + " =? AND " + UsuarioConstantes.COLUMN_SENHA + " =? AND "
                + UsuarioConstantes.COLUMN_ESTADO + " =? ";
        String valores[] = {usuario,
                senha,
                Integer.toString(0)};

        Cursor cursor =  db.query(UsuarioConstantes.TABLE_NAME, colunas, selecao, valores, null, null, null, null);

        if (cursor.moveToFirst()) {
            Long id = cursor.getLong(cursor.getColumnIndex(UsuarioConstantes.COLUMN_ID));
            String nome = cursor.getString(cursor.getColumnIndex(UsuarioConstantes.COLUMN_NOME));
            Integer nivel = cursor.getInt(cursor.getColumnIndex(UsuarioConstantes.COLUMN_NIVEL));
            sessaoVO = new SessaoVO(id, nome, nivel);
        }

        return sessaoVO;
    }

    public List<UsuarioVO> selecionar(SQLiteDatabase db) throws Exception {
        List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();

        Cursor cursor = db.query(
                UsuarioConstantes.TABLE_NAME,
                new String[] {UsuarioConstantes.COLUMN_ID, UsuarioConstantes.COLUMN_NOME,
                        UsuarioConstantes.COLUMN_USUARIO, UsuarioConstantes.COLUMN_SENHA,
                        UsuarioConstantes.COLUMN_NIVEL, UsuarioConstantes.COLUMN_ESTADO},
                null,
                null,
                null,
                null,
                UsuarioConstantes.COLUMN_NOME
        );

        while (cursor.moveToNext()) {

            Long id = cursor.getLong(cursor.getColumnIndex(UsuarioConstantes.COLUMN_ID));
            String nome = cursor.getString(cursor.getColumnIndex(UsuarioConstantes.COLUMN_NOME));
            String usuario = cursor.getString(cursor.getColumnIndex(UsuarioConstantes.COLUMN_USUARIO));
            String senha = cursor.getString(cursor.getColumnIndex(UsuarioConstantes.COLUMN_SENHA));
            Long nivel = cursor.getLong(cursor.getColumnIndex(UsuarioConstantes.COLUMN_NIVEL));
            Long estado = cursor.getLong(cursor.getColumnIndex(UsuarioConstantes.COLUMN_ESTADO));

            UsuarioVO usuarioVO = new UsuarioVO(id, nome, usuario, senha, nivel, estado);

            usuarios.add(usuarioVO);
        }

        return usuarios;
    }
}
