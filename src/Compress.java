import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Compress {
	public static void main(String[] args) {
//		System.out.println("hello");
		TextFile inputFile = new TextFile(args[0], "read");
		TextFile codeFile = new TextFile(args[1], "read");
		String outputName = args[0].substring(0, args[0].length()-3)+"zzz";
		CompressedFile outputFile = new CompressedFile(outputName, "write");
		System.out.println("Name of the file to compress: "+args[0]);
		System.out.println("Name of the file storing compression codes: "+args[1]);
		System.out.println("Name of the output file: "+outputName);



//	 put a try and catch block to ensure if you can open file or not 
		ArrayCode codeList = new ArrayCode(26);
		String currentLine = " ";
		char currentChar; 
		String currentCode= "";
		currentLine = codeFile.readLine();
		String finalOutput = "";
//		int count = 0;
		while (currentLine != null) {
////			cu = currentLine.replaceAll("\\r\\n|\\r|\\n", " ");
//			count++; 
//			System.out.println(count); ////// ONLY ONE LINE READSS.......
			currentCode = ""; 
			if(currentLine.length() == 0) {
				currentLine = codeFile.readLine();
//				continue;
			}
			currentChar = currentLine.charAt(0);
			for (int i = 1; i < currentLine.length(); i++) {
				if(currentLine.charAt(i) != '\n' && currentLine.charAt(i) != '\r') {
					currentCode += currentLine.charAt(i);
				}
			}
			codeList.add(new CodePair(currentChar, currentCode));
			currentLine = codeFile.readLine();
		}
		char currentCompressChar = inputFile.readChar();
		System.out.println("Begin compression");
		int currentIndex;
		while (currentCompressChar != 0) {
				System.out.println("compress char");
				currentIndex = codeList.findCharacter(currentCompressChar);
				if(currentIndex == -1) {
					return;
				}
				String currentOutput = codeList.getCode(currentIndex); 
				finalOutput += currentOutput; 	
				currentCompressChar = inputFile.readChar();
		}
		System.out.println("Compression completed");
		for (int i = 0; i < finalOutput.length(); i++) {
			outputFile.writeBit(finalOutput.charAt(i));
		}
		System.out.println(finalOutput);
		outputFile.close();
		inputFile.close();
		codeFile.close();
	}
	

}
