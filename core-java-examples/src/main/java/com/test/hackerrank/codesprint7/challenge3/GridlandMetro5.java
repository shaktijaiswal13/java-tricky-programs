package com.test.hackerrank.codesprint7.challenge3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/world-codesprint-7/challenges/gridland-metro
 * 
 * This is the final working solution taking into consideration all the cases and able to 
 * handle large values and grids as well.
 * Try with Input 1 and 6 from input_output file.
 *
 */
public class GridlandMetro5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        Long noOfRows = in.nextLong();
        Long noOfColumns = in.nextLong();
        int noOfTrainTracks = in.nextInt();
        Long[][] trainTracks = new Long[noOfTrainTracks][3];
        for (int i=0; i < noOfTrainTracks; i++) {
        	trainTracks[i][0] = in.nextLong();
        	trainTracks[i][1] = in.nextLong();
        	trainTracks[i][2] = in.nextLong();
        }
        in.close();
        
        Map<Long, RowTrainTrackInfo> trackMap = new HashMap<>();
        
        for (int i=0; i<trainTracks.length; i++) {
        	Long trainTrackRow = trainTracks[i][0];
        	Long trainTrackStartCol = trainTracks[i][1];
        	Long trainTrackEndCol = trainTracks[i][2];
        	
        	RowTrainTrackInfo rowTrainTrackInfo = trackMap.get(trainTrackRow);
        	if (rowTrainTrackInfo == null) {
        		rowTrainTrackInfo = new RowTrainTrackInfo();
        		RowTrainTrackInfo.TrainTrackData trackData = rowTrainTrackInfo.getTrainTrackData(trainTrackStartCol, trainTrackEndCol);
        		rowTrainTrackInfo.addTrainTrackData(trackData);
        		trackMap.put(trainTrackRow, rowTrainTrackInfo);
        		System.out.println("New TrainTrackData created: " + trackData);
        		
        	} else {
        		List<RowTrainTrackInfo.TrainTrackData> trackDataList = rowTrainTrackInfo.getTrainTrackDataList();
        		for (int j=0; j<trackDataList.size(); j++) {
        			RowTrainTrackInfo.TrainTrackData trainTrackData = trackDataList.get(j);
        			
        			// If current tracks lies between previous tracks, for eg.
        			// previous tracks are 1,5
        			// current tracks are 2,4
            		if (trainTrackStartCol >= trainTrackData.getTrainTrackColStart() 
            				&& trainTrackEndCol <= trainTrackData.getTrainTrackColEnd()) {
                		System.out.println("TrainTrackData not updated 1st: " + trainTrackData);
            			break;
            		
        			// If previous tracks lies between current tracks, for eg.
        			// previous tracks are 2,4
        			// current tracks are 1,5
            		} else if (trainTrackStartCol <= trainTrackData.getTrainTrackColStart() 
            				&& trainTrackEndCol >= trainTrackData.getTrainTrackColEnd()) {
            			
            			trainTrackData.setTrainTrackColStart(trainTrackStartCol);
            			trainTrackData.setTrainTrackColEnd(trainTrackEndCol);
            			trainTrackData.setTotalTrainTrackCols(trainTrackEndCol - trainTrackStartCol + 1);
                		System.out.println("TrainTrackData updated 2nd: " + trainTrackData);

            			
        			// If tracks are overlapping, for eg.
        			// previous tracks are 2,4
        			// current tracks are 3,5	
            		} else if (trainTrackStartCol > trainTrackData.getTrainTrackColStart() 
            				&& trainTrackStartCol <= trainTrackData.getTrainTrackColEnd()
            				&& trainTrackEndCol > trainTrackData.getTrainTrackColEnd()) {
            			
            			trainTrackData.setTotalTrainTrackCols(trainTrackData.getTotalTrainTrackCols() 
            					+ (trainTrackEndCol - trainTrackData.getTrainTrackColEnd()));        		
            			trainTrackData.setTrainTrackColEnd(trainTrackEndCol);
                		System.out.println("TrainTrackData updated 3rd: " + trainTrackData);

            			
        			// If tracks are overlapping, for eg.
        			// previous tracks are 2,4
        			// current tracks are 1,2	
            		} else if (trainTrackStartCol < trainTrackData.getTrainTrackColStart() 
            				&& trainTrackEndCol >= trainTrackData.getTrainTrackColStart()
            				&& trainTrackEndCol < trainTrackData.getTrainTrackColEnd()) {
            			
            			trainTrackData.setTotalTrainTrackCols(trainTrackData.getTotalTrainTrackCols() 
            					+ (trainTrackData.getTrainTrackColStart() - trainTrackStartCol));        		
            			trainTrackData.setTrainTrackColStart(trainTrackStartCol);
                		System.out.println("TrainTrackData updated 4th: " + trainTrackData);

            			
        			// If tracks are different, for eg.
        			// previous tracks are 2,4
        			// current tracks are 6,7
            		} else if (trainTrackStartCol > trainTrackData.getTrainTrackColEnd()) {
            			RowTrainTrackInfo.TrainTrackData trackData = rowTrainTrackInfo.getTrainTrackData(trainTrackStartCol, trainTrackEndCol);
                		rowTrainTrackInfo.addTrainTrackData(trackData);
                		System.out.println("TrainTrackData updated 5th: " + trainTrackData);

                		
        			// If tracks are different, for eg.
        			// previous tracks are 3,4
        			// current tracks are 1,1
            		} else if (trainTrackEndCol < trainTrackData.getTrainTrackColStart()) {
            			RowTrainTrackInfo.TrainTrackData trackData = rowTrainTrackInfo.getTrainTrackData(trainTrackStartCol, trainTrackEndCol);
                		rowTrainTrackInfo.addTrainTrackData(trackData);
                		System.out.println("TrainTrackData updated 6th: " + trainTrackData);
            		}
        		}
        	}
        }
        
        Long trainTrackCellsCount = 0L;
        
        for (RowTrainTrackInfo rowInfo : trackMap.values()) {
        	for (RowTrainTrackInfo.TrainTrackData trackData : rowInfo.getTrainTrackDataList()) {
        		trainTrackCellsCount += trackData.getTotalTrainTrackCols();
        	}
        }
        System.out.println(noOfRows * noOfColumns - trainTrackCellsCount);
	}

}

