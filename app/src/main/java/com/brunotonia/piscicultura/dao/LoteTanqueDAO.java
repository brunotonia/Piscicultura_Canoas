package com.brunotonia.piscicultura.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.constants.LoteTanqueConstantes;
import com.brunotonia.piscicultura.vo.LoteTanqueVO;

import java.util.ArrayList;
import java.util.List;

public class LoteTanqueDAO {

    public boolean adicionar(SQLiteDatabase db, LoteTanqueVO loteTanqueVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(LoteTanqueConstantes.COLUMN_LOTE, loteTanqueVO.getLote());
        values.put(LoteTanqueConstantes.COLUMN_TANQUE, loteTanqueVO.getTanque());
        values.put(LoteTanqueConstantes.COLUMN_INICIO, loteTanqueVO.getInicio());

        Long l = db.insert(LoteTanqueConstantes.TABLE_NAME, null, values);

        return (l != -1L);
    }

    public boolean editar(SQLiteDatabase db, LoteTanqueVO loteTanqueVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(LoteTanqueConstantes.COLUMN_ID, loteTanqueVO.getId());
        values.put(LoteTanqueConstantes.COLUMN_LOTE, loteTanqueVO.getLote());
        values.put(LoteTanqueConstantes.COLUMN_TANQUE, loteTanqueVO.getTanque());
        values.put(LoteTanqueConstantes.COLUMN_INICIO, loteTanqueVO.getInicio());
        values.put(LoteTanqueConstantes.COLUMN_FINAL, loteTanqueVO.getFim());

        String busca = LoteTanqueConstantes.COLUMN_ID + " =? ";
        String[] dados = new String[] {loteTanqueVO.getId().toString()};

        Integer l = db.update(LoteTanqueConstantes.TABLE_NAME, values, busca, dados);

        return (l > 0);
    }


    public List<LoteTanqueVO> selecionar(SQLiteDatabase db) throws Exception {
        List<LoteTanqueVO> loteTanques = new ArrayList<LoteTanqueVO>();

        Cursor cursor = db.query(
                LoteTanqueConstantes.TABLE_NAME,
                new String[]{LoteTanqueConstantes.COLUMN_ID, LoteTanqueConstantes.COLUMN_LOTE,
                        LoteTanqueConstantes.COLUMN_TANQUE, LoteTanqueConstantes.COLUMN_INICIO,
                        LoteTanqueConstantes.COLUMN_FINAL},
                null,
                null,
                null,
                null,
                LoteTanqueConstantes.COLUMN_ID
        );

        while (cursor.moveToNext()) {

            Long id = cursor.getLong(cursor.getColumnIndex(LoteTanqueConstantes.COLUMN_ID));
            Long lote = cursor.getLong(cursor.getColumnIndex(LoteTanqueConstantes.COLUMN_LOTE));
            Long tanque = cursor.getLong(cursor.getColumnIndex(LoteTanqueConstantes.COLUMN_TANQUE));
            String inicio = cursor.getString(cursor.getColumnIndex(LoteTanqueConstantes.COLUMN_INICIO));
            String fim = cursor.getString(cursor.getColumnIndex(LoteTanqueConstantes.COLUMN_FINAL));

            LoteTanqueVO loteTanqueVO = new LoteTanqueVO(id, lote, tanque, inicio, fim);

            loteTanques.add(loteTanqueVO);
        }

        return loteTanques;
    }
}
