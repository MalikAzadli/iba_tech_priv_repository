package november.classNov28.calc_with_history_db.entities;

public class Operation {
    private final String op1;
    private final String operation;
    private final String op2;
    private  String res;

    public Operation(String op1, String operation, String op2, String res) {
        this.op1 = op1;
        this.operation = operation;
        this.op2 = op2;
        this.res = res;
    }

    public Operation(String op1, String operation, String op2) {
        this.op1 = op1;
        this.operation = operation;
        this.op2 = op2;
    }

    public String getOp1() {
        return op1;
    }

    public String getOperation() {
        return operation;
    }

    public String getOp2() {
        return op2;
    }

    public String getRes() {
        return res;
    }
}
