/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author smggu
 */
@Entity
@Table(name = "Instalacion")
public class Instalacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_instalacion;

    private int id_sensor;
    private String ubicacion_sensor, tipo_sensor;

    public Instalacion(int id_sensor, String ubicacion_sensor, String tipo_sensor) {
        this.id_sensor = id_sensor;
        this.ubicacion_sensor = ubicacion_sensor;
        this.tipo_sensor = tipo_sensor;
    }

    public Instalacion() {
    }

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

    public Instalacion clone() throws CloneNotSupportedException {
        Instalacion cloned = (Instalacion) super.clone();
        return cloned;
    }
}
