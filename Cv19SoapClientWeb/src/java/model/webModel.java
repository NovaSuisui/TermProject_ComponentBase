/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import serviceclient.Cv19Ddc;

/**
 *
 * @author SK
 */
public class webModel {
    public static String updateDataFromSoap(){
        serviceclient.Cv19WebService_Service service = new serviceclient.Cv19WebService_Service();
        serviceclient.Cv19WebService port = service.getCv19WebServicePort();
        return port.insertAndUpdateData();
    }
    
    public static List<Cv19Ddc> allDataFromSoap() {
        serviceclient.Cv19WebService_Service service = new serviceclient.Cv19WebService_Service();
        serviceclient.Cv19WebService port = service.getCv19WebServicePort();
        List<Cv19Ddc> l = port.findAllData();
        return l;
    }
    
    public static List<Cv19Ddc> yearDataFromSoap(int year) {
        serviceclient.Cv19WebService_Service service = new serviceclient.Cv19WebService_Service();
        serviceclient.Cv19WebService port = service.getCv19WebServicePort();
        List<Cv19Ddc> l = port.findDataByYear(year);   
        return l;
    }
    
    public static List<Cv19Ddc> yearweekDataFromSoap(int year, int week) {
        serviceclient.Cv19WebService_Service service = new serviceclient.Cv19WebService_Service();
        serviceclient.Cv19WebService port = service.getCv19WebServicePort();
        List<Cv19Ddc> l = port.findDataByYearAndWeek(year, week);   
        return l;
    }
}
