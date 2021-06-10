/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.shares;


import SharesBind.Share;
import SharesBind.SharePrice;
import SharesBind.Shares;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;

import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 *
 * @author N0731739
 */
@WebService(serviceName = "SharesWS")
@Stateless()
public class SharesWS {

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "unmarshalShares")
    public Shares unmarshalShares() {
        
        Shares shares = new Shares();
        String file = "C:\\Users\\N0731739\\Documents\\NetBeansProjects\\ShareBroService\\sharesXML.xml";
      
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(shares.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            shares = (Shares) unmarshaller.unmarshal(new java.io.File(file)); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return shares;
    }
    
     /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "listShares")
    public List<Share> listShares() {
        
        Shares allShares = unmarshalShares();
        List<Share> List1 = allShares.getShare();
        
        Shares newList = new Shares();
        List<Share> List2 = newList.getShare();
        
        for (Share temp : List1) {
            List2.add(temp);
        }
        return List2;
    }
    

    /**
     * Web service operation
     * @param companySymbol
     * @param amount
     * @return 
     */
    @WebMethod(operationName = "purchaseShares")
    public List<Share> purchaseShares( @WebParam(name = "companySymbol") String companySymbol, @WebParam(name = "amount") int amount) {
        
        String filePath = "C:\\Users\\N0731739\\Documents\\NetBeansProjects\\ShareBroService\\sharesXML.xml";
        File XMLFile = new File(filePath);
        
        Shares shares = unmarshalShares();
        List<Share> allSharesList = shares.getShare();
        
            for (Share temp : allSharesList) {
                if (temp.getCompanySymbol().toUpperCase().equals(companySymbol.toUpperCase())) {
                    temp.setShareavAilability(temp.getShareavAilability()- amount);
                }
            }
        
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(shares.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(shares, XMLFile);
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return allSharesList;
    }

    /**
     * Web service operation
     * @param searchInput
     * @return 
     */
    @WebMethod(operationName = "Search")
    public List<Share> Search(@WebParam(name = "searchInput") String searchInput) {
        
        Shares shares = unmarshalShares();
        List<Share> List1 = shares.getShare();
        
        Shares sharesNew = new Shares();
        List<Share> List2 = sharesNew.getShare();
        
        for (Share temp : List1) {
            boolean flag = false;
            for (SharePrice temp1 : temp.getSharePrice()) {
                try {
                    if ((temp.getCompanyName().toUpperCase().contains(searchInput.toUpperCase())) || (temp.getCompanySymbol().toUpperCase().contains(searchInput.toUpperCase()))) {
                        flag = true;
                        break;
                    } else if ((temp1.getValue() < Integer.parseInt(searchInput.toUpperCase())) && (temp1.getValue() > 0)) {
                        flag = true;
                        break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    flag = false;
                }
            }
            if (flag == true) {
                List2.add(temp);
            }   
        }
        return List2;
    }

    /**
     * Web service operation
     * @param companyName
     * @param companySymbol
     * @param shareavAilability
     * @param currency
     * @param sharePrice
     * @return 
     */
    @WebMethod(operationName = "sellShares")
    public List sellShares(
            @WebParam(name = "companyName") String companyName, 
            @WebParam(name = "companySymbol") String companySymbol, 
            @WebParam(name = "shareavAilability") int shareavAilability, 
            @WebParam(name = "currency") String currency, 
            @WebParam(name = "sharePrice") float sharePrice) {
        
        String filePath = "C:\\Users\\N0731739\\Documents\\NetBeansProjects\\ShareBroService\\sharesXML.xml";
        File XMLFile = new File(filePath);
        Shares shares = unmarshalShares();
        List<Share> allSharesList = shares.getShare();
        
        Share newS = new Share();
        newS.setCompanyName(companyName);
        newS.setCompanySymbol(companySymbol);
        newS.setShareavAilability(shareavAilability);
        
        SharePrice newSP = new SharePrice();
        newSP.setCurrency(currency);
        newSP.setValue(sharePrice);
         try{
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            newSP.setLastUpdate(xmlDate);
        }catch(Exception e){
            
        }
        newS.getSharePrice().add(newSP);
        allSharesList.add(newS);
        
        
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(shares.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(shares, XMLFile);
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        
        return allSharesList;
    }



    


  

        
        
        

}
