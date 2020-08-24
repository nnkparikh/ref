import java.util.Arrays;

class BasicArray {
    public static void main(String[] args){
        int[] intArray = new int[10]; // allocated on heap,initialized to zero
        System.out.println(Arrays.toString(intArray));
    }
}