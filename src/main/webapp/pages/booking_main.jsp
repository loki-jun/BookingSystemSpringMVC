<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
 <head>
  <title>BUI+bootstrap风格后台管理系统模板-www.daimajiayuan.com</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
  <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
   
   <meta name="viewport" content="width=device-width, initial-scale=1.0">

 </head>
 <body>

  <div class="header">
    
     <div class="dl-title"> 
    
        <span class="lp-title-port">USTC</span><span class="dl-title-text">羽毛球场地预约</span></div>
    <div class="dl-log">欢迎您，
    <span class="dl-log-user">
    	<%=session.getAttribute("email") %>
    </span>
    <a href="###" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
  </div>
   <ul id="J_NavContent" class="dl-tab-conten">
 </ul>
 <script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="./assets/js/bui.js"></script>
  <script type="text/javascript" src="./assets/js/config.js"></script><script>
    BUI.use('common/main',function(){
      var config = [{
          id:'menu', 
          homePage : 'code',
          menu:[{
              text:'首页',
              items:[
                {id:'code',text:'系统简介',href:'main/code.html',closeable : false},
              
              ]
            },{
              text:'个人信息',
              items:[
                {id:'operation',text:'个人信息',href:'form/form-dialog-grid.html'},
                
              ]
            },{
              text:'场地预约',
              items:[
                {id:'resource',text:'场地预约',href:'test_json.html'}  
              ]
            }]
          }];
      new PageUtil.MainPage({
        modulesConfig : config
      });
    });
  </script>
 </body>
</html>
