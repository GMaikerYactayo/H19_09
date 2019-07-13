package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;

public class PersonaImpl extends Conexion implements ICRUD<Persona> {

    @Override
    public void registrar(Persona persona) throws Exception {
        this.conectar();
        try {
            String sql = "";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(0, sql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Persona gen) throws Exception {
        this.conectar();
        try {
            String sql = "";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(0, sql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Persona gen) throws Exception {
        this.conectar();
        try {
            String sql = "";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(0, sql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Persona> listar() throws Exception {
        Persona persona;
        List<Persona> listado;
        try {
            this.conectar();
            listado = new ArrayList();
            String sql = "select * from PERSONA";
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                persona = new Persona();
                persona.setCODPER(rs.getString("CODPER"));
                persona.setNOMPER(rs.getString("NOMPER"));
                persona.setAPEPER(rs.getString("APEPER"));
                persona.setDNIPER(rs.getString("DNIPER"));
                persona.setTIPPER(rs.getString("TIPPER"));
                persona.setDIRPER(rs.getString("DIRPER"));
                persona.setESTPER(rs.getString("ESTPER"));
                persona.setCODUBI(rs.getString("CODUBI"));
                listado.add(persona);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return listado;
    }

}
