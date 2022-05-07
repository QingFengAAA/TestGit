<%@page contentType="text/html; UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<body>
<script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
    //页面加载事件
    $(function () {
        //给Id为useRequestBodyAjax超链接绑定一个点击事件
        $("#useRequestBodyAjax").click(function () {
            alert("点击事件绑定成功");
            $.ajax({
                url:"useRequestBody",
                type:"post",
                // data:"username=test&age=18&gender=male",
                data:'{"username":"test","age":25,"gender":"male"}',//json
                contentType:"application/json",
                dataType:"text",
                success:function (data) {
                    alert(data);
                }
            });
        });
    })
</script>

<a href="#" id="useRequestBodyAjax">RequestBody注解的使用</a>

</body>
</html>
