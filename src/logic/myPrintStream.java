package logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class myPrintStream extends PrintStream {

	private static final String newLine = System.getProperty("line.separator");

	private final StringBuffer sb = new StringBuffer();
	private final PrintStream out;

	public myPrintStream(PrintStream out) {
		super(out);
		this.out = out;
	}

	public void print(int i) {
		sb.append(i);
		out.print(i);
	}

	public void print(String str) {
		sb.append(str);
		out.print(str);
	}

	public void println(int i) {
		sb.append(i).append(newLine);
		out.println(i);
	}

	public void println(String str) {
		sb.append(str).append(newLine);
		out.println(str);
	}
	
	public void println() {
		sb.append(newLine);
		out.println();
	}

	public String getAllWrittenText() {
		return sb.toString();
	}

	public void getLog() throws IOException {
		FileWriter fstream = new FileWriter("asdqwe.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		try {
			System.out.println(sb.toString());
			out.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}
}
