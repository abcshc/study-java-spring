package study.java.spring.collection;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TargetItemsTest {
    private final TargetItems targetItems = new TargetItems(List.of(
            new TargetItem(21, "서길동", 1),
            new TargetItem(12, "이길동", 2),
            new TargetItem(8, "박길동", 4),
            new TargetItem(1, "홍길동", 1),
            new TargetItem(2, "김길동", 2),
            new TargetItem(3, "황길동", 3),
            new TargetItem(11, "소길동", 2)
    ));

    @Test
    public void sortedByCompareTo_성공() {
        List<TargetItem> result = targetItems.sortedUsingCompareTo();

        assertEquals("1,21,2,11,12,3,8", joiningById(result));
    }

    private String joiningById(List<TargetItem> list) {
        return list.stream()
                .mapToLong(TargetItem::getId)
                .mapToObj(Long::toString)
                .collect(Collectors.joining(","));
    }

    @Test
    public void sortedUsingComparingInt_성공() {
        List<TargetItem> result = targetItems.sortedUsingComparingInt();

        assertEquals("21,1,12,2,11,3,8", joiningById(result));
    }

    @Test
    public void sortedUsingMultipleComparator_성공() {
        List<TargetItem> result = targetItems.sortedUsingMultipleComparator();

        assertEquals("1,21,2,11,12,3,8", joiningById(result));
    }

    @Test
    public void sortedUsingLambda_성공() {
        List<TargetItem> result = targetItems.sortedUsingLambda();

        assertEquals("8,3,12,2,11,21,1", joiningById(result));
    }
}
