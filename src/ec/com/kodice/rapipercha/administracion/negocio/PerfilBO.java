/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.negocio;

import ec.com.kodice.rapipercha.administracion.persistencia.PerfilDAO;
import ec.com.kodice.rapipercha.administracion.persistencia.PerfilVO;
import java.util.List;
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
            perfilDAO.crear(perfilVO);
        }
        catch(Exception e){
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        }
        return(codigoGenerado);
    }
    
    public PerfilVO buscar(int codigo) throws Exception{
        PerfilVO perfilVO=null;
        try {
            perfilVO = perfilDAO.buscar(codigo);
            
        }
        catch(Exception e){
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        }        
        return(perfilVO);
    }
    
    public List<PerfilVO> buscarTodos() throws Exception{
        List<PerfilVO> listaElementos=null;
        try {
            listaElementos = perfilDAO.buscarTodos();
            
        }
        catch(Exception e){
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        }        
        return(listaElementos);
    }

    public int actualizar(PerfilVO perfilVO) throws Exception{
        int filasAfectadas=0;
        try{
            filasAfectadas = perfilDAO.actualizar(perfilVO);
        }
        catch(Exception e){
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        }        
        return(filasAfectadas);
    }    
    
    public int eliminar(int codigo) throws Exception{
        int filasAfectadas=0;
        try{
                filasAfectadas = perfilDAO.eliminar(codigo);                
        }
        catch(Exception e){
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        }        
        return(filasAfectadas);
    }   
    
    public DefaultTableModel buscarModeloDatos() throws Exception {
        DefaultTableModel dtmListaElementos = new DefaultTableModel();
        List<PerfilVO> listaElementos = null;
        dtmListaElementos.setColumnIdentifiers(new Object[]{"CODIGO", "NOMBRE"});
        try {
            listaElementos = perfilDAO.buscarTodos();
            if (listaElementos != null) {
                for (PerfilVO perfilVO : listaElementos) {
                    dtmListaElementos.addRow(new Object[]{perfilVO.getCodigo(),
                        perfilVO.getNombre()});
                }

            }
        } catch (Exception e) {
            throw new Exception("[" + this.getClass().getName() + "] "
                    + e.getMessage());
        }
        return (dtmListaElementos);
    }

}
