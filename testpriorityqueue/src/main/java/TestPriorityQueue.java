import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestPriorityQueue {
    public static void main(String[] args) {
//        Queue<Integer> pq = new PriorityQueue<Integer>();
        Queue<Integer> pq = new PriorityQueue<Integer>(11, Collections.<Integer>reverseOrder());
        pq.offer(10);
        pq.add(22);
        pq.addAll(Arrays.asList(new Integer[]{11, 12, 34, 2, 7, 4, 15, 12, 8, 6, 19, 13}));
        while (pq.peek() != null) {
            System.out.print(pq.poll() + " ");
        }

        PriorityQueue<Task> tasks = new PriorityQueue<Task>(11, Task.taskComparator);
        tasks.offer(new Task(20,"写日记"));
        tasks.offer(new Task(10,"看电视"));
        tasks.offer(new Task(100,"写代码"));
        Task task = tasks.poll();
        while (task != null)
            System.out.print(" 处理任务: " + task.name + "，优先级:" + task.priority + "\n");
            task = tasks.poll();




//        马俊昌. Java编程的逻辑 (Java核心技术系列) (Kindle 位置 5874-5877). 北京华章图文信息有限公司. Kindle 版本.

//        马俊昌. Java编程的逻辑 (Java核心技术系列) (Kindle 位置 5856-5858). 北京华章图文信息有限公司. Kindle 版本.
    }
}
