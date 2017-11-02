package example.users;

import org.neogroup.warp.controllers.ControllerComponent;
import org.neogroup.warp.controllers.routing.Get;
import org.neogroup.warp.controllers.routing.Route;
import org.neogroup.warp.views.View;

import static org.neogroup.warp.Warp.createView;
import static org.neogroup.warp.Warp.retrieveModels;

@ControllerComponent
public class UsersController {

    @Get("users")
    protected Route showUsers = (req, res) -> {
        View usersView = createView("usersList");
        usersView.setParameter("users", retrieveModels(User.class));
        return usersView;
    };
}