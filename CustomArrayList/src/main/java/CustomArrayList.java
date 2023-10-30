
import java.lang.*;
import java.util.*;

public class CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    Object[] elementData;
    private int modCount;


    public CustomArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else {
            if (initialCapacity != 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
            }
            this.elementData = new Object[0];
        }
        modCount = 0;
    }

    public CustomArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        modCount = 0;
    }

    public int size() {
        return this.modCount;
    }

    public boolean isEmpty() {
        return this.modCount == 0;
    }


    public E get(int index) {
        return (E) this.elementData[index];
    }

    public void add(E element) {
        if (modCount == elementData.length - 1)
            increaseSizeOfArrayList();
        elementData[modCount++] = element;
    }

    public void add(int index, E element) {
        if (index < 0 || index > modCount) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        } else if (modCount == elementData.length - 1) {
            increaseSizeOfArrayList();
        }
        System.arraycopy(elementData, index, elementData, index + 1, modCount - index);
        elementData[index] = element;
        modCount++;
    }

    private void increaseSizeOfArrayList() {
        int newLength = (int) (elementData.length * 1.5 + 1);
        Object[] newArray = new Object[newLength];
        System.arraycopy(elementData, 0, newArray, 0, modCount);
        elementData = newArray;
    }

    public void addAll( Collection<? extends E> c) {
        if (c == null || c.isEmpty()) {
            throw new IllegalArgumentException("Illegal Collection: " + c);
        }
             for (E e:c){
                 add(e);
            }

        }

    public void remove(int index) {
        if (index < 0 || index >= modCount) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        System.arraycopy(elementData, index + 1,elementData, index, modCount - index - 1);
        elementData[--modCount] = null;
    }

    public void remove(Object o) {
        for (int i = 0; i < modCount; i++) {
            if (o.equals(elementData[i])) {
                remove(i);
            }
        }
    }

    public void clear() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        modCount = 0;
    }

    public void sort(Comparator<? super E> c) {
            Object[] values = new Object[modCount];
            mergeSort(c, values, 0, modCount - 1);
        }

    private void mergeSort(Comparator<? super E> c, Object[] values, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(c, values, left, middle);
            mergeSort(c, values, middle + 1, right);
            merge(c, values, left, middle, right);
        }
    }

    private void merge(Comparator<? super E> c, Object[] values,
                       int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (c.compare((E) elementData[i], (E) elementData[j]) <= 0) {
                values[k++] = elementData[i++];
            } else {
                values[k++] = elementData[j++];
            }
        }

        while (i <= middle) {
            values[k++] = elementData[i++];
        }

        while (j <= right) {
            values[k++] = elementData[j++];
        }

        for (k = left; k <= right; k++) {
            elementData[k] = values[k];
        }
    }

    @Override
    public String toString(){
        Object [] values = new Object[modCount];
        System.arraycopy(elementData, 0, values, 0, modCount);
        return Arrays.toString(values);
    }
}
