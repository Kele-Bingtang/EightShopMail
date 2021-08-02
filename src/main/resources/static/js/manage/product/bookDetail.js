window.onload = function (){
    layui.use(['table','form','laydate'],function () {
        var $ = layui.$;
        var table = layui.table;
        let laydate = layui.laydate;

        var categoryId = 2;
        table.render({
            elem: '#main-table',
            height: 560,
            url: '/eight/manage/bookDetail/queryBookDetailPage',
            method: 'POST',
            page: true,
            id: 'table-load',
            toolbar: '#toolbarDemo',
            cols: [
                [
                    {title: '序号',templet: '#indexTpl',width: 60,align:'center'},
                    {field:'bDetailId',title:'详细信息ID',algin:'center',width:120,sort:true},
                    {field:'productName',title:'商品名称',algin:'center',width:200,
                        templet: function (data){
                            return data.productInfo.productName;
                        }},
                    {field:'productCore',title:'商品编码',algin:'center',width:150,sort:true},
                    {field:'bAuthor',title:'作者',algin:'center',width:200},
                    {field:'bPublisher',title:'出版社',algin:'center',width:200},
                    {title:'操作',align:'center',toolbar:'#barDemo',fixed:'right',width:130}

                ]
            ],
            //某一页数据删完后跳回上一个页面
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
                        title: '新增书籍详细信息',
                        content: '/eight/manage/bookDetail/bookDetailPage?categoryId=' + categoryId,
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
                                    url: '/eight/manage/bookDetail/addBookDetail',
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
                        title: '编辑书籍详细信息',
                        content: '/eight/manage/bookDetail/queryBookDetailById?bDetailId=' + data.bDetailId + "&categoryId=" + categoryId,
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
                                    url: '/eight/manage/bookDetail/modifyBookDetail',
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
                            url: '/eight/manage/bookDetail/deleteBookDetail?bDetailId=' +data.bDetailId,
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