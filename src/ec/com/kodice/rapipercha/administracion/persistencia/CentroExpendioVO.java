/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.persistencia;

/**
 * Esta clase contiene los atributos y metodos de un CentroExpendioVO
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2021/01/06 
 */
public class CentroExpendioVO extends EmpresaVO{
    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public CentroExpendioVO(int codigo, String ruc, String RazonSocial,
            String nombreComercial) {
        this.codigo = codigo;
        this.ruc = ruc;
        this.nombreComercial = nombreComercial;
        this.razonSocial = razonSocial;
        
    }    
    
      public CentroExpendioVO() {
       
        
    }    

   public String toString (){
    
        return (this.codigo + " "+this.nombreComercial);
    }
    
}
