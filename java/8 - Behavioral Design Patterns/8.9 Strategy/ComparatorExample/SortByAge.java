import java.util.Comparator;

public class SortByAge implements Comparator<User> {

    @Override
    public int compare(User arg0, User arg1) {
        return arg0.getAge() - arg1.getAge();
    }

}
