package ch.frankel.blog.stream.value;

import org.apache.commons.lang3.mutable.MutableInt;

import java.util.function.BiConsumer;

class MutableIntObjectAccumulator<T> implements BiConsumer<MutableInt, T> {

    @Override
    public void accept(MutableInt mutableInt, T t) {
        mutableInt.increment();
    }
}
