package com.test.testdome.tests;
import java.util.ArrayList;
import java.util.List;


public class RecursiveFrogJump {
    

    public static List <List<Integer>> results = new ArrayList<List<Integer>>();
    
    public static void main(String[] args){
        int sum = 20;    
        List <Integer> way = new ArrayList<Integer>();
        printJumpWays(way, 0, sum);
        System.out.println(results.size());
    }
    
    /**
     * @param way
     * @param currentValue
     * @param sum
     */
    public static void printJumpWays(List <Integer> way, int currentValue, int sum){
        List <Integer> currentWay = new ArrayList<Integer>();
        if(currentValue < sum){
            currentWay.addAll(way);
            currentWay.add(1);
            printJumpWays (currentWay, currentValue+1, sum);
            currentWay = new ArrayList<Integer>();

            currentWay.addAll(way);
            currentWay.add(2);
            printJumpWays (currentWay, currentValue+2, sum);
        }
        
        if (currentValue == sum){
            results.add(way);
            //System.out.println(way);
            return;
        }
            
        if (currentValue > sum){
            return;
        } 
    }

}