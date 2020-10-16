package com.example.petagram.Permanencia;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.petagram.Mascota.Mascota;

@Database(entities = {Mascota.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract Permanencia.MascotaDao MascotaDao();
}
