
var t = 10;

function openwin() {

    t -= 1;

    if(t==0){

        location.href="loading";

    }

    setTimeout("openwin()", 300);

}

openwin();