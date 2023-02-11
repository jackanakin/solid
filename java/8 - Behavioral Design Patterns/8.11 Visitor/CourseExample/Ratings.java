import java.util.HashMap;

@SuppressWarnings("serial")
public class Ratings extends HashMap<Integer, PerformanceRating> {
    public int getFinalRating(int empId) {
        return get(empId).getFinalRating();
    }
}