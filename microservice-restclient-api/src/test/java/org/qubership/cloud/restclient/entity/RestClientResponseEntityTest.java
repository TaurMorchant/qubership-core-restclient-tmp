package org.qubership.cloud.restclient.entity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RestClientResponseEntityTest {

    @Test
    public void verifyEquality() {
        List<String> list = new ArrayList<>();
        String responseBody = "resp";
        Map<String, List<String>> header = new HashMap<>();
        header.put("header1", list);
        RestClientResponseEntity<String> restClientResponseEntity = new RestClientResponseEntity(responseBody, 200, header);
        RestClientResponseEntity<String> restClientResponseEntity2 = new RestClientResponseEntity(responseBody, 200, header);
        assertEquals(restClientResponseEntity,restClientResponseEntity2);
    }

    @Test
    public void verifyNotEqualWhenBodyisDifferent() {
        List<String> list = new ArrayList<>();
        String responseBody = "resp";
        String responseBody2 = "resp2";
        Map<String, List<String>> header = new HashMap<>();
        header.put("header1", list);
        RestClientResponseEntity<String> restClientResponseEntity = new RestClientResponseEntity(responseBody, 200, header);
        RestClientResponseEntity<String> restClientResponseEntity2 = new RestClientResponseEntity(responseBody2, 200, header);
        assertNotEquals(restClientResponseEntity,restClientResponseEntity2);
    }

    @Test
    public void verifyNotEqualWhenHeaderisDifferent() {
        List<String> list = new ArrayList<>();
        String responseBody = "resp";
        Map<String, List<String>> header = new HashMap<>();
        header.put("header1", list);
        Map<String, List<String>> header2 = new HashMap<>();
        header.put("header2", list);
        RestClientResponseEntity<String> restClientResponseEntity = new RestClientResponseEntity(responseBody, 200, header);
        RestClientResponseEntity<String> restClientResponseEntity2 = new RestClientResponseEntity(responseBody, 200, header2);
        assertNotEquals(restClientResponseEntity,restClientResponseEntity2);
    }

    @Test
    public void verifyNotEqualWhenStatusCodeisDifferent() {
        List<String> list = new ArrayList<>();
        String responseBody = "resp";
        Map<String, List<String>> header = new HashMap<>();
        header.put("header", list);
        RestClientResponseEntity<String> restClientResponseEntity = new RestClientResponseEntity(responseBody, 200, header);
        RestClientResponseEntity<String> restClientResponseEntity2 = new RestClientResponseEntity(responseBody, 201, header);
        assertNotEquals(restClientResponseEntity,restClientResponseEntity2);
    }

    @Test
    public void verifyIfNotInstanceOFRestClientResponseEntity() {
        List<String> list = new ArrayList<>();
        Void responseBody = null;
        Map<String, List<String>> header = new HashMap<>();
        header.put("header1", list);
        RestClientResponseEntity<Void> restClientResponseEntity = new RestClientResponseEntity(responseBody, 200, header);
        Object o = new Object();
        assertNotEquals(restClientResponseEntity,o);
    }
}
