package controlador;

import dao.PersonaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Persona;

@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {

    private Persona persona= new Persona();
    private List<Persona> listadoPer;
    
    public PersonaC() {
        listadoPer = new ArrayList();
    }
    
    @PostConstruct
    public void iniciar(){
        try {
            
        } catch (Exception e) {
        }
    }
    
    public void registrar() throws Exception{
        PersonaImpl dao;
        try {
            dao = new PersonaImpl();
            dao.registrar(persona);
            System.out.println("resgistradoooo :D");
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO ,"Registro" , "Correcto"));
        } catch (Exception e) {
            throw e;
        }
    }
    public void modificar() throws Exception{
        PersonaImpl dao;
        try {
            dao = new PersonaImpl();
            dao.modificar(persona);
            System.out.println("resgistradoooo :D");
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Actualización","Correcto"));
        } catch (Exception e) {
            throw e;
        }
    }
    public void eliminar() throws Exception{
        PersonaImpl dao;
        try {
            dao = new PersonaImpl();
            dao.eliminar(persona);
            System.out.println("resgistradoooo :D");
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,"Eliminado","Correcto"));
        } catch (Exception e) {
            throw e;
        }
    }
    public void limpiar() throws Exception{
        PersonaImpl dao;
        try {
            dao = new PersonaImpl();
        } catch (Exception e) {
            throw e;
        }
    }
    public void listar() throws Exception{
        PersonaImpl dao;
        try {
            dao = new PersonaImpl();
            listadoPer = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListadoPer() {
        return listadoPer;
    }

    public void setListadoPer(List<Persona> listadoPer) {
        this.listadoPer = listadoPer;
    }

    
    
}
