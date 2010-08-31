
public class Node{
	Node myParent;
	Node[] myChildren;
	int numChildren;
	int firstMove;
	int secondMove;
	
	public Node(Node parent,int n, int first, int second){
		myParent = parent;
		myChildren = new Node[n];//TODO find out if this uses gobs of memory. use an ArrayList?
		numChildren = 0;
		firstMove = first;
		secondMove = second;
	}
	
	public int getFirstMove() {
		return firstMove;
	}
	
	public void haveChildren(boolean[][] used){
		//we assume this is checked off
		for (int n = 0; n<used.length; n++){
		  if(!used[this.secondMove][n]){
			  this.addChild(new Node(this,used.length,this.secondMove,n));
		  }
		}
	}
	
	public int getNumChildren(){
		return numChildren;
	}

	public void setFirstMove(int firstMove) {
		this.firstMove = firstMove;
	}

	public int getSecondMove() {
		return secondMove;
	}

	public void setSecondMove(int secondMove) {
		this.secondMove = secondMove;
	}
	
	public Node(int n, int first, int second){
		myParent = this;//look up in N/H how they did this for linked lists
		myChildren = new Node[n];
		numChildren = 0;
		firstMove = first;
		secondMove = second;
	}

	public Node getMyParent() {
		return myParent;
	}

	public void setMyParent(Node myParent) {
		this.myParent = myParent;
	}

	public Node[] getMyChildren() {
		return myChildren;
	}
	
	public void addChild(Node newChild){
		myChildren[numChildren] = newChild;
		numChildren++;
	}
	
	public boolean isLeaf(){/*
		String isLeaf;
		if (numChildren==0) isLeaf = "is a leaf";
		else isLeaf = "is not a leaf";
		System.out.println(this.getFirstMove()+ " " + this.getSecondMove()+ " " + isLeaf + " parent is " + myParent.getFirstMove() + " " + myParent.getSecondMove());
		*/
		return (numChildren == 0);
	}
	
}
