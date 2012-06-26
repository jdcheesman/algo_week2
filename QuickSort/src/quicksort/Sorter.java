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
        int pivot = getPivot(toSort);
        
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
    
    private int getPivot(int[] toSort) {
        if (pivotPosition == PivotPosition.LEFT) {
            return toSort[0];
        }
        else if (pivotPosition == PivotPosition.RIGHT) {
            return toSort[toSort.length-1];
        }
        else if (pivotPosition == PivotPosition.RANDOM) {
            int pivotPosn = (int)(Math.random()*(toSort.length-1));
            return toSort[pivotPosn];
        }
        else {
            return toSort[toSort.length / 2];
        }
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
    }    
}
