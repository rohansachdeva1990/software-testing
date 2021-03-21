package com.rohan.testing.basic.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {

    @Mock
    private List<String> list;

    @Test
    public void size_basic() {
        when(list.size()).thenReturn(5);
        assertEquals(5, list.size());
    }

    @Test
    public void returnDifferentValues() {
        when(list.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, list.size());
        assertEquals(10, list.size());
    }

    @Test
    public void returnWithParameters() {
        when(list.get(0)).thenReturn("king rohan");
        assertEquals("king rohan", list.get(0));
        assertNull(list.get(1)); // Default value is returned for non mock stuff
    }

    @Test
    public void returnWithGenericParameters() {
        when(list.get(anyInt())).thenReturn("king rohan");
        assertEquals("king rohan", list.get(0));
        assertEquals("king rohan", list.get(1));
    }

    @Test
    public void verificationBasics() {
        // SUT
        String value1 = list.get(0);
        String value2 = list.get(1);

        // Verify
        verify(list).get(0);
        verify(list, times(2)).get(anyInt());
        verify(list, atLeastOnce()).get(anyInt());
        verify(list, atMost(2)).get(anyInt());
        verify(list, never()).get(2);

    }

    @Test
    public void argumentCapturing() {
        // SUT
        list.add("SomeString");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(list).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        // SUT
        list.add("SomeString1");
        list.add("SomeString2");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(list, times(2)).add(captor.capture());

        final List<String> allValues = captor.getAllValues();
        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    public void testWhyWeNeedSpy() {
        ArrayList<String> arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0));// null
        System.out.println(arrayListMock.size()); // 0
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");

        // A MOCK DOES NOT RETAIN BEHAVIOR OF THE ORIGINAL CLASS!!
        // Size of arraylist will still be 0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); // 5

    }


    @Test
    public void testSpy() {
        // WITH SPY ORIGINAL BEHAVIOR OF A LIST IS RETAINED!!

        ArrayList<String> arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0));// null
        System.out.println(arrayListSpy.size()); // 1
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size()); // 3

        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // 5

        arrayListSpy.add("Test4");
        arrayListSpy.add("Test5");
        arrayListSpy.add("Test6");
        arrayListSpy.add("Test7");
        System.out.println(arrayListSpy.size()); // 5
    }


}
