<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>
<form method="post" action="/todo?action=add">
    <input type="text" name="newTask">
    <input type="submit" value="Add new task">
</form>
<br>
<ul>
    <c:forEach items="${tasks}" var="task">
        <li>
            <form method="post" action="/todo?action=checked" name="checkedTask">
                <label>
                    <input type="hidden" name="task" value="${task.task}">
                    <input type="checkbox"
                           name="completed"
                        ${task.completed ? 'checked' : ''} onchange="this.form.submit()" />
                        ${task.completed ? '<s>' : ''}
                        ${task.task}
                        ${task.completed ? '</s>' : ''}
                </label>
            </form> <form method="post" action="/todo?action=delete">
                <input type="hidden" name="task" value="${task.task}">
                <input type="submit" value="Delete">
            </form>
        </li>
    </c:forEach>
</ul>
</body>
</html>