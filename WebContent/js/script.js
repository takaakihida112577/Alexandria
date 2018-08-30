var timer;
$(window).load(function() {
  var count = $(".complete span").length;
  var index = 0;
  timer = setInterval(function() {
    $(".complete span").eq(index).show(300);
    index ++;
    if(index == count) {
      clearInterval(timer);
    };
  }, 500);
});