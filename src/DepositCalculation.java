import java.util.Scanner;

public class DepositCalculation {

    private static final double YEAR_RATE = 0.06;

    double calculateComplexPercent(double amount, int depositPeriod) {
        double payment = amount * Math.pow((1 + YEAR_RATE / 12), 12 * depositPeriod);
        // Не нашёл точной информации, но мне кажется здесь и в двух методах ниже ну нужна пустая строка, потому что в методе
        return randomizePercent(payment); // в методе состоящем из 2х строк нет смысла улучшать читаемость кода
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        double payment = amount + amount * YEAR_RATE * depositPeriod;

        return randomizePercent(payment);
    }

    double randomizePercent(double value) { // Этот метод округляет число, поэтому мне кажется что было бы лучше
        double scale = Math.pow(10, 2);     // назвать его по другому. Например: roundNumber или как-то похоже.

        return Math.round(value * scale) / scale;
    }

    void openBankDepositAccount() {
        int period, action;
        double totalPercentage = 0;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = userInput.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = userInput.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = userInput.nextInt();

        if (action == 1) {
            totalPercentage = calculateSimplePercent(amount, period);
        } else if (action == 2) {
            totalPercentage = calculateComplexPercent(amount, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalPercentage);
    }

    public static void main(String[] args) {
        new DepositCalculation().openBankDepositAccount();
    }
}
