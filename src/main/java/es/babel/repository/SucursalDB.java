package es.babel.repository;

import es.babel.model.Sucursal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SucursalDB implements ISucursalDB {
    private List<Sucursal> sucursalRepository;

    @Override
    public void inicializarSucursales() {
        sucursalRepository = new ArrayList<>();
        sucursalRepository.add(new Sucursal(1, "Sucursal1", "Paco", "C/ calle1, 1"));
        sucursalRepository.add(new Sucursal(2, "Sucursal2", "Pepe", "C/ calle2, 2"));
        sucursalRepository.add(new Sucursal(3, "Sucursal3", "Antonio", "C/ calle3, 3"));
        sucursalRepository.add(new Sucursal(4, "Sucursal4", "Eustaquio", "C/ calle4, 4"));
        sucursalRepository.add(new Sucursal(5, "Sucursal5", "Alberto", "C/ calle5, 5"));
        sucursalRepository.add(new Sucursal(6, "Sucursal6", "Alexander", "C/ calle6, 6"));
        sucursalRepository.add(new Sucursal(7, "Sucursal7", "Ramón", "C/ calle7, 7"));
    }

    @Override
    public List<Sucursal> listarSucursales() {
        return sucursalRepository;
    }

    @Override
    public void agregarSucursal(Sucursal sucursal) {
        this.sucursalRepository.add(sucursal);
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
