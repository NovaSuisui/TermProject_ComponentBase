/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import services.Cv19DdcTemplate;

/**
 *
 * @author SK
 */
public class Cv19ddcFactory {

    public static Cv19ddc Cv19ddcFactory(Cv19ddc cv, Cv19DdcTemplate cvs) throws ParseException {
        Cv19ddcPK cvPK = new Cv19ddcPK();
        cvPK.setYearnum(cvs.getYearnum());
        cvPK.setWeeknum(cvs.getWeeknum());
        cv.setCv19ddcPK(cvPK);
        cv.setNewCase(cvs.getNewCase());
        cv.setTotalCase(cvs.getTotalCase());
        cv.setNewCaseExcludeabroad(cvs.getNewCaseExcludeabroad());
        cv.setTotalCaseExcludeabroad(cvs.getTotalCaseExcludeabroad());
        cv.setNewRecovered(cvs.getNewRecovered());
        cv.setTotalRecovered(cvs.getTotalRecovered());
        cv.setNewDeath(cvs.getNewDeath());
        cv.setTotalDeath(cvs.getTotalDeath());
        cv.setCaseForeign(cvs.getCaseForeign());
        cv.setCasePrison(cvs.getCasePrison());
        cv.setCaseWalkin(cvs.getCaseWalkin());
        cv.setCaseNewPrev(cvs.getCaseNewPrev());
        cv.setCaseNewDiff(cvs.getCaseNewDiff());
        cv.setDeathNewPrev(cvs.getDeathNewPrev());
        cv.setDeathNewDiff(cvs.getDeathNewDiff());
        cv.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(cvs.getUpdateDate()));
        return cv;
    }
}