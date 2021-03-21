package com.rohan.testing.basic.business;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        // strict = true, matches exact structure, spaces doesn't matters
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }


    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\"}";
        // strict = true, matches exact structure, spaces doesn't matters
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }


    @Test
    public void jsonAssert_StrictFalse_WillFail() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Bat\"}";
        // strict = true, matches exact structure, spaces doesn't matters
        JSONAssert.assertNotEquals(expectedResponse, actualResponse, false);
    }


    @Test
    public void jsonAssert_StrictFalse_WithoutEscapeCharacters() throws JSONException {
        // Only escape if you have spaces in your values
        String expectedResponse = "{id:1, name:Ball}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
