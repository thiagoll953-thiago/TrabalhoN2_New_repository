package com.thiago.trabalhon2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class FormularioActivity2 extends AppCompatActivity {

    private EditText etAtutomovel, etKmLitro, etLitrosTanque, etQuilometragem, etValorGasolina, etValorEtanol, etLitros;
    private Spinner spTipo;
    private Button btnSalvar;
    private String acao;
    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario2);

        acao = getIntent().getExtras().getString("acao");

        etAtutomovel = findViewById(R.id.etAtutomovel);
        etKmLitro = findViewById(R.id.etKmLitro);
        etLitrosTanque = findViewById(R.id.etLitrosTanque);
        etQuilometragem = findViewById(R.id.etQuilometragem);
        etLitros = findViewById(R.id.etLitros);
        etValorEtanol = findViewById(R.id.etValorGasolina);
        etValorGasolina = findViewById(R.id.etValorEtanol);
        spTipo = findViewById(R.id.spTipo);
        btnSalvar = findViewById(R.id.btnSalvar);


        etValorEtanol.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                String ValorGasolina = etValorGasolina.getText().toString();
                String ValorEtanol = etValorEtanol.getText().toString();

                if (!ValorGasolina.isEmpty() && !ValorEtanol.isEmpty()) {
                    ValorGasolina = ValorGasolina.replace(",", ".");
                    double Vg = Double.valueOf(ValorGasolina);

                    ValorEtanol = ValorEtanol.replace(",", ".");
                    double Ve = Double.valueOf(ValorEtanol);

                    double valor = Produto.calcular(Vg, Ve);

                    if (valor < 0.7) {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(FormularioActivity2.this);
                        alerta.setMessage("Abasteça com Etanol");
                        alerta.setPositiveButton("OK", null);
                        alerta.show();
                    } else {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(FormularioActivity2.this);
                        alerta.setMessage("Abasteça com Gasolina");
                        alerta.setPositiveButton("OK", null);
                        alerta.show();
                    }
                }

//                if(! b){
//                    AlertDialog.Builder alerta = new AlertDialog.Builder(FormularioActivity2.this);
//                    alerta.setMessage("Abasteça com Etanol");
//                    alerta.setPositiveButton("OK", null);
//                    alerta.show();
//                }
            }


        });

        etValorGasolina.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {

                    String ValorGasolina = etValorGasolina.getText().toString();
                    String ValorEtanol = etValorEtanol.getText().toString();

                    if (!ValorGasolina.isEmpty() && !ValorEtanol.isEmpty()) {
                        ValorGasolina = ValorGasolina.replace(",", ".");
                        double Vg = Double.valueOf(ValorGasolina);

                        ValorEtanol = ValorEtanol.replace(",", ".");
                        double Ve = Double.valueOf(ValorEtanol);

                        double valor = Produto.calcular(Vg, Ve);

                        if (valor > 0.7) {
                            AlertDialog.Builder alerta = new AlertDialog.Builder(FormularioActivity2.this);
                            alerta.setMessage("Abasteça com Gasolina");
                            alerta.setPositiveButton("OK", null);
                            alerta.show();
                        } else {
                            AlertDialog.Builder alerta = new AlertDialog.Builder(FormularioActivity2.this);
                            alerta.setMessage("Abasteça com Etanol");
                            alerta.setPositiveButton("OK", null);
                            alerta.show();
                        }
                    }

                }
            }
        });
    }
        private void selecionarTipo(String tipo){
            String[] tipoComb = {"Selecione", "Gasolina", "Etanol"};

            String[] tipos;

            switch (tipo){
                case "Gasolina":
                    tipos = tipoComb;
                    spTipo.setEnabled(true);
                    break;
                case "Etanol":
                    tipos = tipoComb;
                    spTipo.setEnabled(true);
                    break;
                default:
                    tipos = new String[]{"Selecione um tipo de combustível!"};
                    spTipo.setEnabled(false);
            }

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tipos);
            spTipo.setAdapter(adapter);
        }

    //}
}