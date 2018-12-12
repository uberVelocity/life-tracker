package model;

public class Model {

    private User user;
    private Database database;

    public Model() {
        user = new User();
        database = new Database();
    }

    public Model(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Database getDatabase() {
        return database;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
