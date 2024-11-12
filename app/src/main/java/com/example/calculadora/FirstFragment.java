package com.example.calculadora;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView textEcuation, textInput;
    Button botonUno, botonDos, botonTres, botonCuatro, botonCinco, botonSeis, botonSiete, botonOcho, botonNueve, botonCero, botonDobleCero, botonSuma, botonResta, botonDivision, botonMultiplicion, botonIgual, botonAC, botonPunto, botonPorcentaje, botonC;
    View view;
    private String operadorActual = "";
    private int valorPrimero = 0;
    private int valorSegundo = 0;

    private double valorPrimeroD = 0.0;
    private double valorSegundoD = 0.0;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
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

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);
        // Inflate the layout for this fragment
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

        return view;
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String datosPrevios = textInput.getText().toString();
        datosPrevios = ("0".equals(datosPrevios)) ? "" : datosPrevios;

        try {
            switch (buttonText) {
                case "AC":
                    textInput.setText("0");
                    textEcuation.setText("");
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
                case "*":
                case "/":
                    if (datosPrevios.contains(".")) {
                        valorPrimeroD = parseDouble(datosPrevios, 0);
                        operadorActual = buttonText;
                        textEcuation.setText(valorPrimeroD + " " + buttonText + " ");
                        textInput.setText("0");
                    } else {
                        valorPrimero = parseInt(datosPrevios, 0);
                        operadorActual = buttonText;
                        textEcuation.setText(valorPrimero + " " + buttonText + " ");
                        textInput.setText("0");
                    }
                    break;
                case "=":

                    if (datosPrevios.contains(".") || valorPrimeroD != 0) {
                        valorSegundoD = parseDouble(datosPrevios, 0.0);
                        textEcuation.setText(valorPrimeroD + " " + operadorActual + " " + valorSegundoD);
                        double resultado = calcularResultadoD(valorPrimeroD, valorSegundoD, operadorActual);
                        textInput.setText(resultado + "");
                        valorPrimeroD = 0.0;
                        valorSegundoD = 0.0;

                    } else {
                        valorSegundo = parseInt(datosPrevios, 0);
                        textEcuation.setText(valorPrimero + " " + operadorActual + " " + valorSegundo);
                        int resultado = calcularResultado(valorPrimero, valorSegundo, operadorActual);
                        textInput.setText(resultado + "");
                        valorPrimero = 0;
                        valorSegundo = 0;

                    }

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
            }
        }catch (ArithmeticException e) {
            Toast.makeText(getContext(), "Operación no permitida: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            textInput.setText("0");
            textEcuation.setText("");
            }


        /*
        //@string/division
        //@string/resta
        //@string/multiplicacion

        if (buttonText.equals("AC")) {
            textInput.setText("");
            textEcuation.setText("0");
            return;
        }
        if (buttonText.equals("=")) {
            textInput.setText(textEcuation.getText());
            return;
        }
        datos_a_Calcular = datos_a_Calcular + buttonText;
        textInput.setText(datos_a_Calcular);
        textInput.getText().toString();
        switch (buttonText) {
            case "AC":
                textInput.setText("");
                textEcuation.setText("0");
                valorPrimero = 0.0;
                valorSegundo = 0.0;
                operadorActual = "";
                break;
            case "=":
                valorSegundo = Double.parseDouble(textInput.getText().toString());
                double resultado = calcularResultado(valorPrimero, valorSegundo, operadorActual);
                textInput.setText(String.valueOf(resultado));
                textEcuation.setText(valorPrimero + " " + operadorActual + " " + valorSegundo + " = " + resultado);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                operadorActual = buttonText;
                valorPrimero = Double.parseDouble(textInput.getText().toString());
                textInput.setText("");
                break;
            default:
                datos_a_Calcular = datos_a_Calcular + buttonText;
                textEcuation.setText(datos_a_Calcular);
                break;
        }

         */
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


    public int calcularResultado(int valorPrimero, int valorSegundo, String operadorActual) {
        int operacion;
        switch (operadorActual) {
            case "+":
                operacion = valorPrimero + valorSegundo;
                break;
            case "-":
                operacion = valorPrimero - valorSegundo;
                break;
            case "*":
                operacion = valorPrimero * valorSegundo;
                break;
            case "/":
                if (valorSegundo == 0){
                    operacion = valorPrimero / valorSegundo;
                    Toast.makeText(null, "No es posible esta operación", Toast.LENGTH_SHORT).show();
                }else{
                    operacion = valorPrimero / valorSegundo;
                }
                if (valorPrimero==0 && operadorActual=="/" && valorSegundo==0){
                    throw new ArithmeticException("División por cero no permitida");
                }
                break;
            default:
                operacion=0;
        }
        return operacion;
    }

    public double calcularResultadoD(double valorPrimeroD, double valorSegundoD, String operadorActual) {
        double operacion;
        switch (operadorActual) {
            case "+":
                operacion = valorPrimeroD + valorSegundoD;
                break;
            case "-":
                operacion = valorPrimeroD - valorSegundoD;
                break;
            case "*":
                operacion = valorPrimeroD * valorSegundoD;
                break;
            case "/":
                if (valorSegundoD == 0.0){
                    operacion = valorPrimeroD / valorSegundoD;
                    throw new ArithmeticException("División por cero no permitida");
                }else{
                    operacion = valorPrimeroD / valorSegundoD;
                }
                break;
            default:
                operacion = 0.0;
                break;
        }
        return operacion;
    }
}