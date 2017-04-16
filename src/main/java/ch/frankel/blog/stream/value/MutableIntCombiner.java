package ch.frankel.blog.stream.value;

import org.apache.commons.lang3.mutable.MutableInt;

import java.util.function.BinaryOperator;

class MutableIntCombiner implements BinaryOperator<MutableInt> {

    @Override
    public MutableInt apply(MutableInt mutableInt1, MutableInt mutableInt2) {
        return new MutableInt(mutableInt1.intValue() + mutableInt2.intValue());
    }
}
