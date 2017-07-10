<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

body {
	margin: 40px 10px;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}
  


</style>
<link href='resources/calender/css/fullcalendar.min.css' rel='stylesheet' />
<link rel='stylesheet' href='resources/calender/css/jquery-ui.min.css' />
<script src='resources/calender/js/jquery.min.js'></script>
<script src='resources/calender/js/moment.min.js'></script>
<script src='resources/calender/js/fullcalendar.min.js'></script>
<script src='resources/calender/js/locale-all.js'></script>
<script src='resources/calender/js/jquery-ui.min.js'></script>


<script type="text/javascript">
	 $(function() {
		 $.ajax({
		     type : "POST", 
		     url : "calendarAjax", 
		     dataType : "json" , 
		     contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
		     success : function(data) {
		    	 $('#calendar').empty();
		    	 console.log(data);
		    	 setCalendar(data);
		    	

		    }

		   });
	})
	        
   
  
	 function setCalendar(data){
	  var date = new Date();
	  var d = date.getDate();
	  var m = date.getMonth();
	  var y = date.getFullYear();
	  var jsonData = JSON.stringify(data).replace(/\[]"/gi,"");
	
	  
	  console.log(jsonData)
	  $('#calendar').fullCalendar({
		theme: true,
		locale:'ko',
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month'
		},
		defaultDate: new Date(),
		navLinks: true, 
		editable: true,
		eventLimit: true, 
	    events: JSON.parse(jsonData),
	    eventClick:function(obj) {
	    	 window.open("gameDetailPage?gno="+obj.gNo);
	 }  
 })
}
	 
        
</script>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id='calendar'></div>
</body>
</html>