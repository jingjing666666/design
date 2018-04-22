<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>树莓后台- 登录</title>
    <meta name="keywords" content="树莓后台">
    <meta name="description" content="树莓后台">
    <link rel="stylesheet" type="text/css"
          href="jquery-easyui-1.3.3/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript"
            src="jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script src="/js/common.js"></script>
    <script type="text/javascript">
        checkCookie();
        var url;

        function addTab(url, text, iconCls) {
            var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/views/"
                + url + "'></iframe>";
            $("#tabs").tabs("add", {
                title: text,
                iconCls: iconCls,
                closable: true,
                content: content
            });
        }

        function openTab(text, url, iconCls) {
            if ($("#tabs").tabs("exists", text)) {
                $("#tabs").tabs("close", text);
                addTab(url, text, iconCls);
                $("#tabs").tabs("select", text);
            } else {
                addTab(url, text, iconCls);
            }
        }

        function logout() {
            $.messager
                .confirm(
                    "系统提示",
                    "您确定要退出系统吗",
                    function (r) {
                        if (r) {
                            clearCookie();
                        }
                    });
        }
    </script>
<body class="easyui-layout">
<div region="north" style="height: 78px;background-color: #FFFFFF">
    <table width="100%">
        <h2 style="text-align:center;" >欢迎进入后台</h2>
        <tr>
            <td width="50%"></td>
            <td valign="bottom"
                style="font-size: 20px;color:#8B8B8B;font-family: '楷体';"
                align="right" width="50%"><font size="3">&nbsp;&nbsp;<strong>当前管理员：</strong>
                admin</font>【管理员】
            </td>
        </tr>
    </table>
</div>
<div region="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-home'">
            <div align="center" style="padding-top: 50px">
                <font color="grey" size="10"></font>
            </div>
        </div>
    </div>
</div>
<div region="west" style="width: 200px;height:500px;background-color: #FFFFFF" title="导航菜单" 
     split="true">
    <div class="easyui-accordion" style="background-color: #FFFFFF">
        <div title="文章管理"
             data-options="selected:true,iconCls:'icon-wenzhangs'"
             style="padding: 10px;height:10px;background-color: #FFFFFF">
            <a
                    href="javascript:openTab(' 文章管理','articleManage-ue.jsp','icon-wenzhang')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-wenzhang'"
                    style="width: 150px;">文章列表</a>
            
        </div>
        <div title="图片管理" data-options="iconCls:'icon-shouye'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 图片设置','pictureManage.jsp?type=1&grade=1','icon-tupians')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-tupian'"
                    style="width: 150px;"> 图片设置</a>
        </div>
        <div title="分类管理" data-options="iconCls:'icon-students'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 图片设置','pictureManage.jsp?type=1&grade=1','icon-tupians')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-student'"
                    style="width: 150px;"> 分类列表</a>
        </div>
        <div title="视频管理" data-options="iconCls:'icon-fenlei'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 图片设置','pictureManage.jsp?type=1&grade=1','icon-tupians')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-saoma'"
                    style="width: 150px;"> 视频列表</a>
        </div>
        <div title="系统管理" data-options="iconCls:'icon-item'"
             style="padding:10px;border:none;">
            <a href="javascript:openTab(' 管理员列表','userManage.jsp','icon-lxr')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-lxr'" style="width: 150px;">
                管理员列表</a><a href="javascript:logout()"
                            class="easyui-linkbutton"
                            data-options="plain:true,iconCls:'icon-exit'"
                            style="width: 150px;">
            安全退出</a>
        </div>
    </div>
</div>
</body>
</html>