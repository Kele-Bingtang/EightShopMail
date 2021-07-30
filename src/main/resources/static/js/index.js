$(function () {
    // 鼠标移入移出导航栏效果
    var navItemA = $(".nav-item");
    //登录图片和购物车移入变颜色
    var logintx = $(".header-user-head");
    var cart = $(".header-user-cart");
    var bookMoreLabel = $(".book-more li:not('.hot-active')");
    var hourseMoreLabel = $(".hourse-more li:not('.hot-active')");
    var audioMoreLabel = $(".audio-more li:not('.hot-active')");
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
                    str += `<li><a href="/pay/buyCart?productId=${data[i].productId}"> 
                            <img src="${data[i].productPicInfo.picUrl}" alt="">
                            <p>${data[i].productName}</p>
                            <p>￥<span>${data[i].price}</span></p>
                        </a></li>`;
                }
                $(select).parent().find(".nav-header-wrap").children("ul").append(str);
            })()
        }
    }

    //主内容
    var main = {
        seckill(data) {
            return (() => {
                console.log(data)
                $(".plain-right").append($("<ul></ul>"));
                var str = "";
                for (let i = 0; i < data.length; i++) {
                str += `<li data-value="${data[i].productId}">
                                <a href="/pay/buyCart?productId=${data[i].productId}">
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
        boxInfoPic(ele, img1, img2) {
            return (() => {
                let select = "." + ele;
                var homeLeft = ` <div>
                            <a href="">
                                <img src="${img1}" alt="">
                            </a>
                        </div>
                        <div>
                            <a href="">
                                <img src="${img2}" alt="">
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
                            <a href="/pay/buyCart?productId=${data[i].productId}">
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
                                    <a href="/pay/buyCart?productId=${data[i].productId}">
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
        //鼠标悬停 切换商品类型
        productSwitch(boxName, boxLabelSelect, data, dataIndex) {
            return (() => {
                let select = "." + boxLabelSelect;
                let boxNameSelect = "." + boxName;
                $(select).mouseover(function (e) {
                    if (dataIndex === undefined || dataIndex === "") {
                        for (let i = 0; i < data.length; i++) {
                            let selector = boxNameSelect + (i + 1);
                            $(selector).find(".img").attr("src", data[i].productPicInfo.picUrl);
                            $(selector).find(".name").text(data[i].productName);
                            $(selector).find(".desc").text(data[i].descript);
                            $(selector).find(".price").text(data[i].price + "元");
                        }
                    } else {
                        for (let i = 0; i < dataIndex.length; i++) {
                            let selector = boxNameSelect + i;
                            $(selector).find(".img").attr("src", data[dataIndex[i]].productPicInfo.picUrl);
                            $(selector).find(".name").text(data[dataIndex[i]].productName);
                            $(selector).find(".desc").text(data[dataIndex[i]].descript);
                            $(selector).find(".price").text(data[dataIndex[i]].price + "元");
                        }
                    }
                })
            })()
        }
    }

    var ajaxGetData = {
        //导航栏菜单
        navAjax() {
            return (() => {
                // 获取手机商品数据
                $.getJSON("http://localhost:8080/product/box", {
                    "boxName": "phone",
                    "code": "hw004&mi007&pg001&mi005&pg005&hw005&pg004&mi010",
                }, function (data) {
                    nav.navHeadSub("phone-item", data);
                })
                //获取家电
                $.getJSON("http://localhost:8080/product/box", {
                    "boxName": "hourse",
                    "code": "hs020&hs007&hs001&hs022&hs005&hs015&hs004&hs010",
                }, function (data) {
                    nav.navHeadSub("hourse-item", data);
                })
                //获取书籍
                $.getJSON("http://localhost:8080/product/box", {
                    "boxName": "book",
                    "code": "book020&book007&book001&book065&book055&book037&book004&book021",
                }, function (data) {
                    nav.navHeadSub("book-item", data);
                })
                //获取音响
                $.getJSON("http://localhost:8080/product/box", {
                    "boxName": "audio",
                    "code": "audio001&audio003&audio005&audio007&audio009&audio011&audio013&audio014",
                }, function (data) {
                    nav.navHeadSub("audio-item", data);
                })
                //获取配件
                $.getJSON("http://localhost:8080/product/box", {
                    "boxName": "parts",
                    "code": "audio001&audio003&audio005&audio007&audio009&audio011&audio013&audio014",
                }, function (data) {
                    nav.navHeadSub("parts-item", data);
                })
            })()
        },
        //主内容商品信息获取
        mainAjax() {
            return (() => {
                //商品秒杀
                $.getJSON("http://localhost:8080/product/seckill", null, function (data) {
                    main.seckill(data);
                })
                //手机模块
                $.getJSON("http://localhost:8080/product/box", {
                    "boxName": "phone",
                    "code": "mi007&mi002&mi004&hw010&hw008&hw001&pg001&pg009"
                }, function (data) {
                    var phoneLeft = `<a href="#"><img src="/static/images/index/phoneDIv.jpg" alt=""></a>`
                    $(".phone-left").append(phoneLeft);
                    main.boxInfo("phone-box", data, 0);
                })
                //家电模块
                $.getJSON("http://localhost:8080/product/box", {
                    "boxName": "hourse",
                    "code": "hs009&hs026&hs013&hs023&hs020&hs032&hs034&hs040"
                }, function (data) {
                    main.boxInfoPic("hourse-left", "/static/images/index/hourse1.png", "/static/images/index/hourse2.png");
                    main.boxInfo("hourse-box", data, 1);
                    main.productSwitch("hourse-box", "hourse-more .hot-active", data);
                })
                //书籍模块
                $.getJSON("http://localhost:8080/product/box", {
                    "boxName": "book",
                    "code": "book003&book014&book056&book023&book020&book032&book034&book070"
                }, function (data) {
                    main.boxInfoPic("book-left", "/static/images/index/book1.webp", "/static/images/index/book2.webp");
                    main.boxInfo("book-box", data, 1);
                    main.productSwitch("book-box", "book-more .hot-active", data);
                })

                //音响模块
                $.getJSON("http://localhost:8080/product/box", {
                    "boxName": "audio",
                    "code": "audio001&audio002&audio003&audio007&audio009&audio010&audio011&audio012"
                }, function (data) {
                    main.boxInfoPic("audio-left", "/static/images/index/audio1.webp", "/static/images/index/audio2.webp");
                    main.boxInfo("audio-box", data, 1);
                    main.productSwitch("audio-box", "audio-more .hot-active", data);

                })
                //配件模块
                $.getJSON("http://localhost:8080/product/box", {
                    "boxName": "parts",
                    "code": "audio001&audio002&audio003&audio007&audio009&audio010&audio011&audio012"
                }, function (data) {
                    main.boxInfo("parts-box", data, 1);
                    main.productSwitch("parts-box", "parts-more .hot-active", data);

                })
                //互动模块
                $.getJSON("http://localhost:8080/product/box", {
                    "boxName": "hourse",
                    "code": "hs003&hs014&hs015&hs026&hs010&hs030&hs036&hs039"
                }, function (data) {
                    main.boxInfo("interact-box", data, 1);
                })
            })()
        },
        ajaxGetProductBoxClass(boxName, boxLabelSelect, catrgoryName, catrgoryId, dataIndex) {
            $.getJSON("http://localhost:8080/product/catrgory/" + catrgoryName, {
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
    main.moreActive("hourse-more");
    main.moreActive("book-more");
    main.moreActive("audio-more");
    main.moreActive("parts-more");
    //书籍分类请求
    let bookCartgoryIds = [7, 8, 9, 10];
    let bookdataIndexs = {
        1: [5, 8, 10, 12, 14, 16, 18, 19],
    }
    for (let i = 0; i < bookMoreLabel.length; i++) {
        ajaxGetData.ajaxGetProductBoxClass("book-box", bookMoreLabel[i].className,
            "book", bookCartgoryIds[i], bookdataIndexs[i])
    }
    //家具分类请求
    let hourseCartgoryIds = [11, 12];
    let hoursedataIndexs = {
        1: [5, 8, 10, 12, 14, 16, 18, 19],
    }
    for (let i = 0; i < hourseMoreLabel.length; i++) {
        ajaxGetData.ajaxGetProductBoxClass("hourse-box", hourseMoreLabel[i].className,
            "hourse", hourseCartgoryIds[i], hoursedataIndexs[i])
    }
    //音响分类请求
    let audioCartgoryIds = [14, 15];
    let audiodataIndexs = {
        1: [0, 1, 2, 3, 4, 5, 6, 7],
        2: [9, 10, 11, 12, 13, 14, 15, 16]
    }
    for (let i = 0; i < audioMoreLabel.length; i++) {
        ajaxGetData.ajaxGetProductBoxClass("audio-box", audioMoreLabel[i].className,
            "audio", audioCartgoryIds[i], audiodataIndexs[i])
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

    if (utils.getCookie("isLoginHead") || $(".head-portrait").attr("value")) {
        $.getJSON("http://localhost:8080/user/headAndInfo", {
            "isLoginHead": utils.getCookie("isLoginHead")
        }, function (data) {
            let headPortrait = $(".head-portrait")
            $(".login-head").css("display", "none");
            headPortrait.on("click", function () {
                window.open("http://localhost:8080/user/index");
            })
            headPortrait.css("display", "block").attr("value", data.userId).children("img").attr("src", data.headUrl);
            //登陆和注册变成用户信息和
            $("#user-operator1").attr({
                "class": "user-info",
                "href": "http://localhost:8080/user/index/level"
            }).text("我的等级");
            $("#user-operator2").attr({
                "class": "user-order",
                "href": "http://localhost:8080/user/index/order"
            }).text("我的订单");
            $("#user-operator3").attr({
                "class": "user-exits",
                "target": ""
            }).removeAttr("href").text("退出");

            $(".user-exits").click(function () {

                if (utils.getCookie("isLoginHead")) {
                    utils.deleteCookie("isLoginHead");
                    window.location.reload();
                } else {
                    alert("退出失败")
                }
            })

        })

    }
})