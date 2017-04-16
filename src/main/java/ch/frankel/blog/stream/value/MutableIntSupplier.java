package ch.frankel.blog.stream.value;

import org.apache.commons.lang3.mutable.MutableInt;

import java.util.function.Supplier;

class MutableIntSupplier implements Supplier<MutableInt> {

    public MutableInt get() {
        return new MutableInt();
    }
}
