<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Подключение базы данных</title>
    </head>
 
    <body>
        <form method="POST" action="Servlet">
            <input type="hidden" name="command" value="CreateConnection"/>
            <table border="3">
                <tr>
                    <td>Введите порт MySQL:</td>
                    <td><input type="text" name="port" value="3306"/></td>
                </tr>
                <tr>
                    <td>Введите username MySQL::</td>
                    <td><input type="text" name="username" value="root"/></td>
                </tr>
                <tr>
                    <td>Введите password MySQL::</td>
                    <td><input type="text" name="password" value="asd"/></td>
                </tr>
                <tr>
                    <td>Введите название БД:</td>
                    <td><input type="text" name="dbname" value="rms"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Создать подключение"/></td>
                </tr>
            </table>
        </form>
    </body>
 </html>
