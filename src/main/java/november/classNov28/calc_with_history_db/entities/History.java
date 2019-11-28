package november.classNov28.calc_with_history_db.entities;

import java.util.ArrayList;
import java.util.List;

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
