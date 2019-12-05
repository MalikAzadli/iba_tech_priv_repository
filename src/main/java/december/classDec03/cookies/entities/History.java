package december.classDec03.cookies.entities;

public class History {
    private User user;
    private Operation operation;

    public History(User user, Operation operation) {
        this.user = user;
        this.operation = operation;
    }

    public User getUser() {
        return user;
    }

    public Operation getOperation() {
        return operation;
    }
}
