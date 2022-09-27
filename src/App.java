import java.util.Arrays;
import java.util.Comparator;

public class App {


    public static void main(String[] args) throws Exception {
        MergeSort mergeSort = new MergeSort();
        String[] data = {"This", "is", "an", "Example", "of", "sorting", "Strings"};
        mergeSort.mergeSort(data, Comparator.naturalOrder());
        System.out.println(Arrays.toString(data));
    }

}
