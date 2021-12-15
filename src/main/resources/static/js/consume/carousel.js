$(function () {
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
        img.src = '/static/images/index/carousel' + (parseInt(index) + 1) + '.jpg';

        for (var i=0; i<lis.length; i++) {
            lis[i].style.backgroundColor = "#fff";
        }
        // 更改li的背景色
        lis[index].style.backgroundColor = "transparent";
        lis[index].style.border = "1px solid #fff";
        // 更改超链接
        if((parseInt(index) + 1) == 1){
            link.href = "/eight/view/commodities?pageName=hourse";
        }else if((parseInt(index) + 1) == 2){
            link.href = "/eight/view/commodities?pageName=phone";
        }else if((parseInt(index) + 1) == 3){
            link.href = "/eight/view/commodities?pageName=hourse";
        }else if((parseInt(index) + 1) == 4){
            link.href = "/eight/view/commodities?pageName=audio";
        }
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