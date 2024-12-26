package payload;

import modules.WebPage;

import java.util.Arrays;
import java.util.List;

public class TestData extends WebPage {
    public static List<pojo> getPayloads() {
        return Arrays.asList(
                new pojo("es", "en", list.get(0) ),
                new pojo("es", "en", list.get(2)),
                new pojo("es", "en", list.get(3)),
                new pojo("es", "en", list.get(4)),
                new pojo("es", "en", list.get(1))
        );
    }
}


