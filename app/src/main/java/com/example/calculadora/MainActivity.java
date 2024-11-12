package com.example.calculadora;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottomNavigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationSelectedListener);

        LayoutInflater inflater = LayoutInflater.from(this);
        View inflatedView1 = inflater.inflate(R.layout.fragment_first, null);






        loadFragment(firstFragment);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.firstFragment:
                    loadFragment(firstFragment);
                    return true;
                case R.id.secondFragment:
                    loadFragment(secondFragment);
                    return true;
                case R.id.thirdFragment:
                    loadFragment(thirdFragment);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer, fragment);
        transaction.commit();

    }
    void asignarId (MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
/*
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String datos_a_Calcular = textInput.getText().toString();
        if (buttonText.equals("AC")){
            textInput.setText("");
            textEcuation.setText("0");
            return;
        }if (buttonText.equals("=")){
            textInput.setText(textEcuation.getText());
            return;
        }
        datos_a_Calcular = datos_a_Calcular+buttonText;
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
                    valorPrimero = Double.parseDouble(textInput.getText().toString()); textInput.setText("");
                    break;
                default:
                    datos_a_Calcular = datos_a_Calcular + buttonText; textInput.setText(datos_a_Calcular);
                    break;
        }
    }
    public double calcularResultado(double valorPrimero, double valorSegundo, String operador){
        switch (operador) {
        case "+":
            return valorPrimero + valorSegundo;
        case "-":
            return valorPrimero - valorSegundo;
        case "*":
            return valorPrimero * valorSegundo;
        case "/":
            return valorPrimero / valorSegundo;
        default:
            return 0.0;
        }

 */
    }
}
