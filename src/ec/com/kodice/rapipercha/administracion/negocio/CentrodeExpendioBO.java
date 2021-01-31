/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.kodice.rapipercha.administracion.negocio;

import ec.com.kodice.rapipercha.administracion.persistencia.CentrodeExpendioDAO;
import ec.com.kodice.rapipercha.administracion.persistencia.CentroExpendioVO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jeffo
 */
public class CentrodeExpendioBO {
    
      
     public DefaultComboBoxModel generaModeloDatosCombo(int codigoProveedor) throws Exception {
        DefaultComboBoxModel  cmbListaElementos = null;
        CentrodeExpendioDAO centrodeexpendioDAO = new CentrodeExpendioDAO();
        List<CentroExpendioVO> listaElementos = null;
        try {
            listaElementos = centrodeexpendioDAO.buscarCentroExpendioporProveedor(codigoProveedor);
            if (listaElementos != null) {
                cmbListaElementos = new DefaultComboBoxModel(listaElementos.toArray());
              /**  for (PerfilVO perfilVO : listaElementos) {
                    cmbListaElementos.addElement(perfilVO);
                }
              */
            }
        } 
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return (cmbListaElementos);
    }
     
       public DefaultComboBoxModel generaModeloDatosComboUnSoloItem(int codigoCentroExpendio) throws Exception {
        DefaultComboBoxModel  cmbListaElementos = null;
        CentrodeExpendioDAO centrodeexpendioDAO = new CentrodeExpendioDAO();
        List<CentroExpendioVO> listaElementos = null;
        try {
            listaElementos = centrodeexpendioDAO.buscarCentroExpendioDesdeLocal(codigoCentroExpendio);
            if (listaElementos != null) {
                cmbListaElementos = new DefaultComboBoxModel(listaElementos.toArray());
              /**  for (PerfilVO perfilVO : listaElementos) {
                    cmbListaElementos.addElement(perfilVO);
                }
              */
            }
        } 
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return (cmbListaElementos);
    }
    
    
    
    
}
