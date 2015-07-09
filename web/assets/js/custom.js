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
}

/**
 *
 * @param $form form action 需要是完整的url
 */
function postFormAndSetAjax($form) {
    $.ajax({
        method: 'post',
        url: $form.attr('action'),
        data: $form.serialize(),
        success: function (data) {
            console.log('ajax success!');

            //返回的是网页
            if (typeof(data) == "string") {
                $('div.content-body').html(data);
                setAjax();

                //TODO: form
            }
            //返回的是json
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