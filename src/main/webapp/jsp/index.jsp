<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="include.jsp"%>
    <title>首页</title>
    <%@include file="common_css.jsp"%>
    <link rel="stylesheet" href="${path}static/css/github-gist.css"/>
    <link rel="stylesheet" href="${path}static/css/railscasts.css"/>
    <link rel="stylesheet" href="${path}static/css/docs.css"/>
    <script type="text/javascript" async="" src="${path}static/js/analytics.js"></script>
    <script async="" src="${path}static/js/js.js"></script>
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());

        gtag('config', 'UA-88818678-1');
    </script>
</head>
<body class="mdui-drawer-body-left mdui-appbar-with-toolbar mdui-loaded mdui-theme-primary-indigo mdui-theme-accent-pink">
<%@include file="header.jsp"%>

<%@include file="theme.jsp"%>
</body>
<%@include file="common_js.jsp"%>
<script src="${path}static/js/smooth-scroll.min.js"></script>
<script src="${path}static/js/holder.min.js"></script>
<script src="${path}static/js/highlight.pack.js"></script>
<script>var $$ = mdui.JQ;</script>
<script src="${path}static/js/docs.js"></script>
</html>
