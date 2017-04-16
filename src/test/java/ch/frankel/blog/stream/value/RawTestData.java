package ch.frankel.blog.stream.value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class RawTestData {

    static List<List<String>> data() {
        List<List<String>> data = new ArrayList<>();
        data.add(Collections.emptyList());
        data.add(Collections.singletonList("foo"));
        data.add(Arrays.asList("foo", "bar"));
        data.add(Arrays.asList("foo", "bar", "baz", "qux", "quux", "quuz", "corge", "grault", "garply", "waldo", "fred", "plugh", "xyzzy", "thud"));
        return data;
    }
}
