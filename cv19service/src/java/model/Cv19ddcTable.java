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
    /*private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv19servicePU");

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
    }*/
    
    public boolean insertData(Cv19ddc cv) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv19servicePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Insert data...");
        System.out.println("Data : "+cv.getCv19ddcPK().toString());
        boolean status = false;
        try {
            em.persist(cv);
            em.getTransaction().commit();
            System.out.println("Insert Complete!!");
            status = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
            System.out.println("Insert Incomplete");
            status = false;
        } finally {
            em.close();
            return status;
        }
    }
    public boolean updateData(Cv19ddc cv) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv19servicePU");
        EntityManager em = emf.createEntityManager();
        Cv19ddc fromDb = em.find(Cv19ddc.class, cv.getCv19ddcPK());
        
        fromDb.setCv19ddcPK(cv.getCv19ddcPK());
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
        System.out.println("Data : "+cv.getCv19ddcPK().toString());
        boolean status = false;
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
            System.out.println("Update Complete!!");
            status = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
            System.out.println("Update Incomplete");
            status = false;
        } finally {
            em.close();
            return status;
        }
    }
    public Cv19ddc findDataById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv19servicePU");
        EntityManager em = emf.createEntityManager();
        Cv19ddc cv = em.find(Cv19ddc.class, id);
        em.close();
        return cv;
    }
    public List<Cv19ddc> findAllData() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv19servicePU");
        EntityManager em = emf.createEntityManager();
        List<Cv19ddc> cvList = (List<Cv19ddc>) em.createNamedQuery("Cv19ddc.findAll").getResultList();
        em.close();
        return cvList;
    }
    public List<Cv19ddc> findDataByYear(int yearnum) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv19servicePU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Cv19ddc.findByYearnum");
        query.setParameter("yearnum", yearnum);
        List<Cv19ddc> cvList = (List<Cv19ddc>) query.getResultList();
        em.close();
        return cvList;
    }
    public List<Cv19ddc> findDataByYearAndWeek(int yearnum, int weeknum) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv19servicePU");
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT c FROM Cv19ddc c WHERE c.cv19ddcPK.yearnum = :yearnum AND c.cv19ddcPK.weeknum = :weeknum";
        Query query = em.createQuery(jpql);
        query.setParameter("yearnum", yearnum);
        query.setParameter("weeknum", weeknum);
        List<Cv19ddc> cvList = (List<Cv19ddc>) query.getResultList();
        em.close();
        return cvList;
    }
    public void removeData(Cv19ddc cv) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv19servicePU");
        EntityManager em = emf.createEntityManager();
        Cv19ddc fromDb = em.find(Cv19ddc.class, cv.getCv19ddcPK());
        em.getTransaction().begin();
        System.out.println("Remove data...");
        System.out.println("Data : "+cv.getCv19ddcPK().toString());
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
            System.out.println("Remove Complete!!");
        } catch (Exception e) {
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