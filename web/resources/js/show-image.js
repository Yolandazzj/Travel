$(document).ready(function() {
    var $iBox = $('.imgBox'),
        $iNum = $('.imgNum'),  //缓存优化
        indexImg = 1,          //初始下标
        totalImg = 5,          //图片总数量
        imgSize = 720,         //图片尺寸 宽度
        moveTime = 1100,        //切换动画时间
        setTime = 2500,        //中间暂停时间
        clc = null;

    function moveImg() {
        if (indexImg != totalImg) {
            $iBox.animate({
                left: -(indexImg * imgSize) + 'px'
            }, moveTime);
            $iNum.removeClass('mark-color')
                .eq(indexImg)
                .addClass('mark-color');
            indexImg++;
        } else {
            indexImg = 1;
            $iNum.removeClass('mark-color')
                .eq(indexImg - 1)
                .addClass('mark-color');
            $iBox.animate({
                left: 0
            }, moveTime);
        }
    }

    $iNum.hover(function () {
        $iBox.stop();                    //结束当前动画
        clearInterval(clc);              //暂停循环
        $iNum.removeClass('mark-color');
        $(this).addClass('mark-color');
        indexImg = $(this).index();
        $iBox.animate({
            left: -(indexImg * imgSize) + 'px'
        }, 500);
    }, function () {
        clc = setInterval(moveImg, setTime);
    });

    //鼠标放上停止动画
    $iBox.hover(function () {
        $('.control').fadeIn(200);
        clearInterval(clc);              //暂停循环
    }, function () {
        $('.control').hide();
        clc = setInterval(moveImg, setTime);
    });
});

