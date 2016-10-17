package com.test.hackerrank.weekofcode24.challenge3;

public class ChessMoves {

	public static void main(String[] args) {
		int[][] chessBoard = new int[4][4];
		 int initialRow = 1;
		 int initialCol = 1;
		 chessBoard[initialRow][initialCol] = 1;
		 
		 generateQueensPossibleMoves(chessBoard, initialRow, initialCol);
		 
		 generateRooksPossibleMoves(chessBoard, initialRow, initialCol);
		 
		 generateBishopsPossibleMoves(chessBoard, initialRow, initialCol);
		 
		 generateKnightsPossibleMoves(chessBoard, initialRow, initialCol);
		 
		 for (int i=0; i < chessBoard.length; i++) {
			 for (int j=0; j<chessBoard[i].length; j++) {
				 System.out.print(chessBoard[i][j] + " ");
			 }
			 System.out.println();
		 }
	}

	private static void generateQueensPossibleMoves(int[][] chessBoard, int queenInitialRow, int queenInitialCol) {
		
		generateHorizontalMoves(chessBoard, queenInitialRow, queenInitialCol);
		
		generateVerticalMoves(chessBoard, queenInitialRow, queenInitialCol);
		
		generateDiagonalMoves(chessBoard, queenInitialRow, queenInitialCol);
	}
	
	private static void generateRooksPossibleMoves(int[][] chessBoard, int rookInitialRow, int rookInitialCol) {
		
		generateHorizontalMoves(chessBoard, rookInitialRow, rookInitialCol);
		
		generateVerticalMoves(chessBoard, rookInitialRow, rookInitialCol);
	}
	
	private static void generateBishopsPossibleMoves(int[][] chessBoard, int bishopInitialRow, int bishopInitialCol) {
		
		generateDiagonalMoves(chessBoard, bishopInitialRow, bishopInitialCol);
	}
	
	private static void generateKnightsPossibleMoves(int[][] chessBoard, int knightInitialRow, int knightInitialCol) {
		
		generateKnightsHorizontalMoves(chessBoard, knightInitialRow, knightInitialCol);
		
		generateKnightsVerticalMoves(chessBoard, knightInitialRow, knightInitialCol);
		
	}
	
	private static void generateHorizontalMoves(int[][] chessBoard, int initialRow, int initialCol) {
		for (int row=(initialRow + 1); row < chessBoard.length; row++) {
			chessBoard[row][initialCol] = 1;
		}
		for (int row=(initialRow - 1); row >= 0; row--) {
			chessBoard[row][initialCol] = 1;
		}
		
	}
	
	private static void generateVerticalMoves(int[][] chessBoard, int initialRow, int initialCol) {
		for (int col=(initialCol + 1); col < chessBoard[initialRow].length; col++) {
			chessBoard[initialRow][col] = 1;
		}
		for (int col=(initialCol - 1); col >= 0; col--) {
			chessBoard[initialRow][col] = 1;
		}
	}

	private static void generateDiagonalMoves(int[][] chessBoard, int initialRow, int initialCol) {
		for (int row=(initialRow + 1), col=(initialCol + 1); row < chessBoard.length && col < chessBoard[row].length; row++, col++) {
			chessBoard[row][col] = 1;
		}
		for (int row=(initialRow + 1), col=(initialCol - 1); row < chessBoard.length && col >= 0; row++, col--) {
			chessBoard[row][col] = 1;
		}
		for (int row=(initialRow - 1), col=(initialCol + 1); row >= 0 && col < chessBoard[row].length; row--, col++) {
			chessBoard[row][col] = 1;
		}
		for (int row=(initialRow - 1), col=(initialCol - 1); row >= 0 && col >= 0; row--, col--) {
			chessBoard[row][col] = 1;
		}
	}
	
	private static void generateKnightsHorizontalMoves(int[][] chessBoard, int initialRow, int initialCol) {
		
		if (initialRow + 2 < chessBoard.length && initialCol - 1 >= 0) {
			chessBoard[initialRow + 2][initialCol - 1] = 1;
		}
		if (initialRow + 2 < chessBoard.length && initialCol + 1 < chessBoard[initialRow + 2].length) {
			chessBoard[initialRow + 2][initialCol + 1] = 1;
		}
		if (initialRow - 2 >= 0 && initialCol - 1 >= 0) {
			chessBoard[initialRow - 2][initialCol - 1] = 1;
		}
		if (initialRow - 2 >= 0 && initialCol + 1 < chessBoard[initialRow - 2].length) {
			chessBoard[initialRow - 2][initialCol + 1] = 1;
		}
	}
	
	private static void generateKnightsVerticalMoves(int[][] chessBoard, int initialRow, int initialCol) {
		
		if (initialRow + 1 < chessBoard.length && initialCol + 2 < chessBoard[initialRow + 1].length) {
			chessBoard[initialRow + 1][initialCol + 2] = 1;
		}
		if (initialRow - 1 >= 0 && initialCol + 2 < chessBoard[initialRow - 1].length) {
			chessBoard[initialRow - 1][initialCol + 2] = 1;
		}
		if (initialRow + 1 < chessBoard.length && initialCol - 2 >= 0) {
			chessBoard[initialRow + 1][initialCol - 2] = 1;
		}
		if (initialRow - 1 >= 0 && initialCol - 2 >= 0) {
			chessBoard[initialRow - 1][initialCol - 2] = 1;
		}
	}
	
}
