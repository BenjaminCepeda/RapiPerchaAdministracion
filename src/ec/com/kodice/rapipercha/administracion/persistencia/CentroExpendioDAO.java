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
public class CentroExpendioDAO {
    /**
     * Permite crear un nuevo CentroExpendio
     *
     * @param centroExpendioVO POJO con los atributos de CentroExpendio
     * @return Codigo del registro creado
     * @throws Exception
     */
    public int crear(CentroExpendioVO centroExpendioVO) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int codigoGenerado = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "INSERT INTO TCENTRO_EXPENDIO"
                    + "(cen_ruc, cen_razon_social, cen_nombre_comercial) "
                    + "VALUES (?, ?, ?)";
            sentencia = conexion.prepareStatement(consulta,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, centroExpendioVO.getRuc());
            sentencia.setString(2, centroExpendioVO.getRazonSocial());
            sentencia.setString(3, centroExpendioVO.getNombreComercial());
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
     * Permite leer un CentroExpendio en base de su codigo
     *
     * @param codigo Codigo del registro a ser leído
     * @return POJO con los atributos de CentroExpendio
     * @throws Exception
     */
    public CentroExpendioVO buscar(int codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        CentroExpendioVO centroExpendioVO = null;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT cen_codigo, cen_ruc, cen_razon_social, "
                    + "cen_nombre_comercial "
                    + "FROM TCENTRO_EXPENDIO WHERE cen_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigo);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                centroExpendioVO = new CentroExpendioVO(codigo,
                        resultado.getString("cen_ruc"),
                        resultado.getString("cen_razon_social"),
                        resultado.getString("cen_nombre_comercial"));
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
        return (centroExpendioVO);
    }

    /**
     * Devuelve el listado de CentroExpendio
     *
     * @return Lista de CentroExpendio
     * @throws Exception
     */
    public List<CentroExpendioVO> buscarTodos() throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        List<CentroExpendioVO> listaElementos = null;
        CentroExpendioVO centroExpendioVO = null;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT cen_codigo, cen_ruc, cen_razon_social, "
                    + "cen_nombre_comercial "
                    + "FROM TCENTRO_EXPENDIO ";
            sentencia = conexion.prepareStatement(consulta);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (listaElementos == null) {
                    listaElementos = new ArrayList<CentroExpendioVO>();
                }
                centroExpendioVO = new CentroExpendioVO(
                        resultado.getInt("cen_codigo"),
                        resultado.getString("cen_ruc"),
                        resultado.getString("cen_razon_social"),
                        resultado.getString("cen_nombre_comercial"));
                listaElementos.add(centroExpendioVO);
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
     * Permite actualizar un registro de CentroExpendio
     *
     * @param centroExpendioVO POJO con los atributos de CentroExpendio
     * @return Numero de registros actualizados
     * @throws Exception
     */
    public int actualizar(CentroExpendioVO centroExpendioVO) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int filasAfectadas = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "UPDATE TCENTRO_EXPENDIO "
                    + "SET cen_ruc = ?, "
                    + "cen_razon_social = ?, "
                    + "cen_nombre_comercial = ? "
                    + "WHERE cen_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, centroExpendioVO.getRuc());
            sentencia.setString(2, centroExpendioVO.getRazonSocial());
            sentencia.setString(3, centroExpendioVO.getNombreComercial());
            sentencia.setInt(4, centroExpendioVO.getCodigo());
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
     * Permte eliminar una instancia de CentroExpendio
     *
     * @param codigo Codigo del CentroExpendio a eliminar
     * @return Numero de registros eliminados
     * @throws Exception
     */
    public int eliminar(int codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int filasAfectadas = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "DELETE FROM TCENTRO_EXPENDIO "
                    + "WHERE cen_codigo = ?";
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
