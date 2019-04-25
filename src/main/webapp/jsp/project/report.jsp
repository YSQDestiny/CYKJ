<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include.jsp" %>
    <%@include file="../common_css.jsp" %>
    <%@include file="../common_js.jsp" %>
    <script src="${path}static/js/echarts.js"></script>
</head>
<style>

</style>
<body>
<div class="mdui-container">
    <div class="mdui-typo">
        <h1>项目名称：${project.name}</h1>
        <small>创建时间：${project.makeTime}</small>
        <ul>

            <li>项目所在地：${project.province}${project.city}${project.county}${project.town}</li>
            <li>详细地址：${project.addr}</li>
            <li>施工单位：${project.construction}</li>
            <li>建设单位：${project.building}</li>
            <li>工程类型：${project.type}</li>
            <li>查勘类型：${project.reviewType}</li>
            <li>项目评分：${project.score} <i class="mdui-icon material-icons" mdui-dialog="{target: '#exampleDialog'}">info</i></li>
            <li>风险等级：${project.level}</li>
        </ul>
        <div class=".mdui-col-xs-3 mdui-tablep-fluid mdui-typo">
            <h5>建设规模：</h5>
            <table class="mdui-table">
                <thead>
                <tr>
                    <th>项目</th>
                    <th>数量</th>
                </tr>
                </thead>
                <tbody>
                <C:forEach var="item" items="${scaleList}">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.value}</td>
                    </tr>
                </C:forEach>
                </tbody>
            </table>
        </div>
        <h5>委托方：</h5>
        <ul>
            <li>委托方：${project.client}</li>
            <li>委托方联系人：${project.clientContact}</li>
            <li>委托方联系电话：${project.clientPhone}</li>
        </ul>
        <h5>地质描述：</h5>
        <p>${project.geological}</p>
        <h5>地质灾害分析</h5>
        <ul>
            <li>地质风险等级：${project.lv}</li>
        </ul>
        <div class=".mdui-col-xs-3 mdui-tablep-fluid mdui-typo">
            <h5>地灾隐患点：</h5>
            <C:if test="${yhdList != null}" >
                <table class="mdui-table">
                    <thead>
                    <tr>
                        <th>隐患点名称</th>
                        <th>发生概率</th>
                    </tr>
                    </thead>
                    <tbody>
                    <C:forEach var="item" items="${yhdList}">
                        <tr>
                            <td>${item.name}</td>
                            <td>${item.value}</td>
                        </tr>
                    </C:forEach>
                    </tbody>
                </table>
            </C:if>
        </div>
    </div>

    <div class="mdui-dialog" id="exampleDialog">
        <div class="mdui-dialog-title">评分标准</div>
        <div class="mdui-dialog-content mdui-typo">
            工程施工安全总体风险大小计算公式为：R=A1+A2+A3+A4+A5+A6，其中，<br/>
            A1指桥梁建设规模所赋分值；<br/>
            A2指工程所处地质条件所赋分值；<br/>
            A3指工程所处气候环境条件所赋分值；<br/>
            A4指工程所处地形地貌所赋分值；<br/>
            A5指桥位特征所赋分值；<br/>
            A6指施工工艺成熟度所赋分值。<br/>
            评估指标体系中各指标所赋分值应结合工程实际情况，综合考虑各种因素的影响程度来确定分值，数值应取整数。评估指标也可以根据工程实际进行相应的增加或删减，同时风险分级标准也须进行相应调整。
        </div>
        <div class="mdui-dialog-actions">
            <button class="mdui-btn mdui-ripple" mdui-dialog-close>关闭</button>
        </div>
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
                    <th>风险点照片</th>
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
                    <td><img style="width: 100px;height: 100px" src="${item.sitePhoto}"/></td>
                    <td>${item.type}</td>
                    <td>${item.instructions}</td>
                    <td>${item.suggestion}</td>
                </tr>
            </C:forEach>
            </tbody>
        </table>
    </div>
    <div style="height: 100px"></div>
</div>
<script type="text/javascript">
    function report() {

    }
</script>
</body>
</html>
