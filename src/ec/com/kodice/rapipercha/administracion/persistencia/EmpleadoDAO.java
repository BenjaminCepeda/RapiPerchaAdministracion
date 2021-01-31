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
public class EmpleadoDAO {

    /**
     * Permite crear un nuevo Usuario
     *
     * @param empleadoVO POJO con los atributos de Empleado
     * @return Codigo del registro creado
     * @throws Exception
     */
    public int crear(EmpleadoVO empleadoVO) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int codigoGenerado = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "INSERT INTO TEMPLEADOS "
                    + "(prov_codigo, usu_codigo, emp_cedula, emp_nombres, "
                    + "emp_apellidos, emp_telefono, emp_correo)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            sentencia = conexion.prepareStatement(consulta,
                    PreparedStatement.RETURN_GENERATED_KEYS);            
            sentencia.setInt(1, empleadoVO.getProveedorCodigo());
            sentencia.setInt(2, empleadoVO.getUsuario().getCodigo());
            sentencia.setString(3, empleadoVO.getCedula());
            sentencia.setString(4, empleadoVO.getNombres());
            sentencia.setString(5, empleadoVO.getApellidos());
            sentencia.setString(6, empleadoVO.getTelefono());
            sentencia.setString(7, empleadoVO.getCorreo());
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
     * Permite leer un Empleado en base de su codigo
     *
     * @param codigo Codigo del registro a ser leído
     * @return POJO con los atributos de Empleado
     * @throws Exception
     */
    public EmpleadoVO buscar(int codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        EmpleadoVO empleadoVO = null;
        UsuarioVO usuarioVO = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
                
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT emp_codigo, prov_codigo, usu_codigo, "
                    + "emp_cedula, emp_nombres, emp_apellidos, emp_telefono, "
                    + "emp_correo  "
                    + "FROM TEMPLEADOS  WHERE emp_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigo);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                empleadoVO = new EmpleadoVO(
                        resultado.getInt("emp_codigo"),
                        resultado.getInt("prov_codigo"),
                        resultado.getInt("usu_codigo"),
                        resultado.getString("emp_cedula"),
                        resultado.getString("emp_nombres"),
                        resultado.getString("emp_apellidos"),
                        resultado.getString("emp_telefono"),
                        resultado.getString("emp_correo"));
                if (empleadoVO.getUsuario()!=null && 
                        empleadoVO.getUsuario().getCodigo()>0)
                    usuarioVO = usuarioDAO.buscar(
                            empleadoVO.getUsuario().getCodigo());
                empleadoVO.setUsuario(usuarioVO);
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
        return empleadoVO;
    }

    /**
     * Devuelve el listado de Empleados
     *
     * @return Lista de empleados
     * @throws Exception
     */
    public List<EmpleadoVO> buscarTodos() throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        List<EmpleadoVO> listaElementos = null;
        EmpleadoVO empleadoVO = null;
        UsuarioVO usuarioVO = null;
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT emp_codigo, prov_codigo, usu_codigo, "
                    + "emp_cedula, emp_nombres, emp_apellidos, emp_telefono, "
                    + "emp_correo  "
                    + "FROM TEMPLEADOS  ";
            sentencia = conexion.prepareStatement(consulta);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (listaElementos == null) {
                    listaElementos
                            = new ArrayList<EmpleadoVO>();
                }
                empleadoVO = new EmpleadoVO(
                        resultado.getInt("emp_codigo"),
                        resultado.getInt("prov_codigo"),
                        resultado.getInt("usu_codigo"),
                        resultado.getString("emp_cedula"),
                        resultado.getString("emp_nombres"),
                        resultado.getString("emp_apellidos"),
                        resultado.getString("emp_telefono"),
                        resultado.getString("emp_correo"));
                if (empleadoVO.getUsuario()!=null && 
                        empleadoVO.getUsuario().getCodigo()>0)
                    usuarioVO = usuarioDAO.buscar(
                            empleadoVO.getUsuario().getCodigo());
                empleadoVO.setUsuario(usuarioVO);
                listaElementos.add(empleadoVO);
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
     * Permite actualizar un registro de Empleado
     *
     * @param empleadoVO POJO con los atributos de Empleado
     * @return Numero de registros actualizados
     * @throws Exception
     */
    public int actualizar(EmpleadoVO empleadoVO) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        conexion = null;
        int filasAfectadas = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "UPDATE TEMPLEADOS "
                    + "SET  prov_codigo = ?, "
                    + "usu_codigo = ?,"
                    + " emp_cedula = ?,"
                    + " emp_nombres = ?,"
                    + " emp_apellidos = ?,"
                    + " emp_telefono = ?, "
                    + "emp_correo = ?"
                    + "WHERE emp_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, empleadoVO.getProveedorCodigo());
            sentencia.setInt(2, empleadoVO.getUsuario().getCodigo());
            sentencia.setString(3, empleadoVO.getCedula());
            sentencia.setString(4, empleadoVO.getNombres());
            sentencia.setString(5, empleadoVO.getApellidos());
            sentencia.setString(6, empleadoVO.getTelefono());
            sentencia.setString(7, empleadoVO.getCorreo());
            sentencia.setInt(8, empleadoVO.getCodigo());
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
     * Permte eliminar un registro de Empleado
     *
     * @param codigo Codigo del Empleado a eliminar
     * @return Numero de registros eliminados
     * @throws Exception
     */
    public int eliminar(int codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int filasAfectadas = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "DELETE FROM TEMPLEADOS "
                    + "WHERE emp_codigo = ?";
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
    
    public List<EmpleadoVO> buscarPorProveedor(int codigoProveedor) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        List<EmpleadoVO> listaElementos = null;
        EmpleadoVO empleadoVO = null;
        UsuarioVO usuarioVO = null;
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT emp_codigo, prov_codigo, usu_codigo, "
                    + "emp_cedula, emp_nombres, emp_apellidos, emp_telefono, "
                    + "emp_correo  "
                    + "FROM TEMPLEADOS  "
                    + "WHERE prov_codigo = ? ";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigoProveedor);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (listaElementos == null) {
                    listaElementos
                            = new ArrayList<EmpleadoVO>();
                }
                empleadoVO = new EmpleadoVO(
                        resultado.getInt("emp_codigo"),
                        resultado.getInt("prov_codigo"),
                        resultado.getInt("usu_codigo"),
                        resultado.getString("emp_cedula"),
                        resultado.getString("emp_nombres"),
                        resultado.getString("emp_apellidos"),
                        resultado.getString("emp_telefono"),
                        resultado.getString("emp_correo"));
                if (empleadoVO.getUsuario()!=null && 
                        empleadoVO.getUsuario().getCodigo()>0)
                    usuarioVO = usuarioDAO.buscar(
                            empleadoVO.getUsuario().getCodigo());
                empleadoVO.setUsuario(usuarioVO);
                listaElementos.add(empleadoVO);
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
