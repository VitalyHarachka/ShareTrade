/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharebroservice;



import SharesBind.Share;
import SharesBind.Shares;
import SharesBind.SharePrice;        

        
import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
   

/**
 *
 * @author N0731739
 */
public class ShareBroService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        File XMLFile = new File("sharesXML.xml");
        
        
        
        Shares shares = new Shares();
        List<Share> allShares = shares.getShare();
        Share share;
        SharePrice sharePrice;
       
        
        
        
        //Tesla share
        share = new Share();
        sharePrice = new SharePrice();
        share.setCompanyName("Tesla");
        share.setCompanySymbol("TSLA");
        share.setShareavAilability(7147);
      
        sharePrice.setCurrency("GBP");
        sharePrice.setValue((float) 419.32);
        try{
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            sharePrice.setLastUpdate(xmlDate);
        }catch(Exception e){
            System.out.println(e);
        }
        share.getSharePrice().add(sharePrice);
        allShares.add(share);
        
         //Adds Apple share
        share = new Share();
        share.setCompanyName("Apple");
        share.setCompanySymbol("AAPL");
        share.setShareavAilability(6687);
        sharePrice = new SharePrice();
        sharePrice.setCurrency("GBP");
        sharePrice.setValue((float) 242.56);
        try{
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            sharePrice.setLastUpdate(xmlDate);
        }catch(Exception e){
            System.out.println(e);
        }
        
        share.getSharePrice().add(sharePrice);
        allShares.add(share);
        
        //Adds Netflix share
        share = new Share();
        share.setCompanyName("Netflix");
        share.setCompanySymbol("NFLX");
        share.setShareavAilability(7000);
        sharePrice = new SharePrice();
        sharePrice.setCurrency("GBP");
        sharePrice.setValue((float) 259.09);
        try{
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            sharePrice.setLastUpdate(xmlDate);
        }catch(Exception e){
            System.out.println(e);
        }
        share.getSharePrice().add(sharePrice);
        allShares.add(share);
        
        //Adds Microsoft share
        share = new Share();
        share.setCompanyName("Microsoft");
        share.setCompanySymbol("MSFT");
        share.setShareavAilability(6195);
        sharePrice = new SharePrice();
        sharePrice.setCurrency("GBP");
        sharePrice.setValue((float) 127.59);
        try{
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            sharePrice.setLastUpdate(xmlDate);
        }catch(DatatypeConfigurationException e){
            System.out.println(e);
        }
        share.getSharePrice().add(sharePrice);
        allShares.add(share);
        
        //Adds Volkswagen share
        share = new Share();
        share.setCompanyName("Volkswagen");
        share.setCompanySymbol("VOW3");
        share.setShareavAilability(8638);
        sharePrice = new SharePrice();
        sharePrice.setCurrency("GBP");
        sharePrice.setValue((float) 138.93);
        try{
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            sharePrice.setLastUpdate(xmlDate);
        }catch(DatatypeConfigurationException e){
            System.out.println(e);
        }
        share.getSharePrice().add(sharePrice);
        allShares.add(share);
        
        
        
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
        
    }
    
}
