<template>
	<div id="managerHome">
		<div class="main">
			<h1>Search for Courses/Tutors/Sessions</h1>
			<form>
				<input name="Search" type="text">
			</form>
			<h1>Requests</h1>
			<table style="width:100%">
			  <tr>
                <td><button class="item" type="button">Review Session<br /><br /><br />ECSE202 (Intro to software development)<br />Drew Keller,Brad Rose(are attending)</button></td>
			    <td><button class="item" type="button" onclick="window.location.href='/#/manager/assignroom'">Review Session<br /><br /><br />ECSE321 (Intro to software engineering)<br />George Brown,Taylor<br />Franck(are attending)</button></td>
			    <td><button class="item" type="button">Review Session<br /><br /><br />ECSE429 (Software Validation)<br />Louis,Daniel Varro,<br />Jack Wei(are attending)</button></td>
			  </tr>
			  <tr>
			    <td><button class="item" type="button">Review Session<br /><br /><br />ECSE420 (Parallel Computing)<br />Dennis Giannacopoulos<br />White,Bob Green(are attending)</button></td>
			    <td><button class="item" type="button">Review Session<br /><br /><br />ECSE205 (Probability and Statistics for Engineers)<br />Harry Leib,Tommy(are attending)</button></td>

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
