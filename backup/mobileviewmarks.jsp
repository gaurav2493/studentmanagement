<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>${callback}('{  "marks": [  <c:forEach var="entry" items="${marksList}">  { "name": "<c:out value="${entry.getSubjectName()}" />", "count": "<c:out value="${entry.getMarks()}" />", "total": "<c:out value="${entry.getTotal()}" />"   },</c:forEach>   { "name": "Dummy",  "count": "100", "total": "100"  }  ] }');

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>{
  "marks": [
  <c:forEach var="entry" items="${marksList}">
      {
        "name": "<c:out value="${entry.getSubjectName()}" />",
        "count": "<c:out value="${entry.getMarks()}" />",
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