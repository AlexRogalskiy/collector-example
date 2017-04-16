package ch.frankel.blog.stream.partition;

import java.util.function.BiConsumer;
import java.util.function.Predicate;

class DoubleListAccumulator<T> implements BiConsumer<DoubleList<T>, T> {

    private final Predicate<T> predicate;

    DoubleListAccumulator(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public void accept(DoubleList<T> doubleList, T t) {
        if (predicate.test(t)) {
            doubleList.addToFirst(t);
        } else {
            doubleList.addToSecond(t);
        }
    }
}
