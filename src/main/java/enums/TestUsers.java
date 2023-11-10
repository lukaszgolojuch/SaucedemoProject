package enums;

import java.util.Random;

public enum TestUsers {

    STANDARD_USER ("standard_user", "secret_sauce"),
    LOCKED_OUT_USER ("locked_out_user", "secret_sauce"),
    PROBLEM_USER ("problem_user", "secret_sauce"),
    PERFORMANCE_GLITCH_USER ("performance_glitch_user", "secret_sauce"),
    ERROR_USER ("error_user", "secret_sauce"),
    VISUAL_USER ("visual_user", "secret_sauce");

    private final String username;
    private final String password;
    private static final Random random = new Random();

    TestUsers(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String username() { return username; }
    public String password() { return password; }

    public static TestUsers randomUser()  {
        TestUsers[] users = values();
        return users[random.nextInt(users.length)];
    }
}
