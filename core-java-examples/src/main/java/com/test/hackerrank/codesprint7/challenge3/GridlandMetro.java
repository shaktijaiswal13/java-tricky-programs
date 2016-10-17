package com.test.hackerrank.codesprint7.challenge3;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/world-codesprint-7/challenges/gridland-metro
 * 
 * Works fine but for small grid. But for large it has the problem of OutOfMemory and is slow as well due to loop.
 * Try with Input 1 and 6 from input_output file.
 *
 */
public class GridlandMetro {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        long noOfRows = in.nextLong();
        long noOfColumns = in.nextLong();
        int noOfTrainTracks = in.nextInt();
        long[][] trainTracks = new long[noOfTrainTracks][3];
        for (int i=0; i < noOfTrainTracks; i++) {
        	trainTracks[i][0] = in.nextLong();
        	trainTracks[i][1] = in.nextLong();
        	trainTracks[i][2] = in.nextLong();
        }
        in.close();
        
        long[][] gridlandCity = new long[(int) noOfRows][(int) noOfColumns];
        for (int i=0; i<trainTracks.length; i++) {
        	long trainTrackRow = trainTracks[i][0];
        	long trainTrackStartCol = trainTracks[i][1];
        	long trainTrackEndCol = trainTracks[i][2];
        	for (long trainTrackCol=trainTrackStartCol; trainTrackCol <= trainTrackEndCol; trainTrackCol++) {
        		gridlandCity[(int) (trainTrackRow - 1)][(int) (trainTrackCol - 1)] = 1;
        	}
        }
        long lamppostPlacesCount = 0;
        
        for (int row=0; row < gridlandCity.length; row++) {
        	for (int col=0; col < gridlandCity[row].length; col++) {
//        		System.out.print(gridlandCity[row][col] + " ");
        		if (gridlandCity[row][col] == 0) {
        			lamppostPlacesCount++;
        		}
        	}
//        	System.out.println();
        }
        System.out.println(lamppostPlacesCount);
	}

}
