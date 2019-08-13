package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Sucursal;


public class SucursalImpl extends Conexion implements ICRUD<Sucursal>{

    @Override
    public void registrar(Sucursal sucursal) throws Exception {
        try {
            conectar();
            String sql = "insert into SUCURSAL (NOMSUC,SEDSUC) values (?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, sucursal.getNOMSUC());
            ps.setString(2, sucursal.getSEDSUC());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar" + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Sucursal sucursal) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE SUCURSAL SET NOMSUC=?,SEDSUC=? WHERE CODSUC=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, sucursal.getNOMSUC());
            ps.setString(2, sucursal.getSEDSUC());
            ps.setInt(3, sucursal.getCODSUC());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("error en actualizar" + e.getMessage());
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Sucursal sucursal) throws Exception {
        try {
            this.conectar();
            String sql = "delete from SUCURSAL where CODSUC= ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, sucursal.getCODSUC());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Sucursal> listar() throws Exception {
        List<Sucursal> listado;
        ResultSet rs;
        try {
            conectar();
            String sql = "SELECT * FROM SUCURSAL";
            listado = new ArrayList();
            Statement st = this.getCn().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Sucursal suc = new Sucursal();
                suc.setCODSUC(rs.getInt("CODSUC"));
                suc.setNOMSUC(rs.getString("NOMSUC"));
                suc.setSEDSUC(rs.getString("SEDSUC"));
                listado.add(suc);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listado;
    }
    
}
