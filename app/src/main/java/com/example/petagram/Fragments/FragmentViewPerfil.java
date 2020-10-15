package com.example.petagram.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petagram.Adaptadores.Dataset;
import com.example.petagram.Adaptadores.MascotasAdaptadorPerfil;
import com.example.petagram.Adaptadores.Recursos;
import com.example.petagram.R;


public class FragmentViewPerfil extends Fragment {
    RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_perfil,container, false);
        listaMascotas = v.findViewById(R.id.RvLista);
        GridLayoutManager GlM = new GridLayoutManager(getActivity(), 3);
        GlM.setOrientation(RecyclerView.VERTICAL);
        listaMascotas.setLayoutManager(GlM);
        InicializarAdaptador();
        return v;
    }

    public void InicializarAdaptador() {
        Dataset data = new Dataset();
        MascotasAdaptadorPerfil adaptadorPerfil = new MascotasAdaptadorPerfil(data.getData());
        adaptadorPerfil.setActivity(getActivity());
        listaMascotas.setAdapter(adaptadorPerfil);
    }
}