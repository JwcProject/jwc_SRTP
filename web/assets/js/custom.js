/**
 * Created by zl on 2015/7/6.
 */

function setAjax() {

    $('div.content-body a').click(function (event) {
        event.preventDefault();
        if ($(this).attr('href').indexOf('javascript') < 0) {
            $.ajax({
                method: 'get',
                url: $(this).attr('href'),
                success: function (data) {
                    $('div.content-body').html(data);
                    setAjax();
                },
                error: function () {
                    $('div.content-body').html('数据库错误，请稍后再试');
                }
            });
        }
    });
    $('input[type="image"],input[type="submit"]').click(function (event) {
        event.preventDefault();

        var form = $(this).parents().filter('form');

        $.ajax({
            method: 'post',
            url: form.attr('action'),
            data: form.serialize(),
            success: function (data) {
                $('div.content-body').html(data);
                setAjax();
            },
            error: function () {
                $('div.content-body').html('数据库错误，请稍后再试');
            }
        });

    })
    $('#pager').css('top','0').addClass('layout-inline');
}

/**
 *
 * @param $form form action ��Ҫ��������url
 */
function postFormAndSetAjax($form) {
    $.ajax({
        method: 'post',
        url: $form.attr('action'),
        data: $form.serialize(),
        success: function (data) {
            console.log('ajax success!');

            //���ص�����ҳ
            if (typeof(data) == "string") {
                $('div.content-body').html(data);
                setAjax();

                //TODO: form
            }
            //���ص���json
            else {
                //TODO:
            }
        },
        error: function () {
            //TODO:
            throw new Error("service response error");
        }
    });
}

function sendGetAndSetAjax($url) {
    $.ajax({
        method: 'get',
        url: $url,
        success: function (data) {
            console.log('ajax success!');

            //���ص�����ҳ
            if (typeof(data) == "string") {
                $('div.content-body').html(data);
                setAjax();

                //TODO: form
            }
            //���ص���json
            else {
                //TODO:
            }
        },
        error: function () {
            //TODO:
            throw new Error("service response error");
        }
    });
}

function PageClick(){

}

