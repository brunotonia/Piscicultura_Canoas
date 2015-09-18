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
import android.widget.Toast;

import com.brunotonia.piscicultura.R;
import com.brunotonia.piscicultura.bo.EspecieBO;
import com.brunotonia.piscicultura.bo.FornecedorBO;
import com.brunotonia.piscicultura.bo.LoteBO;
import com.brunotonia.piscicultura.vo.EspecieVO;
import com.brunotonia.piscicultura.vo.FornecedorVO;
import com.brunotonia.piscicultura.vo.LoteVO;
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
    private Button btnExecutar = null;

    /* Demais Variáveis */
    List<String> lista = new ArrayList<>();
    List<EspecieVO> listaEspecies = null;
    List<FornecedorVO> listaFornecedores = null;
    LoteVO loteVO = null;

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
        btnExecutar = (Button) findViewById(R.id.btnAdicionar);

        /* Altera Rótulos em caso de Edição */
        alteraRotulos();

        /* Povoar Spinners */
        povoarSpinners(this);

        /* listener btnEntrar */
        btnExecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionar(LoteAdicionarActivity.this);
            }

        });

    }

    /* Adicona ou Edita Lotes */
    private void adicionar(Context context) {
        LoteBO loteBO = LoteBO.getInstance();
        /* loteVO sets*/
        loteVO.setNumero(new Integer(txtNumero.getText().toString()));
        loteVO.setEspecie(listaEspecies.get(spnEspecie.getSelectedItemPosition()).getId());
        loteVO.setFornecedor(listaEspecies.get(spnFornecedor.getSelectedItemPosition()).getId());
        loteVO.setIndv_inicio(new Integer(txtIndividuos.getText().toString()));
        loteVO.setData_inicio(txtData.getText().toString());
        try {
            if (operacao.equals("Adicionar")) {
                /* Grava no BD e recupera a Primary Key */
                id = loteBO.adicionar(context, loteVO);
                if (loteBO.validaAdicao(id)) {
                    it = new Intent(this, TanqueAlocarActivity.class);
                    carregarParams();
                    params.putLong("loteID", id);
                    params.putInt("loteEtapa", 0);
                    it.putExtras(params);
                    startActivity(it);
                    Toast.makeText(this, "Lote adicionado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Não foi possível adicionar o Lote", Toast.LENGTH_LONG).show();
                }
            } else {
                if (loteBO.editar(context, loteVO)) {
                    it = new Intent(this, LoteGerenciarActivity.class);
                    carregarParams();
                    it.putExtras(params);
                    startActivity(it);
                    Toast.makeText(this, "Lote editado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Não foi possível editar o Lote", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Povoar os Spinners */
    private void povoarSpinners(Context context) {

        EspecieBO especieBO = EspecieBO.getInstance();
        FornecedorBO fornecedorBO = FornecedorBO.getInstance();
        try {
            listaEspecies = especieBO.selecionar(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (EspecieVO especies: listaEspecies) {
            lista.add(especies.toString());
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
        if (operacao.equals("Editar")) {
            /* TO DO */
        }
    }

    /* Altera Rótulos em caso de Edição */
    private void alteraRotulos() {
        switch (operacao) {
            case "editar":
                /* Rótulos e Botões */
                lblTitulo.setText(R.string.EditarLote);
                btnExecutar.setText(R.string.EditarLote);
                /* Povoa Campos da Interface */
                id = params.getLong("loteID");
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
