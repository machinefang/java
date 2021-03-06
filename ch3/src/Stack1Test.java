import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Stack1Test {
	private final int a = 0;
	private Stack1[] stacks;

	@Before
	public void setUp(){
		stacks = new Stack1[3]; // this new just create an array
		
		for (int i=0; i<3; i++ ){
			stacks[i] = new Stack1();
		}
	}
	@After
	public void clean(){
		Stack1.clear(); // set numOfStacks to 0
	}
	
	@Test
	public void testConstructor(){
		assertEquals(3,Stack1.numOfStack);
		
		for (int i=0; i<3; i++){
			stacks[i] = null;
		}
		Stack1.clear();  // set nunOfStacks to 0
		assertEquals(0,Stack1.numOfStack);
	}

	@Test
	public void testPush() {		
		for(int i=0; i<30; i++){
			int stackIndex = i/10;
			Integer item = new Integer(i);
			stacks[stackIndex].push(item);
		}
		
		for(int i=0; i<30; i++){
			assertEquals(i,((Integer)Stack1.getItem(i)).intValue());
		}
	}

	@Test
	public void testIsEmpty() {
		stacks[0].push(new Integer(1));
		stacks[0].pop();
		assertEquals(true,stacks[0].isEmpty());		
	}

	@Test
	public void testIsFull() {
		for(int i=0; i<10; i++){
			stacks[0].push(new Integer(i));
		}
		assertEquals(true,stacks[0].isFull());
	}

	@Test
	public void testPop() {
		for(int i=0; i<30; i++){
			int stackIndex = i/10;
			Integer item = new Integer(i);
			stacks[stackIndex].push(item);
		}
		//System.out.println(stacks[2].getTop());
		int[] st1PopOutSequence = {9,8,7,6,5,4,3,2,1,0};
		int[] st2PopOutSequence = {19,18,17,16,15,14,13,12,11,10};
		int[] st3PopOutSequence = {29,28,27,26,25,24,23,22,21,20};
		int[] st[] = {st1PopOutSequence,st2PopOutSequence,st3PopOutSequence};
		
		for(int i=0; i<3; i++){
			for(int j = 0; j<10; j++){
				assertEquals(st[i][j],((Integer)stacks[i].pop()).intValue());
			}
		}
		assertEquals(null,stacks[0].pop());
	}

	@Test
	public void testPeek() {
		for(int i=0; i<10; i++){
			stacks[0].push(new Integer(i));
		}
		assertEquals(9,((Integer)stacks[0].peek()).intValue());
	}

}
