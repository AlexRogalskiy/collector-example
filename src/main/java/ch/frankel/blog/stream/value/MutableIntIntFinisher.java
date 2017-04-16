package ch.frankel.blog.stream.value;

import org.apache.commons.lang3.mutable.MutableInt;

import java.util.function.Function;

class MutableIntIntFinisher implements Function<MutableInt, Integer> {

    @Override
    public Integer apply(MutableInt mutableInt) {
        return mutableInt.getValue();
    }
}
