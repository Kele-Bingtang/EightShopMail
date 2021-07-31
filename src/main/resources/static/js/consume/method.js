
var addrShow = $('#addr-show');
var btn = document.getElementsByClassName('met1')[0];
var prov = $('#prov');
var city = $('#city');
var country = $('#country');


/*用于保存当前所选的省市区*/
var current = {
    prov: '',
    city: '',
    country: ''
};

/*自动加载省份列表*/
(function showProv() {
    //btn.disabled = true;
    var len = provice.length;
    let str = "<dt class='option-init'>请选择</>";
    for (let i = 0; i < len; i++) {
        str += `
                <dd data-value="${i}">${provice[i]['name']}</dd>
        `
    }
    prov.append(str);
    optionClick("address-option","init");
    //点击请选择 选项，清空数据，包括三级联动的所有地址，隐藏表单的地址信息，address-label里显示的地址信息
    $(".option-init").on("click",function (){
        $(".unSelect").eq(0).val("");
        $(".unSelect").eq(1).val("");
        $(".unSelect").eq(2).val("");
        city.empty();
        country.empty()
        $(this).parent().css({
            "max-height":"0",
            "padding":"0",
            "border": "0",
            "transition": "all .3s"
        })
        for (let i = 0; i < $(".unSelect").length; i++) {
            $(".address-option").eq(i).children("dd").removeAttr("class data-status");
        }
        $(".provice").val("").text("");
        $(".city").val("").text("");
        $(".district").val("").text("");
    })
})();



/*根据所选的省份来显示城市列表*/
function showCity(obj) {
    let index
    let children = $(obj).children("dd");
    for (let i = 0; i < children.length; i++) {
        if(children.eq(i).attr("data-status") == "selected"){
            index = i;
            break;
        }
    }

    if (index !== current.prov) {
        current.prov = index;
        //addrShow.value = '';
        //btn.disabled = true;
    }
    if (index != null) {
        city.length = 1;
        var cityLen = provice[index]["city"].length;
        let str = "";
        for (let j = 0; j < cityLen; j++) {
            str +=`
               <dd data-value="${j}">${provice[index]['city'][j].name}</dd>
            `
        }
        //第二级和第三级数据清空
        $(".unSelect").eq(1).val("");
        $(".unSelect").eq(2).val("");
        city.empty().append(str);
        //把点击的信息放到文本框
        optionClick(obj.className);
    }
}


/*根据所选的城市来显示县区列表*/
function showCountry(obj) {
    let index;
    let children = $(obj).children("dd");
    for (let i = 0; i < children.length; i++) {
        if(children.eq(i).attr("data-status") == "selected"){
            index = i;
            break;
        }
    }
    current.city = index;
    if (index != null) {
        country.length = 1; //清空之前的内容只留第一个默认选项
        var countryLen = provice[current.prov]["city"][index].districtAndCounty.length;
        if (countryLen == 0) {
            addrShow.value = provice[current.prov].name + '-' + provice[current.prov]["city"][current.city].name;
            return;
        }
        let str = "";
        for (var n = 0; n < countryLen; n++) {
            str +=`
               <dd data-value="${n}">${provice[current.prov]["city"][index].districtAndCounty[n]}</dd>
            `
        }
        //第二级数据清空
        $(".unSelect").eq(2).val("");
        country.empty().append(str);
        optionClick(obj.className);

    }
}

/*点击确定按钮显示用户所选的地址*/
function showAddr() {
    $(".provice").val(provice[current.prov].name);
    $(".city").val(provice[current.prov]["city"][current.city].name);
    $(".district").val(provice[current.prov]["city"][current.city].districtAndCounty[current.country]);
    $(".addr").val(addrShow.value);
}

/*点击option，增加参数*/
function optionClick(ele){
    let select = "." + ele;
    //获取点击事件
    let dd = $(select).find("dd");
    for (let i = 0; i < dd.length; i++) {
        dd.eq(i).on("click",function (){
            let unSelect = $(this).parent().prev().children(".unSelect");
            unSelect.val($(this).text());
            if($(this).parent().attr("id") === "prov"){
                $(".provice").val(unSelect.val()).text(unSelect.val());
            }else if($(this).parent().attr("id") === "city"){
                $(".city").val(unSelect.val()).text(unSelect.val());
            }else if($(this).parent().attr("id") === "country"){
                $(".district").val(unSelect.val()).text(unSelect.val());
            }
            $("#addr-show").val($("#addr-show").val() + $(this).text());
            $(this).attr({
                "class":"selected",
                "data-status":"selected"
            });
            dd.not($(this)).removeAttr("class data-status");
            $(this).parent().css({
                "max-height":"0",
                "padding":"0",
                "border": "0",
                "transition": "all .3s"
            })

        })
    }
    $(".address-input").bind("input", function (){
        $(".address").val($(this).val()).text($(this).val());
    })
}