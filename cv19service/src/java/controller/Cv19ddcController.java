/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.util.List;
import model.Cv19ddc;
import model.Cv19ddcFactory;
import model.Cv19ddcTable;
import services.Cv19DdcTemplate;
import services.ParseException_Exception;

/**
 *
 * @author SK
 */
public class Cv19ddcController {
    public static String setData() throws ParseException, ParseException_Exception{
        Cv19ddc cv = new Cv19ddc();
        cv = Cv19ddcFactory.Cv19ddcFactory(cv, dataFromSoap());
        Cv19ddcTable cvt = new Cv19ddcTable();
        boolean ins = cvt.insertData(cv);
        if(ins)
            return "insert";
        else{
            ins = cvt.updateData(cv);
            if(ins)
                return "update";
            else
                return "error";
        }
    }
    
    public static List<Cv19ddc> getAllData(){
        Cv19ddcTable cvt = new Cv19ddcTable();
        return cvt.findAllData();
    }
    
    public static List<Cv19ddc> getDataByYear(int yearnum){
        Cv19ddcTable cvt = new Cv19ddcTable();
        return cvt.findDataByYear(yearnum);
    }
    
    public static List<Cv19ddc> getDataByYearAndWeek(int yearnum, int weeknum){
        Cv19ddcTable cvt = new Cv19ddcTable();
        return cvt.findDataByYearAndWeek(yearnum, weeknum);
    }
    
    private static Cv19DdcTemplate dataFromSoap() throws ParseException_Exception {
        services.RestToSoapWebService_Service service = new services.RestToSoapWebService_Service();
        services.RestToSoapWebService port = service.getRestToSoapWebServicePort();
        return port.getDDCData();
    }
}