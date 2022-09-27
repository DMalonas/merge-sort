package src;

import java.util.Comparator;

public class MergeSort {

    private final static int TWO = 2;


    public static <T> void mergeSort(T[] toSort, Comparator<T> comparator) {
        if (toSort == null || comparator == null) {
            throw new IllegalArgumentException("Wrong data provided");
        }
        if (toSort.length > 1) {
            //left side
            T[] l = (T[]) new Object[toSort.length / TWO];
            int lengthLeft = l.length;
            for (int i = 0; i < lengthLeft; i++) {
                l[i] = toSort[i];
            }

            //right side
            T[] r = (T[]) new Object[toSort.length - l.length];
            int lengthRight = r.length;
            for (int i = 0; i < lengthRight; i++) {
                r[i] = toSort[i + l.length];
            }

            mergeSort(l, comparator);
            mergeSort(r, comparator);
            merge(toSort, comparator, l, r);
        }
    }

    private static <T> void merge(T[] toSort, Comparator<T> comparator,
                                  T[] l, T[] r) {
        int i = 0, j = 0;
        int len = toSort.length;
        int rightLen = r.length;
        int leftLen = l.length;
        for (int k = 0; k < len; k++) {
            if (j >= rightLen || (i < leftLen && comparator.compare(l[i], r[j]) <= 0)) {
                toSort[k] = l[i];
                i++;
            } else {
                toSort[k] = r[j];
                j++;
            }
        }
    }

}
