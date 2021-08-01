
$(function () {
    console.log("关于来到八八商城首页！")
    // 鼠标移入移出导航栏效果
    var navItemA = $(".nav-item");
    //登录图片和购物车移入变颜色
    var logintx = $(".header-user-head");
    var cart = $(".header-user-cart");
    var bookMoreLabel = $(".book-more li:not('.hot-active')");
    var hourseMoreLabel = $(".hourse-more li:not('.hot-active')");
    var audioMoreLabel = $(".audio-more li:not('.hot-active')");
    var partsMoreLabel = $(".parts-more li:not('.hot-active')");
    // 主内容的模块前的图片
    $(".phone-left img").attr("src","/static/images/index/phoneDIv.jpg")
    var hourseImg = ["/static/images/index/hourse1.png", "/static/images/index/hourse2.png"];
    var bookImg = ["/static/images/index/book1.webp", "/static/images/index/book2.webp"];
    var audioImg = ["/static/images/index/audio1.webp", "/static/images/index/audio2.webp"];
    var partsImg = ["/static/images/index/parts1.webp", "/static/images/index/parts2.jpg"];
    // 导航栏显示的商品code
    var navData = {
        //导航栏手机数据
        phoneData:{
            "boxName": "phone",
            "code": "hw004&mi007&pg001&mi005&pg005&hw005&pg004&mi010",
        },
        //导航栏家电数据
        hourseData:{
        "boxName": "hourse",
        "code": "hs020&hs007&hs001&hs022&hs005&hs015&hs004&hs010",
       },
        //导航书籍机数据
        bookData:{
            "boxName": "book",
            "code": "book020&book007&book001&book065&book055&book037&book004&book021",
        },
        //导航栏音响数据
        audioData:{
            "boxName": "audio",
            "code": "audio001&audio003&audio005&audio007&audio009&audio011&audio013&audio014",
        },
        //导航栏配件数据
        partsData:{
            "boxName": "parts",
            "code": "parts001&parts003&parts005&parts006&parts007&parts009&parts010&parts011",
        },
    }
    // 主界面显示的商品code
    var mainData = {
        //主界面手机数据
        phoneData:{
            "boxName": "phone",
                "code": "mi007&mi002&mi004&hw010&hw008&hw001&pg001&pg009"
        },
        //主界面家电数据
        hourseData:{
            "boxName": "hourse",
            "code": "hs009&hs026&hs013&hs023&hs020&hs032&hs034&hs040"
        },
        //主界面书籍数据
        bookData:{
            "boxName": "book",
            "code": "book003&book014&book056&book023&book020&book032&book034&book070"
        },
        //主界面音响数据
        audioData:{
            "boxName": "audio",
            "code": "audio001&audio002&audio003&audio007&audio009&audio010&audio011&audio012"
        },
        //主界面配件数据
        partsData:{
            "boxName": "parts",
            "code": "parts001&parts002&parts003&parts007&parts009&parts010&parts011&parts012"
        }
    }
    //热门之外悬停出现的的商品顺序
    var moreData = {
       //书籍分类请求
        bookCartgoryIds: [7, 8, 9, 10], //书籍分类
        //获得数据的顺序，前面的数字代表除热门以外的标签数量，数组是悬停时显示的商品内容顺序，都是从0开始算
        bookdataIndexs: { //获取的书籍，只选择八个存放
           0: [5, 8, 10, 12, 14, 16, 18, 20],
       },
        //家具分类请求
         hourseCartgoryIds: [11, 12],//家具分类
        //悬停显示的商品id
        //获得数据的顺序，前面的数字代表除热门以外的标签数量，数组是悬停时显示的商品内容顺序，都是从0开始算
        hoursedataIndexs: {
            0: [5, 8, 10, 12, 14, 16, 18, 19],
        },
        //音响分类请求
         audioCartgoryIds : [14, 15],//音响分类
        //获得数据的顺序，前面的数字代表除热门以外的标签数量，数组是悬停时显示的商品内容顺序，都是从0开始算
         audiodataIndexs : {
            0: [0, 1, 2, 3, 4, 5, 6, 7],
            1: [0, 1, 2, 3, 4, 5, 6, 7],
        },
        //配件分类请求
        partsCartgoryIds : [17, 18],//配件分类
        //获得数据的顺序，前面的数字代表除热门以外的标签数量，数组是悬停时显示的商品内容顺序，都是从0开始算
        partsdataIndexs : {
            0: [0, 1, 2, 3, 4, 5, 6, 7],
            1: [0, 1, 2, 3, 4, 5, 6, 7],
        }

    }
    //导航栏
    var nav = {
        //导航栏的颜色，鼠标移入移出改变
        navHeadToggle(ele) {
            return (() => {
                $(ele).parents(".nav").off("mouseover");
                $(ele).on("mouseover", $(ele).children("a"), function () {
                    $(logintx).children("span").css("color", "#999");
                    $(cart).children("span").css("color", "#999");
                    $(ele).children("a").css("color", "#000");
                    $(ele).parents(".nav").mouseover(function () {
                        $(this).off("mouseout");
                        $(this).css({
                            "background-color": "#fff",
                            "transition": "background-color .3s",
                        });
                        $(ele).children("a").css("color", "#000");
                    })
                })
                $(ele).on("mouseout", $(ele).children("a"), function () {
                    $(ele).children("a").css("color", "#fff");
                    $(logintx).children("span").css("color", "#fff");
                    $(cart).children("span").css("color", "#fff");
                    $(ele).parents(".nav").mouseout(function () {
                        $(this).off("mouseover");
                        $(this).css({
                            "background-color": "transparent",
                            "transition": "background-color .6s",
                        });
                        $(ele).children("a").css("color", "#fff");
                    })
                })
            })()
        },
        //鼠标悬停在导航栏的文字时，弹出相应的菜单
        navToggle() {
            return (() => {
                for (let index = 0; index < navItemA.length; index++) {
                    (function (index) {
                        $(navItemA[index]).mouseover(function () {
                            $(this).find(".nav-header-sub").css({
                                "height": "183px",
                                "transition": "height .3s",
                            });
                            $(navItemA[index]).children("a").css("color", "#008cff");

                        })
                        $(navItemA[index]).mouseout(function () {
                            $(this).find(".nav-header-sub").css({
                                "height": "0",
                            });
                            $(navItemA[index]).children("a").css("color", "#000");
                        })
                    })(index)
                }
            })()
        },
        //将商品动态显示在导航栏
        navHeadSub(ele, data) {
            return (() => {
                let select = "." + ele;
                const navHead = $("<div class=\"nav-header-sub-wrap\">" +
                    "<div class=\"nav-header-sub\">" +
                    "<div class=\"nav-header-wrap\">" +
                    "<ul></ul></div></div></div>");
                $(select).after(navHead);
                var str = "";
                for (let i = 0; i < 8; i++) {
                    str += `<li>
                                <a href="http://localhost:8080/eight/viewProduct?productId=${data[i].productId}" target="_blank"> 
                                    <img src="${data[i].productPicInfo.picUrl}" alt="">
                                    <p>${data[i].productName}</p>
                                    <p>￥<span>${data[i].price}</span></p>
                                 </a>
                             </li>`;
                }
                $(select).parent().find(".nav-header-wrap").children("ul").append(str);
            })()
        }
    }

    //主内容
    var main = {
        //秒杀倒计时
        seckillTime(){
            return (()=>{
                let hourse;//时
                let minute;//分
                let second;//秒
                //是否是偶数小时
                function isOddTime(time){
                    if(time.getHours() % 2 === 0){
                        return time;
                    }else {
                        let towTime = time.getTime() - 360000;
                        return new Date(towTime);
                    }
                }
                //获取两个小时后的整时
                function getTwoTime(time){
                    let twoDate = new Date(time.getTime() - time.getMinutes() * 60000 - time.getSeconds() * 1000);
                    let towTime = twoDate.getTime() + (60 * 60 * 2 * 1000);
                    return new Date(towTime);
                }
                //重置倒计时
                function spwierTime(){
                    let nowTime = new Date();
                    let twoTime = getTwoTime(nowTime);
                    $(".round").text(isOddTime(nowTime).getHours() + ":00 场")
                    //倒计时，时间都需要减1，才正确
                    hourse = (isOddTime(twoTime).getHours()>nowTime.getHours()?isOddTime(twoTime).getHours():24 + isOddTime(twoTime).getHours()) - nowTime.getHours() - 1;
                    minute = ((twoTime.getTime() - nowTime.getTime())  / 1000 / 60 % 60).toFixed(0) - 1;
                    second = ((twoTime.getTime() - nowTime.getTime())  / 1000 % 60).toFixed(0) - 1;
                }
                //开始倒计时
                spwierTime();
                var timer = setInterval(function (){
                    function checkTime(t){
                        if(t < 10){
                            t = "0" + t;
                        }
                        return t;
                    }
                    second--;
                    if(second < 0){
                        minute--;
                        second = 59;
                    }
                    if (minute < 0){
                        hourse--;
                        minute = 59;
                    }
                    if(hourse < 0){
                        spwierTime();
                    }
                    $(".hourse").text(checkTime(hourse));
                    $(".minute").text(checkTime(minute));
                    $(".second").text(checkTime(second));
                },1000)
            })()
        },
        //秒杀商品
        seckill(data) {
            return (() => {
                $(".plain-right").append($("<ul></ul>"));
                var str = "";
                for (let i = 0; i < data.length; i++) {
                str += `<li data-value="${data[i].productId}">
                                <a href="http://localhost:8080/eight/viewProduct?productId=${data[i].productId}" target="_blank">
                                     <img src="${data[i].productPicInfo.picUrl}" alt="" class="img">
                                     <p class="name">${data[i].productName}</p>
                                    <p class="desc">${data[i].descript}</p>
                                    <span class="price">${data[i].price}元</span>
                                    <del class="del">${data[i].realPrice}元</del>
                                </a>
                            </li>`
                }
                $(".plain-right").children("ul").append(str);
            })()
        },
        //模块前面的两个图片
        boxInfoPic(ele, img) {
            return (() => {
                let select = "." + ele;
                var homeLeft = ` <div>
                            <a href="#">
                                <img src="${img[0]}" alt="">
                            </a>
                        </div>
                        <div>
                            <a href="#">
                                <img src="${img[1]}" alt="">
                            </a>
                        </div>`;
                $(select).append(homeLeft);
            })()
        },
        //模块图片添加
        boxInfo(ele, data, num) {
            return (() => {
                let select = "." + ele;
                $(select).append($("<ul></ul>"));
                var str = "";
                for (let i = 0; i < data.length - num; i++) {
                    str += ` <li class="${ele}${i + 1}">
                            <a href="http://localhost:8080/eight/viewProduct?productId=${data[i].productId}" target="_blank">
                                <img src="${data[i].productPicInfo.picUrl}" alt="" class="img">
                                <p class="name">${data[i].productName}</p>
                                <p class="desc">${data[i].descript}</p>
                                <span class="price">${data[i].price}元</span>
                            </a>
                        </li>`
                }
                if (num === 1) {
                    for (let i = 0; i < num; i++) {
                        str += `<li class="last-item ${ele}${data.length}">
                                <div>
                                    <a href="http://localhost:8080/eight/viewProduct?productId=${data[i].productId}">
                                        <img src="${data[data.length - num].productPicInfo.picUrl}" alt="">
                                        <p class="name">${data[data.length - num].productName}</p>
                                        <p class="price">${data[data.length - num].price}元</p>
                                    </a>
                                </div>
                                <div>
                                    <div class="more1">
                                        <a href="#">
                                            <span class="iconfont">&#xe619;</span>
                                            <p>预览更多</p>
                                            <small>热门</small>
                                        </a>
                                    </div>
                                </div>`
                    }
                }
                $(select).children("ul").append(str);
            })()
        },

        //热门 more选项
        moreActive(ele) {
            return (() => {
                let select = "." + ele;
                var moreLi = $(select).find("li");
                $(select).find(".hot-active").css({
                    "color": "#008cff",
                    "border-bottom": "2px solid #008cff",
                })
                for (let i = 0; i < moreLi.length; i++) {
                    (function (i) {
                        $(moreLi[i]).mouseover(function () {
                            for (let j = 0; j < moreLi.length; j++) {
                                if (j !== i) {
                                    $(moreLi[j]).css({
                                        "color": "#333",
                                        "border-bottom": "0",
                                    });
                                }
                            }
                            $(this).css({
                                "color": "#008cff", //ff6700
                                "border-bottom": "2px solid #008cff",
                            });
                        })
                    })(i)
                }
            })()
        },
        //鼠标悬停分类 切换商品类型
        //参数1：模块名 参数2：鼠标悬停元素的class 参数3：数据类型名 参数4：数据类型id 参数5：显示数据的id，8个
        productSwitch(boxName, boxLabelSelect, data, dataIndex) {
            return (() => {
                let select = "." + boxLabelSelect;
                let boxNameSelect = "." + boxName;
                $(select).mouseover(function (e) {
                    //热门 dataIndex 为undefined
                    if (dataIndex === undefined || dataIndex === "") {
                        for (let i = 0; i < data.length; i++) {
                            let selector = boxNameSelect + (i + 1);
                            $(selector).find(".img").attr("src", data[i].productPicInfo.picUrl);
                            $(selector).find(".name").text(data[i].productName);
                            $(selector).find(".desc").text(data[i].descript);
                            $(selector).find(".price").text(data[i].price + "元");
                        }
                    } else {    //其他是这个循环
                        for (let i = 0; i < dataIndex.length; i++) {
                            let selector = boxNameSelect + (i + 1);
                            $(selector).find(".img").attr("src", data[dataIndex[i]].productPicInfo.picUrl);
                            $(selector).find(".name").text(data[dataIndex[i]].productName);
                            $(selector).find(".desc").text(data[dataIndex[i]].descript);
                            $(selector).find(".price").text(data[dataIndex[i]].price + "元");
                        }
                    }
                })
            })()
        },
        //社区模块数据显示
        communityBox(data){
            return (()=>{
                let str = '';
                for (let i = 0; i < 8; i++) {
                    str += `<a href="#">
                            <div class="community-item community-item${i + 1}">
                                <img style="width: 240px;" src="${data[i].productPicInfo.picUrl}" alt="" class="community-item-img">
                                <div class="community-user">
                                    <img src="${data[i].userHead.headUrl}" alt="" class="community-user-tx">
                                    <p class="community-user-name">${data[i].userInfo.username}</p>
                                </div>
                                <p class="community-item-title">${data[i].title} | ${data[i].content}</p>
                                <p class="community-user-phoneX">${data[i].productInfo.productName}</p>
                            </div>
                          </a>`
                }
                $(".community").append(str);
            })()
        }
    }

    //ajax请求内容
    var ajaxGetData = {
        //导航栏菜单的请求
        navAjax() {
            return (() => {
                // 获取手机商品数据
                $.getJSON("http://localhost:8080/eight/index/box", navData.phoneData, function (data) {
                    nav.navHeadSub("phone-item", data);
                })
                //获取家电
                $.getJSON("http://localhost:8080/eight/index/box", navData.hourseData, function (data) {
                    nav.navHeadSub("hourse-item", data);
                })
                //获取书籍
                $.getJSON("http://localhost:8080/eight/index/box", navData.bookData, function (data) {
                    nav.navHeadSub("book-item", data);
                })
                //获取音响
                $.getJSON("http://localhost:8080/eight/index/box", navData.audioData, function (data) {
                    nav.navHeadSub("audio-item", data);
                })
                //获取配件
                $.getJSON("http://localhost:8080/eight/index/box", navData.partsData, function (data) {
                    nav.navHeadSub("parts-item", data);
                })
            })()
        },
        //主内容商品信息获取
        mainAjax() {
            return (() => {
                //商品秒杀
                $.getJSON("http://localhost:8080/eight/index/seckill", null, function (data) {
                    main.seckill(data);
                })
                //手机模块
                $.getJSON("http://localhost:8080/eight/index/box",mainData.phoneData , function (data) {
                    //左侧图片
                    main.boxInfo("phone-box", data, 0);
                })
                //家电模块
                $.getJSON("http://localhost:8080/eight/index/box", mainData.hourseData, function (data) {
                    //左侧图片
                    main.boxInfoPic("hourse-left", hourseImg);
                    main.boxInfo("hourse-box", data, 1);
                    main.productSwitch("hourse-box", "hourse-more .hot-active", data);
                })
                //书籍模块
                $.getJSON("http://localhost:8080/eight/index/box",mainData.bookData , function (data) {
                    //左侧图片
                    main.boxInfoPic("book-left", bookImg);
                    main.boxInfo("book-box", data, 1);
                    main.productSwitch("book-box", "book-more .hot-active", data);
                })

                //音响模块
                $.getJSON("http://localhost:8080/eight/index/box",mainData.audioData , function (data) {
                    main.boxInfoPic("audio-left", audioImg);
                    main.boxInfo("audio-box", data, 1);
                    main.productSwitch("audio-box", "audio-more .hot-active", data);

                })
                //配件模块
                $.getJSON("http://localhost:8080/eight/index/box", mainData.partsData, function (data) {
                    main.boxInfoPic("parts-left", partsImg);
                    main.boxInfo("parts-box", data, 1);
                    main.productSwitch("parts-box", "parts-more .hot-active", data);

                })
                //互动模块
                $.getJSON("http://localhost:8080/eight/index/box", {
                    "boxName": "hourse",
                    "code": "hs003&hs014&hs015&hs026&hs010&hs030&hs036&hs039"
                }, function (data) {
                    main.boxInfo("interact-box", data, 1);
                })

                $.getJSON("http://localhost:8080/eight/index/commentArticle",{
                    "artcleFine":1
                },function (data){
                    main.communityBox(data);
                })
            })()
        },
        //模块悬停，切换商品
        //参数1：模块名 参数2：鼠标悬停元素的class 参数3：数据类型名 参数4：数据类型id 参数5：显示数据的id，8个
        ajaxGetProductBoxClass(boxName, boxLabelSelect, catrgoryName, catrgoryId, dataIndex) {
            $.getJSON("http://localhost:8080/eight/index/catrgory/" + catrgoryName, {
                "catrgoryId": catrgoryId
            }, function (data) {
                main.productSwitch(boxName, boxLabelSelect, data, dataIndex);
            })
        }
    }

    nav.navHeadToggle(".nav-item")
    nav.navHeadToggle(".nav-header-sub")
    nav.navToggle()
    ajaxGetData.navAjax();
    ajaxGetData.mainAjax();
    main.seckillTime();
    main.moreActive("hourse-more");
    main.moreActive("book-more");
    main.moreActive("audio-more");
    main.moreActive("parts-more");

    //鼠标悬停，切换商品
    //书籍分类请求
    for (let i = 0; i < bookMoreLabel.length; i++) {
        ajaxGetData.ajaxGetProductBoxClass("book-box", bookMoreLabel[i].className,
            "book", moreData.bookCartgoryIds[i], moreData.bookdataIndexs[i])
    }

    for (let i = 0; i < hourseMoreLabel.length; i++) {
        ajaxGetData.ajaxGetProductBoxClass("hourse-box", hourseMoreLabel[i].className,
            "hourse", moreData.hourseCartgoryIds[i], moreData.hoursedataIndexs[i])
    }

    for (let i = 0; i < audioMoreLabel.length; i++) {
        ajaxGetData.ajaxGetProductBoxClass("audio-box", audioMoreLabel[i].className,
            "audio", moreData.audioCartgoryIds[i], moreData.audiodataIndexs[i])
    }

    for (let i = 0; i < partsMoreLabel.length; i++) {
        ajaxGetData.ajaxGetProductBoxClass("parts-box", partsMoreLabel[i].className,
            "parts", moreData.partsCartgoryIds[i], moreData.partsdataIndexs[i])
    }

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

    $(".user-login").on("click", function () {
        window.open($(".user-login").attr("href"));
    })

    if (utils.getCookie("isLoginHead") || localStorage.getItem("isLoginHead")) {
        let userId;
        if(utils.getCookie("isLoginHead")){
            userId = utils.getCookie("isLoginHead")
        }else if(localStorage.getItem("isLoginHead")){
            userId = localStorage.getItem("isLoginHead");
        }

        $.getJSON("http://localhost:8080/eight/user/headAndInfo", {
            "isLoginHead": localStorage.getItem("isLoginHead"),
            "userId": userId
        }, function (data) {
            let headPortrait = $(".head-portrait")
            $(".login-head").css("display", "none");

            let str = `<span class="skip-person">
                          <img src="/static/images/head/default.jpg" alt="">
                        </span>`;

            if(data !== null){
              /*  str = `<a href="http://localhost:8080/eight/userInfo/queryUserInfo?userId=${userId}" target="_blank">
                          <img src="${data.headUrl}" alt="">
                        </a>`;*/
                str = `<span class="skip-person">
                          <img src="${data.headUrl}" alt="">
                        </span>`;
            }
            headPortrait.css("display", "block").attr("value", userId).append(str);
            $(".skip-person").on("click",function (){
                window.open( "http://localhost:8080/eight/userInfo/queryUserInfo?userId=" + userId);
            })
        })

        //登陆和注册变成用户信息
        $("#user-operator1").attr({
            "class": "user-info",
            "value":userId,
            "href": "http://localhost:8080/eight/user/index/level"
        }).text("我的等级");
        $("#user-operator2").attr({
            "class": "user-order",
            "value":userId,
            "href": "http://localhost:8080/eight/user/index/order"
        }).text("我的订单");
        $("#user-operator3").attr({
            "class": "user-exits",
            "value":userId,
            "target": ""
        }).removeAttr("href").text("退出");

        $(".header-user-cart").attr("value",userId);
        //用户退出时
        $(".user-exits").click(function () {
            if (utils.getCookie("isLoginHead") || localStorage.getItem("isLoginHead")) {
                $.getJSON("http://localhost:8080/eight/user/exitsLogin",{
                    "userId":userId
                },function (data){
                    if(localStorage.getItem("isLoginHead")){
                        localStorage.removeItem("isLoginHead")
                    }
                    $(".header-user-cart").removeAttr("value");
                    $(".head-portrait").empty().css("display","none").off("click");
                    window.location.reload();
                })
            } else {
                alert("退出失败")
            }
        })

    }


})