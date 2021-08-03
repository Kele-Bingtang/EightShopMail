$(function(){
    JSON.stringify($(".m").val($("#title").text()));

    JSON.stringify($(".mi").val($(".desc").text()));

    $(".f").val($(".price").text());
    $(".n").val($(".amount").val());
    var amount = $(".amount");
    // 绑定焦点事件，改变焦点事件,value属性值发生改变时触发
    function getTotalPrice(num){
        var pri = $(".price").text();
        var total = pri * num;
        $(".total").text(total.toFixed(2));
        var price = $(".total-price").text(total.toFixed(2)).text();
        $(".f").val(price);
        JSON.stringify($(".f").val(price));
        $(".n").val(num);
        JSON.stringify($(".n").val(num));
    }

    $(".amount-increase").on("click",function (){
        var num = parseInt(amount.val()) + 1;
        amount.val(num)
        getTotalPrice(num);
    })
    $(".amount-decrease").on("click",function(){
        var num = parseInt(amount.val()) - 1;
        if(num <= 0){
            num = 1;
        }
        amount.val(num)

        getTotalPrice(num);
    });


    var utils = {
        getCookie(key) {
            return (() => {
                var cookies = document.cookie;//mima=123; uername=abc%E5%BC%A0%E4%B8%89123; uname=lilei
                if (cookies) {//存在解析 cookies获取 key对应的值
                    //2.分割字符串转数组 ;
                    var arr = cookies.split(';');
                    //3.遍历数组 分割数组的每一项的内容  split('=')
                    for (var i = 0; i < arr.length; i++) {
                        // console.log(arr[i].trim());
                        var newArr = arr[i].trim().split('=');
                        if (key === newArr[0]) {
                            return decodeURIComponent(newArr[1]);
                        }
                    }
                }
            })()
        },
        deleteCookie(cookie) {
            return (() => {
                var myDate = new Date();
                myDate.setTime(-1000);//设置立即消失的时间
                document.cookie = cookie + "=''; expires=" + myDate.toUTCString() + ";path=/";
            })()
        }
    }

    $(".user-id").val(utils.getCookie("isLoginHead"))


    $(".buybtn").on("click",function (){
        $.ajax({
            url:"http://localhost:8080/eight/alipay",
            type:"post",
            data: $("#pay-form").serialize(),
            success:function (data){
                $("#pay-form").submit();
            }
        })
    })

})