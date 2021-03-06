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
 * Esta clase permite el acceso a datos de un Usuario
 *
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/06
 */
public class UsuarioDAO {

    /**
     * Permite crear un nuevo Usuario
     *
     * @param usuarioVO POJO con los atributos de Usuario
     * @return Codigo del registro creado
     * @throws Exception
     */
    public int crear(UsuarioVO usuarioVO) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int codigoGenerado = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "INSERT INTO TUSUARIOS "
                    + "(per_codigo, usu_nombre, usu_clave, usu_estado)"
                    + "VALUES (?,?,?,?)";
            sentencia = conexion.prepareStatement(consulta,
                    PreparedStatement.RETURN_GENERATED_KEYS);            
            sentencia.setInt(1, usuarioVO.getPerfil().getCodigo());
            sentencia.setString(2, usuarioVO.getNombre());
            sentencia.setString(3, usuarioVO.getClave());
            sentencia.setString(4, usuarioVO.getEstado());
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
     * Permite leer un Usuario en base de su codigo
     *
     * @param codigo Codigo del registro a ser leído
     * @return POJO con los atributos de Usuario
     * @throws Exception
     */
    public UsuarioVO buscar(int codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        UsuarioVO usuarioVO = null;
        PerfilVO perfilVO = null;
        PerfilDAO perfilDAO = new PerfilDAO();
                
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT usu_codigo, per_codigo,  "
                    + "usu_nombre, usu_clave, usu_estado "
                    + "FROM TUSUARIOS  WHERE usu_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigo);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                usuarioVO = new UsuarioVO(
                        resultado.getInt("usu_codigo"),
                        resultado.getString("usu_nombre"),
                        resultado.getString("usu_clave"),
                        resultado.getString("usu_estado"));
                perfilVO = perfilDAO.buscar(resultado.getInt("per_codigo"));
                usuarioVO.setPerfil(perfilVO);
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
        return usuarioVO;
    }

    /**
     * Devuelve el listado de Usuarios
     *
     * @return Lista de usuarios
     * @throws Exception
     */
    public List<UsuarioVO> buscarTodos() throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        List<UsuarioVO> listaElementos = null;
        UsuarioVO usuarioVO = null;
        PerfilVO perfilVO = null;
        PerfilDAO perfilDAO= new PerfilDAO();
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT usu_codigo, per_codigo, usu_nombre, "
                    + "usu_clave, usu_estado "
                    + "FROM TUSUARIOS ";
            sentencia = conexion.prepareStatement(consulta);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (listaElementos == null) {
                    listaElementos
                            = new ArrayList<UsuarioVO>();
                }
                usuarioVO = new UsuarioVO(
                        resultado.getInt("usu_codigo"),
                        resultado.getString("usu_nombre"),
                        resultado.getString("usu_clave"),
                        resultado.getString("usu_estado"));
                perfilVO = perfilDAO.buscar(resultado.getInt("per_codigo"));
                usuarioVO.setPerfil(perfilVO);
                listaElementos.add(usuarioVO);
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
     * Permite actualizar una registro de Usuario
     *
     * @param usuarioVO POJO con los atributos de Usuario
     * @return Numero de registros actualizados
     * @throws Exception
     */
    public int actualizar(UsuarioVO usuarioVO) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        conexion = null;
        int filasAfectadas = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "UPDATE TUSUARIOS "
                    + "SET  per_codigo = ?, "
                    + "usu_nombre = ?, "
                    + "usu_clave = ?, "
                    + "usu_estado = ? "
                    + "WHERE usu_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, usuarioVO.getPerfil().getCodigo());
            sentencia.setString(2, usuarioVO.getNombre());
            sentencia.setString(3, usuarioVO.getClave());
            sentencia.setString(4, usuarioVO.getEstado());
            sentencia.setInt(5, usuarioVO.getCodigo());
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
     * Permte eliminar un registro de Usuario
     *
     * @param codigo Codigo del Usuario a eliminar
     * @return Numero de registros eliminados
     * @throws Exception
     */
    public int eliminar(int codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int filasAfectadas = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "DELETE FROM TUSUARIOS "
                    + "WHERE usu_codigo = ?";
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

    /**
     * Permite actualizar la clave de un Usuario
     *
     * @param usuarioVO POJO con los atributos de Usuario
     * @return Numero de registros actualizados
     * @throws Exception
     */
    public int cambiarClave(int codigo, String nuevaClave) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        conexion = null;
        int filasAfectadas = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "UPDATE TUSUARIOS " +
                    "SET  usu_clave = ? "
                    + "WHERE usu_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nuevaClave);
            sentencia.setInt(2, codigo);
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
     * Permite actualizar la clave de un Usuario
     *
     * @param usuarioVO POJO con los atributos de Usuario
     * @return Numero de registros actualizados
     * @throws Exception
     */
    public int validaCredenciales(String nombreUsuario, String clave) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        conexion = null;
        int codigoEmpleado = 0;
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT E.emp_codigo  FROM TUSUARIOS U "                     
                    + "INNER JOIN TEMPLEADOS E ON "
                    + "U.usu_codigo = E.usu_codigo "
                    + "WHERE (IFNULL(E.emp_correo,'')= ? or usu_nombre = ?) "
                    + "AND usu_clave = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nombreUsuario);
            sentencia.setString(2, nombreUsuario);
            sentencia.setString(3, clave);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                codigoEmpleado = resultado.getInt("emp_codigo");
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
        return (codigoEmpleado);
    }

}
