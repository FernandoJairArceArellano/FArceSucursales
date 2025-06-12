package com.Digis01.FArceSucursales.Service;

import com.Digis01.FArceSucursales.JPA.Empresa;
import com.Digis01.FArceSucursales.JPA.Result;
import com.Digis01.FArceSucursales.Repository.EmpresaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Result<Empresa> getAll() {
        Result<Empresa> result = new Result<>();
        try {
            List<Empresa> empresas = empresaRepository.findAll();
            result.correct = true;
            result.objects = empresas;
        } catch (Exception e) {
            result.correct = false;
            result.errorMessage = e.getMessage();
            result.ex = e;
        }
        return result;
    }

    public Result<Empresa> getById(Long id) {
        Result<Empresa> result = new Result<>();
        try {
            Optional<Empresa> empresa = empresaRepository.findById(id);
            if (empresa.isPresent()) {
                result.correct = true;
                result.object = empresa.get();
            } else {
                result.correct = false;
                result.errorMessage = "Empresa no encontrada";
            }
        } catch (Exception e) {
            result.correct = false;
            result.errorMessage = e.getMessage();
            result.ex = e;
        }
        return result;
    }

    public Result<Empresa> save(Empresa empresa) {
        Result<Empresa> result = new Result<>();
        try {
            Empresa saved = empresaRepository.save(empresa);
            result.correct = true;
            result.object = saved;
        } catch (Exception e) {
            result.correct = false;
            result.errorMessage = e.getMessage();
            result.ex = e;
        }
        return result;
    }

    public Result<Empresa> delete(Long id) {
        Result<Empresa> result = new Result<>();
        try {
            empresaRepository.deleteById(id);
            result.correct = true;
        } catch (Exception e) {
            result.correct = false;
            result.errorMessage = e.getMessage();
            result.ex = e;
        }
        return result;
    }
}
