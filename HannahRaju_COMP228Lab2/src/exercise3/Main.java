package exercise3;

// class Main is used to call class Overload() to demonstrate method overloading
public class Main {

    public static void main(String[] args){

        int x = 3;
        int y = 2;
        int z = 3;

        // call Overload.fillArray with one parameter
        int[] array1d = Overload.fillArray(x);

        //print 1d array to terminal
        for(int i=0; i<x; i++){
            System.out.println(array1d[i]);
        }
        System.out.println("");

        //call Overload.fillArray with two parameters
        int[][] array2d = Overload.fillArray(x,y);

        // print 2d array to terminal
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                System.out.println(array2d[i][j]);
            }
        }
        System.out.println("");

        // call Overload.fillArray with three parameters
        int[][][] array3d = Overload.fillArray(x,y,z);

        // print 3d array to terminal
        for(int i=0; i<x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    System.out.println(array3d[i][j][k]);
                }
            }
        }

    }
}
