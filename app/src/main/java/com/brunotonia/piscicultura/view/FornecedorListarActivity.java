package com.brunotonia.piscicultura.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.brunotonia.piscicultura.R;
import com.brunotonia.piscicultura.vo.SessaoVO;

public class FornecedorListarActivity extends Activity {

    /* Variáveis de Sessão */
    private Intent it = null;
    private Bundle params = null;
    private SessaoVO sessaoVO = null;
    private String operacao = null;

    /* Variáveis dos Elementos de Tela */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fornecedor_listar);

        /* Recupera params */
        recuperarParams();
        carregarParams();

        /* Inicializa Elementos de Interface */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
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
        }


        return super.onOptionsItemSelected(item);
    }
}
