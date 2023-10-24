import java.io.*;
import java.util.Scanner;

public class MatrixShift {
    public MatrixShift() {
        readMatrix();
    }
    void readMatrix(){
        try {
            File file = new File("src//matrix1.txt");
            Scanner input = new Scanner(file);
            int k = input.nextInt(); // Хэдэн матриц байгаа тоо
            int n = input.nextInt(); // Матрицын мөр ба баганын тоо гол диагональтай байна гэдэг нь m = n гэсэн үг
            int [][] matrix = new int [n][n];
            System.out.println("Гол диагоналын элементүүдийн нийлбэр нь 5-тай тэнцүү байдаг матрицууд: ");
            for( int i = 0; i < k ; i++){
                for (int j = 0; j < n; j++){
                    for(int l = 0; l < n; l++){
                        matrix[j][l] = input.nextInt();
                    }
                }
                if(calculateMatrix(matrix) == 5){
                    printMatrix(matrix);
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Алдаа гарлаа");
            e.printStackTrace();
        }
    }
    private static int  calculateMatrix(int [][] matrix){
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    void printMatrix(int [][] matrix) throws FileNotFoundException{
        int n = matrix.length;
        // FileWriter true flag means append mode.
        try (PrintWriter output = new PrintWriter(new FileWriter("src//matrix2.txt", true))) {
            for (int[] ints : matrix) {
                for (int i = 0; i < n; i++) {
                    System.out.print(ints[i] + " ");
                    output.print(ints[i] + " ");
                }
                output.println("");
                System.out.println();
            }
            output.println("");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String [] arg){
        new MatrixShift();
    }
}
