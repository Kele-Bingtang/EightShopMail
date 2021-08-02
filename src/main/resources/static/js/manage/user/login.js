window.onload = function (){
    layui.use("form",function () {
        var form = layui.form;
        var $ = layui.$;
        //监听提交
        form.on("submit(login)",function (data) {
            $.ajax({
                url:"/eight/manage/logging",
                type:"POST",
                data:data.field,
                dataType:"json",
                success: function (result) {
                    if(result.code === "1"){
                        layer.msg(result.msg,{icon:result.icon,anim:result.anim},function () {
                            console.log(result)
                            location.href = "/eight/manage/index?username=" + result.username;    //登录成功，转向后台主页
                        });
                    }else{
                        layer.msg(result.msg,{icon:result.icon,anim:result.anim});
                    }
                }
            });
            return false; //false代表表单不主动跳转，需要使用location.href主动跳转
        });
    });
}