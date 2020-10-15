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

import com.example.petagram.Adaptadores.Recursos;
import com.example.petagram.R;



public class FragmentView extends Fragment {
    RecyclerView listaMascotas;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        listaMascotas = v.findViewById(R.id.RvLista);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        InicializarAdaptador();
        return v;
    }

    public void InicializarAdaptador() {
        Recursos.MascotaAdaptador.setActivity(getActivity());
        Recursos.MascotaAdaptador.getAdaptador().MostrarTodo();
        listaMascotas.setAdapter(Recursos.MascotaAdaptador.getAdaptador());
    }


}
