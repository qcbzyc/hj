<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/20
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入bootstrap-table样式 -->
    <link href="bootstrap-3.3.7/css/bootstrap-table.min.css" rel="stylesheet">
    <!-- 2. jQuery导入 -->
    <script type="text/javascript" src="pluges/jquery-3.4.1.min.js" charset="UTF-8"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <!-- 引入bootstrap-table js -->
    <script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap-table.min.js"></script>
    <!-- 引入中文语言包 -->
    <script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" >

       $(function(){
           //刷新数据
           function refresh(){
               $.ajax({
                   type:"post",
                   url:"employeeList",
                   async:true,  //异步
                   data:{
                       search:$(".secbox").val()//搜索栏数据
                   },
                   success:function(res){
                       var str=''
                       console.log(res)
                       var result = JSON.parse(res)
                       console.log(result.employees)
                       var result = result.employees
                       //用for循环将json文件里的内容拼接成字符串
                       for (var i=0;i<result.length;i++){
                           str+='<tr><td>'+result[i].empID+'</td><td>'+result[i].empName+'</td><td>'+result[i].job+'</td><td>'+result[i].salary+'</td><td>'+result[i].dept+'</td>'+
                               '<td><button class="btn btn-primary btn-xs update" data-toggle = "modal" data-target = "#updateModal">修改</button> ' +
                               '<button class="btn btn-danger btn-xs del">删除</button></td></tr>'
                       }
                       //刷新前先清除第一行以外的数据
                       $(".table tr:not(:first)").empty("")
                       //不好保留表头行，重新填充
                       var th = "<tr><td>编号</td> <td>姓名</td> <td>职位</td> <td>薪水</td><td>部门</td><td>操作</td></tr>"
                       //将刚才保存的字符串append到HTML里面
                       $(".table").append(th)
                       $(".table").append(str)
                   }
               });
           }
           //加载即刷新
           refresh()

           //查询
           $(".sec").click(function(){
               refresh();
           });

           //增
           $(".add_emp").click(function() {//点开增加按钮弹出的模态框后的确定按钮事件
               var employee={
                   "empName" : $("#empName").val(),
                   "job" : $("#job").val(),
                   "salary" : $("#salary").val(),
                   "dept" : $("#dept").val()
               }
                   $.post("employeeAdd",{employee:JSON.stringify(employee)},function(res){
                       var res = JSON.parse(res)
                       if(res.errorMsg){
                           alert(res.errorMsg);
                           return;
                       }else{
                           alert("保存成功");
                       }
                   })
                   $(".addmd").modal("hide")
                   refresh();
           })

           //改
           //add弹窗
           var arr=[]
           var empID
           $(document).on("click",".update",function(){
               //得到除首尾外所用一行单元格的值
               $(this).parents("tr").find("td:not(:first):not(:last)").each(function(){
                   arr.push($(this).text())
               })
               //得到所选行第一个单元格
               empID = $(this).parent().siblings().eq(0).text()
               console.log(empID)
               //赋值给修改框的子元素，方便修改
               $(".up").children().find("input").each(function(i){
                   $(this).val(arr[i])
               })
           })
           //确定修改
           $(".que_update").click(function(){//同增加事件
               var employee={
                   "empID":empID,
                   "empName" : $("#empName0").val(),
                   "job" : $("#job0").val(),
                   "salary" : $("#salary0").val(),
                   "dept" : $("#dept0").val()
               }
               $.post("employeeModify",{employee:JSON.stringify(employee)},function(res){
                   var res = JSON.parse(res)
                   if(res.errorMsg){
                       alert(res.errorMsg);
                       return;
                   }else{
                       alert("修改成功");
                       refresh();
                   }
               })
               //隐藏模态框
               $(".up").modal("hide")
           })

           //删除
           $(document).on("click",".del",function(){
               var empName = $(this).parent().siblings().eq(1).text()
               alert("确认删除员工"+empName+"?")
               //得到所选行第一个单元格
               empID = $(this).parent().siblings().eq(0).text()
               var employee={
                   "empID":empID
               }
               $.post("employeeDelete",{employee:JSON.stringify(employee)},function(res){
               var res = JSON.parse(res)
               if(res.errorMsg){
                   alert(res.errorMsg);
                   return;
               }else{
                   alert("删除成功");
                   refresh();
               }
               })
           })

       });

    </script>

</head>
<body>
<div class="container" style="padding-top: 40px;"><!--整个盒子居中-->
    <table class="table table-bordered text-center">
        <tr >
            <td colspan="6">
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-8">
                            <input  type="text" class="form-control secbox" />
                        </div>
                        <div class="col-md-3">
                            <button class="btn btn-danger sec" id="sec">搜索</button><!--搜索确定-->
                            <button class="btn btn-default add" data-toggle="modal" data-target="#addModal">增加</button>
                            <!--data-toggle data-target 属性插入bootstrap事件自带的模态框事件-->
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>职位</td>
            <td>薪水</td>
            <td>部门</td>
            <td>操作</td>
        </tr>
    </table>

    <!--修改模态框-->
    <div class="modal fade up" tabindex="-1" role="dialog" id="updateModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改员工</h4>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <span class="label label-primary">名字</span>
                            <input type="text" placeholder="名字" class="form-control" id="empName0"/>
                        </div>
                        <div class="form-group">
                            <span class="label label-success">职业</span>
                            <input type="text" placeholder="职业" class="form-control" id="job0"/>
                        </div>
                        <div class="form-group">
                            <span class="label label-info">薪水</span>
                            <input type="text" placeholder="薪水" class="form-control" id="salary0"/>
                        </div>
                        <div class="form-group">
                            <span class="label label-warning">部门</span>
                            <input type="text" placeholder="部门" class="form-control" id="dept0"/>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary que_update">确定</button><!--确定修改-->
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>
</div>

<!--增加模态框-->
<div class="modal fade addmd" tabindex="-1" role="dialog" id="addModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">增加员工</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <span class="label label-primary">名字</span>
                        <input type="text" placeholder="名字" class="form-control" id="empName"/>
                    </div>
                    <div class="form-group">
                        <span class="label label-success">职业</span>
                        <input type="text" placeholder="职业" class="form-control" id="job"/>
                    </div>
                    <div class="form-group">
                        <span class="label label-info">薪水</span>
                        <input type="text" placeholder="薪水" class="form-control" id="salary"/>
                    </div>
                    <div class="form-group">
                        <span class="label label-warning">部门</span>
                        <input type="text" placeholder="部门" class="form-control" id="dept"/>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消</button>
                <button id="add" type="button" class="btn btn-primary add_emp">确定</button><!--确定添加-->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
</div>

</body>
</html>
