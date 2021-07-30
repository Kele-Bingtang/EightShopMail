$(function(){
    var pri = $(".price").text();
    // 绑定焦点事件，改变焦点事件,value属性值发生改变时触发
    $(".number").bind("input propertychange",function(blur){
        var num = $(".number").val();
        var tota = pri*num;
        $(".total").text(tota.toFixed(2));
        var price = $(".total").text(tota.toFixed(2)).text();
        $(".f").val(price);
        JSON.stringify($(".f").val(price));
        $(".n").val(num);
        JSON.stringify($(".n").val(num));
    });

    var title = $("#title").text();
    JSON.stringify($(".m").val(title));

    var desc = $(".desc").text();
    JSON.stringify($(".mi").val(desc));


    
})