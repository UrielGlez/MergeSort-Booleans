package mergesort;

public class Mergesort {

    public static void main(String args[]) {
        
            int array[] = new int[30];
            Mergesort ms = new Mergesort();
            ms.fillArray(array);
            System.out.println("\nArray desordenado: ");
            ms.printArray(array);
            long startTime = System.currentTimeMillis();
            ms.divideArray(array, 0, array.length - 1);
            long finalTime = System.currentTimeMillis();
            System.out.println("\nTiempo algoritmo: " + (finalTime - startTime) + "ms");
            System.out.println("Array ordenado: ");
            ms.printArray(array);
        

    }

    /*
    Merges the two subarrays that are given by divideArrays
     */
    void mergeArrays(int array[], int indexLeft, int indexRight, int middle) {
        //Find size of subarrays 
        int sizeArrayA = middle - indexLeft + 1;
        int sizeArrayB = indexRight - middle;

        //Create new temporary arrays to contain data 
        int tempArrayA[] = new int[sizeArrayA];
        int tempArrayB[] = new int[sizeArrayB];

        //Arrays to keep track of data
        boolean boolArrayA[] = new boolean[sizeArrayA + 1];
        boolean boolArrayB[] = new boolean[sizeArrayB + 1];
        //We make double sure theyre in false

        for (int b = 0; b < sizeArrayA + 1; b++) {
            boolArrayA[b] = false;
        }
        for (int b = 0; b < sizeArrayB + 1; b++) {
            boolArrayB[b] = false;
        }

        boolArrayA[sizeArrayA] = true;
        boolArrayB[sizeArrayB] = true;

        //Copy data into the temporary arrays
        for (int i = 0; i < sizeArrayA; i++) {
            tempArrayA[i] = array[indexLeft + i];
        }
        for (int j = 0; j < sizeArrayB; j++) {
            tempArrayB[j] = array[middle + 1 + j];
        }

        //Indexes to compare the arrays 
        int indexA = 0, indexB = 0;
        int indexActual = indexLeft;

        while (boolArrayA[indexA] == false && boolArrayB[indexB] == false) {
            if (tempArrayA[indexA] <= tempArrayB[indexB]) {
                array[indexActual] = tempArrayA[indexA];
                indexA++;
            } else {
                array[indexActual] = tempArrayB[indexB];
                indexB++;
            }
            indexActual++;
        }

        while (boolArrayA[indexA] == false) {
            array[indexActual] = tempArrayA[indexA];
            indexA++;
            indexActual++;
        }

        while (boolArrayB[indexB] == false) {
            array[indexActual] = tempArrayB[indexB];
            indexB++;
            indexActual++;
        }

    }

    /*
    We divide arrays in their smallest unit (1) 
     */
    void divideArray(int array[], int indexLeft, int indexRight) {
        if (indexLeft < indexRight) {
            //Find the middle point 
            int middle = (indexLeft + indexRight) / 2;

            //Divide the two halves 
            divideArray(array, indexLeft, middle);
            divideArray(array, middle + 1, indexRight);

            //Merge arrays
            mergeArrays(array, indexLeft, indexRight, middle);
        }
    }

    void printArray(int array[]) {
        int arrayLength = array.length;
        for (int j = 0; j < arrayLength; j++) {
            System.out.println(array[j]);
        }
    }

    void fillArray(int array[]) {
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            array[i] = (int) (Math.random() * 10000);
        }
    }
}
