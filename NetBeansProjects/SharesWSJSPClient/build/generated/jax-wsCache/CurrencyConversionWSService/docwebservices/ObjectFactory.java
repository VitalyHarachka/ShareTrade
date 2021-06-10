
package docwebservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the docwebservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetConversionRate_QNAME = new QName("http://DOCwebServices/", "GetConversionRate");
    private final static QName _GetConversionRateResponse_QNAME = new QName("http://DOCwebServices/", "GetConversionRateResponse");
    private final static QName _GetCurrencyCodes_QNAME = new QName("http://DOCwebServices/", "GetCurrencyCodes");
    private final static QName _GetCurrencyCodesResponse_QNAME = new QName("http://DOCwebServices/", "GetCurrencyCodesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: docwebservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetConversionRate }
     * 
     */
    public GetConversionRate createGetConversionRate() {
        return new GetConversionRate();
    }

    /**
     * Create an instance of {@link GetConversionRateResponse }
     * 
     */
    public GetConversionRateResponse createGetConversionRateResponse() {
        return new GetConversionRateResponse();
    }

    /**
     * Create an instance of {@link GetCurrencyCodes }
     * 
     */
    public GetCurrencyCodes createGetCurrencyCodes() {
        return new GetCurrencyCodes();
    }

    /**
     * Create an instance of {@link GetCurrencyCodesResponse }
     * 
     */
    public GetCurrencyCodesResponse createGetCurrencyCodesResponse() {
        return new GetCurrencyCodesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConversionRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://DOCwebServices/", name = "GetConversionRate")
    public JAXBElement<GetConversionRate> createGetConversionRate(GetConversionRate value) {
        return new JAXBElement<GetConversionRate>(_GetConversionRate_QNAME, GetConversionRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConversionRateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://DOCwebServices/", name = "GetConversionRateResponse")
    public JAXBElement<GetConversionRateResponse> createGetConversionRateResponse(GetConversionRateResponse value) {
        return new JAXBElement<GetConversionRateResponse>(_GetConversionRateResponse_QNAME, GetConversionRateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyCodes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://DOCwebServices/", name = "GetCurrencyCodes")
    public JAXBElement<GetCurrencyCodes> createGetCurrencyCodes(GetCurrencyCodes value) {
        return new JAXBElement<GetCurrencyCodes>(_GetCurrencyCodes_QNAME, GetCurrencyCodes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyCodesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://DOCwebServices/", name = "GetCurrencyCodesResponse")
    public JAXBElement<GetCurrencyCodesResponse> createGetCurrencyCodesResponse(GetCurrencyCodesResponse value) {
        return new JAXBElement<GetCurrencyCodesResponse>(_GetCurrencyCodesResponse_QNAME, GetCurrencyCodesResponse.class, null, value);
    }

}
