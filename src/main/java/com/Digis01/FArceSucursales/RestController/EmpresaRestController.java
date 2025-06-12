package com.Digis01.FArceSucursales.RestController;

import com.Digis01.FArceSucursales.DAO.EmpresaDAOImplementation;
import com.Digis01.FArceSucursales.JPA.Empresa;
import com.Digis01.FArceSucursales.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaRestController {

    @Autowired
    private EmpresaDAOImplementation empresaDAOImplementation;
    
    @GetMapping()
    public String index(Model model) {
        Result resultJPA = empresaDAOImplementation.GetAllEmpresa();
        
        Empresa empresa = new Empresa();
        
        model.addAttribute("empresas",resultJPA);
        return "Saludo usuario";
    }
}
