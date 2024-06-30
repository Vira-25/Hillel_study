public class CalculatorIf {


static void calc(double numA, double numB, char operation){
    double result = 0;
    if(operation == '+') {
        result = numA + numB;
    } else if(operation == '-'){
        result = numA - numB;
    } else if(operation == '*'){
        result = numA * numB;
    } else if(operation == '/'){
        result = numA / numB;
    } else {
        System.out.println("Ups, incorrect operation type");
    }
    System.out.println("Result: " + result);
}

public static void main(String[] args) {
    calc(20, 10, '+');
    calc(20, 10, '-');
    calc(20, 10, '*');
    calc(20, 10, '/');
    calc(20, 10, '$');
}

}

