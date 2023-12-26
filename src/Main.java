import java.util.Scanner;

public class Main {
    static StepTracker stepTracker = new StepTracker();
    static MonthData monthData = new MonthData();

    public static void main(String[] args) {
        System.out.println("Вас приветствует счётчик калорий!\n");
        while (true) {
            switch (printMenu()) {
                case "1" -> stepTracker.addNewNumberStepsPerDay();
                case "2" -> stepTracker.setGoalByStepsPerDay();
                case "3" -> monthData.printStatistic();
                case "4" -> stepTracker.closeStepTracker();
                default -> System.out.println("Неизвестная команда!\n");
            }
        }
    }

    public static String printMenu() {
        System.out.println("Выберите одну из команд:");
        System.out.println("1. Ввести количество пройденых шагов за день");
        System.out.println("2. Ввести цель шагов в день");
        System.out.println("3. Показать статистику за месяц");
        System.out.println("4. Завершить работу");
        return new Scanner(System.in).next();
    }
}