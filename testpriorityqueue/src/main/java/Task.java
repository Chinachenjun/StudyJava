import java.util.Comparator;

public class Task {
    int priority; //值越大，优先级越高
    String name;
    public Task(int priority,String name){
        this.priority = priority;
        this.name = name;
    }
    public static Comparator<Task> taskComparator = new Comparator<Task>() {
        @Override
        public int compare(Task o1, Task o2) {
            if(o1.priority > o2.priority){
                return -1;
            }else if(o1.priority < o2.priority){
                return 1;
            }
            return 0;
        }
    };
}
