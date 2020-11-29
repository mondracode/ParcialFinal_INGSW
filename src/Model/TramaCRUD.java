/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author smggu
 */
public class TramaCRUD {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BONO_DBU");
    
    public void insertar(TramaDatos trama){
        
    }
}
