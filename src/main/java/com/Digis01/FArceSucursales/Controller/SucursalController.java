package com.Digis01.FArceSucursales.Controller;

import com.Digis01.FArceSucursales.JPA.Empresa;
import com.Digis01.FArceSucursales.JPA.Sucursal;
import com.Digis01.FArceSucursales.Service.EmpresaService;
import com.Digis01.FArceSucursales.Service.SucursalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;
    private final EmpresaService empresaService;

    public SucursalController(SucursalService sucursalService, EmpresaService empresaService) {
        this.sucursalService = sucursalService;
        this.empresaService = empresaService;
    }

    @GetMapping("/empresa/{idEmpresa}")
    public String listarSucursales(@PathVariable Long idEmpresa, Model model) {
        model.addAttribute("sucursales", sucursalService.getAllByEmpresa(idEmpresa).objects);
        model.addAttribute("empresaId", idEmpresa);
        return "sucursales";
    }

    @GetMapping("/form/{idEmpresa}")
    public String formularioSucursal(@PathVariable Long idEmpresa, Model model) {
        Sucursal sucursal = new Sucursal();
        Empresa empresa = empresaService.getById(idEmpresa).object;
        sucursal.setEmpresa(empresa);
        model.addAttribute("sucursal", sucursal);
        return "sucursal-form";
    }

    @PostMapping("/save")
    public String guardarSucursal(@ModelAttribute Sucursal sucursal) {
        sucursalService.save(sucursal);
        return "redirect:/sucursales/empresa/" + sucursal.getEmpresa().getIdEmpresa();
    }
}
