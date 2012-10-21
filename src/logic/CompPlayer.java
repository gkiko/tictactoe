package logic;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Cell;
import model.ReadOnlyBoard;

import ui.ConsolePlayer;

public class CompPlayer extends ConsolePlayer {
	private final PrintStream out;

	public CompPlayer(Scanner scanner, PrintStream out) {
		super(scanner, out);
		this.out = out;
	}
	
	public void makeMove(ReadOnlyBoard board, PlayerColor playerColor,
			MoveListener moveListener) {

		Cell nextMove = nextMoveUntilLegal(board);
		moveListener.makeMove(nextMove);
		int[][] arr = board.getMatrix();
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
			}System.out.println();
		}
	}
	
	private Cell nextMoveUntilLegal(ReadOnlyBoard board) {
		while (true) {
			try {
				int[] arr = move();
				int x = arr[0];
				int y = arr[1];
				Cell moveCandidate = new Cell(x, y);
				Boolean isEmpty = board.isEmpty(moveCandidate);
				if (isEmpty) {
					return moveCandidate;
				} else {
					out.println("Cell is not empty.");
				}

			} catch (IllegalArgumentException e) {
				out.println(e.getMessage());
			}
		}
	}

	private int[] move() {
		int x = (int) (Math.random()*3);
		int y = (int) (Math.random()*3);
		return new int[]{x,y};
	}
}
