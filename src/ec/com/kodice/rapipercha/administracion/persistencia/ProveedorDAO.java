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

/**
 * Esta clase contiene metodos de acceso a datos de una Empresa
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/03 
 */
public class ProveedorDAO {

    public void crear(ProveedorVO provedorVO){
        // TODO: Completar el metodo
    }
    public ProveedorVO leer(int codigo) 
            throws SQLException, ClassNotFoundException{
        ProveedorVO proveedorVO = null;
        try{
            Connection conexion = CustomConnection.getConnection();
            String sentencia="SELECT prov_codigo, prov_ruc, prov_razon_social, "
                    + "prov_nombre_comercial, prov_nombre_contacto, "
                    + "prov_apellido_contacto, prov_telefono_contacto, "
                    + "prov_correo_contacto"
                    + "FROM TPROVEEDORES WHER prov_codigo = ?";
            PreparedStatement consulta = conexion.prepareStatement(sentencia);
            consulta.setInt(1, codigo);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
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
        catch(SQLException e){
            throw new SQLException(e);
        }
        return proveedorVO;
    }
    public void actualizar(ProveedorVO provedorVO){
        // TODO: Completar el metodo
    }
    public void eliminar(int codigo){
        // TODO: Completar el metodo
    }
    
}
