package november.classNov26.calc_with_history;

public class Operation {
    private final String op1;
    private final String operation;
    private final String op2;
    private final String res;

    public Operation(String op1, String operation, String op2, String res) {
        this.op1 = op1;
        this.operation = operation;
        this.op2 = op2;
        this.res = res;
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
