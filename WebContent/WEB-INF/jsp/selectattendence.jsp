<h3>Choose Your Class</h3><br/>
<form action="addattendence" method="get">
	<Select name="session" class="form-control">
		<option>Session</option>
		<option value='2012'>2012 - 2013</option>
		<option value='2013'>2013 - 2014</option>
	</Select>
	<select name="branch" class="form-control">
		<option value='cse'>CSE</option>
		<option value='it'>IT</option>
		<option value='me'>ME</option>
		<option value='ce'>CE</option>
		<option value='ic'>IC</option>
		<option value='mt'>MT</option>
	</select>
	<select name="year" class="form-control">
		<option value=1>1</option>
		<option value=2>2</option>
		<option value=3>3</option>
		<option value=4>4</option>
	</select>
	<select name="class" class="form-control">
		<option value='a'>A</option>
		<option value='b'>B</option>
	</select>
	<input type="submit" class="form-control">
</form>