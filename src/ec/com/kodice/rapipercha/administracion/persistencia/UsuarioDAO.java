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
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/06 
 */
public class UsuarioDAO {
    
    /**
     * Permite crear un nuevo Usuario
     * @param usuarioVO POJO con los atributos de Usuario
     * @return Codigo del registro creado 
     * @throws Exception 
     */
    public int crear(UsuarioVO usuarioVO) throws Exception{
        Connection conexion=null;
        PreparedStatement sentencia = null;
        int codigoGenerado=0;
        try{
            conexion = CustomConnection.getConnection();
            String consulta="INSERT INTO TUSUARIOS "
                    + "(usu_nombre, usu_clave, usu_estado)"
                    + "VALUES (?,?,?)";
            sentencia = conexion.prepareStatement(consulta,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, usuarioVO.getNombre());
            sentencia.setString(2, usuarioVO.getClave());
            sentencia.setString(3, usuarioVO.getEstado());
            sentencia.executeUpdate();
            ResultSet resultado = sentencia.getGeneratedKeys();
            while(resultado.next()){
               codigoGenerado = resultado.getInt(1);
            }            
        } 
        catch(Exception e){
            if (sentencia!=null) sentencia.close();
            if (conexion!=null) conexion.close();
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        }
        finally{
            try {
                if (sentencia!=null) sentencia.close();
                if (conexion!=null) conexion.close();
            } catch (SQLException e){throw new Exception("[" +
                    this.getClass().getName()+"] "+ e.getMessage());}
        }
        return (codigoGenerado);
    }
    
    /**
     * Permite leer un Usuario en base de su codigo
     * @param codigo Codigo del registro a ser leído
     * @return POJO con los atributos de Usuario
     * @throws Exception 
     */
    public UsuarioVO buscar(int codigo) throws Exception{
        Connection conexion=null;
        PreparedStatement sentencia = null;
        UsuarioVO usuarioVO = null;
        try{
            conexion = CustomConnection.getConnection();
            String consulta="SELECT usu_codigo, usu_nombre, usu_clave, "
                    + "usu_estado "
                    + "FROM TUSUSARIOS  WHERE usu_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigo);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
               usuarioVO = new UsuarioVO(codigo, 
                       resultado.getString("usu_nombre"),
                       resultado.getString("usu_clave"),
                       resultado.getString("usu_estado"));
            }      
        } 
        catch(Exception e){
            if (sentencia!=null) sentencia.close();
            if (conexion!=null) conexion.close();
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        } 
        finally{
            try {
                if (sentencia!=null) sentencia.close();
                if (conexion!=null) conexion.close();
            } catch (SQLException e){throw new Exception("[" +
                    this.getClass().getName()+"] "+ e.getMessage());}
        }        
        return usuarioVO;
    }

   /**
     * Devuelve el  listado  de Usuarios
     * @return Lista de usuarios
     * @throws Exception 
     */
    public List<UsuarioVO> buscarTodos() throws Exception{
        Connection conexion=null;
        PreparedStatement sentencia = null;
        List<UsuarioVO> listaElementos=null;
        UsuarioVO usuarioVO = null;
        try{
            conexion = CustomConnection.getConnection();
            String consulta="SELECT usu_codigo, usu_nombre "
                    +"usu_clave, usu_estado"
                    + "FROM TPERFILES ";
            sentencia = conexion.prepareStatement(consulta);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                if (listaElementos== null) listaElementos = 
                        new ArrayList<UsuarioVO>();
               usuarioVO = new UsuarioVO(
                       resultado.getInt("usu_codigo"),
                       resultado.getString("usu_nombre"),
                       resultado.getString("usu_clave"),
                       resultado.getString("usu_estado"));
               listaElementos.add(usuarioVO);
            }      
        } 
        catch(Exception e){
            if (sentencia!=null) sentencia.close();
            if (conexion!=null) conexion.close();
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        } 
        
        finally{
            try {
                if (sentencia!=null) sentencia.close();
                if (conexion!=null) conexion.close();
            } catch (SQLException e){throw new Exception("[" +
                    this.getClass().getName()+"] "+ e.getMessage());}
        }        return (listaElementos);
    }
    
    /**
     * Permite actualizar una registro de Perfil
     * @param perfilVO POJO con los atributos de Perfil
     * @return Numero de registros actualizados 
     * @throws Exception 
     */
    public int actualizar(UsuarioVO usuarioVO) throws Exception{
        Connection conexion=null;
        PreparedStatement sentencia = null;
        conexion=null;
        int filasAfectadas=0;
        try{
            conexion = CustomConnection.getConnection();
            String consulta = "SET  "
                    + "usu_clave = ? "
                    + "usu_estado = ? "
                    + "UPDATE TUSUARIOS "
                    + "WHERE usu_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, usuarioVO.getClave());
            sentencia.setString(2, usuarioVO.getEstado());
            sentencia.setInt(3, usuarioVO.getCodigo());
            filasAfectadas = sentencia.executeUpdate();
        }
        catch(Exception e){
            if (sentencia!=null) sentencia.close();
            if (conexion!=null) conexion.close();
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        }
        finally{
            try {
                if (sentencia!=null) sentencia.close();
                if (conexion!=null) conexion.close();
            } catch (SQLException e){throw new Exception("[" +
                    this.getClass().getName()+"] "+ e.getMessage());}
        }        return (filasAfectadas);
    }
    
    /**
     * Permte eliminar un registro de Usuario
     * @param codigo Codigo del Usuario a eliminar
     * @return Numero de registros eliminados
     * @throws Exception 
     */
    public int eliminar(int codigo) throws Exception{
        Connection conexion=null;
        PreparedStatement sentencia = null;
        int filasAfectadas=0;
        try{
            conexion = CustomConnection.getConnection();
            String consulta="DELETE FROM TUSUARIOS "
                    + "WHERE usu_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigo);
            filasAfectadas = sentencia.executeUpdate();
            conexion.close();
        }
        catch(Exception e){
            if (sentencia!=null) sentencia.close();
            if (conexion!=null) conexion.close();
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        }
        finally{
            try {
                if (sentencia!=null) sentencia.close();
                if (conexion!=null) conexion.close();
            } catch (SQLException e){throw new Exception("[" +
                    this.getClass().getName()+"] "+ e.getMessage());}
        }
        return (filasAfectadas);

    }
    

}
