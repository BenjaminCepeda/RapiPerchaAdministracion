/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.persistencia;

/**
 * Esta clase contiene los atributos y metodos de un ProductoVO
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2021/01/13 
 */
public class ProductoVO {
    private int codigo;
    private int proveedorCodigo;
    private String descripcion;
    private String codigoExternoProducto;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoExternoProducto() {
        return codigoExternoProducto;
    }

    public void setCodigoExternoProducto(String codigoExternoProducto) {
        this.codigoExternoProducto = codigoExternoProducto;
    }

    public ProductoVO(int codigo, int proveedorCodigo, String descripcion, String codigoExternoProducto) {
        this.codigo = codigo;
        this.proveedorCodigo = proveedorCodigo;
        this.descripcion = descripcion;
        this.codigoExternoProducto = codigoExternoProducto;
    }

    public ProductoVO() {
    }

    

}
