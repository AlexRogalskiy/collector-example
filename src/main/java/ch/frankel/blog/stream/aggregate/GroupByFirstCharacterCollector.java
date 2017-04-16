package ch.frankel.blog.stream.aggregate;

import org.apache.commons.collections4.MultiValuedMap;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class GroupByFirstCharacterCollector implements Collector<String, MultiValuedMap<Character, String>, MultiValuedMap<Character, String>> {

    @Override
    public Supplier<MultiValuedMap<Character, String>> supplier() {
        return new MultiValuedMapSupplier();
    }

    @Override
    public BiConsumer<MultiValuedMap<Character, String>, String> accumulator() {
        return new MultiValuedMapAccumulator();
    }

    @Override
    public BinaryOperator<MultiValuedMap<Character, String>> combiner() {
        return new MultiValuedMapCombiner();
    }

    @Override
    public Function<MultiValuedMap<Character, String>, MultiValuedMap<Character, String>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.singleton(IDENTITY_FINISH);
    }
}
