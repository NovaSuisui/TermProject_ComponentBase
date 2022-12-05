/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cv19ddcTemplate;
import static model.Cv19ddcTemplateFactory.Cv19ddcFactory;
import util.Cv19DDCOpenDataClient;

/**
 *
 * @author SK
 */
public class Cv19ddcManager {
    public static Cv19ddcTemplate getData() {
        Cv19ddcTemplate cv = new Cv19ddcTemplate();
        Cv19DDCOpenDataClient sv = new Cv19DDCOpenDataClient();
        String jsn = sv.findAll_JSON(String.class);
        System.out.println(jsn);
        cv = Cv19ddcFactory(cv, jsn);
        return cv;
    }
}