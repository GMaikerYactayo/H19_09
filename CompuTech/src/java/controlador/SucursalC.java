package controlador;

import dao.SucursalImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Sucursal;

@Named(value = "sucursalC")
@SessionScoped
public class SucursalC implements Serializable {

    private Sucursal sucursal = new Sucursal();
    private Sucursal select;
    private List<Sucursal> listadoSuc;
    private List<Sucursal> listadoSuc2;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void registrar() throws Exception {
        SucursalImpl dao;
        try {
            dao = new SucursalImpl();
            dao.registrar(sucursal);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado..."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        SucursalImpl dao;
        try {
            dao = new SucursalImpl();
            dao.modificar(select);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización", "Completado.."));
        } catch (SQLException e) {
            throw e;
        }
    }


    public void eliminar() throws Exception {
        SucursalImpl dao;
        try {
            dao = new SucursalImpl();
            dao.eliminar(select);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminación", "Completado.."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        SucursalImpl dao;
        try {
            dao = new SucursalImpl();
            listadoSuc = dao.listar();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void limpiar() throws Exception {
        sucursal = new Sucursal();
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Sucursal getSelect() {
        return select;
    }

    public void setSelect(Sucursal select) {
        this.select = select;
    }

    public List<Sucursal> getListadoSuc() {
        return listadoSuc;
    }

    public void setListadoSuc(List<Sucursal> listadoSuc) {
        this.listadoSuc = listadoSuc;
    }

    public List<Sucursal> getListadoSuc2() {
        return listadoSuc2;
    }

    public void setListadoSuc2(List<Sucursal> listadoSuc2) {
        this.listadoSuc2 = listadoSuc2;
    }
    
    
    
}
