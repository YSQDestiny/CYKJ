<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="include.jsp" %>
    <%@include file="common_css.jsp" %>
    <%@include file="common_js.jsp" %>
    <script src="${path}static/js/echarts.js"></script>
</head>
<body>
    <div class="mdui-container">
        <div class="mdui-textfield">
            <label class="mdui-textfield-label">城市</label>
            <input class="mdui-textfield-input" id="city" type="text"/>
        </div>
        <div class="mdui-textfield">
            <label class="mdui-textfield-label">区/县</label>
            <input class="mdui-textfield-input" id="county" type="text"/>
        </div>
        <div class="mdui-textfield">
            <label class="mdui-textfield-label">镇</label>
            <input class="mdui-textfield-input" id="town" type="text"/>
        </div>
        <button class="mdui-btn mdui-btn-raised mdui-ripple" id="search" onclick="doSearch()">查询</button>
    </div>
    <C:if test="${list != null}">
        <h5>地质灾害隐患点：</h5>
        <div class="mdui-tablep-fluid mdui-typo">
            <table class="mdui-table">
                <thead>
                <tr>
                    <th>隐患点名称</th>
                    <th>类型</th>
                    <th>威胁财产(万元)</th>
                    <th>威胁人数(人)</th>
                </tr>
                </thead>
                <tbody>
                    <C:forEach items="${list}" var="item">
                        <tr>
                            <td>${item.hiddenDanger}</td>
                            <td>${item.type}</td>
                            <td>${item.threatProperty}</td>
                            <td>${item.threatPeople}</td>
                        </tr>
                    </C:forEach>
                </tbody>
            </table>
        </div>
    </C:if>
</body>
<script type="text/javascript">
    function doSearch() {
        var city = document.getElementById("city").value;
        if (city.valueOf() === ""){
            alert('请输入城市');
        }
        var county = document.getElementById("county").value;
        if (county === ""){
            alert('请输入区/县');
        }
        var town = document.getElementById("town").value;
        if (town === ""){
            alert('请输入镇');
        }
        window.location.href="${path}doDisasterSearch?city="+city+"&county="+county+"&town="+town;
    }
</script>
</html>
