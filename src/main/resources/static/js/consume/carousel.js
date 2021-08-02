$(function () {
    var imgs = ["loop1.jpg", "loop2.jpg", "loop3.jpg", "loop4.jpg"];
    var carimg = document.getElementById("loop-img1");
// var limg = document.getElementById("l-arrow");
// var rimg = document.getElementById("r-arrow");
    var circle = document.querySelector(".circle")
    var circlea = document.querySelectorAll(".circle>a");
    var a = document.querySelectorAll("a");
    let n = 0;
    let interval;


    /**
     * 轮播图左下圆点
     * 圆点随图片移动而移动
     * i:圆点索引
     * n:图片索引
     */
    function circleAndimg() {
        for (var i = 0; i < circlea.length; i++) {
            if (n === i) {
                circlea[i].style.backgroundColor = "transparent";
                circlea[0].style.border = "1px solid #fff";
            } else {
                circlea[i].style.backgroundColor = "#fff";
            }
        }
    }

    /**
     * 图片自动向右加载
     */
    function right() {
        n++;
        if (n >= imgs.length) {
            n = 0;
        }
        carimg.src = "/images/index/" + imgs[n];
        circleAndimg();
    }

    /**
     * 图片自动向左加载
     */
    function left() {
        n--;
        if (n < 0) {
            n = imgs.length - 1;
        }
        carimg.src = "/images/index/" + imgs[n];
        circleAndimg();
    }

    /**
     * 鼠标悬停和移出时
     * 鼠标悬停：图片不切换，
     * 鼠标移出：重置切换时间为0
     * @param status 状态
     */
    function process(status) {
        if (status === "enter") {
            clearInterval(interval);
        } else if (status === "leave") {
            interval = setInterval(right, 4000);
        }
    }

    /**
     * 设置元素的悬停和移出事件
     * @param attr
     */
    function attrProcess(attr) {
        attr.onmouseenter = function () {
            process("enter");
        }
        attr.onmouseleave = function () {
            process("leave");
        }
    }

    /**
     * 圆点点击事件
     * 圆点点击后，图片跟着索引切换
     * @param index
     */
    function circleclick(index) {
        for (var i = 0; i < circlea.length; i++) {
            if (i === index) {
                n = i;
                carimg.src = "/images/index/" + imgs[n];
                circlea[i].style.backgroundColor = "transparent";
                circlea[0].style.border = "1px solid #fff";
            } else {
                circlea[i].style.backgroundColor = "#fff";
            }
        }
    }

    /**
     * 轮播图两个箭头点击事件
     */
// rimg.onclick = right;
// limg.onclick = left;

    /**
     * 页面元素加载后执行脚本
     */
    window.onload = function () {
        attrProcess(carimg);
        // attrProcess(limg);
        // attrProcess(rimg);
        attrProcess(circle);
        circlea[0].style.backgroundColor = "transparent";
        circlea[0].style.border = "1px solid #fff";
        /*for (var i = 0; i < a.length; i++) {
            a[i].onclick = function (e){
                e = e || window.event;
                e.preventDefault()===undefined ? e.returnValue = false : e.preventDefault();
                console.log("超链接无法跳转");
            }
        }*/
    }
    /**
     * 页面不关闭，内容无限循环
     */
    interval = setInterval(right, 4000);


    // 获取页面元素
    var div = document.querySelector('.cartun'),//
        img = document.querySelector('.cartun img'),//图片
        link = document.querySelector('.cartun a'),//点击图片跳转的超链接
        lis = document.querySelectorAll('.circle li');//索引li
    var index = 0; // index表示的是图片或HTML页面的下标

    // 启动定时器，实现图片自动轮播的效果
    var timer = setInterval(autoChange, 5000);
    //第一个默认选中
    lis[0].style.backgroundColor = "transparent";
    lis[0].style.border = "1px solid #fff";

    // 设置鼠标移入div的效果
    div.addEventListener('mouseover', function() {
        // 停止图片的自动轮播效果
        clearInterval(timer);

    }, false);

    // 设置鼠标移出div的效果
    div.addEventListener('mouseout', function() {
        // 重新启动定时器，使图片轮播
        timer = setInterval(autoChange, 5000);
    }, false);


    // 设置鼠标移入到li编号上时的效果
    for (var i=0; i<lis.length; i++) {
        lis[i].id = i;
        // 为li设置鼠标移入事件
        lis[i].onclick = function() {
            index = this.id;
            change();
        }
    }


    // 定义一个方法，该方法的功能是切换图片、li的背景色、以及超链接
    function change() {
        // 更改图片
        img.src = '/static/images/index/loop' + (parseInt(index) + 1) + '.jpg';

        for (var i=0; i<lis.length; i++) {
            lis[i].style.backgroundColor = "#fff";
        }
        // 更改li的背景色
        lis[index].style.backgroundColor = "transparent";
        lis[index].style.border = "1px solid #fff";
        // 更改超链接
        link.href = 'html/' + index + '.html';
    }

    // 定义一个方法，该方法的作用是启动切换图片、超链接、li的背景色
    function autoChange() {
        // 修正index的值
        index++;//7
        // 判断index的值是否到达边界
        if (index === lis.length) {
            index = 0;
        }
        // 调用change方法，根据index的值自动切换图片、超链接、li的背景色
        change();
    }
})