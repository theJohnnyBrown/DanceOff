import java.awt.geom.Point2D;

/*
 * n possible moves -> (n+r-1)!/(r!(n-1)!) possible combinations where r=2 so (n+1)!/(2!(n-1)!) turns.
 * 
 * @author johnny
 *
 */
public class DanceBattle {

	private int movesPossible;
	boolean[] filler;
	boolean[][] allTurns;
	boolean iWin;
	
	public DanceBattle(int moves, Node[] used) {
		movesPossible = moves;
		filler = new boolean[moves];
		java.util.Arrays.fill(filler,true);
		allTurns = new boolean[moves][moves];
		java.util.Arrays.fill(allTurns,filler);
		//TODO all searching (and maybe even treebuilding) needs to happen in a findWinStatus(Node nd) method
		//that uses depth-first. maybe.
		for (int i = 0; i<used.length; i++){//fill the matrix of used turns
			allTurns[used[i].getFirstMove()][used[i].getSecondMove()] = false;
			allTurns[used[i].getSecondMove()][used[i].getFirstMove()] = false;
		}//O(n)
		Boolean[] children = allTurns[used.length - 1];
		
		
		/*
		 *here we would model the turns alread taken by setting false the cells in this matrix [first,second]
		 *and also [second,first] (because order doesn't matter for crossing out turns). 
		 *
		 *I need to make a decision tree and then figure out what an optimal player would do with that information
		 */
	}	
	
	public int turnsPossible(int moves){
		return fact(moves+1)/(2*fact(moves-1));
	}
	
	public int fact(int n){//TODO make iterative for efficiency
		if (n==0) return 1;
		else return n*fact(n-1); 
	}
	
	public boolean iWin(){
		return iWin;
	}
	 
}

