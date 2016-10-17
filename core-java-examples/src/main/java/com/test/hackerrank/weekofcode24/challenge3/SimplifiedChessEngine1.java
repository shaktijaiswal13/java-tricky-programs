package com.test.hackerrank.weekofcode24.challenge3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimplifiedChessEngine1 {

	public static void main(String[] args) {
		List<ChessPieceInfo> whitePiecesList = new ArrayList<>(); 
		List<ChessPieceInfo> blackPiecesList = new ArrayList<>(); 
		int noOfMoves = 0;
		Scanner scan = new Scanner(System.in);
		int noOfGames = scan.nextInt();
		
		for (int noOfGames_i=0; noOfGames_i < noOfGames; noOfGames_i++) {
			int whitePieces = scan.nextInt();
			int blackPieces = scan.nextInt();
			noOfMoves = scan.nextInt();
			
			for (int whitePieces_i=0; whitePieces_i < whitePieces; whitePieces_i++) {
				String piece = scan.next();
				String column = scan.next();
				int row = scan.nextInt();
				Position position = null;
				if (column.equals("A")) {
					position = new Position(row-1, 0);
				} else if (column.equals("B")) {
					position = new Position(row-1, 1);
				} else if (column.equals("C")) {
					position = new Position(row-1, 2);
				} else if (column.equals("D")) {
					position = new Position(row-1, 3);
				}
				ChessPieceInfo pieceInfo = new ChessPieceInfo("White", piece, position);
				whitePiecesList.add(pieceInfo);
			}
			for (int blackPieces_i=0; blackPieces_i < blackPieces; blackPieces_i++) {
				String piece = scan.next();
				String column = scan.next();
				int row = scan.nextInt();
				Position position = null;
				if (column.equals("A")) {
					position = new Position(row-1, 0);
				} else if (column.equals("B")) {
					position = new Position(row-1, 1);
				} else if (column.equals("C")) {
					position = new Position(row-1, 2);
				} else if (column.equals("D")) {
					position = new Position(row-1, 3);
				}
				ChessPieceInfo pieceInfo = new ChessPieceInfo("Black", piece, position);
				blackPiecesList.add(pieceInfo);
			}
		}
		scan.close();

		for (ChessPieceInfo pieceInfo : whitePiecesList) {
			
			if (pieceInfo.getPiece().equals("N")) {
				int moves = 0;
				while (moves++ <= noOfMoves) {
					List<Position> possiblePositions = generateKnightsPossibleMoves(pieceInfo.getPosition().getRow(), pieceInfo.getPosition().getCol());
					for (Position pos : possiblePositions) {
						for (ChessPieceInfo blackPiece : blackPiecesList) {
							if (pos.getRow() == blackPiece.getPosition().getRow() && pos.getCol() == blackPiece.getPosition().getCol()) {
								if (blackPiece.getPiece().equals("Q")) {
									if (moves <= noOfMoves) {
										System.out.println("YES");
									}
									return;
								} else {
									
								}
							} 
						}
					}
					
				}
			}
		}
	}
	
	private static List<Position> generateKnightsPossibleMoves(int knightInitialRow, int knightInitialCol) {
		
		List<Position> knightPossiblePositions = new ArrayList<>();
		
		generateKnightsHorizontalMoves(knightInitialRow, knightInitialCol, knightPossiblePositions);
		
		generateKnightsVerticalMoves(knightInitialRow, knightInitialCol, knightPossiblePositions);
		
		return knightPossiblePositions;
	}
	
private static void generateKnightsHorizontalMoves(int initialRow, int initialCol, List<Position> knightPossiblePositions) {
		
		if (initialRow + 2 < 4 && initialCol - 1 >= 0) {
			Position position = new Position(initialRow + 2, initialCol - 1);
			knightPossiblePositions.add(position);
		}
		if (initialRow + 2 < 4 && initialCol + 1 < 4) {
			Position position = new Position(initialRow + 2, initialCol + 1);
			knightPossiblePositions.add(position);
		}
		if (initialRow - 2 >= 0 && initialCol - 1 >= 0) {
			Position position = new Position(initialRow - 2, initialCol - 1);
			knightPossiblePositions.add(position);
		}
		if (initialRow - 2 >= 0 && initialCol + 1 < 4) {
			Position position = new Position(initialRow - 2, initialCol + 1);
			knightPossiblePositions.add(position);
		}
	}
	
	private static void generateKnightsVerticalMoves(int initialRow, int initialCol, List<Position> knightPossiblePositions) {
		
		if (initialRow + 1 < 4 && initialCol + 2 < 4) {
			Position position = new Position(initialRow + 1, initialCol + 2);
			knightPossiblePositions.add(position);
		}
		if (initialRow - 1 >= 0 && initialCol + 2 < 4) {
			Position position = new Position(initialRow - 1, initialCol + 2);
			knightPossiblePositions.add(position);
		}
		if (initialRow + 1 < 4 && initialCol - 2 >= 0) {
			Position position = new Position(initialRow + 1, initialCol - 2);
			knightPossiblePositions.add(position);
		}
		if (initialRow - 1 >= 0 && initialCol - 2 >= 0) {
			Position position = new Position(initialRow - 1, initialCol - 2);
			knightPossiblePositions.add(position);
		}
	}

}

class ChessPieceInfo {
	
	private String color;
	private String piece;
	private Position position;
	
	public ChessPieceInfo(String color, String piece, Position position) {
		this.color = color;
		this.piece = piece;
		this.position = position;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}

class Position {

	private int row;
	private int col;
	
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
}