<%-- 
    Document   : Search
    Created on : 30.05.2015, 10:10:57
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Поиск</title>
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
         <p>Заполните поля формы, согласно которым будет произведен поиск:</p>
        <form method="POST" action="Servlet">
            <input type="hidden" name="command" value="SearchMaterial"/>
            <input type="hidden" name="dateForvarded" value="${date}"/>
            <table border="2">
                <tr>
                    <td>
                        Наименование материального ресурса:
                    </td>
                    <td>
                        <input type="text" name="title" size="50"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Спецификация материального ресурса:
                    </td>
                    <td>
                        <input type="text" name="specification" size="50"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Мера материального ресурса:
                    </td>
                    <td>
                        <input type="text" name="measure" size="50"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Диапазон масс единицы ресурса:
                    </td>
                    <td>
                        От <input type="number" name="minWeight" value="${minWeight}"/>
                        До <input type="number" name="maxWeight" value="${maxWeight}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Диапазон объема единицы ресурса:
                    </td>
                    <td>
                        От <input type="number" name="minVolume" value="${minVolume}"/>
                        До <input type="number" name="maxVolume" value="${maxVolume}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Стоимость хранения единицы ресурса:
                    </td>
                    <td>
                        От <input type="number" name="minUnitStorageCost" value="${minUnitStorageCost}"/>
                        До <input type="number" name="maxUnitStorageCost" value="${maxUnitStorageCost}"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <input class="button" type="submit" value="Поиск" />
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
            <input type="hidden" name="command" value="SearchSupplier"/>
            <p>Заполните поля формы, согласно которым будет произведен поиск:</p>
            <table border="2">
                <tr>
                    <td>
                        Наименование организации поставщика:
                    </td>
                    <td>
                        <input type="text" name="title" size="50"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Наименование поставляемого материала:
                    </td>
                    <td>
                        <input type="text" name="materialTitle" size="50"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Цена доставки одной партии:
                    </td>
                    <td>
                        От <input type="number" name="minDeliveryPrice" value="${minDeliveryPrice}"/>
                        До <input type="number" name="maxDeliveryPrice" value="${maxDeliveryPrice}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Введите цену одной единицы мат. ресурса:
                    </td>
                    <td>
                        От <input type="number" name="minResourceUnitPrice" value="${minResourceUnitPrice}"/>
                        До <input type="number" name="maxResourceUnitPrice" value="${maxResourceUnitPrice}"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <input class="button" type="submit" value="Поиск" />
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
            <input type="hidden" name="command" value="SearchOrder"/>
            <p>Заполните поля формы, согласно которым будет произведен поиск:</p>
            <table border="2">
                <tr>
                    <td>
                        Дата подписания:
                    </td>
                    <td>
                        От <input type="date" name="minSignDate" value="${minSignDate}"/>
                        До <input type="date" name="maxSignDate" value="${maxSignDate}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Дата выполнения:
                    </td>
                    <td>
                        От <input type="date" name="minExecDate" value="${minExecDate}"/>
                        До <input type="date" name="maxExecDate" value="${maxExecDate}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Объем заказа:
                    </td>
                    <td>
                        От <input type="number" name="minTotalVolume" value="${minTotalVolume}" />
                        До <input type="number" name="maxTotalVolume" value="${maxTotalVolume}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Стоимость заказа:
                    </td>
                    <td>
                        От <input type="number" name="minTotalCost" value="${minTotalCost}" />
                        До <input type="number" name="maxTotalCost" value="${maxTotalCost}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Готовность:
                    </td>
                    <td>
                        Не завершен<input type="checkbox" name="isFinished" value="1" />
                        Завершен<input type="checkbox" name="isFinished" value="2" />
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <input class="button" type="submit" value="Поиск" />
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
            <input type="hidden" name="command" value="SearchStorage"/>
            <p>Заполните поля формы, согласно которым будет произведен поиск:</p>
            <table border="2">
                <tr>
                    <td>Материал</td>
                    <td>
                        <input type="text" name="materialTitle" size="50"/>
                    </td>
                </tr>
                <tr>
                    <td>Спецификация</td>
                    <td>
                        <input type="text" name="materialSpecification" size="50"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Дата поступления:
                    </td>
                    <td>
                        От <input type="date" name="minReceiptDate" value="${minReceiptDate}"/>
                        До <input type="date" name="maxReceiptDate" value="${maxReceiptDate}"/>
                    </td>
                </tr>
                <tr>
                    <td>Количество единиц</td>
                    <td>
                        От <input type="number" name="minNumberOfMaterialUnits" value="${minNumberOfMaterialUnits}"/>
                        До <input type="number" name="maxNumberOfMaterialUnits" value="${maxNumberOfMaterialUnits}"/>
                    </td>    
                </tr>
                <tr>
                    <td>Объем</td>
                    <td>
                        От <input type="number" name="minTotalVolumeOfMaterial" value="${minTotalVolumeOfMaterial}"/>
                        До <input type="number" name="maxTotalVolumeOfMaterial" value="${maxTotalVolumeOfMaterial}"/>
                    </td>    
                </tr>
                <tr>
                    <td align="center">
                        <input class="button" type="submit" value="Поиск" />
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
