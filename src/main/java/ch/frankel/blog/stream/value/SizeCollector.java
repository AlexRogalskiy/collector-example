package ch.frankel.blog.stream.value;

import org.apache.commons.lang3.mutable.MutableInt;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class SizeCollector<T> implements Collector<T, MutableInt, Integer> {

    @Override
    public Supplier<MutableInt> supplier() {
        return new MutableIntSupplier();
    }

    @Override
    public BiConsumer<MutableInt, T> accumulator() {
        return new MutableIntObjectAccumulator<>();
    }

    @Override
    public BinaryOperator<MutableInt> combiner() {
        return new MutableIntCombiner();
    }

    @Override
    public Function<MutableInt, Integer> finisher() {
        return new MutableIntIntFinisher();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>();
    }
}
