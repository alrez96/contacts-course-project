$(document).ready(function(){
  $("a#sidebar-toggle").click(function(){
    $(".sidebar").toggleClass("sidebar-show");
    $(".item-title").toggleClass("item-title-show");
    $(".page-overlay").css("display", "block");
    $(".page-overlay").animate({
      opacity: 1
    }, 300);
  });

  $(".page-overlay").click(function(){
    $(".sidebar").toggleClass("sidebar-show");
    $(".item-title").toggleClass("item-title-show");
    $(this).animate({
      opacity: 0
    }, 300, function() {
      $(this).css("display", "none");
    });
  });

  $("input#night-mode-toggle").change(function(){
    $(".is-night-mode-a").toggleClass("night-mode-a");
    $(".is-night-mode-b").toggleClass("night-mode-b");
    $(".is-night-mode-c").toggleClass("night-mode-c");
    $(".is-night-mode-d").toggleClass("night-mode-d");
    $(".is-night-mode-e").toggleClass("night-mode-e");
  });
});
