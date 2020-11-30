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
public class InsertarSensores {
    
    
    public static void main(String[] args) {
        
        Sensor s = new Sensor("LED3", "Módulo LED 3 colores", 0, 16777215, 0, false);
        boolean x = SensorCRUD.insertar(s);
        System.out.println(x);
    }
}
