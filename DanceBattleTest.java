import junit.framework.TestCase;

//TODO make longer unit tests to compare times
// check breadth-first, move isLeaf() check to first loop - this doesn;t work b/c child does not know if 
// it is a leaf until haveChildren is called in findWinStatus(child).
public class DanceBattleTest extends TestCase {
String dataPath;

 protected void setUp() throws Exception {
  super.setUp();
  System.out.println("--");
  dataPath = "data/";
 }
 
 
 
 public void testDanceBattle32(){
  DanceBattle d = new DanceBattle();
  assertTrue(d.checkFile(dataPath+"test32.txt"));
 }
 
 public void testDanceBattle31(){
  DanceBattle d = new DanceBattle();
  assertTrue(d.checkFile(dataPath+"test31.txt"));
 }
 
 public void testDanceBattle43(){
  DanceBattle d = new DanceBattle();
  assertFalse(d.checkFile(dataPath+"test43.txt"));
 }
 
 public void testDanceBattle44(){
  DanceBattle d = new DanceBattle();
  assertFalse(d.checkFile(dataPath+"test44.txt"));
 }
 
 public void testDanceBattle45(){
  DanceBattle d = new DanceBattle();
  assertFalse(d.checkFile(dataPath+"test45.txt"));
 }
 
 public void testDanceBattle52(){
  DanceBattle d = new DanceBattle();
  assertTrue(d.checkFile(dataPath+"test52.txt"));
 }
 
 public void testDanceBattle55(){
  DanceBattle d = new DanceBattle();
  assertFalse(d.checkFile(dataPath+"test55.txt"));
 }
 
 public void testDanceBattle56(){
  DanceBattle d = new DanceBattle();
  assertTrue(d.checkFile(dataPath+"test56.txt"));
 }
 
 public void testDanceBattle57(){
  DanceBattle d = new DanceBattle();
  assertFalse(d.checkFile(dataPath+"test57.txt"));
 }
 
 public void testDanceBattle714(){
  DanceBattle d = new DanceBattle();
  assertTrue(d.checkFile(dataPath+"test714.txt"));
 }
 
 public void testDanceBattle77(){
  DanceBattle d = new DanceBattle();
  assertFalse(d.checkFile(dataPath+"test77.txt"));
 }
 
 public void testDanceBattle102(){
  DanceBattle d = new DanceBattle();
  assertTrue(d.checkFile(dataPath+"test102.txt"));
 }
 
 public void testDanceBattle34(){//given is leaf
  DanceBattle d = new DanceBattle();
  assertFalse(d.checkFile(dataPath+"test34.txt"));
 }
 
 public void testDanceBattle64(){//seed 6 0
  DanceBattle d = new DanceBattle();
  assertFalse(d.checkFile(dataPath+"test60.txt"));
 }

     public void testDanceBattle30(){
	 DanceBattle d = new DanceBattle();
	 assertTrue(d.checkFile(dataPath+"test30.txt"));}

public void testDanceBattle65(){//seed65
DanceBattle d = new DanceBattle();
assertFalse(d.checkFile(dataPath+"test65.txt"));}

public void testDanceBattle63(){//seed612
DanceBattle d = new DanceBattle();
assertFalse(d.checkFile(dataPath+"test612.txt"));}

public void testDanceBattle62(){//seed613
DanceBattle d = new DanceBattle();
assertTrue(d.checkFile(dataPath+"test613.txt"));}

public void testDanceBattle61(){//seed614
DanceBattle d = new DanceBattle();
assertFalse(d.checkFile(dataPath+"test614.txt"));}}
