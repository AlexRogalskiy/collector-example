package ch.frankel.blog.stream.value;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class SizeCollectorTest {

    private SizeCollector<String> collector;

    @BeforeTest
    protected void setUp() {
        collector = new SizeCollector<>();
    }

    @DataProvider
    public Object[][] data() {
        Object[][] data = new Object[4][1];
        List<List<String>> rawData = RawTestData.data();
        for (int i = 0; i < 4; i++) {
            data[i][0] = rawData.get(i);
        }
        return data;
    }

    @Test(dataProvider = "data")
    public void collection_should_be_of_expected_size(List<String> collection) {
        Integer result = collection.stream().collect(collector);
        assertNotNull(result);
        assertEquals(result.intValue(), collection.size());
    }
}
