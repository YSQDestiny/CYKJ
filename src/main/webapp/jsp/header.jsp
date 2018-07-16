<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="mdui-appbar mdui-appbar-fixed">
    <div class="mdui-toolbar mdui-color-theme">
            <span class="mdui-btn mdui-btn-icon mdui-ripple mdui-ripple-white"
                  mdui-drawer="{target:'#main-drawer',swipe:true}">
                <i class="mdui-icon material-icons">menu</i>
            </span>
        <a href="#" class="mdui-typo-headline mdui-hidden-xs">蝉远科技</a>
        <div class="mdui-toolbar-spacer"></div>
        <span class="mdui-btn mdui-btn-icon mdui-ripple-white" mdui-dialog="{target: '#dialog-docs-theme'}"
              mdui-tooltip="{content:'设置主题'}">
                <i class="mdui-icon material-icons">color_lens</i>
            </span>
    </div>
</header>
<div class="mdui-drawer mdui-drawer-left" id="main-drawer">
    <div class="mdui-list" mdui-collapse="{accordion: true}" style="margin-bottom: 76px;">

        <div class="mdui-collapse-item">
            <div class="mdui-collapse-item-header mdui-list-item mdui-ripple">
                <i class="mdui-list-item-icon mdui-icon material-icons">home</i>
                <div class="mdui-list-item-content">
                    <a href="${path}index.html">首页</a>
                </div>
            </div>
        </div>

        <div class="mdui-collapse-item">
            <div class="mdui-collapse-item-header mdui-list-item mdui-ripple">
                <i class="mdui-list-item-icon mdui-icon material-icons mdui-text-color-blue">near_me</i>
                <div class="mdui-list-item-content">企财险</div>
                <i class="mdui-collapse-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>
            </div>
            <div class="mdui-collapse-item-body mdui-list">
                <a href="${path}industry.html" class="mdui-list-item mdui-ripple ">行业</a>
                <a href="" class="mdui-list-item mdui-ripple ">区域</a>
                <a href="" class="mdui-list-item mdui-ripple ">查勘描述</a>
            </div>
        </div>
    </div>
</div>