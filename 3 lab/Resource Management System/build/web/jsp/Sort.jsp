<%-- 
    Document   : Selection
    Created on : 30.05.2015, 10:10:35
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Сортировка</title>
        <link rel="stylesheet" type="text/css" href="jsp/css/view.css" />
        <link rel="stylesheet" type="text/css" href="jsp/css/simpletabs.css" />
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
<div class="tabs">
  <ul>
    <li>
     <input type="radio" name="tabs-0" checked="checked" id="tabs-0-0" />
        <label for="tabs-0-0">Материал</label>
     <div>
         <p>Укажите поля для сортировки:</p>
        <form method="POST" action="Servlet">
            <input type="hidden" name="command" value="SortMaterial"/>
            <input type="hidden" name="dateForvarded" value="${date}"/>
            <table border="2">
                <tr>
                    <td>
                        Наименование:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="title"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Масса:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="weight"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Объем
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="volume"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Стоимость хранения
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="unitStorageCost"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <input class="button" type="submit" value="Сортировка" />
                    </td>  
                </tr>
            </table>    
        </form>
    </div>
   </li>
   <li>
     <input type="radio" name="tabs-0" id="tabs-0-1" />
       <label for="tabs-0-1">Поставщик</label>
     <div>
<form method="POST" action="Servlet">
            <input type="hidden" name="dateForvarded" value="${date}"/>
            <input type="hidden" name="command" value="SortSupplier"/>
            <p>Укажите поля для сортировки:</p>
            <table border="2">
                <tr>
                    <td>
                        Наименование организации:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="title"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Наименование поставляемого материала:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="titleMat"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Цена единицы материала:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="resourceUnitPrice"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Цена поставки:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="deliveryPrice"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <input class="button" type="submit" value="Сортировка" />
                    </td>  
                </tr>
            </table>
</form>
    </div>
    </li>
    <li>
      <input type="radio" name="tabs-0" id="tabs-0-2" />
        <label for="tabs-0-2">Заказ</label>
      <div>
<form method="POST" action="Servlet">
            <input type="hidden" name="dateForvarded" value="${date}"/>
            <input type="hidden" name="command" value="SortOrder"/>
            <p>Укажите поля для сортировки:</p>
            <table border="2">
                 <tr>
                    <td>
                        Наименование материала:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="titleMat"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Название фирмы - поставщика:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="titleSup"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Дата заключения договора:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="signDate"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Дата выполнения договора:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="execDate"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Объем заказа:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="totalVolume"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Стоимость заказа:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="totalCost"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Готовность:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="isCompleted"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <input class="button" type="submit" value="Сортировка" />
                    </td>  
                </tr>
            </table>    
        </form>
      </div>
   </li>
   <li>
     <input type="radio" name="tabs-0" id="tabs-0-3" />
        <label for="tabs-0-3">Склад</label>
     <div>
       <form method="POST" action="Servlet">
            <input type="hidden" name="dateForvarded" value="${date}"/>
            <input type="hidden" name="command" value="SortStorage"/>
            <p>Укажите поля для сортировки:</p>
            <table border="2">
                <tr>
                    <td>
                        Наименование материала:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="titleMat"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Дата поступления:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="receiptDate"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Число единиц ресурса:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="numberOfMaterialUnits"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Занимаемый объем:
                    </td>
                    <td>
                        <input type="checkbox" name="sort" value="totalVolumeOfMaterial"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <input class="button" type="submit" value="Сортировка" />
                    </td>  
                </tr>
            </table>
       </form>
     </div>
   </li>
  </ul>
</div>               
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
