import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.model.Role;
import hiber.model.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllTest {

    @Test
    public void Testing() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserDao userService = context.getBean(UserDao.class);


        /*User user1 = new User("naaasos", "laaaas", "eaaaas", "pp");
        User user2 = new User("aaa", "aaa", "aaa","pp");
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USERR");*/

        //user1.getRoles().add(role2);
        //user1.setId(1l);
        //user2.getRoles().add(role2);
        //user2.getRoles().add(role1);
        //userService.createUser(user2);
        //userService.updateUser(user1);

        System.out.println(userService.getUserByEmail("memtt@pozvonim.com"));
        //userService.deleteUserById(user1);
    }
}
