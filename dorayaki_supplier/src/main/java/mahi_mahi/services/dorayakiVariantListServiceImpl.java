package mahi_mahi.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.*;

// import com.sohnny.httpclient.sdk.MyResponseHandler;

import org.apache.http.*;
// import org.apache.http.client.*;
// import org.apache.http.client.ClientProtocolException;
// import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
// import org.apache.http.client.config.RequestConfig;
// import org.apache.http.client.entity.UrlEncodedFormEntity;
// import org.apache.http.client.methods.*;
// import org.apache.http.entity.ContentType;
// import org.apache.http.entity.InputStreamEntity;
// import org.apache.http.impl.client.CloseableHttpClient;
// import org.apache.http.impl.client.HttpClients;
// import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
// import org.apache.http.HttpEntity;
// import org.apache.http.HttpResponse;
// import org.apache.http.client.ResponseHandler;
// import org.apache.http.client.methods.HttpGet;
// import org.apache.http.impl.client.CloseableHttpClient;
// import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

// import org.json.*;

class MyResponseHandler implements ResponseHandler<String> {

    public String handleResponse(final HttpResponse response) throws IOException {
        int status = response.getStatusLine().getStatusCode();
        if (status >= 200 && status < 300) {
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return "";
            } else {
                return EntityUtils.toString(entity);
            }
        } else {
            return "" + status;
        }
    }
}

@WebService(endpointInterface = "mahi_mahi.services.dorayakiVariantListService")
public class dorayakiVariantListServiceImpl implements dorayakiVariantListService {
    @WebMethod
    public String hello(@WebParam(name = "name") String name) {
        return "Hello " + name + "!";
    }

    @Override
    public String testPrint() {
        System.out.println("Hello World!");
        return "hello you did it";
    }

    @Override
    public void getVariantList() {
        try {
            URL urlForGetRequest = new URL("http://localhost:8005/getResepNames");
            String readLine = null;
            HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer response = new StringBuffer();
                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }
                in.close();

                System.out.println(response.toString());
            } else {
                System.out.println("Unable to make GET request");
            }
        } catch (MalformedURLException err) {
            System.out.println(err);
        } catch (IOException err) {
            System.out.println(err);
        }
    }

    // public static void main(String[] args) {
    // dorayakiVarianListServiceImpl dorayakivariantservice = new
    // dorayakiVariantListServiceImpl();

    // dorayakivariantservice.getVariantList();
    // }
}

// String jsonString = ... ; //assign your JSON String here
// JSONObject obj = new JSONObject(jsonString);
// String pageName = obj.getJSONObject("pageInfo").getString("pageName");

// JSONArray arr = obj.getJSONArray("posts"); // notice that `"posts": [...]`
// for (int i = 0; i < arr.length(); i++)
// {
// String post_id = arr.getJSONObject(i).getString("post_id");
// ......
// }