class Questions{
    private int id;
    private String question;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String answer;

    public Questions(int id, String question, String op1, String op2, String op3, String op4, String answer){
        setId(id);
        setQuestion(question);
        setOp1(op1);
        setOp2(op2);
        setOp3(op3);
        setOp4(op4);
        setAnswer(answer);
    }

    // setters - to obtain the value from the users;
    public void setId(int id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public void setOp4(String op4) {
        this.op4 = op4;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    // getters - to use these values;
    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getOp1() {
        return op1;
    }

    public String getOp2() {
        return op2;
    }

    public String getOp3() {
        return op3;
    }

    public String getOp4() {
        return op4;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Questions{" + "id=" + id + ", question='" + question + '\'' + ", op1='" + op1 + '\'' + ", op2='" + op2 + '\'' + ", op3='" + op3 + '\'' + ", op4='" + op4 + '\'' + ", answer='" + answer + '\'' +
                '}';
    }
}