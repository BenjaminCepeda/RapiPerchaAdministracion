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
    private PersonaVO contacto = new PersonaVO();
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public PersonaVO getContacto() {
        return contacto;
    }

    public void setContacto(PersonaVO contacto) {
        this.contacto = contacto;
    }


    public ProveedorVO() {
    }

    public ProveedorVO(int codigo, String ruc, String razonSocial,
            String nombreComercial, String nombreContacto, 
            String apellidoContacto, String telefonoContacto, 
            String correoContacto) {
        this.codigo = codigo;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.nombreComercial = nombreComercial;
        this.contacto.setNombres( nombreContacto);
        this.contacto.setApellidos( apellidoContacto);
        this.contacto.setTelefono(telefonoContacto);
        this.contacto.setCorreo(correoContacto);
    }
    
    @Override
    public String toString(){
        return(this.razonSocial + " (" + nombreComercial+")");
    }    
}
