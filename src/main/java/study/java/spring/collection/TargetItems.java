package study.java.spring.collection;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TargetItems {
    private final List<TargetItem> list;

    public TargetItems(List<TargetItem> list) {
        this.list = list;
    }

    public List<TargetItem> getList() {
        return list;
    }

    public List<TargetItem> sortedUsingCompareTo() {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<TargetItem> sortedUsingComparingInt() {
        return list.stream()
                .sorted(Comparator.comparingInt(TargetItem::getPriority))
                .collect(Collectors.toList());
    }

    public List<TargetItem> sortedUsingMultipleComparator() {
        return list.stream()
                .sorted(Comparator.comparingInt(TargetItem::getPriority).thenComparing(TargetItem::getId))
                .collect(Collectors.toList());
    }

    public List<TargetItem> sortedUsingLambda() {
        return list.stream()
                .sorted((TargetItem item1, TargetItem item2) ->
                        item2.getPriority() - item1.getPriority()
                ).collect(Collectors.toList());
    }
}
