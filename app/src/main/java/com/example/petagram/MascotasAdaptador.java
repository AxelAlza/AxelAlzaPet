package com.example.petagram;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.MascotaViewHolder> {

    Activity activity;
    ArrayList<Mascota> Mascotas;

    public MascotasAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        Mascotas = mascotas;
        this.activity = activity;
    }

    public ArrayList<Mascota> getMascotas() {
        return Mascotas;
    }

    public void filtrarNoLikeados() {
        ArrayList<Mascota> resultado = new ArrayList();
        for (Mascota m : Mascotas) {
            if (m.isLikeado()) {
                resultado.add(m);
            }
        }
        Mascotas = resultado;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota m = Mascotas.get(position);
        holder.IbLike.setTag(0);
        holder.TvNombre.setText(m.getNombre());
        holder.TvLikes.setText(String.valueOf(m.getLikes()));
        holder.IvFoto.setImageResource(m.getFoto());
        if (m.isLikeado()){
           holder.IbLike.setTag(1);
           holder.IbLike.setImageResource(R.drawable.ic_like);
        }
        else{
            holder.IbLike.setTag(0);
            holder.IbLike.setImageResource(R.drawable.ic_nolike);
        }
        holder.IbLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((int) (holder.IbLike.getTag()) == 0) {
                    m.darLike();
                    holder.IbLike.setTag(1);
                    Toast.makeText(activity, "Le diste like a " + m.getNombre() + " :)", Toast.LENGTH_SHORT).show();
                    holder.IbLike.setImageResource(R.drawable.ic_like);
                } else {
                    m.quitarLike();
                    holder.IbLike.setTag(0);
                    Toast.makeText(activity, "Le quitaste like a " + m.getNombre() + " :(", Toast.LENGTH_SHORT).show();
                    holder.IbLike.setImageResource(R.drawable.ic_nolike);
                }
                holder.TvLikes.setText(String.valueOf(m.getLikes()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return Mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView IvFoto;
        private TextView TvNombre;
        private TextView TvLikes;
        private ImageButton IbLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            IbLike = itemView.findViewById(R.id.IbLike);
            IvFoto = itemView.findViewById(R.id.IvFoto);
            TvNombre = itemView.findViewById(R.id.TvNombre);
            TvLikes = itemView.findViewById(R.id.TvLikes);

        }
    }
}
