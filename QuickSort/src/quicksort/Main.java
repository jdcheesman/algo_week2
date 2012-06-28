/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author j.cheesman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("Missing filename");
        }
        File f = new File(args[0]);
        if (!f.exists()) {
            throw new IllegalArgumentException("File " + args[0] + " doesn't exist");
        }
        if (f.isDirectory()) {
            throw new IllegalArgumentException("File " + args[0] + " is a directory");
        }
        long start = System.currentTimeMillis();
        
        Scanner scanner = new Scanner(f);
        List<Integer> data = new ArrayList<>();
        while (scanner.hasNextLine()) {
            if (scanner.hasNextInt()) {
                int tmp = scanner.nextInt();
                if (tmp == 91901) {
                        System.out.println("EOF!");        
                }
                data.add(tmp);
            }
            else {
                scanner.nextLine();
            }
            
        }
        int[] dataToCheck = new int[data.size()];
        for (int i=0; i<dataToCheck.length; i++) {
            dataToCheck[i] = data.get(i).intValue();
        }
        System.out.println("Date read \tTime: " + (System.currentTimeMillis()-start) + " ms");
        
        Sorter sorter = new Sorter();
        // run it once to warm the JIT up.
        sorter.sort(dataToCheck);

        long result;

//        sorter.setPivotPosition(PivotPosition.MID);
//        sorter.setNumberSteps(0);
//        start = System.currentTimeMillis();
//        sorter.sort(dataToCheck);
//        result = sorter.getNumberSteps();
//        System.out.println("MID\n\tTime: " + (System.currentTimeMillis()-start) + " ms");
//        System.out.println("\tFinal count: " + result);        
        
        sorter.setPivotPosition(PivotPosition.LEFT);
        sorter.setNumberSteps(0);
        start = System.currentTimeMillis();
        sorter.sort(dataToCheck);
        result = sorter.getNumberSteps();
        System.out.println("LEFT\n\tTime: " + (System.currentTimeMillis()-start) + " ms");
        System.out.println("\tFinal count: " + result);        
        
        
        sorter.setPivotPosition(PivotPosition.RIGHT);
        sorter.setNumberSteps(0);
        start = System.currentTimeMillis();
        sorter.sort(dataToCheck);
        result = sorter.getNumberSteps();
        System.out.println("RIGHT\n\tTime: " + (System.currentTimeMillis()-start) + " ms");
        System.out.println("\tFinal count: " + result);   
        
//        sorter.setPivotPosition(PivotPosition.RANDOM);
//        sorter.setNumberSteps(0);
//        start = System.currentTimeMillis();
//        sorter.sort(dataToCheck);
//        result = sorter.getNumberSteps();
//        System.out.println("RANDOM\n\tTime: " + (System.currentTimeMillis()-start) + " ms");
//        System.out.println("\tFinal count: " + result);        
        
        sorter.setPivotPosition(PivotPosition.MEDIAN);
        sorter.setNumberSteps(0);
        start = System.currentTimeMillis();
        sorter.sort(dataToCheck);
        result = sorter.getNumberSteps();
        System.out.println("MEDIAN\n\tTime: " + (System.currentTimeMillis()-start) + " ms");
        System.out.println("\tFinal count: " + result);          
    }
    
}
