package datastructure;

import java.util.Arrays;

public class IntSet {
    private static final int EMPTY = -1;
    private int size;
    private int[] indexToValue;
    private int[] valueToIndex;

    public IntSet(int capacity) {
        this.size = 0;
        indexToValue = new int[capacity];
        valueToIndex = new int[capacity];
        Arrays.fill(valueToIndex, EMPTY);
    }

    public boolean add(int value) {
        if (valueToIndex[value] != EMPTY) {
            return false;
        }
        indexToValue[size] = value;
        valueToIndex[value] = size;
//        set(size, value);
        size++;
        return true;
    }

    public boolean remove(int value) {
        int index = indexOf(value);
        if (index == EMPTY) {
            return false;
        }
        removeByIndex(index);
        return true;
    }

    private boolean removeByIndex(int index) {
        if (size == 0) {
            return false;
        }
        assert index < size;

//        swap(index, size - 1);
        size--;
        int value = indexToValue[index];
        int value2 = indexToValue[size];

//        set(index, value2);
        indexToValue[index] = value2;
        valueToIndex[value2] = index;

        indexToValue[size] = value;
        valueToIndex[value] = EMPTY;

        return true;
    }

//    private void set(int index, int value) {
//        indexToValue[index] = value;
//        valueToIndex[value] = index;
//    }

    public void swap(int index, int index2) {
        assert index < size;
        assert index2 < size;

        int swap = indexToValue[index];
        indexToValue[index] = indexToValue[index2];
        indexToValue[index2] = swap;

        valueToIndex[indexToValue[index]] = index;
        valueToIndex[indexToValue[index2]] = index2;

    }

    public void swapValue(int value, int value2) {
        assert value < size;
        assert value2 < size;

        int swap = valueToIndex[value];
        valueToIndex[value] = valueToIndex[value2];
        valueToIndex[value2] = swap;

        indexToValue[valueToIndex[value]] = value;
        indexToValue[valueToIndex[value2]] = value2;

    }

    public int get(int index) {
        assert index < size;
        return indexToValue[index];
    }

    public int indexOf(int value) {
//        assert value < size;
        return valueToIndex[value];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() <= 0;
    }

    public void clear() {
        for (; size() > 0;) {
            removeByIndex(0);
        }
    }

    public boolean contains(int value) {
        return indexOf(value) != EMPTY;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(indexToValue, size()));
    }
}
