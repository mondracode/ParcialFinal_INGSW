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
public class SensorCRUD {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BONO_DBU");

    public static boolean insertar(Sensor sensor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(sensor);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return true;
        }
    }

    public static boolean eliminar(Sensor sensor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean done = false;
        try {
            em.remove(sensor);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return done;
        }
    }

    public static Sensor leerSingle(Sensor sensor) {
        EntityManager em = emf.createEntityManager();
        Sensor res = null;
        Query q = em
                .createQuery(
                        "SELECT t FROM Sensor t " + "WHERE  t.id_toma LIKE :tipo" + " AND t.id_sensor LIKE :nombre")
                .setParameter("tipo", sensor.getTipo()).setParameter("nombre", sensor.getNombre());

        try {
            res = (Sensor) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            res = (Sensor) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return res;
        }
    }

    public static Sensor buscarSensor(int id_s) {
        EntityManager em = emf.createEntityManager();
        Sensor res = null;
        Query q = em.createQuery("SELECT t FROM Sensor t " + "WHERE t.id_sensor = :id").setParameter("id", id_s);

        try {
            res = (Sensor) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            res = (Sensor) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return res;
        }
    }

    public static ArrayList<Sensor> leerMultiple() {
        // TO DO
        return null;
    }

    public static boolean actualizarPromedio(int id_s, boolean p) {
        Sensor s = buscarSensor(id_s);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean done = false;

        try {
            s.setPromedio(p);
            em.merge(s);
            em.getTransaction().commit();
            done = true;

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return done;
        }
    }
    
    public static boolean actualizarHoras(int id_s, int h) {
        Sensor s = buscarSensor(id_s);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean done = false;

        try {
            s.setNum_horas(h);
            em.merge(s);
            em.getTransaction().commit();
            done = true;

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return done;
        }
    }
}
