package hudson.tasks.junit;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ldrygala on 2015-11-27.
 */
public final class Test2UserDb {
    private static final Map<String,String> test2User = new ConcurrentHashMap<String, String>();

    private Test2UserDb() {
    }

    public static void assign(String test, String user) {
        test2User.put(test,user);
    }

    public static String getAssignedUser(String test) {
        return test2User.get(test);
    }

    public static boolean isAssigned(String test) {
        return test2User.containsKey(test);
    }

    public static void unassign(String test) {
        test2User.remove(test);
    }

    public static void removeOtherThen(List<String> tests) {
        Set<String> testsAssignedToUser = test2User.keySet();
        for (String t2u : testsAssignedToUser) {
            if (!tests.contains(t2u)) {
                test2User.remove(t2u);
            }
        }
    }
}
