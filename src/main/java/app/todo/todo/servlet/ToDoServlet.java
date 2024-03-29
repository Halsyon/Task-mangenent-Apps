package app.todo.todo.servlet;

import app.todo.todo.model.Event;
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
import java.util.Date;
import java.util.List;

/**
 * Сервлет, который будет отрабатывать запросы.
 * объект типа PrintWriter, используемый для отправки вывода клиенту.
 * Однако, чтобы сделать объект response полезным,
 * следует использовать буферизированный вариант PrintWriter - JspWriter
 * Перед определением класса указана аннотация WebServlet,
 * которая указывает, с какой конечной точкой будет сопоставляться данный сервлет.
 * То есть данный сервлет будет обрабатывать запросы по адресу "/greet".
 * Для обработки GET-запросов (например, при обращении к сервлету из адресной строки браузера)
 * сервлет должен переопределить метод doGet. То есть, к примеру, в данном случае get-запрос
 * по адресу /greet будет обрабатываться методом doGet.
 * два параметра. Параметр типа HttpServletRequest инкапсулирует всю информацию о запросе.
 * А параметр типа HttpServletResponse позволяет управлять ответом.
 */
/*/todo*/
public class ToDoServlet extends HttpServlet {
    private static final Gson GSON = new GsonBuilder().create();
    private List<User> userList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String category;
        var fr = req.getParameter("description");
        category = req.getParameter("category");
        var usr = req.getParameter("user");
        System.out.println("TO DO SERV USER : " + usr);

        if (category.equals("null")) {
            category = "normal";
        }
        System.out.println("String " + fr);
        System.out.println("String " + category);
        /*Event event = new Event(fr, Timestamp.valueOf(LocalDateTime.now()), false, category);*/
        Event event = new Event(fr, new Date(System.currentTimeMillis()), false, category);

        var evtId = HbnStore.instOf().add(event);
        var iD = evtId.getId();
        System.out.println("Evene ID posle bazi : " + iD);
        var userL = HbnStore.instOf().findByEmail(usr);
        var user1 = userL.iterator().next();
        var userNewTack = User.of(user1.getName(), user1.getEmail(), user1.getPassword(), event);
        HbnStore.instOf().addUser(userNewTack);
        userList.add(userNewTack);
        resp.setContentType("application/json; charset=utf-8");
        OutputStream output = resp.getOutputStream();
        String json = GSON.toJson(userList);
        output.write(json.getBytes(StandardCharsets.UTF_8));
        output.flush();
        output.close();
    }
}
