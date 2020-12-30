/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.presentacion;

import ec.com.kodice.rapipercha.administracion.persistencia.EmpleadoVO;
import ec.com.kodice.rapipercha.administracion.persistencia.ProveedorVO;

/**
 * Esta clase contiene los atributos y metodos de un FrmEsquemaInicial
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/30 
 */
public class FrmEsquemaInicial extends javax.swing.JFrame{
    private EmpleadoVO empleadoLogueado= null;
    private ProveedorVO proveedorEmpleadoLogueado = null;

    public EmpleadoVO getEmpleadoLogueado() {
        return empleadoLogueado;
    }

    public void setEmpleadoLogueado(EmpleadoVO empleadoLogueado) {
        this.empleadoLogueado = empleadoLogueado;
    }

    public ProveedorVO getProveedorEmpleadoLogueado() {
        return proveedorEmpleadoLogueado;
    }

    public void setProveedorEmpleadoLogueado(ProveedorVO proveedorEmpleadoLogueado) {
        this.proveedorEmpleadoLogueado = proveedorEmpleadoLogueado;
    }

    public FrmEsquemaInicial (EmpleadoVO empleadoLogueado, 
            ProveedorVO proveedorEmpleadoLogueado){
        this.empleadoLogueado = empleadoLogueado;
        this.proveedorEmpleadoLogueado = proveedorEmpleadoLogueado;
    }
    
}
