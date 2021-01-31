/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.kodice.rapipercha.administracion.persistencia;

import ec.com.kodice.connection.CustomConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeffo
 */
public class CentrodeExpendioDAO {
    
    public List<CentroExpendioVO>  buscarCentroExpendioporProveedor(int codigo) throws Exception{
       Connection conexion = null;
        PreparedStatement sentencia = null;
        List<CentroExpendioVO> listaElementos = null;
        CentroExpendioVO centroexpendioVO = null;
        UsuarioVO usuarioVO = null;
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT tcentro_expendio.`CEN_CODIGO`,`CEN_RUC`,`CEN_RAZON_SOCIAL`,`CEN_NOMBRE_COMERCIAL` " +
            "FROM `tcentro_expendio` " +
            "INNER JOIN rconvenio r ON tcentro_expendio.CEN_CODIGO=r.CEN_CODIGO " +
            "WHERE r.PROV_CODIGO= ?  ";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigo);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (listaElementos == null) {
                    listaElementos
                            = new ArrayList<CentroExpendioVO>();
                }
                centroexpendioVO = new CentroExpendioVO(
                        resultado.getInt("CEN_CODIGO"),
                        resultado.getString("CEN_RUC"),
                        resultado.getString("CEN_RAZON_SOCIAL"),
                        resultado.getString("CEN_NOMBRE_COMERCIAL"));
                listaElementos.add(centroexpendioVO);
            }
        } 
        catch(Exception e){
            conexion.close();
            throw new Exception(e.getMessage() + "\n[" + this.getClass().getName()
                    + "] ");
        }    
        finally{
            try {
                conexion.close();
            } catch (SQLException e){
                throw new Exception(e.getMessage() + "\n[" 
                        + this.getClass().getName() + "] ");
            }
        }        
        return (listaElementos);
    
}
    
    
    public List<CentroExpendioVO>  buscarCentroExpendioDesdeLocal(int codigoCentroExpendio) throws Exception{
       Connection conexion = null;
        PreparedStatement sentencia = null;
        List<CentroExpendioVO> listaElementos = null;
        CentroExpendioVO centroexpendioVO = null;
        UsuarioVO usuarioVO = null;
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT * FROM `tcentro_expendio`" +
            "WHERE CEN_CODIGO=?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigoCentroExpendio);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (listaElementos == null) {
                    listaElementos
                            = new ArrayList<CentroExpendioVO>();
                }
                centroexpendioVO = new CentroExpendioVO(
                        resultado.getInt("CEN_CODIGO"),
                        resultado.getString("CEN_RUC"),
                        resultado.getString("CEN_RAZON_SOCIAL"),
                        resultado.getString("CEN_NOMBRE_COMERCIAL"));
                listaElementos.add(centroexpendioVO);
            }
        } 
        catch(Exception e){
            conexion.close();
            throw new Exception(e.getMessage() + "\n[" + this.getClass().getName()
                    + "] ");
        }    
        finally{
            try {
                conexion.close();
            } catch (SQLException e){
                throw new Exception(e.getMessage() + "\n[" 
                        + this.getClass().getName() + "] ");
            }
        }        
        return (listaElementos);
    
}
    
}