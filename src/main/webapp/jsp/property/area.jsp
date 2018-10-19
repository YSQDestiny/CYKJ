<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include.jsp" %>
    <title>物业区域</title>
    <%@include file="../common_css.jsp" %>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/material/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

    <link rel="stylesheet" href="${path}static/css/github-gist.css"/>
    <link rel="stylesheet" href="${path}static/css/railscasts.css"/>
    <link rel="stylesheet" href="${path}static/css/docs.css"/>
    <script type="text/javascript" async="" src="${path}static/js/analytics.js"></script>
    <script async="" src="${path}static/js/js.js"></script>
    <script>
        window.dataLayer = window.dataLayer || [];

        function gtag() {
            dataLayer.push(arguments);
        }

        gtag('js', new Date());

        gtag('config', 'UA-88818678-1');
    </script>
</head>
<body class="mdui-drawer-body-left mdui-appbar-with-toolbar mdui-loaded mdui-theme-primary-indigo mdui-theme-accent-pink">
<%@include file="../header.jsp" %>

<div class="mdui-container doc-container">
    <table id="dg" title="物业区域" class="easyui-datagrid" style="width:100%;height:500px"
           url="${path}property/getAllArea"
           toolbar="#toolbar" pagination="true"
           rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
        <tr>
            <th field="name" width="50">区域</th>
            <th field="singlePoint" width="50">单项分</th>
            <th field="important" width="50">重要区域</th>
            <th field="standard" width="50">评分标准</th>
        </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
           onclick="destroyUser()">删除</a>
    </div>
</div>

<div id="dlg" class="easyui-dialog" style="width:400px"
     data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
        <h3>添加选项</h3>
        <div style="margin-bottom:10px">
            <input name="name" class="easyui-textbox" required="true" label="区域:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="singlePoint" class="easyui-textbox" required="true" label="单项分:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="important" class="easyui-textbox" required="true" label="重要区域:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="standard" class="easyui-textbox" required="true" label="评分标准:" style="width:100%">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()"
       style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
       onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
</div>

<script type="text/javascript">
    var url;

    function newUser() {
        $('#dlg').dialog('open').dialog('center').dialog('setTitle', '添加行业');
        $('#fm').form('clear');
        url = '${path}property/saveArea';
    }

    function editUser() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $('#dlg').dialog('open').dialog('center').dialog('setTitle', '编辑区域');
            $('#fm').form('load', row);
            url = '${path}property/editArea?id=' + row.id;
        }
    }

    function saveUser() {
        $('#fm').form('submit', {
            url: url,
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (result) {
                var result = eval('(' + result + ')');
                if (result.status) {
                    $('#dlg').dialog('close');        // close the dialog
                    $('#dg').datagrid('reload');    // reload the user data
                } else {
                    $.messager.show({
                        title: 'Error',
                        msg: result.message
                    });
                }
            }
        });
    }

    function destroyUser() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $.messager.confirm('Confirm', 'Are you sure you want to destroy this user?', function (r) {
                if (r) {
                    $.post('${path}property/deleteArea', {id: row.id}, function (result) {
                        if (result.status) {
                            $('#dg').datagrid('reload');    // reload the user data
                        } else {
                            $.messager.show({    // show error message
                                title: 'Error',
                                msg: result.errorMsg
                            });
                        }
                    }, 'json');
                }
            });
        }
    }
</script>

<%@include file="../theme.jsp" %>
</body>
<%@include file="../common_js.jsp" %>
<script src="${path}static/js/smooth-scroll.min.js"></script>
<script src="${path}static/js/holder.min.js"></script>
<script src="${path}static/js/highlight.pack.js"></script>
<script>var $$ = mdui.JQ;</script>
<script src="${path}static/js/docs.js"></script>
</html>
