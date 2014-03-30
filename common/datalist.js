function callme()
{
/*
	url="http://120.59.131.187:9080/serverApp/ajax/getrollno?count=3&start=1";
	
	 $.ajax({
	 url: "http://120.59.131.187:9080/serverApp/ajax/getrollno?count=3&start=1",
	 context: document.body
	}).done(function() {
	 $( this ).addClass( "done" );
	});
	
	*/
	DataList dl = new DataList();
	dl.DataSource = from n in context.Projects  select n;//Data from DB 
	dl.DataBind();
	panel1.Controls.Add(dl);
	
	alert("helo");
}