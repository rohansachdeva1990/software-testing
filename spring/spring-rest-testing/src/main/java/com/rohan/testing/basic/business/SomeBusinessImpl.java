package com.rohan.testing.basic.business;

import com.rohan.testing.basic.data.SomeDataService;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        int sum = 0;
        for (int d : data) {
            sum += d;
        }
        return sum;
    }


    public int calculateSumUsingDataService(){
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for (int d : data) {
            sum += d;
        }
        return sum;
    }

}
