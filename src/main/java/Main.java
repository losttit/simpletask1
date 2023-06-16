import java.util.Scanner;
// A simple calculator 1.0
public class Main {
    static Scanner sc = new Scanner(System.in);
    static String digit;
    public static String calc(String input) {
        String[] expression = input.split(" ");
        switch (expression[1]){
            case "+":
                digit = String.valueOf(Float.parseFloat(expression[0]) + Float.parseFloat(expression[2]));
                break;
            case "-":
                digit = String.valueOf(Float.parseFloat(expression[0]) - Float.parseFloat(expression[2]));
                break;
            case "/":
                digit = String.valueOf(Float.parseFloat(expression[0]) / Float.parseFloat(expression[2]));
                break;
            case "*":
                digit = String.valueOf(Float.parseFloat(expression[0]) * Float.parseFloat(expression[2]));
                break;
            default:
                digit = "Vse xuyina, davai po novoy";
        }
        return digit;
    }

    public static void main(String[] args){
        System.out.println(calc(sc.nextLine()));
    }
}