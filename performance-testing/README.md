# Performance Tesing with Jmeter

## Introduction

What is Performance Testing?
    - Performance Testing is a type of testing to ensure software applications will perform well under the particular workload.

    - Load testing is the simplest form of performance testing.

Why Jmeter?
    - Open source
    - Cross platform support
    - Scripting not essentials to learn Jmeter
 
Jmeter Overview

    - Test plan: Consist of all actions and components you need to execute your performance test scripts
    - Workbench: Workbench can be taken as a practice area or a temporary storage 
    as the components of workbench are not saved along with the test plan.
    A most important component is HTTPSTestScriptRecorder which can record the scripts directly and tester can put the load on those later on.
    
## Recording the Jmeter Scripts

What is Record and Playback?
    - Jmeter records the set of actions your perform to run your test.
    - Test Plan -> Non-test Elements -> HTTP(S) Test Script Recorder
    - To test we need request and responses
    - With https website needs certificate provided with Jmeter
How to?
    - Using blazemeter extension in chrome and exporting it as jmx file in Jmeter


## How to put load and analyse performance metrics

What is Thread Group?
    - A thread group is a set of threads/users executing the same scenario.
    - Executing a flow wiht n number of users

Thread Properties
    - Number of threads: number of user you want to access the app
    - Ramp-up period: Means in how many seconds we want the user to be on that website/app
        - For eg. If Number of threads is 50, and rampup value is 5, then it means in 1 second 10 user will be there and then in next 1 second another 10 untill it completes.
        - We do this normally to create a real time situation, not 1000 user will be at a time on the website. It will gradually grow.
    - Loop count: number of repetition in test
        - 50 user and 5 loop count means the test will be performed 250 times

    - Scheduler (Enabled on Forever)
        - Duration: duration you want to apply load on the servber

What is Listeners?
    - General Approach    
        - Test your Jmeter script with 1 user to ensure that the request and response are as expected
        - And then jump into increasing the load.

    - Collects all load parameters, results....
    - Essential listeners
        - View Result tree
        - Aggregate Report
            - Samples: Num of user hitting that specific request (in defined threadgroup time) = 2153
            - Average: It is the average time taken by all the samples to execute specific label. (129)
            - Min: The shortest time taken by a sample for specific label to get a response
            - Max: The longest time taken by a sample for specific label to get a response
            - Error %: Percentage of fail request
            - Throughput: It is the number of request that are processed per time unit(seconds, minutes, hours) by the server. The time is calculated from the start of first sample to the end of the last sample. Larger throughput is better. (50/sec - 50 request are processed by the server per second.). Time taken by the server for handling the users/request. At some point throughput becomes constant even if you increase your threads.
                - Eg. With 100 user load, throuput is 123 requests/sec for reserver.php. (What we send to the client). Ideally with less number of user the TP should be higher
            - Median: It is the time in the middle of a set of sample results. It indicates that 50% of the samples took no more than this time. i.e. the remainder took at least as long.
            - Std. Dev: This shows the set of exceptional cases which were deviating from the average value of sample response time. The lesser this value more consistent the sata. Standard deviation should be less than or equal to the average time for that label
            - 90% line: 90% of the smaples took no more than this time. The remaining samples took at least as long as this. (90th percentile).
            Basically to know how much most of the user are getting the response time.
        - Graph Results
            - Deviation: Check if user are on the right track. Normally it should be constant or straight
            - Throughput should not decrease (Always increase) and Deviation should not increase
            - Deviation should always be less than (or half of) Average.

## Advanced Thread Group Methofd for Real time load with Jmeter

    - Concurrency Thread Group
        - Properties
            - Target Concurrency: How many threads you want start (60)
            - Ramp Up Time (sec): In how many seconds this number of user should be up and hit the server. Time taken by all user to be available to start hitting the server (30)
            - Ramp Up Steps Count (3): So 20 user will be ramped 3 times in 30 secs
            - Hold Target Rate Time (sec): How many seconds we keep the user until some time. 
    - Ultimate Thread Group
        - Proprties
            - Start Threads Count
            - Initial Delay, sec
            - Startup Time, sec
            - Hold Load For, sec
            - Shutdown Time


## HTTP Cookie Manager to capture sessions

## Assertions in Jmeter

## Sample Application to Practice Jmeter Tool

## Jmeter controllers for Modules wise Metrics

## Timers in Jmeter

## Importance of Regex in Jmeter

## Handling Dynamic Responses - Advanced Jmeter

## Jmeter validation in Non GUI Mode

## Jmeter Distributed Mode in running tests in Slave machines

## Beanshel Scripting basics for Jmeter

## Integration of Selenium with Jmeter

## REST API Load testing using Jmeter

## Monitoring Server performance
