package com.brunotonia.piscicultura.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.constants.TanqueConstantes;
import com.brunotonia.piscicultura.constants.UsuarioConstantes;
import com.brunotonia.piscicultura.vo.TanqueVO;

import java.util.ArrayList;
import java.util.List;

public class TanqueDAO {

    public boolean adicionar(SQLiteDatabase db, TanqueVO tanqueVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(TanqueConstantes.COLUMN_NUMERO, tanqueVO.getNumero());
        values.put(TanqueConstantes.COLUMN_ETAPA, tanqueVO.getEtapa());
        values.put(TanqueConstantes.COLUMN_ESTADO, tanqueVO.getEstado());
        values.put(TanqueConstantes.COLUMN_LINHA, tanqueVO.getLinha());
        values.put(TanqueConstantes.COLUMN_COLUNA, tanqueVO.getColuna());

        Long l = db.insert(TanqueConstantes.TABLE_NAME, null, values);

        return (l != -1L);
    }

    public boolean editar(SQLiteDatabase db, TanqueVO tanqueVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(TanqueConstantes.COLUMN_ID, tanqueVO.getId());
        values.put(TanqueConstantes.COLUMN_NUMERO, tanqueVO.getNumero());
        values.put(TanqueConstantes.COLUMN_ETAPA, tanqueVO.getEtapa());
        values.put(TanqueConstantes.COLUMN_ESTADO, tanqueVO.getEstado());
        values.put(TanqueConstantes.COLUMN_LINHA, tanqueVO.getLinha());
        values.put(TanqueConstantes.COLUMN_COLUNA, tanqueVO.getColuna());

        String busca = UsuarioConstantes.COLUMN_ID + " =? ";
        String[] dados = new String[] {tanqueVO.getId().toString()};

        Integer l = db.update(TanqueConstantes.TABLE_NAME, values, busca, dados);

        return (l > 0);
    }

    public List<TanqueVO> selecionar(SQLiteDatabase db) throws Exception {
        List<TanqueVO> tanques = new ArrayList<TanqueVO>();

        Cursor cursor = db.query(
                TanqueConstantes.TABLE_NAME,
                new String[]{TanqueConstantes.COLUMN_ID, TanqueConstantes.COLUMN_NUMERO,
                        TanqueConstantes.COLUMN_ETAPA, TanqueConstantes.COLUMN_ESTADO,
                        TanqueConstantes.COLUMN_LINHA, TanqueConstantes.COLUMN_COLUNA},
                null,
                null,
                null,
                null,
                TanqueConstantes.COLUMN_ID
        );

        while (cursor.moveToNext()) {

            Long id = cursor.getLong(cursor.getColumnIndex(TanqueConstantes.COLUMN_ID));
            Integer numero = cursor.getInt(cursor.getColumnIndex(TanqueConstantes.COLUMN_NUMERO));
            Integer etapa = cursor.getInt(cursor.getColumnIndex(TanqueConstantes.COLUMN_ETAPA));
            Integer estado = cursor.getInt(cursor.getColumnIndex(TanqueConstantes.COLUMN_ESTADO));
            Integer linha = cursor.getInt(cursor.getColumnIndex(TanqueConstantes.COLUMN_LINHA));
            Integer coluna = cursor.getInt(cursor.getColumnIndex(TanqueConstantes.COLUMN_COLUNA));

            TanqueVO tanqueVO = new TanqueVO(id, numero, etapa, estado, linha, coluna);

            tanques.add(tanqueVO);
        }

        return tanques;
    }

}
