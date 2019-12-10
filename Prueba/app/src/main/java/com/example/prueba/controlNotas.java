package com.example.prueba;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class controlNotas extends AppCompatActivity {

    public static final String user = "names";
    public static final String nombre = "name";
    public static final String apellido = "nam";
    public static final String key = "nam";
    public static final String curso = "nam";
    public static final String mateiras = "nam";
    public static final String paralelo = "nam";
    public static final String periodo = "nam";
    public static final String role = "na";

    public TextView usuario;
    public TextView first;
    public TextView last;
    public TextView clave;
    public TextView curs;
    public TextView materia;
    public TextView parale;
    public TextView peri;
    public TextView r;


    DatabaseReference mRootReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_notas);


        //Se asigna la variable a cada txtView
        usuario = (TextView)findViewById(R.id.textView2);
        first = (TextView)findViewById(R.id.txtVMateria1);
        last = (TextView)findViewById(R.id.txtVNotaMa1);
        r = (TextView)findViewById(R.id.txtTotalMa1);


        //se toma los datos de la ventana de login
        String usua = getIntent().getStringExtra("names");
        String nom = getIntent().getStringExtra("name");
        String apel = getIntent().getStringExtra("nam");
        String rol = getIntent().getStringExtra("na");


        //se setean los datos en cada txtView
        usuario.setText(usua);
        first.setText(nom);
        last.setText(apel);
        r.setText(rol);




    }
}
