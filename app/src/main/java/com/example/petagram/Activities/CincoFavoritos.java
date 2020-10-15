package com.example.petagram.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.Adaptadores.MascotasAdaptador;
import com.example.petagram.Adaptadores.Recursos;
import com.example.petagram.R;
import com.google.android.material.appbar.MaterialToolbar;

public class CincoFavoritos extends AppCompatActivity {
    RecyclerView listaMascotas;
    MaterialToolbar Mt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cincofavoritos);

        //MaterialToolbar init//
        Mt = findViewById(R.id.topAppBar);
        Mt.setNavigationIcon(R.drawable.back);
        Mt.setTitle("Te gustaron");
        setSupportActionBar(Mt);
        Mt.setNavigationOnClickListener(v -> finish());
        //MaterialToolbar init//

        //Recycler View init//
        listaMascotas = findViewById(R.id.RvLista);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        InicializarAdaptador();
        //Recycler View Init//

    }

    public void InicializarAdaptador() {
        Recursos.MascotaAdaptador.setActivity(this);
        Recursos.MascotaAdaptador.getAdaptador().filtrarNoLikeados();
        listaMascotas.setAdapter(Recursos.MascotaAdaptador.getAdaptador());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_app_bar, menu);
        Mt.getMenu().findItem(R.id.favoritos).setVisible(false);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.acercade:
                intent = new Intent(this, AcercaDe.class);
                startActivity(intent);
                return true;
            case R.id.contacto:
                intent = new Intent(this, Contacto.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
