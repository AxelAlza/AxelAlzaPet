package com.example.petagram.Permanencia;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.petagram.Mascota.Mascota;

import java.util.List;

public class Permanencia {


    @Dao
    public interface MascotaDao {
        @Query("SELECT * FROM Mascota")
        List<Mascota> getAll();

        @Query("SELECT * FROM Mascota WHERE MascotaRaiteado = 1 ORDER BY MascotaTiempoDeRait desc LIMIT 5 ")
         List<Mascota> getGustados();

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        public void insertMascota(Mascota... mascota);

        @Update(onConflict = OnConflictStrategy.REPLACE)
        public void updateMascota(Mascota... mascota);

    }

    public static class ConexionSql{
        private static AppDatabase db;

        public static void setDb(AppDatabase db) {
            ConexionSql.db= db;
        }

        public static AppDatabase getDb() {
            return db;
        }
    }
    }

