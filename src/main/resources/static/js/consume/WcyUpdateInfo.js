jQuery(function () {
    var $ = jQuery;

    /*点击编辑按钮跳转到编辑页面*/
    jQuery(".edit").on("click", function () {
        location.href = "updateInfo?userInfoId=5";
    })

    jQuery(".btn3").on("click", function () {
        $.ajax({
            url: "updateInfos",
            data: $(".form").serialize()

        })

        /*修改资料后点击提交按钮*/

        jQuery(".btn3").on("click", function () {
            $.ajax({
                url: "updateInfos",
                data: $(".form").serialize()

            })
        })

        /* 点击返回按钮跳转回到账号管理页面 */
        jQuery(".btn31").on("click", function () {
            location.href = "returnPage?userInfoId=5";
        })
    })
})