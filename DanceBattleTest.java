import junit.framework.TestCase;


public class DanceBattleTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	
	
	public void testDanceBattle32(){
		DanceBattle d = new DanceBattle();
		assertTrue(d.checkFile("data/test32.txt"));
	}
	
	public void testDanceBattle31(){
		DanceBattle d = new DanceBattle();
		assertTrue(d.checkFile("data/test31.txt"));
	}
	
	public void testDanceBattle43(){
		DanceBattle d = new DanceBattle();
		assertFalse(d.checkFile("data/test43.txt"));
	}
	
	public void testDanceBattle44(){
		DanceBattle d = new DanceBattle();
		assertFalse(d.checkFile("data/test44.txt"));
	}
	
	public void testDanceBattle45(){
		DanceBattle d = new DanceBattle();
		assertFalse(d.checkFile("data/test45.txt"));
	}
	
	public void testDanceBattle52(){
		DanceBattle d = new DanceBattle();
		assertTrue(d.checkFile("data/test52.txt"));
	}
	
	public void testDanceBattle55(){
		DanceBattle d = new DanceBattle();
		assertFalse(d.checkFile("data/test55.txt"));
	}
	
	public void testDanceBattle56(){
		DanceBattle d = new DanceBattle();
		assertTrue(d.checkFile("data/test56.txt"));
	}
	
	public void testDanceBattle57(){
		DanceBattle d = new DanceBattle();
		assertFalse(d.checkFile("data/test57.txt"));
	}
	
	public void testDanceBattle714(){
		DanceBattle d = new DanceBattle();
		assertTrue(d.checkFile("data/test714.txt"));
	}
	
	public void testDanceBattle77(){
		DanceBattle d = new DanceBattle();
		assertFalse(d.checkFile("data/test77.txt"));
	}

}
