$(function () {
    var normalInput = $(".normalInput");
    //鼠标悬停，点击记住等等状态
    var status = {
        activeStatus() {
            return (() => {
                for (let i = 0; i < normalInput.length; i++) {
                    normalInput.focusin(function () {
                        $(this).addClass("btn-focus");

                    })
                    normalInput.focusout(function () {
                        $(this).removeClass("btn-focus");
                    })
                }

            })()
        },
        rememberStatus() {
            return (() => {
                $(".checkBox").click(function () {
                    //取消选中
                    if ($(this).css("background-position") !== "0% 0%" && $(this).css("background-position") !== "0px 0px") {
                        $(this).css("background-position", "0 0");
                        $(this).children("#remember").attr("value",0);
                    } else {
                        //选中
                        $(this).css("background-position", "-39px -25px");
                        $(this).children("#remember").attr("value",1);
                    }

                })
            })()
        },
        //错误提示 div 抖动
        shake(ele){
            return (()=>{
                var $panel = $("."+ele);
                var box_left = 0;
                $panel.css({'left': box_left,"position":"relative"});
                for(var i=1; i<=4; i++){
                    $panel.animate({left:box_left-(40-10*i)},50);
                    $panel.animate({left:box_left+2*(40-10*i)},50);
                }
            })()
        },
        //登录成功，弹窗提示
        dialogTip(msg,icon){
            return (()=>{
                if($(".dialog").length == 0 && $(".dialog").length < 2){
                    let str = `<div class="dialog">
                                    <div class="dialog-content">
                                        <i class="tipIcon"></i>${msg}
                                    </div>
                                </div>`
                    $("body").append(str);
                    //雪碧图显示✔或×
                    if(icon == "2" || icon == 2){
                        $(".tip-Icon").css("background-position","0 -38px")
                    }else if(icon == "1"){
                        $(".tip-Icon").css("background-position","0 0")
                    }else {
                        $(".tip-Icon").css("background-position","0 0")
                    }
                    //动画效果  右侧旋转

                    $(".dialog").animate({
                        "transform": "rotate(0)",
                    }).css({
                        "top": "45%",
                        "left": "45%",
                        "transform": "rotate(0)",
                        "transition": "all .4s",
                        "margin-left": -parseInt($(".dialog").css("width"))/2 + 'px',
                        "margin-top": -parseInt($(".dialog").css("height"))/2 + 'px',
                    })
                    //两秒后自动清除弹窗
                    setTimeout(function (){
                        $(".dialog").remove()
                    },2000)
                }

            })()
        }
    }
    status.activeStatus();
    status.rememberStatus();

    //提示信息，包括注册时候用户名问题，二次密码相等，手机号码存在等等
    var tipInfo = {
        //手机号码是否合法
        phoneTip(inpValue, tipValue) {
            return (() => {
                if (!inpValue) {
                    inpValue = "";
                }
                // 邮箱没有注册
                if (inpValue.lastIndexOf("@") !== -1) {
                    if (!tipValue) {
                        tipValue = "邮箱格式不合法！";
                    }
                    // 邮箱验证：xxxxx@xxx.com
                    //1 获取邮箱里的内容
                    //2 创建正则表达式对象
                    var inpEmailPatt = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                    //3 使用test方法验证是否合法
                    if (!inpEmailPatt.test(inpValue) && inpValue !== "") {
                        //4 提示用户
                        $(".tip-box").css("display", "table").children(".tip-font").text(tipValue);
                        return false;
                    } else {
                        $(".tip-box").css("display", "none").children(".tip-font").text("");
                        return false;
                    }
                } else {
                    //手机号没有注册
                    if (!tipValue) {
                        tipValue = "手机格式不合法！";
                    }
                    var inpPhonePatt = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/
                    if (!inpPhonePatt.test(inpValue) && inpValue !== "") {
                        //4 提示用户
                        $(".tip-box").css("display", "table").children(".tip-font").text(tipValue);
                        return false;
                    } else {
                        $(".tip-box").css("display", "none").children(".tip-font").text("");
                        return true;
                    }
                }
            })()
        },
        //用户名时候合法
        regUsernameTip(inpValue) {
            return (() => {
                //登陆注册判断用户名和密码问题
                // 验证用户名：必须由字母，数字下划线组成，并且长度为3到18位
                //1 获取用户名输入框里的内容
                //2 创建正则表达式对象
                let UserPatt = /^\w{3,18}$/;
                //3 使用test方法验证
                if (inpValue.length === 0) {
                    $(".reg-username-tip").css("display", "none").children("p").text("");
                    return false;
                } else if (!UserPatt.test(inpValue) && inpValue !== "") {
                    $(".reg-username-tip").css({
                        "display": "block",
                        "color": "red"
                    }).children("p").text("用户名不合法！");
                    return false;
                } else {
                    $.getJSON("http://localhost:8080/eight/user/queryUsername", {"username": inpValue}, function (data) {
                        if (data === null) {
                            $(".reg-username-tip").css({
                                "display": "block",
                                "color": "green"
                            }).children("p").text("用户名不存在，可以注册");
                            return true;
                        } else {
                            console.log(data)
                            $(".reg-username-tip").css({
                                "display": "block",
                                "color": "red"
                            }).children("p").text("用户名存在，无法注册");
                            return false;
                        }
                    })
                    return true;
                }

            })()
        },
        //密码是否合法
        regPasswordTip(inpValue) {
            return (() => {
                // 验证密码：必须由字母，数字下划线组成，并且长度为5到18位
                //1 获取用户名输入框里的内容
                //2 创建正则表达式对象
                let passwordPatt = /^\w{5,18}$/;
                //3 使用test方法验证
                if (inpValue.length === 0) {
                    $(".reg-password-tip").css("display", "none").children("p").text("");
                    return false;
                } else if (!passwordPatt.test(inpValue) && inpValue !== "") {
                    //4 提示用户结果
                    $(".reg-password-tip").css("display", "block").children("p").text("密码不合法！");
                    return false;
                } else {
                    $(".reg-password-tip").css("display", "none").children("p").text("");
                    return true;
                }
            })()
        },
        //确认密码是否合法
        regRePasswordTip(inpOldValue, inpNewValue) {
            return (() => {
                // 验证确认密码：和密码相同
                if (inpNewValue.length === 0) {
                    $(".reg-re-password-tip").css("display", "none").children("p").text("");
                    return false;
                } else if (inpOldValue !== inpNewValue && inpNewValue !== "") {
                    $(".reg-re-password-tip").css("display", "block").children("p").text("确认密码和原密码不一致！");
                    return false;
                } else {
                    $(".reg-re-password-tip").css("display", "none").children("p").text("");
                    return true;
                }
            })()
        }
    }
    // 手机号码是否合法
    $(".reg-phone-normalInput").focusout(function () {
        tipInfo.phoneTip($(".inp-phone").val());
    });
    //用户名是否合法
    $("#reg-user").on("blur", function () {
        tipInfo.regUsernameTip($(this).val());
    })
    //密码是否合法
    $("#reg-password").on("blur", function () {
        tipInfo.regPasswordTip($(this).val());
    })
    //确认密码是否合法
    $("#re-password").on("blur", function () {
        if ($("#reg-password").val().length === 0 && $(this).val() !== "") {
            $(".reg-password-tip").css("display", "block").children("p").text("修改密码不能为空！");
        } else {
            tipInfo.regRePasswordTip($("#reg-password").val(), $(this).val());
        }
    })
    //可以关闭提示
    $(".close-ico").on("click", function () {
        $(".tip-box").css("display", "none").children(".tip-font").text("");
    })


    // 输入验证码时，验证码字体消失
    $(".code-input").on({
        input: function () {
            if ($(".code-input").val().length !== 0) {
                $(".input-Tip").text("")
            } else {
                $(".input-Tip").text("验证码")
            }
        },
        blur: function () {
            if ($(this).val().length === 0) {
                $(".code-info").css("display", "none").children("span").text("")
            }
        }
    })

    //工具对象
    var utils = {
        //通过key获得cookie的值
        getCookie(key) {
            return (() => {
                var cookies = document.cookie;//mima=123; uername=abc%E5%BC%A0%E4%B8%89123; uname=lilei
                if (cookies) {//存在解析 cookies获取 key对应的值
                    //2.分割字符串转数组 ;
                    var arr = cookies.split(';');
                    //3.遍历数组 分割数组的每一项的内容  split('=')
                    for (var i = 0; i < arr.length; i++) {
                        var newArr = arr[i].trim().split('=');
                        if (key === newArr[0]) {
                            return decodeURIComponent(newArr[1]);
                        }
                    }
                }
            })()
        }
    }
    // 登陆的操作，1.判断用户名密码是否正确，2.判断是否启用记住状态
    $(".login-btn").on("click", function () {
        $.ajax({
            url: "http://localhost:8080/eight/user/login",
            type: "POST",
            data: $("#main-form").serialize(),
            dataType: "json",
            success: function (result) {
                if (result.icon === 2) {
                    $(".tip-box").css("display", "table").children(".tip-font").text(utils.getCookie('loginInfo-Error'));
                    status.shake("tip-box");
                } else {
                    if($("#remember").val() != 0){
                        if(!localStorage.getItem("isLoginHead")){
                            localStorage.setItem("isLoginHead",data.userId);
                        }
                        if(!localStorage.getItem("rememberLogin")){
                            localStorage.setItem("rememberLogin","1");
                        }
                    }else if(localStorage.getItem("rememberLogin")){
                        localStorage.removeItem("rememberLogin");
                    }
                    const login = async ()=>{
                        return new Promise( (resolve,reject)=>{
                            status.dialogTip(result.msg,result.icon); //提示
                            setTimeout(resolve,2000) //两秒后执行后续操作
                        })
                    };
                    const closeAndJump = async ()=>{
                        await login();
                        if (window.opener) {
                            window.self.close();
                            window.opener.location.reload();
                        } else {//为空则跳转首页
                            window.location.href = "http://localhost:8080/eight/index";
                        }
                    }
                    closeAndJump().then((data)=>{
                        console.log("登录成功");
                    }).catch((err)=>{
                        console.log("登录失败");
                    });
                }
            }
        })
    })

    //刚开始进入界面，请求数据，获取信息
    if (utils.getCookie("loginUserHis")) {
        $(".login-user").val(utils.getCookie("loginUserHis"));
    }
    if (utils.getCookie("rememberLogin")) {
        $(".login-password").val(utils.getCookie("rememberLogin"));
    }
    if(localStorage.getItem("rememberLogin")){
        $(".checkBox").css("background-position", "-39px -25px").children("#remember").attr("value", "1");
    }

    //点击注册，检查内容
    $(".reg-btn").on("click", function () {
        let regUser = $(".reg-user");
        let regPassword = $(".reg-password");
        let regRePassword = $(".re-password");
        let codeInput = $(".code-input");
        if (tipInfo.regUsernameTip(regUser.val()) && tipInfo.regPasswordTip(regPassword.val())
            && tipInfo.regRePasswordTip(regRePassword.val(), regPassword.val()) && codeInput.val() === "xplm") {
            $.ajax({
                url: "http://localhost:8080/eight/user/register",
                type: "POST",
                data: $(".main-form").serialize(),
                dataType: "json",
                success: function (data) {
                    window.location.href = "http://localhost:8080/static/userLoginAndReg/loginUser.html"
                }
            })
        }
        if (regUser.val().length === 0) {
            $(".reg-username-tip").css("display", "block").children("p").text("用户名不能为空！");
            status.shake("reg-username-tip");
        }
        if (regPassword.val().length === 0) {
            $(".reg-password-tip").css("display", "block").children("p").text("密码不能为空！");
            status.shake("reg-password-tip");

        }
        if (regRePassword.val().length === 0) {
            $(".reg-re-password-tip").css("display", "block").children("p").text("确认密码不能为空！");
            status.shake("reg-re-password-tip");

        }
        if (codeInput.val() !== "xplm") {
            $(".code-info").css("display", "block").children("p").text("验证码错误！");
            status.shake("code-info");
        } else {
            $(".code-info").css("display", "none").children("p").text("");
        }
    })



})