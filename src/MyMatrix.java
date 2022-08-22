public class MyMatrix {
    public int N;
    public int[][] A;
    public int[] B,C;

    public void printMatrix(int[][] x){
        int rowLen = x.length;
        int colLen = x[0].length;
        for(int i=0; i<rowLen; i++){
            for(int j=0; j<colLen; j++){
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void printMatrix(int[] x){
        int rowLen = x.length;
            for(int i=0; i<rowLen; i++){
                System.out.print(x[i] + " ");
            }
            System.out.println();

    }
}
