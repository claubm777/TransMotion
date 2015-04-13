package models;

/**
 * Created by Asus on 11/04/2015.
 */
public class Location {
    public int latitud;
public int longitud;

public int estacionLatitud;
public int estacionLongitud;
public String nombreEstación;

    public Location(int lat, int longi) {
        this.latitud = lat;
        this.longitud = longi;
        this.estacionLatitud = 0;
        this.estacionLongitud =0;
        this.nombreEstación = "Estacion";
    }

    public int getLatitud() {
        return latitud;
    }

    public int getEstacionLatitud() {
        return estacionLatitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public int getEstacionLongitud() {
        return estacionLongitud;
    }

    public void setLongitud(int longi) {
        this.longitud = longi;
    }

    public void setLatitud(int lat) {
        this.latitud = lat;
    }

    public void setEstacionLongitud(int longi) {
        this.estacionLongitud = longi;
    }

    public void setEstacionLatitud(int lat) {
        this.estacionLatitud = lat;
    }
}
