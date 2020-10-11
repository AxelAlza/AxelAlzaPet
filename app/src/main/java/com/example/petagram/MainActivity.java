package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.ImageSpan;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Dataset data = new Dataset();
    MascotasAdaptador Adaptador = new MascotasAdaptador(data.getData(),this);
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialToolbar tb = findViewById(R.id.topAppBar);
        tb.setOnMenuItemClickListener(item -> {
            boolean r = false;
            switch (item.getItemId()) {
                case R.id.favoritos:
                    irFavoritos();
                    r = true;
                    break;
            }
            return r;
        });
        listaMascotas = findViewById(R.id.RvLista);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        InicializarAdaptador();
    }
    public void irFavoritos() {
        Intent intent = new Intent(this, Activity5Favoritos.class);
        intent.putParcelableArrayListExtra("mascotas" , Adaptador.getMascotas());
        startActivity(intent);
    }

    public void InicializarAdaptador() {
        listaMascotas.setAdapter(Adaptador);
    }
}