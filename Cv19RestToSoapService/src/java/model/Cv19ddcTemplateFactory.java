/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SK
 */
public class Cv19ddcTemplateFactory {

    public static Cv19ddcTemplate Cv19ddcFactory(Cv19ddcTemplate cv, String jsn) {
        jsn = jsn.substring(2, jsn.length()-2);
        String[] jsnspl = jsn.split(",");
        String[] jsnsw;
        for(String str:jsnspl){
            System.out.println(str);
            jsnsw = str.split(":", 2);
            System.out.println(jsnsw[1]);
            switch(jsnsw[0]){
                case "\"year\"":
                    cv.setYearnum(Integer.parseInt(jsnsw[1]));
                break;
                case "\"weeknum\"":
                    cv.setWeeknum(Integer.parseInt(jsnsw[1]));
                break;
                case "\"new_case\"":
                    cv.setNewCase(Integer.parseInt(jsnsw[1]));
                break;
                case "\"total_case\"":
                    cv.setTotalCase(Integer.parseInt(jsnsw[1]));
                break;
                case "\"new_case_excludeabroad\"":
                    cv.setNewCaseExcludeabroad(Integer.parseInt(jsnsw[1]));
                break;
                case "\"total_case_excludeabroad\"":
                    cv.setTotalCaseExcludeabroad(Integer.parseInt(jsnsw[1]));
                break;
                case "\"new_recovered\"":
                    cv.setNewRecovered(Integer.parseInt(jsnsw[1]));
                break;
                case "\"total_recovered\"":
                    cv.setTotalRecovered(Integer.parseInt(jsnsw[1]));
                break;
                case "\"new_death\"":
                    cv.setNewDeath(Integer.parseInt(jsnsw[1]));
                break;
                case "\"total_death\"":
                    cv.setTotalDeath(Integer.parseInt(jsnsw[1]));
                break;
                case "\"case_foreign\"":
                    cv.setCaseForeign(Integer.parseInt(jsnsw[1]));
                break;
                case "\"case_prison\"":
                    cv.setCasePrison(Integer.parseInt(jsnsw[1]));
                break;
                case "\"case_walkin\"":
                    cv.setCaseWalkin(Integer.parseInt(jsnsw[1]));
                break;
                case "\"case_new_prev\"":
                    cv.setCaseNewPrev(Integer.parseInt(jsnsw[1]));
                break;
                case "\"case_new_diff\"":
                    cv.setCaseNewDiff(Integer.parseInt(jsnsw[1]));
                break;
                case "\"death_new_prev\"":
                    cv.setDeathNewPrev(Integer.parseInt(jsnsw[1]));
                break;
                case "\"death_new_diff\"":
                    cv.setDeathNewDiff(Integer.parseInt(jsnsw[1]));
                break;
                case "\"update_date\"":
                    jsnsw[1] = jsnsw[1].substring(1, jsnsw[1].length()-1);
                    cv.setUpdateDate(jsnsw[1]);
                break;
                default:
                    System.out.println("error on "+str);
                break;
            }            
        }
        
        return cv;
    }
}