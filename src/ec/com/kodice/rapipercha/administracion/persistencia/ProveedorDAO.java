/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.kodice.rapipercha.administracion.persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ec.com.kodice.connection.CustomConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase contiene metodos de acceso a datos de una Empresa
 *
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/03
 */
public class ProveedorDAO {

    /**
     * Permite crear un nuevo Proveedor
     *
     * @param proveedorVO POJO con los atributos de Proveedor
     * @return Codigo del registro creado
     * @throws Exception
     */
    public int crear(ProveedorVO proveedorVO) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int codigoGenerado = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "INSERT INTO TPROVEEDORES"
                    + "(prov_ruc, prov_razon_social, prov_nombre_comercial, "
                    + "prov_nombre_contacto, prov_apellido_contacto, "
                    + "prov_telefono_contacto, prov_correo_contacto) "
                    + "VALUES (?, ?, ?, ?, ?,?, ?)";
            sentencia = conexion.prepareStatement(consulta,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, proveedorVO.getRuc());
            sentencia.setString(2, proveedorVO.getRazonSocial());
            sentencia.setString(3, proveedorVO.getNombreComercial());
            sentencia.setString(4, proveedorVO.getNombreContacto());
            sentencia.setString(5, proveedorVO.getApellidoContacto());
            sentencia.setString(6, proveedorVO.getTelefonoContacto());
            sentencia.setString(7, proveedorVO.getCorreoContacto());
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
     * Permite leer un Proveedor en base de su codigo
     *
     * @param codigo Codigo del registro a ser leído
     * @return POJO con los atributos de Proveedor
     * @throws Exception
     */
    public ProveedorVO buscar(int codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ProveedorVO proveedorVO = null;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT prov_codigo, prov_ruc, prov_razon_social, "
                    + "prov_nombre_comercial, prov_nombre_contacto, "
                    + "prov_apellido_contacto, prov_telefono_contacto, "
                    + "prov_correo_contacto "
                    + "FROM TPROVEEDORES WHERE prov_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigo);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                proveedorVO = new ProveedorVO(codigo,
                        resultado.getString("prov_ruc"),
                        resultado.getString("prov_razon_social"),
                        resultado.getString("prov_nombre_comercial"),
                        resultado.getString("prov_nombre_contacto"),
                        resultado.getString("prov_apellido_contacto"),
                        resultado.getString("prov_telefono_contacto"),
                        resultado.getString("prov_correo_contacto"));
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
        return (proveedorVO);
    }

    /**
     * Devuelve el listado de Proveedores
     *
     * @return Lista de Proveedores
     * @throws Exception
     */
    public List<ProveedorVO> buscarTodos() throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        List<ProveedorVO> listaElementos = null;
        ProveedorVO proveedorVO = null;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT prov_codigo, prov_ruc, prov_razon_social, "
                    + "prov_nombre_comercial, prov_nombre_contacto, "
                    + "prov_apellido_contacto, prov_telefono_contacto, "
                    + "prov_correo_contacto "
                    + "FROM TPROVEEDORES ";
            sentencia = conexion.prepareStatement(consulta);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (listaElementos == null) {
                    listaElementos = new ArrayList<ProveedorVO>();
                }
                proveedorVO = new ProveedorVO(
                        resultado.getInt("prov_codigo"),
                        resultado.getString("prov_ruc"),
                        resultado.getString("prov_razon_social"),
                        resultado.getString("prov_nombre_comercial"),
                        resultado.getString("prov_nombre_contacto"),
                        resultado.getString("prov_apellido_contacto"),
                        resultado.getString("prov_telefono_contacto"),
                        resultado.getString("prov_correo_contacto"));
                listaElementos.add(proveedorVO);
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
     * Permite actualizar un registro de Proveedor
     *
     * @param perfilVO POJO con los atributos de Proveedor
     * @return Numero de registros actualizados
     * @throws Exception
     */
    public int actualizar(ProveedorVO proveedorVO) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int filasAfectadas = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "UPDATE TPROVEEDORES "
                    + "SET prov_ruc = ? "
                    + "SET prov_razon_social = ? "
                    + "SET prov_nombre_comercial = ? "
                    + "SET prov_nombre_contacto = ? "
                    + "SET prov_apellido_contacto = ? "
                    + "SET prov_telefono_contacto = ? "
                    + "SET prov_correo_contacto = ? "
                    + "WHERE prov_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, proveedorVO.getRuc());
            sentencia.setString(2, proveedorVO.getRazonSocial());
            sentencia.setString(3, proveedorVO.getNombreComercial());
            sentencia.setString(4, proveedorVO.getNombreContacto());
            sentencia.setString(5, proveedorVO.getApellidoContacto());
            sentencia.setString(6, proveedorVO.getTelefonoContacto());
            sentencia.setString(7, proveedorVO.getCorreoContacto());
            sentencia.setInt(8, proveedorVO.getCodigo());
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
     * Permte eliminar una instaancia de Perfil
     *
     * @param codigo Codigo del Perfil a eliminar
     * @return Numero de registros eliminados
     * @throws Exception
     */
    public int eliminar(int codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int filasAfectadas = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "DELETE FROM TPROVEEDORES "
                    + "WHERE prov_codigo = ?";
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
