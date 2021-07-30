window.onload = function (){
    layui.use(['table','form','laydate'],function () {
        var $ = layui.$;
        var table = layui.table;
        let laydate = layui.laydate;

        table.render({
            elem: '#main-table',
            height: 560,
            url: '/eight/manage/orderMaster/queryOrderMasterPage',
            method: 'POST',
            page: true,
            id: 'table-load',
            toolbar: '#toolbarDemo',
            cols: [
                [
                    {title: '序号',templet: '#indexTpl',width: 60,align:'center'},
                    {field:'orderId',title:'订单ID',algin:'center',width:120,sort:true},
                    {field:'orderSn',title:'订单编号',algin:'center',width:95,sort:true},
                    {field:'userId',title:'下单人ID',algin:'center',width:100,sort:true},
                    {field:'shippingUser',title:'收货人姓名',algin:'center',width:100},
                    {field:'province',title:'省',algin:'center',width:120},
                    {field:'city',title:'市',algin:'center',width:95},
                    {field:'district',title:'区',algin:'center',width:100},
                    {field:'address',title:'地址',algin:'center',width:100},
                    {field:'paymentMethod',title:'支付方式',algin:'center',width:120},
                    {field:'orderMoney',title:'订单金额',algin:'center',width:95,sort:true},
                    {field:'districtMoney',title:'优惠金额',algin:'center',width:100,sort:true},
                    {field:'shippingMoney',title:'运费金额',algin:'center',width:100,sort:true},
                    {field:'paymentMoney',title:'支付金额',algin:'center',width:120,sort:true},
                    {field:'shoppingMailName',title:'商城名称',algin:'center',width:95},
                    {field:'orderStatus',title:'订单状态',algin:'center',width:95},
                    {field:'orderPoint',title:'订单积分',algin:'center',width:100,sort:true},
                    {field:'shippingTime',title:'发货时间',algin:'center',width:100,
                        templet: function (data) {return layui.util.toDateString(data.modifiedTime,'yyyy-MM-dd HH:mm:ss')}},
                    {field:'payTime',title:'支付时间',algin:'center',width:100,
                        templet: function (data) {return layui.util.toDateString(data.modifiedTime,'yyyy-MM-dd HH:mm:ss')}},
                    {field:'receiveTime',title:'收货时间',algin:'center',width:120,
                        templet: function (data) {return layui.util.toDateString(data.modifiedTime,'yyyy-MM-dd HH:mm:ss')}},
                    {field:'modifiedTime',title:'最后修改时间',algin:'center',width:200,
                        templet: function (data) {return layui.util.toDateString(data.modifiedTime,'yyyy-MM-dd HH:mm:ss')}},
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
                        title: '新增主订单信息',
                        content: '/eight/manage/orderMaster/orderMasterPage',
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
                                    url: '/eight/manage/orderMaster/addOrderMaster',
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
                        title: '编辑主订单信息',
                        content: '/eight/manage/orderMaster/queryOrderMasterById?orderMasterId=' + data.orderMasterId,
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
                                    url: '/eight/manage/orderMaster/modifyOrderMaster',
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
                            url: '/eight/manage/orderMaster/deleteOrderMaster?userId=' +data.userId,
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