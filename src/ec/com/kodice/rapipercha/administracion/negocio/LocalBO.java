/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.kodice.rapipercha.administracion.negocio;

import ec.com.kodice.rapipercha.administracion.persistencia.LocalDAO;
import ec.com.kodice.rapipercha.administracion.persistencia.LocalVO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chica
 */
public class LocalBO {
    LocalDAO localDAO= null;
    
    public LocalBO(){
        localDAO = new LocalDAO();
    }
    
    public int crear(LocalVO localVO) throws Exception{
        int codigoGenerado = 0;
        try {
            codigoGenerado = localDAO.crear(localVO);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (codigoGenerado);
    }
    
    public LocalVO buscar(int codigo) throws Exception{
        LocalVO localVO=null;
        try {
            localVO = localDAO.buscar(codigo);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (localVO);
    }
    
    public List<LocalVO> buscarTodos() throws Exception {
        List<LocalVO> listaElementos = null;
        try {
            listaElementos = localDAO.buscarTodos();

        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (listaElementos);
    }
    
    public int actualizar(LocalVO localVO) throws Exception {
        int filasAfectadas = 0;
        try {
            filasAfectadas = localDAO.actualizar(localVO);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (filasAfectadas);
    }
    
    public int eliminar(int codigo) throws Exception {
        int filasAfectadas = 0;
        try {
            filasAfectadas = localDAO.eliminar(codigo);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (filasAfectadas);
    }
    
    public DefaultTableModel generaModeloDatosTabla(Object[] titulosCabecera) 
            throws Exception {
        DefaultTableModel dtmListaElementos = new DefaultTableModel();
        List<LocalVO> listaElementos = null;
        dtmListaElementos.setColumnIdentifiers(titulosCabecera);
        try {
            listaElementos = localDAO.buscarTodos();
            if (listaElementos != null) {
                for (LocalVO localVO : listaElementos) {
                    dtmListaElementos.addRow(new Object[]{
                        localVO.getCodigo(), localVO.getNombre(),
                      localVO.getDireccion()});
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (dtmListaElementos);
    }
}
