/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
/**
 *
 * @author smggu
 */
public class TramaDatos implements Cloneable {
    private int id_toma, id_sensor, valor_tomado;
    private LocalDate fecha_toma;
    
    public int getId_toma() {
        return id_toma;
    }

    public void setId_toma(int id_toma) {
        this.id_toma = id_toma;
    }

    public int getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(int id_sensor) {
        this.id_sensor = id_sensor;
    }

    public int getValor_tomado() {
        return valor_tomado;
    }

    public void setValor_tomado(int valor_tomado) {
        this.valor_tomado = valor_tomado;
    }

    public LocalDate getFecha_toma() {
        return fecha_toma;
    }

    public void setFecha_toma(LocalDate fecha_toma) {
        this.fecha_toma = fecha_toma;
    }
    
    public TramaDatos clone() throws CloneNotSupportedException{
        TramaDatos cloned = (TramaDatos) super.clone();
        return cloned;
    }
}
