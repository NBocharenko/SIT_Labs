<%-- 
    Document   : Statistics
    Created on : 30.05.2015, 10:10:46
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Статистика</title>
        <link rel="stylesheet" type="text/css" href="jsp/css/view.css" />
    </head>
 
    <body>
        <table width="100%" height="650" border="3">
            <tr height=50>
                <td class="head" colspan="6"><h2>Система управления ресурсами</h2></td>
            </tr>
            <tr>
                <td rowspan="6" valign="top" width="10%">
                    <table width="100%" align="center" rules="groups" border="1">
                        <colgroup>
                        <tr>
                            <td align="center">Материал</td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="GoToCreateMaterial"/>
                                    <input class="button" type="submit" value="Добавить"/>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="ReadMaterial"/>
                                    <input class="button" type="submit" value="Вывести" />
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="GoToUpdateMaterial"/>
                                    <input class="button" type="submit" value="Обновить" />
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="GoToDeleteMaterial"/>
                                    <input class="button" type="submit" value="Удалить" />
                                </form>
                            </td>
                        </tr>
                        </colgroup>
                        <colgroup>
                        <tr>
                            <td align="center">Поставщик</td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="GoToCreateSupplier"/>
                                    <input class="button" type="submit" value="Добавить"/>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="ReadSupplier"/>
                                    <input class="button" type="submit" value="Вывести" />
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="GoToUpdateSupplier"/>
                                    <input class="button" type="submit" value="Обновить" />
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="GoToDeleteSupplier"/>
                                    <input class="button" type="submit" value="Удалить" />
                                </form>
                            </td>
                        </tr>
                        </colgroup>
                        <colgroup>
                        <tr>
                            <td align="center">Заказ</td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="GoToCreateOrder"/>
                                    <input class="button" type="submit" value="Добавить"/>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="ReadOrder"/>
                                    <input class="button" type="submit" value="Вывести" />
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="GoToUpdateOrder"/>
                                    <input class="button" type="submit" value="Обновить" />
                                </form>
                            </td>
                        </tr>
                        <tr>
                             <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="GoToDeleteOrder"/>
                                    <input class="button" type="submit" value="Удалить" />
                                </form>
                            </td>
                        </tr>
                        </colgroup>
                    </table>
                </td>
                <td valign="top" height="100%">
                    <table width="100%" align="center">
                        <tr>
                            <td width="25%" align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="GoToMain"/>
                                    <input class="button1" type="submit" value="На главную" />
                                </form>
                            </td>
                            <td width="25%" align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="GoToFinance"/>
                                    <input class="button1" type="submit" value="Финансы" />
                                </form>
                            </td>
                            <td width="25%" align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="ReadStorage"/>
                                    <input class="button1" type="submit" value="Склад" />
                                </form>
                            </td>
                            <td width="25%" align="center">
                                <table width="100%">
                                    <tr>
                                        <td align="center"><fmt:formatDate pattern="dd.MM.yyyy" value="${date}"/></td>
                                    </tr>
                                    <form method="POST" action="Servlet">
                                        <input type="hidden" name="command" value="ChangeDate"/>
                                    <tr>
                                        <td align="center">
                                            <input type="date" name="newDate">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="center">
                                            <input class="button" type="submit" value="Изменить дату" />
                                        </td>
                                    </tr>
                                    </form>
                                </table>
                            </td>
                        </tr>  
                    </table>
                                    
                                    
                                    
                                    
                                    
                                    
                </td>
                <td width="10%" rowspan="6" valign="top">
                    <table>
                        <tr>
                            <td align="center">Расширенные</td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="GoToSearch"/>
                                    <input class="button" type="submit" value="Поиск" />
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td align="center">
                                <form method="POST" action="Servlet">
                                    <input type="hidden" name="dateForvarded" value="${date}"/>
                                    <input type="hidden" name="command" value="GoToSort"/>
                                    <input class="button" type="submit" value="Сортировка" />
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>    
        </table>
     </body>
 </html>
