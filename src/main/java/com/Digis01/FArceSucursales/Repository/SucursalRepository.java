package com.Digis01.FArceSucursales.Repository;

import com.Digis01.FArceSucursales.JPA.Sucursal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

    List<Sucursal> findByEmpresaIdEmpresa(Long idEmpresa);
}
