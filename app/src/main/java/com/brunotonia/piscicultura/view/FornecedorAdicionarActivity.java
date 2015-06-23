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
import com.brunotonia.piscicultura.bo.FornecedorBO;
import com.brunotonia.piscicultura.bo.UsuarioBO;
import com.brunotonia.piscicultura.vo.FornecedorVO;
import com.brunotonia.piscicultura.vo.SessaoVO;
import com.brunotonia.piscicultura.vo.UsuarioVO;

public class FornecedorAdicionarActivity extends Activity {

    /* Variáveis de Sessão */
    private Intent it = null;
    private Bundle params = null;
    private SessaoVO sessaoVO = null;
    private String operacao = null;
    private Long id = null;

    /* Variáveis dos Elementos de Tela */
    private TextView lblTitulo = null;
    private EditText txtNome = null;
    private EditText txtCPF = null;
    private EditText txtEmail = null;
    private EditText txtDdd = null;
    private EditText txtTelefone = null;
    private EditText txtContato = null;
    private Button btnAdicionar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fornecedor_adicionar);

        /* Recupera params */
        recuperarParams();

        /* Inicializa Elementos de Interface */
        lblTitulo = (TextView) findViewById(R.id.lblTitulo);
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtCPF = (EditText) findViewById(R.id.txtCPF);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtDdd = (EditText) findViewById(R.id.txtDdd);
        txtTelefone = (EditText) findViewById(R.id.txtTelefone);
        txtContato = (EditText) findViewById(R.id.txtContato);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);

        /* Altera Rótulos em caso de Edição */
        alteraRotulos();

        /* listener btnEntrar */
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionar(FornecedorAdicionarActivity.this);
            }

        });

    }

    /* Adicona ou Edita Usuários */
    private void adicionar(Context context) {
        FornecedorBO fornecedorBO = FornecedorBO.getInstance();
        FornecedorVO fornecedorVO = null;
        try {
            if (operacao.equals("Adicionar")) {
                fornecedorVO = new FornecedorVO(txtNome.getText().toString(), txtCPF.getText().toString(), txtEmail.getText().toString(),
                        txtDdd.getText().toString(), txtTelefone.getText().toString(), txtContato.getText().toString());
                if (fornecedorBO.adicionar(context, fornecedorVO)) {
                    it = new Intent(this, UsuarioActivity.class);
                    carregarParams();
                    it.putExtras(params);
                    startActivity(it);
                    Toast.makeText(this, "Fornecedor adicionado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Não foi possível adicionar o fornecedor", Toast.LENGTH_LONG).show();
                }
            } else {
                fornecedorVO = new FornecedorVO(id, txtNome.getText().toString(), txtCPF.getText().toString(), txtEmail.getText().toString(),
                        txtDdd.getText().toString(), txtTelefone.getText().toString(), txtContato.getText().toString());
                it = new Intent(this, UsuarioActivity.class);
                if (fornecedorBO.editar(context, fornecedorVO)) {
                    carregarParams();
                    it.putExtras(params);
                    startActivity(it);
                    Toast.makeText(this, "Usuário editado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Não foi possível editar o usuário", Toast.LENGTH_LONG).show();
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
            lblTitulo.setText("Editar Usuario");
            btnAdicionar.setText(R.string.EditarFornecedor);
            /* Povoa Campos da Interface */
            id = new Long(params.getLong("fornecedorID"));
            txtNome.setText(params.getString("fornecedorNome"));

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
