<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>          
	<style type="text/css">
		body {
  background:url('http://cdn.wallpapersafari.com/13/6/Mpsg2b.jpg');
  margin:0px;
  font-family: 'Ubuntu', sans-serif;
	background-size: 100% 110%;
}
h1, h2, h3, h4, h5, h6,p {
  margin:0; padding:0;
}
.login {
  margin:0 auto;
  max-width:500px;
}
.login-header {
  color:#fff;
  text-align:center;
  font-size:300%;
}
/* .login-header h1 {
   text-shadow: 0px 5px 15px #000; */
}
.login-form {
  border:.5px solid #fff;
  background:#4facff;
  border-radius:10px;
  box-shadow:0px 0px 10px #000;
}
.login-form h3,p{
  text-align:left;
  margin-left:40px;
  color:#fff;
}
.login-form {
  box-sizing:border-box;
  padding-top:15px;
	padding-bottom:10%;
  margin:5% auto;
  text-align:center;
}
.login input[type="text"],input[type="email"],input[type="number"],input[type="password"],.sel,input[type="date"]{
  max-width:400px;
	width: 80%;
  line-height:3em;
  font-family: 'Ubuntu', sans-serif;
  margin:1em 2em;
  border-radius:5px;
  border:2px solid #f2f2f2;
  outline:none;
  padding-left:10px;
}

.login .sel{
  max-width:400px;
  width: 80%;
  line-height:3em;
  font-family: 'Ubuntu', sans-serif;
  margin:1em 2em;
  border-radius:5px;
  border:2px solid #f2f2f2;
  outline:none;
  padding-left:10px;
}
.login-form input[type="submit"] {
  height:30px;
  width:100px;
  background:#fff;
  border:1px solid #f2f2f2;
  border-radius:20px;
  color: slategrey;
  text-transform:uppercase;
  font-family: 'Ubuntu', sans-serif;
  cursor:pointer;
}
.login-form input[type="submit"]:hover{
  cursor: pointer;
  background: #ffc107;     
  color: #000;
}
.login-form a{
  text-decoration: none;
  font-size: 12px;
  line-height: 20px;
  color: darkgray;

}
.login-form a:hover{
  color: #00ff00;
}
/*Media Querie*/
@media only screen and (min-width : 150px) and (max-width : 530px){
  .login-form h3,p {
    text-align:center;
    margin:0;
  }
  
  .sign-up a{
           text-align:center;
    margin:0;
  }
  .sign-up{
    margin:10px 0;
  }
  .login-button {
    margin-bottom:10px;
  }
}
	</style>
</head>
<body>
	<link href='https://fonts.googleapis.com/css?family=Ubuntu:500' rel='stylesheet' type='text/css'>

<div class="login">
  <div class="login-header">
    <h2>Register Here</h2>
  </div>
<form  action="save" method="post" id="userlogin" >
  <div class="login-form">
    <table align="center">

<tr>
<td>Name</td>
<td><input type="text" name="name" id="name" placeholder="Enter Your Name"  /></td>
</tr>
<tr>
              <td>Date Of Birth</td>
              <td><input type="date" name="dob" id="dob" placeholder="DD/MM/YYYY" /></td>
            </tr>
<tr>
<td>Gender</td>
<td>
<select name="gender" id="gender" class="sel">
<option value="">Select Your Gender</option>
<option value="female">Female</option>
<option value="male">Male</option>
<option value="other">Other</option>
</select>
</td>
</tr>
<tr>
      <!--         <td>Father's Name</td>
              <td><input type="text" name="father_name" id="father_name" placeholder="Enter Your Father's Name"/></td>
            </tr>
            <tr>
              <td>Mother's Name</td>
              <td><input type="text" name="mother_name" id="mother's_name" placeholder="Enter Your Mother's Name"/></td>
            </tr>    -->


