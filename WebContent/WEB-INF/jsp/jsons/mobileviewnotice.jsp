<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>${callback}('{ "viewnotice2": [ { "notice_id": "${notice.getNotice_id() }", "author":"${notice.getAuthor() }", "timestamp": "${notice.getDate() }", "subject": "${notice.getSubject() }","notice":"${notice.getNotice() }","attachment":"${notice.isAttachment()}","fileurl":[<c:forEach var="entry" items="${notice.getAttachmentMap()}">{"filename":"${entry.getKey()}","url":"/notice/downloadfile?sequence_no=${entry.getValue() }&notice_id=${notice.getNotice_id()}" },</c:forEach>{"filename":"","url":""}] } ]}');