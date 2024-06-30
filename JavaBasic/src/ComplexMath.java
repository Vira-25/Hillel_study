public class ComplexMath {

static double calc(double numA, double numB, char operation){
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
    return result;
}

public static void main(String[] args) {

    double d = calc(20, 10, '+');
    double v = calc(d, 5, '*');
    double z = calc(v, 100.50, '-');
    System.out.println(z);

    //System.out.println(calc(20, 10, '+'));
    //System.out.println(calc(20, 10, '-'));
    //System.out.println(calc(20, 10, '*'));
    //System.out.println(calc(20, 10, '/'));
    //System.out.println(calc(20, 10, '$'));
}

}

