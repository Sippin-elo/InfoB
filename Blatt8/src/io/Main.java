package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File text = new File("test.txt");
		
		FileSystem root = new FileSystem(text);
		
		FileReader f = new FileReader(text);

		BufferedReader bufRead = null;
		bufRead = new BufferedReader(f);
		
		SearchLineReader slr = new SearchLineReader(bufRead, "test.txt");
		slr.readLine();
		System.out.println(slr.getAmountOfMatches());
	
		
	}

}
