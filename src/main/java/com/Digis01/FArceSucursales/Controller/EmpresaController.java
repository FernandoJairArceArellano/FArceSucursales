package com.Digis01.FArceSucursales.Controller;

import com.Digis01.FArceSucursales.JPA.Empresa;
import com.Digis01.FArceSucursales.JPA.Result;
import com.Digis01.FArceSucursales.Service.EmpresaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public String listEmpresas(Model model) {
        Result<Empresa> result = empresaService.getAll();
        model.addAttribute("empresas", result.objects);
        return "empresas";
    }

    @GetMapping("/form")
    public String formEmpresa(@RequestParam(value = "id", required = false) Long id, Model model) {
        Empresa empresa = (id != null) ? empresaService.getById(id).object : new Empresa();
        model.addAttribute("empresa", empresa);
        return "empresa-form";
    }

    @PostMapping("/save")
    public String saveEmpresa(@ModelAttribute Empresa empresa) {
        empresaService.save(empresa);
        return "redirect:/empresas";
    }

    @GetMapping("/delete")
    public String deleteEmpresa(@RequestParam("id") Long id) {
        empresaService.delete(id);
        return "redirect:/empresas";
    }
}
