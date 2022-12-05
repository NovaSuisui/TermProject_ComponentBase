<%-- 
    Document   : ShowTable
    Created on : Dec 5, 2022, 1:15:20 AM
    Author     : SK
--%>

<%@page import="java.util.List"%>
<%@page import="serviceclient.Cv19Ddc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Table</title>
    </head>
    <body>
        <table border="1" cellpadding="1" align="center">
            <thead>
                <tr>
                    <th>Year</th>
                    <th>Week</th>
                    <th>new_case</th>
                    <th>total_case</th>
                    <th>new_case_excludeabroad</th>
                    <th>total_case_excludeabroad</th>
                    <th>new_recovered</th>
                    <th>total_recovered</th>
                    <th>new_death</th>
                    <th>total_death</th>
                    <th>case_foreign</th>
                    <th>case_prison</th>
                    <th>case_walkin</th>
                    <th>case_new_prev</th>
                    <th>case_new_diff</th>
                    <th>death_new_prev</th>
                    <th>death_new_diff</th>
                    <th>update_date</th>
                </tr>
            </thead>
            <tbody>
                <%List<Cv19Ddc> cvList = (List<Cv19Ddc>)request.getAttribute("dataList");
                for(Cv19Ddc cv : cvList){%>
                <tr>
                    <td><%=cv.getCv19DdcPK().getYearnum()%></td>
                    <td><%=cv.getCv19DdcPK().getWeeknum()%></td>
                    <td><%=cv.getNewCase()%></td>
                    <td><%=cv.getTotalCase()%></td>
                    <td><%=cv.getNewCaseExcludeabroad()%></td>
                    <td><%=cv.getTotalCaseExcludeabroad()%></td>
                    <td><%=cv.getNewRecovered()%></td>
                    <td><%=cv.getTotalRecovered()%></td>
                    <td><%=cv.getNewDeath()%></td>
                    <td><%=cv.getTotalDeath()%></td>
                    <td><%=cv.getCaseForeign()%></td>
                    <td><%=cv.getCasePrison()%></td>
                    <td><%=cv.getCaseWalkin()%></td>
                    <td><%=cv.getCaseNewPrev()%></td>
                    <td><%=cv.getCaseNewDiff()%></td>
                    <td><%=cv.getDeathNewPrev()%></td>
                    <td><%=cv.getDeathNewDiff()%></td>
                    <td><%=cv.getUpdateDate()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <p align="center">
            <a href="index.html">Back to Homepage</a>   
        </p>
    </body>
</html>
