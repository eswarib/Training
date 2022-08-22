
//This class executes matrix multiplication for row
public class MatrixMultiplyWorker implements Runnable {
    private int row;
    private MyMatrix matrixObj;

    public MatrixMultiplyWorker(int row,MyMatrix matrixObj){
        this.row = row;
        this.matrixObj = matrixObj;
    }

    @Override
    public void run() {

        System.out.println("Starting convolution function");
        for(int col = 0; col < matrixObj.N; col++) {
            matrixObj.C[row] = matrixObj.C[row] + (matrixObj.A[row][col] * matrixObj.B[col]);
        }

    }
}
