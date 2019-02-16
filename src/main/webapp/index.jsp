<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>菜鸟教程(runoob.com)</title>
    <script src="view/js/jquery-3.3.1.min.js"></script>
    <script src="view/js/layer-v3.1.1/layer/layer.js"></script>
    <style type="text/css">
        .demo{
           background-color: aquamarine;
        }
    </style>
</head>
<body>
<input type="button" value="测试layer" id="testLayer">
<input type="button" value="测试layer" id="testLayer1">
<input type="button" value="测试layer" id="testLayer2">
<input type="button" value="测试layer" id="testLayer3">
<input type="button" value="测试layer" id="testLayer4">
<button value="测试dom1" id ="dom1" style="display: none">
    <span>这是button 测试显示</span>
</button>
<div id="dom2" style="display: none" class="demo">
    <div>
        <table>
            <tbody>
            <tr>
                <td>嵌套div dom测试</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
<script >
    $("#testLayer").on('click', function () {
        //layer.msg("layer is fist");
        var array=['l','a','y','e','r'];
        var arr=new Array(2);
        var ar=new Array('2','3');
        /**
         * title支持三种形式的参数
         * String ''标题显示的数据或['',''] 第一个标题显示的数据，第二显示字符串的样式
         * title:['参数测试','font-size:18px;color:blue;'],
         * Boolean false与''的效果是一样的都是不显示标题
         * Array
         * content 三种数据类型
         *String 直接显示 content:'content 测试String类型'
         * Dom 只有type=1时可以使用
         *
         * */
        layer.open({
            title:'参数测试',
            content:array
        });
    });

    $("#testLayer1").on('click', function () {
        //layer.msg("layer is fist");
        layer.open({
            title:'参数测试',
            type:1,
            shade:0.5,
            shadeClose:true,
            maxmin:true,
            resizing: function(layero){
               // alert(layero);
            },
            btn:['btn1a','btn2b','btn3c'],no: function(index, layero){alert(index+"a");},
            btn2:function(index, layero){alert(index+"b");},
            btn3:function(index, layero){alert(index+"c");},

            content:'btn text'
        });
    });
    $("#testLayer2").on('click', function () {
        layer.alert("asaa",{title:'qwerty'},function(){

        })
    });
    $("#testLayer3").on('click', function () {
        //layer.msg("layer is fist");
        var array=['l','a','y','e','r'];
        var arr=new Array(2);
        var ar=new Array('2','3');
        layer.open({
            title:'参数测试',
            type: 3,
            content:['','baidu.com']
        });
    });
    $("#testLayer14").on('click', function () {
        //layer.msg("layer is fist");
        var array=['l','a','y','e','r'];
        var arr=new Array(2);
        var ar=new Array('2','3');
        layer.open({
            title:'参数测试',
            type: 4,
            content:array
        });
    });
</script>
</html>
