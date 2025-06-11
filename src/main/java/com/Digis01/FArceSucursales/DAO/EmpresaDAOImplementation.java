package com.Digis01.FArceSucursales.DAO;

import com.Digis01.FArceSucursales.JPA.Empresa;
import com.Digis01.FArceSucursales.JPA.Result;
import com.Digis01.FArceSucursales.JPA.Sucursal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmpresaDAOImplementation implements IEmpresaDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Result GetAllEmpresa() {
        Result result = new Result();

        try {
            TypedQuery<Empresa> queryEmpresas = entityManager.createQuery("FROM Empresa", Empresa.class);
            List<Empresa> empresas = queryEmpresas.getResultList();

            result.objects = empresas;
            result.correct = true;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    @Transactional
    @Override
    public Result AddEmpresa(Empresa empresa) {
        Result result = new Result();

        try {
            entityManager.persist(empresa);
            result.correct = true;

            if (result.correct) {
                System.out.println("Se insertó una nueva empresa correctamente");
            }

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    @Override
    public Result GetById(int idEmpresa) {
        Result result = new Result();

        try {
            Empresa empresa = entityManager.find(Empresa.class, idEmpresa);

            if (empresa != null) {
                result.object = empresa;
                result.correct = true;
                System.out.println("Se encontró una Empresa");
            } else {
                result.correct = false;
                result.errorMessage = "Empresa no encontrada con Id: " + idEmpresa;
            }

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    @Override
    public Result GetAllSucursales() {
        Result result = new Result();

        try {
            TypedQuery<Sucursal> querySucursales = entityManager.createQuery("FROM Sucursal ORDER BY empresa.idEmpresa", Sucursal.class);
            List<Sucursal> sucursales = querySucursales.getResultList();

            result.objects = sucursales;
            result.correct = true;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }
}
