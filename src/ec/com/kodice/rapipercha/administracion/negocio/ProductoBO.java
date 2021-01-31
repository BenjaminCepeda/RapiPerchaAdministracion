/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.kodice.rapipercha.administracion.negocio;
import ec.com.kodice.rapipercha.administracion.persistencia.PerfilVO;
import ec.com.kodice.rapipercha.administracion.persistencia.ProductoDAO;
import ec.com.kodice.rapipercha.administracion.persistencia.ProductoVO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jeffo
 */
public class ProductoBO {
     ProductoDAO productoDAO= null;
    
    
    
      public DefaultTableModel generaModeloDatosTabla(int codigolocal, int codigoproveedor,Object[] titulosCabecera) throws Exception {
        DefaultTableModel dtmListaElementos = new DefaultTableModel();
        ProductoDAO productoDAO= new ProductoDAO();
        List<ProductoVO> listaElementos = null;
        dtmListaElementos.setColumnIdentifiers(titulosCabecera);
        try {
            listaElementos = productoDAO.buscaProductosporLocal(codigolocal, codigoproveedor);
            if (listaElementos != null) {
                for (ProductoVO productoVO : listaElementos) {
                    dtmListaElementos.addRow(new Object[]{productoVO.getCodigo(),
                        productoVO.getDescripcion(),productoVO.getCodigoExternoProducto(),
                        productoVO.getExistencia(),productoVO.getcantidadMinima()});
                }

            }
        } 
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return (dtmListaElementos);
    }
    
    
      
    
    
}
