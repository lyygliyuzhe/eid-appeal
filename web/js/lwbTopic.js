//微博列表
$(function() {
    $('#dataGrid').datagrid({
        url: 'lwb_topic_list.do',
        fit: true,
        fitColumns: true,
        border: true,
        rownumbers: true,
        singleSelect: true,
        columns: [[{
                    field: 'id',
                    title: '编号',
                    width: 80
                }, {
                    field: 'name',
                    title: '话题',
                    width: 80
                },{
                    field: 'status',
                    title: '趋势分析',
                    width: 60,
                    formatter: function(value, row, index) {
                        if (value === null) {
                            return "<a href='#' onclick='trend()'>趋势分析</a>";
                        }
                    }
                }]],
        toolbar: '#toolbar'
    });



});

//增加链接
function addTopic() {
    var lwbTopic = $('#lwb_topic').val();
    $.ajax({
        type: "POST",
        url: "lwb_topic_add.do",
        dataType: 'json',
        data: {lwbTopic: lwbTopic},
        success: function(errorMsg) {
            if (errorMsg) {
                $.messager.show({
                    title: 'Error',
                    msg: errorMsg
                });
            } else {
                $('#dataGrid').datagrid('reload');    // reload the user data
            }
        }
    });

}

//删除链接
function destroyTopic() {
    var row = $('#dataGrid').datagrid('getSelected');
    if (row) {
        $.messager.confirm('提示', '确定删除此事件吗?', function(r) {
            if (r) {
                $.post('lwb_topic_delete.do', {id: row.id}, function(errorMsg) {
                    if (!errorMsg) {
                        $('#dataGrid').datagrid('reload');    // reload the user data
                    } else {
                        $.messager.show({// show error message
                            title: 'Error',
                            msg: errorMsg
                        });
                    }
                }, 'json');
            }
        });
    }
}

