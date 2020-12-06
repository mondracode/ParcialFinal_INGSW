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
public class InsertarInstalaciones {
    public static void main(String[] args) {
        Instalacion i = new Instalacion(1, "Sótano", SensorCRUD.buscarSensor(1).getTipo());
        boolean x = InstalacionCRUD.insertar(i);
        System.out.println(x);

    }
}
