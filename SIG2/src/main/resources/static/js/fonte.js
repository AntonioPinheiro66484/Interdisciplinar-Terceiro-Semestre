var fontsite = 15;

$(document).ready(function(){
    $('#aumentaFonte').click(function(){
        if(fontsite<20){
            fontsite=fontsite+1;
            $('body').css({'font-size': fontsite+ 'px'});
            $('p').css({'font-size': fontsite+ 'px'});
            $('h3').css({'font-size': fontsite+ 'px'});
            $('label').css({'font-size': fontsite+ 'px'});
            $('input').css({'font-size': fontsite+ 'px'});
            $('a').css({'font-size': fontsite+ 'px'});
            $('header').css({'font-size': fontsite+ 'px'});
            $('option').css({'font-size': fontsite+ 'px'});
            $('select').css({'font-size': fontsite+ 'px'});
        }
    });

    $('#diminuiFonte').click(function(){
        if(fontsite>12){
            fonte=fonte-1;
            $('body').css({'font-size': fontsite+'px'});
            $('p').css({'font-size': fontsite+'px'});
            $('h3').css({'font-size': fontsite+ 'px'});
            $('label').css({'font-size': fontsite+ 'px'});
            $('input').css({'font-size': fontsite+ 'px'});
            $('a').css({'font-size': fontsite+ 'px'});
            $('header').css({'font-size': fontsite+ 'px'});
            $('option').css({'font-size': fontsite+ 'px'});
            $('select').css({'font-size': fontsite+ 'px'});

        }
    });

});