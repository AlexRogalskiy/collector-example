package ch.frankel.blog.stream.partition;

import java.util.function.Supplier;

class DoubleListSupplier<T> implements Supplier<DoubleList<T>> {

    @Override
    public DoubleList<T> get() {
        return new DoubleList<T>();
    }
}
