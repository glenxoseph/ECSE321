<template>
<div id="login">
	<body>
		<div id="content">
			<div id="left">
				<img id="logo" src="/static/whiteLogo.png" alt="Logo" style="width:270px;height:305px;">
				<div class="leftText">
					<p id="leftTitle"><b>Student Tutoring<br>Service</b></p>
					<p id="leftPar">
						Any student looking for a tutor<br>in any subject at the high school,<br>CEGEP, and university levels can use<br>Student Tutoring service to help<br>them find an amazing tutor.
					</p>
				</div>
			</div>			
			<div id="right">
				<form>
					<b>Username</b>
					<br><br>
					<input name="username" type="text"></input>
					<br><br>
					<b>Password</b>
					<br><br>
					<input name="password" type="text"></input>
					<br><br><br>
				    <button class="sign" id="signup" type="button" onclick="window.location.href='/#/signup'">Sign up</button><br>
				    <button class="sign" type="button" onclick="window.location.href='/#/manager/home'">Sign in</button>
				</form>
			</div>
		</div>
	</body>
</div>
</template>

<script>
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
body {
  background-color: #29478E;
  font-family: Arial, Helvetica, sans-serif;
}
.leftText {
	color: white;
	float: right;
	padding-top: 200px;
}

#logo {
	float: left;
}
#leftPar {
	font-size: 20px;
	opacity: 0.75;
}
#leftTitle {
	font-size: 44px;
}
#left {
	float: left;
	width: 60%;
}
#right {
	background-color: lightgrey;
	opacity: 0.75;
	float: right;
	padding: 50px;
	width: 35%;
	border-radius: 40px 40px 40px 40px;
}
#content {
	padding-right: 100px;
	padding-left: 100px;
	padding-top: 30px;
	padding-bottom: 30px;
}
#signup {
	background-color: #113285;
	color: white;
}
.sign {
	border-radius: 40px 40px 40px 40px;
	width: 285px;
	height: 35px;
	background-color: white;
	color: #113285;
	border: none;
	transition-duration: 0.4s;
}
.sign:hover {
	opacity: 0.5;
}

input {
	border-radius: 40px 40px 40px 40px;
	height: 35px;
	width: 285px;
	border: none;
	background-color: white;
}
</style>
