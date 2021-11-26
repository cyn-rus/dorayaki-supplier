package mahi_mahi.services;

import javax.jws.WebService;
import javax.jws.WebParam;

import java.io.*;
import java.net.*;
// import org.json.*;

@WebService(endpointInterface = "mahi_mahi.services.dorayakiRequestStatusService")

public class dorayakiRequestStatusServiceImpl implements dorayakiRequestStatusService {
    @Override
    public String testPrint() {
        System.out.println("Hello World!");
        return "hello you did it";
    }

    @Override
    public String getRequestStatus(@WebParam(name = "request_name") String request_name) {
        try {
            URL urlForGetRequest = new URL("http://localhost:8005/getStatus");
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
                return response.toString();
            } else {
                System.out.println("Unable to make GET request");
                return "Unable to make GET request";
            }
        } catch (MalformedURLException err) {
            System.out.println(err);
            return (err.toString());
        } catch (IOException err) {
            System.out.println(err);
            return (err.toString());
        }
    }
}
