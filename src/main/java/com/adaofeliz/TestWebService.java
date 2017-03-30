package com.adaofeliz;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;

public class TestWebService {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try
        {
            String endPoint="http://www.webxml.com.cn/WebServices/IpAddressSearchWebService.asmx";
            Service service = new Service();
            Call call = (Call)service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(endPoint));
            call.setUseSOAPAction(true);
            call.setSOAPActionURI("http://WebXml.com.cn/getCountryCityByIp");
            call.setOperationName("getCountryCityByIp");
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);

            call.addParameter(new QName("ip"), //设置要传递的参数
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);

            String str=(String)call.invoke( new Object[]{"北京"});
            System.out.println(str);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}