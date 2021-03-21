package com.rohan.testing.basic.business;

import com.rohan.testing.basic.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Using stubs, maintaining them is a hell any new method to an interface implemented stub, will change break everything
 */
class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(() -> new int[]{});
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(() -> new int[]{1});
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

    static class SomeDataServiceStub implements SomeDataService {
        @Override
        public int[] retrieveAllData() {
            return new int[]{1, 2, 3};
        }
    }

}