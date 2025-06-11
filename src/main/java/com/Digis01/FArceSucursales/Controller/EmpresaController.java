package com.Digis01.FArceSucursales.Controller;

import com.Digis01.FArceSucursales.DAO.IEmpresaDAO;
import com.Digis01.FArceSucursales.JPA.Empresa;
import com.Digis01.FArceSucursales.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private IEmpresaDAO empresaDAO;

    @GetMapping
    public ResponseEntity<?> getAllEmpresas() {
        Result result = empresaDAO.GetAllEmpresa();
        if (result.correct) {
            return ResponseEntity.ok(result.objects);
        } else {
            return ResponseEntity.badRequest().body(result.errorMessage);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmpresaById(@PathVariable int id) {
        Result result = empresaDAO.GetById(id);
        if (result.correct) {
            return ResponseEntity.ok(result.object);
        } else {
            return ResponseEntity.badRequest().body(result.errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<?> addEmpresa(@RequestBody Empresa empresa) {
        Result result = empresaDAO.AddEmpresa(empresa);
        if (result.correct) {
            return ResponseEntity.ok("Empresa agregada correctamente.");
        } else {
            return ResponseEntity.badRequest().body(result.errorMessage);
        }
    }
}
