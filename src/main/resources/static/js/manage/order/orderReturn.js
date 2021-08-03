window.onload = function (){
    layui.use(['table','form','laydate'],function () {
        var $ = layui.$;
        var table = layui.table;
        let laydate = layui.laydate;

        table.render({
            elem: '#main-table',
            height: 560,
            url: '/eight/manage/orderReturn/queryOrderReturnPage',
            method: 'POST',
            page: true,
            id: 'table-load',
            toolbar: '#toolbarDemo',
            cols: [
                [
                    {title: '序号',templet: '#indexTpl',width: 60,align:'center'},
                    {field:'returnId',title:'退货ID',algin:'center',width:120,sort:true},
                    {field:'orderId',title:'退货订单主表ID',algin:'center',width:95,sort:true},
                    {field:'orderDetailId',title:'退货订单ID',algin:'center',width:95,sort:true,
                        templet: function(data){return data.orderDetail.orderDetailId}},
                    {field:'returnType',title:'退货类型',algin:'center',width:100,sort:true},
                    {field:'returnReason',title:'退货原因',algin:'center',width:100,sort:true},
                    {field:'returnPrice',title:'退货价格',algin:'center',width:120,sort:true},
                    {field:'returnDesc',title:'退货描述',algin:'center',width:95},
                    {field:'returnState',title:'是否同意退货',algin:'center',width:95},
                    {field:'modifiedTime',title:'最后修改时间',algin:'center',width:200,
                        templet: function (data) {return layui.util.toDateString(data.modifiedTime,'yyyy-MM-dd HH:mm:ss')}},
                    {title:'操作',align:'center',toolbar:'#barDemo',fixed:'right',width:350}
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
                        title: '新增购物车信息',
                        content: '/eight/manage/orderReturn/orderReturnPage',
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
                                    url: '/eight/manage/orderReturn/addOrderReturn',
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
                        title: '编辑购物车信息',
                        content: '/eight/manage/orderReturn/queryOrderReturnById?returnId=' + data.returnId,
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
                                    url: '/eight/manage/orderReturn/modifyOrderReturn',
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
                            url: '/eight/manage/orderReturn/deleteOrderReturn?returnId=' +data.returnId,
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
                case 'agree':
                    layer.confirm('确认同意退货吗？',function (index) {
                        $.ajax({
                            url: '/eight/manage/orderReturn/modifyOrderReturn?returnId=' +data.returnId,
                            data: {
                                "returnState":"1",
                                "orderId":data.orderId,
                                "orderDetailId":data.orderDetail.orderDetailId,
                                "returnType":data.returnType,
                                "returnReason":data.returnReason,
                                "returnPrice":data.returnPrice,
                                "returnDesc":data.returnDesc
                            },
                            async: false,
                            cache: false,
                            success: function (str) {
                                table.reload('table-load');
                                layer.msg(str.msg,{icon:str.icon,anim:str.anim});
                            }
                        });
                    })
                    break;
                case 'disAgree':
                    layer.confirm('确认不同意退货吗？',function (index) {
                        $.ajax({
                            url: '/eight/manage/orderReturn/modifyOrderReturn?returnId=' +data.returnId,
                            data: {
                                "returnState":"2",
                                "orderId":data.orderId,
                                "orderDetailId":data.orderDetail.orderDetailId,
                                "returnType":data.returnType,
                                "returnReason":data.returnReason,
                                "returnPrice":data.returnPrice,
                                "returnDesc":data.returnDesc
                            },
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