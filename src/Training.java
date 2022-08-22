import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import java.util.function.Consumer;

public class Training {

    public static void main (String[] args){
        //Creating a linked list, adding elements and printing the list
        /*
        System.out.println("This is a training module to prepare for interviews");0
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(5);
        list.add(1);
        list.add(10);
        System.out.println("Linked list probelm");
        Collections.sort(list);

        System.out.println(list);

         */
        MyMatrix myMatrix = new MyMatrix();

        //matrix multiplication n*n * n*1 = n*1.
        //parallel executiong
        // lets get the value of n
        System.out.println("Input the size of matrix");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        myMatrix.N = n;
        ExecutorService executor = Executors.newFixedThreadPool(n);
        System.out.println("Input given for size of matrix : " + n);

        System.out.println("Input matrix A, row wise");
        //lets get the matrix A and B, get the inputs columnwise
        //int[][] A = new int[n][n];
        myMatrix.A = new int[n][n];
        for(int i =0; i < n; i++) {
            String Arow = s.next();
            System.out.println("Input given " + Arow);
            String[] ArowArr = Arow.split(",");
            for(int index=0; index<ArowArr.length; index++){
                myMatrix.A[i][index] = Integer.valueOf(ArowArr[index]);
            }
        }

        System.out.println("Input matrix B (1*n)");
        //int[] B = new int[n];
        myMatrix.B = new int[n];
        String Bcol = s.next();
        String[] BcolArr = Bcol.split(",");
        for(int index=0; index < BcolArr.length; index++){
            myMatrix.B[index] = Integer.valueOf(BcolArr[index]);
        }
        System.out.println("given B : " + Bcol);
        myMatrix.printMatrix(myMatrix.B);

        //int[] C = new int[n];
        myMatrix.C = new int[n];
        //fixed thread pool of n threads created. lets code the runnable interface

        //MatrixMultiplyWorker worker = new MatrixMultiplyWorker(0,0,this);

        executor.execute(new MatrixMultiplyWorker(0,myMatrix));
        executor.execute(new MatrixMultiplyWorker(1,myMatrix));
        executor.execute(new MatrixMultiplyWorker(2,myMatrix));
        System.out.println("-------Printing A----");
        myMatrix.printMatrix(myMatrix.A);
        System.out.println("-------Printing B----");
        myMatrix.printMatrix(myMatrix.B);
        System.out.println("-------Printing V----");
        myMatrix.printMatrix(myMatrix.C);
    }
}
