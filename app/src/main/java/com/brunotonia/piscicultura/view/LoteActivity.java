package com.brunotonia.piscicultura.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.brunotonia.piscicultura.R;
import com.brunotonia.piscicultura.vo.SessaoVO;

public class LoteActivity extends Activity {

    /* Variáveis de Sessão */
    private Intent it = null;
    private Bundle params = null;
    private SessaoVO sessaoVO = null;

    /* Variáveis dos Elementos de Tela */
    private Button btnAdicionar = null;
    private Button btnGerenciar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lote);

        /* Recupera params */
        recuperarParams();

        /* Inicializa Elementos de Interface */
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);
        btnGerenciar = (Button) findViewById(R.id.btnGerenciar);

        /* Adiciona Lote */
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sessaoVO.isAdministrador()) {
                    adicionar();
                } else {
                    Toast.makeText(LoteActivity.this, "Usuário sem permissão de acesso", Toast.LENGTH_LONG).show();
                }
            }
        });

        /* Gerenciar Lote */
        btnGerenciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sessaoVO.isAdministrador()) {
                    gerenciar();
                } else {
                    Toast.makeText(LoteActivity.this, "Usuário sem permissão de acesso", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /* Adicionar Lote */
    private void adicionar() {
        carregarParams();
        it = new Intent(this, LoteAdicionarActivity.class);
        params.putString("loteOperacao", "Adicionar");
        it.putExtras(params);
        startActivity(it);
    }

    /*  Gerenciar Lote */
    private void gerenciar() {
        carregarParams();
        it = new Intent(this, LoteListarActivity.class);
        params.putString("usuarioOperacao", "Editar");
        it.putExtras(params);
        startActivity(it);
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
