<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Result Page</title>
    </head>
    <body>
        <h3>Результат запроса:</h3>
        <table border="3">
            <tr>
                <td>Реквест.toString():</td>
                <td>${req}</td>
            </tr>
            <tr>
                <td>header реквеста:</td>
                <td>${header}</td>
            </tr>
            <tr>
                <td>URL реквеста:</td>
                <td>${requestURL}</td>
            </tr>
            <tr>
                <td>Параметры реквеста:</td>
                <td>${param}</td>
            </tr>
        </table>
    </body>
</html>
