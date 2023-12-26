public class Converter {
    public double convertToKm(int steps) {
        double kmInOneStep = 0.00075;
        return steps * kmInOneStep;
    }

    public double convertStepsToKilocalories(int steps) {
        double kcalInOneStep = 0.05;
        return steps * kcalInOneStep;
    }
}