/* 

App Landing Template

http://www.templatemo.com/tm-474-app-landing

*/
jQuery(document).ready(function(){
    // jQuery.templatemo_is_chrome
    $.templatemo_is_chrome = /chrom(e|ium)/.test(navigator.userAgent.toLowerCase());
    $.templatemo_is_ie = !!navigator.userAgent.match(/Trident/g) || !!navigator.userAgent.match(/MSIE/g);
    // Template Mo menu hide
    jQuery.fn.templateMoMenuHide = function(){
        return this.each(function(){
            $(this)
                .removeClass("shadow-top-down")
                .animate({opacity: 0,top: 120}, 240,"easeOutSine",function(){
                    $(this).hide();
                });
            return true;
        });
    }
    // Template Mo menu show
    jQuery.fn.templateMoMenuShow = function(){
        return this.each(function(){
            $(this)
                .addClass("shadow-top-down")
                .show()
                .css({opacity: 0,top: 120})
                .animate({opacity: 1,top: 130}, 40,"easeInSine");
            return true;
        });
    }
    // Menu click on plus btn
    $('.show-menu a').on('click', function(e){
        // When nav is visible make nav hide
        if($('nav').is(":visible")){
            $('nav:visible').templateMoMenuHide();
        // When nav is not visible make nav show
        }else{
            $('nav').templateMoMenuShow();
        }
        return false;
    });
    // Menu hide when click on any area of document
    $(document).on('click', function(e){
        $('nav:visible').templateMoMenuHide();
        return true;
    });
    // Menu scroll to.
    $('a.scroll_effect').on('click', function(e){
        target_element = $(this).attr('href');
        scroll_to = $(target_element).offset().top;
        if($(window).scrollTop() != scroll_to && target_element !== undefined){
            // Chrome scroll to calculation and other browser scroll to calculation is different.
            if($.templatemo_is_chrome){
                body_scroll_target = scroll_to;
            }else{
                body_scroll_target = $("body").scrollTop()+scroll_to;
            }
            $('html,body').animate({scrollTop:body_scroll_target},1000);
        }
        // If menu is visible hide the nav.
        $('nav:visible').templateMoMenuHide();
        return false;
    });
    // Javascropt parallax effect config for different browser.
    // Chrome broswer setting
    if($.templatemo_is_chrome){
        $("html").attr("style","overflow:auto;");
        $("body").attr("style","overflow:auto;height:auto;");
        $('#templatemo_home').parallax("50%", 0.1);
        $('#templatemo_download').parallax("50%", 0.1);
    // Non IE broswer setting
    }else if(!$.templatemo_is_ie){
        $("html").attr("style","overflow: auto;");
        $("body").attr("style","background: #455a64;overflow: auto;height: auto;");
        $('#templatemo_home').parallax("50%", 0.1);
        $('#templatemo_download').parallax("50%", 0.1);
    // IE broswer setting
    }else{
        $('#templatemo_home').parallax("50%", 0.5);
        $('#templatemo_download').parallax("50%", 0.5);
    }
});