package es.babel.model;

import java.util.List;
import java.util.Objects;

public class Cliente{
    int id;
    String dni;
    String nombre;
    int direccionPostal;
    String email;
    String telefono;
    Sucursal sucursalPrincipal;
    List<Cuenta> cuentasAsociadas;

    public Cliente() {
    }

    public Cliente(int id, String dni, String nombre, int direccionPostal, String email, String telefono,
            Sucursal sucursalPrincipal, List<Cuenta> cuentasAsociadas) {
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

    public List<Cuenta> getCuentasAsociadas() {
        return cuentasAsociadas;
    }

    public void setCuentasAsociadas(List<Cuenta> cuentasAsociadas) {
        this.cuentasAsociadas = cuentasAsociadas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return id == cliente.id || Objects.equals(dni, cliente.dni) || Objects.equals(email, cliente.email);
    }

}