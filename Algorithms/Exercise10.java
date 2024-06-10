public class Exercise10 {
    public static void main(String[] args){
        int[] array = new int[]{0, 5, 3, 9, 12, 65, 34, 92, 4};
        bublesort(array);
        for(int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
        bbublesort(array);
        System.out.println();
        for(int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
        selectionsort(array);
        System.out.println();
        for(int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
        insertionsort(array);
        System.out.println();
        for(int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
    }
    public static void bublesort(int[] array){
        int temp = 0;
        for(int i = 0; i < array.length - 1; i++){
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[i]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    public static void bbublesort(int[] array) {
        boolean swapped;

        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    public static void selectionsort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int index = i;
            for(int  j = i + 1; j < array.length; j++){
                if(array[j] < array[index]) index = j;
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }
    public static void insertionsort(int[] array){
        for(int i = 1; i < array.length; i++){
            int key = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > key){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
