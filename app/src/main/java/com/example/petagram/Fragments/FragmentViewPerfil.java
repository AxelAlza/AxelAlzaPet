package com.example.petagram.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petagram.Adaptadores.MascotasAdaptadorPerfil;
import com.example.petagram.Mascota.Mascota;
import com.example.petagram.Permanencia.Permanencia;
import com.example.petagram.R;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class FragmentViewPerfil extends Fragment {
    RecyclerView listaMascotas;
    List<Mascota> mascotas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_perfil, container, false);
        listaMascotas = v.findViewById(R.id.RvLista);
        GridLayoutManager GlM = new GridLayoutManager(getActivity(), 3);
        GlM.setOrientation(RecyclerView.VERTICAL);
        listaMascotas.setLayoutManager(GlM);
        inicializarAdaptador();
        return v;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        ((MascotasAdaptadorPerfil) listaMascotas.getAdapter()).updateAdapter();
        ((MascotasAdaptadorPerfil) listaMascotas.getAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        ((MascotasAdaptadorPerfil) listaMascotas.getAdapter()).updateAdapter();
        ((MascotasAdaptadorPerfil) listaMascotas.getAdapter()).notifyDataSetChanged();
        super.onResume();
    }

    public void inicializarAdaptador() {
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
        MascotasAdaptadorPerfil ma = new MascotasAdaptadorPerfil(mascotas);
        ma.setActivity(getActivity());
        listaMascotas.setAdapter(ma);
    }


}