<template>
	<div id="tutor">
		<div class="main">
			<h1>All Tutors</h1>
			<table style="width:100%">
			  <tr>
			    <td><button class="item" type="button" onclick="window.location.href='#/manager/MaxMin'"><p><b>Tutor</b><br>Bill Clark<br>9.0/10<br>ECSE 321 offering</p></button></td>
			    <td><button class="item" type="button"><p><b>Tutor</b><br>Mark Adams<br>8.7/10<br>ECSE 202 offering</p></button></td>
			    <td><button class="item" type="button"><p><b>Tutor</b><br>Susan Black<br>9.1/10<br>CEGEP Maths offering</p></button></td>
			  </tr>
			</table>
		</div>
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
	border-spacing: 100px;
}
td {

    	padding: 12px 12px 12px 12px;
}
button {
	background-color: white;
	border-radius: 15px 15px 15px 15px;
	height: 250px;
	width: 100%;
	border: none;
	opacity: 0.85;
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
	padding-top: 260px;
	padding-left: 20px;
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
