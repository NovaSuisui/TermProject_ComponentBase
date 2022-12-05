/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.Cv19ddcController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Cv19ddc;

/**
 *
 * @author SK
 */
@WebService(serviceName = "Cv19WebService")
public class Cv19WebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "InsertAndUpdateData")
    public String InsertAndUpdateData(){
        String msg = Cv19ddcController.setData();
        return msg;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findAllData")
    public List<Cv19ddc> findAllData() {
        return Cv19ddcController.getAllData();
    }
    @WebMethod(operationName = "findDataByYear")
    public List<Cv19ddc> findDataByYear(@WebParam(name = "yearnum") int yearnum) {
        return Cv19ddcController.getDataByYear(yearnum);
    }
    @WebMethod(operationName = "findDataByYearAndWeek")
    public List<Cv19ddc> findDataByYearAndWeek(@WebParam(name = "yearnum") int yearnum, @WebParam(name = "weeknum") int weeknum) {
        return Cv19ddcController.getDataByYearAndWeek(yearnum, weeknum);
    }
}
