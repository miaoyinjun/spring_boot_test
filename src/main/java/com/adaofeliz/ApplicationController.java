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
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
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
    public String helloWorld() throws IOException, ServiceException {

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

    public static String test() throws RemoteException, ServiceException, MalformedURLException {

        String inputParam = "测试";
        Service service = new Service();
        String url = "http://wddcsdbws85:81/scs.ws/icfg4_lips/LOTService.asmx";  //URL地址
        String namespace = "http://tempuri.org/";
//        String actionUri = "getinfo"; //Action路径
        String op = "getinfo"; //要调用的方法名
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(url));
        call.setUseSOAPAction(true);
//        call.setSOAPActionURI(namespace + actionUri); // action uri
//        call.setOperationName(new QName(namespace, op));// 设置要调用哪个方法
// 设置参数名称，具体参照从浏览器中看到的
        call.addParameter(new QName(namespace, "GetMessageOperationCompleted"), XMLType.XSD_STRING, ParameterMode.IN);  //设置请求参数及类型
//call.setReturnType(new QName(namespace,"getinfo"),Model.class); //设置返回结果为是某个类
        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置结果返回类型
        Object[] params = new Object[] {inputParam};
        String result = (String) call.invoke(params); //方法执行后的返回值
        System.out.println(result);
        return result;
    }
}