/**
 * This class stores all the train tracks info for a single row.
 */
class RowTrainTrackInfo {
	
	List<TrainTrackData> trainTrackDataList = new ArrayList<>();
	
	public void addTrainTrackData(TrainTrackData trainTrackData) {
		trainTrackDataList.add(trainTrackData);
	}
	
	public TrainTrackData getTrainTrackData(Long trainTrackColStart, Long trainTrackColEnd) {
		return new TrainTrackData(trainTrackColStart, trainTrackColEnd);
	}
	
	public List<TrainTrackData> getTrainTrackDataList() {
		return trainTrackDataList;
	}

	/**
	 * This is an inner class for the RowTrainTrackInfo class. This class is used to store the
	 * started column and end column of the track. It also stores the info about the total 
	 * cells used for that track.
	 *
	 */
	class TrainTrackData {
		
		private Long trainTrackColStart;
		private Long trainTrackColEnd;
		private Long totalTrainTrackCols;
		
		public TrainTrackData(Long trainTrackColStart, Long trainTrackColEnd) {
			this.trainTrackColStart = trainTrackColStart;
			this.trainTrackColEnd = trainTrackColEnd;
			this.totalTrainTrackCols = trainTrackColEnd - trainTrackColStart + 1;
		}
		
		public void setTotalTrainTrackCols(Long totalTrainTrackCols) {
			this.totalTrainTrackCols = totalTrainTrackCols;
		}
		
		public Long getTrainTrackColStart() {
			return trainTrackColStart;
		}
		
		public void setTrainTrackColStart(Long trainTrackColStart) {
			this.trainTrackColStart = trainTrackColStart;
		}
		
		public Long getTrainTrackColEnd() {
			return trainTrackColEnd;
		}
		
		public void setTrainTrackColEnd(Long trainTrackColEnd) {
			this.trainTrackColEnd = trainTrackColEnd;
		}
		
		public Long getTotalTrainTrackCols() {
			return totalTrainTrackCols;
		}

		@Override
		public String toString() {
			return "TrainTrackData [trainTrackColStart=" + trainTrackColStart + ", trainTrackColEnd=" + trainTrackColEnd
					+ ", totalTrainTrackCols=" + totalTrainTrackCols + "]";
		}
		
	}
}
