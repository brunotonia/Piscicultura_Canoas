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
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.brunotonia.piscicultura.R;
import com.brunotonia.piscicultura.bo.UsuarioBO;
import com.brunotonia.piscicultura.vo.SessaoVO;
import com.brunotonia.piscicultura.vo.UsuarioVO;

public class UsuarioAlterarSenhaActivity extends Activity {

    /* Variáveis de Sessão */
    private Intent it = null;
    private Bundle params = null;
    private SessaoVO sessaoVO = null;

    /* Variáveis dos Elementos de Tela */
    private TextView txtSenha = null;
    private TextView txtNovaSenha = null;
    private TextView txtNovaSenha2 = null;
    private Switch swExibe = null;
    private boolean exibeSenha = false;
    private Button btnAlterar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_alterar_senha);

        /* Recupera params */
        recuperarParams();

        /* Inicializa Elementos de Interface */
        txtSenha = (TextView) findViewById(R.id.txtSenha);
        txtNovaSenha = (TextView) findViewById(R.id.txtNovaSenha);
        txtNovaSenha2 = (TextView) findViewById(R.id.txtNovaSenha2);
        swExibe = (Switch) findViewById(R.id.swExibe);
        btnAlterar = (Button) findViewById(R.id.btnAdicionar);

        /* listener swExibir */
        swExibe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirSenha();
            }
        });

        /* listener btnEntrar */
        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alterar(UsuarioAlterarSenhaActivity.this);
            }

        });


    }

    /* Alterar Senha */
    private void alterar(Context context) {
        UsuarioBO usuarioBO = UsuarioBO.getInstance();
        UsuarioVO usuarioVO = null;
        if (txtNovaSenha.getText().toString().equals(txtNovaSenha2.getText().toString())) {
            try {
                if (usuarioBO.alterarSenha(context, sessaoVO.getId(), txtSenha.getText().toString(), txtNovaSenha.getText().toString())) {
                    it = new Intent(this, UsuarioActivity.class);
                    carregarParams();
                    it.putExtras(params);
                    startActivity(it);
                    Toast.makeText(this, "Usuário adicionado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Não foi possível adicionar o usuário", Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            Toast.makeText(this, "Verifique a nova senha.", Toast.LENGTH_LONG).show();
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

    /* Exibe ou Oculta as Senhas */
    private void exibirSenha() {
        if (exibeSenha) {
            txtSenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
            txtNovaSenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
            txtNovaSenha2.setTransformationMethod(PasswordTransformationMethod.getInstance());
            exibeSenha = false;
        } else {
            txtSenha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            txtNovaSenha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            txtNovaSenha2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            exibeSenha = true;
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
