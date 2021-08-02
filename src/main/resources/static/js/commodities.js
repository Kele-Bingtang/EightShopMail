var curPage = $("#curPage");
var totalRecord = $(".totalRecord");
var pageSize = Number($("#pageSize").val());
var totalPage;
var pageName=$("#pageName").val();
var flag = "false";
var selectedList = [];
var condition = "null";
var conLen = 0;
var oneCategoryId;

$(".head2").html(pageName);

$(document).ready(function () {
    if(pageName==="phone"){
        oneCategoryId="1";
    }else if(pageName==="book"){
        oneCategoryId="2"
    }else if(pageName==="hourse"){
        oneCategoryId="3"
    }else if(pageName==="audio"){
        oneCategoryId="13"
    }else if(pageName==="parts"){
        oneCategoryId="16"
    }
    $.getJSON("http://localhost:8080/view/getCategory", {
        "categoryId": oneCategoryId
    }, function (data) {
        CreateVariety_Category("variety", data);
    })
    if(pageName==="book"){
        $.getJSON("http://localhost:8080/view/getDetail", {
            "pageName": pageName,
        }, function (data) {
            CreateVariety_Detail("variety", data);
        })
    }
    $.getJSON("http://localhost:8080/redirectPage/init", {
        "pageName": pageName,
        "oneCategoryId":oneCategoryId,
        "pageSize": pageSize,
        "curPage": curPage.val(),
        "condition": condition,
        "conLen": conLen
    }, function (data) {
        CreateCommodities("commodities", data);
    });
})
$("input[name='toPage']").click(function () {
    totalPage = parseInt((Number(totalRecord.val()) + pageSize - 1) / pageSize);
    if (this.id === "firstPage") {
        curPage.val(1);
    } else if (this.id === "prePage") {
        if (curPage.val() !== "1") {
            curPage.val(Number(curPage.val()) - 1);
        }
    } else if (this.id === "nextPage") {
        if (curPage.val() < totalPage) {
            curPage.val(Number(curPage.val()) + 1);
        }
    } else if (this.id === "lastPage") {
        curPage.val(totalPage);
    }
    $.getJSON("http://localhost:8080/redirectPage/limit", {
        "pageName": pageName,
        "oneCategoryId":oneCategoryId,
        "pageSize": pageSize,
        "curPage": curPage.val(),
        "condition": condition,
        "conLen": conLen
    }, function (data) {
        ChangeByLimit(data);
    })
});

$("#variety").on("mouseenter", ".condition", function () {
    $(this).addClass("hovered");
})
$("#variety").on("mouseleave", ".condition", function () {
    $(this).removeClass("hovered")
})


$("#variety").on("click", ".condition", function () {
    condition = "";
    conLen = 0;
    var obj = {"id": $(this).attr("id"), "data": $(this).attr("data")}
    var objIndex;
    var res = selectedList.some(item => {
        if (item.id === obj.id) {
            objIndex = selectedList.indexOf(item);
            return true;
        } else
            return false;
    });

    if (!res) {
        $(this).addClass("selected");
        selectedList.push(obj);
    } else {
        $(this).removeClass("selected");
        selectedList = $.grep(selectedList, function (e, n) {
            return n !== objIndex;
        })
    }
    if (selectedList.length === 0) {
        condition = "null";
    }
    $.each(selectedList, function (n, e) {
        var c = "&condition_" + n + "=" + e.id.substring(0, e.id.length - 1) + e.data;
        if (n === 0) {
            condition = c;
        }
        else{
            condition += c;
        }
        conLen++;
    });
    curPage.val(1);
    $.getJSON("http://localhost:8080/redirectPage/updateCom", {
        "pageName": pageName,
        "oneCategoryId":oneCategoryId,
        "pageSize": pageSize,
        "condition": condition,
        "conLen": conLen
    }, function (data) {
        UpdateCommodities(data);
    })
});

