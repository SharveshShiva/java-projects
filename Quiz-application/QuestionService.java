import java.util.Scanner;
class QuestionService{
    Questions[] question = new Questions[5];// array of type questions.
    String[] answers = new String[5];
    int i = 0;

    public QuestionService(){
        question[0] = new Questions(1,
                "Which of the following is NOT a primitive data type in Java?",
                "int",
                "boolean",
                "String",
                "double",
                "String");

        question[1] = new Questions(2,
                "Which keyword is used to inherit a class in Java?",
                "extends",
                "implements",
                "inherits",
                "super",
                "extends");

        question[2] = new Questions(3,
                "What is the index of the first element in a Java array?",
                "1",
                "0",
                "-1",
                "null",
                "0");

        question[3] = new Questions(4,
                "Which method is used to find the length of a String in Java?",
                "length()",
                "size()",
                "getLength()",
                "count()",
                "length()");

        question[4] = new Questions(5,
                "Which loop is guaranteed to execute at least once?",
                "for loop",
                "while loop",
                "do-while loop",
                "enhanced for loop",
                "do-while loop");

    }

    public void playQuiz(){
        for(Questions q : question){
            System.out.print("Question: "+q.getId()+". ");
            System.out.println(q.getQuestion());
            System.out.println("1. "+q.getOp1());
            System.out.println("2. "+q.getOp2());
            System.out.println("3. "+q.getOp3());
            System.out.println("4. "+q.getOp4());
            Scanner sc = new Scanner(System.in);
            answers[i] = sc.nextLine();
            i++;
        }
    }

    public void printScore(){
        int score = 0;
        for(int i=0;i<question.length;i++){
            Questions que = question[i];
            String answer = que.getAnswer();
            String userAnswer = answers[i];

            if(answer.equals(userAnswer)){
                score++;
                System.out.println("Correct");
            }

            else{
                System.out.println("Wrong");
            }
        }

        System.out.println("Your score is "+score);
    }
}