package com.brunotonia.piscicultura.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.brunotonia.piscicultura.R;
import com.brunotonia.piscicultura.bo.UsuarioBO;
import com.brunotonia.piscicultura.vo.SessaoVO;

public class LoginActivity extends Activity {

    /* Variáveis de Sessão */
    private Bundle params = null;

    /* Variáveis dos Elementos de Tela */
    private EditText txtUsuario = null;
    private EditText txtSenha = null;
    private Switch swExibir = null;
    private Button btnEntrar = null;
    boolean exibeSenha = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* Inicializa Elementos de Tela */
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        swExibir = (Switch) findViewById(R.id.swExibe);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        /* listener swExibir */
        swExibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirSenha();
            }
        });

        /* listener btnEntrar */
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(LoginActivity.this);
            }

        });

    }

    private void exibirSenha() {
        if (exibeSenha) {
            txtSenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
            exibeSenha = false;
        } else {
            txtSenha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            exibeSenha = true;
        }
    }

    private void carregarParams(SessaoVO sessaoVO) {
        params = new Bundle();
        params.putLong("sessaoId", sessaoVO.getId());
        params.putString("sessaoUsuario", sessaoVO.getNome());
        params.putInt("sessaoNivel", sessaoVO.getNivel());
    }

    private void login(Context context) {
        UsuarioBO usuarioBO = UsuarioBO.getInstance();
        SessaoVO sessaoVO = new SessaoVO(-1L, "Erro", -1);
        try {
            sessaoVO = usuarioBO.login(context, txtUsuario.getText().toString(), txtSenha.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sessaoVO.getId() != -1L) {
            carregarParams(sessaoVO);
            Intent iPrincipal = new Intent(this, MainActivity.class);
            iPrincipal.putExtras(params);
            startActivity(iPrincipal);
        } else {
            Toast.makeText(context, "Usuário e/ou Senha incorretos!", Toast.LENGTH_LONG).show();
        }
    }

}