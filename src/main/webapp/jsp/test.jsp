<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="common_css.jsp"%>
    <%@include file="common_js.jsp"%>
    <%@include file="include.jsp"%>
    <title>Title</title>
</head>
<body>

    <div class="mdui-drawer-body-left mdui-appbar-with-toolbar mdui-theme-primary-indigo mdui-theme-accent-pink mdui-loaded">

        <header class="mdui-appbar mdui-appbar-fixed">
            <div class="mdui-toolbar mdui-color-theme">
                <span class="mdui-btn mdui-btn-icon mdui-ripple mdui-ripple-white" mdui-drawer="{target: '#main-drawer',swipe: true}">
                    <i class="mdui-icon material-icons">menu</i>
                </span>
            </div>
        </header>

    </div>

</body>
</html>
