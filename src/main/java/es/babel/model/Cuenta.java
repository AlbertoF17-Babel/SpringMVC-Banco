package es.babel.model;

import java.util.List;

public class Cuenta {
    int id;
    long numCuenta;
    Sucursal sucursal;
    int idUsuario;
    Double balance;
    List<Cuenta> cuentasAsociadas;

    public Cuenta() {
    }

    public Cuenta(int id, long numCuenta, Sucursal sucursal, int idUsuario, Double balance, List<Cuenta> cuentasAsociadas) {
        this.id = id;
        this.numCuenta = numCuenta;
        this.sucursal = sucursal;
        this.idUsuario = idUsuario;
        this.balance = balance;
        this.cuentasAsociadas = cuentasAsociadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(long numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Cuenta> getCuentasAsociadas() {
        return cuentasAsociadas;
    }

    public void setCuentasAsociadas(List<Cuenta> cuentasAsociadas) {
        this.cuentasAsociadas = cuentasAsociadas;
    }
}
