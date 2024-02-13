package com.ugb.conversores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TabWidget;

public class MainActivity extends AppCompatActivity {

    TabHost tbh;
    Spinner spn, spnAlm, spnMon, spnMas, spnVol, spnTie, spnTransf;
    TextView tempVal, tempValAlm, tempValMon, tempValMas, tempValVol, tempValTie, tempValTransf;
    Button btn, btnAlm, btnMon, btnMas, btnVol, btnTie, btnTransf;
    conversores miObj = new conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //valores para los edittext
        EditText txtLongitud= (EditText)findViewById(R.id.txtLongitudCantidad);
        EditText txtAlmacenamiento= (EditText)findViewById(R.id.txtAlmacenamientoCantidad);
        EditText txtMonedas= (EditText)findViewById(R.id.txtMonedasCantidad);
        EditText txtMasa= (EditText)findViewById(R.id.txtMasaCantidad);
        EditText txtVolumen= (EditText)findViewById(R.id.txtVolumenCantidad);
        EditText txtTiempo= (EditText)findViewById(R.id.txtTiempoCantidad);
        EditText txtTransferenciaDatos= (EditText)findViewById(R.id.txtTransfDatosCantidad);


        //cambiar color barra de estado
        cambiarColorBarraEstado(getResources().getColor(R.color.gray60));

        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("longitud").setIndicator("LONGITUD").setContent(R.id.tabLongitud));
        tbh.addTab(tbh.newTabSpec("almacenamiento").setIndicator("ALMACENAMIENTO").setContent(R.id.tabAlmacenamiento));
        tbh.addTab(tbh.newTabSpec("monedas").setIndicator("MONEDAS").setContent(R.id.tabMonedas));
        tbh.addTab(tbh.newTabSpec("masa").setIndicator("MASA").setContent(R.id.tabMasa));
        tbh.addTab(tbh.newTabSpec("volumen").setIndicator("VOLUMEN").setContent(R.id.tabVolumen));
        tbh.addTab(tbh.newTabSpec("tiempo").setIndicator("TIEMPO").setContent(R.id.tabTiempo));
        tbh.addTab(tbh.newTabSpec("transferencia").setIndicator("TRANSFERENCIA DE DATOS").setContent(R.id.tabTransfDatos));


        // Obtener el TabWidget personalizado y habilitar el desplazamiento horizontal
        TabWidget tabWidget = tbh.getTabWidget();
        tabWidget.setStripEnabled(false); // Desactivar la tira indicadora
        tabWidget.setShowDividers(TabWidget.SHOW_DIVIDER_NONE); // Ocultar los divisores

        //Longitud
        btn = findViewById(R.id.btnLongitudConvertir);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Longitud
                if(txtLongitud.getText().toString().isEmpty()){
                    txtLongitud.setError("Campo obligatorio");

                } else{
                    spn = findViewById(R.id.spnLongitudDe);
                    int de = spn.getSelectedItemPosition();

                    spn = findViewById(R.id.spnLongitudA);
                    int a = spn.getSelectedItemPosition();

                    tempVal = findViewById(R.id.txtLongitudCantidad);
                    double cantidad = Double.parseDouble(tempVal.getText().toString());

                    double resp = miObj.convertir(0, de, a, cantidad);
                    Toast.makeText(getApplicationContext(), "Respuesta: "+ resp, Toast.LENGTH_LONG).show();
                }

                //tempVal.setText("");
            }


        });

        //Almacenamiento
        btnAlm = findViewById(R.id.btnAlmacenamientoConvertir);
        btnAlm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtAlmacenamiento.getText().toString().isEmpty()){
                    txtAlmacenamiento.setError("Campo obligatorio");

                } else {
                    spnAlm = findViewById(R.id.spnAlmacenamientoDe);
                    int de = spnAlm.getSelectedItemPosition();

                    spnAlm = findViewById(R.id.spnAlmacenamientoA);
                    int a = spnAlm.getSelectedItemPosition();

                    tempValAlm = findViewById(R.id.txtAlmacenamientoCantidad);
                    double cantidad = Double.parseDouble(tempValAlm.getText().toString());

                    double respAlm = miObj.convertir(1, de, a, cantidad);
                    Toast.makeText(getApplicationContext(), "Respuesta: " + respAlm, Toast.LENGTH_LONG).show();
                }
            }
        });

        //Monedas
        btnMon = findViewById(R.id.btnMonedasConvertir);
        btnMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txtMonedas.getText().toString().isEmpty()){
                    txtMonedas.setError("Campo obligatorio");

                } else {
                    spnMon = findViewById(R.id.spnMonedasDe);
                    int de = spnMon.getSelectedItemPosition();

                    spnMon = findViewById(R.id.spnMonedasA);
                    int a = spnMon.getSelectedItemPosition();

                    tempValMon = findViewById(R.id.txtMonedasCantidad);
                    double cantidad = Double.parseDouble(tempValMon.getText().toString());

                    double respMon = miObj.convertir(2, de, a, cantidad);
                    Toast.makeText(getApplicationContext(), "Respuesta: " + respMon, Toast.LENGTH_LONG).show();

                }
            }
        });

        //Masa
        btnMas = findViewById(R.id.btnMasaConvertir);
        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtMasa.getText().toString().isEmpty()){
                    txtMasa.setError("Campo obligatorio");

                } else {
                    spnMas = findViewById(R.id.spnMasaDe);
                    int de = spnMas.getSelectedItemPosition();

                    spnMas = findViewById(R.id.spnMasaA);
                    int a = spnMas.getSelectedItemPosition();

                    tempValMas = findViewById(R.id.txtMasaCantidad);
                    double cantidad = Double.parseDouble(tempValMas.getText().toString());

                    double respMas = miObj.convertir(3, de, a, cantidad);
                    Toast.makeText(getApplicationContext(), "Respuesta: " + respMas, Toast.LENGTH_LONG).show();
                }
            }
        });

        //Volumen
        btnVol = findViewById(R.id.btnVolumenConvertir);
        btnVol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtVolumen.getText().toString().isEmpty()){
                    txtVolumen.setError("Campo obligatorio");

                } else {
                    spnVol = findViewById(R.id.spnVolumenDe);
                    int de = spnVol.getSelectedItemPosition();

                    spnVol = findViewById(R.id.spnVolumenA);
                    int a = spnVol.getSelectedItemPosition();

                    tempValVol = findViewById(R.id.txtVolumenCantidad);
                    double cantidad = Double.parseDouble(tempValVol.getText().toString());

                    double respVol = miObj.convertir(4, de, a, cantidad);
                    Toast.makeText(getApplicationContext(), "Respuesta: " + respVol, Toast.LENGTH_LONG).show();
                }


            }
        });

        //Tiempo
        btnTie = findViewById(R.id.btnTiempoConvertir);
        btnTie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtTiempo.getText().toString().isEmpty()){
                    txtTiempo.setError("Campo obligatorio");

                } else {
                    spnTie = findViewById(R.id.spnTiempoDe);
                    int de = spnTie.getSelectedItemPosition();

                    spnTie = findViewById(R.id.spnTiempoA);
                    int a = spnTie.getSelectedItemPosition();

                    tempValTie = findViewById(R.id.txtTiempoCantidad);
                    double cantidad = Double.parseDouble(tempValTie.getText().toString());

                    double respTie = miObj.convertir(5, de, a, cantidad);
                    Toast.makeText(getApplicationContext(), "Respuesta: " + respTie, Toast.LENGTH_LONG).show();
                }
            }
        });

        //Transferencia de datos
        btnTransf = findViewById(R.id.btnTransfDatosConvertir);
        btnTransf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtTransferenciaDatos.getText().toString().isEmpty()){
                    txtTransferenciaDatos.setError("Campo obligatorio");

                } else {
                    spnTransf = findViewById(R.id.spnTransfDatosDe);
                    int de = spnTransf.getSelectedItemPosition();

                    spnTransf = findViewById(R.id.spnTransfDatosA);
                    int a = spnTransf.getSelectedItemPosition();

                    tempValTransf = findViewById(R.id.txtTransfDatosCantidad);
                    double cantidad = Double.parseDouble(tempValTransf.getText().toString());

                    double respTransf = miObj.convertir(6, de, a, cantidad);
                    Toast.makeText(getApplicationContext(), "Respuesta: " + respTransf, Toast.LENGTH_LONG).show();
                }

            }
        });

    } //


    private void cambiarColorBarraEstado(int color) {
        // Verificar si la versión del SDK es Lollipop o superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    } //fin cambiar colorbarraestado

    class conversores{
        double[][] valores = {
                {1, 100, 39.3701, 3.28084, 1.193, 1.09361, 0.001, 0.000621371}, //longitud
                {1, 0.001, 0.000001, 0.000000001, 1000, 1000000, 0.000000001, 0.000001, 0.008, 8}, //Almacenamiento
                {1, 0.92, 7.86, 24.62, 36.56, 8.75, 535.14, 145.52, 83.32, 0.79}, //Monedas
                {1, 0.453592, 453.592, 0.000453592, 453592, 453600000, 0.000446429, 0.0005, 0.0714286, 16}, //Masa
                {1, 0.264172, 1.05669, 2.11338, 4.16667, 33.814, 67.628, 202.884, 0.001, 1000}, //Volumen
                {1, 60, 0.0166667, 0.000694444, 0.000099206, 0.000022831, 0.0000019026, 0.00000019026, 0.00000001903, 60000}, //Tiempo
                {1, 8, 7.62939, 8e+6, 8000, 1000, 7812.5, 0.008, 0.001, 0.00745058, 8e-6, 1e-6, 7.276e-6}  //Transferencia de datos

        };
        public double convertir(int opcion, int de, int a, double cantidad){
            return valores[opcion][a] / valores[opcion][de] * cantidad;
        }

    }
}