
package org.me.shares;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.me.shares package. 
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

    private final static QName _Search_QNAME = new QName("http://shares.me.org/", "Search");
    private final static QName _SearchResponse_QNAME = new QName("http://shares.me.org/", "SearchResponse");
    private final static QName _ListShares_QNAME = new QName("http://shares.me.org/", "listShares");
    private final static QName _ListSharesResponse_QNAME = new QName("http://shares.me.org/", "listSharesResponse");
    private final static QName _PurchaseShares_QNAME = new QName("http://shares.me.org/", "purchaseShares");
    private final static QName _PurchaseSharesResponse_QNAME = new QName("http://shares.me.org/", "purchaseSharesResponse");
    private final static QName _UnmarshalShares_QNAME = new QName("http://shares.me.org/", "unmarshalShares");
    private final static QName _UnmarshalSharesResponse_QNAME = new QName("http://shares.me.org/", "unmarshalSharesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.me.shares
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UnmarshalSharesResponse }
     * 
     */
    public UnmarshalSharesResponse createUnmarshalSharesResponse() {
        return new UnmarshalSharesResponse();
    }

    /**
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link Shares }
     * 
     */
    public Shares createShares() {
        return new Shares();
    }

    /**
     * Create an instance of {@link Share }
     * 
     */
    public Share createShare() {
        return new Share();
    }

    /**
     * Create an instance of {@link ListShares }
     * 
     */
    public ListShares createListShares() {
        return new ListShares();
    }

    /**
     * Create an instance of {@link ListSharesResponse }
     * 
     */
    public ListSharesResponse createListSharesResponse() {
        return new ListSharesResponse();
    }

    /**
     * Create an instance of {@link PurchaseShares }
     * 
     */
    public PurchaseShares createPurchaseShares() {
        return new PurchaseShares();
    }

    /**
     * Create an instance of {@link PurchaseSharesResponse }
     * 
     */
    public PurchaseSharesResponse createPurchaseSharesResponse() {
        return new PurchaseSharesResponse();
    }

    /**
     * Create an instance of {@link UnmarshalShares }
     * 
     */
    public UnmarshalShares createUnmarshalShares() {
        return new UnmarshalShares();
    }

    /**
     * Create an instance of {@link SharePrice }
     * 
     */
    public SharePrice createSharePrice() {
        return new SharePrice();
    }

    /**
     * Create an instance of {@link UnmarshalSharesResponse.Return }
     * 
     */
    public UnmarshalSharesResponse.Return createUnmarshalSharesResponseReturn() {
        return new UnmarshalSharesResponse.Return();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "Search")
    public JAXBElement<Search> createSearch(Search value) {
        return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "SearchResponse")
    public JAXBElement<SearchResponse> createSearchResponse(SearchResponse value) {
        return new JAXBElement<SearchResponse>(_SearchResponse_QNAME, SearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "listShares")
    public JAXBElement<ListShares> createListShares(ListShares value) {
        return new JAXBElement<ListShares>(_ListShares_QNAME, ListShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListSharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "listSharesResponse")
    public JAXBElement<ListSharesResponse> createListSharesResponse(ListSharesResponse value) {
        return new JAXBElement<ListSharesResponse>(_ListSharesResponse_QNAME, ListSharesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PurchaseShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "purchaseShares")
    public JAXBElement<PurchaseShares> createPurchaseShares(PurchaseShares value) {
        return new JAXBElement<PurchaseShares>(_PurchaseShares_QNAME, PurchaseShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PurchaseSharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "purchaseSharesResponse")
    public JAXBElement<PurchaseSharesResponse> createPurchaseSharesResponse(PurchaseSharesResponse value) {
        return new JAXBElement<PurchaseSharesResponse>(_PurchaseSharesResponse_QNAME, PurchaseSharesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnmarshalShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "unmarshalShares")
    public JAXBElement<UnmarshalShares> createUnmarshalShares(UnmarshalShares value) {
        return new JAXBElement<UnmarshalShares>(_UnmarshalShares_QNAME, UnmarshalShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnmarshalSharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "unmarshalSharesResponse")
    public JAXBElement<UnmarshalSharesResponse> createUnmarshalSharesResponse(UnmarshalSharesResponse value) {
        return new JAXBElement<UnmarshalSharesResponse>(_UnmarshalSharesResponse_QNAME, UnmarshalSharesResponse.class, null, value);
    }

}
