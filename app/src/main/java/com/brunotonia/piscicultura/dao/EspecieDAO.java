package com.brunotonia.piscicultura.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.constants.EspecieConstantes;
import com.brunotonia.piscicultura.vo.EspecieVO;

import java.util.ArrayList;
import java.util.List;

public class EspecieDAO {

    public boolean adicionar(SQLiteDatabase db, EspecieVO especieVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(EspecieConstantes.COLUMN_ESPECIE, especieVO.getEspecie());

        Long l = db.insert(EspecieConstantes.TABLE_NAME, null, values);

        return (l != -1L);
    }

    public boolean editar(SQLiteDatabase db, EspecieVO especieVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(EspecieConstantes.COLUMN_ID, especieVO.getId());
        values.put(EspecieConstantes.COLUMN_ESPECIE, especieVO.getEspecie());

        String busca = EspecieConstantes.COLUMN_ID + " =? ";
        String[] dados = new String[] {especieVO.getId().toString()};

        Integer l = db.update(EspecieConstantes.TABLE_NAME, values, busca, dados);

        return (l > 0);
    }

    public List<EspecieVO> selecionar(SQLiteDatabase db) throws Exception {
        List<EspecieVO> especies = new ArrayList<EspecieVO>();

        Cursor cursor = db.query(
                EspecieConstantes.TABLE_NAME,
                new String[]{EspecieConstantes.COLUMN_ID, EspecieConstantes.COLUMN_ESPECIE},
                null,
                null,
                null,
                null,
                EspecieConstantes.COLUMN_ID
        );

        while (cursor.moveToNext()) {

            Long id = cursor.getLong(cursor.getColumnIndex(EspecieConstantes.COLUMN_ID));
            String especie = cursor.getString(cursor.getColumnIndex(EspecieConstantes.COLUMN_ESPECIE));

            EspecieVO especieVO = new EspecieVO(id, especie);

            especies.add(especieVO);
        }

        return especies;
    }
}
