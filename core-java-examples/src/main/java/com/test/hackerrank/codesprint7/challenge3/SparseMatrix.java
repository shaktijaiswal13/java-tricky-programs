package com.test.hackerrank.codesprint7.challenge3;

import java.util.HashMap;
import java.util.Map;

public class SparseMatrix {
	
	private Long maxRows;
	private Long maxCols;
	public Map<Position, Integer> usedPositionsMap = new HashMap<>();
	
	public SparseMatrix(Long maxRows, Long maxCols) {
		this.maxRows = maxRows;
		this.maxCols = maxCols;
	}
	
	public void setValue(Long row, Long col, Integer value) {
		if (row > this.maxRows || col > this.maxCols) {
			throw new RuntimeException("Indexes out of bound.");
		}
		usedPositionsMap.put(new Position(row, col), value);
	}

}
