
jQuery(function () {
    //获取点击事件的对象
    jQuery(".nav li").click(function () {
        //获取要显示或隐藏的对象
        var divShow = jQuery(".content").children('.list');
        //判断当前对象是否被选中，如果没选中的话进入if循环
        if (!jQuery(this).hasClass('selected')) {
            //获取当前对象的索引
            var index = jQuery(this).index();
            //当前对象添加选中样式并且其同胞移除选中样式；
            jQuery(this).addClass('selected').siblings('li').removeClass('selected');
            //索引对应的div块显示
            jQuery(divShow[index]).show();
            //索引对应的div块的同胞隐藏
            jQuery(divShow[index]).siblings('.list').hide();
        }

    });


   /* $.ajax({
        url:"localhost/8080/user/info",
        data:{
            "user_name":"kele"
        },
        datatype:"json",
        success:function (data) {
            console.log(data)
        }

    });*/
/*
    jQuery.getJSON("info1",{"user_name":"wcy"},function (data) {
        console.log(data)/!*想要打印哪个变量就data.哪个*!/
        $(".userId_inp_l").text(data.b)
        <p>aaa</p>
    })*/
});