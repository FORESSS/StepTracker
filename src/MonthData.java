public class MonthData {
    StepTracker stepTracker = new StepTracker();
    Converter converter = new Converter();

    void printStatistic() {
        int month = stepTracker.checkMonth();
        printGoal();
        printSumStepsFromMonth(month);
        printDaysAndStepsFromMonth(month);
        printMaxSteps(month);
        printBestSeries(month, StepTracker.getGoalByStepsPerDay());
        printAverageStepsFromMonth(month);
        printDistance(getSumStepsFromMonth(month));
        printCalories(getSumStepsFromMonth(month));
    }

    void printDaysAndStepsFromMonth(int month) {
        System.out.println("Количество пройдёных шагов по дням:");
        for (int i = 0; i < StepTracker.getDays()[month - 1].length; i++) {
            System.out.print(i != StepTracker.getDays()[month - 1].length - 1 ? (i + 1)
                    + " День: " + StepTracker.getDays()[month - 1][i] + ", "
                    : (i + 1) + " День: " + StepTracker.getDays()[month - 1][i] + "\n");
        }
        System.out.println();
    }

    int getSumStepsFromMonth(int month) {
        int sumSteps = 0;
        for (int i = 0; i < StepTracker.getDays()[month - 1].length; i++) {
            sumSteps += StepTracker.getDays()[month - 1][i];
        }
        return sumSteps;
    }

    void printSumStepsFromMonth(int month) {
        System.out.println("Общее количество шагов за месяц: " + getSumStepsFromMonth(month) + "\n");
    }

    void printAverageStepsFromMonth(int month) {
        System.out.println("Среднее количество шагов в день: " + getSumStepsFromMonth(month) / StepTracker.getDays()[month - 1].length + "\n");
    }

    void printMaxSteps(int month) {
        int maxSteps = 0;
        int day = 0;
        for (int i = 0; i < StepTracker.getDays()[month - 1].length; i++) {
            if (StepTracker.getDays()[month - 1][i] > maxSteps) {
                maxSteps = StepTracker.getDays()[month - 1][i];
                day = i + 1;
            }
        }
        System.out.println("Максимальное количество шагов за день: ");
        System.out.println("День " + day + ": " + maxSteps + " шагов\n");
    }

    void printBestSeries(int month, int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < StepTracker.getDays()[month - 1].length; i++) {
            if (StepTracker.getDays()[month - 1][i] >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                currentSeries = 0;
            }
            if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
            }
        }
        System.out.println("Самая длинная серия выполненной цели: " + finalSeries + "\n");
    }

    void printDistance(int steps) {
        System.out.printf("Пройденая дистания за месяц: %.2f км\n\n", converter.convertToKm(steps));
    }

    void printCalories(int steps) {
        System.out.printf("Сожжено за месяц: %.1f ккал\n\n", converter.convertStepsToKilocalories(steps));
    }

    void printGoal() {
        System.out.println("Цель: " + StepTracker.getGoalByStepsPerDay() + " шагов в день\n");
    }
}