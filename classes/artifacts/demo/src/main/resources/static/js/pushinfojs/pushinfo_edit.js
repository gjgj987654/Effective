/**
 *   编辑表单提交
 */
function submitForm() {
    if (!$('#pushinfoEditFrom').form('validate')) {
        $.messager.alert('提示', '请填完整!');
        return;
    }
    var v = $('#pushinfoEditFrom').serializeObject();
    var jso = JSON.stringify(v);

    //提交到后台的RESTful
    $.ajax({
        type: "POST",
        url: "/pushinfo/addandupdatepushinfo",
        // data: $("#pushinfoEditFrom").serialize(),
        data: jso,
        contentType: 'application/json',
        success: function (result) {
            var obj = JSON.parse(result);
            if (obj.code == 200) {
                $.messager.alert('提示', '成功');
                $("#pushinfoEditWindow").window('close');
                $("#pushinfolist").datagrid("reload");//刷新
            } else {
                $.messager.alert('提示', '失败');
                $("#pushinfoEditWindow").window('close');

            }

        }

    });
}
//表单转json函数
$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();

    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

function cancelFrom() {
    $("#pushinfoEditWindow").window("close");
}

function closePushCycle() {
    $("#pushcycle").hide();
 //$("#pushcycle").css("display","none");
    $('#pushcycletime').timespinner('disableValidation');
    $('#pushcycletime').timespinner({
        required: false
    });
}
function openPushCycle() {
    $("#pushcycle").show();
  //  $("#pushcycle").css("display","block");
    $('#pushcycletime').timespinner({
        required: true
    });
}

function changeSourceAddr(valueType){


    if(valueType==3){
        $("#pushsourceaddr").hide();
        $('#pushsourceaddrid').textbox('disableValidation');
        $('#pushsourceaddrid').textbox({
            required: false
        });
        $("#kafkaSource").show();
        $('#sourceKafkaInfoid').textbox({
            required: true
        });

    }else{
        $("#kafkaSource").hide();
        $('#sourceKafkaInfoid').textbox('disableValidation');
        $('#sourceKafkaInfoid').textbox({
            required: false
        });

        $("#pushsourceaddr").show();
        $('#pushsourceaddrid').textbox({
            required: true
        });
    }

}

