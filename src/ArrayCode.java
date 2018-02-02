
public class ArrayCode {
	public static void main(String[] args) {
	}
	CodePair[] pairArray;
	int size; 
	int numPairs; 
	public ArrayCode(int size) {
		this.size = size; 
		this.pairArray = new CodePair[size]; 
		this.numPairs = 0; 
	}
	public void add(CodePair pair) {
		
		if (this.numPairs == (this.pairArray.length)) {
			this.expandCapacity();
		}
		this.pairArray[numPairs] = pair; 
		this.numPairs++;  
		
	
		
	}
	private void expandCapacity() {
		CodePair[] largerList; 
		if(this.pairArray.length <= 100) {
			largerList = new CodePair[this.pairArray.length*2];
			this.size = this.size*2; 
			}else {
				largerList = new CodePair[this.pairArray.length + 20];
				this.size = this.size+20; 
			}
		
		
		for (int i = 0; i <pairArray.length; i++) {
			largerList[i] = pairArray[i]; 
		}
		pairArray = largerList; 	
	}
	
	public void remove(CodePair pairToRemove) {
		int index = -1; 
		for(int i=0; i < this.pairArray.length; i++) {
			if(pairArray[i].equals(pairToRemove)) {
				index = i; 
				break; 
			}
		}
		if (index == -1){
			return;
		}
		if (index == this.pairArray.length-1) {
			this.pairArray[index] = null; 
		}
		else {
			for (int i = index+1; i < this.pairArray.length; i++) {
				this.pairArray[i-1] = this.pairArray[i]; 
			}
		}
	
		this.numPairs--;
		if (numPairs < this.pairArray.length/4) {
			CodePair[] smallerList; 
			smallerList = new CodePair[this.pairArray.length/2];
			for (int i = 0; i < pairArray.length/2; i++) {
				smallerList[i] = pairArray[i]; 
			}
			this.size = smallerList.length;
			pairArray = smallerList;	
		}
		
	}
	public int findCode(String code){
		for (int i =0; i < numPairs; i++) {
			if (this.pairArray[i].getCode().equals(code)) {
				return i;
			}
//			String retrievedCode = pairArray[i].getCode();
//			boolean match = (retrievedCode.equals(code));
//			if(match) {
//				return i; 
//			}	
		}
		return -1;
		
	}
	public int findCharacter(char c) {
		for (int i =0; i < numPairs; i++) {
			if(pairArray[i].getCharacter() == c) {
				return i; 
			}	
		}
		return -1;
		
	}
	public String getCode(int i) {
		if(i < 0 || i >= numPairs) {
			return null; 
		}
		return(pairArray[i].getCode());
	}
	public char getCharacter(int i) {
		if(i < 0 || i >= numPairs) {
			return 0; 
		}
		return(pairArray[i].getCharacter());
	}
	public int getSize() {
		return this.size;
	}
	public int getNumPairs() {
		return this.numPairs;
	}
}
