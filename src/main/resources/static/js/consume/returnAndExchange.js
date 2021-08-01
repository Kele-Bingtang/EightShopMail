$(function () {
    $("#btn").on("click",function () {
        if($(".shu1").val().length === 0){
            alert("金额不能为空，请输入金额");
        }else {
            window.location.href = "success";
        }
    })
});
