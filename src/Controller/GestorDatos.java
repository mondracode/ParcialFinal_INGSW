/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Sensor;
import Model.SensorCRUD;
import Model.TramaDatos;
import Model.TramaDatosCRUD;
import View.EnviarDato;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author smggu
 */
public class GestorDatos {
    public static void enviarDato(int id){
        if(id < 1 || id > 38){
            return;
        }
                     
        Sensor s = SensorCRUD.buscarSensor(id);
        
        //valor aleatorio permitido
        int valor_tomado = (int)(Math.random()*((s.getMax_permitido() - s.getMin_permitido())+1))+s.getMin_permitido();
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha = LocalDateTime.now().format(formatter);
        
        TramaDatos t = new TramaDatos(id, valor_tomado,fecha);
        
        TramaDatosCRUD.insertar(t);
    }
    
    public static ArrayList<Object[]> mostrarTramas(int id){
        ArrayList<TramaDatos> list = Model.TramaDatosCRUD.leerMultiple(id);
        ArrayList<Object[]> rows = new ArrayList<>();
        Sensor s = SensorCRUD.buscarSensor(id);
        
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row = new Object[5];
            row[0] = list.get(i).getId_toma();
            row[1] = list.get(i).getId_sensor();
            row[2] = list.get(i).getValor_tomado();
            row[3] = list.get(i).getFecha_toma();
            
            if(list.get(i).getValor_tomado() < s.getMax_permitido() && list.get(i).getValor_tomado() > s.getMin_permitido()){
                row[4] = "NORMAL";
            }
            else{
                row[4] = "ALERTA";
            }
            
            rows.add(row);
        }
        
        return rows;
    }
}
