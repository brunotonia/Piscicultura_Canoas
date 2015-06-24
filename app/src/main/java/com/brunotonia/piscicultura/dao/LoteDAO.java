package com.brunotonia.piscicultura.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.brunotonia.piscicultura.constants.LoteConstantes;
import com.brunotonia.piscicultura.constants.LoteEtapaConstantes;
import com.brunotonia.piscicultura.vo.LoteVO;

import java.util.ArrayList;
import java.util.List;


public class LoteDAO {
    public Long adicionar(SQLiteDatabase db, LoteVO loteVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(LoteConstantes.COLUMN_NUMERO, loteVO.getEspecie());
        values.put(LoteConstantes.COLUMN_FORNECEDOR, loteVO.getFornecedor());
        values.put(LoteConstantes.COLUMN_IND_INICIO, loteVO.getIndv_inicio());
        values.put(LoteConstantes.COLUMN_INICIO, loteVO.getData_inicio());

        Long l = db.insert(LoteConstantes.TABLE_NAME, null, values);

        return (l);
    }

    public boolean editar(SQLiteDatabase db, LoteVO loteVO) throws Exception {

        ContentValues values = new ContentValues();
        values.put(LoteConstantes.COLUMN_NUMERO, loteVO.getEspecie());
        values.put(LoteConstantes.COLUMN_ESPECIE, loteVO.getFornecedor());
        values.put(LoteConstantes.COLUMN_FORNECEDOR, loteVO.getFornecedor());
        values.put(LoteConstantes.COLUMN_IND_INICIO, loteVO.getIndv_inicio());
        values.put(LoteConstantes.COLUMN_INICIO, loteVO.getData_inicio());
        String busca = LoteConstantes.COLUMN_ID + " =? ";
        String[] dados = new String[] {loteVO.getId().toString()};

        Integer l = db.update(LoteConstantes.TABLE_NAME, values, busca, dados);

        return (l > 0);
    }

    public List<LoteVO> selecionarConcluidos(SQLiteDatabase db) throws Exception {
        List<LoteVO> lotes = new ArrayList<LoteVO>();

        Cursor cursor = db.query(
                LoteConstantes.TABLE_NAME,
                new String[]{LoteConstantes.COLUMN_ID, LoteConstantes.COLUMN_NUMERO, LoteConstantes.COLUMN_ESPECIE,
                        LoteConstantes.COLUMN_ETAPA, LoteConstantes.COLUMN_FORNECEDOR, LoteConstantes.COLUMN_IND_INICIO,
                        LoteConstantes.COLUMN_INICIO, LoteConstantes.COLUMN_IND_FINAL, LoteConstantes.COLUMN_IND_FINAL},
                LoteConstantes.COLUMN_ETAPA + " IS ",
                new String[]{LoteEtapaConstantes.VETOR_ETAPAS[3].toString()},
                null,
                null,
                LoteConstantes.COLUMN_ID
        );

        while (cursor.moveToNext()) {

            Long id = cursor.getLong(cursor.getColumnIndex(LoteConstantes.COLUMN_ID));
            Integer numero = cursor.getInt(cursor.getColumnIndex(LoteConstantes.COLUMN_NUMERO));
            Long especie = cursor.getLong(cursor.getColumnIndex(LoteConstantes.COLUMN_ESPECIE));
            Long fornecedor = cursor.getLong(cursor.getColumnIndex(LoteConstantes.COLUMN_FORNECEDOR));
            Long etapa = cursor.getLong(cursor.getColumnIndex(LoteConstantes.COLUMN_ETAPA));
            Integer indv_inicio = cursor.getInt(cursor.getColumnIndex(LoteConstantes.COLUMN_IND_INICIO));
            String inicio = cursor.getString(cursor.getColumnIndex(LoteConstantes.COLUMN_INICIO));
            Integer indv_final = cursor.getInt(cursor.getColumnIndex(LoteConstantes.COLUMN_IND_FINAL));
            String fim = cursor.getString(cursor.getColumnIndex(LoteConstantes.COLUMN_FINAL));

            LoteVO loteVO = new LoteVO(id, numero, especie, etapa, fornecedor, indv_inicio, inicio, indv_final, fim);

            lotes.add(loteVO);
        }

        return lotes;
    }

    public List<LoteVO> selecionarTodos(SQLiteDatabase db) throws Exception {
        List<LoteVO> lotes = new ArrayList<>();

        Cursor cursor = db.query(
                        LoteConstantes.TABLE_NAME,
                new String[]{LoteConstantes.COLUMN_ID, LoteConstantes.COLUMN_NUMERO,LoteConstantes.COLUMN_ESPECIE,
                        LoteConstantes.COLUMN_ETAPA, LoteConstantes.COLUMN_FORNECEDOR, LoteConstantes.COLUMN_IND_INICIO,
                        LoteConstantes.COLUMN_INICIO, LoteConstantes.COLUMN_IND_FINAL, LoteConstantes.COLUMN_IND_FINAL},
                null,
                null,
                null,
                null,
                LoteConstantes.COLUMN_ID
        );

        while (cursor.moveToNext()) {

            Long id = cursor.getLong(cursor.getColumnIndex(LoteConstantes.COLUMN_ID));
            Integer numero = cursor.getInt(cursor.getColumnIndex(LoteConstantes.COLUMN_NUMERO));
            Long especie = cursor.getLong(cursor.getColumnIndex(LoteConstantes.COLUMN_ESPECIE));
            Long fornecedor = cursor.getLong(cursor.getColumnIndex(LoteConstantes.COLUMN_FORNECEDOR));
            Long etapa = cursor.getLong(cursor.getColumnIndex(LoteConstantes.COLUMN_ETAPA));
            Integer indv_inicio = cursor.getInt(cursor.getColumnIndex(LoteConstantes.COLUMN_IND_INICIO));
            String inicio = cursor.getString(cursor.getColumnIndex(LoteConstantes.COLUMN_INICIO));
            Integer indv_final = cursor.getInt(cursor.getColumnIndex(LoteConstantes.COLUMN_IND_FINAL));
            String fim = cursor.getString(cursor.getColumnIndex(LoteConstantes.COLUMN_FINAL));

            LoteVO loteVO = new LoteVO(id, numero, especie, etapa, fornecedor, indv_inicio, inicio, indv_final, fim);

            lotes.add(loteVO);
        }

        return lotes;
    }

}
