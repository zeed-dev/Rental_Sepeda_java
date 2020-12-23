package user;

import javax.swing.JTable;

public interface UserDAO {

    public void read(JTable table);

    public void create(User user);

    public void update(User user);

    public void delete(int id);

    public void search(JTable jt,String key);
}
