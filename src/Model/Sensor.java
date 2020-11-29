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
public class Sensor {
    private String tipo, nombre;
    private int min_permitido, max_permitido, num_horas;
    private boolean promedio;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMin_permitido() {
        return min_permitido;
    }

    public void setMin_permitido(int min_permitido) {
        this.min_permitido = min_permitido;
    }

    public int getMax_permitido() {
        return max_permitido;
    }

    public void setMax_permitido(int max_permitido) {
        this.max_permitido = max_permitido;
    }

    public int getNum_horas() {
        return num_horas;
    }

    public void setNum_horas(int num_horas) {
        this.num_horas = num_horas;
    }

    public boolean isPromedio() {
        return promedio;
    }

    public void setPromedio(boolean promedio) {
        this.promedio = promedio;
    }
    
    public Sensor clone() throws CloneNotSupportedException{
        Sensor cloned = (Sensor) super.clone();
        return cloned;
    }
}
