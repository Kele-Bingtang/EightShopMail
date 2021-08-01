$(function (){
   function clickOption(){
       /*点击option，增加参数*/
       //获取点击事件
       let dd = $(".option").children("dd");
       for (let i = 0; i < dd.length; i++) {
           dd.eq(i).on("click", function () {
               let unSelect = $(this).parent().prev().children(".unSelect");
               unSelect.val($(this).text());
               $(this).attr({
                   "class": "selected",
                   "data-status": "selected"
               });
               dd.eq(i).parent().children("dd").not($(this)).removeAttr("class data-status");
               $(this).parent().css({
                   "max-height": "0",
                   "padding": "0",
                   "border": "0",
                   "transition": "all .3s"
               })
           })
       }
   }
    clickOption();
    //模拟下拉菜单，出现和隐藏，添加滑动动画
    for (let i = 0; i < $(".unSelect").length; i++) {
        $(".unSelect").eq(i).on("click",function (){
            clickOption();
            selectAnim($(this));
        })
        //点击箭头也可以下拉
        $(".arrow").eq(i).on("click",function (){
            clickOption();
            selectAnim($(this));
        })
    }
    //触发下拉菜单显示
    function selectAnim(ele){
        let option = $(ele).parent().next()
        $(".unSelect").not($(ele)).parent().next().css({
            "max-height":"0",
            "padding":"0",
            "border": "0",
            "transition": "all .1s"
        })
        if(option.children("dd").length <= 0){
            option.html("<span class='no-data'>无数据</span>")
        }else {
            option.remove("span");
        }

        if(option.css("height") == "0" || option.css("height") == "0px" ){
            option.css({
                "max-height":"300px",
                "padding":"5px 0",
                "border": "1px solid #d2d2d2",
                "transition": "all .3s"
            });
        }else {
            option.css({
                "max-height":"0",
                "padding":"0",
                "border": "0",
                "transition": "all .3s"
            });
        }
    }
    //点击请选择按钮，清空后面的元素
    function optionInit(){
        if($(".option").eq(0).children(".option-init").length < 1){
            $(".option").eq(0).prepend("<dt class='option-init'>请选择</dt>")
        }
    }
    optionInit();

    $(".option-init").on("click",function (){
        $(this).parent().css({
            "max-height":"0",
            "padding":"0",
            "border": "0",
            "transition": "all .3s"
        })
        $(".option").children("dd").removeAttr("class data-status");
        $(".unSelect").val("")

    })
})