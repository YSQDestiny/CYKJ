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
    <div class="mdui-typo">
        <h1>项目名称：${project.name}</h1>
        <small>创建时间：${project.makeTime}</small>
        <ul>
            <li>所属地区：${project.area}</li>
            <li>工程项目部：${project.department}</li>
            <li>项目标的：${project.project_target}</li>
            <li>工程类型：${project.type}</li>
            <li>项目起点：${project.start}</li>
            <li>项目终点：${project.ending}</li>
            <li>项目全长（KM）：${project.length}</li>
            <li>项目评分：${project.score}</li>
        </ul>
        <h5>地质描述：</h5>
        <p>${project.geological}</p>
    </div>

    <!-- 气温降水 -->
    <C:forEach items="${weatherData}" varStatus="status" var="item">
        <div id="weather${status.count}" class=".mdui-col-lg-12 .mdui-col-xs-12" style="height: 400px;"></div>
        <script type="text/javascript">
            var myChart = echarts.init(document.getElementById('weather${status.count}'));

            var option = {
                title: {
                    text: '${item.name}历史气候信息',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        crossStyle: {
                            color: '#999'
                        }
                    }
                },
                legend: {
                    data: ['最高温度', '最低温度', '降水量'],
                    x: 'center',
                    y: 'bottom'
                },
                xAxis: [
                    {
                        type: 'category',
                        data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
                        axisPointer: {
                            type: 'shadow'
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '温度',
                        min: 0,
                        max: 35,
                        interval: 5,
                        axisLabel: {
                            formatter: '{value} °C'
                        }
                    },
                    {
                        type: 'value',
                        name: '水量',
                        min: 0,
                        max: 350,
                        interval: 50,
                        axisLabel: {
                            formatter: '{value} ml'
                        }
                    }

                ],
                series: [
                    {
                        name: '最高温度',
                        type: 'line',
                        data:${item.highWeather}
                    },
                    {
                        name: '最低温度',
                        type: 'line',
                        data:${item.lowWeather}
                    },
                    {
                        name: '降水量',
                        type: 'bar',
                        yAxisIndex: 1,
                        data:${item.rainfall}
                    }
                ]
            };
            myChart.setOption(option);
        </script>
    </C:forEach>

    <!-- 历史灾害 -->
    <C:forEach items="${disasterData}" varStatus="status" var="item">
        <div id="disaster${status.count}" class=".mdui-col-lg-12 .mdui-col-xs-12" style="height: 400px"></div>
        <script type="text/javascript">
            var myChart = echarts.init(document.getElementById('disaster${status.count}'));
            option = {
                title: {
                    text: '${item.name}历史灾害',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    x: 'center',
                    y: 'bottom',
                    data:${item.nameList}
                },
                calculable: true,
                series: [
                    {
                        name: '面积模式',
                        type: 'pie',
                        radius: [30, 130],
                        center: ['50%', '50%'],
                        roseType: 'area',
                        data:${item.barData}
                    }
                ]
            };
            myChart.setOption(option);
        </script>
    </C:forEach>

    <div class="mdui-tablep-fluid mdui-typo">
        <h5>现场风险：</h5>
        <table class="mdui-table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>名称</th>
                    <th>类型</th>
                    <th>说明</th>
                    <th>建议</th>
                </tr>
            </thead>
            <tbody>
            <C:forEach var="item" items="${projectAccidents}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.type}</td>
                    <td>${item.instructions}</td>
                    <td>${item.suggestion}</td>
                </tr>
            </C:forEach>
            </tbody>
        </table>
    </div>
    <div style="height: 100px">
        <button class="mdui-btn mdui-btn-raised mdui-ripple" onclick="location.href='${path}project/downloadDoc'">生成报告</button>
    </div>
</div>
<script type="text/javascript">
    function report() {

    }
</script>
</body>
</html>
