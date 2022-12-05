/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import serviceclient.Cv19Ddc;

/**
 *
 * @author SK
 */
public class appModel {
    private static final String column[] = {"Year", "Week", "new_case", "total_case", "new_case_excludeabroad", "total_case_excludeabroad",
            "new_recovered", "total_recovered", "new_death", "total_death", "case_foreign", "case_prison", "case_walkin",
            "case_new_prev", "case_new_diff", "death_new_prev", "death_new_diff", "update_date"};
    private static String year, week, new_case, total_case, new_case_excludeabroad, total_case_excludeabroad,
            new_recovered, total_recovered, new_death, total_death, case_foreign, case_prison, case_walkin,
            case_new_prev, case_new_diff, death_new_prev, death_new_diff, update_date;
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    public static String updateDataFromSoap(){
        serviceclient.Cv19WebService_Service service = new serviceclient.Cv19WebService_Service();
        serviceclient.Cv19WebService port = service.getCv19WebServicePort();
        return port.insertAndUpdateData();
    }
    
    public static DefaultTableModel allDataFromSoap() {
        serviceclient.Cv19WebService_Service service = new serviceclient.Cv19WebService_Service();
        serviceclient.Cv19WebService port = service.getCv19WebServicePort();
        List<Cv19Ddc> l = port.findAllData();
        return setDataModel(l);
    }
    
    public static DefaultTableModel yearDataFromSoap(int year) {
        serviceclient.Cv19WebService_Service service = new serviceclient.Cv19WebService_Service();
        serviceclient.Cv19WebService port = service.getCv19WebServicePort();
        List<Cv19Ddc> l = port.findDataByYear(year);   
        return setDataModel(l);
    }
    
    public static DefaultTableModel yearweekDataFromSoap(int year, int week) {
        serviceclient.Cv19WebService_Service service = new serviceclient.Cv19WebService_Service();
        serviceclient.Cv19WebService port = service.getCv19WebServicePort();
        List<Cv19Ddc> l = port.findDataByYearAndWeek(year, week);   
        return setDataModel(l);
    }
    
    private static DefaultTableModel setDataModel(List<Cv19Ddc> l){
        DefaultTableModel modelTable = new DefaultTableModel(column, 0);
        for(Cv19Ddc obj : l){
            year = String.valueOf( obj.getCv19DdcPK().getYearnum() );
            week = String.valueOf( obj.getCv19DdcPK().getWeeknum() );
            new_case = String.valueOf( obj.getNewCase() );
            total_case = String.valueOf( obj.getTotalCase() );
            new_case_excludeabroad = String.valueOf( obj.getNewCaseExcludeabroad() );
            total_case_excludeabroad = String.valueOf( obj.getTotalCaseExcludeabroad() );
            new_recovered = String.valueOf( obj.getNewRecovered() );
            total_recovered = String.valueOf( obj.getTotalRecovered() );
            new_death = String.valueOf( obj.getNewDeath() );
            total_death = String.valueOf( obj.getTotalDeath() );
            case_foreign = String.valueOf( obj.getCaseForeign() );
            case_prison = String.valueOf( obj.getCasePrison() );
            case_walkin = String.valueOf( obj.getCaseWalkin() );
            case_new_prev = String.valueOf( obj.getCaseNewPrev() );
            case_new_diff = String.valueOf( obj.getCaseNewDiff() );
            death_new_prev = String.valueOf( obj.getDeathNewPrev() );
            death_new_diff = String.valueOf( obj.getDeathNewDiff() );
            update_date = formatter.format( obj.getUpdateDate().toGregorianCalendar().getTime() );
            String[] row = {year, week, new_case, total_case, new_case_excludeabroad, total_case_excludeabroad,
            new_recovered, total_recovered, new_death, total_death, case_foreign, case_prison, case_walkin,
            case_new_prev, case_new_diff, death_new_prev, death_new_diff, update_date};
            modelTable.addRow(row);
        }
        return modelTable;
    }
}
