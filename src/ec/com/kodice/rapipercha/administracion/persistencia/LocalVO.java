/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.persistencia;

/**
 * Esta clase contiene los atributos y metodos de un LocalVO
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2021/01/06 
 */
public class LocalVO {
    private int codigo;
    private CentroExpendioVO centroExpendioVO = new CentroExpendioVO();
    private String nombre;
    private String direccion;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public CentroExpendioVO getCentroExpendioVO() {
        return centroExpendioVO;
    }

    public void setCentroExpendioVO(CentroExpendioVO centroExpendioVO) {
        this.centroExpendioVO = centroExpendioVO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalVO(int codigo, int centroExpendioCodigo, String nombre, String direccion) {
        this.codigo = codigo;
        this.centroExpendioVO.setCodigo(centroExpendioCodigo);
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public LocalVO() {
    }
    
    
}
