package mahi_mahi.services;

import javax.jws.WebService;

@WebService(endpointInterface = "mahi_mahi.services.dorayakiVariantListService")
public class dorayakiVariantListServiceImpl implements dorayakiVariantListService
{
    @Override
    public String testPrint()
    {
        System.out.println( "Hello World!" );
        return "hello you did it";
    }
}
