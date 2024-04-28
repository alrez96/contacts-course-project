$("#error1").hide();
$("#error2").hide();
$("#error6").hide();
$("#error7").hide();
$(document).ready(function(){
  $("#inputOP").change(function(){
    if ($(this).val() == "ارجاع") {
      $("#inputRef").removeAttr("disabled");
      $("#inputNote").removeAttr("disabled");
      $('#inputStatusCh').attr("disabled", "disabled");
    } else if ($(this).val() == "تغییر وضعیت") {
      $("#inputStatusCh").removeAttr("disabled");
      $("#inputNote").removeAttr("disabled");
      $('#inputRef').attr("disabled", "disabled");
    } else if ($(this).val() == "ثبت یادداشت") {
      $("#inputNote").removeAttr("disabled");
      $('#inputRef').attr("disabled", "disabled");
      $('#inputStatusCh').attr("disabled", "disabled");
    } else {
      $('#inputRef').attr("disabled", "disabled");
      $('#inputNote').attr("disabled", "disabled");
      $('#inputStatusCh').attr("disabled", "disabled");
    }
  });
});

$(".error0").hide();
$(".error1").hide();
$(".error2").hide();
$(".error3").hide();
$(".error4").hide();
$(".error5").hide();
 function IsEmail(email) {
  var regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  if(regex.test(email)==false) {
    return false;
  }else{
    return true;
  }
}
function hasNumber(password){
   if (password.match(/([0-9])/)){
    return true;
   }else{
    return false;
   }
}

function hasLetter(password){
    if (password.match(/([a-zA-Z])/)){
        return true;
   }else{
    return false;
   }
}
$(document).ready(function() {
  $('input[type="text"]').keyup(function() {
    //$('.btn').prop('disabled', true);
        $('.error2').hide();
        var email = $('#email-box').val();
        var password = $('#password-box').val();
        if((IsEmail(email)==true) && hasLetter(password)==true && hasNumber(password)==true && (password.length >= 8) ) {
           //$('.btn').prop('disabled', false);
        }else if(IsEmail(email)==false && email != ""){
            $('.error2').show();
        }
     });
  });
$(document).ready(function() {
    $('input[type="password"]').keyup(function() {
    //$('.btn').prop('disabled', true);
        $('.error3').hide();
        $('.error4').hide();
        $('.error5').hide();
        var email = $('#email-box').val();
        var password = $('#password-box').val();
        if((IsEmail(email)==true) && hasLetter(password)==true && hasNumber(password)==true && (password.length >= 8)) {
           //$('.btn').prop('disabled', false);
        }else if(hasLetter(password)==false && password != ""){
          $('.error1').hide();
            $('.error5').show();
        }else if(hasNumber(password)==false && password != ""){
          $('.error1').hide();
            $('.error4').show();
        }else if(password.length< 8 && password != ""){
          $('.error1').hide();
            $('.error3').show();
        }
     });

    $('input[type="password"][id="repassword-box"]').keyup(function() {
    //$('.signinBtn').prop('disabled', true);
      $('.error1').hide();
      var email = $('#email-box').val();
      var password = $('#password-box').val();
      var repassword = $('#repassword-box').val();
    $('.signinBtn').prop('disabled', true);
    $('.error1').hide();
    if((IsEmail(email)==true) && hasLetter(password)==true && hasNumber(password)==true && (password.length >= 8) && repassword==password ) {
           //$('.signinBtn').prop('disabled', false);
        }else if (repassword != password && password != "" && repassword != "" && password.length> 7) {
      $(".error1").show();
    }
  });
  $('input[type="password"][id="password-box"]').change(function() {
    //$('.signinBtn').prop('disabled', true);
        $('.error1').hide();
    var email = $('#email-box').val();
        var password = $('#password-box').val();
    $('.signinBtn').prop('disabled', true);
    $('.error1').hide();
    if((IsEmail(email)==true) && hasLetter(password)==true && hasNumber(password)==true && (password.length >= 8) && repassword==password ) {
          // $('.signinBtn').prop('disabled', false);
    }else if (repassword != password && password != "" && password.length> 7) {
      $(".error1").show();
    }
  });

});
