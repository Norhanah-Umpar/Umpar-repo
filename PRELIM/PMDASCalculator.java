import java.util.Scanner;
import java.util.Stack;
//Use stack in order to read through the expression, as it will remove the 
//the first numbers in the equation until to the last number, thus reading 
//the expression and implement appropriate operation for the expression.

public class PMDASCalculator {

    public static double evaluatePMDAS(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        
        //this loop is for reading through the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            //checks if the character is digit or not, (operation symbols and () are not digits)
            if (Character.isDigit(ch)) {
            
               //append is part of the StringBuilder class in which it would add the string in sequence
                StringBuilder numappend = new StringBuilder();
                
                //while loop explains that the expression does not go beyond the index of the operation
                //the character in position is a digit or has a decimal point.
                //if conditions are met it would then append to numbuilder, which is used to construct a numerical value
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numappend.append(expression.charAt(i));
                    i++;//moves to the next character of the expressin
                }
                i--;//i-- step ensures that i is correctly positioned after the numerical value has been extracted.

               //change the numappend.toString to double by parsing
                double num = Double.parseDouble(numappend.toString());
                values.push(num);//keep track on the num of the expression by pushing
            } else if (ch == '(') {
                operators.push(ch);//ch is pusehd to stack operators. keep track of operators and parenthesis
            } else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {//this loop evaluates the numbers within the parentheses
                    applyOperator(values, operators);
                }
                operators.pop(); // the pop is the'(' and removes it 
            } 
            else if (isOperator(ch)) {//if the ch in the expresion is not an open and close parenthesis
            
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                //precedence is part of java operators in which evaluates the highest precedence first    
                    applyOperator(values, operators);//call apply operators method
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            applyOperator(values, operators);
        }

        return values.pop();//result
    }

    public static boolean isOperator(char ch) {//checks if ch is an opeartor or not 
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static int precedence(char operator) {
        switch (operator) {
            case '*':
            case '/':
                return 2; // higher precedence
            case '+':
            case '-':
                return 1; //lower precedence
            default:
                return 0; // not  part of the operators
        }
    }

    public static void applyOperator(Stack<Double> values, Stack<Character> operators) {
        char operator = operators.pop(); //oprator to be performed
        double operand2 = values.pop(); //top operand but second value 
        double operand1 = values.pop();//second operand but first value
        double result = 0;

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }
        values.push(result);//final result
    }
     public static void main(String[] args) {//main class
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter expression or type 'exit' to quit: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("bye");
                break;
            }
                double answer = evaluatePMDAS(input);
                System.out.println("Answer: " + answer);
        }
    }
}