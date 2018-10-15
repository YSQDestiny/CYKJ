<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include.jsp" %>
    <%@include file="../common_css.jsp" %>
    <%@include file="../common_js.jsp" %>
    <script src="${path}static/js/echarts.js"></script>
</head>
<body>
<div class="mdui-container">
    <div class="mdui-row">
        <div class="mdui-col-xs-12">
            <div class="mdui-typo">
                <h1>项目名称：${property.name}</h1>
                <small>创建时间：${property.makeTime}</small>
                <h5>项目概述：</h5>
                <p>${str}</p>
                <h5>设施配套：</h5>
                <p>${equi}</p>
                <p>${companyInfo}</p>
                <p>${table}</p>
            </div>
        </div>
    </div>
    <div class="mdui-row">
        <div class="mdui-col-xs-2"></div>
        <div class="mdui-col-xs-8">
            <button style="width: 100%" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-indigo" onclick="location.href='${path}property/download?id=${property.id}'">生成报告</button>
        </div>
        <div class="mdui-col-xs-2"></div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">

</script>