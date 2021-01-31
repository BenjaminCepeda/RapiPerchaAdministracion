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
 * @author Miguel
 */
public class CentrodeExpendioDAO {
    
    public int crear(CentroExpendioVO centroexpendioVO) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int codigoGenerado = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "INSERT INTO `tcentro_expendio` (`CEN_CODIGO`, `CEN_RUC`, "
                    + "`CEN_RAZON_SOCIAL`, `CEN_NOMBRE_COMERCIAL`) "
                    + "VALUES (NULL,?,?,?);";
            sentencia = conexion.prepareStatement(consulta,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, centroexpendioVO.getRuc());
            sentencia.setString(2, centroexpendioVO.getRazonSocial());
            sentencia.setString(3, centroexpendioVO.getNombreComercial());
            
            sentencia.executeUpdate();
            ResultSet resultado = sentencia.getGeneratedKeys();
            while (resultado.next()) {
                codigoGenerado = resultado.getInt(1);
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
        return (codigoGenerado);
    }
    
    /**
     * Permite leer un Perfil en base de su codigo
     * @param codigo Codigo del registro a ser leído
     * @return POJO con los atributos de Perfil
     * @throws Exception 
     */
    public CentroExpendioVO buscar(int codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        CentroExpendioVO centroexpendioVO = null;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT *  "
                    + "FROM TCENTRO_EXPENDIO WHERE CEN_CODIGO = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigo);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                centroexpendioVO = new CentroExpendioVO(codigo,
                        resultado.getString("CEN_RUC"),
                        resultado.getString("CEN_RAZON_SOCIAL"),
                        resultado.getString("CEN_NOMBRE_COMERCIAL"));
                        
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
        return (centroexpendioVO);
    }

   /**
     * Devuelve el  listado  de Centro de Expendio
     * @return Lista de Perfiles
     * @throws Exception 
     */
    public List<CentroExpendioVO> BuscarTodos() throws Exception{
        Connection conexion=null;
        PreparedStatement sentencia = null;
        List<CentroExpendioVO> listaElementos=null;
        CentroExpendioVO centroexpendioVO = null;
        try{
            conexion = CustomConnection.getConnection();
            String consulta="SELECT * "
                    + "FROM TCENTRO_EXPENDIO ";
            sentencia = conexion.prepareStatement(consulta);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                if (listaElementos== null) listaElementos = new ArrayList<CentroExpendioVO>();
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
                    + "]");
        }    
        finally{
            try {
                conexion.close();
            } catch (SQLException e){
                throw new Exception(e.getMessage() + "\n[" 
                        + this.getClass().getName() + "]");
            }
        }        
        return (listaElementos);
    }
    
    /**
     * Permite actualizar una registro de Perfil
     * @param perfilVO POJO con los atributos de Perfil
     * @return Numero de registros actualizados 
     * @throws Exception 
     */
    public int actualizar(CentroExpendioVO centroexpendioVO) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int filasAfectadas = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "UPDATE `tcentro_expendio` SET `CEN_RUC` = ?, "
                    + "`CEN_RAZON_SOCIAL` = ?, "
                    + "`CEN_NOMBRE_COMERCIAL` = ? "
                    + "WHERE `tcentro_expendio`.`CEN_CODIGO` = ?; ";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, centroexpendioVO.getRuc());
            sentencia.setString(2, centroexpendioVO.getRazonSocial());
            sentencia.setString(3, centroexpendioVO.getNombreComercial());
            sentencia.setInt(4, centroexpendioVO.getCodigo());;
            filasAfectadas = sentencia.executeUpdate();
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
        return (filasAfectadas);
    }
     public int eliminar(int codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int filasAfectadas = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "DELETE FROM TCENTRO_EXPENDIO "
                    + "WHERE CEN_CODIGO = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigo);
            filasAfectadas = sentencia.executeUpdate();
            conexion.close();
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
        return (filasAfectadas);

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