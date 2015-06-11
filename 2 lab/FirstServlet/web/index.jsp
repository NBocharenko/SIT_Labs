<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Ввод формы</title>
    </head>
    <body>
        <h3>Заполните форму:</h3>
        <form name="Simple" action="simpleservlet" method="POST">
            <input type="hidden" name="buttonClick" value="Кнопка_не_нажата"/>
            <table border="3">
                <tr>
                    <td align="center"><i>Кнопка</i></td>
                    <td align="center"><i>Что любите употреблять поутру?</i></td>
                    <td align="center"><i>Емэйл</i></td>
                    <td align="center"><i>Что нужно сделать с изобретателем goTo?</i></td>
                </tr>
                <tr>
                    <td align="center"><input type="button" name="button" value="Кнопка" onclick="button1()"/></td>
                    <td align="center">
                        <input type="checkbox" name="checkbox1"/><label>Чай</label>
                        <input type="checkbox" name="checkbox2"/><label>Кофе</label>
                        <input type="checkbox" name="checkbox3"/><label>Героин</label>
                    </td>
                    <td align="center"><input type="email" name="email"/></td>
                    <td align="center">
                        <input type="radio" name="radio" value="1"/><label>Повесить</label>
                        <input type="radio" name="radio" value="2"/><label>Расстреллять</label>
                        <input type="radio" name="radio" value="3"/><label>Утопить</label>
                    </td>
                </tr>
                <tr>
                    <td align="center"><i>Цвет</i></td>
                    <td align="center"><i>Пароль</i></td>
                    <td align="center"><i>Текст</i></td>
                    <td align="center"><i>Файл</i></td>
                </tr>
                <tr>
                    <td align="center"><input type="color" name="color"/></td>
                    <td align="center"><input type="password" name="password"/></td>
                    <td align="center"><input type="text" name="text"/></td>
                    <td align="center"><input type="file" name="file"/></td>
                </tr>
                <tr align="center">
                    <td colspan="2"><input type="submit" name="submit" value="Отправить форму"/></td>
                    <td colspan="2"><input type="reset" name="reset" value="Сбросить форму"/></td>
                </tr>
            </table>  
        </form>
        
         <SCRIPT LANGUAGE="JavaScript">
            <!--
            function button1()
            {
                document.Simple.buttonClick.value = "Кнопка_нажата"
                form1.submit()
            } 
            // --> 
        </SCRIPT>
        
    </body>
</html>
