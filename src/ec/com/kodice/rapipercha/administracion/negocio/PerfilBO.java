/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.negocio;

import ec.com.kodice.rapipercha.administracion.persistencia.PerfilDAO;
import ec.com.kodice.rapipercha.administracion.persistencia.PerfilVO;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase contiene la capa de negocio de Perfil
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/06 
 */
public class PerfilBO {
    PerfilDAO perfilDAO =null;

    public PerfilBO() {
        perfilDAO = new PerfilDAO();
    }
    
    public int  crear(PerfilVO perfilVO) throws Exception{
        int codigoGenerado=0;
        try {
            codigoGenerado = perfilDAO.crear(perfilVO);
        }
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return(codigoGenerado);
    }
    
    public PerfilVO buscar(int codigo) throws Exception{
        PerfilVO perfilVO=null;
        try {
            perfilVO = perfilDAO.buscar(codigo);
            
        }
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return(perfilVO);
    }
    
    public List<PerfilVO> buscarTodos() throws Exception{
        List<PerfilVO> listaElementos=null;
        try {
            listaElementos = perfilDAO.buscarTodos();
            
        }
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return(listaElementos);
    }

    public int actualizar(PerfilVO perfilVO) throws Exception{
        int filasAfectadas=0;
        try{
            filasAfectadas = perfilDAO.actualizar(perfilVO);
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
                filasAfectadas = perfilDAO.eliminar(codigo);                
        }
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return(filasAfectadas);
    }   
    
    public DefaultTableModel generaModeloDatosTabla(Object[] titulosCabecera) throws Exception {
        DefaultTableModel dtmListaElementos = new DefaultTableModel();
        List<PerfilVO> listaElementos = null;
        dtmListaElementos.setColumnIdentifiers(titulosCabecera);
        try {
            listaElementos = perfilDAO.buscarTodos();
            if (listaElementos != null) {
                for (PerfilVO perfilVO : listaElementos) {
                    dtmListaElementos.addRow(new Object[]{perfilVO.getCodigo(),
                        perfilVO.getNombre()});
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
        List<PerfilVO> listaElementos = null;
        try {
            listaElementos = perfilDAO.buscarTodos();
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
 
    public DefaultComboBoxModel generaModeloDatosTipoPerfil() {
        DefaultComboBoxModel dcmListaElementos = new DefaultComboBoxModel();    
        dcmListaElementos.addElement("Administrador");
        dcmListaElementos.addElement("Coordinador");
        dcmListaElementos.addElement("Toma fisica");
        return (dcmListaElementos);
    }
}
