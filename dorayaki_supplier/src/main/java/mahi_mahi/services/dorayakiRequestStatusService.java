package mahi_mahi.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

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

public interface dorayakiRequestStatusService {
    @WebMethod
    public String testPrint();

    @WebMethod
    public void getRequestStatus(@WebParam(name = "test") String request_name);

}
