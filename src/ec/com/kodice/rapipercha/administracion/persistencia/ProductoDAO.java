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
 * @author jeffo
 */
public class ProductoDAO {
    
    public List<ProductoVO> buscaProductosporLocal(int codigolocal, int codigoproveedor) throws Exception {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        List<ProductoVO> listaElementos = null;
        ProductoVO productoVO = null;
        UsuarioVO usuarioVO = null;
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        try {
            conexion = CustomConnection.getConnection();
            String consulta = "SELECT \n" +
"            tproductos.PROD_CODIGO,\n" +
"            tproductos.PROD_DESCRIPCION,\n" +
"            tproductos.PROD_CODIGO_EXTERNO_PRODUCTO,\n" +
"            `PRLO_CANTIDAD_MINIMA`,\n" +
"            `PRLO_EXISTENCIA`\n" +
"            FROM\n" +
"            `rproducto_local`\n" +
"            INNER JOIN tproductos ON rproducto_local.PROD_CODIGO = tproductos.PROD_CODIGO\n" +
"            WHERE\n" +
"            `LOC_CODIGO` = ? and tproductos.PROV_CODIGO=? ";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, codigolocal);
            sentencia.setInt(2, codigoproveedor);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (listaElementos == null) {
                    listaElementos
                            = new ArrayList<ProductoVO>();
                }
                productoVO = new ProductoVO(
                        resultado.getInt("tproductos.PROD_CODIGO"),
                        resultado.getString("tproductos.PROD_DESCRIPCION"),
                        resultado.getString("tproductos.PROD_CODIGO_EXTERNO_PRODUCTO"),
                        resultado.getFloat("PRLO_CANTIDAD_MINIMA"),
                        resultado.getFloat("PRLO_EXISTENCIA"));
                                      
                listaElementos.add(productoVO);
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
