package com.example.calculadora;

import android.os.Bundle;

import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstFragment extends Fragment implements View.OnClickListener {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView textEcuation, textInput;
    Button botonUno, botonDos, botonTres, botonCuatro, botonCinco, botonSeis, botonSiete, botonOcho, botonNueve, botonCero, botonDobleCero, botonSuma, botonResta, botonDivision, botonMultiplicion, botonIgual, botonAC, botonPunto, botonPorcentaje, botonC;
    View view;
    static AppCompatImageView imageNightMode;
    private String operadorActual = "";
    private Number valorPrimero = 0;
    private Number valorSegundo = 0;

    private static final String SUMA_OPERADOR = "+";
    private static final String RESTA_OPERADOR = "-";
    private static final String MULTI_OPERADOR = "x";
    private static final String DIVI_OPERADOR = "÷";
    private static final String PORCE_OPERADOR = "%";
    ImageView sol, luna ;


    private String mParam1;
    private String mParam2;

    public FirstFragment() {

    }
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ponerIndicadorModoNoche();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        }

    @OptIn(markerClass = UnstableApi.class)
    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.fragment_first, container, false);
            textEcuation = view.findViewById(R.id.textEcuation);
            textInput = view.findViewById(R.id.textInput);
            botonCero = view.findViewById(R.id.botonCero);
            botonDobleCero = view.findViewById(R.id.botonDobleCero);
            botonUno = view.findViewById(R.id.botonUno);
            botonDos = view.findViewById(R.id.botonDos);
            botonTres = view.findViewById(R.id.botonTres);
            botonCuatro = view.findViewById(R.id.botonCuatro);
            botonCinco = view.findViewById(R.id.botonCinco);
            botonSeis = view.findViewById(R.id.botonSeis);
            botonSiete = view.findViewById(R.id.botonSiete);
            botonOcho = view.findViewById(R.id.botonOcho);
            botonNueve = view.findViewById(R.id.botonNueve);
            botonSuma = view.findViewById(R.id.botonSuma);
            botonResta = view.findViewById(R.id.botonResta);
            botonDivision = view.findViewById(R.id.botonDivision);
            botonMultiplicion = view.findViewById(R.id.botonMultiplicacion);
            botonIgual = view.findViewById(R.id.botonIgual);
            botonAC = view.findViewById(R.id.botonAllClear);
            botonC = view.findViewById(R.id.botonC);
            botonPorcentaje = view.findViewById(R.id.botonPorcentaje);
            botonPunto = view.findViewById(R.id.botonPuntoDecimal);
            imageNightMode = view.findViewById(R.id.imageNightMode);
            botonCero.setOnClickListener(this);
            botonDobleCero.setOnClickListener(this);
            botonUno.setOnClickListener(this);
            botonDos.setOnClickListener(this);
            botonTres.setOnClickListener(this);
            botonCuatro.setOnClickListener(this);
            botonCinco.setOnClickListener(this);
            botonCinco.setOnClickListener(this);
            botonSeis.setOnClickListener(this);
            botonSiete.setOnClickListener(this);
            botonOcho.setOnClickListener(this);
            botonNueve.setOnClickListener(this);
            botonSuma.setOnClickListener(this);
            botonResta.setOnClickListener(this);
            botonDivision.setOnClickListener(this);
            botonMultiplicion.setOnClickListener(this);
            botonIgual.setOnClickListener(this);
            botonAC.setOnClickListener(this);
            botonC.setOnClickListener(this);
            botonPorcentaje.setOnClickListener(this);
            botonPunto.setOnClickListener(this);
            imageNightMode.setOnClickListener(this);
            ponerIndicadorModoNoche();

            return view;
        }
            @Override
            public void onClick(View view) {
                if (view == imageNightMode) {
                    cambiarModoNoche();

                    return;
                }
                Button button = (Button) view;
                String buttonText = button.getText().toString();
                String datosPrevios = textInput.getText().toString();
                datosPrevios = ("0".equals(datosPrevios)) ? "" : datosPrevios;

                try {
                    switch (buttonText) {
                        case "AC":
                            textInput.setText("0");
                            textEcuation.setText("");
                            valorPrimero = 0;
                            valorSegundo = 0;
                            operadorActual = "";
                            break;
                        case "00":
                        case "0":
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                        case "7":
                        case "8":
                        case "9":
                            textInput.setText(datosPrevios + buttonText);
                            break;
                        case "+":
                        case "-":
                        case "%":
                        case "x":
                        case "÷":
                            valorPrimero = convertirANumero(datosPrevios);
                            operadorActual = buttonText;
                            textEcuation.setText(valorPrimero + " " + buttonText + " ");
                            textInput.setText("0");
                            break;
                        case "=":
                            valorSegundo = convertirANumero(datosPrevios);
                            textEcuation.setText(valorPrimero + " " + operadorActual + " " + valorSegundo);
                            Number resultado = realizarOperacion(operadorActual, valorPrimero, valorSegundo);
                            textInput.setText(resultado + "");
                            valorPrimero = 0;
                            valorSegundo = 0;
                            break;
                        case "C":
                            String entrada = textInput.getText().toString();
                            textInput.setText(borrarCaracter(entrada));
                            break;
                        case ".":
                            if (!datosPrevios.contains(".")) {
                                textInput.setText(datosPrevios + buttonText);
                            }
                            break;
                        /*
                        case "imageNightMode":
                            cambiarModoNoche();
                            break;
                        */
                    }
                }catch (ArithmeticException e) {
                    Toast.makeText(getContext(), "Operación no permitida: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    textInput.setText("0");
                    textEcuation.setText("");
                }

            }

            private static int parseInt(String text, int defValue) {
                if ("".equals(text)) {
                    return defValue;
                } else {
                    return Integer.parseInt(text);
                }
            }

            private static double parseDouble(String text, double defValue) {
                if ("".equals(text)) {
                    return defValue;
                } else {
                    return Double.parseDouble(text);
                }
            }

            private static String borrarCaracter(String entrada) {
                if (entrada.length() > 0) {
                    entrada = entrada.substring(0, entrada.length() - 1);
                }
                if (entrada.length() == 0) {
                    entrada = "0";
                }
                return entrada;
            }
            private void cambiarModoNoche(){
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                ponerIndicadorModoNoche();
            }

    private void ponerIndicadorModoNoche() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            imageNightMode.setImageResource(R.drawable.ic_sun);
        } else {
            imageNightMode.setImageResource(R.drawable.ic_moon);
        }
    }


    public static Number realizarOperacion(String operador, Number valorPrimero, Number valorSegundo) {
        double resultado = 0.0;
        if (SUMA_OPERADOR.equals(operador)) {
            resultado = valorPrimero.doubleValue() + valorSegundo.doubleValue();
        } else if (RESTA_OPERADOR.equals(operador)) {
            resultado = valorPrimero.doubleValue() - valorSegundo.doubleValue();
        } else if (MULTI_OPERADOR.equals(operador)) {
            resultado = valorPrimero.doubleValue() * valorSegundo.doubleValue();
        } else if (DIVI_OPERADOR.equals(operador)) {
            validarDivision(valorSegundo);
            resultado = valorPrimero.doubleValue() / valorSegundo.doubleValue();
        } else if (PORCE_OPERADOR.equals(operador)){
            resultado = (valorPrimero.doubleValue() * valorSegundo.doubleValue()) / 100.0;
        }
        if (Double.class.equals(valorPrimero.getClass()) || Double.class.equals(valorSegundo.getClass())) {
            return resultado;
        } else {
            return (int) resultado;
        }
    }
    public static Number convertirANumero(String numero) {
        if (numero.contains(".")) {
            return parseDouble(numero, 0.0);
        } else {
            return parseInt(numero, 0);
        }
    }
    public static void validarDivision (Number valorSegundo){
        Number cero = 0;
        if (cero.equals(valorSegundo)){
            throw new ArithmeticException("División por cero no permitida");
        }
    }


}

