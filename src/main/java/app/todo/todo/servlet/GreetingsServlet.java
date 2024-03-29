package app.todo.todo.servlet;

import app.todo.todo.model.User;
import app.todo.todo.store.HbnStore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервлет передает получает данные из БД все записи существующие на данный момент,
 * передает их вызывающему в виде json.
 * mapping - /greet
 */
public class GreetingsServlet extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();

    private List<User> userList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        for (User user : HbnStore.instOf().findAllUser()) {
            System.out.println("ТО что достакм : " + user);
            userList.add(user);
        }

        String email = req.getParameter("user");
        System.out.println("SErvlet Geet String user " + email);
        resp.setContentType("application/json; charset=utf-8");
        OutputStream output = resp.getOutputStream();
        String json = GSON.toJson(userList);
        output.write(json.getBytes(StandardCharsets.UTF_8));
        output.flush();
        output.close();
    }
}
