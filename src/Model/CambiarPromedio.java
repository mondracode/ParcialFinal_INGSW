/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author smggu
 */
public class CambiarPromedio {
    public static void main(String[] args) {
        boolean x = SensorCRUD.actualizarPromedio(1, true);
        System.out.println(x);
    }
}
