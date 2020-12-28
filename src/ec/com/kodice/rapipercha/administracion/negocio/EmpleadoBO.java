/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.negocio;

import ec.com.kodice.rapipercha.administracion.persistencia.EmpleadoDAO;
import ec.com.kodice.rapipercha.administracion.persistencia.EmpleadoVO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase contiene los atributos y metodos de un EmpleadoBO
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/28
 */
public class EmpleadoBO {
    EmpleadoDAO empleadoDAO = null;

    public EmpleadoBO() {
        empleadoDAO = new EmpleadoDAO();
    }

    public int crear(EmpleadoVO empleadoVO) throws Exception {
        int codigoGenerado = 0;
        try {
            codigoGenerado = empleadoDAO.crear(empleadoVO);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (codigoGenerado);
    }

    public EmpleadoVO buscar(int codigo) throws Exception {
        EmpleadoVO empleadoVO = null;
        try {
            empleadoVO = empleadoDAO.buscar(codigo);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (empleadoVO);
    }

    public List<EmpleadoVO> buscarTodos() throws Exception {
        List<EmpleadoVO> listaElementos = null;
        try {
            listaElementos = empleadoDAO.buscarTodos();

        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (listaElementos);
    }

    public int actualizar(EmpleadoVO empleadoVO) throws Exception {
        int filasAfectadas = 0;
        try {
            filasAfectadas = empleadoDAO.actualizar(empleadoVO);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (filasAfectadas);
    }

    public int eliminar(int codigo) throws Exception {
        int filasAfectadas = 0;
        try {
            filasAfectadas = empleadoDAO.eliminar(codigo);
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (filasAfectadas);
    }

    public DefaultTableModel generaModeloDatosTabla(Object[] titulosCabecera) 
            throws Exception {
        DefaultTableModel dtmListaElementos = new DefaultTableModel();
        List<EmpleadoVO> listaElementos = null;
        dtmListaElementos.setColumnIdentifiers(titulosCabecera);
        try {
            listaElementos = empleadoDAO.buscarTodos();
            if (listaElementos != null) {
                for (EmpleadoVO empleadoVO : listaElementos) {
                    dtmListaElementos.addRow(new Object[]{
                        empleadoVO.getCodigo(), empleadoVO.getCedula(),
                        empleadoVO.getApellidos(),empleadoVO.getNombres(),
                        empleadoVO.getUsuario().getNombre(),
                        empleadoVO.getUsuario().getPerfil().getNombre()});
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage()
                    + "\n[" + this.getClass().getName() + "]");
        }
        return (dtmListaElementos);
    }

}
