/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.negocio;

import ec.com.kodice.rapipercha.administracion.persistencia.PerfilVO;
import ec.com.kodice.rapipercha.administracion.persistencia.ProveedorDAO;
import ec.com.kodice.rapipercha.administracion.persistencia.ProveedorVO;
import ec.com.kodice.rapipercha.administracion.persistencia.UsuarioVO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase contiene los atributos y metodos de un ProveedorBO
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/22 
 */
public class ProveedorBO {
    ProveedorDAO proveedorDAO = null;

    public ProveedorBO() {
        proveedorDAO = new ProveedorDAO();
    }

    public int crear(ProveedorVO proveedorVO) throws Exception {
        int codigoGenerado = 0;
        try {
            codigoGenerado = proveedorDAO.crear(proveedorVO);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (codigoGenerado);
    }

    public ProveedorVO buscar(int codigo) throws Exception {
        ProveedorVO proveedorVO = null;
        try {
            proveedorVO = proveedorDAO.buscar(codigo);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (proveedorVO);
    }

    public List<ProveedorVO> buscarTodos() throws Exception {
        List<ProveedorVO> listaElementos = null;
        try {
            listaElementos = proveedorDAO.buscarTodos();

        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (listaElementos);
    }
    
    
    public int actualizar(ProveedorVO proveedorVO) throws Exception {
        int filasAfectadas = 0;
        try {
            filasAfectadas = proveedorDAO.actualizar(proveedorVO);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (filasAfectadas);
    }

    public int eliminar(int codigo) throws Exception {
        int filasAfectadas = 0;
        try {
            filasAfectadas = proveedorDAO.eliminar(codigo);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (filasAfectadas);
    }

    public DefaultTableModel generaModeloDatosTabla(Object[] titulosCabecera) 
            throws Exception {
        DefaultTableModel dtmListaElementos = new DefaultTableModel();
        List<ProveedorVO> listaElementos = null;
        dtmListaElementos.setColumnIdentifiers(titulosCabecera);
        try {
            listaElementos = proveedorDAO.buscarTodos();
            if (listaElementos != null) {
                for (ProveedorVO proveedorVO : listaElementos) {
                    dtmListaElementos.addRow(new Object[]{
                        proveedorVO.getCodigo(), proveedorVO.getRuc(),
                      proveedorVO.getRazonSocial(),
                      proveedorVO.getNombreComercial()});
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
        List<ProveedorVO> listaElementos = null;
        try {
            listaElementos = proveedorDAO.buscarTodos();
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
