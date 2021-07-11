package study.java.spring.collection;

public class TargetItem implements Comparable<TargetItem> {
    private final long id;
    private final String name;
    private final int priority;

    public TargetItem(long id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(TargetItem o) {
        int priorityCompareResult = Integer.compare(priority, o.priority);
        return priorityCompareResult != 0 ? priorityCompareResult : Long.compare(id, o.id);
    }
}
