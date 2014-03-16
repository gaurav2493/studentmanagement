<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>{
  "subject": [
  <c:forEach var="entry" items="${subjectAttendanceList}">
      {
        "name": "<c:out value="${entry.getSubjectName()}" />",
        "count": "<c:out value="${entry.getCount()}" />",
        "total": "<c:out value="${entry.getTotal()}" />"
      },
	</c:forEach>
      {
        "name": "Dummy",
        "count": "100",
        "total": "100"
      }
    ]
  }