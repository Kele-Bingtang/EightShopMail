window.onload = function (){
    layui.use(['table','form','laydate'],function () {
        var $ = layui.$;
        var table = layui.table;
        let laydate = layui.laydate;
        //支持日期控件
        laydate.render({
            elem: '#birthday',
            trigger: 'click'
        });

        var taskTable = table.render({
            elem: '#main-table',
            height: 560,
            url: '/eight/manage/userInfo/queryUserInfoPage',
            method: 'POST',
            page: true,
            id: 'table-load',
            toolbar: '#toolbarDemo',
            cols: [
                [
                    {title: '序号',templet: '#indexTpl',width: 60,align:'center'},
                    {field:'userInfoId',title:'用户信息id',algin:'center',width:120,sort:true},
                    {field:'userId',title:'用户id',algin:'center',width:95,sort:true},
                    {field:'userLevel',title:'积分id',algin:'center',width:100,sort:true},
                    {field:'username',title:'用户名',algin:'center',width:100},
                    {field:'realName',title:'真实姓名',algin:'center',width:100},
                    {field:'identityCardTypeStr',title:'证件类型',algin:'center',width:120},
                    {field:'identityCardNo',title:'证件号码',algin:'center',width:220},
                    {field:'userSex',title:'性别',algin:'center',width:70},
                    {field:'mobilePhone',title:'手机号码',algin:'center',width:120},
                    {field:'email',title:'邮箱',algin:'center',width:180},
                    {field:'birthday',title:'生日',algin:'center',width:160,
                        templet: function (data) {return layui.util.toDateString(data.birthday,'yyyy-MM-dd')}},
                    {field:'userMoney',title:'用户余额',algin:'center',width:100,sort:true},
                    {field:'levelPoint',title:'用户积分',algin:'center',width:100,sort:true},
                    {field:'registerTime',title:'注册时间',algin:'center',width:200,
                        templet: function (data) {return layui.util.toDateString(data.registerTime,'yyyy-MM-dd HH:mm:ss')}},
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
                        title: '新增用户信息',
                        content: '/eight/manage/userInfo/userInfoPage',
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
                                    url: '/eight/manage/userInfo/addUserInfo',
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
                        title: '编辑用户信息',
                        content: '/eight/manage/userInfo/queryUserInfoById?userInfoId=' + data.userInfoId,
                        shade:[0.8,'#393d49'],
                        area:['600px','600px'],
                        btn:['确定','取消'],
                        yes:function (index,layero) {
                            var iframeWindow = window['layui-layer-iframe'+index];
                            var submit = layero.find('iframe').contents().find("#lay-front-submit");
                            //监听提交
                            iframeWindow.layui.form.on('submit(lay-front-submit)',function (data) {
                                var field = data.field;
                                console.log(data)
                                $.ajax({
                                    url: '/eight/manage/userInfo/modifyUserInfo',
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
                            url: '/eight/manage/userInfo/deleteUserInfo?userInfoId=' +data.userInfoId,
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