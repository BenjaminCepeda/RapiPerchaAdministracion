/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.presentacion;

/**
 * Esta clase contiene los atributos y metodos de la clase Principal
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/02 
 */
public class Principal {

    /**
     * Metodo principal de la clase
     * @param args Argumento de linea de comando
     */
    public static void main(String[] args) {
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setLocationRelativeTo(null);
        frmLogin.setVisible(true);
   }
}
