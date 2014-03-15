<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>{
  "attendance": {
  <c:forEach var="entry" items="${subjectAttendanceList}">
  "subject": [
      {
        "name": "<c:out value="${entry.getSubjectName()}" />",
        "count": "<c:out value="${entry.getCount()}" />",
        "total": "<c:out value="${entry.getTotal()}" />"
      },
	</c:forEach>
    "subject": [
      {
        "name": "Dummy",
        "count": "100",
        "total": "100"
      }
    ]
  }
}