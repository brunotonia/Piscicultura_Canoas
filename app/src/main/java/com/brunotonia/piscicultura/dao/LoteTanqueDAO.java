package com.brunotonia.piscicultura.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.constants.LoteTanqueContantes;
import com.brunotonia.piscicultura.constants.LoteTanquePerdasConstantes;
import com.brunotonia.piscicultura.constants.TanqueConstantes;
import com.brunotonia.piscicultura.constants.UsuarioConstantes;
import com.brunotonia.piscicultura.vo.LoteTanqueVO;
import com.brunotonia.piscicultura.vo.TanqueVO;

import java.util.ArrayList;
import java.util.List;

public class LoteTanqueDAO {

    public boolean adicionar(SQLiteDatabase db, LoteTanqueVO loteTanqueVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(LoteTanqueContantes.COLUMN_LOTE, loteTanqueVO.getLote());
        values.put(LoteTanqueContantes.COLUMN_TANQUE, loteTanqueVO.getTanque());
        values.put(LoteTanqueContantes.COLUMN_INICIO, loteTanqueVO.getInicio());

        Long l = db.insert(LoteTanqueContantes.TABLE_NAME, null, values);

        return (l != -1L);
    }

    public boolean editar(SQLiteDatabase db, LoteTanqueVO loteTanqueVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(LoteTanqueContantes.COLUMN_ID, loteTanqueVO.getId());
        values.put(LoteTanqueContantes.COLUMN_LOTE, loteTanqueVO.getLote());
        values.put(LoteTanqueContantes.COLUMN_TANQUE, loteTanqueVO.getTanque());
        values.put(LoteTanqueContantes.COLUMN_INICIO, loteTanqueVO.getInicio());
        values.put(LoteTanqueContantes.COLUMN_FINAL, loteTanqueVO.getFim());

        String busca = LoteTanqueContantes.COLUMN_ID + " =? ";
        String[] dados = new String[] {loteTanqueVO.getId().toString()};

        Integer l = db.update(LoteTanqueContantes.TABLE_NAME, values, busca, dados);

        return (l > 0);
    }

    public List<LoteTanqueVO> selecionar(SQLiteDatabase db) throws Exception {
        List<LoteTanqueVO> loteTanques = new ArrayList<LoteTanqueVO>();

        Cursor cursor = db.query(
                LoteTanqueContantes.TABLE_NAME,
                new String[]{LoteTanqueContantes.COLUMN_ID, LoteTanqueContantes.COLUMN_LOTE,
                        LoteTanqueContantes.COLUMN_TANQUE, LoteTanqueContantes.COLUMN_INICIO,
                        LoteTanqueContantes.COLUMN_FINAL},
                null,
                null,
                null,
                null,
                LoteTanqueContantes.COLUMN_ID
        );

        while (cursor.moveToNext()) {

            Long id = cursor.getLong(cursor.getColumnIndex(LoteTanqueContantes.COLUMN_ID));
            Long lote = cursor.getLong(cursor.getColumnIndex(LoteTanqueContantes.COLUMN_LOTE));
            Long tanque = cursor.getLong(cursor.getColumnIndex(LoteTanqueContantes.COLUMN_TANQUE));
            String inicio = cursor.getString(cursor.getColumnIndex(LoteTanqueContantes.COLUMN_INICIO));
            String fim = cursor.getString(cursor.getColumnIndex(LoteTanqueContantes.COLUMN_FINAL));

            LoteTanqueVO loteTanqueVO = new LoteTanqueVO(id, lote, tanque, inicio, fim);

            loteTanques.add(loteTanqueVO);
        }

        return loteTanques;
    }
}
