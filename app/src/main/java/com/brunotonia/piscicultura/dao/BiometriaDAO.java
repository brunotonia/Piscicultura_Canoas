package com.brunotonia.piscicultura.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.constants.BiometriaConstantes;
import com.brunotonia.piscicultura.constants.FornecedorConstantes;
import com.brunotonia.piscicultura.vo.BiometriaVO;

import java.util.ArrayList;
import java.util.List;

public class BiometriaDAO {

    public boolean adicionar(SQLiteDatabase db, BiometriaVO biometriaVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(BiometriaConstantes.COLUMN_LTANQUE, biometriaVO.getLoteTanque());
        values.put(BiometriaConstantes.COLUMN_DATA, biometriaVO.getData());
        values.put(BiometriaConstantes.COLUMN_A1_IND, biometriaVO.getA1_ind());
        values.put(BiometriaConstantes.COLUMN_A1_PESO, biometriaVO.getA1_peso());
        values.put(BiometriaConstantes.COLUMN_A2_IND, biometriaVO.getA1_ind());
        values.put(BiometriaConstantes.COLUMN_A2_PESO, biometriaVO.getA1_peso());
        values.put(BiometriaConstantes.COLUMN_A3_IND, biometriaVO.getA1_ind());
        values.put(BiometriaConstantes.COLUMN_A3_PESO, biometriaVO.getA1_peso());
        values.put(BiometriaConstantes.COLUMN_A4_IND, biometriaVO.getA1_ind());
        values.put(BiometriaConstantes.COLUMN_A4_PESO, biometriaVO.getA1_peso());
        values.put(BiometriaConstantes.COLUMN_RESP, biometriaVO.getResponsavel());

        Long l = db.insert(BiometriaConstantes.TABLE_NAME, null, values);

        return (l != -1L);
    }

    public boolean editar(SQLiteDatabase db, BiometriaVO biometriaVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(BiometriaConstantes.COLUMN_ID, biometriaVO.getId());
        values.put(BiometriaConstantes.COLUMN_LTANQUE, biometriaVO.getLoteTanque());
        values.put(BiometriaConstantes.COLUMN_DATA, biometriaVO.getData());
        values.put(BiometriaConstantes.COLUMN_A1_IND, biometriaVO.getA1_ind());
        values.put(BiometriaConstantes.COLUMN_A1_PESO, biometriaVO.getA1_peso());
        values.put(BiometriaConstantes.COLUMN_A2_IND, biometriaVO.getA1_ind());
        values.put(BiometriaConstantes.COLUMN_A2_PESO, biometriaVO.getA1_peso());
        values.put(BiometriaConstantes.COLUMN_A3_IND, biometriaVO.getA1_ind());
        values.put(BiometriaConstantes.COLUMN_A3_PESO, biometriaVO.getA1_peso());
        values.put(BiometriaConstantes.COLUMN_A4_IND, biometriaVO.getA1_ind());
        values.put(BiometriaConstantes.COLUMN_A4_PESO, biometriaVO.getA1_peso());
        values.put(BiometriaConstantes.COLUMN_RESP, biometriaVO.getResponsavel());

        String busca = BiometriaConstantes.COLUMN_ID + " =? ";
        String[] dados = new String[] {biometriaVO.getId().toString()};

        Integer l = db.update(FornecedorConstantes.TABLE_NAME, values, busca, dados);

        return (l > 0);
    }

    public List<BiometriaVO> selecionar(SQLiteDatabase db) throws Exception {
        List<BiometriaVO> biometrias = new ArrayList<BiometriaVO>();

        Cursor cursor = db.query(
                BiometriaConstantes.TABLE_NAME,
                new String[]{BiometriaConstantes.COLUMN_ID, BiometriaConstantes.COLUMN_LTANQUE, BiometriaConstantes.COLUMN_DATA,
                        BiometriaConstantes.COLUMN_A1_IND, BiometriaConstantes.COLUMN_A1_PESO,
                        BiometriaConstantes.COLUMN_A2_IND, BiometriaConstantes.COLUMN_A2_PESO,
                        BiometriaConstantes.COLUMN_A3_IND, BiometriaConstantes.COLUMN_A3_PESO,
                        BiometriaConstantes.COLUMN_A4_IND, BiometriaConstantes.COLUMN_A4_PESO,
                        BiometriaConstantes.COLUMN_RESP},
                null,
                null,
                null,
                null,
                FornecedorConstantes.COLUMN_ID
        );

        while (cursor.moveToNext()) {

            Long id = cursor.getLong(cursor.getColumnIndex(BiometriaConstantes.COLUMN_ID));
            Long lTanque = cursor.getLong(cursor.getColumnIndex(BiometriaConstantes.COLUMN_LTANQUE));
            String data = cursor.getString(cursor.getColumnIndex(BiometriaConstantes.COLUMN_DATA));
            Integer a1i = cursor.getInt(cursor.getColumnIndex(BiometriaConstantes.COLUMN_A1_IND));
            Float a1p = cursor.getFloat(cursor.getColumnIndex(BiometriaConstantes.COLUMN_A1_PESO));
            Integer a2i = cursor.getInt(cursor.getColumnIndex(BiometriaConstantes.COLUMN_A2_IND));
            Float a2p = cursor.getFloat(cursor.getColumnIndex(BiometriaConstantes.COLUMN_A2_PESO));
            Integer a3i = cursor.getInt(cursor.getColumnIndex(BiometriaConstantes.COLUMN_A3_IND));
            Float a3p = cursor.getFloat(cursor.getColumnIndex(BiometriaConstantes.COLUMN_A3_PESO));
            Integer a4i = cursor.getInt(cursor.getColumnIndex(BiometriaConstantes.COLUMN_A4_IND));
            Float a4p = cursor.getFloat(cursor.getColumnIndex(BiometriaConstantes.COLUMN_A4_PESO));
            Long resp = cursor.getLong(cursor.getColumnIndex(BiometriaConstantes.COLUMN_ID));

            BiometriaVO biometriaVO = new BiometriaVO(id, lTanque, data, a1i, a1p, a2i, a2p, a3i, a3p, a4i, a4p, resp);

            biometrias.add(biometriaVO);
        }

        return biometrias;
    }
}
