<%-- 
    Document   : newjsp
    Created on : 2014-10-11, 20:37:50
    Author     : lyz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
	<title>Administrator_module</title>
	<link rel="stylesheet" type="text/css" href="../plugin/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../plugin/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../plugin/easyui/demo/demo.css">
	<script type="text/javascript" src="../plugin/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../plugin/easyui/jquery.easyui.min.js"></script>
</head>
<body>
	</div>
	<div style="margin:10px 0;"></div>
	<div class="easyui-layout" style="width:100%;height:900px;">
            <div data-options="region:'north'" style="height:100px">
                <a style="font-size:44px;padding:30px 20px 10px 30px">LOGO</a>
                <a style="font-size:44px;padding:30px 20px 10px 10px">下午好!</a>
                <a style="font-size:44px;padding:30px 20px 10px 10px">李林丽</a>
                <a href="" style="font-size:44px;padding:30px 20px 10px 10px">EXIT</a>
            </div>
            <div data-options="region:'south', border:false" style="height:50px;">
            </div>
		<div data-options="region:'east'" title="East" style="width:200px;"></div>
		<div data-options="region:'west'" title="West" style="width:200px;"></div>
		<div data-options="region:'center'" title="Center">
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'north'" style="height:200px">
                                    <h2 style="font-size:30px;padding: 5px 5px;">查询条件</h2>
                                    <form id="check_form" method="post">
                                        <table cellpadding="5" cellspacing="5">
                                        <tr>
                                            <td>
                                                <a style="font-size:20px;padding: 15px 0px 15px 15px">提交时间：</a>
                                            </td>
                                            <td>
                                                <input class="easyui-datebox" name="data_begin" />
                                            </td>
                                            <td>
                                                <a style="font-size:20px;padding: 15px 5px">——</a>
                                            </td>
                                            <td>
                                                <input class="easyui-datebox" name="data_end" />
                                            </td>
                                            <td>
                                                <a style="font-size:20px;padding: 15px 5px">姓名：</a>
                                            </td>
                                            <td>
                                                <input class="easyui-textbox" name="name" style="width:100px;height:20px" />
                                            </td>
                                            <td>
                                                <a style="font-size:20px;padding: 15px 5px">身份证号：</a>
                                            </td>
                                            <td>
                                                <input class="easyui-textbox" name="persnal_id" style="width:150px;height:20px" maxlength="18" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a style="font-size:20px;padding: 30px 0px 15px 15px">申诉编号：</a>
                                            </td>
                                            <td>
                                                <input class="easyui-textbox" name="name" style="width:100px;height:20px" />
                                            </td>
                                            <td>
                                                <a style="font-size:20px;padding: 15px 5px">状态：</a>
                                            </td>
                                            <td>
                                                <select class="easyui-combobox" name="status" style="width:100px;height:20px" size="4">
                                                    <option value="all">全部</option>
                                                    <option value="un_handle">未处理</option>
                                                    <option value="passed">已通过</option>
                                                    <option value="unpassed">未通过</option>
                                                </select>
                                            </td>
                                        </tr>
                                        </table>
                                    </form>
                                </div>
				<div data-options="region:'center'"></div>
			</div>
		</div>
	</div>

</body>
</html>
