package es.babel.model;

public class Cliente{
    int id;
    String dni;
    String nombre;
    int direccionPostal;
    String email;
    String telefono;
    Sucursal sucursalPrincipal;

    public Cliente() {
    }

    public Cliente(int id, String dni, String nombre, int direccionPostal, String email, String telefono, Sucursal sucursalPrincipal) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.direccionPostal = direccionPostal;
        this.email = email;
        this.telefono = telefono;
        this.sucursalPrincipal = sucursalPrincipal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(int direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Sucursal getSucursalPrincipal() {
        return sucursalPrincipal;
    }

    public void setSucursalPrincipal(Sucursal sucursalPrincipal) {
        this.sucursalPrincipal = sucursalPrincipal;
    }
}
