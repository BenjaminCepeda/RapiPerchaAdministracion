/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.persistencia;

/**
 * Esta clase contiene los atributos y metodos de un EmpresaVO
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/03 
 */
public class EmpresaVO {
    protected String ruc;
    protected String razonSocial;
    protected String nombreComercial;

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

}
