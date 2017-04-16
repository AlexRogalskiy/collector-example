package ch.frankel.blog.stream.partition;

import java.util.function.BinaryOperator;

class DoubleListCombiner<T> implements BinaryOperator<DoubleList<T>> {

    @Override
    public DoubleList<T> apply(DoubleList<T> list1, DoubleList<T> list2) {
        return list1.merge(list2);
    }
}
