/**
 *   获取选框数据
 * @returns {Array}
 */
function getSelectionsIds() {
    var userList = $("#pushinfolist");
    var sels = userList.datagrid("getSelections");
    var ids = [];
    for (var i in sels) {
        ids.push(sels[i].id);
    }
    ids = ids.join(",");

    return ids;
}
/**
 *   id搜索
 * @param searchKey
 * @param searchValue
 * @returns {boolean}
 */
function searchFun(searchKey, searchValue) {
    if (isNaN(searchKey)) {
        $.messager.alert('提示', '只能根据id搜索');
        return false;
    }

    if (searchKey.length == 0) {

        var url = "/pushinfo/findpagepushinfo";
    }

    if (searchKey.length != 0) {
        var url = "/pushinfo/searchpagepushinfo?id=" + searchKey;
    }

    $("#pushinfolist").datagrid('options').url = url;
    $("#pushinfolist").datagrid('reload');
}
/**
 *   新增操作
 */
function addPushInfo() {

    $("#pid").val("");
    $("#pushinfoEditWindow").window("open");
    $("#titleresult").html("新增");
    $("#pushinfoEditFrom").form("reset");

    changeSourceAddr(2);

}
/**
 *   推送操作
 */
function impushinfo() {
    var ids = getSelectionsIds();
    if (ids.length == 0) {
        $.messager.alert('提示', '未选中!');
        return;
    }
    if (ids.indexOf(',') > 0) {
        $.messager.alert('提示', '不需要批量推送!');
        return;
    }

    //判断是否能够推送
       $.ajax({
        type: "GET",
        async: false,
        url: "/pushinfo/findpushstat/"+ids,
        success: function (data) {
            var json = JSON.parse(data);
            if (json.pushStat == 2) {//推送中
                $.messager.alert('提示', '当前推送处于推送中..不能重复推送');
                return;
            }else{
                //可以推送 推送请求
                $.messager.confirm('确认', '确定推送ID为 ' + ids + ' 吗？',
                    function (r) {
                        if (r) {
                            //提交到后台的RESTful
                            $.ajax({
                                type: "GET",
                                async: false,
                                url: "/httppush/pushdata/" + ids,
                                //data: {'id':data.id},
                                success: function (data) {

                                    var json = JSON.parse(data);
                                    if (json.code == 200) {
                                        $.messager.alert('提示', json.msg);
                                        $("#pushinfolist").datagrid("reload");
                                        /* $.messager.confirm('确认', '推送请求已发出,是否查看推送进度？',function(r){
                                         if(r){
                                         var tabs = $("#tabs");
                                         var tab = tabs.tabs("getTab","推送记录查询");
                                         if(tab){
                                         tabs.tabs("select","推送记录查询");
                                         }else{
                                         tabs.tabs('add',{
                                         title:'推送记录查询',
                                         href: '/pushrecord/page/pushrecord',
                                         closable:true,
                                         bodyCls:"content"
                                         });
                                         }
                                         $("#pushrecordlist").datagrid("reload");}

                                         });*/
                                    } else {

                                        $.messager.alert('提示', '推送请求失败:' + json.msg);

                                    }


                                }, error: function (data) {
                                    $.messager.alert('提示', '推送请求失败!');

                                }

                            });

                        }
                    });




            }

        }, error: function (data) {
            $.messager.alert('提示', '操作失败!');
        }

    });

}
/**
 *   查询全部
 */
function searchall() {
    var url = "/pushinfo/findpagepushinfo";
    $("#pushinfolist").datagrid('options').url = url;
    $("#pushinfolist").datagrid('reload');
}
/**
 *  停止推送
 */
