package com.example.petagram.Mascota;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mascota implements Parcelable {
    @PrimaryKey
    public int MascotaId;
    @ColumnInfo(name = "MascotaNombre")
    public String MascotaNombre;
    @ColumnInfo(name = "MascotaRaits")
    public int MascotaRaits;
    @ColumnInfo(name = "MascotaFoto")
    public int MascotaFoto;
    @ColumnInfo(name = "MascotaRaiteado")
    public boolean MascotaRaiteado;
    @ColumnInfo(name = "MascotaTiempoDeRait")
    public long MascotaTiempoDeRait;

    public Mascota(int MascotaId, String MascotaNombre, int MascotaRaits, int MascotaFoto, boolean MascotaRaiteado, long MascotaTiempoDeRait) {
        this.MascotaId = MascotaId;
        this.MascotaNombre = MascotaNombre;
        this.MascotaRaits = MascotaRaits;
        this.MascotaFoto = MascotaFoto;
        this.MascotaRaiteado = MascotaRaiteado;
        this. MascotaTiempoDeRait = MascotaTiempoDeRait;
    }

    protected Mascota(Parcel in) {
        MascotaId = in.readInt();
        MascotaNombre = in.readString();
        MascotaRaits = in.readInt();
        MascotaFoto = in.readInt();
        MascotaRaiteado = in.readByte() != 0;
        MascotaTiempoDeRait = in.readLong();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(MascotaId);
        dest.writeString(MascotaNombre);
        dest.writeInt(MascotaRaits);
        dest.writeInt(MascotaFoto);
        dest.writeByte((byte) (MascotaRaiteado ? 1 : 0));
        dest.writeLong(MascotaTiempoDeRait);
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

    public boolean isMascotaRaiteado() {
        return MascotaRaiteado;
    }

    public int getMascotaId() {
        return MascotaId;
    }

    public void setMascotaId(int mascotaId) {
        MascotaId = mascotaId;
    }

    public void setMascotaNombre(String mascotaNombre) {
        MascotaNombre = mascotaNombre;
    }

    public void setMascotaRaits(int mascotaRaits) {
        MascotaRaits = mascotaRaits;
    }

    public void setMascotaFoto(int mascotaFoto) {
        MascotaFoto = mascotaFoto;
    }

    public void setMascotaRaiteado(boolean mascotaRaiteado) {
        MascotaRaiteado = mascotaRaiteado;
    }

    public long getMascotaTiempoDeRait() {
        return MascotaTiempoDeRait;
    }

    public void setMascotaTiempoDeRait(long mascotaTiempoDeRait) {
        MascotaTiempoDeRait = mascotaTiempoDeRait;
    }

    public String getMascotaNombre() {
        return MascotaNombre;
    }

    public int getMascotaRaits() {
        return MascotaRaits;
    }

    public int getMascotaFoto() {
        return MascotaFoto;
    }

    public void darLike() {
        MascotaRaits++;
        MascotaRaiteado = true;
    }

    public void quitarLike() {
        MascotaRaits--;
        MascotaRaiteado = false;
    }

    @Override
    public int describeContents() {
        return 0;
    }


}


