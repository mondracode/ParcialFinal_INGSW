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
public class Instalacion {
    private int id_sensor, id_instalacion;
    private String ubicacion_sensor, tipo_sensor;

    public int getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(int id_sensor) {
        this.id_sensor = id_sensor;
    }

    public String getUbicacion_sensor() {
        return ubicacion_sensor;
    }

    public void setUbicacion_sensor(String ubicacion_sensor) {
        this.ubicacion_sensor = ubicacion_sensor;
    }

    public String getTipo_sensor() {
        return tipo_sensor;
    }

    public void setTipo_sensor(String tipo_sensor) {
        this.tipo_sensor = tipo_sensor;
    }

    public int getId_instalacion() {
        return id_instalacion;
    }

    public void setId_instalacion(int id_instalacion) {
        this.id_instalacion = id_instalacion;
    }
    
    
        
    public Instalacion clone() throws CloneNotSupportedException{
        Instalacion cloned = (Instalacion) super.clone();
        return cloned;
    }
}
