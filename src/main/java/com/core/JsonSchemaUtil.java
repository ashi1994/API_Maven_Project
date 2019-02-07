package com.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class JsonSchemaUtil {

    public static final String JSON_V4_SCHEMA_IDENTIFIER = "http://json-schema.org/draft-06/schema#";
    public static final String JSON_SCHEMA_IDENTIFIER_ELEMENT = "$schema";
    public static final String JSON_SCHEME="$id";

    public static JsonNode getJsonNode(String jsonText)
            throws IOException {
        return JsonLoader.fromString(jsonText);
    }

    public static JsonNode getJsonNode(File jsonFile)
            throws IOException {
        return JsonLoader.fromFile(jsonFile);
    }

    public static JsonNode getJsonNode(java.net.URL url)
            throws IOException {
        return JsonLoader.fromURL(url);
    }

    public static JsonNode getJsonNodeFromResource(String resource)
            throws IOException {
        return JsonLoader.fromResource(resource);
    }

    public static JsonSchema getSchemaNode(String schemaText)
            throws IOException, ProcessingException {
        final JsonNode schemaNode = getJsonNode(schemaText);
        return _getSchemaNode(schemaNode);
    }

    public static JsonSchema getSchemaNode(File schemaFile)
            throws IOException, ProcessingException {
        final JsonNode schemaNode = getJsonNode(schemaFile);
        return _getSchemaNode(schemaNode);
    }

    public static JsonSchema getSchemaNodeFromResource(String resource)
            throws IOException, ProcessingException {
        final JsonNode schemaNode = getJsonNodeFromResource(resource);
        return _getSchemaNode(schemaNode);
    }

    private static JsonSchema _getSchemaNode(JsonNode jsonNode)
            throws ProcessingException {
        final JsonNode schemaIdentifier = jsonNode.get(JSON_SCHEMA_IDENTIFIER_ELEMENT);
        if (null == schemaIdentifier) {
            ((ObjectNode) jsonNode).put(JSON_SCHEMA_IDENTIFIER_ELEMENT, JSON_V4_SCHEMA_IDENTIFIER);

        }

        final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        return factory.getJsonSchema(jsonNode);
    }


    // Validate Json Schema
    public List<String> validateServiceSchema(String jsonSchema, String jsonData) throws ProcessingException,IOException {
        List<String> missingNodeList = new ArrayList<>();
        JsonNode data=getJsonNode(jsonData);
        JsonSchema schema =getSchemaNode(jsonSchema);
        ProcessingReport report = schema.validate(data);
        System.out.println("\nSchema Processing Success Status ===> " + report.isSuccess());
        Iterator<ProcessingMessage> itr = report.iterator();
        while (itr.hasNext()) {
            ProcessingMessage message = itr.next();
            if (null != message && null != message.asJson() && message.getLogLevel().toString() != "warning" ) {
                missingNodeList.add(message.toString());
            }
        }
        return missingNodeList;
    }


    public void PrintNodes(JsonNode Node){
        String Current="$";
        if(!Current.equals(Node.asText())) {
            Current=Current+"."+Node.asText();
        }
        Iterator<String> NodeIterator = Node.fieldNames();
        while(NodeIterator.hasNext())
        {
            String node = NodeIterator.next();
            JsonNode value = Node.get(node);
            if(value.isObject())
            {
                PrintNodes(value);
            }
            else
            {
                String NodeValue = value.asText();
                System.out.println(Current+"."+node+" : "+NodeValue);

            }
        }


    }

    //Method to Parse JSON and check for null / empty keys

    public List<String> getEmptyNodes(JsonNode Node){
        List<String> emptyNodes=new ArrayList<String>();
        HashSet<String> emptyNodeSet = new HashSet<String>();
        Iterator<String> NodeIterator = Node.fieldNames();
        while(NodeIterator.hasNext()){
            String node = NodeIterator.next();
            JsonNode value = Node.get(node);
            if(value.isObject()) {
                getEmptyNodes(value);
            }
            else if(value.isArray()){
                continue;
            }
            else{
                String NodeValue = value.asText();
                if(NodeValue.isEmpty() || NodeValue.equals(null) ||NodeValue.equals("")){
                    emptyNodes.add(node);
                    emptyNodeSet.add(node);
                    System.out.println("Found Empty Node : "+node);
                }
                else
                {
                    //System.out.println(node+" : "+NodeValue);
                }
            }
        }

        return emptyNodes;


    }

    //Method to Parse JSON and check for null / empty keys

    public boolean hasEmptyNodes(String response) throws  IOException {
        HashSet<String> emptyNodeSet = new HashSet<String>();
        boolean hasEmptyNodes = false;
        JsonNode json = new ObjectMapper().readTree(response);
        List<String> emptyNodes = getEmptyNodes(json);

        System.out.println("Printing LIST -->"+emptyNodeSet);
        if(!emptyNodes.isEmpty()) {
            hasEmptyNodes=true;
            System.out.println("FAULTY NODES:\n ");
            ListIterator<String> ITR = emptyNodes.listIterator();
            while(ITR.hasNext()) {
                System.out.println(ITR.next());
            }
        }
        return hasEmptyNodes;
    }

    public boolean validateSchema(String schemaPath, String actualResp) {
        boolean valid = false;
        try {
            String jsonSchema = new ToolBox().readFileAsString(System.getProperty("user.dir") + schemaPath);
            List<String> missingNodeList = validateServiceSchema(jsonSchema, actualResp);
            valid = missingNodeList.isEmpty();
            if(!valid) {
                System.out.println("missing node are : "+missingNodeList);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return valid;
    }
}