/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import model.Cv19ddc;
import static model.Cv19ddcFactory.Cv19ddcFactory;
import model.Cv19ddcTable;
import util.Cv19DDCOpenDataClient;

/**
 *
 * @author SK
 */
public class Cv19ddcManager {
    public static void setData() throws ParseException{
        Cv19ddc cv = new Cv19ddc();
        Cv19DDCOpenDataClient sv = new Cv19DDCOpenDataClient();
        String jsn = sv.findAll_JSON(String.class);
        System.out.println(jsn);
        cv = Cv19ddcFactory(cv, jsn);
        Cv19ddcTable cvt = new Cv19ddcTable();
        if(!cvt.insertData(cv))
            cvt.updateData(cv);
    }
    public static void getData(){
        
    }
}
