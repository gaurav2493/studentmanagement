var serverAddress="http://192.168.1.4:9080/serverApp";

var authentication=serverAddress+"/login?user=";
var attendance=serverAddress+"/jsonp/getjsonattendance?callback=JSONRetrive&session=";
var examType=serverAddress+"/jsonp/getexamtypes?callback=examTypesFunction";
var marksSubject=serverAddress+"/jsonp/getmarks?callback=marksFunction&";
var viewnoticeurl=serverAddress+"/jsonp/viewnotices?pageno=1&callback=viewNotice";
var viewsinglenoticeurl=serverAddress+"/jsonp/viewnotice?callback=view_single_notice&notice_id=";
var examscheduleurl="";
var showmorebuttonurl=serverAddress+"/jsonp/viewnotices?";
var viewfileurl=serverAddress+"/jsonp/viewnotices?pageno=1&callback=viewFiles";
var viewsinglefileeurl=serverAddress+"/jsonp/viewnotice?notice_id=20&callback=view_single_notice";