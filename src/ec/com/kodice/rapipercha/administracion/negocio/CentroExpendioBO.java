/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.kodice.rapipercha.administracion.negocio;

import ec.com.kodice.rapipercha.administracion.persistencia.CentroExpendioDAO;
import ec.com.kodice.rapipercha.administracion.persistencia.CentroExpendioVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chica
 */
public class CentroExpendioBO {
    
    CentroExpendioDAO centroExpendioDAO = null;
    
    public CentroExpendioBO(){
        centroExpendioDAO = new CentroExpendioDAO();
    }
    
    public int crear(CentroExpendioVO centroExpendioVO) throws Exception {
        int codigoGenerado = 0;
        try {
            codigoGenerado = centroExpendioDAO.crear(centroExpendioVO);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (codigoGenerado);
    }

    public CentroExpendioVO buscar(int codigo) throws Exception {
        CentroExpendioVO centroExpendioVO = null;
        try {
            centroExpendioVO = centroExpendioDAO.buscar(codigo);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (centroExpendioVO);
    }

    public List<CentroExpendioVO> buscarTodos() throws Exception {
        List<CentroExpendioVO> listaElementos = null;
        try {
            listaElementos = centroExpendioDAO.buscarTodos();

        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (listaElementos);
    }

    public int actualizar(CentroExpendioVO centroExpendioVO) throws Exception {
        int filasAfectadas = 0;
        try {
            filasAfectadas = centroExpendioDAO.actualizar(centroExpendioVO);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (filasAfectadas);
    }

    public int eliminar(int codigo) throws Exception {
        int filasAfectadas = 0;
        try {
            filasAfectadas = centroExpendioDAO.eliminar(codigo);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (filasAfectadas);
    }

    public DefaultTableModel generaModeloDatosTabla(Object[] titulosCabecera) 
            throws Exception {
        DefaultTableModel dtmListaElementos = new DefaultTableModel();
        List<CentroExpendioVO> listaElementos = null;
        dtmListaElementos.setColumnIdentifiers(titulosCabecera);
        try {
            listaElementos = centroExpendioDAO.buscarTodos();
            if (listaElementos != null) {
                for (CentroExpendioVO centroExpendioVO : listaElementos) {
                    dtmListaElementos.addRow(new Object[]{centroExpendioVO.getCodigo(), centroExpendioVO.getRuc(),
                      centroExpendioVO.getRazonSocial(), centroExpendioVO.getNombreComercial()});
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (dtmListaElementos);
    }
    
    public DefaultComboBoxModel generaModeloDatosCombo() throws Exception {
        DefaultComboBoxModel  cmbListaElementos = null;
        List<CentroExpendioVO> listaElementos = null;
        try {
            listaElementos=centroExpendioDAO.buscarTodos();
            if (listaElementos != null) {
                List<String> listTemp=new ArrayList<>();
                for (Iterator<CentroExpendioVO> iterator = listaElementos.iterator(); iterator.hasNext();) {
                    CentroExpendioVO next = iterator.next();
                    listTemp.add(next.getCodigo()+"-"+next.getNombreComercial());
                }
                cmbListaElementos = new DefaultComboBoxModel(listTemp.toArray());
            }
        } 
        catch(Exception e){
            throw new Exception(e.getMessage() + 
                    "\n["+this.getClass().getName()+"]");
        }
        return (cmbListaElementos);
    }
}
