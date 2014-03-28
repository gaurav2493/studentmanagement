<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>${notice.getSubject()}</h3>
<br />
<br />

<p align="justify">
	<font size=2>${notice.getNotice() }</font>
</p>
<br />
<br />
<p align="right">
	<font size=3><strong>${notice.getAuthor() }<br />${notice.getDate()
			}
	</strong></font>
</p>
<c:choose>
	<c:when test="${notice.isAttachment() }">
		<h3 align="center">Attachments</h3>
		<c:forEach var="entry" items="${notice.getAttachmentMap() }">
			<a href='<c:url value="/notice/downloadfile" />?sequence_no=${entry.getValue() }&notice_id=${notice.getNotice_id()}'>${entry.getKey() }</a><br/>
		</c:forEach>
	</c:when>
</c:choose>
