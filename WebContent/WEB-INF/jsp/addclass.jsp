<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br />
<br />
<script type="text/javascript">
	function createSubjectFields() {
		var n = document.getElementById("nosubjects").value;
		document.getElementById("hid1").value=n;
		var i;
		var subfields="<table class='table table-striped'>";
		for (i = 0; i < n; i++) {
			subfields+="<tr><td>Subject - "+(i+1)+"</td><td><input type='text' name='sub"+i+"' class='form-control' placeholder='Subject name'/></td></tr>";
		}
		subfields+="</table>";
		document.getElementById("subject-fields").innerHTML=subfields;	
		document.getElementById("div1").style.display='block'
	}
	function createStudentFields() {
		var n = document.getElementById("nostudents").value;
		document.getElementById("hid0").value=n;
		var i;
		var subfields="<table class='table table-striped'>";
		for (i = 0; i < n; i++) {
			subfields+="<tr><td>Student - "+(i+1)+"</td><td><input type='text' name='stu"+i+"' class='form-control' placeholder='Roll number'/></td></tr>";
		}
		subfields+="</table>";
		document.getElementById("roll-fields").innerHTML=subfields;
		document.getElementById("div2").style.display='block'
	}
</script>
<form action='submit_new_class' method='post'>

	<div class="panel panel-default">
		<div class="panel-heading">Enter new Class Detail</div>
		<div class="panel-body">
			<table class="table table-striped">
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
				</tr>
				<tr>
					<td>Section</td>
					<td><select name="section" class="form-control">
							<option value='a'>A</option>
							<option value='b'>B</option>
					</select></td>
				</tr>
				<tr>
					<td>Year</td>
					<td><select name="year" class="form-control">
							<option value=1>1</option>
							<option value=2>2</option>
							<option value=3>3</option>
							<option value=4>4</option>
					</select></td>
				</tr>
				<tr>
					<td>Session</td>
					<td><div class="control-group">
							<div class="controls">
								<select name="session" class="form-control">
									<option value="${currentYear-1}">${currentYear-1} - ${currentYear}</option>
									<option value="${currentYear}">${currentYear} - ${currentYear+1}</option>
									<option value="${currentYear+1}">${currentYear+1} - ${currentYear+2}</option>
								</select>
							</div>
						</div></td>
				</tr>
				<tr>
					<td>Number of subjects</td>
					<td><input type="number" id="nosubjects"
						class="form-control" /></td>
					<td><input type="button" onclick="createSubjectFields()"
						value="Generete Fields" class="form-control" /></td>
				</tr>
				<tr>
					<td>No of students</td>
					<td><input type="number" id="nostudents"
						class="form-control" /></td>
					<td><input type="button" onclick="createStudentFields()"
						value="Generete Fields" class="form-control" /></td>
				</tr>
			</table>
		</div>
	</div>

	<div class="panel panel-default" style="display:none;" id='div1'>
		<div class="panel-heading">Enter new Subjects for this class</div>
		<div class="panel-body" id='subject-fields'></div>
	</div>

	<div class="panel panel-default" style="display:none;" id='div2'>
		<div class="panel-heading">Enter new Student's roll numbers</div>
		<div class="panel-body" id='roll-fields'></div>
	</div>
	<input type='hidden' name='nostudents' id='hid0'/>
	<input type='hidden' name='nosubjects' id='hid1'/>
	<Input type='submit' class="btn btn-default" />
</form>