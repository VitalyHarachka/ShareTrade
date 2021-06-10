
package org.me.shares;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SharesWS", targetNamespace = "http://shares.me.org/", wsdlLocation = "http://localhost:9090/SharesWS/SharesWS?wsdl")
public class SharesWS_Service
    extends Service
{

    private final static URL SHARESWS_WSDL_LOCATION;
    private final static WebServiceException SHARESWS_EXCEPTION;
    private final static QName SHARESWS_QNAME = new QName("http://shares.me.org/", "SharesWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9090/SharesWS/SharesWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SHARESWS_WSDL_LOCATION = url;
        SHARESWS_EXCEPTION = e;
    }

    public SharesWS_Service() {
        super(__getWsdlLocation(), SHARESWS_QNAME);
    }

    public SharesWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SHARESWS_QNAME, features);
    }

    public SharesWS_Service(URL wsdlLocation) {
        super(wsdlLocation, SHARESWS_QNAME);
    }

    public SharesWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SHARESWS_QNAME, features);
    }

    public SharesWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SharesWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SharesWS
     */
    @WebEndpoint(name = "SharesWSPort")
    public SharesWS getSharesWSPort() {
        return super.getPort(new QName("http://shares.me.org/", "SharesWSPort"), SharesWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SharesWS
     */
    @WebEndpoint(name = "SharesWSPort")
    public SharesWS getSharesWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://shares.me.org/", "SharesWSPort"), SharesWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SHARESWS_EXCEPTION!= null) {
            throw SHARESWS_EXCEPTION;
        }
        return SHARESWS_WSDL_LOCATION;
    }

}
