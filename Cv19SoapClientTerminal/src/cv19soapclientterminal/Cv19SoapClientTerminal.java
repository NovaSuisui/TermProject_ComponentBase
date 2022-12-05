/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv19soapclientterminal;

import java.util.List;
import serviceclient.Cv19Ddc;

/**
 *
 * @author SK
 */
public class Cv19SoapClientTerminal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        serviceclient.Cv19WebService_Service service = new serviceclient.Cv19WebService_Service();
        serviceclient.Cv19WebService port = service.getCv19WebServicePort();
        List<Cv19Ddc> l = port.findAllData();
        listDataToString(l);
        l = port.findDataByYear(2022);
        listDataToString(l);
        l = port.findDataByYearAndWeek(2022, 47);
        listDataToString(l);
    }
    
    public static void dataToString(Cv19Ddc cv){
        System.out.println( "year : " + cv.getCv19DdcPK().getYearnum() );
        System.out.println( cv.getCv19DdcPK().getWeeknum() );
        System.out.println( cv.getNewCase() );
        System.out.println( cv.getTotalCase() );
        System.out.println( cv.getNewCaseExcludeabroad() );
        System.out.println( cv.getTotalCaseExcludeabroad() );
        System.out.println( cv.getNewRecovered() );
        System.out.println( cv.getTotalRecovered() );
        System.out.println( cv.getNewDeath() );
        System.out.println( cv.getTotalDeath() );
        System.out.println( cv.getCaseForeign() );
        System.out.println( cv.getCasePrison() );
        System.out.println( cv.getCaseWalkin() );
        System.out.println( cv.getCaseNewPrev() );
        System.out.println( cv.getCaseNewDiff() );
        System.out.println( cv.getDeathNewPrev() );
        System.out.println( cv.getDeathNewDiff() );
        System.out.println( cv.getUpdateDate().toGregorianCalendar().getTime() );
    }
    
    public static void listDataToString(List<Cv19Ddc> l){
        for(Cv19Ddc obj : l)
            dataToString(obj);
    }
}
