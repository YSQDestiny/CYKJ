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
                <h1>项目名称：${hydro.name}</h1>
                <small>创建时间：${hydro.makeTime}</small>
                <h5>项目概述：</h5>
                <ul>
                    <li>所属地区：${hydro.province}${hydro.city}${hydro.county}${hydro.addr}</li>
                    <li>投产年限：${hydro.year}</li>
                    <li>水电站形式：${hydro.form}</li>
                    <li>大坝类型：${hydro.type}</li>
                    <li>大坝材质：${hydro.material}</li>
                    <li>轴顶长度：${hydro.length}</li>
                    <li>最大坝高：${hydro.high}</li>
                    <li>正常水位：${hydro.normal}</li>
                    <li>设计水位：${hydro.design}</li>
                    <li>校核水位：${hydro.checkWater}</li>
                    <li>主要用途：${hydro.purpose}</li>
                    <li>机组样式：${hydro.crewStyle}</li>
                </ul>
                <h5>暴雨风险：</h5>
                <p>${hydroGeology.rainStorm}</p>
                <h5>洪水风险：</h5>
                <p>${hydroGeology.flood}</p>
                <h5>低温风险：</h5>
                <p>${hydroGeology.low}</p>
                <h5>雷击风险：</h5>
                <p>${hydroGeology.lightning}</p>
                <h5>地质风险：</h5>
                <p>${hydroGeology.geology}</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
