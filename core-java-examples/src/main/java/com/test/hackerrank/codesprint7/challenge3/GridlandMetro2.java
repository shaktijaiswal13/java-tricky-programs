package com.test.hackerrank.codesprint7.challenge3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/world-codesprint-7/challenges/gridland-metro
 *
 * Same as GridlandMetro1.java, but used ArrayList instead of 2-d array. 
 * But it is not completed yet.
 */
public class GridlandMetro2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        BigInteger noOfRows = in.nextBigInteger();
        BigInteger noOfColumns = in.nextBigInteger();
        int noOfTrainTracks = in.nextInt();
        
        List<List<BigInteger>> trainTracksInfo = new ArrayList<>();
        List<BigInteger> trainTrack;
        
        for (int i=0; i < noOfTrainTracks; i++) {
        	trainTrack = new ArrayList<>(3);
        	trainTrack.add(in.nextBigInteger());
        	trainTrack.add(in.nextBigInteger());
        	trainTrack.add(in.nextBigInteger());
        	trainTracksInfo.add(trainTrack);
        }
        in.close();
        
        List<List<Integer>> gridlandCity = new ArrayList<>();
        BigInteger one = BigInteger.ONE;
        BigInteger zero = BigInteger.ZERO;
        BigInteger trainTracksCount = zero;
        
        System.out.println(trainTracksInfo.size());
        
        for (List<BigInteger> trainTrackInfo : trainTracksInfo) {
        	System.out.println(trainTrackInfo.size());
        	BigInteger trainTrackRow = trainTrackInfo.get(0);
        	BigInteger trainTrackStartCol = trainTrackInfo.get(1);
        	BigInteger trainTrackEndCol = trainTrackInfo.get(2);
        	
        	for (BigInteger trainTrackCol=trainTrackStartCol; trainTrackCol.compareTo(trainTrackEndCol) <= 0;) {
        		List<Integer> gridlandCityRows = gridlandCity.get((trainTrackRow.intValue() - 1));
        		if (gridlandCityRows != null) {
        			gridlandCityRows.add((trainTrackCol.intValue() - 1), 1);
        		} else {
        			gridlandCityRows = new ArrayList<>();
        			gridlandCityRows.add((trainTrackCol.intValue() - 1), 1);
        			gridlandCity.add(gridlandCityRows);
        		}
        		trainTrackCol = trainTrackCol.add(one);
        	}
        }
        
        for (List<Integer> gridlandCityRows : gridlandCity) {
        	for (Integer gridlandCityCols : gridlandCityRows) {
//        		System.out.print(gridlandCityCols + " ");
        		if (gridlandCityCols.equals(1)) {
        			trainTracksCount = trainTracksCount.add(one);
        		}
        	}
//        	System.out.println();
        }
        
        BigInteger totalCells = noOfRows.multiply(noOfColumns);
        BigInteger lamppostsCellCount = totalCells.subtract(trainTracksCount);
        System.out.println(lamppostsCellCount);
	}

}
