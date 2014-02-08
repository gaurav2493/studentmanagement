<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	<sec:authorize access="isAnonymous()">
    <h2>Members</h2>
    <form class="form-signin" role="form" action='<c:url value='j_spring_security_check' />' method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input name="j_username" type="text" class="form-control" placeholder="Email address" required autofocus><br/>
        <input name="j_password" type="password" class="form-control" placeholder="Password" required>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
      
      <c:if test="${not empty error}">
		<div><font color="red"><br/>
			Invalid username or password</font>
		</div>
	</c:if>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
                <font size=3>
              	<ul class="nav nav-stacked" id="sidebar">
                  <li><a href="selectattendence">Attendence</a></li>
                  <li><a href="#sec2">Reports</a></li>
                  <li><a href="#sec3">Fee Schedules</a></li>
                  <li><a href="addstudent">Add a Student</a></li>
              	  <li><a href="adduser">Add a User</a></li>
              	  <li><a href="addclass">Add a class</a></li>
              	  <li><a href="addsubject">Add a Subject</a></li>
                  <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
              	</ul>
              	</font>
</sec:authorize>