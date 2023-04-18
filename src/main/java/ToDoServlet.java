import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

@WebServlet(urlPatterns = "/todo", loadOnStartup = -1)
public class ToDoServlet extends HttpServlet {
    private final ArrayList<Task> tasks = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        if (tasks.size() == 0) {
//            tasks.add(new Task("isComplete"));
//            tasks.add(new Task("isDontComplete"));
//            tasks.get(0).check();
//        }
        ArrayList<Task> reversTasks = new ArrayList<>(tasks);
        Collections.reverse(reversTasks);
        req.setAttribute("tasks", reversTasks);
        req.getRequestDispatcher("/todo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            String task = request.getParameter("newTask");
            tasks.add(new Task(task));
        } else if ("checked".equals(action)) {
            String task = request.getParameter("task");
            getTask(task).check();
        } else if ("delete".equals(action)) {
            String task = request.getParameter("task");
            tasks.remove(getTask(task));
        }

        response.sendRedirect("/todo");
    }


    private Task getTask(String taskString) {
        for (Task task:tasks) {
            if (Objects.equals(task.task, taskString)) return task;
        }
        return null;
    }
}
