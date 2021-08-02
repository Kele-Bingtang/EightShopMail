window.onload = function (){
    layui.use(['table','form','laydate'],function () {
        var $ = layui.$;
        var table = layui.table;

        var taskTable = table.render({
            elem: '#main-table',
            height: 560,
            url: '/eight/manage/userAddr/queryUserAddrPage',
            method: 'POST',
            page: true,
            id: 'table-load',
            toolbar: '#toolbarDemo',
            cols: [
                [
                    {title: '序号',templet: '#indexTpl',width: 60,align:'center'},
                    {field:'userAddrId',title:'地址ID',algin:'center',width:120,sort:true},
                    {field:'userId',title:'用户ID',algin:'center',width:95,sort:true},
                    {field:'username',title:'用户名',algin:'center',width:95,
                        templet: function (data){return data.user.username}},
                    {field:'zip',title:'邮编',algin:'center',width:100,sort:true},
                    {field:'province',title:'省份的ID',algin:'center',width:100},
                    {field:'city',title:'城市的ID',algin:'center',width:100},
                    {field:'district',title:'区ID',algin:'center',width:120},
                    {field:'address',title:'具体的地址门牌号',algin:'center',width:220},
                    {field:'modifiedTime',title:'最后修改时间',algin:'center',width:200,
                        templet: function (data) {return layui.util.toDateString(data.modifiedTime,'yyyy-MM-dd HH:mm:ss')}},
                    {title:'操作',align:'center',toolbar:'#barDemo',fixed:'right',width:130}
                ]
            ],
            done: function (res, currentPage)  {
                if (currentPage > 1 && res.data.length === 0) {
                    taskTable.reload({
                        page: {
                            curr: currentPage - 1
                        }
                    });
                }
            }
        });

        //监听头工具栏事件
        table.on('toolbar(main-table)',function (obj) {
            switch (obj.event) {
                case 'add':
                    layer.open({
                        type: 2,
                        title: '新增用户地址信息',
                        content: '/eight/manage/userAddr/userAddrPage',
                        shade:[0.8,'#393d49'],
                        area:['600px','600px'],
                        btn:['确定','取消'],
                        yes:function (index,layero) {  //index是新出窗口的索引，layero是窗口的window对象
                            var iframeWindow = window['layui-layer-iframe' + index]; //获取哪个窗口点击的yes
                            var submit = layero.find('iframe').contents().find("#lay-front-submit");
                            //监听提交
                            iframeWindow.layui.form.on('submit(lay-front-submit)',function (data) {
                                var field = data.field;
                                $.ajax({
                                    url: '/eight/manage/userAddr/addUserAddr',
                                    data: field,
                                    async: false,
                                    cache: false,
                                    success: function (str) {
                                        if(str.code === 0){
                                            table.reload('table-load');
                                        }
                                        layer.msg(str.msg,{icon:str.icon,anim:str.anim});
                                    }
                                });
                                layer.close(index);     //关闭弹层
                            });
                            submit.trigger('click');
                        },
                        success:function (layero,index) {

                        }
                    });
                    break;
                case 'querySearch':
                    var param = $('#param').val();
                    table.reload('table-load',{
                        where: {
                            param: param
                        }
                    });
                    $('#param').val(param);
                    break;
            }
        });

        //监听编辑、删除
        table.on('tool(main-table)',function (obj) {
            var data = obj.data;

            switch (obj.event) {
                case 'edit':
                    layer.open({
                        type: 2,
                        title: '编辑用户地址信息',
                        content: '/eight/manage/userAddr/queryUserAddrById?userAddrId=' + data.userAddrId,
                        shade:[0.8,'#393d49'],
                        area:['600px','600px'],
                        btn:['确定','取消'],
                        yes:function (index,layero) {
                            var iframeWindow = window['layui-layer-iframe'+index];
                            var submit = layero.find('iframe').contents().find("#lay-front-submit");
                            //监听提交
                            iframeWindow.layui.form.on('submit(lay-front-submit)',function (data) {
                                var field = data.field;
                                $.ajax({
                                    url: '/eight/manage/userAddr/modifyUserAddr',
                                    data: field,
                                    async: false,
                                    cache: false,
                                    success: function (str) {
                                        if(str.code === 0){
                                            table.reload('table-load');
                                        }
                                        layer.msg(str.msg,{icon:str.icon,anim:str.anim});
                                    }
                                });
                                layer.close(index);     //关闭弹层
                            });
                            submit.trigger('click');
                        },
                        success:function (layero,index) {

                        }
                    });
                    break;
                case 'del':
                    layer.confirm('确认要删除吗？',function (index) {
                        $.ajax({
                            url: '/eight/manage/userAddr/deleteUserAddr?userAddrId=' +data.userAddrId,
                            data: null,
                            async: false,
                            cache: false,
                            success: function (str) {
                                table.reload('table-load');
                                layer.msg(str.msg,{icon:str.icon,anim:str.anim});
                            }
                        });
                    })
                    break;
            }
        });
    });

}