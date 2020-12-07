/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.negocio;

import ec.com.kodice.rapipercha.administracion.persistencia.PerfilVO;
import ec.com.kodice.rapipercha.administracion.persistencia.UsuarioDAO;
import ec.com.kodice.rapipercha.administracion.persistencia.UsuarioVO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase contiene la capa de negocio de Perfil
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/06 
 */
public class UsuarioBO {
    UsuarioDAO usuarioDAO =null;

    public UsuarioBO() {
        usuarioDAO = new UsuarioDAO();
    }
    
    public int  crear(UsuarioVO usuarioVO) throws Exception{
        int codigoGenerado=0;
        try {
            usuarioDAO.crear(usuarioVO);
        }
        catch(Exception e){
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        }
        return(codigoGenerado);
    }
    
    public UsuarioVO buscar(int codigo) throws Exception{
        UsuarioVO usuarioVO=null;
        try {
            usuarioVO = usuarioDAO.buscar(codigo);
            
        }
        catch(Exception e){
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        }        
        return(usuarioVO);
    }
    
    public List<UsuarioVO> buscarTodos() throws Exception{
        List<UsuarioVO> listaElementos=null;
        try {
            listaElementos = usuarioDAO.buscarTodos();
            
        }
        catch(Exception e){
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        }        
        return(listaElementos);
    }

    public int actualizar(UsuarioVO usuarioVO) throws Exception{
        int filasAfectadas=0;
        try{
            filasAfectadas = usuarioDAO.actualizar(usuarioVO);
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
                filasAfectadas = usuarioDAO.eliminar(codigo);                
        }
        catch(Exception e){
            throw new Exception("["+this.getClass().getName()+"] "
                    + e.getMessage());
        }        
        return(filasAfectadas);
    }    
    public DefaultTableModel buscarModeloDatos() throws Exception {
        DefaultTableModel dtmListaElementos = new DefaultTableModel();
        List<UsuarioVO> listaElementos = null;
        dtmListaElementos.setColumnIdentifiers(new Object[]{"CODIGO", "NOMBRE"});
        try {
            listaElementos = usuarioDAO.buscarTodos();
            if (listaElementos != null) {
                for (UsuarioVO usuarioVO : listaElementos) {
                    dtmListaElementos.addRow(new Object[]{usuarioVO.getCodigo(),
                        usuarioVO.getNombre()});
                }

            }
        } catch (Exception e) {
            throw new Exception("[" + this.getClass().getName() + "] "
                    + e.getMessage());
        }
        return (dtmListaElementos);
    }

}
