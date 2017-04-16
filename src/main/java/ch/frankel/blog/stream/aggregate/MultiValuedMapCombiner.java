package ch.frankel.blog.stream.aggregate;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.function.BinaryOperator;

class MultiValuedMapCombiner implements BinaryOperator<MultiValuedMap<Character, String>> {

    @Override
    public MultiValuedMap<Character, String> apply(MultiValuedMap<Character, String> map1, MultiValuedMap<Character, String> map2) {
        ArrayListValuedHashMap<Character, String> map = new ArrayListValuedHashMap<>();
        map.putAll(map1);
        map.putAll(map2);
        return map;
    }
}
