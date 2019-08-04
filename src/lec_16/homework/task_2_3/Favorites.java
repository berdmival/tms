package lec_16.homework.task_2_3;

public class Favorites {
    private String subject;
    private int priority;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "subject='" + subject + '\'' +
                ", priority=" + priority +
                '}';
    }
}
