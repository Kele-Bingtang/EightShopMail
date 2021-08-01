
$(function () {

    //获取点击事件的对象
    $(".nav li").click(function () {
        //获取要显示或隐藏的对象
        var divShow = $(".content").children('.list');
        //判断当前对象是否被选中，如果没选中的话进入if循环
        if (!$(this).hasClass('selected')) {
            //获取当前对象的索引
            var index = $(this).index();
            //当前对象添加选中样式并且其同胞移除选中样式；
            $(this).addClass('selected').siblings('li').removeClass('selected');
            //索引对应的div块显示
            $(divShow[index]).show();
            //索引对应的div块的同胞隐藏
            $(divShow[index]).siblings('.list').hide();
        }
    });

   function selectYear(){
       let yearAll = new Date().getFullYear();
       let year = '';
       for (let i = yearAll; i >= 1990; i--) {
           if($(".year-input").val() == i){
               year += `<dd data-value="${i}" data-status="selected" class="selected">${i}</dd>`
           }else {
               year += `<dd data-value="${i}">${i}</dd>`
           }
       }
       $(".option1").append(year)

   }
    selectYear();
  function selectMonth(){
      // 月份列表
      let month = '';
      for (var i = 1; i <= 12; i++) {
          if($(".month-input").val() == i) {
              month += `<dd data-value="${i}" data-status="selected" class="selected">${i}</dd>`;
          }else {
              month += `<dd data-value="${i}">${i}</dd>`;

          }
      }
      $(".option2").append(month);

      if($(".month-input").val()){
          selectDay($(".month-input").val());
      }
      $(".option2").children("dd").on("click",function (){
          selectDay($(this).attr("data-value"));
      })
  }
    selectMonth();
  function selectDay(month){
      let dayCount = "";
      let year;
      for (let i = 0; i < $(".option1").children("dd").length; i++) {
          if($(".option1").children("dd").eq(i).attr("data-status")){
            year = $(".option1").children("dd").eq(i).text();
          }
      }
      for (let i = 1; i <= 12; i++) {
          // 31天
          if( month == 2){
              dayCount = 29;
              if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)){
                  dayCount = 28;
                  break;
              }
              break;
          }else if(month % 2 != 0 && month < 8){
              dayCount = 31;
              break;
          }else if(month % 2 == 0 && month >= 8){
              dayCount = 31;
              break;
          }else {
              dayCount = 30;
              break;
          }
      }
      let day = "";
      for (let i = 1; i <= dayCount; i++) {
          if($(".day-input").val() == i) {
              day += `<dd data-value="${i}" data-status="selected" class="selected">${i}</dd>`
          }else {
              day += `<dd data-value="${i}">${i}</dd>`
          }
      }
      $(".option3").empty().append(day);
  }

    $(".to-index").on("click",function (){
        if(window.opener){
            window.self.close();
            window.opener.location.reload();
        }
    })


});