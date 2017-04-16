package ch.frankel.blog.stream.partition;

import java.util.Collections;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class PartitionByPredicateCollector<T> implements Collector<T, DoubleList<T>, DoubleList<T>> {

    private final Predicate<T> predicate;

    public PartitionByPredicateCollector(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public Supplier<DoubleList<T>> supplier() {
        return new DoubleListSupplier<T>();
    }

    @Override
    public BiConsumer<DoubleList<T>, T> accumulator() {
        return new DoubleListAccumulator<>(predicate);
    }

    @Override
    public BinaryOperator<DoubleList<T>> combiner() {
        return new DoubleListCombiner<>();
    }

    @Override
    public Function<DoubleList<T>, DoubleList<T>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.singleton(IDENTITY_FINISH);
    }
}
