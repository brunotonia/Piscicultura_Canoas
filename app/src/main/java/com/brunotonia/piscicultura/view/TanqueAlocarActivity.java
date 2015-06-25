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
import com.brunotonia.piscicultura.bo.LoteTanqueBO;
import com.brunotonia.piscicultura.bo.TanqueBO;
import com.brunotonia.piscicultura.vo.LoteTanqueVO;
import com.brunotonia.piscicultura.vo.SessaoVO;
import com.brunotonia.piscicultura.vo.TanqueVO;

import java.util.ArrayList;
import java.util.List;

public class TanqueAlocarActivity extends Activity {

    /* Variáveis de Sessão */
    private Intent it = null;
    private Bundle params = null;
    private SessaoVO sessaoVO = null;
    private Long lote = null;
    private String data = null;
    private Long etapa = null;

    /* Variáveis dos Elementos de Tela */
    private Spinner spnTanque = null;
    private EditText txtIndividuos = null;
    private TextView lblRestantes = null;
    private Button btnAdicionar = null;
    private List<String> lista = new ArrayList<>();
    private List<TanqueVO> listaTanques = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanque_alocar);

        /* Recupera params */
        recuperarParams();

        /* Inicializa Elementos de Interface */
        spnTanque = (Spinner) findViewById(R.id.spnTanque);
        txtIndividuos = (EditText) findViewById(R.id.txtIndividuos);
        lblRestantes = (TextView) findViewById(R.id.lblRestantes);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);

        /* Povoar Spinners */
        povoarSpinners(this);

        /* listener btnEntrar */
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionar(TanqueAlocarActivity.this);
            }

        });

    }

    /* Adicona ou Edita Usuários */
    private void adicionar(Context context) {
        LoteTanqueBO loteTanqueBO = LoteTanqueBO.getInstance();
        TanqueBO tanqueBO = TanqueBO.getInstance();
        LoteTanqueVO loteTanqueVO = null;
        try {
            Long tanque = new Long(spnTanque.getSelectedItemId());
            // esse tanque tá errado!
            tanqueBO.selecionar(context, listaTanques.get(tanque.intValue()).getNumero());
            loteTanqueVO = new LoteTanqueVO(lote, tanque, data);

            if (loteTanqueBO.adicionar(context, loteTanqueVO) && tanqueBO.alterarEstado(context, tanque, 1L)){
                it = new Intent(this, LoteActivity.class);
                carregarParams();
                it.putExtras(params);
                startActivity(it);
                Toast.makeText(this, "Tanque alocado com sucesso!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Não foi possível alocar o Tanque", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Povoar os Spinners */
    private void povoarSpinners(Context context) {
        TanqueBO tanqueBO = TanqueBO.getInstance();
        try {
            listaTanques = tanqueBO.selecionarDisponiveis(context, etapa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < listaTanques.size(); i++) {
            lista.add(listaTanques.toString());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lista);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnTanque.setAdapter(arrayAdapter);
    }

    /* Recuperar params */
    private void recuperarParams() {
        it = getIntent();
        params = it.getExtras();
        sessaoVO = new SessaoVO(params.getLong("sessaoId"), params.getString("sessaoUsuario"), params.getInt("sessaoNivel"));
        lote = params.getLong("loteLote");
        data = params.getString("loteData");
        etapa = params.getLong("loteEtapa");
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
