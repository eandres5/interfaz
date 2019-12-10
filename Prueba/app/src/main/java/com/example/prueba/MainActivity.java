package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    private EditText txtUsu;
    private EditText txtPass;
    private Button btnIngre;

    private String email="";
    private String password="";

    private String firstna;
    private String lastna;
    private String role;


    private FirebaseAuth mAuth;

    //referencia al nodo principal
    DatabaseReference mRootReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mRootReference = FirebaseDatabase.getInstance().getReference();


        txtUsu = (EditText)findViewById(R.id.txtUsuario);
        txtPass = (EditText)findViewById(R.id.txtPassword);
        btnIngre = (Button)findViewById(R.id.btnIngresar);


        //comprueba si la base de datos tiene el usuario ingresado.

        btnIngre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=txtUsu.getText().toString();
                password=txtPass.getText().toString();

                login();

            }
        });


        //funcion para extraer los datos del usuario hace referencai a la clase user con metodos setters and getters
        // esta funcion no vale mijo jejej
        //o sea si vale pero no se como pasar los datos que se extraen aqui a la nueva ventana,
        //todas las variables que se crean son de la clase user por que es un objeto y asi se divide al objeto en partes.

        mRootReference.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (final DataSnapshot snapshot: dataSnapshot.getChildren()){

                    mRootReference.child("Users").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            user us = snapshot.getValue(user.class);

                            //variables para traer los datos
                            String email = us.getEmail();
                            String first = us.getFirstname();
                            String last = us.getLastname();
                            String key = us.getKey();
                            //String materias = us.getMaterias;
                            String paralelo = us.getParalelo();
                            String periodo = us.getPeriodo();
                            String role = us.getRole();



                            Log.e("email", "" + email);
                            Log.e("FirstName", "" + first);
                            Log.e("email", "" + last);
                            Log.e("email", "" + role);



                            Log.e("Datos","" + snapshot.getValue());

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }

    private void login(){

        if(!email.isEmpty() && !password.isEmpty()){


            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        final Intent inte = new Intent(getApplication(),controlNotas.class);
                        inte.putExtra(controlNotas.user, email);
                        startActivity(inte);


                    }else{
                        Toast.makeText(MainActivity.this,"No se pudo iniciar sesiòn compruebe los datos",Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }else{
            Toast.makeText(MainActivity.this,"Complete los campos",Toast.LENGTH_SHORT).show();
        }

    }


}
