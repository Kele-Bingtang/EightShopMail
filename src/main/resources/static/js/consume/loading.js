
var t = 10;

function openwin() {

    t -= 1;

    if(t==0){
        location.href="http://localhost:8080/eight/orderDetail/loading";

    }

    setTimeout("openwin()", 300);

}

openwin();