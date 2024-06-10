public class Test{
    public static void main(String[] args){
        int[] arr = new int[]{0, 34, 67, 2, 5, 98, 3, 4, -1};
        arr = sort(arr);
        for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
    }
    public static int[] sort(int[] arr){
        int block = arr.length/2;
        int temp = 0;
        for(int i = 0; i < block; i++){
            for(int j = i + 1; j < block; j++){
                if(arr[j] < arr[i]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i = arr.length - 1; i > block; i--){
            for(int j = i - 1; j > block; j--){
                if(arr[j] < arr[i]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        
        }
        int[] array = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        int sorted = 0;
        while(left != right){
            if(arr[left] < arr[right]){
                array[sorted] = arr[left];
                left++;
            }
            else{
                array[sorted] = arr[right];
                right--;
            }
            sorted++;
        }
        array[sorted] = arr[right];
        return array;
    }
}