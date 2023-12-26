import java.util.Scanner;

public class StepTracker {
    private static final int monthsCount = 12;
    private int month;
    private static final int[][] days = new int[monthsCount][];

    static {
        days[0] = new int[Months.January.getDaysCount()];
        days[1] = new int[Months.February.getDaysCount()];
        days[2] = new int[Months.March.getDaysCount()];
        days[3] = new int[Months.April.getDaysCount()];
        days[4] = new int[Months.May.getDaysCount()];
        days[5] = new int[Months.June.getDaysCount()];
        days[6] = new int[Months.July.getDaysCount()];
        days[7] = new int[Months.August.getDaysCount()];
        days[8] = new int[Months.September.getDaysCount()];
        days[9] = new int[Months.October.getDaysCount()];
        days[10] = new int[Months.November.getDaysCount()];
        days[11] = new int[Months.December.getDaysCount()];
    }

    Scanner scanner = new Scanner(System.in);
    private static int goalByStepsPerDay = 10000;

    public static int[][] getDays() {
        return days;
    }

    public static int getGoalByStepsPerDay() {
        return goalByStepsPerDay;
    }

    void addNewNumberStepsPerDay() {
        month = checkMonth();
        int day = checkDay();
        int steps = checkStepsCount();
        for (int i = 0; i < days.length; i++) {
            for (int j = 0; j < days[i].length; j++) {
                days[month - 1][day - 1] = steps;
            }
        }
        System.out.println("Сохранено!\n");
    }

    public void setGoalByStepsPerDay() {
        goalByStepsPerDay = checkGoal();
        System.out.println("Новая цель: " + goalByStepsPerDay + " шагов в день сохранена!\n");
    }

    public void closeStepTracker() {
        System.out.println("Программа завершена");
        System.exit(0);
    }

    public int checkMonth() {
        int month;
        while (true) {
            System.out.println("Введите номер месяца:");
            month = checkInput(scanner.next());
            if (month < 1 || month > 12) {
                System.out.println("Ошибка! Пожалуйста, введите значение от 1 до 12\n");
            } else {
                break;
            }
        }
        return month;
    }

    public int checkDay() {
        int day;
        while (true) {
            System.out.println("Введите номер дня:");
            day = checkInput(scanner.next());
            if (day < 1 || day > days[month - 1].length) {
                System.out.println("Ошибка! Пожалуйста, введите значение от 1 до " + days[month - 1].length + "\n");
            } else {
                break;
            }
        }
        return day;
    }

    public int checkStepsCount() {
        int stepsCount;
        while (true) {
            System.out.println("Введите количество шагов:");
            stepsCount = checkInput(scanner.next());
            if (stepsCount < 1) {
                System.out.println("Ошибка! Пожалуйста, введите корректное значение\n");
            } else {
                break;
            }
        }
        return stepsCount;
    }

    public int checkGoal() {
        int goal;
        while (true) {
            System.out.println("Введите новую цель:");
            goal = checkInput(scanner.next());
            if (goal < 1) {
                System.out.println("Ошибка! Пожалуйста, введите корректное значение\n");
            } else {
                break;
            }
        }
        return goal;
    }

    public int checkInput(String input) {
        String value = "0";
        char[] inputArray = input.toCharArray();
        boolean isDigit = true;
        for (char ch : inputArray) {
            if (!Character.isDigit(ch)) {
                isDigit = false;
            }
        }
        if (isDigit && Long.parseLong(input) < Integer.MAX_VALUE) {
            value = input;
        }
        return Integer.parseInt(value);
    }
}