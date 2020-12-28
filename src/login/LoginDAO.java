package login;

public interface LoginDAO {

    public void login(String username, String password);

    public void logout();
}
