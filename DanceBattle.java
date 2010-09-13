import java.io.*;
import java.util.*;


/*
 * n possible moves -> (n+r-1)!/(r!(n-1)!) possible combinations where r=2 so (n+1)!/(2!(n-1)!) turns.
 * 
 * @author johnny
 *
 */
public class DanceBattle {

	boolean[][] turnsUsed;
	boolean lastIsWinner;
	
	public static void main(String[] args){
		Scanner s = new Scanner("");
		try{
		s = new Scanner(new File(args[0]));
		}
		catch (FileNotFoundException e){
			
		}
		int movesPossible = s.nextInt();
		int numTurnsTaken = s.nextInt();
	    Node[] turns = new Node[numTurnsTaken];
	    if (s.hasNextInt()) turns[0] = (new Node(movesPossible,s.nextInt(),s.nextInt()));
		for (int i = 1; i<numTurnsTaken; i++){
			turns[i] = (new Node(turns[i-1],movesPossible,s.nextInt(),s.nextInt()));
		}
		DanceBattle d = new DanceBattle(movesPossible,turns);
		boolean iAmLast = !(numTurnsTaken%2 == 0);
		if (iAmLast == d.lastIsWinner()) System.out.println("win");
		else System.out.println("lose");
		
	}
	
	public DanceBattle(){
		
	}
	
	public boolean checkFile(String filename){
		Scanner s = new Scanner("");
		try{
		s = new Scanner(new File(filename));
		}
		catch (FileNotFoundException e){
			
		}
		int movesPossible = s.nextInt();
		int numTurnsTaken = s.nextInt();
	    Node[] turns = new Node[numTurnsTaken];
	    if (s.hasNextInt()) turns[0] = (new Node(movesPossible,s.nextInt(),s.nextInt()));
		for (int i = 1; i<numTurnsTaken; i++){
			turns[i] = (new Node(turns[i-1],movesPossible,s.nextInt(),s.nextInt()));
		}
		turnsUsed = new boolean[movesPossible][movesPossible];
		for (int i = 0; i<turns.length; i++){//fill the matrix of used turns. maybe do this as we read them
			turnsUsed[turns[i].getFirstMove()][turns[i].getSecondMove()] = true;
			turnsUsed[turns[i].getSecondMove()][turns[i].getFirstMove()] = true;
		}//O(n)
		lastIsWinner = findWinStatus(turns[turns.length - 1]);
		boolean iAmLast = !(numTurnsTaken%2 == 0);
		return (iAmLast == lastIsWinner); 

	}
	
	public DanceBattle(int moves, Node[] used) {
		turnsUsed = new boolean[moves][moves];
		for (int i = 0; i<used.length; i++){//fill the matrix of used turns. maybe do this as we read them
			turnsUsed[used[i].getFirstMove()][used[i].getSecondMove()] = true;
			turnsUsed[used[i].getSecondMove()][used[i].getFirstMove()] = true;
		}//O(n)
		lastIsWinner = findWinStatus(used[used.length - 1]);
		
		
		/*
		 *here we would model the turns alread taken by setting false the cells in this matrix [first,second]
		 *and also [second,first] (because order doesn't matter for crossing out turns). 
		 *
		 *I need to make a decision tree and then figure out what an optimal player would do with that information
		 */
	}	
	
	public boolean lastIsWinner(){
		return lastIsWinner;
	}
	
	public boolean findWinStatus(Node nd){
		boolean isWinner = true;
		turnsUsed[nd.getFirstMove()][nd.getSecondMove()] = true;
		turnsUsed[nd.getSecondMove()][nd.getFirstMove()] = true;
		nd.haveChildren(turnsUsed);
		if (nd.isLeaf()){			
			turnsUsed[nd.getFirstMove()][nd.getSecondMove()] = false;
			turnsUsed[nd.getSecondMove()][nd.getFirstMove()] = false;
			return isWinner;
		}
		Node[] children = nd.getMyChildren();
		for (int i = 0; i<nd.getNumChildren() && isWinner;i++){
			Node child = children[i];
			if (findWinStatus(child)) isWinner = false;
		}
		turnsUsed[nd.getFirstMove()][nd.getSecondMove()] = false;
		turnsUsed[nd.getSecondMove()][nd.getFirstMove()] = false;
		return isWinner;
	}
	 
}

