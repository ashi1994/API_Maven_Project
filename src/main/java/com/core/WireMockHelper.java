package com.core;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.admin.model.ListStubMappingsResult;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.http.DelayDistribution;
import com.github.tomakehurst.wiremock.http.UniformDistribution;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WireMockHelper {

    @Test
    public void startMockServer(int port) {
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options().port(port));
        WireMock.configureFor("localhost", port);
        if(wireMockServer.isRunning()) {
            System.out.print("Here in if loop." + wireMockServer.toString());
            wireMockServer.stop();
        }
        wireMockServer.start();

    }

    public void startMockServer() {
        WireMockServer wireMockServer = new WireMockServer();
        if(wireMockServer.isRunning()) {
            System.out.print("Here in if loop." + wireMockServer.toString());
            wireMockServer.stop();
        }
        wireMockServer.start();
    }

    public void stopMockServer() {
        WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.stop();
    }

    public void setupStub(String uri, int statusCode, String contentType, String body) {
        stubFor(get(urlMatching(".*/" + uri + ".*"))
                .willReturn(aResponse()
                        .withStatus(statusCode)
                        .withHeader("Content-Type", contentType)
                        .withBody(body)));
    }

    public void setupStub(String uri, int statusCode, String contentType, String body, int minDelay, int maxDelay) {
        DelayDistribution dd = new UniformDistribution(minDelay, maxDelay);
        stubFor(get(urlMatching(".*/" + uri + ".*"))
                .willReturn(aResponse()
                        .withRandomDelay(dd)
                        .withStatus(statusCode)
                        .withHeader("Content-Type", contentType)
                        .withBody(body)));
    }

    public void setupStub(String uri, int statusCode, String contentType, String body, int delay) {
        stubFor(get(urlMatching(".*/"+uri+".*"))
                .willReturn(aResponse()
                        .withFixedDelay(delay)
                        .withStatus(statusCode)
                        .withHeader("Content-Type", contentType)
                        .withBody(body)));

    }

    public void setupStubEdit(String uri, int statusCode, String contentType, String body, int delay) {
        stubFor(get("/"+uri)
                .willReturn(aResponse()
                        .withFixedDelay(delay)
                        .withStatus(statusCode)
                        .withHeader("Content-Type", contentType)
                        .withBody(body)));

    }


    public void setupStubPost(String uri, int statusCode, String contentType, String reqBody, String resBody) {
        stubFor(post(urlMatching(".*/" + uri + ".*")).withRequestBody(equalToJson(reqBody))
                .willReturn(aResponse()
                        .withStatus(statusCode)
                        .withHeader("Content-Type", contentType)
                        .withBody(resBody)));
    }

    public void setupStubPost(String uri, int statusCode, String contentType, String reqBody, String resBody, int minDelay, int maxDelay) {
        DelayDistribution dd = new UniformDistribution(minDelay, maxDelay);
        stubFor(post(urlMatching(".*/" + uri + ".*")).withRequestBody(equalToJson(reqBody))
                .willReturn(aResponse()
                        .withRandomDelay(dd)
                        .withStatus(statusCode)
                        .withHeader("Content-Type", contentType)
                        .withBody(resBody)));
    }

    public void setupStubPost(String uri, int statusCode, String contentType, String reqBody, String resBody, int delay) {
        stubFor(post(urlMatching(".*/" + uri + ".*")).withRequestBody(equalToJson(reqBody))
                .willReturn(aResponse()
                        .withFixedDelay(delay)
                        .withStatus(statusCode)
                        .withHeader("Content-Type", contentType)
                        .withBody(resBody)));
    }

    public void setupStubPost(String uri, int statusCode, String contentType, String resBody) {
        stubFor(post(urlMatching(".*/" + uri + ".*"))
                .willReturn(aResponse()
                        .withStatus(statusCode)
                        .withHeader("Content-Type", contentType)
                        .withBody(resBody)));
    }

    public void setupStubPost(String uri, int statusCode, String contentType, String resBody, int minDelay, int maxDelay) {
        DelayDistribution dd = new UniformDistribution(minDelay, maxDelay);
        stubFor(post(urlMatching(".*/" + uri + ".*"))
                .willReturn(aResponse()
                        .withRandomDelay(dd)
                        .withStatus(statusCode)
                        .withHeader("Content-Type", contentType)
                        .withBody(resBody)));
    }

    public void setupStubPost(String uri, int statusCode, String contentType, String resBody, int delay) {
        stubFor(post(urlMatching(".*/" + uri + ".*"))
                .willReturn(aResponse()
                        .withFixedDelay(delay)
                        .withStatus(statusCode)
                        .withHeader("Content-Type", contentType)
                        .withBody(resBody)));
    }

    public void setupStubPut(String uri, int statusCode, String contentType, String resBody, int delay){
        stubFor(put(urlMatching(".*/"+uri+".*"))
                .willReturn(aResponse()
                        .withFixedDelay(delay)
                        .withStatus(statusCode)
                        .withHeader("Content-Type", contentType)
                        .withBody(resBody)));
    }
    public void listAll(){
        ListStubMappingsResult listStubMappingsResult = listAllStubMappings();
        List<StubMapping> mappings = listStubMappingsResult.getMappings();
        for(StubMapping stubMapping : mappings){
            removeStub(stubMapping);
        }
    }
    @Test
    public void test() throws IOException {
        WireMockHelper wireMockHelper = new WireMockHelper();
        wireMockHelper.startMockServer(6666);
        wireMockHelper.listAll();
    }
}
