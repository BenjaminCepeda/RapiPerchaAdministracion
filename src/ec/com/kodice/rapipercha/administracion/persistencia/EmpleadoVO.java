/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.persistencia;

/**
 * Esta clase contiene los atributos y metodos de un EmpleadoVO
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/28 
 */
public class EmpleadoVO extends PersonaVO{
    private int codigo;
    private int proveedorCodigo;
    private UsuarioVO usuario;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getProveedorCodigo() {
        return proveedorCodigo;
    }

    public void setProveedorCodigo(int proveedorCodigo) {
        this.proveedorCodigo = proveedorCodigo;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public EmpleadoVO() {
    }

    public EmpleadoVO(int codigo, int proveedorCodigo, int usuarioCodigo, 
            String cedula, String nombres, String apellidos, String telefono,
            String correo) {
        this.codigo = codigo;
        this.proveedorCodigo = proveedorCodigo;        
        this.usuario.setCodigo(usuarioCodigo);
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;        
    }

}
