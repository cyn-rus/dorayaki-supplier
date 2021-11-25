package mahi_mahi.services;

import javax.jws.WebService;

@WebService(endpointInterface = "mahi_mahi.services.dorayakiRequestStatusService")

public class dorayakiRequestStatusServiceImpl implements dorayakiRequestStatusService{
    @Override
    public String testPrint()
    {
        System.out.println( "Hello World!" );
        return "hello you did it";
    }
}
