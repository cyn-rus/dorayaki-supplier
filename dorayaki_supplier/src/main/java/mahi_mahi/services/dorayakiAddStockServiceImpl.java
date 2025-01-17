package mahi_mahi.services;

import javax.jws.WebService;
import java.io.*;
import java.net.*;
// import org.apache.http.entity.StringEntity;
// import java.util.*;
import org.json.*;

import javax.jws.WebParam;

@WebService(endpointInterface = "mahi_mahi.services.dorayakiAddStockService")
public class dorayakiAddStockServiceImpl implements dorayakiAddStockService {
    @Override
    public String testPrint() {
        System.out.println("Hello World!");
        return "hello you did it";
    }

    // @Override
    // public void getRequestLog() {
    @Override
    public int addRequest(@WebParam(name = "request_name") String request_name,
            @WebParam(name = "nama_dorayaki") String nama_dorayaki, @WebParam(name = "jumlah") int jumlah,
            @WebParam(name = "ip") String ip, @WebParam(name = "endpoint") String endpoint,
            @WebParam(name = "timestamp") String timestamp) {
        System.out.println("test");

        // commonj.sdo.DataObject smo = (commonj.sdo.DataObject)aEObject;
        // HttpClient client = new HttpClient();
        // PostMethod pm = new PostMethod("http://localhost:8080/HTTPServer/server");
        // pm.getParams().setSoTimeout(10); pm.setRequestEntity(new
        // StringRequestEntity(""+((Message)smo.get("body")).eContents().get(0),
        // "text/xml", "UTF-8"));
        // int rc = client.executeMethod(pm);
        // String response = pm.getResponseBodyAsString();
        // pm.releaseConnection();
        try {
            URL obj = new URL("http://localhost:8005/addRequest");
            HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();

            postConnection.setDoOutput(true);
            postConnection.setDoInput(true);
            postConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            postConnection.setRequestProperty("Accept", "application/json");
            postConnection.setRequestMethod("POST");

            JSONObject body = new JSONObject();
            body.put("request_name", request_name);
            body.put("nama_dorayaki", nama_dorayaki);
            body.put("jumlah", jumlah);
            body.put("status", 320);
            body.put("ip", ip);
            body.put("endpoint", endpoint);
            body.put("timestamp", timestamp);

            OutputStream os = postConnection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            osw.write(body.toString());
            osw.flush();

            os.close();

            int responseCode = postConnection.getResponseCode();
            System.out.println("POST Response Code : " + responseCode);
            System.out.println("POST Response Message : " + postConnection.getResponseMessage());

            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
                return 1;
            } else {
                System.out.println("POST NOT WORKED");
                return 0;
            }
        } catch (Exception err) {
            System.out.println(err);
            return 0;
        }
    }
}
