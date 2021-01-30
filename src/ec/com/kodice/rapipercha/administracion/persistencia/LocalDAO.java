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
 * @author chica
 */
public class LocalDAO {
    /**
     * Permite crear un nuevo Local
     *
     * @param localVO POJO con los atributos de Local
     * @return Codigo del registro creado
     * @throws Exception
     */
    public int crear(LocalVO localVO) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int codigoGenerado = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "INSERT INTO TLOCALES"
                    + "(cen_codigo, loc_nombre, loc_direccion) "
                    + "VALUES (?, ?, ?)";
            sentencia = conexion.prepareStatement(consulta,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setInt(1, localVO.getCentroExpendioVO().getCodigo());
            sentencia.setString(2, localVO.getNombre());
            sentencia.setString(3, localVO.getDireccion());
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
     * Permite leer un Local en base de su codigo
     *
     * @param codigo Codigo del registro a ser leído
     * @return POJO con los atributos de Proveedor
     * @throws Exception
     */
    public LocalVO buscar(int codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        LocalVO localVO = null;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT loc_codigo, cen_codigo, loc_nombre, "
                    + "loc_direccion "
                    + "FROM TLOCALES WHERE loc_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigo);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                localVO = new LocalVO(codigo,
                        resultado.getInt("cen_codigo"),
                        resultado.getString("loc_nombre"),
                        resultado.getString("loc_direccion"));
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
        return (localVO);
    }

    /**
     * Devuelve el listado de Locales
     *
     * @return Lista de Locales
     * @throws Exception
     */
    public List<LocalVO> buscarTodos() throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        List<LocalVO> listaElementos = null;
        LocalVO localVO = null;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT loc_codigo, cen_codigo, loc_nombre, "
                    + "loc_direccion "
                    + "FROM TLOCALES ";
            sentencia = conexion.prepareStatement(consulta);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (listaElementos == null) {
                    listaElementos = new ArrayList<LocalVO>();
                }
                localVO = new LocalVO(
                        resultado.getInt("loc_codigo"),
                        resultado.getInt("cen_codigo"),
                        resultado.getString("loc_nombre"),
                        resultado.getString("loc_direccion"));
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

    /**
     * Permite actualizar un registro de Local
     *
     * @param localVO POJO con los atributos de Local
     * @return Numero de registros actualizados
     * @throws Exception
     */
    public int actualizar(LocalVO localVO) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int filasAfectadas = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "UPDATE TLOCALES "
                    + "SET cen_codigo = ?, "
                    + "loc_nombre = ?, "
                    + "loc_direccion = ? "
                    + "WHERE loc_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, localVO.getCentroExpendioVO().getCodigo());
            sentencia.setString(2, localVO.getNombre());
            sentencia.setString(3, localVO.getDireccion());
            sentencia.setInt(4, localVO.getCodigo());
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

    /**
     * Permte eliminar una instancia de Local
     *
     * @param codigo Codigo del Local a eliminar
     * @return Numero de registros eliminados
     * @throws Exception
     */
    public int eliminar(int codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int filasAfectadas = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "DELETE FROM TLOCALES "
                    + "WHERE loc_codigo = ?";
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
}
