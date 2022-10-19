package com.example.mycalculadora;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Instanciar los IDs Del Archivo activity_main.xml
    EditText valor1,valor2;
    TextView resultado;
    Button sumar, restar, multiplicar, dividir, limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar Los Objetos Con Los Elementos Del Archivo xml
        valor1 = findViewById(R.id.etvalor1);
        valor2 = findViewById(R.id.etvalor2);
        resultado = findViewById(R.id.tvresultado);
        sumar = findViewById(R.id.btnsumar);
        restar = findViewById(R.id.btnrestar);
        multiplicar = findViewById(R.id.btnmultiplicar);
        dividir = findViewById(R.id.btndividir);
        limpiar = findViewById(R.id.btnlimpiar);

        //Generar Los Eventos Para Realizar El Codigo Por Cada Uno De Los Botones
        sumar.setOnClickListener(this);
        restar.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        dividir.setOnClickListener(this);
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor1.setText("");
                valor2.setText("");
                resultado.setText("");
                valor1.requestFocus(); //Se Envia Foco Al Control valor1
            }
        });


        /*sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tomar Los Datos Del Valor1 y Valor2 Como Numericos
                double mvalor1 = parseDouble(valor1.getText().toString());
                double mvalor2 = parseDouble(valor2.getText().toString());
                double mresultado = mvalor1 + mvalor2;

                //Utilizar La Clase DecimalFormat Para Dar Formato Al Resultado
                DecimalFormat oNumero = new DecimalFormat("###,###,###,###.##");

                //Asignar El Contenido De La Variable mresultado Al Objeto Referenciado De Resultado


                resultado.setText("$"+String.valueOf(oNumero.format(mresultado)));

            }
        });*/
    }

    @Override
    public void onClick(View v) {
        //Este Metodo Se Comparte Para Todos Los Botones, Teniendo En cuenta El Id De Cada Boton
        //Validar Que Los Datos (valor1 y valor2) Se Hayan Digitado
        if (!valor1.getText().toString().isEmpty() && !valor2.getText().toString().isEmpty()){
            double mvalor1 = parseDouble(valor1.getText().toString());
            double mvalor2 = parseDouble(valor2.getText().toString());
            double mresultado = 0;

            //Chequear A Cual Boton Se Hizo Click
            switch (v.getId()){
                case R.id.btnsumar:
                    mresultado = mvalor1 + mvalor2;
                    break;
                case R.id.btnrestar:
                    mresultado = mvalor1 - mvalor2;
                    break;
                case R.id.btnmultiplicar:
                    mresultado = mvalor1 * mvalor2;
                    break;
                case R.id.btndividir:
                    mresultado = mvalor1 / mvalor2;
                    break;
            }
            DecimalFormat oNumero = new DecimalFormat("###,###,###,###.##");
            resultado.setText(String.valueOf(oNumero.format(mresultado)));

        }
        else {
            //Notificacion
            Toast.makeText(getApplicationContext(),"Debe Ingresar Los 2 Valores",Toast.LENGTH_LONG).show();
        }

    }
}