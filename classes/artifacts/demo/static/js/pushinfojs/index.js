/**
 *   首页 菜单栏折叠与tab显示功能
 */

$(function(){
        $('#menu').tree({
            onClick: function(node){
                if($('#menu').tree("isLeaf",node.target)){
                    var tabs = $("#tabs");
                    var tab = tabs.tabs("getTab",node.text);
                    if(tab){
                        tabs.tabs("select",node.text);
                    }else{
                        tabs.tabs('add',{
                            title:node.text,
                            href: node.attributes.url,
                            closable:true,
                            bodyCls:"content"
                        });
                    }
                }
            }
        });
});

/**
 *   定时刷新
 */
function statusRefresh()
{
    $("#pushinfolist").datagrid('load');
}
setInterval('statusRefresh()',300000); //每5分钟刷新一次表格