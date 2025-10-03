package exercise3;

// class Overload demonstrates method overloading, populates and returns an array sized and
// filled according to the number of integer parameters given
public class Overload{

    // fillArray(int x) returns a 1D array populated with index values i
    public static int[] fillArray(int x) {
        int[] array = new int[x];
        for(int i=0; i<x; i++){
            array[i] = i;
        }

        return array;
    }

    // fillArray(int x, int y) returns a 2D array populated with index values i*j
    public static int[][] fillArray(int x, int y){
        int[][] array = new int[x][y];
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                array[i][j] = i*j;
            }
        }
        return array;
    }
    // fillArray(int x, int y, int z) returns a 3D array populated with index values i*j*k
    public static int[][][] fillArray(int x, int y, int z){
        int[][][] array = new int[x][y][z];
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                for(int k=0; k<z;k++){
                    array[i][j][k] = i*j*k;
                }
            }
        }
        return array;
    }

}