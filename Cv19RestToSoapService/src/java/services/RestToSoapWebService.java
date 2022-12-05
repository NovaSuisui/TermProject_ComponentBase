/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.Cv19ddcManager;
import java.text.ParseException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Cv19ddcTemplate;

/**
 *
 * @author SK
 */
@WebService(serviceName = "RestToSoapWebService")
public class RestToSoapWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    /**
     * Web service operation
     * @return 
     * @throws java.text.ParseException 
     */
    @WebMethod(operationName = "getDDCData")
    public Cv19ddcTemplate getDDCData() throws ParseException {
        return Cv19ddcManager.getData();
    }
}
