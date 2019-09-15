<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Webpage using div</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<style>
		body{
			margin:0px;
		}
        .header{
                padding: 2px;
                padding-left: 12%;
                background-color:#455e64;
                text-align: left;
               }
          .header h2{
          	color: black; }
              /*===============[Nav CSS]==========*/
              .nav{
              	background-color:#243238;
              	padding: 5px;
              	}
             
              .nav li{
              list-style: none;
              display: inline-block;
              padding: 5px;
               }
           .nav a{
           	color: #fff;
           }
           
          .nav ul li a:hover{
            text-decoration: none;
            color: #7fffd4;
           } 
              .lside{
              	 float: left;
               width: 100%;
               min-height: 550px;
               background-color: #f0f8ff;
               text-align: center;
              }
           .sidebar {
           padding-top: 5%; 
           height: 100%;
           width: 160px;
           position: fixed;
           z-index: 1;
           top: 0;
           left: 0;
           background-color: #111;
           overflow-x: hidden;
  
}

.sidebar a {
  
  margin-top: 20%; 
  
  text-decoration: none;
  font-size: 20px;
  color: #818181;
  display: block;
}
.dropdown-btn {
  margin-top: 20%;
  text-decoration: none;
  font-size: 20px;
  color: #818181;
  display: block;
  border: none;
  background: none;
  width: 100%;
  text-align: left;
  cursor: pointer;
  outline: none;
}

.sidebar a:hover ,.dropdown-btn:hover {
  color: #f1f1f1;
}

.dropdown-container {
  display: none;
  background-color: #262626;
  padding-left: 8px;
}

/* Optional: Style the caret down icon */
.fa-caret-down {
  float: right;
  padding-right: 8px;
}
.main {
  margin-left: 160px; /* Same as the width of the sidenav */
  padding: 0px 10px;
}
</style>
</head>
<body>
<div>
	<div class="header">
	  <h2>WELCOME <em>ADMIN</em></h2>
	</div>
         	<!-- Nav -->
      	<div class="nav">
      		<ul>
                
	<!--    <li style="padding-left: 50px;"><a href="#">MENU</a></li>
				<li style="float: center;"><a href="#">ABOUT</a></li>
				<li style="float: center;"><a href="#">CONTACT</a></li> -->
				<li>CHANGE</li>    			
				<li style="float: right;"><a href="index.jsp">LOGOUT</a></li>
			</ul>
      	</div>    
     
      <!-- main -->
      	<div style="height:440px">
      		<div class="main">	
      			<c:if test="${!empty user}">

	<c:forEach items="${user}" var="user">
		
			
			<p>Name:${user.name}</p>
			<p>Address:${user.address}</p>
			<p>City:${user.city}</p>
			<p>State:${user.state}</p>
		    <p>Pincode: ${user.pincode}</p>
		    <p>Email:   ${user.email}</p>
		    <p>Contact: ${user.contact_no}</p>
	</c:forEach>
	
</c:if>
      		</div>
      	
      	</div>
      <!-- sidebar -->
           
 </div>
 <div class="sidebar">
  <a href="introduction.jsp"><i class="fa fa-fw fa-home"></i> INTRODUCTION</a>
<button class="dropdown-btn">
<i class="fa fa-fw fa-user"></i>Faculty<i class="fa fa-caret-down"></i>
</button>
<div class="dropdown-container">
    <a href="faculty_view"><i class=".fa-minus-circle"></i>List</a>
</div>
  <button class="dropdown-btn">
  <i class="fa fa-fw fa-user"></i>Student<i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="allstudent_view"><i class=".fa-minus-circle"></i>List</a>
</div>
  <script>
/* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
var dropdown = document.getElementsByClassName("dropdown-btn");
var i;

for (i = 0; i < dropdown.length; i++) {
  dropdown[i].addEventListener("click", function() {
  this.classList.toggle("active");
  var dropdownContent = this.nextElementSibling;
  if (dropdownContent.style.display === "block") {
  dropdownContent.style.display = "none";
  } else {
  dropdownContent.style.display = "block";
  }
  });
}
</script>
</body>
</html>