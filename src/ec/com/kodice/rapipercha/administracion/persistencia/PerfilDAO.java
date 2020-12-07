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
 * Esta clase contiene metodos de acceso a datos de una Perfil
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/05 
 */
public class PerfilDAO {
    
    /**
     * Permite crear un nuevo Perfil
     * @param perfilVO POJO con los atributos de Perfil
     * @return Codigo del registro creado 
     * @throws Exception 
     */
    public int crear(PerfilVO perfilVO) throws Exception{
        Connection conexion=null;
        PreparedStatement sentencia = null;
        int codigoGenerado=0;
        try{
            conexion = CustomConnection.getConnection();
            String consulta="INSERT INTO TPERFILES "
                    + "(per_nombre)"
                    + "VALUES (?)";
            sentencia = conexion.prepareStatement(consulta,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, perfilVO.getNombre());
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
     * Permite leer un Perfil en base de su codigo
     * @param codigo Codigo del registro a ser leído
     * @return POJO con los atributos de Perfil
     * @throws Exception 
     */
    public PerfilVO buscar(int codigo) throws Exception{
        Connection conexion=null;
        PreparedStatement sentencia = null;
        PerfilVO perfilVO = null;
        try{
            conexion = CustomConnection.getConnection();
            String consulta="SELECT per_codigo, per_nombre "
                    + "FROM TPERFILES  WHERE per_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigo);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
               perfilVO = new PerfilVO(codigo, 
                       resultado.getString("per_nombre"));
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
        }        return perfilVO;
    }

   /**
     * Devuelve el  listado  de Perfiles
     * @return Lista de Perfiles
     * @throws Exception 
     */
    public List<PerfilVO> buscarTodos() throws Exception{
        Connection conexion=null;
        PreparedStatement sentencia = null;
        List<PerfilVO> listaElementos=null;
        PerfilVO perfilVO = null;
        try{
            conexion = CustomConnection.getConnection();
            String consulta="SELECT per_codigo, per_nombre "
                    + "FROM TPERFILES ";
            sentencia = conexion.prepareStatement(consulta);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                if (listaElementos== null) listaElementos = new ArrayList<PerfilVO>();
               perfilVO = new PerfilVO(
                       resultado.getInt("per_codigo"),
                       resultado.getString("per_nombre"));
               listaElementos.add(perfilVO);
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
    public int actualizar(PerfilVO perfilVO) throws Exception{
        Connection conexion=null;
        PreparedStatement sentencia = null;
        conexion=null;
        int filasAfectadas=0;
        try{
            conexion = CustomConnection.getConnection();
            String consulta = "SET per_nombre = ? "
                    + "UPDATE TPERFILES "
                    + "WHERE per_codigo = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, perfilVO.getNombre());
            sentencia.setInt(2, perfilVO.getCodigo());
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
     * Permte eliminar un registro de Perfil
     * @param codigo Codigo del Perfil a eliminar
     * @return Numero de registros eliminados
     * @throws Exception 
     */
    public int eliminar(int codigo) throws Exception{
        Connection conexion=null;
        PreparedStatement sentencia = null;
        int filasAfectadas=0;
        try{
            conexion = CustomConnection.getConnection();
            String consulta="DELETE FROM TPERFILES "
                    + "WHERE per_codigo = ?";
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
