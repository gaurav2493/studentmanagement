<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>{
  "examList": [
<c:forEach var="entry" items="${examTypes}">
  {"exam_id" : "<c:out value="${entry.key}"/>", "exam_name" : "<c:out value="${entry.value}"/>",
  },
</c:forEach>
  {"exam_id" : "-1",
   "exam_name" : "n",
  }
 ]
}