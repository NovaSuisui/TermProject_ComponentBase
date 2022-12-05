/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.table.DefaultTableModel;
import model.appModel;
import view.dataTable;

/**
 *
 * @author SK
 */
public class appController {
    private dataTable dt = new dataTable();
    public String updateData(){
        return appModel.updateDataFromSoap();
    }
    public void findAllData(){
        dt.setTable(appModel.allDataFromSoap());
        dt.setVisible(true);
    }
    public void findDataByYear(String s_year){
        int year = Integer.parseInt(s_year);
        dt.setTable(appModel.yearDataFromSoap(year));
        dt.setVisible(true);
    }
    public void findDataByYearAndWeek(String s_year, String s_week){
        int year = Integer.parseInt(s_year);
        int week = Integer.parseInt(s_week);
        dt.setTable(appModel.yearweekDataFromSoap(year, week));
        dt.setVisible(true);
    }
}
