/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.persistencia;

/**
 * Esta clase contiene los atributos y metodos de un Usuario
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/06 
 */
public class UsuarioVO {
    private int codigo;
    private String nombre;
    private String clave;
    private String estado;
    private PerfilVO perfil;

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public PerfilVO getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilVO perfilVO) {
        this.perfil = perfilVO;
    }

    public UsuarioVO() {
    }

    public UsuarioVO(int codigo, String nombre, String clave, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.clave = clave;
        this.estado = estado;
    }
@Override
    public String toString(){
        return(this.codigo +" "+ this.nombre);
    }
}
