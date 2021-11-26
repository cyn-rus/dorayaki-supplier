package mahi_mahi.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.WebParam;

// import org.apache.http.*;
// import org.apache.http.client.ClientProtocolException;
// import org.apache.http.client.config.RequestConfig;
// import org.apache.http.client.entity.UrlEncodedFormEntity;
// import org.apache.http.client.methods.*;
// import org.apache.http.entity.ContentType;
// import org.apache.http.entity.InputStreamEntity;
// import org.apache.http.impl.client.CloseableHttpClient;
// import org.apache.http.impl.client.HttpClients;
// import org.apache.http.message.BasicNameValuePair;

@WebService
@SOAPBinding(style = Style.DOCUMENT)

public interface dorayakiAddStockService {
    @WebMethod
    public String testPrint();

    @WebMethod
    public int addRequest(@WebParam(name = "request_name") String request_name,
            @WebParam(name = "nama_dorayaki") String nama_dorayaki, @WebParam(name = "jumlah") int jumlah,
            @WebParam(name = "ip") String ip, @WebParam(name = "endpoint") String endpoint,
            @WebParam(name = "timestamp") String timestamp);
}
