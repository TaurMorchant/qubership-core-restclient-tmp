package org.qubership.cloud.restclient.exception;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class MicroserviceRestClientResponseExceptionTest {

    String msg = "test";
    byte[] responseBody = new byte[8];
    Map<String, List<String>> responseHeaders = new HashMap<>();

    @Test
    public void getResponseBodyAsString() {
        String response = "resp";
        responseBody = response.getBytes();
        List<String> list = new ArrayList<>();
        list.add("charset=UTF-8;xyz");
        responseHeaders.put("Content-Type", list);
        MicroserviceRestClientResponseException microserviceRestClientResponseException = new MicroserviceRestClientResponseException(msg, 200, responseBody, responseHeaders);
        String str = microserviceRestClientResponseException.getResponseBodyAsString();
        assertEquals("resp", str);
    }

    @Test
    public void getToStringWithResponseData() {
        String response = "resp";
        responseBody = response.getBytes();
        List<String> list = new ArrayList<>();
        list.add("charset=UTF-8;xyz");
        responseHeaders.put("Content-Type", list);
        String expected = "MicroserviceRestClientResponseException{message=test, httpStatus=200, responseBody=resp}";
        MicroserviceRestClientResponseException microserviceRestClientResponseException = new MicroserviceRestClientResponseException(msg, 200, responseBody, responseHeaders);
        String str = microserviceRestClientResponseException.toString();
        assertEquals(expected, str);
    }
}
