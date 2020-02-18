<template>
  <div id="manager">
	<body>
		<div class="sidenav">
			<div id="navContent">
				<img id="userimg" src="static/ben.jpg" alt="Profile Image">
				<h3 id="username">Ben</h3>
				<div id="links">
					<a href="#/manager/viewinfo"><b>All Sessions</b></a><br>
          <a href="#/manager/tutor"><b>All Tutors</b></a><br>
					<a href="#"><b>All Students</b></a><br>
					<a href="#"><b>All Evaluations</b></a><br>
                    <a href="#/login"><b>Log Out</b></a>
				</div>
			</div>
			<div id="logo">
			<img src="static/blueLogo.png" alt="Logo" style="width:50px;height:50px;">
			</div>
		</div>
		<router-view></router-view>
	</body>
  </div>
</template>

<script>

</script>

<style scoped>
	body {
  background-color: #29478E;
  font-family: PT Sans, Helvetica, sans-serif;
}
h1 {
	color: white;
	padding-top: 8px;
}
table {
	border-spacing: 20px;
}
td {
	/**background-color: white;
	border-radius: 40px 40px 40px 40px;
	height: 300px;
	width: 100px;**/
}
button {
	background-color: white;
	border-radius: 40px 40px 40px 40px;
	height: 300px;
	width: 290px;
}
#userimg {
	height: 100px;
	width: 100px;
	border-radius: 80px 80px 80px 80px;
	border-style: solid;
	border-width: 2px;
	border-color: #29478E;
	text-align: center;
	display: block;
  	margin-left: auto;
  	margin-right: auto;
}
#logo {
	padding-top: 105%;
	padding-left: 5%;
}
.sidenav {
  height: 100%; /* Full-height: remove this if you want "auto" height */
  width: 20%; /* Set the width of the sidebar */
  position: fixed; /* Fixed Sidebar (stay in place on scroll) */
  z-index: 1; /* Stay on top */
  top: 0; /* Stay at the top */
  left: 0;
  background-color: white;
  opacity: 0.75;
  overflow-x: hidden; /* Disable horizontal scroll */
  padding-top: 20px;
}
h3 {
	text-align: center;
	opacity: 0.75;
}
#navContent {
	padding-top: 50px;
}
#links{
	text-align: center;
}
a {
	color: black;
	text-decoration: none;
}
.main {
  margin-left: 20%; /* Same as the width of the sidebar */
  padding: 0px 10px;
  padding-left: 30px;
}
input {
	border-radius: 40px 40px 40px 40px;
	height: 35px;
	width: 285px;
	border: none;
	background-color: white;
}

</style>
