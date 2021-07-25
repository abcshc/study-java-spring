package study.java.spring.collection

class TargetItem(val id: Long, val name: String, val priority: Int): Comparable<TargetItem> {
    override fun compareTo(o: TargetItem): Int {
        val priorityCompareResult = priority.compareTo(o.priority)
        return if (priorityCompareResult != 0) priorityCompareResult else id.compareTo(o.id)
    }
}
