<!DOCTYPE html>
<html>
<head>
	<title></title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
.login input[type="text"],input[type="email"],
.login input[type="password"] {
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
    <h1>Login</h1>
  </div>
  <form action="login" method="post" id="userlogin">
  <div class="login-form">
    <h3>Email:</h3>
    <input type="email" placeholder="Email" name="email" id="email" /><br>
    <h3>Password:</h3>
    <input type="password" placeholder="Password" name="password" id="password" />
    <br>
    <input type="submit" value="Login" class="login-button" id="submit" />
    <br>
   <p>New User? <a href="registration" >Register Here</a></p>
    <br>
    <p>Forgot Password?<a href="forgot  ">Reset Password</a></p>
    <br>
  
  </div>
  </form>
</div>
<script type="text/javascript">
$(document).ready(function(){
  $("#submit").click(function() {
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



    else {
      $("#userlogin").submit();
    }
  });
});
</script>
</body>
</html>


