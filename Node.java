
public class Node{
	Node myParent;
	Node[] myChildren;
	int numChildren;//TODO make getter
	int firstMove;
	int secondMove;
	
	public int getFirstMove() {
		return firstMove;
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

	public Node(Node parent,int n, int first, int second){
		myParent = parent;
		parent.addChild(this);
		myChildren = new Node[n];//TODO find out if this uses gobs of memory. use an ArrayList?
		numChildren = 0;
		firstMove = first;
		secondMove = second;
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
	
	public boolean isLeaf(){
		return (numChildren == 0);
	}
	
}
