import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        try {
            File file = new File("src/test.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            List<User> users = new ArrayList<>();
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
            System.out.println(users);
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
    }
}
