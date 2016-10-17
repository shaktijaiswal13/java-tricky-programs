package com.test.hackerrank.codesprint7.challenge3;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/world-codesprint-7/challenges/gridland-metro
 *
 * Same as GridlandMetro.java, but with BigInteger instead of long to handle more values. But it still have the problem
 * of OutOfMemory and is slow as well due to loop.
 * Try with Input 1 and 5 from input_output file.
 */
public class GridlandMetro1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        BigInteger noOfRows = in.nextBigInteger();
        BigInteger noOfColumns = in.nextBigInteger();
        int noOfTrainTracks = in.nextInt();
        BigInteger[][] trainTracks = new BigInteger[noOfTrainTracks][3];
        for (int i=0; i < noOfTrainTracks; i++) {
        	trainTracks[i][0] = in.nextBigInteger();
        	trainTracks[i][1] = in.nextBigInteger();
        	trainTracks[i][2] = in.nextBigInteger();
        }
        in.close();
        
        BigInteger[][] gridlandCity = new BigInteger[noOfRows.intValue()][noOfColumns.intValue()];
        BigInteger one = BigInteger.ONE;
        for (int i=0; i<trainTracks.length; i++) {
        	BigInteger trainTrackRow = trainTracks[i][0];
        	BigInteger trainTrackStartCol = trainTracks[i][1];
        	BigInteger trainTrackEndCol = trainTracks[i][2];
        	for (BigInteger trainTrackCol=trainTrackStartCol; trainTrackCol.compareTo(trainTrackEndCol) <= 0;) {
        		gridlandCity[(trainTrackRow.intValue() - 1)][(trainTrackCol.intValue() - 1)] = one;
        		trainTrackCol = trainTrackCol.add(one);
        	}
        }
        BigInteger zero = BigInteger.ZERO;
        BigInteger trainTracksCount = zero;
        
        for (int row=0; row < gridlandCity.length; row++) {
        	for (int col=0; col < gridlandCity[row].length; col++) {
//        		System.out.print(gridlandCity[row][col] + " ");
        		if (one.equals(gridlandCity[row][col])) {
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
