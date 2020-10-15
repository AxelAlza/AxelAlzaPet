package com.example.petagram.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.petagram.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputLayout;

public class Contacto extends AppCompatActivity {

     TextInputLayout TiComentario;
     TextInputLayout TiNombre;
     TextInputLayout TiEmail;
     Button btn;
     MaterialToolbar Mt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_contacto);

            //Formulario init
            TiComentario = findViewById(R.id.EtComentario);
            TiNombre = findViewById(R.id.EtName);
            TiEmail = findViewById(R.id.EtEmail);
            //

            //MaterialToolbar init//
            Mt = findViewById(R.id.topAppBar);
            Mt.setNavigationIcon(R.drawable.back);
            Mt.setTitle("Contacto");
            setSupportActionBar(Mt);
            Mt.setNavigationOnClickListener(v -> finish());
            //MaterialToolbar init//

            btn = findViewById(R.id.btn);
            btn.setOnClickListener(v -> Toast.makeText(this,"Nop, no funciona, lo intente pero no pude" , Toast.LENGTH_LONG).show());






    }
}