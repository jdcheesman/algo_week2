/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 * Quicksort implementation.
 * 
 * @author j.cheesman
 */
public class Sorter {
    private long numberSteps = 0;
    private PivotPosition pivotPosition  = PivotPosition.MID;
    
    public Sorter() {}


    
    public int[] sort(int[] toSort) {
        if (toSort == null || toSort.length <= 1) {
            return toSort;
        }

        numberSteps+=toSort.length-1;
        
        int pivot = getPivot(toSort, pivotPosition);
        
        if (pivotPosition == PivotPosition.MEDIAN) System.out.println("Pivot: " + pivot);
        
        int[] left = new int[toSort.length];
        int lIndex = 0;
        int[] right = new int[toSort.length];
        int rIndex = 0;
        for (int i=0; i<toSort.length; i++) {
            if (toSort[i] < pivot) {
                left[lIndex++] = toSort[i];
            }
            else if (toSort[i] > pivot) {
                right[rIndex++] = toSort[i];
            }            
        }
        
        int[] result = new int[toSort.length];
        if (lIndex > 0) {
            int[] newLeft = new int[lIndex];
            System.arraycopy(left, 0, newLeft, 0, lIndex);
            System.arraycopy(sort(newLeft), 0, result, 0, lIndex);
        }

        result[lIndex] = pivot;
        
        if (rIndex > 0) {
            int[] newRight = new int[rIndex];
            System.arraycopy(right, 0, newRight, 0, rIndex);
            System.arraycopy(sort(newRight), 0, result, lIndex+1, rIndex);
        }
        return result;
    }
    
    public int getPivot(int[] toSort, final PivotPosition pp) {
        if (pp == PivotPosition.LEFT) {
            return toSort[0];
        }
        else if (pp == PivotPosition.RIGHT) {
            int pivot = toSort[toSort.length-1];
            swap(toSort, 0, toSort.length-1);
            return pivot;
        }
        else if (pp == PivotPosition.RANDOM) {
            int pivotPosn = (int)(Math.random()*(toSort.length-1));
            return toSort[pivotPosn];
        }

        int midPosn = toSort.length / 2;
        if (toSort.length%2 == 0 && midPosn > 0) {
            midPosn--;
        }
        
        if (pp == PivotPosition.MEDIAN) {
            System.out.println(midPosn);
            int val0 = toSort[0];
            int val1 = toSort[midPosn];
            int val2 = toSort[toSort.length-1];
            int max = Math.max(val0,Math.max(val1, val2));
            int min = Math.min(val0,Math.min(val1, val2));
            int pivot = val2;
            if (val0 < max && val0 > min) pivot = val0;
            if (val1 < max && val1 > min) pivot = val1;
            if (pivot == val1) swap(toSort, midPosn, 0);
            if (pivot == val2)swap(toSort, 0, toSort.length-1);
            return pivot;
        }
        return toSort[midPosn];
    }    
    
    public long getNumberSteps() {
        return numberSteps;
    }
    
    public void setNumberSteps(long steps) {
        numberSteps = steps;
    }    
    
    /**
     * @return the pivotPosition
     */
    public PivotPosition getPivotPosition() {
        return pivotPosition;
    }

    /**
     * @param pivotPosition the pivotPosition to set
     */
    public void setPivotPosition(PivotPosition pivotPosition) {
        this.pivotPosition = pivotPosition;
        numberSteps=0;
    }    
  

    // pre: array is full and index1, index2 < array.length
    // post: the values at indices 1 and 2 have been swapped
    public void swap(int array[], int index1, int index2) {
        int temp = array[index1];           // store the first value in a temp
        array[index1] = array[index2];      // copy the value of the second into the first
        array[index2] = temp;               // copy the value of the temp into the second
    }
    

}
