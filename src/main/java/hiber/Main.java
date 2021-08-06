package hiber;

import hiber.config.AppConfig;
import hiber.model.Role;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);


        User user1 = new User("naaasos", "laaaas", "eaaaas", "pp");
        User user2 = new User("aaa", "aaa", "aaa","pp");
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USERR");

        //user1.getRoles().add(role2);
        //user1.setId(1l);
        //user2.getRoles().add(role2);
        //user2.getRoles().add(role1);
        //userService.createUser(user2);
        //userService.updateUser(user1);

        System.out.println(userService.getUser(1l).getRoles());
        //userService.deleteUserById(user1);
    }
}
