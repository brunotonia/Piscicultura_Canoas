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
import com.brunotonia.piscicultura.bo.FornecedorBO;
import com.brunotonia.piscicultura.util.ListUtil;
import com.brunotonia.piscicultura.vo.FornecedorVO;
import com.brunotonia.piscicultura.vo.SessaoVO;

import java.util.ArrayList;
import java.util.List;

public class FornecedorListarActivity extends ListActivity {

    /* Variáveis de Sessão */
    private Intent it = null;
    private Bundle params = null;
    private SessaoVO sessaoVO = null;
    private String operacao = null;


    /* Variáveis dos Elementos de Tela */
    private List<FornecedorVO> fornecedores = new ArrayList<>();
    private FornecedorVO fornecedorVO = null;
    private FornecedorBO fornecedorBO = FornecedorBO.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fornecedor_listar);

        /* Recupera params */
        recuperarParams();

        /* Inicializa Elementos de Interface */

        /* Gera a Lista */
        try {
            carregarFornecedores(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Listener da Lista de Usuários */
        getListView().setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        fornecedorVO = fornecedores.get(position);
                        it = new Intent(FornecedorListarActivity.this, FornecedorAdicionarActivity.class);
                        carregarParams();
                        it.putExtras(params);
                        startActivity(it);
                    }
                });

         /* Gera a Lista */
        try {
            carregarFornecedores(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /* Gera lista de Fornecedores */
    private void carregarFornecedores(Context context) throws Exception {
        fornecedores = fornecedorBO.selecionar(context);

        BaseAdapter adapter = new ArrayAdapter<>(
                FornecedorListarActivity.this, // CONTEXTO/TELA
                android.R.layout.simple_list_item_single_choice,  // LAYOUT DO ITEM
                ListUtil.convertToStringList(fornecedores)); // LISTA DE OBJETOS

        getListView().setChoiceMode(
                ListView.CHOICE_MODE_SINGLE);

        setListAdapter(adapter);
    }

    /* Recuperar params */
    private void recuperarParams() {
        it = getIntent();
        params = it.getExtras();
        sessaoVO = new SessaoVO(params.getLong("sessaoId"), params.getString("sessaoUsuario"), params.getInt("sessaoNivel"));
        operacao = params.getString("fornecedorOperacao");
    }

    /* Carregar params */
    private void carregarParams() {
        params = new Bundle();
        params.putLong("sessaoId", sessaoVO.getId());
        params.putString("sessaoUsuario", sessaoVO.getNome());
        params.putInt("sessaoNivel", sessaoVO.getNivel());

        params.putString("fornecedorOperacao", operacao);

        params.putLong("fornecedorID", fornecedorVO.getId());
        params.putString("fornecedorNome", fornecedorVO.getNome());
        params.putString("fornecedorCpf", fornecedorVO.getCpf());
        params.putString("fornecedorEmail", fornecedorVO.getEmail());
        params.putString("fornecedorDdd", fornecedorVO.getDdd());
        params.putString("fornecedorTelefone", fornecedorVO.getTelefone());
        params.putString("fornecedorContato", fornecedorVO.getContato());
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
        }


        return super.onOptionsItemSelected(item);
    }
}
