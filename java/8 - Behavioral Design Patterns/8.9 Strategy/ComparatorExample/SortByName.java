import java.util.Comparator;

public class SortByName implements Comparator<User> {

    @Override
    public int compare(User arg0, User arg1) {
        return arg0.getName().compareToIgnoreCase(arg1.getName());
    }

}
