public class Test1 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 0, 4, 0, 5, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                j++;
            }
        }
        for (int k : array) {
            System.out.println(k);
        }
    }
}
