package mx.unam.myapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSuma;
    EditText edtNumero1;
    EditText edtNumero2;
    TextView txvRespuesta;
    Button btnResta;
    Button btnMultiplica;
    Button btnDivi;
    Operaciones operacion = new Operaciones();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumero1 = (EditText) findViewById(R.id.txtNum1);
        edtNumero2 = (EditText) findViewById(R.id.txtNum2);
        txvRespuesta = (TextView) findViewById(R.id.txtResultado);
        btnSuma = (Button) findViewById(R.id.btnSuma);
        btnResta = (Button) findViewById(R.id.btnResta);
        btnMultiplica = (Button) findViewById(R.id.btnMulti);
        btnDivi = (Button) findViewById(R.id.btnDivi);

        //clase anonima
        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res;
                if (isValid()) {
                    int num2 = Integer.valueOf(edtNumero2.getText().toString());
                    int num1 = Integer.valueOf(edtNumero1.getText().toString());


                    res = operacion.suma(num1, num2);
                    showResult(String.valueOf(res));
                    closeKeyWord();
                } else {
                    showError();
                }

            }
        });


        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res;
                if (isValid()) {
                    int num2 = Integer.valueOf(edtNumero2.getText().toString());
                    int num1 = Integer.valueOf(edtNumero1.getText().toString());


                    res = operacion.resta(num1, num2);
                    showResult(String.valueOf(res));
                    closeKeyWord();
                } else {
                    showError();
                }
            }
        });

        btnMultiplica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res;
                if (isValid()) {
                    int num2 = Integer.valueOf(edtNumero2.getText().toString());
                    int num1 = Integer.valueOf(edtNumero1.getText().toString());


                    res = operacion.multiplica(num1, num2);
                    showResult(String.valueOf(res));
                    closeKeyWord();
                } else {
                    showError();
                }
            }
        });

        btnDivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res;
                if (isValid()) {
                    int num2 = Integer.valueOf(edtNumero2.getText().toString());
                    int num1 = Integer.valueOf(edtNumero1.getText().toString());


                    res = operacion.divide(num1, num2);
                    showResult(String.valueOf(res));
                    closeKeyWord();
                } else {
                    showError();
                }
            }
        });


    }

    public void showError() {
        Toast.makeText(MainActivity.this, "Ingrese los datos correctos", Toast.LENGTH_SHORT).show();
    }

    public void showResult(String resultado) {
        txvRespuesta.setText(resultado);
    }

    public boolean isValid() {
        return !(TextUtils.isEmpty(edtNumero1.getText().toString()) || TextUtils.isEmpty(edtNumero2.getText().toString()));
    }

    public void closeKeyWord() {
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


}
