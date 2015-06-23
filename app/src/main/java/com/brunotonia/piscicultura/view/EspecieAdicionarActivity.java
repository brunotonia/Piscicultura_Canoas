package com.brunotonia.piscicultura.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.brunotonia.piscicultura.R;
import com.brunotonia.piscicultura.bo.EspecieBO;
import com.brunotonia.piscicultura.vo.EspecieVO;
import com.brunotonia.piscicultura.vo.SessaoVO;

public class EspecieAdicionarActivity extends Activity {

    /* Variáveis de Sessão */
    private Intent it = null;
    private Bundle params = null;
    private SessaoVO sessaoVO = null;
    private String operacao = null;
    private Long id = null;

    /* Variáveis dos Elementos de Tela */
    private TextView lblTitulo = null;
    private EditText txtEspecie = null;
    private Button btnAdicionar = null;
    private boolean exibeSenha = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especie_adicionar);

        /* Recupera params */
        recuperarParams();

        /* Inicializa Elementos de Interface */
        lblTitulo = (TextView) findViewById(R.id.lblTitulo);
        txtEspecie = (EditText) findViewById(R.id.txtEspecie);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);

        /* Altera Rótulos em caso de Edição */
        alteraRotulos();

        /* listener btnEntrar */
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionar(EspecieAdicionarActivity.this);
            }

        });


    }

    /* Adicona ou Edita Usuários */
    private void adicionar(Context context) {
        EspecieBO especieBO = EspecieBO.getInstance();
        EspecieVO especieVO = null;
        try {
            if (operacao.equals("adicionar")) {
                especieVO = new EspecieVO(txtEspecie.getText().toString());
                if (especieBO.adicionar(context, especieVO)) {
                    it = new Intent(this, EspecieActivity.class);
                    carregarParams();
                    it.putExtras(params);
                    startActivity(it);
                    Toast.makeText(this, "Espécie adicionada com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Não foi possível adicionar a Espécie", Toast.LENGTH_LONG).show();
                }
            } else {
                especieVO = new EspecieVO(id, txtEspecie.getText().toString());
                it = new Intent(this, EspecieActivity.class);
                if (especieBO.editar(context, especieVO)) {
                    carregarParams();
                    it.putExtras(params);
                    startActivity(it);
                    Toast.makeText(this, "Espécie editada com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Não foi possível editar a Espécie", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    }

    /* Altera Rótulos em caso de Edição */
    private void alteraRotulos() {
        if(operacao.equals("Editar")) {
            /* Rótulos e Botões */
            lblTitulo.setText(R.string.EditarEspecie);
            btnAdicionar.setText(R.string.EditarEspecie);
            /* Povoa Campos da Interface */
            id = new Long (params.getLong("especieID"));
            txtEspecie.setText(params.getString("especieNome"));
        }
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
