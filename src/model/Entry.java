package model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Entry implements Serializable {

    private static final long serialVersionUID = 42L;

    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private Date date;

    /**
     * Depending on the button pressed, the entry will have
     * a certain type. This type is initialized in the con-
     * structor.
     *
     * Press button in context A -> set type of Entry context(A).
     */
    private Type type;

    public enum Type {
      WORKOUT, CALORIES, WEIGHT, FOOD, SLEEP, TASK, HABIT, DIARY, USER
    }

    public Entry() {}

    public Entry(Type type) {
        this.type = type;
    }

    public void printDate() {
        System.out.println(sdf.format(date));
    }

    public Type getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public void setUser(String username, int age) {
        User user = new User();
        user.setAge(age);
        user.setUsername(username);
    }
}
