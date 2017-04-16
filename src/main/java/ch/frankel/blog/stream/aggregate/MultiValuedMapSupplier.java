package ch.frankel.blog.stream.aggregate;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.function.Supplier;

class MultiValuedMapSupplier implements Supplier<MultiValuedMap<Character, String>> {

    @Override
    public MultiValuedMap<Character, String> get() {
        return new ArrayListValuedHashMap<>();
    }
}
