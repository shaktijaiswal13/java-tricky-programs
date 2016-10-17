package com.test.hackerrank.codesprint7.challenge3;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/world-codesprint-7/challenges/gridland-metro
 * 
 * Tried again with Sparse matrix but did not worked out. Not completed yet.
 *
 */
public class GridlandMetro3 {

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
        System.out.println("scanner closed....");
        SparseMatrix sparseMatrix = new SparseMatrix(noOfRows, noOfColumns);
        for (int i=0; i<trainTracks.length; i++) {
        	long trainTrackRow = trainTracks[i][0];
        	long trainTrackStartCol = trainTracks[i][1];
        	long trainTrackEndCol = trainTracks[i][2];
        	for (long trainTrackCol=trainTrackStartCol; trainTrackCol <= trainTrackEndCol; trainTrackCol++) {
        		System.out.println("trainTrackCol " + trainTrackCol );
        		sparseMatrix.setValue((trainTrackRow - 1), (trainTrackCol - 1), 1);
        	}
        }
        long lamppostPlacesCount = 0;
        
//        for (int row=0; row < gridlandCity.length; row++) {
//        	for (int col=0; col < gridlandCity[row].length; col++) {
////        		System.out.print(gridlandCity[row][col] + " ");
//        		if (gridlandCity[row][col] == 0) {
//        			lamppostPlacesCount++;
//        		}
//        	}
////        	System.out.println();
//        }
        System.out.println(sparseMatrix.usedPositionsMap.size());
        System.out.println(noOfRows * noOfColumns - sparseMatrix.usedPositionsMap.size());

	}

}
