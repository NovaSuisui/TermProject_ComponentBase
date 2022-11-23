/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author SK
 */
public class Cv19ddcTable {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CV19ServicePU");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public boolean insertData(Cv19ddc cv) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CV19ServicePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Insert data...");
        System.out.println("Data : "+cv.getId());
        boolean status = false;
        try {
            em.persist(cv);
            em.getTransaction().commit();
            System.out.println("Insert Complete!!");
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Insert Incomplete");
            status = false;
        } finally {
            em.close();
            return status;
        }
    }
    public void updateData(Cv19ddc cv) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CV19ServicePU");
        EntityManager em = emf.createEntityManager();
        Cv19ddc fromDb = em.find(Cv19ddc.class, cv.getId());
        
        fromDb.setYearnum(cv.getYearnum());
        fromDb.setWeeknum(cv.getWeeknum());
        fromDb.setNewCase(cv.getNewCase());
        fromDb.setTotalCase(cv.getTotalCase());
        fromDb.setNewCaseExcludeabroad(cv.getNewCaseExcludeabroad());
        fromDb.setTotalCaseExcludeabroad(cv.getTotalCaseExcludeabroad());
        fromDb.setNewRecovered(cv.getNewRecovered());
        fromDb.setTotalRecovered(cv.getTotalRecovered());
        fromDb.setNewDeath(cv.getTotalDeath());
        fromDb.setCaseForeign(cv.getCaseForeign());
        fromDb.setCasePrison(cv.getCasePrison());
        fromDb.setCaseWalkin(cv.getCaseWalkin());
        fromDb.setCaseNewPrev(cv.getCaseNewPrev());
        fromDb.setCaseNewDiff(cv.getCaseNewDiff());
        fromDb.setDeathNewPrev(cv.getDeathNewPrev());
        fromDb.setDeathNewDiff(cv.getDeathNewDiff());
        fromDb.setUpdateDate(cv.getUpdateDate());
        
        em.getTransaction().begin();
        System.out.println("Updat data...");
        System.out.println("Data : "+cv.getId());
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
            System.out.println("Update Complete!!");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Update Incomplete");
        } finally {
            em.close();
        }
    }
    public Cv19ddc findDataById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CV19ServicePU");
        EntityManager em = emf.createEntityManager();
        Cv19ddc cv = em.find(Cv19ddc.class, id);
        em.close();
        return cv;
    }
    public List<Cv19ddc> findAllData() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CV19ServicePU");
        EntityManager em = emf.createEntityManager();
        List<Cv19ddc> cvList = (List<Cv19ddc>) em.createNamedQuery("Student.findAll").getResultList();
        em.close();
        return cvList;
    }
    public List<Cv19ddc> findDataByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CV19ServicePU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Student.findByName");
        query.setParameter("name", name);
        List<Cv19ddc> cvList = (List<Cv19ddc>) query.getResultList();
        em.close();
        return cvList;
    }
    public void removeData(Cv19ddc cv) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CV19ServicePU");
        EntityManager em = emf.createEntityManager();
        Cv19ddc fromDb = em.find(Cv19ddc.class, cv.getId());
        em.getTransaction().begin();
        System.out.println("Remove data...");
        System.out.println("Data : "+cv.getId());
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
            System.out.println("Remove Complete!!");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Remove Inomplete");
        } finally {
            em.close();
        }           
    }
    public void removeAllData(){
        List<Cv19ddc> cv = findAllData();
        for(Cv19ddc obj : cv){
            removeData(obj);
        }
    }
}
