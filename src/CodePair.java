import java.lang.String;
public class CodePair {
	char character; 
//	Declaration statement, no assignment 
	String code; 
	public CodePair(char c, String code) {
		this.character = c; 
		this.code = code; 		
	}
	public String getCode() {
		return code; 
	}
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char c) {
		this.character = c; 
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean equals(CodePair anotherPair) {
		return (this.character == anotherPair.character);
	}
}
