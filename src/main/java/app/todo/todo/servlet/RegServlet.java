package app.todo.todo.servlet;

import app.todo.todo.model.User;
import app.todo.todo.store.HbnStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 4. Регистрация пользователя. [#283110 #209712]01
 * Уровень : 3. МидлКатегория : 3.2. Servlet JSPТопик : 3.2.6. Filter, Security
 * ATTENTION! -
 * удален файл web.xml, произведена замена во всех классах
 * на аннотацию @WebServlet(urlPattern = " маппинг имя")
 */
/*@WebServlet(urlPatterns = "/reg.do")*/
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("reg.jsp").forward(req, resp);
    }

    /**
     * Если пользователь ввел верную почту и пароль, то мы записываем в HttpSession
     * детали этого пользователя.
     * HttpSession sc = req.getSession();
     * User admin = new User();
     * admin.setName("Admin");
     * admin.setEmail(email);
     * sc.setAttribute("user", admin);
     * Теперь эти данные можно получить на другой странице.
     * <p>
     * 4. Регистрация пользователя. [#283110 #209712]
     * Уровень : 3. МидлКатегория : 3.2. Servlet JSPТопик : 3.2.6. Filter, Security
     * Авторизация и регистрацию сделайте через Store. В предыдущих уроках мы загрузали пользователя в коде.
     * User admin = new User();
     * admin.setName("Admin");
     * admin.setEmail(email);
     * sc.setAttribute("user", admin);
     * Нужно это переделать на Store.instOf().findByEmail().
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        var userList = HbnStore.instOf().findByEmail(email);
        var user = userList.get(0);
        if (user != null) {
            req.setAttribute("error", "данный пользователь уже существует");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        if (name != null && email != null && password != null) {
            HttpSession sc = req.getSession();
            User admin = new User();
            admin.setName(name);
            admin.setEmail(email);
            admin.setPassword(password);
            sc.setAttribute("user", admin);
            HbnStore.instOf().save(admin);
            resp.sendRedirect(req.getContextPath() + "/afterLogin.jsp");
        } else {
            req.setAttribute("error", "Не верный email, пароль или имя");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
