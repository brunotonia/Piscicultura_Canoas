package com.brunotonia.piscicultura.view;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.brunotonia.piscicultura.R;
import com.brunotonia.piscicultura.bo.EspecieBO;
import com.brunotonia.piscicultura.util.ListUtil;
import com.brunotonia.piscicultura.vo.EspecieVO;
import com.brunotonia.piscicultura.vo.SessaoVO;

import java.util.ArrayList;
import java.util.List;

public class EspecieListarActivity extends ListActivity {

    /* Variáveis de Sessão */
    private Intent it = null;
    private Bundle params = null;
    private SessaoVO sessaoVO = null;
    private String operacao = null;

    /* Variáveis dos Elementos de Tela */
    private List<EspecieVO> especies = new ArrayList<>();
    private EspecieVO especieVO = null;
    private EspecieBO especieBO = EspecieBO.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lote_especie_listar);

        /* Recupera params */
        recuperarParams();

        /* Inicializa Elementos de Interface */

        /* Gera a Lista */
        try {
            carregarEspecies(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Listener da Lista de Usuários */
        getListView().setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        especieVO = especies.get(position);
                        it = new Intent(EspecieListarActivity.this, EspecieAdicionarActivity.class);
                        carregarParams();
                        it.putExtras(params);
                        startActivity(it);
                    }
                });

         /* Gera a Lista */
        try {
            carregarEspecies(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /* Gera lista de Especies */
    private void carregarEspecies(Context context) throws Exception {
        especies = especieBO.selecionar(context);

        BaseAdapter adapter = new ArrayAdapter<>(
                EspecieListarActivity.this, // CONTEXTO/TELA
                android.R.layout.simple_list_item_single_choice,  // LAYOUT DO ITEM
                ListUtil.convertToStringList(especies)); // LISTA DE OBJETOS

        getListView().setChoiceMode(
                ListView.CHOICE_MODE_SINGLE);

        setListAdapter(adapter);
    }

    /* Recuperar params */
    private void recuperarParams() {
        it = getIntent();
        params = it.getExtras();
        sessaoVO = new SessaoVO(params.getLong("sessaoId"), params.getString("sessaoUsuario"), params.getInt("sessaoNivel"));
        operacao = params.getString("especieOperacao");
    }

    /* Carregar params */
    private void carregarParams() {
        params = new Bundle();
        params.putLong("sessaoId", sessaoVO.getId());
        params.putString("sessaoUsuario", sessaoVO.getNome());
        params.putInt("sessaoNivel", sessaoVO.getNivel());

        params.putString("especieOperacao", operacao);

        params.putLong("especieID", especieVO.getId());
        params.putString("especieNome", especieVO.getEspecie());
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
                carregarParams();
                it.putExtras(params);
                startActivity(it);
                return true;
            case (R.id.action_GFornecedores) :
                it = new Intent(this, FornecedorActivity.class);
                carregarParams();
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
