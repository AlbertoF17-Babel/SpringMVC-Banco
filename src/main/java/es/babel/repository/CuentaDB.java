package es.babel.repository;

import es.babel.model.Cliente;
import es.babel.model.Cuenta;
import es.babel.model.Sucursal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CuentaDB implements ICuentaDB {

    List<Cuenta> listaCuentas = new ArrayList<>();

    @Override
    public List<Cuenta> listarCuenta() {
        return listaCuentas;
    }

}
