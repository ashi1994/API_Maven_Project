package com.core;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.text.StrSubstitutor;
import javax.ws.rs.core.NewCookie;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by Ashiwani
 */
public class ToolBox {

    public Boolean DoesFileExists(String filepath){
        File f = new File(filepath);
        return (f.exists() && !f.isDirectory());
    }


    public static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }


    public String readFileAsString(String filePath) throws IOException
    {
        //log.info("Begining reading file '" + filePath + "'");
        // StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        /*
         * char[] buf = new char[1024]; int numRead=0;
         * while((numRead=reader.read(buf)) != -1){ String readData =
         * String.valueOf(buf, 0, numRead); fileData.append(readData); }
         * reader.close();
         */

        // log.info("File content is : "+IOUtils.toString(reader));
        return IOUtils.toString(reader);
    }

    public boolean toBoolean(String string){
        return Boolean.valueOf(string.toLowerCase().trim());
    }

    public String Parameterize(String PayloadRawString, String[] StringParameters){
        Map<String, String> valuesMap = new HashMap<String, String>();
        int paramnumber = 0;
        for (String param : StringParameters) {
            valuesMap.put(Integer.toString(paramnumber), param);
            paramnumber++;
        }

        String templateString = PayloadRawString;
        StrSubstitutor sub = new StrSubstitutor(valuesMap);
        String resolvedString = sub.replace(templateString);
        return resolvedString;
    }


    public void PrintHashmap(HashMap<String, NewCookie> map) {
        for (Map.Entry<String, NewCookie> entry : map.entrySet()) {

            System.out.println(entry.getKey()+" : "+entry.getValue().toString());


        }
    }


    public void PrintHashMap(HashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {

            System.out.println(entry.getKey()+" : "+entry.getValue().toString());


        }
    }

    public static String encode(String url) {
        String encodeURL= null;
        try {
            encodeURL = URLEncoder.encode( url, "UTF-8" );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeURL;
    }

    public static String decode(String url)  {
        String decodedURL = null;
        try {
            decodedURL = URLDecoder.decode( url, "UTF-8" );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decodedURL;
    }


    /**
     * Method to reduce the contents of a double dimensional dataprovider
     * depending on the group that is included for the test. Currently this
     * method runs all data variants for ExhaustiveRegression, regressionDpCount
     * data variants for Regression and miniRegressionDpCount data variants for
     * MiniRegression
     *
     * @param dataSet
     * @param includedGroups
     * @param miniRegressionDpCount
     * @param regressionDpCount
     * @return
     */
    public static Object[][] returnReducedDataSet(Object[][] dataSet,
                                                  String[] includedGroups, int miniRegressionDpCount,
                                                  int regressionDpCount)
    {
        if (ArrayUtils.contains(includedGroups, "ExhaustiveRegression"))
        {
            // Don't remove any of the data
        } else if (ArrayUtils.contains(includedGroups, "Regression")||ArrayUtils.contains(includedGroups, "regression"))
        {
            dataSet = removeNItemsFromArray(dataSet, regressionDpCount);
        } else
            dataSet = removeNItemsFromArray(dataSet, miniRegressionDpCount);
        return dataSet;
    }

    // For Environment Specific dataset
    public static Object[][] returnReducedDataSet(String Env,
                                                  Object[][] dataSet, String[] includedGroups,
                                                  int miniRegressionDpCount, int regressionDpCount)
    {
        if (Env != null)
            dataSet = returnEnvSpecificDataSet(Env, dataSet);
        else
            dataSet = returnDataSetIfEnvNull(dataSet);
        if (ArrayUtils.contains(includedGroups, "ExhaustiveRegression"))
        {
            // Don't remove any of the data
        } else if (ArrayUtils.contains(includedGroups, "Regression")||ArrayUtils.contains(includedGroups, "regression"))
        {
            dataSet = removeNItemsFromArray(dataSet, regressionDpCount);
        } else
            dataSet = removeNItemsFromArray(dataSet, miniRegressionDpCount);
        return dataSet;
    }


    /**
     * Method to remove elements from a double dimensional array
     *
     * @param dataSet
     *            the array to remove elements from
     * @param finalArrayCount
     *            final length of the array needed
     * @return the reduced double dimensional array
     */
    public static Object[][] removeNItemsFromArray(Object[][] dataSet,
                                                   int finalArrayCount)
    {
        Random random = new Random();
        for (int i = dataSet.length - finalArrayCount; i > 0; i--)
        {
            int indexToBeRemoved = random.nextInt(dataSet.length);
            dataSet = ArrayUtils.remove(dataSet, indexToBeRemoved);
        }
        return dataSet;
    }



    private static Object[][] returnEnvSpecificDataSet(String Env, Object[][] dataSet){
        List dataSetAsList = Arrays.asList(dataSet);
        ArrayList dataSetOfEnv = new ArrayList();
        int index = 0;
        for (int i = 0; i < dataSetAsList.size(); i++)
        {
            String[] test = (String[]) dataSetAsList.get(i);
            System.out.println();
            if (test[0].toUpperCase().contains(Env.toUpperCase()))
            {
                dataSetOfEnv.add(index,
                        ArrayUtils.subarray(test, 1, test.length));
                index++;
            }
        }
        Object[][] newDataSet = new Object[dataSetOfEnv.size()][];
        for (int i = 0; i < dataSetOfEnv.size(); i++)
        {
            newDataSet[i] = (Object[]) dataSetOfEnv.get(i);

        }

        return newDataSet;
    }

    private static Object[][] returnDataSetIfEnvNull(Object[][] dataSet)
    {
        List dataSetAsList = Arrays.asList(dataSet);
        ArrayList dataSetOfEnv = new ArrayList();
        int index = 0;
        for (int i = 0; i < dataSetAsList.size(); i++)
        {
            String[] test = (String[]) dataSetAsList.get(i);
            dataSetOfEnv.add(index, ArrayUtils.subarray(test, 1, test.length));
            index++;
        }
        Object[][] newDataSet = new Object[dataSetOfEnv.size()][];
        for (int i = 0; i < dataSetOfEnv.size(); i++)
        {
            newDataSet[i] = (Object[]) dataSetOfEnv.get(i);
        }

        return newDataSet;
    }

    public boolean Exists(String NodePath, String JsonString) {
        boolean result = false, temp = true;
        JsonElement jsonElement = new JsonParser().parse(JsonString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonArray jsonArray;
        String[] nodePathArray = NodePath.split("\\.");
        int counter = nodePathArray.length;
        for (String node : nodePathArray) {
            JsonElement element = jsonObject.get(node);
            System.out.println("Node is : " + node + " : " + counter);
            if (counter > 1) {
                if(element == null){
                    return false;
                }
                if (element.isJsonObject()) {
                    System.out.println("Identified as JsonObject");
                    jsonObject = jsonObject.getAsJsonObject(node);
                } else {
                    if (element.isJsonArray()) {
                        System.out.println("Identified as JsonArray");
                        jsonArray = jsonObject.getAsJsonArray(node);
                        for (int i = 0; i < jsonArray.size(); i++) {
                            if (counter == 2) {
                                jsonObject = jsonArray.get(i).getAsJsonObject();
                                temp = checkKeyIsPresent(jsonObject, nodePathArray[nodePathArray.length - 1]);
                                result = result && temp;
                            } else {
                                jsonObject = jsonArray.get(i).getAsJsonObject();
                            }
                        }
                    } else {
                        System.out.println("Node is neither a json array or a json object.");
                    }
                }
            } else {
                result = jsonObject.has(node);
                System.out.println("Finally checking hasnode and result is " + result);
                System.out.println("\n\n" + jsonObject.toString());
            }
            counter--;
            if (!result) {
                System.out.println("Node '" + node + "' is missing from " + NodePath);
                System.out.println(jsonObject.toString());
            }
        }
        return result;
    }

    public boolean checkKeyIsPresent(JsonObject jobject, String Key) {
        boolean result = false;
        System.out.println("Checking key " + Key);
        result = jobject.has(Key);
        return result;
    }

    public boolean compareLists( List<?> l1, List<?> l2 ) {
        // make a copy of the list so the original list is not changed, and remove() is supported
        ArrayList<?> cp = new ArrayList<>( l1 );
        for ( Object o : l2 ) {
            if ( !cp.remove( o ) ) {
                return false;
            }
        }
        return cp.isEmpty();
    }

}

