/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.persistencia;

/**
 * Esta clase contiene los atributos y metodos de un ProveedorVO
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/03 
 */
public class ProveedorVO extends EmpresaVO {
    private int codigo;
    private String nombreContacto;
    private String apellidoContacto;
    private String telefonoContacto;
    private String correoContacto;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getApellidoContacto() {
        return apellidoContacto;
    }

    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public ProveedorVO() {
    }

    public ProveedorVO(int codigo, String ruc, String razonSocial,
            String nombreComercial, String nombreContacto, 
            String apellidoContacto, String telefonoContacto, 
            String correoContacto) {
        this.codigo = codigo;
        setRuc(ruc);
        setRazonSocial(razonSocial);
        setNombreComercial(nombreComercial);
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.telefonoContacto = correoContacto;
        this.correoContacto = correoContacto;
    }
    

}
