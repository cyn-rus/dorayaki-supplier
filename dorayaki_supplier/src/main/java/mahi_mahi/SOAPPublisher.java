package mahi_mahi;

import javax.xml.ws.Endpoint;

// import mahi_mahi.services.CheeseServiceImpl;
import mahi_mahi.services.dorayakiVariantListServiceImpl;
import mahi_mahi.services.dorayakiAddStockServiceImpl;
import mahi_mahi.services.dorayakiRequestStatusServiceImpl;

public class SOAPPublisher
{
    public static void main( String[] args )
    {
        // Endpoint.publish("https://localhost:9999/dorayaki_supplier/cheese", new CheeseServiceImpl());
        Endpoint.publish("http://localhost:9999/dorayaki_supplier/dorayakiVariantList", new dorayakiVariantListServiceImpl());
        Endpoint.publish("http://localhost:9999/dorayaki_supplier/dorayakiAddStock", new dorayakiAddStockServiceImpl());
        Endpoint.publish("http://localhost:9999/dorayaki_supplier/dorayakiRequestStatus", new dorayakiRequestStatusServiceImpl());
    }
}
