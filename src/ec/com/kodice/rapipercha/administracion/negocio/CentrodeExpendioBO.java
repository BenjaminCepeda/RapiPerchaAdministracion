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

   
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase contiene la capa de negocio de Perfil
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/06 
 */
public class CentrodeExpendioBO {
    CentrodeExpendioDAO centroexpendiodao =null;

    public CentrodeExpendioBO() {
        centroexpendiodao = new CentrodeExpendioDAO();
    }
    
    public int  crear(CentroExpendioVO centroexpendioVO) throws Exception{
        int codigoGenerado=0;
        try {
            codigoGenerado = centroexpendiodao.crear(centroexpendioVO);
        }
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return(codigoGenerado);
    }
    
    public CentroExpendioVO buscar(int codigo) throws Exception{
        CentroExpendioVO centroexpendioVO=null;
        try {
            centroexpendioVO = centroexpendiodao.buscar(codigo);
            
        }
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return(centroexpendioVO);
    }
    
    public List<CentroExpendioVO> buscarTodos() throws Exception{
        List<CentroExpendioVO> listaElementos=null;
        try {
            listaElementos = centroexpendiodao.BuscarTodos();
            
        }
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return(listaElementos);
    }

    public int actualizar(CentroExpendioVO centroexpendioVO) throws Exception{
        int filasAfectadas=0;
        try{
            filasAfectadas = centroexpendiodao.actualizar(centroexpendioVO);
        }
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return(filasAfectadas);
    }    
    
    public int eliminar(int codigo) throws Exception{
        int filasAfectadas=0;
        try{
                filasAfectadas = centroexpendiodao.eliminar(codigo);                
        }
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return(filasAfectadas);
    }   
    
    public DefaultTableModel generaModeloDatosTabla(Object[] titulosCabecera) throws Exception {
        DefaultTableModel dtmListaElementos = new DefaultTableModel();
        List<CentroExpendioVO> listaElementos = null;
        dtmListaElementos.setColumnIdentifiers(titulosCabecera);
        try {
            listaElementos = centroexpendiodao.BuscarTodos();
            if (listaElementos != null) {
                for (CentroExpendioVO centroexpendioVO : listaElementos) {
                    dtmListaElementos.addRow(new Object[]{centroexpendioVO.getCodigo(),
                        centroexpendioVO.getRuc(),centroexpendioVO.getRazonSocial(),
                        centroexpendioVO.getNombreComercial()});
                }

            }
        } 
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return (dtmListaElementos);
    }
    public DefaultComboBoxModel generaModeloDatosCombo() throws Exception {
        DefaultComboBoxModel  cmbListaElementos = null;
        List<CentroExpendioVO> listaElementos = null;
        try {
            listaElementos = centroexpendiodao.BuscarTodos();
            if (listaElementos != null) {
                cmbListaElementos = new DefaultComboBoxModel(listaElementos.toArray());
              /**  for (CentroExpendioVO centroexpendioVO : listaElementos) {
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
 
    public DefaultComboBoxModel generaModeloDatosTipoPerfil() {
        DefaultComboBoxModel dcmListaElementos = new DefaultComboBoxModel();    
        dcmListaElementos.addElement("Administrador");
        dcmListaElementos.addElement("Coordinador");
        dcmListaElementos.addElement("Toma fisica");
        return (dcmListaElementos);
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
             
}