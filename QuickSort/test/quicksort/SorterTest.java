/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author j.cheesman
 */
public class SorterTest {
    
    private Sorter sorter;
    
    
    public SorterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        sorter = new Sorter();
    }
    
    @After
    public void tearDown() {
        sorter = null;
    }

    @Test
    public void testsort() {
        System.out.println("testsort");
        int[] unsorted = {3,2,1,4,6,7,5};
        int[] sorted = {1,2,3,4,5,6,7};
        final int steps = 11;
        runTest(sorted, unsorted, steps);
        sorter.setPivotPosition(PivotPosition.LEFT);
        runTest(sorted, unsorted, 23);
        sorter.setPivotPosition(PivotPosition.RIGHT);
        runTest(sorted, unsorted, 36);
        sorter.setPivotPosition(PivotPosition.RANDOM);
        assertArrayEquals(sorted, sorter.sort(sorted));        
    }
    
    @Test
    public void testsortShort() {
        System.out.println("testsort");
        int[] unsorted = {3,2,1};
        int[] sorted = {1,2,3};

        runTest(sorted, unsorted, 2);
        sorter.setPivotPosition(PivotPosition.LEFT);
        runTest(sorted, unsorted, 5);
        sorter.setPivotPosition(PivotPosition.RIGHT);
        runTest(sorted, unsorted, 8);
        sorter.setPivotPosition(PivotPosition.RANDOM);
        assertArrayEquals(sorted, sorter.sort(sorted));        
    }
    
    
    @Test
    public void testsort_rh1() {
        System.out.println("testsort_rh1");
        int[] unsorted = {1,2,3,4,5,7,6};
        int[] sorted = {1,2,3,4,5,6,7};
        final int steps = 11;
        runTest(sorted, unsorted, steps);
        sorter.setPivotPosition(PivotPosition.LEFT);
        runTest(sorted, unsorted,32);
        sorter.setPivotPosition(PivotPosition.RIGHT);
        runTest(sorted, unsorted, 48);
        sorter.setPivotPosition(PivotPosition.RANDOM);
        assertArrayEquals(sorted, sorter.sort(sorted));        
    }    
    
    @Test
    public void testsort_lh1() {
        System.out.println("testsort_rh1");
        int[] unsorted = {2,1,3,4,5,6,7};
        int[] sorted = {1,2,3,4,5,6,7};
        final int steps = 11;
        runTest(sorted, unsorted, steps);
        sorter.setPivotPosition(PivotPosition.LEFT);
        runTest(sorted, unsorted, 27);
        sorter.setPivotPosition(PivotPosition.RIGHT);
        runTest(sorted, unsorted, 48);     
        sorter.setPivotPosition(PivotPosition.RANDOM);
        assertArrayEquals(sorted, sorter.sort(sorted));        
    }        

    @Test
    public void testsort_none() {
        System.out.println("testsort_none");
        int[] sorted = {1,2,3,4,5,6,7};
        final int steps = 10;
        runTest(sorted, sorted, steps);
        sorter.setPivotPosition(PivotPosition.LEFT);
        runTest(sorted, sorted, 31);
        sorter.setPivotPosition(PivotPosition.RIGHT);
        runTest(sorted, sorted, 52);        
        
        sorter.setPivotPosition(PivotPosition.RANDOM);
        assertArrayEquals(sorted, sorter.sort(sorted));
    }        
    

    @Test
    public void testsort_reversed() {
        System.out.println("testsort_reversed");
        int[] unsorted = {7,6,5,4,3,2,1};
        int[] sorted = {1,2,3,4,5,6,7};
        int steps = 10;
        runTest(sorted, unsorted, steps);
        sorter.setPivotPosition(PivotPosition.LEFT);
        runTest(sorted, unsorted, 31);
        sorter.setPivotPosition(PivotPosition.RIGHT);
        runTest(sorted, unsorted, 52);    
        sorter.setPivotPosition(PivotPosition.RANDOM);
        assertArrayEquals(sorted, sorter.sort(sorted));        
    }

    private void runTest(int[] sorted, int[] unsorted, int steps) {
        int[] done = sorter.sort(unsorted);
        assertEquals(sorted.length, done.length);
        assertArrayEquals(sorted, done);
        assertEquals(steps, sorter.getNumberSteps());
    }
    
}
