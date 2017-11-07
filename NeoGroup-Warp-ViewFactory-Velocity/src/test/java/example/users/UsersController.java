package example.users;

import org.neogroup.warp.controllers.ControllerComponent;
import org.neogroup.warp.controllers.routing.Get;
import org.neogroup.warp.controllers.routing.Route;
import org.neogroup.warp.views.View;

import java.util.Map;

import static org.neogroup.warp.Warp.createView;
import static org.neogroup.warp.Warp.retrieveModel;
import static org.neogroup.warp.Warp.retrieveModels;

@ControllerComponent
public class UsersController {

    @Get("users")
    protected Route showUsers = (req, res) -> {
        View usersView = createView("usersList", Map.of("rama", "pepech"));
        usersView.setParameter("users", retrieveModels(User.class));
        usersView.setParameter("user", retrieveModel(User.class, 1));
        return usersView;
    };

    @Get("test")
    protected Route test = (req, res) -> "ramaaaa !!!";
}
