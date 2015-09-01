public class SequenceSelector {
	private final static int MAX_SEQUENCE = 20;
	private final static String DELIMINATOR = "###";

	private SequenceSelector(){}

	/* Generates a random sequence in the form of an integer array.
	* @param difficulty An int 1-99 that increases the diffuculty and length.
	* @param x An int that dictates the number of rows the sequence will contain.
	* @param y An int that dictates the number of columns the sequence will contain.
	* @throws IllegalArgumentException thrown if any input is negative or if the difficulty
	*	  is not within 1-99.
	*/
	protected static String[] randomSequence( int difficulty, int x, int y ) {
		//check to see if any of the accepted parameters are invalid.
		if( (difficulty>99 || difficulty<1) || (x<1) || (y<1) )
			throw new IllegalArgumentException("Illegal Args");

		//declare variables needed.
		String[][] temp = new int[x][y];
		int currentOrder = 1;
		int numberOfSequences = difficulty % MAX_SEQUENCE;
		String tempString;
		int randX, randY;		

		//initiate loop to generate the sequence.
		for(int i = 0; i < numberOfSequences; i++){
			randX = generateRandInt(x);
			randY = generateRandInt(y);
			tempString = temp[randX][randY];
			if(tempString == null){
				tempString = "";
				tempString = tempString + (currentOrder++);
			}
			else{
				tempString = tempString + DELIMINATOR + (currentOrder++);
			}
		}

		//concentrates into a single array
		String[] concentratedArray = new Array[x*y];
		int tick = 0;
		for(int i = 0; i<x; i++)
			for(int j = 0; j<y; j++)
				concentratedArray[tick++] = temp[i][j];

		return concentratedArray;
	
	}
	private int generateRandInt ( int size ){
		double genDouble = Math.random();
		return (int)(genDouble * size);
	}
}