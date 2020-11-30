/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author smggu
 */
public class TramaDatosCRUD {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BONO_DBU");
    
    public static void insertar(TramaDatos trama){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(trama);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static boolean eliminar(TramaDatos trama){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean done = false;
        try{
            em.remove(trama);
        } catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
            return done;
        }
    }
    
    public static TramaDatos leerSingle(TramaDatos trama){
        EntityManager em = emf.createEntityManager();
        TramaDatos res = null;
        Query q = em.createQuery("SELECT t FROM TramaDatos t " + 
                                "WHERE  t.id_toma LIKE :id_toma" + 
                                " AND t.id_sensor LIKE :id_sensor")
                                .setParameter("id_toma", trama.getId_toma())
                                .setParameter("id_sensor", trama.getId_sensor());
        
        try{
            res = (TramaDatos)q.getSingleResult();
        } catch(NonUniqueResultException e){
            res = (TramaDatos)q.getResultList().get(0);
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return res;
        }
    }
    
    public static ArrayList<TramaDatos> leerMultiple(int id_s){
        //TO DO
        EntityManager em = emf.createEntityManager();
        List<TramaDatos> res = null;
        Query q = em.createQuery("SELECT t FROM TramaDatos t " + 
                                "WHERE t.id_sensor =:id "+
                                "ORDER BY t.id_toma DESC")
                                .setParameter("id", id_s);
        
        try{
            res = q.getResultList();
        }  catch (Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            ArrayList<TramaDatos> list = new ArrayList<>(res.size());
            if(res.size() > 5){
                for (int i = 0; i < 5; i++) {
                    list.add(res.get(i));
                }
            }
            else{
                list.addAll(res);
            }
            
            
            return list;
        }
        
    } 
    
    public static boolean actualizar(TramaDatos t, TramaDatos new_t){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean done = false;
        
        try{
            t = leerSingle(t);
            t = (TramaDatos)new_t.clone();
            em.merge(t);
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
