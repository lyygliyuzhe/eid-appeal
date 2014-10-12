<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>传播综述</title>
        <link rel="stylesheet" type="text/css" href="../plugin/easyui/themes/sunny/easyui.css">
        <link rel="stylesheet" type="text/css" href="../plugin/easyui/themes/icon.css">
        <script type="text/javascript" src="../plugin/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="../plugin/easyui/jquery.easyui.min.js"></script>
        <script  type="text/javascript" src="../plugin/easyui/locale/easyui-lang-zh_CN.js"></script>
        <script type="text/javascript" src="../js/lwbTopic.js"></script>
        <style type="text/css">
            body{
                background-color: #ffffff;
                width:100%;
                height:100%;
                overflow-x:hidden;
            }
            div{
                width:100%;
            }
            .header{
                height:250px;
            }
            #topic_time{
                height: 300px;
            }
            #topic_areal{
                height: 200px;
            }
        </style>
    </head>
    <body>
        <div class="header">
            <table id="dataGrid"> </table>
        </div>
        <div id="toolbar" style="padding:5px;height:auto;" style="display: none;">
            <input id="lwb_topic" type="text" name="lwbTopic" placeholder="请输入要检测的话题" style="width:300px;"/>
            <a href="#" class="easyui-linkbutton" onclick="addTopic();">添加话题</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyTopic();">删除已选项</a>
        </div>
    </body>
</html>
