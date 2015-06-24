
<%@ page contentType = "text/html; charset=utf-8" %>

<html>
  <head>
  	<link rel="stylesheet" type="text/css" href="/team6/css/bootstrap.min.css">
	<title>Welcome to our system</title>
  </head>
  
  <body style="background-image:url(../team6/img/bg.jpg);background-repeat: no-repeat;background-size:100% 100%;">
      <div style="text-align:center;margin-top:50px;font-size:50px;font-family: Microsoft YaHei;background-color:#336699;opacity:0.8;">
        <p style="color:#FFFFFF;">软件项目管理大作业------java源程序分析系统</p>
      </div>
  	   <div id ="uploadform" style="margin:50 auto 0 auto;height:440px;width:600px;">
       
              <p style="text-align:center;font-size:30px;font-family: Microsoft YaHei;color:#2F4F4F;margin-top:200px;">请先上传您的文件</p>
              <form action="step2.jsp" method="post" enctype="multipart/form-data" name="form1" class="style1">
              <table>
                  <tr>
                    <td>
                      <p style="text-align:left;font-size:25px;font-family: Microsoft YaHei;width:200px;margin-left:50px;margin-top:5px;">点击右侧的按钮选择上传的.java程序源文件（目前仅支持java），选择成功后点击提交按钮</p>
                    </td>
                    <td>
                      <input style="margin-top:50px;margin-left:30px;" class="btn btn-primary" type="file" name="file" size="150" />
                    </td>
                  </tr>
              </table> 
              <div style="margin-left:250px;margin-top:10px;">
                <input style="width:100px;"class="btn btn-primary btn-lg" role="button" type="submit" value="提交" />
              </div>
              </form>
       </div>
	     <p align="center" style="margin-top:10px;">第六组，白文俊，李海杰，刘佳军，林淳</p>

  </body>
  </html>