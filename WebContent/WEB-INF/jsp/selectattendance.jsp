<h3>Choose Your Class</h3>
<br />
<form action="addattendance" method="post">
	<table class="table table-striped">
		<tr>
			<td>Session</td>
			<td><Select name="session" class="form-control">
					<option>Session</option>
					<option value='2012'>2012 - 2013</option>
					<option value='2013'>2013 - 2014</option>
			</Select></td>
		<tr>
			<td>Branch</td>
			<td><select name="branch" class="form-control">
					<option value='cse'>CSE</option>
					<option value='it'>IT</option>
					<option value='me'>ME</option>
					<option value='ce'>CE</option>
					<option value='ic'>IC</option>
					<option value='mt'>MT</option>
			</select></td>
		<tr>
			<td>Year</td>
			<td><select name="year" class="form-control">
					<option value=1>1</option>
					<option value=2>2</option>
					<option value=3>3</option>
					<option value=4>4</option>
			</select></td>
		<tr>
			<td>Section</td>
			<td><select name="section" class="form-control">
					<option value='a'>A</option>
					<option value='b'>B</option>
			</select></td>
		</tr>
		<tr>
			<td>Subject</td>
			<td><select name="subject" class="form-control">
					<option value='ECS-502'>ECS-502</option>
					<option value='ECS-501'>ECS-501</option>
			</select></td>
		</tr>
	</table>
	<input type="submit" class="btn btn-default">
</form>