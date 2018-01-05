import controllers.UserController;
import services.UserService;

import static spark.Spark.port;

public class Main {
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        new UserController(new UserService());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

}
