package ch.frankel.blog.stream.value;

import ch.frankel.blog.stream.aggregate.GroupByFirstCharacterCollector;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GroupByFirstCharacterCollectorTest {

    private GroupByFirstCharacterCollector collector;

    @BeforeTest
    protected void setUp() {
        collector = new GroupByFirstCharacterCollector();
    }

    @SuppressWarnings("unchecked")
    @DataProvider
    public Object[][] data() {
        Object[][] data = new Object[4][2];
        List<List<String>> rawData = RawTestData.data();
        for (int i = 0; i < 4; i++) {
            List<String> list = rawData.get(i);
            data[i][0] = list;
            ArrayListValuedHashMap<Character, String> map = new ArrayListValuedHashMap<>();
            list.forEach(string -> map.put(string.charAt(0), string));
            data[i][1] = map;
        }
        return data;
    }

    @Test(dataProvider = "data")
    public void collection_should_be_collected_into_expected_map(List<String> collection, MultiValuedMap<Character, String> expected) {
        MultiValuedMap<Character, String> result = collection.stream().collect(collector);
        assertNotNull(result);
        assertEquals(result.isEmpty(), collection.isEmpty());
        assertEquals(result.size(), collection.size());
        assertEquals(result.keySet(), expected.keySet());
        result.keySet().forEach(key -> {
            assertEquals(result.get(key), expected.get(key));
        });
    }
}
