package com.brunotonia.piscicultura.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.constants.FornecedorConstantes;
import com.brunotonia.piscicultura.constants.TanqueConstantes;
import com.brunotonia.piscicultura.constants.UsuarioConstantes;
import com.brunotonia.piscicultura.vo.FornecedorVO;
import com.brunotonia.piscicultura.vo.TanqueVO;

import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    public boolean adicionar(SQLiteDatabase db, FornecedorVO fornecedorVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(FornecedorConstantes.COLUMN_NOME, fornecedorVO.getNome());
        values.put(FornecedorConstantes.COLUMN_CPF, fornecedorVO.getCpf());
        values.put(FornecedorConstantes.COLUMN_EMAIL, fornecedorVO.getEmail());
        values.put(FornecedorConstantes.COLUMN_DDD, fornecedorVO.getDdd());
        values.put(FornecedorConstantes.COLUMN_TELEFONE, fornecedorVO.getTelefone());
        values.put(FornecedorConstantes.COLUMN_CONTATO, fornecedorVO.getContato());

        Long l = db.insert(FornecedorConstantes.TABLE_NAME, null, values);

        return (l != -1L);
    }

    public boolean editar(SQLiteDatabase db, FornecedorVO fornecedorVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(FornecedorConstantes.COLUMN_ID, fornecedorVO.getId());
        values.put(FornecedorConstantes.COLUMN_NOME, fornecedorVO.getNome());
        values.put(FornecedorConstantes.COLUMN_CPF, fornecedorVO.getCpf());
        values.put(FornecedorConstantes.COLUMN_EMAIL, fornecedorVO.getEmail());
        values.put(FornecedorConstantes.COLUMN_DDD, fornecedorVO.getDdd());
        values.put(FornecedorConstantes.COLUMN_TELEFONE, fornecedorVO.getTelefone());
        values.put(FornecedorConstantes.COLUMN_CONTATO, fornecedorVO.getContato());

        String busca = FornecedorConstantes.COLUMN_ID + " =? ";
        String[] dados = new String[] {fornecedorVO.getId().toString()};

        Integer l = db.update(FornecedorConstantes.TABLE_NAME, values, busca, dados);

        return (l > 0);
    }

    public List<FornecedorVO> selecionar(SQLiteDatabase db) throws Exception {
        List<FornecedorVO> fornecedores = new ArrayList<FornecedorVO>();

        Cursor cursor = db.query(
                FornecedorConstantes.TABLE_NAME,
                new String[]{FornecedorConstantes.COLUMN_ID, FornecedorConstantes.COLUMN_NOME,
                        FornecedorConstantes.COLUMN_CPF, FornecedorConstantes.COLUMN_EMAIL,
                        FornecedorConstantes.COLUMN_DDD, FornecedorConstantes.COLUMN_TELEFONE,
                        FornecedorConstantes.COLUMN_CONTATO},
                null,
                null,
                null,
                null,
                FornecedorConstantes.COLUMN_ID
        );

        while (cursor.moveToNext()) {

            Long id = cursor.getLong(cursor.getColumnIndex(FornecedorConstantes.COLUMN_ID));
            String nome = cursor.getString(cursor.getColumnIndex(FornecedorConstantes.COLUMN_NOME));
            String cpf = cursor.getString(cursor.getColumnIndex(FornecedorConstantes.COLUMN_CPF));
            String email = cursor.getString(cursor.getColumnIndex(FornecedorConstantes.COLUMN_EMAIL));
            String ddd = cursor.getString(cursor.getColumnIndex(FornecedorConstantes.COLUMN_DDD));
            String telefone = cursor.getString(cursor.getColumnIndex(FornecedorConstantes.COLUMN_TELEFONE));
            String contato = cursor.getString(cursor.getColumnIndex(FornecedorConstantes.COLUMN_CONTATO));

            FornecedorVO fornecedorVO = new FornecedorVO(id, nome, cpf, email, ddd, telefone, contato);

            fornecedores.add(fornecedorVO);
        }

        return fornecedores;
    }

}
