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
 * Esta clase permite el acceso a datos de un Empleado
 *
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/28
 */
public class LocalDAO {

 
    

    /**
     * Permite leer un Empleado en base de su codigo
     *
     * @param codigo Codigo del registro a ser leído
     * @return POJO con los atributos de Empleado
     * @throws Exception
     */
    public LocalVO buscar(int codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        LocalVO localVO = null;
        localVO=new LocalVO();
        UsuarioVO usuarioVO = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
                
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT `LOC_CODIGO`, `CEN_CODIGO`, "
                    + "`LOC_NOMBRE`, `LOC_DIRECCION` FROM `tlocales`"
                    + " WHERE `LOC_CODIGO`=?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigo);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                localVO = new LocalVO(
                        resultado.getInt("LOC_CODIGO"),
                        resultado.getInt("CEN_CODIGO"),
                        resultado.getString("LOC_NOMBRE"),
                        resultado.getString("LOC_DIRECCION"));
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
        return localVO;
    }

    /**
     * Devuelve el listado de Empleados
     *
     * @return Lista de empleados
     * @throws Exception
     */
        
    

   

    /**
     * Permte eliminar un registro de Empleado
     *
     * @param codigo Codigo del Empleado a eliminar
     * @return Numero de registros eliminados
     * @throws Exception
     */
    
    
    
      public List<LocalVO> buscaLocalporCentroExpendio(int codigoCE) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        List<LocalVO> listaElementos = null;
        LocalVO localVO = null;
        UsuarioVO usuarioVO = null;
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT `LOC_CODIGO`, `CEN_CODIGO`, "
                    + "`LOC_NOMBRE`, `LOC_DIRECCION` FROM `tlocales`"
                    + " WHERE `CEN_CODIGO`=? ";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigoCE);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (listaElementos == null) {
                    listaElementos
                            = new ArrayList<LocalVO>();
                }
                localVO = new LocalVO(
                        resultado.getInt("LOC_CODIGO"),
                        resultado.getInt("CEN_CODIGO"),
                        resultado.getString("LOC_NOMBRE"),
                        resultado.getString("LOC_DIRECCION"));
              
                listaElementos.add(localVO);
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
      
       public List<LocalVO> buscarLocalporCodigoaComboBox(int codigoLocal) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        List<LocalVO> listaElementos = null;
        LocalVO localVO = null;
        UsuarioVO usuarioVO = null;
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT `LOC_CODIGO`, `CEN_CODIGO`, "
                    + "`LOC_NOMBRE`, `LOC_DIRECCION` FROM `tlocales`"
                    + " WHERE `LOC_CODIGO`=? ";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigoLocal);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (listaElementos == null) {
                    listaElementos
                            = new ArrayList<LocalVO>();
                }
                localVO = new LocalVO(
                        resultado.getInt("LOC_CODIGO"),
                        resultado.getInt("CEN_CODIGO"),
                        resultado.getString("LOC_NOMBRE"),
                        resultado.getString("LOC_DIRECCION"));
              
                listaElementos.add(localVO);
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