<tr>
<td>Address</td>
<td><input type="text" name="address" id="address" placeholder="Enter Your Address"/></td>
</tr>
<tr>
<td>City</td>
<td><input type="text" name="city" id="city" placeholder="Enter Your City"/></td>
</tr>
<tr>
<td>State</td>
<td><input type="text" name="state" id="state" placeholder="Enter Your State"/></td>
</tr>
<tr>
<td>Pincode</td>
<td><input type="text" name="pincode" id="pincode" placeholder="Enter Your Adress's Pincode"  maxlength=6 /></td>
</tr>
<tr>
<td>Contact No</td>
<td><input type="text" name="contact_no"  id="contact" placeholder="Enter Your Contact Number" maxlength=10/></td>
</tr>
<tr>
<td>Email Id</td>
<td><input type="email" name="email" id="email" placeholder="Enter Your Valid Email ID"/></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password" id="password" placeholder="Enter Your Password"/></td>
</tr>
<tr>
              <td>Register as</td>
              <td><select name="role_type" id="role_type" class="sel">
              <option value="">Select Your Role Type</option>
              <option value="Admin">Admin</option>
              <option value="Faculty">Faculty</option>
              <option value="Student">Student</option>
              </select>
              </td>
            </tr>

            <tr>
              <td>Course</td>
              <td>
             <select   name="course" class="sel" id="course">
   			<option value="">Select Course</option>
       <c:forEach var="f" items="${course}">
        	<option value="${f.getCourse_name()}">${f.getCourse_name()}</option>
    </c:forEach>
     </select>
              </td>
              </tr>
              
            <tr>
              <td> Branch</td>
              <td><select name="branch" id="branch" class="sel">
              <option value="">Select Branch</option>
              <c:forEach var="f" items="${branch}">
        	  <option value="${f.getBranch_name()}">${f.getBranch_name()}</option>
               </c:forEach>
               </select>
              </td>
            </tr>
            <tr>
              <td> Specialisation</td>
              <td><select name="specialisation" id="specialisation" class="sel">
              <option value="null">Select Specialisation</option>
              <c:forEach var="f" items="${branch}">
        	  <option value="${f.getSpecialisation()}">${f.getSpecialisation()}</option>
               </c:forEach>
               </select>
              </td>
            </tr>
            
            <tr>
				<td>Admission Year</td>
				<td><input type="text" name="admission_year" id="admission_year" placeholder="Enter Your Admission Year"/></td>
			</tr>
            
            
            	<tr id="semester">
						<td>Semester</td>
             			<td><select name="semester" class="sel">
              			<option value="">Select Semester</option>
              			<option value="1">I</option>
              			<option value="2">II</option>
              			<option value="3">III</option>
              			<option value="4">IV</option>
              			<option value="5">V</option>
              			<option value="6">VI</option>
              			<option value="7">VII</option>
              			<option value="8">VIII</option>
              			</select>
              			</td>
            	</tr>
      
 			      <tr id="section">
              		<td>Section</td>
              		<td><select name="section" class="sel">
              		<option value="">Select Your Section</option>
              		<option value="a">A</option>
              		<option value="b">B</option>
              			</select>
              		</td>
            	</tr>

				<tr id="faculty_name">
				<td>Select Faculty </td>
					<td><select name="faculty_name" class="sel">
					<option value="">Select Faculty</option>
						<c:forEach var="f" items="${faculty}">
							<option value="${f.name}">${f.getName()}</option>
						</c:forEach>
						</select></td>
				</tr>


            <tr >

              <td>Security Question</td>
              <td><select name="security_question" id="security_question" class="sel" >
              <option value="">Select Security Question</option>
              <option value="favourite_colour">What is your Favourite Colour</option>
              <option value="mother's_maiden">What is your Mother's maiden Name</option>
              <option value="pet_name">What is your First Pet's Name</option>
              <option value="Vehical_no">What is your First Vehical's Number</option>
              </select>
              </td>
            </tr>

            <tr>
              <td>Security Answer</td>
              <td><input type="text" name="security_answer" id="ans" placeholder="Enter Your Security Answer"/></td>
            </tr>
</table>
<input type="submit" name="submit" value="submit" class="submit" />

  </div>
  </form>
</div>
<script type="text/javascript">
$(document).ready(function(){
  $(".submit").click(function() {
    if($("#name").val() == '') {
      alert("Please enter your Name");
      $("#name").focus();
      return false;
    }
    if($("#name").val() != ''){
    if($("#name").val().length <=3){
    alert('Please enter your Full Name');
    $("#name").focus();
    return false;
    }
    }
    if($("#dob").val() == '') {
      alert("Please enter your Date of Birth ");
      $("#dob").focus();
      return false;
    } 
    if($("#gender").val() == '') {
      alert("Please Select your Gender");
      $("#gender").focus();
      return false;
    } 
    if($("#address").val() == '') {
      alert("Please enter your Address");
      $("#address").focus();
      return false;
    } 
    if($("#city").val() == '') {
      alert("Please enter your City");
      $("#city").focus();
      return false;
    } 
    if($("#state").val() == '') {
      alert("Please enter your State");
      $("#state").focus();
      return false;
    } 
    if($("#pincode").val() == '') {
      alert("Please enter your City Pincode");
      $("#pincode").focus();
      return false;
    } 
    if(isNaN($("#pincode").val())){
    alert('Please Enter Your valid City Pincode');
    $("#pincode").focus();
    return false;
    }
if($("#pincode").val() != ''){
    if($("#pincode").val().length <6){
    alert('Enter your 6 digit City Pincode');
    $("#pincode").focus();
    return false;
    }
    }
    if($("#contact").val() == '') {
      alert("Please enter Contact Number");
      $("#contact").focus();
      return false;
    } 
    if(isNaN($("#contact").val())){
    alert("Please Enter Your Valid Contact Number");
    $("#contact").focus();
    return false;
    }
if($("#contact").val() != ''){
    if($("#contact").val().length <10){
    alert('Enter your 10 digit Contact Number');
    $("#contact").focus();
    return false;
    }
    }
    if($("#email").val() == '') {
      alert("Please enter your Valid Email id");
      $("#email").focus();
      return false;
    } 
    if($("#email").val() != '') {
      if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,6})+$/.test($("#email").val())){
      alert("Please enter your correct Email id");
      $("#email").focus();
      return false;
    } }
    if($("#password").val() == '') {
      alert("Please enter your password");
      $("#password").focus();
      return false;
    } 
    if($("#password").val() != '') {
      if(!/^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z])[a-zA-Z0-9!@#$%^&*]{7,15}$/.test($("#password").val())){
      alert("6 to 20 characters which contain at least one numeric digit, one uppercase and one lowercase letter and one Special character");
      $("#password").focus();
      return false;
    } }
    if ($("#role_type").val()=='') {
      alert("Plese select your role type");
      $("#role_type").focus();
      return false;
    }
    if ($("#security_question").val()=='') {
      alert("Plese select your Security Question");
      $("#security_question").focus();
      return false;
    }

    if ($("#ans").val()=='') {
      alert("Plese enter your Answer");
      $("#ans").focus();
      return false;
    }

   
  else {
      $("#userlogin").submit();
    }
  });

  $('#course').change(function(){

         alert($(this).val());
	  });
});
</script>
</body>
</html>