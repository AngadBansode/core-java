package annotation;

public class UserService {

    @User(username = "alice", permissionLevel = "ADMIN")
    public void createUser() {
        System.out.println("Creating a new user.");
    }

    @User(username = "bob")
    public void viewUser() {
        System.out.println("Viewing user information.");
    }

    @User(username = "charlie", permissionLevel = "GUEST")
    public void deleteUser() {
        System.out.println("Deleting a user.");
    }
}
