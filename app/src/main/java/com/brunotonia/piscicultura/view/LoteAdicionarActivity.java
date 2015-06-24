package com.brunotonia.piscicultura.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.brunotonia.piscicultura.R;
import com.brunotonia.piscicultura.bo.EspecieBO;
import com.brunotonia.piscicultura.bo.FornecedorBO;
import com.brunotonia.piscicultura.vo.EspecieVO;
import com.brunotonia.piscicultura.vo.FornecedorVO;
import com.brunotonia.piscicultura.vo.SessaoVO;

import java.util.ArrayList;
import java.util.List;

public class LoteAdicionarActivity extends Activity {

    /* Variáveis de Sessão */
    private Intent it = null;
    private Bundle params = null;
    private SessaoVO sessaoVO = null;
    private String operacao = null;
    private Long id = null;
    private Integer etapa = null;

    /* Variáveis dos Elementos de Tela */
    private TextView lblTitulo = null;
    private EditText txtNumero = null;
    private Spinner spnEspecie = null;
    private Spinner spnFornecedor = null;
    private EditText txtIndividuos = null;
    private EditText txtData = null;
    private Button btnAdicionar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lote_adicionar);

        /* Recupera params */
        recuperarParams();

        /* Inicializa Elementos de Interface */
        lblTitulo = (TextView) findViewById(R.id.lblTitulo);
        txtNumero = (EditText) findViewById(R.id.txtNumero);
        spnEspecie = (Spinner) findViewById(R.id.spnEspecie);
        spnFornecedor = (Spinner) findViewById(R.id.spnFornecedor);
        txtIndividuos = (EditText) findViewById(R.id.txtIndividuos);
        txtData = (EditText) findViewById(R.id.txtData);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);

        /* Altera Rótulos em caso de Edição */
        alteraRotulos();

        /* Povoar Spinners */
        povoarSpinners(this);

        /* listener btnEntrar */
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionar(LoteAdicionarActivity.this);
            }

        });


    }

    /* Povoar os Spinners */
    private void povoarSpinners(Context context) {
        List<String> lista = new ArrayList<>();
        List<EspecieVO> listaEspecies = null;
        List<FornecedorVO> listaFornecedores = null;
        EspecieBO especieBO = EspecieBO.getInstance();
        FornecedorBO fornecedorBO = FornecedorBO.getInstance();
        try {
            listaEspecies = especieBO.selecionar(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < listaEspecies.size(); i++) {
            lista.add(listaEspecies.toString());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lista);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnEspecie.setAdapter(arrayAdapter);

        lista = new ArrayList<>();
        try {
            listaFornecedores = fornecedorBO.selecionar(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < listaFornecedores.size(); i++) {
            lista.add(listaFornecedores.toString());
        }
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lista);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnFornecedor.setAdapter(arrayAdapter);
    }

    /* Recuperar params */
    private void recuperarParams() {
        it = getIntent();
        params = it.getExtras();
        sessaoVO = new SessaoVO(params.getLong("sessaoId"), params.getString("sessaoUsuario"), params.getInt("sessaoNivel"));
        operacao = params.getString("loteOperacao");
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
        switch (operacao) {
            case "editar":
                /* Rótulos e Botões */
                lblTitulo.setText(R.string.EditarLote);
                btnAdicionar.setText(R.string.EditarLote);
                /* Povoa Campos da Interface */
                id = new Long(params.getLong("loteID"));
                txtNumero.setText(params.getInt("loteNumero"));




                break;
            case "adicionar":
                etapa = 0;
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
            case (R.id.action_GEspecies) :
                it = new Intent(this, EspecieActivity.class);
                it.putExtras(params);
                startActivity(it);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
