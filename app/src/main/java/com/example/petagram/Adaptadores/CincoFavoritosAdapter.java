package com.example.petagram.Adaptadores;


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

import com.example.petagram.Mascota.Mascota;
import com.example.petagram.Permanencia.Permanencia;
import com.example.petagram.R;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CincoFavoritosAdapter extends RecyclerView.Adapter<CincoFavoritosAdapter.MascotaViewHolder> {

    Activity activity;
    List<Mascota> MascotasVisibles;

    public CincoFavoritosAdapter(List<Mascota> mascotas) {
        MascotasVisibles = mascotas;

    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void updateAdapter(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                MascotasVisibles = Permanencia.ConexionSql.getDb().MascotaDao().getGustados();
            }
        });
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota m = MascotasVisibles.get(position);
        holder.IbLike.setTag(0);
        holder.TvNombre.setText(m.getMascotaNombre());
        holder.TvLikes.setText(String.valueOf(m.getMascotaRaits()));
        holder.IvFoto.setImageResource(m.getMascotaFoto());
        if (m.isMascotaRaiteado()) {
            holder.IbLike.setTag(1);
            holder.IbLike.setImageResource(R.drawable.ic_like);
        } else {
            holder.IbLike.setTag(0);
            holder.IbLike.setImageResource(R.drawable.ic_nolike);
        }
        holder.IbLike.setOnClickListener(v -> {
            if ((int) (holder.IbLike.getTag()) == 0) {
                m.darLike();
                holder.IbLike.setTag(1);
                Toast.makeText(activity, "Le diste like a " + m.getMascotaNombre() + " :)", Toast.LENGTH_SHORT).show();
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        Permanencia.ConexionSql.getDb().MascotaDao().updateMascota(m);
                        updateAdapter();
                        notifyDataSetChanged();
                    }
                });
                executorService.shutdown();
                try {
                    executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                holder.IbLike.setImageResource(R.drawable.ic_like);
            } else {
                m.quitarLike();
                holder.IbLike.setTag(0);
                Toast.makeText(activity, "Le quitaste like a " + m.getMascotaNombre() + " :(", Toast.LENGTH_SHORT).show();
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        Permanencia.ConexionSql.getDb().MascotaDao().updateMascota(m);
                        updateAdapter();
                        notifyDataSetChanged();
                    }
                });
                executorService.shutdown();
                try {
                    executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                holder.IbLike.setImageResource(R.drawable.ic_nolike);
            }
            holder.TvLikes.setText(String.valueOf(m.getMascotaRaits()));
        });
    }


    @Override
    public int getItemCount() {
        return MascotasVisibles.size();
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
