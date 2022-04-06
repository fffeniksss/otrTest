import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        try {
            File file = new File("src/test.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            StringBuilder builder = new StringBuilder();
            builder.append(line).append("\n");
            while (line != null) {
                line = reader.readLine();
                try {
                    builder.append(line).append("\n");
                    if (isNumeric(line)) {
                        users.add(createUserFromString(builder.toString()));
                        builder.setLength(0);
                    }
                } catch (Exception ignore) {
                }
            }
            users.forEach(u -> System.out.println(u + "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isNumeric(String string) {
        if (string == null || string.equals("")) {
            return false;
        }
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ignored) {
        }
        return false;
    }

    public static User createUserFromString(String string) {
        String[] userStr = string.split("\n");
        return new User(userStr[0], userStr[1], userStr[2], Integer.parseInt(userStr[3]));
    }

    static class User {
        String firstName;
        String secondName;
        String middleName;
        Integer age;

        public User(String firstName, String secondName, String middleName, Integer age) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.middleName = middleName;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", secondName='" + secondName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
