package com.example.petagram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Activity5Favoritos extends AppCompatActivity {
    RecyclerView listaMascotas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity5_favoritos);
        MaterialToolbar Mt = findViewById(R.id.topAppBar2);
        setSupportActionBar(Mt);
        Mt.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listaMascotas = findViewById(R.id.RvLista);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        InicializarAdaptador();

    }

    public void InicializarAdaptador() {
        MascotasAdaptador Adaptador = new MascotasAdaptador(getIntent().getParcelableArrayListExtra("mascotas"),this);
        Adaptador.filtrarNoLikeados();
        listaMascotas.setAdapter(Adaptador);
    }
}