function stopPush(){
    var ids = getSelectionsIds();
    if (ids.length == 0) {
        $.messager.alert('提示', '未选中!');
        return;
    }
    if (ids.indexOf(',') > 0) {
        $.messager.alert('提示', '不需要批量推送!');
        return;
    }


    //判断是否能够停止推送
    $.ajax({
        type: "GET",
        async: false,
        url: "/pushinfo/findpushstat/"+ids,
        success: function (data) {
            var json = JSON.parse(data);
            if (json.pushStat !=2) {//推送中
                $.messager.alert('提示', '已经停止推送');
                return;
            }else{
                //可以停止
                $.ajax({
                    type: "GET",
                    async: false,
                    url: "/httppush/stoppush/"+ids,
                    success: function (data) {
                        var json = JSON.parse(data);
                        if (json.code == 200) {
                            $.messager.alert('提示', '成功');
                            $("#pushinfolist").datagrid("reload");

                        } else {
                            $.messager.alert('提示', '失败:' + json.msg);
                        }

                    }, error: function (data) {
                        $.messager.alert('提示', '失败!');

                    }

                });
            }
        }, error: function (data) {
            $.messager.alert('提示', '操作失败!');
        }

    });

}
/**
 *   编辑操作
 */
function editPushInfo() {

    var ids = getSelectionsIds();
    if (ids.length == 0) {
        $.messager.alert('提示', '必须选择一个才能编辑!');
        return;
    }
    if (ids.indexOf(',') > 0) {
        $.messager.alert('提示', '只能选择一个!');
        return;
    }
    $("#pushinfoEditWindow").window({
        onLoad: function () {
            //回显数据
            var data = $("#pushinfolist").datagrid("getSelections")[0];
          //  data.pushCycle = TimeObjectUtil.longMsTimeConvertToDateTime(data.pushCycle);
            if(data.sourceType==3){//kafka来源的
                data.sourceKafkaInfo = data.sourceInfo;
                data.sourceInfo="";
            }

            $("#pushinfoEditWindow").form("load", data);
            $("#titleresult").html("修改");
            if(data.sourceType==3){//kafka来源的
                changeSourceAddr(3);
            }

        }

    }).window("open");

}
/**
 *  删除
 */
function deletePushInfo() {
    var ids = getSelectionsIds();
    // var data = $("#pushinfolist").datagrid("getSelections")[0];
    if (ids.length == 0) {
        $.messager.alert('提示', '未选中!');
        return;
    }
    if (ids.indexOf(',') > 0) {
        $.messager.alert('提示', '不需要批量删除!');
        return;
    }
    $.messager.confirm('确认', '确定删除ID为 ' + ids + ' 吗？',
        function (r) {
            if (r) {
                //提交到后台的RESTful
                $.ajax({
                    type: "DELETE",
                    url: "/pushinfo/deletepushinfo/" + ids,
                    //data: {'id':data.id},
                    success: function (data) {
                        var json = JSON.parse(data);
                        if (json.code == 200) {
                            $.messager.alert('提示', '成功');
                            $("#pushinfolist").datagrid("reload");

                        } else {
                            $.messager.alert('提示', '失败:' + json.msg);
                        }

                    }, error: function (data) {
                        $.messager.alert('提示', '失败!');

                    }

                });

            }
        });
}
/**
 * 毫秒转时间格式
 */
function convertTime(time) {

    if(time!=null){
        var myDate = new Date(time);
        var datetime = myDate.getFullYear()
            + "-"// "年"
            + ((myDate.getMonth() + 1) >= 10 ? (myDate.getMonth() + 1) : "0"
                + (myDate.getMonth() + 1))
            + "-"// "月"
            + (myDate.getDate() < 10 ? "0" + myDate.getDate() : myDate
                .getDate())
            + " "
            + (myDate.getHours() < 10 ? "0" + myDate.getHours() : myDate
                .getHours())
            + ":"
            + (myDate.getMinutes() < 10 ? "0" + myDate.getMinutes() : myDate
                .getMinutes())
            + ":"
            + (myDate.getSeconds() < 10 ? "0" + myDate.getSeconds() : myDate
                .getSeconds());
        return datetime;
    }else{
        return time;
    }

}

function doSearch(){

    $('#pushinfolist').datagrid('load',{
        "id": $('#search_id').val(),
        "pushName": $('#search_name').val(),
        "pushType": $('#search_pushtype').val(),
        "cycleType": $('#search_cycletype').val(),
        "pushStat": $('#search_stat').val()
    });
}
/*  $('#cycleInput').combobox({
      onSelect: function(record){
          alert(1111);
          var content = $("#cycleInput").combobox('getText');
          alert(content);
      }
  })
*/



