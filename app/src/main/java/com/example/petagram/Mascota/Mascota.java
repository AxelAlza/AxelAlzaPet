package com.example.petagram.Mascota;


import android.os.Parcel;
import android.os.Parcelable;

public class Mascota implements Parcelable {
    String Nombre;
    int Likes;
    int Foto;
    boolean likeado;

    protected Mascota(Parcel in) {
        Nombre = in.readString();
        Likes = in.readInt();
        Foto = in.readInt();
        likeado = in.readByte() != 0;
    }

    public static final Creator<Mascota> CREATOR = new Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };

    public boolean isLikeado() {
        return likeado;
    }

    public Mascota(String nombre, int likes, int foto) {
        Nombre = nombre;
        Likes = likes;
        Foto = foto;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getLikes() {
        return Likes;
    }

    public int getFoto() {
        return Foto;
    }

    public void darLike(){
        Likes++;
        likeado = true;
    }
    public void quitarLike(){
        Likes--;
        likeado = false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Nombre);
        dest.writeInt(Likes);
        dest.writeInt(Foto);
        dest.writeByte((byte) (likeado ? 1 : 0));
    }
}



