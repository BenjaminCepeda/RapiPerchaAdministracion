/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.persistencia;

/**
 * Esta clase contiene los atributos y metodos de un Perfil
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/05 
 */
public class PerfilVO {

    private int codigo;
    private String nombre;

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

    public PerfilVO(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public PerfilVO() {
    }
    
    @Override
    public String toString(){
        return(this.nombre);
    }
}
