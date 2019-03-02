package com.core;

import org.apache.commons.text.StringSubstitutor;
import java.util.HashMap;
import java.util.Map;

public class PayloadParam {

    public static String Parameterize(String PayloadRawString, String[] StringParameters){
        Map<String, String> valuesMap = new HashMap<String, String>();
        int paramnumber = 0;
        for (String param : StringParameters) {
            valuesMap.put(Integer.toString(paramnumber), param);
            paramnumber++;
        }

        String templateString = PayloadRawString;
        StringSubstitutor sub = new StringSubstitutor(valuesMap);
        String resolvedString = sub.replace(templateString);
        return resolvedString;
    }
    public static void main(String[] args) throws Exception {
        String readoriginal=new ToolBox().readFileAsString(System.getProperty("user.dir")+"/payload/PayloadParams/PayloadChange");
        String[] StringParameters={"mithu","222"};
        String output=Parameterize(readoriginal,StringParameters);
        System.out.println(output);

    }
}