<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>

 		body{
		background:#C0C0C0;
	
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
              padding: 8px;
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
           font-family:sans-serif;     
           position: fixed;
           z-index: 1;
           top: 0;
           left: 0;
           background-color: #455e64;
           overflow-x: hidden;
  
}

.sidebar a {
  
  margin-top: 20%; 
  
  text-decoration: none;
  
  font-weight:bold;
  font-size: 20px;
  color: #111;
  display: block;
}
.dropdown-btn {
  margin-top: 20%;
  text-decoration: none;
  font-weight:bold;
  font-size: 20px;
  color: #111;
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
/* Add an active class to the active dropdown button */
.active {
  background-color: green;
  color: white;
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

 .main input[type="submit"]:hover{
  cursor: pointer;
  background: #ffc107;
  color: #000;
}
.w3-half {
          font-size: 17px;
}
</style>
</head>
<body>
  <div class="header">
    <h2>WELCOME<em> ADMIN</em></h2>

  </div>
          <!-- Nav -->
        <div class="nav">
          <ul>
            <li>MENU</li>
       		<li style="float: right;"><a href="index.jsp">LOGOUT</a></li>
          </ul>
        </div>



<div class="main">
  <h3>Details</h3>
  <form  action="saveSubject" method="POST" >
  
 
 
  <div class="w3-row-padding">
  <div class="w3-half">
  <label>Subject ID</label>
    <input class="w3-input w3-border" type="text" name="subject_id"  >
    <br>
  <label>Subject Name</label>
    <input class="w3-input w3-border" type="text" name="Subject_name"  >
    <br>
    <label>Maximum External Marks</label>
    <input class="w3-input w3-border" type="text" name="external_marks"  >
    <br>
    <label>Maximum Internal Marks</label>
    <input class="w3-input w3-border" type="text" name="internal_marks"  >
    <br>
    <label>Credit</label>
    <input class="w3-input w3-border" type="text" name="credit"  >
    <br>
  </div>
 
   <div class="w3-half">
   <label>Course Name</label>
    		<select   name="course" class="w3-input w3-border" id="course">
   			<option value="">Select Course</option>
       		<c:forEach var="f" items="${course}">
        	<option value="${f.getCourse_name()}">${f.getCourse_name()}</option>
    		</c:forEach>
     		</select>
    <br>
   <label>Specialization</label>
    <select name="specialisation" id="specialisation" class="w3-input w3-border">
              <option value="null">Select Specialisation</option>
              <c:forEach var="f" items="${branch}">
        	  <option value="${f.getSpecialisation()}">${f.getSpecialisation()}</option>
               </c:forEach>
               </select>
    <br>
  <label>Branch Name</label>
    <select name="branch" id="branch" class="w3-input w3-border">
              <option value="null">Select Branch</option>
              <c:forEach var="f" items="${branch}">
        	  <option value="${f.getBranch_name()}">${f.getBranch_name()}</option>
               </c:forEach>
               </select>
    <br>
   <label>Semester</label>
    <input class="w3-input w3-border" type="text" name="semester"  >
    <br>  
   
   </div>
  <input class="w3-input w3-border" type="submit" name="submit" value="submit">
</div>

</form>
</div>
<div class="sidebar">
 <a href=" "><i class="fa fa-fw fa-home"></i>INTRODUCTION</a>
 
  <button class="dropdown-btn"><i class="fa fa-fw fa-user"></i>Faculty<i class="fa fa-caret-down"></i>

  </button>
  <div class="dropdown-container">
     <a href="faculty_view"><i class="fa fa-circle-o"></i>List</a>
  </div>
  <button class="dropdown-btn"><i class="fa fa-fw fa-user"></i>Student<i class="fa fa-caret-down"></i>

  </button>
  <div class="dropdown-container">
     <a href="faculty_view"><i class="fa fa-circle-o"></i>List</a>
  </div>
  <button class="dropdown-btn"><i class="fa fa-fw fa-user"></i>Course<i class="fa fa-caret-down"></i>

  </button>
  <div class="dropdown-container">
     <a href="course"><i class="fa fa-circle-o"></i>List</a>
     <a href="add_course"><i class="fa fa-circle-o"></i>Add</a>
  </div>
  <button class="dropdown-btn"><i class="fa fa-fw fa-user"></i>Branch
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="branch"><i class="fa fa-circle-o"></i>List</a>
     <a href="add_branch"><i class="fa fa-circle-o"></i>Add</a>
</div>
<button class="dropdown-btn"><i class="fa fa-fw fa-user"></i>Subject
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="subject"><i class="fa fa-circle-o"></i>List</a>
     <a href="add_subject"><i class="fa fa-circle-o"></i>Add</a>
</div>
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
