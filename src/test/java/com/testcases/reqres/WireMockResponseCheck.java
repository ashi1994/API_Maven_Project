package com.testcases.reqres;

import com.common.RestCalls;
import com.core.WireMockHelper;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import java.io.File;

public class WireMockResponseCheck {
    WireMockHelper helper=new WireMockHelper();

    @Test
    public void testwiremock() throws Exception{
        File fp=new File(System.getProperty("user.dir")+"/payload/MOCK/testmock1.json");
        String body= FileUtils.readFileToString(fp);
        helper.startMockServer(2000);
        helper.setupStub("api",200,"application/json",body);
        String URI = "http://localhost:2000/api/xyz";
        String response= RestCalls.GETRequest(URI).getBody().asString();
        System.out.println("Response "+response);
        helper.stopMockServer();



    }
}
