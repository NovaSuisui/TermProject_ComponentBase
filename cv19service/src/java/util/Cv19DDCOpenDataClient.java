/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:EmployeeFacadeREST
 * [model.employee]<br>
 * USAGE:
 * <pre>
 *        Cv19DDCOpenDataClient client = new Cv19DDCOpenDataClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author SK
 */
public class Cv19DDCOpenDataClient {

    private javax.ws.rs.client.WebTarget webTarget;
    private javax.ws.rs.client.Client client;
    private static final String BASE_URI = "https://covid19.ddc.moph.go.th/api/Cases/today-cases-all";

    public Cv19DDCOpenDataClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }

    public <T> T findAll_XML(Class<T> responseType) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findAll_JSON(Class<T> responseType) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
