public class CalculatorSwitch {

    static void calc(double A, double B, char operation){

        double result = 0;

        switch (operation) {
            case '+':
                result = A + B;
                System.out.println("Сума A і B: " + result);
                break;
            case '-':
                result = A - B;
                System.out.println("Різниця A і B: " + result);
                break;
            case '*':
                result = A * B;
                System.out.println("Множення A на B: " + result);
                break;
            case '/':
                if (B != 0) {
                    result = A / B;
                    System.out.println("Поділити A на B: " + result);
                } else {
                    System.out.println("Неможна поділити на нуль");
                }
                break;
            default:
                System.out.println("Некоректна операція");
                break;
        }

    }

    public static void main(String[] args) {

        calc(20,  10,  '+');
        calc(20,  10,  '-');
        calc(20,  10,  '*');
        calc(20,  10,  '/');
        calc(20,  10,  '$');


    }
}