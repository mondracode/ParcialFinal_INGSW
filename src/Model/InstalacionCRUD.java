/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author smggu
 */
public class InstalacionCRUD {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BONO_DBU");
    
    public void insertar(Instalacion instalacion){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(instalacion);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public boolean eliminar(Instalacion instalacion){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean done = false;
        try{
            em.remove(instalacion);
        } catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
            return done;
        }
    }
    
    public Instalacion leerSingle(Instalacion instalacion){
        EntityManager em = emf.createEntityManager();
        Instalacion res = null;
        Query q = em.createQuery("SELECT t FROM Instalacion t " + 
                                "WHERE  t.id_toma LIKE :id_instalacion" + 
                                " AND t.id_instalacion LIKE :id_sensor")
                                .setParameter("id_instalacion", instalacion.getId_instalacion())
                                .setParameter("id_sensor", instalacion.getId_sensor());
        
        try{
            res = (Instalacion)q.getSingleResult();
        } catch(NonUniqueResultException e){
            res = (Instalacion)q.getResultList().get(0);
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return res;
        }
    }
    
    public ArrayList<Instalacion> leerMultiple(){
        //TO DO
        return null;
    } 
    
    public boolean actualizar(Instalacion s, Instalacion new_s){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean done = false;
        
        try{
            s = leerSingle(s);
            s = (Instalacion)new_s.clone();
            em.merge(s);
            em.getTransaction().commit();
            done = true;
            
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
            return done;
        }
    }
}
