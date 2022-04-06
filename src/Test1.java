import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 0, 4, 0, 5};
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                j++;
            }
        }
        System.out.println(array);
    }
}
