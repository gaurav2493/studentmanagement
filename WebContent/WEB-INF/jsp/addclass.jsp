<center>
	<h1>Enter new Class Detail</h1>
</center>
<form action='submit_new_class' method='post'>
	<table class="table table-striped">
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