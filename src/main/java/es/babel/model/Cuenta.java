package es.babel.model;

import java.util.List;

public class Cuenta {
    int id;
    long numCuenta;
    int sucursal;
    int idUsuario;
    Double balance;

    public Cuenta() {
    }

    public Cuenta(int id, long numCuenta, int sucursal, int idUsuario, Double balance) {
        this.id = id;
        this.numCuenta = numCuenta;
        this.sucursal = sucursal;
        this.idUsuario = idUsuario;
        this.balance = balance;
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

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
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

}
