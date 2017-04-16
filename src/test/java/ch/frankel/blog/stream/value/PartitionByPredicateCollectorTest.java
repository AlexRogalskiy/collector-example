package ch.frankel.blog.stream.value;

import ch.frankel.blog.stream.partition.DoubleList;
import ch.frankel.blog.stream.partition.PartitionByPredicateCollector;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PartitionByPredicateCollectorTest {

    private PartitionByPredicateCollector<String> collector;

    @BeforeTest
    protected void setUp() {
        collector = new PartitionByPredicateCollector<>(string -> string.length() == 4);
    }

    @DataProvider
    public Object[][] data() {
        Object[][] data = new Object[4][3];
        List<List<String>> rawData = RawTestData.data();
        for (int i = 0; i < 4; i++) {
            data[i][0] = rawData.get(i);
        }
        data[0][1] = 0;
        data[0][2] = 0;
        data[1][1] = 0;
        data[1][2] = 1;
        data[2][1] = 0;
        data[2][2] = 2;
        data[3][1] = 4;
        data[3][2] = 10;
        return data;
    }

    @Test(dataProvider = "data")
    public void double_list_should_be_partitioned_according_to_result(List<String> collection, int size1, int size2) {
        DoubleList<String> doubleList = collection.stream().collect(collector);
        assertNotNull(doubleList);
        List<String> list1 = doubleList.first();
        assertEquals(list1.size(), size1);
        List<String> list2 = doubleList.second();
        assertEquals(list2.size(), size2);
    }
}
