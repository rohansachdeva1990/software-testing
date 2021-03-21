package com.rohan.testing.basic.business;

import com.rohan.testing.basic.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Using stubs, maintaining them is a hell any new method to an interface implemented stub, will change break everything
 */
@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {

    @Mock
    private SomeDataService someDataService;

    @InjectMocks
    private SomeBusinessImpl business;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(someDataService.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(someDataService.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(someDataService.retrieveAllData()).thenReturn(new int[]{1});
        assertEquals(1, business.calculateSumUsingDataService());
    }
}