package com.Digis01.FArceSucursales.DAO;

import com.Digis01.FArceSucursales.JPA.Empresa;
import com.Digis01.FArceSucursales.JPA.Result;

public interface IEmpresaDAO {

    Result GetAllEmpresa();

    Result AddEmpresa(Empresa empresa);

    Result GetById(int IdEmpresa);

    Result GetAllSucursales();

}
