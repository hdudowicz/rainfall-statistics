import java.util.ArrayList;
import java.util.List;

public class RainfallStats {

    List<Double> stats = new ArrayList<>();

    public int getCount() {
        return stats.size();
    }


    public void addMeasurement(double measurement) throws InvalidRainfallException{
        if (measurement < 0){
            throw new InvalidRainfallException();
        } else {
            stats.add(measurement);
        }
    }

    public double getMean() throws IllegalStateException{
        if (stats.size() == 0){
            throw new IllegalStateException();
        } else {
            double temp = 0;
            for (double num : stats) {
                temp += num;
            }
            return temp / stats.size();
        }
    }

    public double getMax() throws IllegalStateException {
        if (stats.size() == 0){
            throw new IllegalStateException();
        } else {
            double largest = 0;
            for (double num : stats) {
                if (num > largest) {
                    largest = num;
                }
            }
            return largest;
        }
    }
}
