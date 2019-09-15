<!DOCTYPE html>
<html>
<head>
	<title></title>
	<style type="text/css">
		body {
  background:url('http://cdn.wallpapersafari.com/13/6/Mpsg2b.jpg');
  height: 100vh;
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
  font-size:200%;
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
.login input[type="text"],input[type="email"],input[type="password"],.sel {
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
    <h1>Forgot Password</h1>
  </div>
  <form action="forgot_password" method="post">
  <div class="login-form">
    <h3>Email:</h3>
    <input type="email" placeholder="Email" name="email"/><br>
    
     <h3>Security Question</h3>
              <select name="security_question" id="security_question" class="sel" >
              <option value="">Select Security Question</option>
              <option value="favourite_colour">What is your Favourite Colour</option>
              <option value="mother's_maiden">What is your Mother's maiden Name</option>
              <option value="pet_name">What is your First Pet's Name</option>
              <option value="Vehical_no">What is your First Vehical's Number</option>
              </select>
              
    
    
    
    <h3>Security Answer:</h3>
    <input type="text" placeholder="Answer" name="security_answer"/>
    <br>
    <input type="submit" value="Reset" class="login-button"/>
    <br>
   <p>New User? <a href="registration" >Register Here</a></p>
    <br>
    
  
  </div>
  </form>
</div>
</body>
</html>