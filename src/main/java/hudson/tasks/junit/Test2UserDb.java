package hudson.tasks.junit;

import java.util.Map;
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
}