function UpdateCommodities(data) {
    var lastLen = 0;
    if (data.length === 0) {
        alert("抱歉，未能查询到您需要的商品信息");
        for (var i = 0; i < pageSize; i++) {
            $("#commodity_" + i).css("display", "none");
        }
        flag = "true";
    } else {
        totalRecord.val(data[0].totalRecord);
        totalPage = parseInt((Number(totalRecord.val()) + pageSize - 1) / pageSize);
        if (flag === "true" && data.length >= pageSize) {
            for (var j = 0; j < pageSize; j++) {
                $("#commodity_" + j).css("display", "block")
            }
            flag = "false";
        }
        if (flag === "true" && data.length >= lastLen) {
            for (var j = 0; j < data.length; j++) {
                $("#commodity_" + j).css("display", "block");
            }
        }
        if (data.length < pageSize) {
            flag = "true";
        }
        lastLen = data.length;
        for (var i = 0; i < pageSize; i++) {
            var e = $("#pic_" + i);
            var n = $("#productName_" + i);
            var p = $("#price_" + i);
            if (i < data.length) {
                e.attr("src", data[i].productPicInfo.picUrl);
                n.html(data[i].productName)
                p.html(data[i].price);
            } else {
                $("#commodity_" + i).css("display", "none");
            }
        }
    }
}

function ChangeByLimit(data) {
    if (flag === "true" && Number(curPage.val()) !== totalPage) {
        for (var j = 0; j < pageSize; j++) {
            $("#commodity_" + j).css("display", "block");
        }
        flag = "false";
    }
    if (Number(curPage.val()) === totalPage) {
        flag = "true";
    }
    for (var i = 0; i < pageSize; i++) {
        var e = $("#pic_" + i);
        var n = $("#productName_" + i);
        var p = $("#price_" + i);
        if (i < data.length) {
            e.attr("src", data[i].productPicInfo.picUrl);
            n.html(data[i].productName)
            p.html(data[i].price);
        } else {
            $("#commodity_" + i).css("display", "none");
        }
    }
}

function CreateCommodities(ele, data) {
    let select = "#" + ele;
    var str = "";
    var commodityId;
    var pId;
    var nId;
    var price_id;
    totalRecord.val(data[0].totalRecord);
    for (let i = 0; i < pageSize&&i<data.length; i++) {
        commodityId = "commodity_" + i;
        pId = "pic_" + i;
        nId = "productName_" + i;
        price_id = "price_" + i
        if (i % 3 === 0 && i !== 0) {
            str += '<br/>'
        }
        str += `<li><a id=${commodityId} href=\"#\">
                            <img id=${pId} src="${data[i].productPicInfo.picUrl}" alt="">
                            <p id=${nId}>${data[i].productName}</p>
                            <p>￥<span id=${price_id}>${data[i].price}</span></p>
                        </a></li>`;
    }
    $(select).children("ul").append(str);
    for (var i = 0; i < pageSize; i++) {
        var commodities = $("#commodity_" + i);
        var pic =$("#pic_"+i);
        commodities.css("position", "absolute");
        commodities.css("width", "20%");
        commodities.css("height", "50%");
        commodities.css("left", (10 + 30 * (i % 3)).toString() + "%");
        commodities.css("top", (parseInt((i / 3)) * 50).toString() + "%");
        pic.css("border","black solid 2px");
        pic.css("width","95%");
        pic.css("height","70%");
    }
}

function CreateVariety_Category(ele, data) {
    let select = "#" + ele;
    var str = "";
    var tmp;
    str += `<li>类型:`;

    for (var i = 0; i < data.length; i++) {
        tmp = "two_category_id_" + i;
        str += `<input id=${tmp} class="condition" type="button" name="condition" value=${data[i].categoryName} data=${data[i].categoryId}>`
    }
    str += `</li>`
    $(select).children("ul").append(str);
}

function CreateVariety_Detail(ele, data) {
    let select = "#" + ele;
    var str = "";
    var tmp;
    str += `<li><label>出版社:</label>`;
    for (var i = 0; i < data.length; i++) {
        tmp = "b_publisher_" + i;
        str += `<input id=${tmp} class="condition" type="button" name="condition" value=${data[i].bpublisher} data=${data[i].bpublisher}>`
    }
    str += `</li>`
    $(select).children("ul").append(str);
    str = `<li><label>作者:</label>`;
    for (var i = 0; i < data.length; i++) {
        tmp = "b_author_" + i;
        str += `<input id=${tmp} class="condition" type="button" name="condition" value=${data[i].bauthor} data=${data[i].bauthor}>`
    }
    str += `</li>`
    $(select).children("ul").append(str);
}
