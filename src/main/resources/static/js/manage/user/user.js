window.onload = function (){
    layui.use(['table','form'],function () {
        var $ = layui.$;
        var table = layui.table;
        var taskTable = table.render({
            elem: '#main-table',
            height: 560,
            url: '/eight/manage/user/queryUserPage',
            method: 'POST',
            page: true,
            id: 'table-load',
            toolbar: '#toolbarDemo',
            cols: [
                [
                    {title: '序号',templet: '#indexTpl',width: 60,align:'center'},
                    {field:'userId',title:'用户id',algin:'center',width:150,sort:true},
                    {field:'username',title:'用户名',algin:'center',width:250},
                    {field:'userStatusStr',title:'用户状态',algin:'center',width:250,sort:true},
                    {field:'modifiedTime',title:'最后操作时间',algin:'center',width:250,
                        templet: function (data) {return layui.util.toDateString(data.registerTime,'yyyy-MM-dd HH:mm:ss')}},
                    {title:'操作',align:'center',toolbar:'#barDemo',fixed:'right'}
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
                        title: '新增用户',
                        content: '/eight/manage/user/userPage',
                        shade:[0.8,'#393d49'],
                        area:['600px','400px'],
                        btn:['确定','取消'],
                        yes:function (index,layero) {  //index是新出窗口的索引，layero是窗口的window对象
                            var iframeWindow = window['layui-layer-iframe' + index]; //获取哪个窗口点击的yes
                            var submit = layero.find('iframe').contents().find("#lay-front-submit");
                            //监听提交
                            iframeWindow.layui.form.on('submit(lay-front-submit)',function (data) {
                                var field = data.field;
                                $.ajax({
                                    url: '/eight/manage/user/addUser',
                                    data: field,
                                    async: false,
                                    cache: false,
                                    success: function (str) {
                                        console.log(str.code)
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
                        title: '编辑用户',
                        content: '/eight/manage/user/queryUserById?userId=' + data.userId,
                        shade:[0.8,'#393d49'],
                        area:['600px','400px'],
                        btn:['确定','取消'],
                        yes:function (index,layero) {
                            var iframeWindow = window['layui-layer-iframe'+index];
                            var submit = layero.find('iframe').contents().find("#lay-front-submit");
                            //监听提交
                            iframeWindow.layui.form.on('submit(lay-front-submit)',function (data) {
                                var field = data.field;
                                $.ajax({
                                    url: '/eight/manage/user/modifyPassword',
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
                            url: '/eight/manage/user/deleteUser?userId=' +data.userId,
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