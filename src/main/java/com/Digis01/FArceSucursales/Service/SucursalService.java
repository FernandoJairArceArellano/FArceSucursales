package com.Digis01.FArceSucursales.Service;

import com.Digis01.FArceSucursales.JPA.Result;
import com.Digis01.FArceSucursales.JPA.Sucursal;
import com.Digis01.FArceSucursales.Repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService {

    private final SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    public Result<Sucursal> getAllByEmpresa(Long idEmpresa) {
        Result<Sucursal> result = new Result<>();
        try {
            List<Sucursal> sucursales = sucursalRepository.findByEmpresaIdEmpresa(idEmpresa);
            result.correct = true;
            result.objects = sucursales;
        } catch (Exception e) {
            result.correct = false;
            result.errorMessage = e.getMessage();
            result.ex = e;
        }
        return result;
    }

    public Result<Sucursal> save(Sucursal sucursal) {
        Result<Sucursal> result = new Result<>();
        try {
            Sucursal saved = sucursalRepository.save(sucursal);
            result.correct = true;
            result.object = saved;
        } catch (Exception e) {
            result.correct = false;
            result.errorMessage = e.getMessage();
            result.ex = e;
        }
        return result;
    }
}
