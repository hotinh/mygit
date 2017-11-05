<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Demo</title>
<link rel="stylesheet" href="${ctx}/resources/bootstrap-table.min.css">
<script type="text/javascript" src="${ctx}/resources/jquery-1.11.1.min.js"/></script>
<script type="text/javascript" src="${ctx}/resources/bootstrap-table.min.js"></script>
<link rel="stylesheet" href="${ctx}/resources/bootstrap.min.css">
<script type="text/javascript" src="${ctx}/resources/bootstrap.min.js"></script>
</head>
<body >
	<div class="page-container">
	  <div style="height:500px">
	   <table class="table table-bordered table-striped" id="usertable">
	   </table>
	   </div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	 $("#usertable").bootstrapTable({
		 method:'get',
		 url:"${ctx}/user/page",
		 cache: false, 
		 striped: true,
		 pagination: true,
		 pageList: [10,20,50],
		 pageSize:10,
		 pageNumber:1,
		 queryParams: function(params){
		 		paramsReturn = {
					limit: params.limit,
					offset: params.offset,
				};
			 	return paramsReturn;
		 },
		 sidePagination:'server',
		 contentType: "application/x-www-form-urlencoded",
		 showColumns: true, 
		 showRefresh: true,  
		 smartDisplay:true,
		 columns: [
          {  
				field: 'id',  
				title: '编号',  
				align: 'center',  
				width: '60',  
				valign: 'middle',	
          },
          {  
        	  	field: 'username', 
          	    title: '名称',  
				align: 'center',  
				width: '60',  
				valign: 'middle', 
          },
          {  
				field: 'age',  
				title: '年龄',  
				align: 'center',  
				width: '40',  
				valign: 'middle',
          },
          {   
        	  	field: 'password',
          		title: '密码',  
				align: 'center',  
				width: '120',  
				valign: 'middle',
          },
          {
        	    field: 'mail',
				title: '邮箱',  
				align: 'center',  
				width: '40',  
				valign: 'middle', 
          },
          {
				title: '用户操作',  
				align: 'center',  
				width: '240',  
				valign: 'middle', 
				formatter: function(value,row,index){
	        		 var str = "";
	            		 str += '<button class="btn btn-secondary btn-xs"><i class="fa fa-edit"></i><span>查看</span></button>';
	            	 return str;
   			}
          },
	     ]
	 });
});
</script>
</html>