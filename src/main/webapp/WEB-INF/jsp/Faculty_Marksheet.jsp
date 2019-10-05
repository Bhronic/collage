<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head><meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Insert title here</title>
<style type="text/css">
.logo h1{margin: 0;
		font-family: sans-serif;
		font-weight:bold;
		font-size: 40px;
		text-align: center;
		box-sizing: border-box;
		}
.logo p{margin: 0;
		font-family: sans-serif;
		font-size: 20px;
		text-align: center;
		padding: 0 0 40px;}
.college_logo{
			  max-width:200px;
			  max-height: 200px;
			  position:absolute;
				}
.stmt h3{
font-family: sans-serif;
		font-size: 30px;
		text-align: center;
}
.stmt p{

		font-size: 15px;
		padding: 0 0 0;
}
</style>
</head>
<body>
<label id="down"><input type="submit" value="Download PDF" name="download" onclick="window.print()"; ></label>
<br>
<div class="logo">
<img alt="image" src="data:image/jpeg;base64,${image}" width="250 px" height="150 px" class="college_logo">
<h1>PARUL UNIVERSITY</h1>
<p>Waghodiya,Vadodara</p>
</div>
<div class="stmt">
<h3>STATEMENT OF MARKS</h3>
<p><strong>Name:</strong>${name}</p>
<p><strong>Course:</strong>${course}</p>
<p><strong>Branch:</strong>${branch}</p>
<p><strong>Semester:</strong>${semester}</p>
</div>

<!--<table style="width:100%">
<tr>
<th>Subject Code and Name</th>
<th>Maximum Marks</th>
<th>Marks Obtained</th>
</tr>
</table>
-->
<div class="w3-row-padding">
  <div class="w3-half">

<c:if test="${!empty subject}">

  
	<table style="width:100%" >
						<tr>
								<th>Subject Code and Name</th>
								<th colspan="2">Maximum Marks</th>
							
						</tr>
						
						<tr>
							<th></th>
							<th>Sessional</th>
							<th>Exam.</th>
							
						</tr>
			<c:forEach items="${subject}" var="sub">
					<tr>
						<td>${sub.subject_id} ${sub.subject_name}</td>
						<td>${sub.internal_marks}</td>
						<td>${sub.external_marks}</td>
					</tr>
				</c:forEach>
  					<tr>
						<td>Total</td>
						<td>${session_total}</td>
						<td>${exam_total}</td>
					</tr>
					<tr>
						<td>Grand Total</td>
						<td>${total}</td>
					
					</tr>				
		</table>
		</c:if>
		   </div>
   <div class="w3-half">
		
  <c:if test="${!empty result}">
					<table style="width:100%">
						<tr>
							<th colspan="3">Marks Obtained</th>
						<tr>
							<th>Internal Marks</th>
							<th>External Marks</th>
							<th>Credit</th>
						</tr>
				<c:forEach items="${result}" var="result">
					<tr>
						<td>${result.internal_marks_ob}</td>
						<td>${result.external_marks_ob}</td>
						<td>${result.credit }</td>
					</tr>  
				</c:forEach>
					<tr>
						<td>${session_mark}</td>
						<td>${exam_mark}</td>
						<td>${cre_total}</td>
					</tr>
					<tr>
						<td>${total_mark}</td>
					</tr>
			</table>
		</c:if>		
		
</div>
</div>




</body>
</html>