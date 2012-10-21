package crosscutting;

import java.io.IOException;
import java.util.Scanner;

import logic.*;
import model.*;
import ui.*;

import ui.ConsolePresenter;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		myPrintStream asd = new myPrintStream(System.out);
//		System.setOut(asd);
		
		Presenter presenter = new ConsolePresenter(System.out);
		Board board = new Board();
		Player xPlayer = new ConsolePlayer(scanner, System.out);
		Player oPlayer = new ConsolePlayer(scanner, System.out);
		Referee referee = new PrimeReferee();
		
		Game game = new Game(board, xPlayer, oPlayer, referee, presenter);
		game.play();
		try {
			board.getLog();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.close();
	}
}
