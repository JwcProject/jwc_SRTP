/**
 * Created by zl on 2015/7/6.
 */
$(function () {
    window.onhashchange = function () {
        var url = loaction.href;
        url = url.substring(url.indexOf("#"));
        $.ajax({
            method: 'get',
            url: '<%=basePath>' + url,
            success: function (data) {

            }
        })
    }
})