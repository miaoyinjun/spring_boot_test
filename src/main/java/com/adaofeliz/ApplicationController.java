package com.adaofeliz;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.xml.namespace.QName;

/**
 * Created on 19/11/14.
 */

@Controller
@EnableWebMvc
@EnableAutoConfiguration
public class ApplicationController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationController.class, args);
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {

//        URL url = new URL("http://wddcsdbws85:81/scs.ws/icfg4_lips/LOTService.asmx");
//        URLConnection urlcon = url.openConnection();
//        InputStream is = urlcon.getInputStream();
//        BufferedReader in = new BufferedReader(new InputStreamReader(
//                urlcon.getInputStream()));
//        String line;
//        String result = "1";
//        while ((line = in.readLine()) != null) {
//            result += line;
//        }
        return test();
//        return HttpRequest.sendGet("http://wddcsdbws85:81/scs.ws/icfg4_lips/LOTService.asmx", null);
//        return "Hello World: Spring-boot Sample Application using Maven";
    }


    public static String test() {
// TODO Auto-generated method stub
        String str = "";
        System.out.println("Start invoking....");
        try {
            String endPoint = "http://wddcsdbws85:81/scs.ws/icfg4_lips/LOTService.asmx";
            String soapaction = "http://scs.mkcorp.com/services/1.0/LOT";
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(endPoint));
            call.setOperation("GetMessage");
            call.setUseSOAPAction(true);
            call.setSOAPActionURI("");
            call.setOperationName(new QName(soapaction, "GetMessage"));
            call.addParameter(new QName(soapaction, "messageId"), org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
            str = (String) call.invoke(new Object[]{"1"});
        } catch (Exception e) {
            str = e.getMessage();
            e.printStackTrace();
        }
        return str;

    }
}
