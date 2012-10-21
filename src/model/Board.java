package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Board implements ReadOnlyBoard {

	private final int size = 3;
	private final CellValue[][] matrix;
	
	FileWriter fstream;
	BufferedWriter out = null;

	private int moveCount; 
	
	public Board() {
		this.matrix = new CellValue[3][3];
		clear();
		try {
			log();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void clear() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = CellValue.EMPTY;
			}
		}
		moveCount = 0;
	}
	
	public boolean isFull() {
		return (moveCount == size * size);
	}
	
	public CellValue getValueAt(Cell cell) {
		if (cell.x >= size)
			throw new IllegalArgumentException("X is out of range.");
		if (cell.y >= size)
			throw new IllegalArgumentException("Y is out of range.");
		
		return matrix[cell.x][cell.y];
	}

	public boolean isEmpty(Cell cell) {
		return getValueAt(cell) == CellValue.EMPTY;
	}
	
	public void makeMove(Cell cell, CellValue value){
		if (value==CellValue.EMPTY) 
			throw new IllegalArgumentException("A cell can not be set to emty during move.");
		setValueAt(cell, value);
	}

	public int getSize() {
		return size;
	}

	private void setValueAt(Cell cell, CellValue value) {
		if (!isEmpty(cell)) 
			throw new IllegalArgumentException("The cell is not emty.");
		
		matrix[cell.x][cell.y] = value;
		try {
			append(cell, value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void log() throws IOException{
		fstream = new FileWriter("asdqwe.txt");
		out = new BufferedWriter(fstream);
	}
	
	private void append(Cell cell, CellValue value) throws IOException{
		out.write(""+matrix[cell.x][cell.y]+" "+cell.x+" "+cell.y);
		out.newLine();
	}
	
	public void getLog() throws IOException, IllegalAccessException{
		if(out != null){
			out.flush();
		}else throw new IllegalAccessException("Log not initialized");
			
	}
}