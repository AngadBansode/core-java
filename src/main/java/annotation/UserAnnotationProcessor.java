package annotation;

import java.lang.reflect.Method;

public class UserAnnotationProcessor {
    public static void main(String[] args) {
        UserService userService = new UserService();

        Method[] methods = UserService.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(User.class)) {
                User user = method.getAnnotation(User.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Username: " + user.username());
                System.out.println("Permission Level: " + user.permissionLevel());
                System.out.println("----------");
            }
        }
    }
}
