package com.brunotonia.piscicultura.view;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.brunotonia.piscicultura.R;
import com.brunotonia.piscicultura.bo.LoteBO;
import com.brunotonia.piscicultura.bo.UsuarioBO;
import com.brunotonia.piscicultura.util.ListUtil;
import com.brunotonia.piscicultura.vo.LoteVO;
import com.brunotonia.piscicultura.vo.SessaoVO;
import com.brunotonia.piscicultura.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

public class LoteListarActivity extends ListActivity {

    /* Variáveis de Sessão */
    private Intent it = null;
    private Bundle params = null;
    private SessaoVO sessaoVO = null;
    private String operacao = null;

    /* Variáveis dos Elementos de Tela */
    private List<LoteVO> lotes = new ArrayList<>();
    private LoteVO loteVO = null;
    private LoteBO loteBO = LoteBO.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lote_listar);

        /* Recupera params */
        recuperarParams();

        /* Gera a Lista */
        try {
            carregarUsuarios(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /* Gera lista de Usuários */
    private void carregarUsuarios(Context context) throws Exception {
        lotes = loteBO.selecionarTodos(context);

        BaseAdapter adapter = new ArrayAdapter<>(
                LoteListarActivity.this, // CONTEXTO/TELA
                android.R.layout.simple_list_item_single_choice,  // LAYOUT DO ITEM
                ListUtil.convertToStringList(lotes)); // LISTA DE OBJETOS

        getListView().setChoiceMode(
                ListView.CHOICE_MODE_SINGLE);

        setListAdapter(adapter);
    }

    /* Recuperar params */
    private void recuperarParams() {
        it = getIntent();
        params = it.getExtras();
        sessaoVO = new SessaoVO(params.getLong("sessaoId"), params.getString("sessaoUsuario"), params.getInt("sessaoNivel"));
    }

    /* Carregar params */
    private void carregarParams() {
        params = new Bundle();
        params.putLong("sessaoId", sessaoVO.getId());
        params.putString("sessaoUsuario", sessaoVO.getNome());
        params.putInt("sessaoNivel", sessaoVO.getNivel());

        params.putLong("loteID", loteVO.getId());
        params.putLong("loteEspecie", loteVO.getEspecie());
        params.putLong("loteFornecedor", loteVO.getFornecedor());
        params.putLong("loteEtapa", loteVO.getEtapa());
        params.putInt("loteIndvInicial", loteVO.getIndv_final());
        params.putString("loteDataInicial", loteVO.getData_inicio());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case (R.id.action_GUsuarios) :
                it = new Intent(this, UsuarioActivity.class);
                it.putExtras(params);
                startActivity(it);
                return true;
            case (R.id.action_GFornecedores) :
                it = new Intent(this, FornecedorActivity.class);
                it.putExtras(params);
                startActivity(it);
                return true;
            case (R.id.action_GEspecies) :
                it = new Intent(this, EspecieActivity.class);
                it.putExtras(params);
                startActivity(it);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
