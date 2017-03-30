package com.adaofeliz;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**
 * Created by jimmy on 2017/3/8.
 */
public class Test {
    public static void main(String[] args) {
        try
        {
            String endPoint="http://www.webxml.com.cn/WebServices/IpAddressSearchWebService.asmx";
            Service service = new Service();
            Call call = (Call)service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(endPoint));
            call.setUseSOAPAction(true);
            call.setSOAPActionURI("http://WebXml.com.cn/getVersionTime");
            call.setOperationName("getVersionTime");
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
            String str=(String)call.invoke( new Object[]{});
            System.out.println(str);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
