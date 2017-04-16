package ch.frankel.blog.stream.aggregate;

import org.apache.commons.collections4.MultiValuedMap;

import java.util.function.BiConsumer;

class MultiValuedMapAccumulator implements BiConsumer<MultiValuedMap<Character, String>, String> {

    @Override
    public void accept(MultiValuedMap<Character, String> map, String s) {
        map.put(s.charAt(0), s);
    }
}
