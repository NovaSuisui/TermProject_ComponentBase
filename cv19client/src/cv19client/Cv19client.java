/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv19client;

/**
 *
 * @author Dylan
 */
public class Cv19client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(hello("s"));
    }

    private static String hello(java.lang.String name) {
        services.Cv19WebServices_Service service = new services.Cv19WebServices_Service();
        services.Cv19WebServices port = service.getCv19WebServicesPort();
        return port.hello(name);
    }
    
}
