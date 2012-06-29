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
public class SorterTest2 {
    
    private Sorter sorter;
    
    
    public SorterTest2() {
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
    public void testsort1() {
        System.out.println("testsort1");
        int[] unsorted = {1};
        int[] sorted = {1};

        sorter.setPivotPosition(PivotPosition.LEFT);
        runTest(sorted, unsorted, 0);
        sorter.setPivotPosition(PivotPosition.RIGHT);
        runTest(sorted, unsorted, 0);
        sorter.setPivotPosition(PivotPosition.MEDIAN);
        runTest(sorted, unsorted, 0);
    }
    
    @Test
    public void testsort2() {
        System.out.println("testsort2");
        int[] unsorted = new int[]{1,2};
        int[] sorted = {1,2};

        sorter.setPivotPosition(PivotPosition.LEFT);
        runTest(sorted, unsorted, 1);
        unsorted = new int[]{1,2};
        sorter.setPivotPosition(PivotPosition.RIGHT);
        runTest(sorted, unsorted, 1);
        unsorted = new int[]{1,2};
        sorter.setPivotPosition(PivotPosition.MEDIAN);
        runTest(sorted, unsorted, 1);
    }    

        @Test
    public void testsort3() {
        System.out.println("testsort3");
        int[] unsorted = {1,2,3};
        int[] sorted = {1,2,3};

        sorter.setPivotPosition(PivotPosition.LEFT);
        runTest(sorted, unsorted, 3);
        unsorted = new int[]{1,2,3};
        sorter.setPivotPosition(PivotPosition.RIGHT);
        runTest(sorted, unsorted, 3);
        unsorted = new int[]{1,2,3};
        sorter.setPivotPosition(PivotPosition.MEDIAN);
        runTest(sorted, unsorted, 2);
    }
    
        @Test
    public void testsort4() {
        System.out.println("testsort4");
        int[] unsorted = {1,2,3,4};
        int[] sorted = {1,2,3,4};

        sorter.setPivotPosition(PivotPosition.LEFT);
        runTest(sorted, unsorted, 6);
        unsorted = new int[]{1,2,3,4};
        sorter.setPivotPosition(PivotPosition.RIGHT);
        runTest(sorted, unsorted, 6);
        unsorted = new int[]{1,2,3,4};
        sorter.setPivotPosition(PivotPosition.MEDIAN);
        runTest(sorted, unsorted, 4);
    }        

        
    @Test
    public void testsort5() {
        System.out.println("testsort5");
        int[] unsorted = {9,6,3,7,2,4};
        int[] sorted = {2,3,4,6,7,9};

        sorter.setPivotPosition(PivotPosition.LEFT);
        runTest(sorted, unsorted, 11);
        unsorted = new int[]{9,6,3,7,2,4};
        sorter.setPivotPosition(PivotPosition.RIGHT);
        runTest(sorted, unsorted, 9);
        unsorted = new int[]{9,6,3,7,2,4};
        sorter.setPivotPosition(PivotPosition.MEDIAN);
        runTest(sorted, unsorted, 8);
    }

    @Test
    public void testsort6() {
        System.out.println("testsort6");
        int[] unsorted = {9,6,3,7,4,2};
        int[] sorted = {2,3,4,6,7,9};

        sorter.setPivotPosition(PivotPosition.LEFT);
        runTest(sorted, unsorted, 13);
        unsorted = new int[]{9,6,3,7,4,2};
        sorter.setPivotPosition(PivotPosition.RIGHT);
        runTest(sorted, unsorted, 13);
        unsorted = new int[]{9,6,3,7,4,2};
        sorter.setPivotPosition(PivotPosition.MEDIAN);
        runTest(sorted, unsorted, 9);
    }    
    
    
    @Test
    public void testMedian() {
        /*
ARRAY: 0 9 8 7 6 5 4 3 2 1  # of comps =25
ARRAY: 0 1 2 3 4 5 6 7 8 9   # of comps =19
ARRAY: 1 11 5 15 2 12 9 99 77 0   # of comps =22
ARRAY: 999;3;2;98;765;8;14;15;16;88;145;100   # of comps =29
ARRAY: 1;11;5;15;2;999;3;2;98;765;8;14;15;16;88;145;100;12;9;99;77;0    # of comps = 82         
         */
        int[] unsorted = new int[]{0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sorter.setPivotPosition(PivotPosition.MEDIAN);
        sorter.sort(unsorted);
        assertEquals(25, sorter.getNumberSteps());
        
        unsorted = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        sorter.setPivotPosition(PivotPosition.MEDIAN);
        sorter.sort(unsorted);
        assertEquals(19, sorter.getNumberSteps());

        unsorted = new int[]{1, 11, 5, 15, 2, 12, 9, 99, 77, 0};
        sorter.setPivotPosition(PivotPosition.MEDIAN);
        sorter.sort(unsorted);
        assertEquals(22, sorter.getNumberSteps());
        
        unsorted = new int[]{999, 3, 2, 98, 765, 8, 14, 15, 16, 88, 145, 100};
        sorter.setPivotPosition(PivotPosition.MEDIAN);
        sorter.sort(unsorted);
        assertEquals(29, sorter.getNumberSteps());
 
        unsorted = new int[]{1, 11, 5, 15, 2, 999, 3, 2, 98, 765, 8, 14, 15, 16, 88, 145, 100, 12, 9, 99, 77, 0};
        sorter.setPivotPosition(PivotPosition.MEDIAN);
        sorter.sort(unsorted);
        assertEquals(82, sorter.getNumberSteps());
    }
    
    private void runTest(int[] sorted, int[] unsorted, int steps) {
        sorter.sort(unsorted);
        assertEquals(sorted.length, unsorted.length);
        assertArrayEquals(sorted, unsorted);
        assertEquals(steps, sorter.getNumberSteps());
    }

    @Test
    public void testPivot() {
        int[] sorted = {2,3,4,6,7,9};
        assertEquals(2, sorter.getPivot(sorted, PivotPosition.LEFT));
        assertEquals(9, sorter.getPivot(sorted, PivotPosition.RIGHT));
        assertEquals(4, sorter.getPivot(sorted, PivotPosition.MID));
        assertEquals(4, sorter.getPivot(sorted, PivotPosition.MEDIAN));
        
        assertEquals(4, sorter.getPivot(sorted, 0, sorted.length-1, PivotPosition.MEDIAN));
    }

    @Test
    public void testPivot2() {
        int[] sorted = {1,2,3};
        assertEquals(1, sorter.getPivot(sorted, PivotPosition.LEFT));
        assertEquals(3, sorter.getPivot(sorted, PivotPosition.RIGHT));
        assertEquals(2, sorter.getPivot(sorted, PivotPosition.MID));
        assertEquals(2, sorter.getPivot(sorted, PivotPosition.MEDIAN));
        
        assertEquals(2, sorter.getPivot(sorted, 0, sorted.length-1, PivotPosition.MEDIAN));
    }    

    @Test
    public void testPivot3() {
        int[] sorted = new int[]{1,2};
        assertEquals(1, sorter.getPivot(sorted, PivotPosition.LEFT));
        sorted = new int[]{1,2};
        assertEquals(2, sorter.getPivot(sorted, PivotPosition.RIGHT));
        sorted = new int[]{1,2};
        assertEquals(1, sorter.getPivot(sorted, PivotPosition.MID));
        sorted = new int[]{1,2};
        assertEquals(2, sorter.getPivot(sorted, PivotPosition.MEDIAN));
        sorted = new int[]{1,2};
        assertEquals(2, sorter.getPivot(sorted, 0, sorted.length-1, PivotPosition.MEDIAN));
    }    

    @Test
    public void testPivot4() {
        int[] sorted = {1,2,3,4,6,7,9};
        assertEquals(1, sorter.getPivot(sorted, PivotPosition.LEFT));
        assertEquals(9, sorter.getPivot(sorted, PivotPosition.RIGHT));
        assertEquals(4, sorter.getPivot(sorted, PivotPosition.MID));
        assertEquals(4, sorter.getPivot(sorted, PivotPosition.MEDIAN));
        
        assertEquals(4, sorter.getPivot(sorted, 0, sorted.length-1, PivotPosition.MEDIAN));
    }    
}
