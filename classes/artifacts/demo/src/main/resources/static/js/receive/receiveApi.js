layui.config({
    base: '/static/js/layuiadmin/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'table', 'form'], function () {
    var $ = layui.$,
        table = layui.table,
        form = layui.form,
        active = {
            add: saveOrUpdate,
            edit: saveOrUpdate,
            del: function (data) {
                console.log(data);
                layer.confirm("确定删除此条记录？", function (e) {
                    $.get("/manage/receive/api/delete/" + data.id, function (result) {
                        if (result.state) {
                            layer.msg('删除成功', {
                                icon: 1,
                                time: 500
                            }, function () {
                                table.reload('LAY-app-content-list');
                            })
                        } else {
                            layer.msg(result.msg, {
                                icon: 2,
                                time: 1000
                            })
                        }
                    });
                    layer.close(e);
                })
            }
        };

    table.render({
        elem: "#LAY-app-content-list",
        url: "/manage/receive/api/list",
        cols: [[
            {field: "description", title: "接口说明"},
            {field: "uri", title: "接口地址"},
            {field: "handler", title: "消息处理器"},
            {field: "kafkaServer", title: "kafka服务器"},
            {field: "topic", title: "topic"},
            {field: "groupid", title: "groupid"},
            {field: "start", title: "是否开启消费", templet: "#buttonTpl", align: "center"},
            {title: "操作", minWidth: 150, align: "center", fixed: "right", toolbar: "#table-content-list"}
        ]],
        page: !0,
        limit: 30,
        text: "对不起，加载出现异常！"
    });
    table.on("tool(LAY-app-content-list)", function (t) {
        active[t.event] ? active[t.event].call(this, t.data) : '';
    });

    form.on('switch(startStatus)', function (data) {
        $.get('/manage/receive/api/updateStart/' + data.value ,{start:this.checked},function (result) {
            if (result.state) {
                layer.msg('切换成功', {
                    icon: 1,
                    time: 500
                })
            } else {
                layer.msg(result.msg, {
                    icon: 2,
                    time: 1000
                }, function () {
                    table.reload('LAY-app-content-list');
                })
            }
        });
    });


    $('.layui-btn.layuiadmin-btn-list').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    /**
     * 添加或修改数据
     */
    function saveOrUpdate(data) {
        layer.open({
            type: 2
            , title: data ? "修改记录" : '添加记录'
            , content: '/manage/receive/api/showReceiveForm' + (data ? "?id=" + data.id : "")
            , maxmin: true
            , area: ['550px', '600px']
            , btn: ['确定', '取消']
            , yes: function (index, layero) {
                //点击确认触发 iframe 内容中的按钮提交
                var submit = layero.find('iframe').contents().find("#layuiadmin-app-form-submit");
                submit.click();
            }
        });
    }


});
