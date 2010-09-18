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
 
 public static void main(String[] args){
  DanceBattle d = new DanceBattle();
  if (d.checkFile(args[0])) System.out.println("win");
  else System.out.println("Lose");
  System.exit(0);
 }
 
 public DanceBattle(){
  
 }
 
 public boolean checkFile(String filename){

  Scanner s = scannerFor(filename);
  int movesPossible = s.nextInt();
  int numTurnsTaken = s.nextInt();
  Node[] turns = new Node[numTurnsTaken];
  turnsUsed = new boolean[movesPossible][movesPossible];
  
  if (s.hasNextInt()) turns[0] = (new Node(movesPossible,s.nextInt(),s.nextInt()));
  for (int i = 1; i<numTurnsTaken; i++){
   turns[i] = (new Node(turns[i-1],movesPossible,s.nextInt(),s.nextInt()));
   chekov(turns[i]);
  }
  
  boolean iAmLast = !(numTurnsTaken%2 == 0);
  return (iAmLast == findWinStatus(turns[turns.length - 1])); 

 }
 
 public Scanner scannerFor(String filename){
	 Scanner s = new Scanner("");
	  try{
	  s = new Scanner(new File(filename));
	  }
	  catch (FileNotFoundException e){
	    System.out.println("File: "+filename+" not found");
	    System.exit(0);
	  }
	  return s;
 }
  
 

 
 public boolean findWinStatus(Node nd){
  boolean isWinner = true;
  chekov(nd);
  nd.haveChildren(turnsUsed);

  Node[] children = nd.getMyChildren();
  for (int i = 0; i<nd.getNumChildren() && isWinner;i++){
   Node child = children[i];
   if (child.getFirstMove() == child.getSecondMove()) isWinner = false;
  }
  for (int i = 0; i<nd.getNumChildren() && isWinner;i++){
   Node child = children[i];
   if (findWinStatus(child)) isWinner = false;
  }
  unCheck(nd); 
  return isWinner;
 }
 
 private void chekov(Node nd){
	 turnsUsed[nd.getFirstMove()][nd.getSecondMove()] = true;
	 turnsUsed[nd.getSecondMove()][nd.getFirstMove()] = true;
 }
 
 private void unCheck(Node nd){
	 turnsUsed[nd.getFirstMove()][nd.getSecondMove()] = false;
	 turnsUsed[nd.getSecondMove()][nd.getFirstMove()] = false; 
 }
  
}

