package com.brunotonia.piscicultura.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.brunotonia.piscicultura.R;
import com.brunotonia.piscicultura.bo.UsuarioBO;
import com.brunotonia.piscicultura.constants.UsuarioEstadoConstantes;
import com.brunotonia.piscicultura.constants.UsuarioNivelConstantes;
import com.brunotonia.piscicultura.vo.SessaoVO;
import com.brunotonia.piscicultura.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

public class UsuarioAdicionarActivity extends Activity {

    /* Variáveis de Sessão */
    private Intent it = null;
    private Bundle params = null;
    private SessaoVO sessaoVO = null;
    private String operacao = null;
    private Long id = null;

    /* Variáveis dos Elementos de Tela */
    private TextView lblTitulo = null;
    private EditText txtNome = null;
    private EditText txtUsuario = null;
    private EditText txtSenha = null;
    private Switch swExibe = null;
    private Spinner spnNivel = null;
    private Spinner spnEstado = null;
    private Button btnAdicionar = null;
    private boolean exibeSenha = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_adicionar);

        /* Recupera params */
        recuperarParams();

        /* Inicializa Elementos de Interface */
        lblTitulo = (TextView) findViewById(R.id.lblTitulo);
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        swExibe = (Switch) findViewById(R.id.swExibe);
        spnNivel = (Spinner) findViewById(R.id.spnNivel);
        spnEstado = (Spinner) findViewById(R.id.spnEstado);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);

        /* Povoa os Spinners*/
        povoarSpinners();

        /* Altera Rótulos em caso de Edição */
        alteraRotulos();

        /* listener swExibir */
        swExibe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirSenha();
            }
        });

        /* listener btnEntrar */
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionar(UsuarioAdicionarActivity.this);
            }

        });

    }

    /* Adicona ou Edita Usuários */
    private void adicionar(Context context) {
        UsuarioBO usuarioBO = UsuarioBO.getInstance();
        UsuarioVO usuarioVO = null;
        try {
            if (operacao.equals("Adicionar")) {
                Long nivel = new Long(Integer.toString(spnNivel.getSelectedItemPosition()));
                Long estado = new Long(Integer.toString(spnEstado.getSelectedItemPosition()));
                usuarioVO = new UsuarioVO(txtNome.getText().toString(), txtUsuario.getText().toString(),
                        txtSenha.getText().toString(), nivel, estado);
                if (usuarioBO.adicionar(context, usuarioVO)) {
                    it = new Intent(this, UsuarioActivity.class);
                    carregarParams();
                    it.putExtras(params);
                    startActivity(it);
                    Toast.makeText(this, "Usuário adicionado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Não foi possível adicionar o usuário", Toast.LENGTH_LONG).show();
                }
            } else {
                Long nivel = new Long(Integer.toString(spnNivel.getSelectedItemPosition()));
                Long estado = new Long(Integer.toString(spnEstado.getSelectedItemPosition()));
                usuarioVO = new UsuarioVO(id, txtNome.getText().toString(), txtUsuario.getText().toString(),
                        txtSenha.getText().toString(), nivel, estado);
                it = new Intent(this, UsuarioActivity.class);
                if (usuarioBO.editar(context, usuarioVO)) {
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

    /* Povoar os Spinners */
    private void povoarSpinners() {
        List<String> lista = new ArrayList<>();
        lista.add(UsuarioNivelConstantes.VETOR_DESCRICOES[0]);
        lista.add(UsuarioNivelConstantes.VETOR_DESCRICOES[1]);
        lista.add(UsuarioNivelConstantes.VETOR_DESCRICOES[2]);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lista);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnNivel.setAdapter(arrayAdapter);
        lista = new ArrayList<>();
        lista.add(UsuarioEstadoConstantes.VETOR_DESCRICOES[0]);
        lista.add(UsuarioEstadoConstantes.VETOR_DESCRICOES[1]);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lista);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnEstado.setAdapter(arrayAdapter);
    }

    /* Recuperar params */
    private void recuperarParams() {
        it = getIntent();
        params = it.getExtras();
        sessaoVO = new SessaoVO(params.getLong("sessaoId"), params.getString("sessaoUsuario"), params.getInt("sessaoNivel"));
        operacao = params.getString("usuarioOperacao");
    }

    /* Carregar params */
    private void carregarParams() {
        params = new Bundle();
        params.putLong("sessaoId", sessaoVO.getId());
        params.putString("sessaoUsuario", sessaoVO.getNome());
        params.putInt("sessaoNivel", sessaoVO.getNivel());
    }

    /* Exibe ou Oculta as Senhas */
    private void exibirSenha() {
        if (exibeSenha) {
            txtSenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
            exibeSenha = false;
        } else {
            txtSenha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            exibeSenha = true;
        }
    }

    /* Altera Rótulos em caso de Edição */
    private void alteraRotulos() {
        if(operacao.equals("Editar")) {
            /* Rótulos e Botões */
            lblTitulo.setText("Editar Usuario");
            btnAdicionar.setText(R.string.EditarUsuario);
            /* Povoa Campos da Interface */
            id = new Long (params.getLong("usuarioID"));
            Long nivel = params.getLong("usuarioTipo");
            Long estado = params.getLong("usuarioEstado");
            txtNome.setText(params.getString("usuarioNome"));
            txtUsuario.setText(params.getString("usuarioLogin"));
            txtSenha.setText(params.getString("usuarioSenha"));
            spnNivel.setSelection(nivel.intValue());
            spnEstado.setSelection(estado.intValue());
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
