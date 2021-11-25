package mahi_mahi.services;

import javax.jws.WebService;

import java.io.*;
import java.net.*;
import org.json.*;

@WebService(endpointInterface = "mahi_mahi.services.dorayakiRequestStatusService")

public class dorayakiRequestStatusServiceImpl implements dorayakiRequestStatusService {
    @Override
    public String testPrint() {
        System.out.println("Hello World!");
        return "hello you did it";
    }

    @Override
    public void getRequestStatus() {
        try {
            URL urlForGetRequest = new URL("http://localhost:8005/getStatus");
            String readLine = null;
            HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Accept", "application/json");

            JSONObject body = new JSONObject();
            body.put("request_name", "test");

            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            osw.write(body.toString());
            osw.flush();

            os.close();

            int responseCode = connection.getResponseCode();
            System.out.println("POST Response Code : " + responseCode);
            System.out.println("POST Response Message : " + connection.getResponseMessage());

            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
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
        } catch (Exception err) {
            System.out.println(err);
        }
    }
}
