<!DOCTYPE html>
<html>
<head>
	<title></title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<style type="text/css">
  body{
    background: url('http://cdn.wallpapersafari.com/13/6/Mpsg2b.jpg');
        height: 100vh;
    margin: 0;
    padding: 0;
    background-size: cover;
    background-position: center;
    font-family: sans-serif;

  }

/*========[#4CAF50]====*/
.loginbox{
             width:320px;
             height: 420px;
            background:#fc8c03;                                                             /* #fc9d03;         */
             color: #fff;
             top: 50%;
             left:50%;
             position: absolute;
             transform: translate(-50%,-50%);
             box-sizing: border-box;
             padding: 70px 30px;
           }
 .avatar{
           
           height: 100px;
           border-radius: 8%;
           position: absolute;
           top: -50px;
           left: calc(35% - 50px);



}


 h1{
     margin: 0;
     padding: 0 0 20px;
     text-align: center;
     font-size: 22px;
}

.loginbox p{
      margin: 0;
      padding: 0;
      font-weight: bold;
}
 .loginbox input{
      width: 100%;
      margin-bottom: 20px;


 }    
 .loginbox input[type="email"], input[type="password"] {
          border: none;
          border-bottom: 1px solid #fff;
          background: transparent;
          outline: none;
          height: 40px;
          color: #000;
          font-size: 16px;
 }  
.loginbox input[type="submit"]{
  border: none;
  outline: none;
  height: 40px;
  background: #fb2525;
  color: #fff;
  font-size: 18px;
  border-radius: 20px;
}
.loginbox input[type="submit"]:hover{
  cursor: pointer;
  background: #ffc107;
  color: #000;
}
.loginbox a{
  text-decoration: none;
  font-size: 12px;
  line-height: 20px;
  color:#5e03fc;

}
.loginbox a:hover{
  color: #ffc107;
}
</style>
</head>
<body>
	<link href='https://fonts.googleapis.com/css?family=Ubuntu:500' rel='stylesheet' type='text/css'>
	

<div class="loginbox">
<img src="/College_Management/resources/image/download.png" class="avatar" style="width:200px" />
         <h1>Login Here</h1> 
      <form  action="login" method="POST" id="userlogin">   
          
         <p>Email</p>
      
        <input type="email" name="email" placeholder="Enter Your Email" id="email">
        <p>Password</p>    
        <input type="password" name="password" placeholder="Enter Your Password" id="password">
        <input type="submit" name="submit" value="submit">
   <p class="message">Not Registered?<a href="registration">Register Here</a></p>
   <p class="message">Forgot Password?<a href="forgot">Forgot Password</a></p>  
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


