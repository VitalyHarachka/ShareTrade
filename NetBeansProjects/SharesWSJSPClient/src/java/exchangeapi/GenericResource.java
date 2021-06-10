/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exchangeapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author N0731739
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of exchangeapi.GenericResource
     * @return an instance of java.lang.Double
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Double getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(Double content) {
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String UpdatedExchange(@QueryParam("symbol")String coSymbol) throws IOException{
        
        String val ="";
        
        try{
            URL url = new URL("https://api.exchangeratesapi.io/latest?base=" + coSymbol + "&symbols=GBP");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() !=200){
               throw new IOException(conn.getResponseMessage());
            }
        
            BufferedReader Br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inString;
            StringBuilder stringB = new StringBuilder();
            while ((inString = Br.readLine()) != null){
                stringB.append(inString);
            }
            String newS = stringB.toString();
        
            val = newS.replaceAll("[^0-9\\.]", "");
        
        
        } catch(MalformedURLException e){
    
        }
        return val;
    }
    
}
