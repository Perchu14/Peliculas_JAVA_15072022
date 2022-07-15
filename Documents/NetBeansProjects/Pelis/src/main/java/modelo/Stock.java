package modelo;

public class Stock {
    
    private int idpeli;
    private String nombre;
    private String director;
    private int duracion;
    private double costo;
    private int visitas;

    public Stock(int idpeli, String nombre, String director, int duracion, double costo, int visitas) {
        this.idpeli = idpeli;
        this.nombre = nombre;
        this.director = director;
        this.duracion = duracion;
        this.costo = costo;
        this.visitas = visitas;
        
    }

    public Stock(String nombre, String director, int duracion, double costo, int visitas) {
        this.nombre = nombre;
        this.director = director;
        this.duracion = duracion;
        this.costo = costo;
        this.visitas = visitas;
    }

    public int getIdpeli() {
        return idpeli;
    }

    public void setIdpeli(int idpeli) {
        this.idpeli = idpeli;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    @Override
    public String toString() {
        return "Stock{" + "nombre=" + nombre + ", director=" + director + ", duracion=" + duracion + ", costo=" + costo + ", visitas=" + visitas + '}';
    }

}
