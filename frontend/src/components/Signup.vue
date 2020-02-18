<template>
<div id="signup">
<body>
		<div id="content">
			<div id="left">
				<div id="logo">
					<img src="static/whiteLogo.png" alt="Logo" style="width:270px;height:270px;">
				</div>
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
					<input name="username" type="text">
					<br><br>
					<b>Password</b>
					<br><br>
					<input name="password" type="text">
					<br><br>
					<b>I am a ...</b>
					<br><br>
					<button class="role" type="button"></button>Student<button class="role" type="button"></button>Tutor<button class="role" type="button"></button>Manager
					<br><br>
					<b>School</b>
					<br><br>
					<input list="schools" name="school">
					<br><br><br>
				    <datalist id="schools">
					    <option value="McGill University"></option>
					    <option value="Concordia University"></option>
					    <option value="UQAM"></option>
				    </datalist>
				    <button class="sign" id="signup" type="button" onclick="window.location.href='/#/login'">Sign up</button><br>
				    <button class="sign" type="button" onclick="window.location.href='/#/login'">Cancel</button>
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
  font-family: PT Sans, Helvetica, sans-serif;
}
.leftText {
	color: white;
	float: right;
	padding-top: 100px;
	
}

#logo {
	float: left;
}
#leftPar {
	font-size: 20px;
	opacity: 0.75;
	float: right;
}
#leftTitle {
	padding-top: 100px;

	font-size: 44px;
}
#left {
	color: white;
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
	opacity: 0.8;
}
.role {
	border-radius: 40px 40px 40px 40px;
	height: 30px;
	width: 30px;
	border: none;
	background-color: white;
	transition-duration: 0.4s;
}
.role:hover {
	background-color: #113285;
}
input {
	border-radius: 40px 40px 40px 40px;
	height: 35px;
	width: 285px;
	border: none;
	background-color: white;
}
</style>
