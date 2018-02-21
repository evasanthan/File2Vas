import junit.framework.TestCase;

public class StackTest extends TestCase {

	Stack emptyStack = new Stack();
	Stack singleStack = new Stack();
	Stack manyStack = new Stack();
	
	protected void setUp() {
		singleStack.push(1);
		manyStack.push("a");
		manyStack.push("b");
	}
	
	public void testEmpty() {
		assertTrue(emptyStack.isEmpty());
		assertFalse(singleStack.isEmpty());
		assertFalse(manyStack.isEmpty());
	}
	
	public void testPeek() {
		assertNull(emptyStack.peek());
		assertEquals(1, singleStack.peek());
		assertEquals("b", manyStack.peek());
	}
	
	public void testPop() {
		assertEquals(1, singleStack.pop());
		
		assertEquals("b", manyStack.pop());
		assertEquals("a", manyStack.pop());
		assertNull(manyStack.pop());
		
		assertNull(emptyStack.pop());
	}
	
	public void testPopPeek() {
		assertEquals(1, singleStack.pop());
		assertNull(singleStack.peek());
		assertTrue(singleStack.isEmpty());
		
		assertEquals("b", manyStack.pop());
		assertEquals("a", manyStack.peek());
	}
	
	public void testContains() {
		assertTrue(singleStack.contains(1));
		assertFalse(singleStack.contains(2));
		
		assertFalse(emptyStack.contains("anything"));
		
		assertTrue(manyStack.contains("a"));
		assertTrue(manyStack.contains("b"));
		assertFalse(manyStack.contains("c"));
	}
	
	public void testSize() {
		assertEquals(0, emptyStack.size());
		assertEquals(1, singleStack.size());
		assertEquals(2, manyStack.size());
		
		manyStack.pop();
		assertEquals(1, manyStack.size());
		
		singleStack.pop();
		assertEquals(0, singleStack.size());
		
		emptyStack.pop();
		assertEquals(0, emptyStack.size());
	}
	
	public void testPeekN() {
		assertNull(emptyStack.peek(1));
		
		assertEquals(1, singleStack.peek(0));
		assertEquals("b", manyStack.peek(0));
		assertEquals("a", manyStack.peek(1));
		assertNull(manyStack.peek(2));
	}
	
		
}
