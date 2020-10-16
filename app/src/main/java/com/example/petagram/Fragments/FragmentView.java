package com.example.petagram.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.Adaptadores.MascotasAdaptador;
import com.example.petagram.Adaptadores.MascotasAdaptadorPerfil;
import com.example.petagram.Permanencia.Permanencia;
import com.example.petagram.Mascota.Mascota;
import com.example.petagram.R;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;


public class FragmentView extends Fragment {
    List<Mascota> mascotas;
    RecyclerView listaMascotas;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        listaMascotas = v.findViewById(R.id.RvLista);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializaAdaptador();
        return v;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
            ((MascotasAdaptador)listaMascotas.getAdapter()).updateAdapter();
            ((MascotasAdaptador)listaMascotas.getAdapter()).notifyDataSetChanged();
    }
    @Override
    public void onResume() {
        super.onResume();
        ((MascotasAdaptador) listaMascotas.getAdapter()).updateAdapter();
        ((MascotasAdaptador)listaMascotas.getAdapter()).notifyDataSetChanged();
    }

    private void inicializaAdaptador() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {

             mascotas = Permanencia.ConexionSql.getDb().MascotaDao().getAll();

            }
        });
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MascotasAdaptador ma = new MascotasAdaptador(mascotas);
        ma.setActivity(getActivity());
        listaMascotas.setAdapter(ma);

    }


}
