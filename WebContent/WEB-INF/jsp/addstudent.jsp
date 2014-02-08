<center>
	<h1>Enter new student detail</h1>
</center>
<form action='submit_new_student' method='post'>
	<table class="table table-striped">
		<tr>
			<td>Name</td>
			<td><input type='text' name='name' class="form-control" /></td>
		</tr>
		<tr>
			<td>Roll no</td>
			<td><input type='text' name='rollno' class="form-control" /></td>
		</tr>
		<tr>
			<td>Father's name</td>
			<td><input type='text' name='fname' class="form-control"/></td>
		</tr>
		<tr>
			<td>Mother's name</td>
			<td><input type='text' name='mname' class="form-control"/></td>
		</tr>
		<tr>
			<td>Email Id</td>
			<td><input type='email' name='email' class="form-control" /></td>
		</tr>
		<tr>
			<td>Parent's Email Id</td>
			<td><input type='email' name='pemail' class="form-control" /></td>
		</tr>
		<tr>
			<td>Course</td>
			<td><input type='text' name='course' class="form-control"/></td>
		</tr>
		<tr>
			<td>Branch</td>
			<td><input type='text' name='branch' class="form-control"/></td>
		</tr>
		<tr>
			<td>Section</td>
			<td><input type='text' name='section' class="form-control"/></td>
		</tr>
		<tr>
			<td>Year</td>
			<td><input type='text' name='year' class="form-control"/></td>
		</tr>
		<tr>
			<td>Session</td>
			<td><div class="control-group">
            <div class="controls">
            <select name="session">
                <option value="2011">2011 - 2012</option>
                <option value="2012">2012 - 2013</option>
                <option value="2013">2013 - 2014</option>
                <option value="2013">2014 - 2015</option>
                <option value="2013">2015 - 2016</option>
            </select>
        </div>
        </div></td>
		</tr>
	</table>
	<Input type='submit'  class="btn btn-default"/>
</form>