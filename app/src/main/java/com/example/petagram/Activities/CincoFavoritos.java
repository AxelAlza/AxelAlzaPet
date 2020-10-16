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
import com.example.petagram.Mascota.Mascota;
import com.example.petagram.Permanencia.Permanencia;
import com.example.petagram.R;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CincoFavoritos extends AppCompatActivity {
    RecyclerView listaMascotas;
    MaterialToolbar Mt;
    List<Mascota> mascotas;



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
        inicializarAdaptador();
        //Recycler View Init//

    }

    private void inicializarAdaptador() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mascotas = Permanencia.ConexionSql.getDb().MascotaDao().getGustados();
            }
        });
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MascotasAdaptador ma = new MascotasAdaptador(mascotas);
        ma.setActivity(this);
        listaMascotas.setAdapter(ma);

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
