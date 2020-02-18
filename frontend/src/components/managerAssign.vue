<template>
	<div class="managerAssign">
		<div class="main">
			<h1 id="Sessionid">Review Session #127654</h1>
			<table style="width:100%">
			  <tr>
<td><button class="item" type="button">Course:ECSE321<br /><br />Intro to software development<br />Offered by:Andrew Nguyen ,lan Laffey</button></td>
			    <td><button class="item" type="button">Students<br /><br /><br />George Brown<br />Taylor<br />Franck</button></td>
			  </tr>
			</table>
			<h2 id="searchTutor">Search for Tutor</h2>
			<form>
				<input name="Search" type="text">
			</form>
			<h2>Assign Time & Room</h2>
			<table style="width:100%">
			  <tr>
			    <td><input list="date" name="date" value="Nov 15th"></td>
				<td><input list="time" name="time" value="9:00am"></td>
				<td><input list="room" name="room" value="1101"></td>
			  </tr>
			</table>
			<datalist id="date">
			 	<option value="Nov 12th"></option>
				<option value="Nov 13th"></option>
				<option value="Nov 14th"></option>
			</datalist>
			<datalist id="room">
			 	<option value="1101"></option>
				<option value="1102"></option>
				<option value="1103"></option>
			</datalist>
			<datalist id="time">
			 	<option value="9:00"></option>
				<option value="9:30"></option>
				<option value="10:00"></option>
			</datalist>
			<div id="cButton">
			<button id="confirm" type="button" onclick="window.location.href='/#/manager/home2'"><b>Confirm</b></button>
			</div>
		  </div>
	</div>
</template>

<script>

</script>

<style scoped>


h3 {
  text-align: center;
  opacity: 0.75;
}
.main {
  margin-left: 20%; /* Same as the width of the sidebar */
  padding: 0px 10px;
  padding-left: 30px;
}
#links{
  text-align: center;
}
#navContent {
  padding-top: 50px;
}
a {
  color: black;
  text-decoration: none;
}
#logo {
  padding-top: 260px;
  padding-left: 20px;
}
h1 {
  color: white;
  padding-top: 8px;
}
h2 {
  color: white;
  padding-left: 30px;
}
input {
  border-radius: 40px 40px 40px 40px;
  height: 35px;
  width: 255px;
  border: none;
  background-color: white;
  padding-left: 40px;
}
.item {
  background-color: white;
  border-radius: 20px 20px 20px 20px;
  height: 200px;
  width: 90%;
  border: none;
  opacity: 0.75;
}
td {
  height: 10%;
}

#confirm {
  border-radius: 40px 40px 40px 40px;
  height: 35px;
  width: 285px;
  border: none;
  background-color: white;
  color: #29478E;

}
#cButton {
  padding-left: 70%;
  padding-top: 4%;
}

</style>
