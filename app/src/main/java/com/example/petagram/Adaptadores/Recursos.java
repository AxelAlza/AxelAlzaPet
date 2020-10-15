package com.example.petagram.Adaptadores;

import android.app.Activity;

public class Recursos {

    public static class MascotaAdaptador {
        static Dataset data = new Dataset();
        static MascotasAdaptador adaptador = new MascotasAdaptador(data.getData());
        public static void setActivity(Activity activity){
            adaptador.setActivity(activity);
        }
        public static MascotasAdaptador getAdaptador(){
            return adaptador;
        }
    }
}
