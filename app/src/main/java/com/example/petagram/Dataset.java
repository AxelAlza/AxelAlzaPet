package com.example.petagram;

import java.util.ArrayList;

public class Dataset {
    ArrayList<Mascota> mascotas = new ArrayList<>();
    public Dataset() {
        mascotas.add(new Mascota("Thurston Waffles", 20, R.drawable.thurston));
        mascotas.add(new Mascota("Cheems", 21, R.drawable.cheems));
        mascotas.add(new Mascota("Doge", 30, R.drawable.doge));
        mascotas.add(new Mascota("Keyboard cat", 10, R.drawable.keycat));
        mascotas.add(new Mascota("Harambe", 100, R.drawable.harambe));
        mascotas.add(new Mascota("Gruñon", 50, R.drawable.grumpy_cat));
        mascotas.add(new Mascota("Teleperro", 13, R.drawable.dog));
        mascotas.add(new Mascota("Porque me gritan", 200, R.drawable.meme));
    }

    public ArrayList<Mascota> getData() {
        return mascotas;
    }
    }


