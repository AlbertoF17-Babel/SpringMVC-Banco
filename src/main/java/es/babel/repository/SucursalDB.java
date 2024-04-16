package es.babel.repository;

import es.babel.model.Sucursal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SucursalDB implements ISucursalDB {
    private final List<Sucursal> sucursalRepository = new ArrayList<>();



    @Override
    public List<Sucursal> listarSucursales() {
        return sucursalRepository;
    }

    @Override
    public void agregarSucursal(Sucursal sucursal) {
        if (!sucursalRepository.isEmpty()) {
            int idUltimaSucursal = sucursalRepository.get(sucursalRepository.size()-1).getId();
            sucursal.setId(idUltimaSucursal+1);
        } else {
            sucursal.setId(1);
        }
        sucursalRepository.add(sucursal);
    }

    @Override
    public void borrarSucursal(int id) {
        try {
            Sucursal sucursalABorrar = buscarSucursal(id);
            sucursalRepository.remove(sucursalABorrar);
        } catch (Error e) {
            System.out.println("No hay sucursal que borrar");
        }
    }

    @Override
    public Sucursal buscarSucursal(int id) {
        Sucursal sucursal = null;
        for (Sucursal s : sucursalRepository) {
            if (id == s.getId()) {
                sucursal = s;
                break;
            }
        }
        return sucursal;
    }


}
