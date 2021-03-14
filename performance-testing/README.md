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


## Advanced Thread Group Methofd for Real time load with Jmeter

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
    - Collects all load parameters, results....
    - Essential listeners
        - View Result tree
        - Aggregate Report
        - Graph Results
        

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
