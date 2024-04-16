package es.babel.model;

public class Sucursal {
    int id;
    String nombre;
    String director;
    String direccion;

    public Sucursal() {
    }

    public Sucursal(int id, String nombre, String director, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
