
public class Decompress {
	public static void main(String[] args) {
		String compressedFileName = args[0];
		TextFile inputFile = new TextFile(compressedFileName, "read");
		TextFile codeFile = new TextFile(args[1], "read");
		String outputName = args[0].substring(0, args[0].length()-3)+"dec";
		TextFile outputFile = new TextFile(outputName, "write");
		System.out.println("Name of the file to decompress: "+args[0]);
		System.out.println("Name of the file storing compression codes: "+args[1]);
		System.out.println("Name of the output file: "+outputName);
		ArrayCode codeList = new ArrayCode(26);
		String currentLine = " ";
		char currentChar = 0; 
		String currentCode= "";
		currentLine = codeFile.readLine();
		String finalOutput = "";
		int count = 0;
		while (currentLine != null) {
//			count++; 
//			System.out.println(count);
			currentCode = ""; 
			if (currentLine.length() != 0) {
				currentChar = currentLine.charAt(0);
			}
			for (int i = 1; i < currentLine.length(); i++) {  //// GOD BLESS MAX.... UNDERSTAND WHAT HAPPENED HERE 
	
				currentCode += currentLine.charAt(i);
			}
			codeList.add(new CodePair(currentChar, currentCode));
			currentLine = codeFile.readLine();
		}
		char currentCompressChar = ' ';
		String candidateCode = ""; 
		currentCompressChar = inputFile.readChar();
		while (currentCompressChar != 0) {
			candidateCode += currentCompressChar; 
			if (codeList.findCode(candidateCode) == -1) { // code was not found
				currentCompressChar = inputFile.readChar();
				continue;
			}
			else { // is found
				currentChar = codeList.getCharacter(codeList.findCode(candidateCode));
				finalOutput += currentChar; 
				candidateCode = ""; 
			}
			currentCompressChar = inputFile.readChar();
		}
		for (int i = 0; i < finalOutput.length(); i++) {
			outputFile.writeChar(finalOutput.charAt(i));
		}
		System.out.println(finalOutput); 
		outputFile.close();
	}
}
