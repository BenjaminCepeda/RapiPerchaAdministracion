/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.kodice.rapipercha.administracion.negocio;

import ec.com.kodice.rapipercha.administracion.persistencia.LocalVO;
import ec.com.kodice.rapipercha.administracion.persistencia.LocalDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jeffo
 */
public class LocalBO {
    
    LocalDAO localDAO = null;

    public LocalBO() {
        localDAO = new LocalDAO();
    }
    public DefaultComboBoxModel generaModeloDatosCombo(int codigocentroexpendio) throws Exception {
        DefaultComboBoxModel  cmbListaElementos = null;
        LocalDAO localDAO = new LocalDAO();
        List<LocalVO> listaElementos = null;
        try {
            listaElementos = localDAO.buscaLocalporCentroExpendio(codigocentroexpendio);
            if (listaElementos != null) {
                cmbListaElementos = new DefaultComboBoxModel(listaElementos.toArray());
                          
            }
        } 
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return (cmbListaElementos);
    }
     
    
    public LocalVO buscar(int codigo) throws Exception {
        LocalVO localVO = null;
        LocalDAO localDAO=null;
        localDAO =new LocalDAO();
        
        try {
            localVO = this.localDAO.buscar(codigo);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (localVO);
    }
    
    public DefaultComboBoxModel generaModeloDatosComboUnSoloItem(int LocalCodigo) throws Exception {
        DefaultComboBoxModel  cmbListaElementos = null;
        LocalDAO localDAO = new LocalDAO();
        List<LocalVO> listaElementos = null;
        try {
            listaElementos = localDAO.buscarLocalporCodigoaComboBox(LocalCodigo);
            if (listaElementos != null) {
                cmbListaElementos = new DefaultComboBoxModel(listaElementos.toArray());
                          
            }
        } 
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return (cmbListaElementos);
    }
    
    
}
