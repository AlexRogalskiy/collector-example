package ch.frankel.blog.stream.partition;

import java.util.ArrayList;
import java.util.List;

public class DoubleList<T> {

    private final List<T> list1;
    private final List<T> list2;

    DoubleList() {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
    }

    void addToFirst(T t) {
        list1.add(t);
    }

    void addToSecond(T t) {
        list2.add(t);
    }

    DoubleList<T> merge(DoubleList<T> anotherList) {
        DoubleList<T> mergedList = new DoubleList<>();
        mergedList.list1.addAll(list1);
        mergedList.list2.addAll(list2);
        mergedList.list1.addAll(anotherList.list1);
        mergedList.list2.addAll(anotherList.list2);
        return mergedList;
    }

    public List<T> first() {
        return new ArrayList<>(list1);
    }

    public List<T> second() {
        return new ArrayList<>(list2);
    }
}
