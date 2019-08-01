$(document).ready(function(){
	$("#searchByEmail").show();
	$("#searchByDesignation").show();
	$("#sEmail").show();
	$("#sDesignation").show();
	$("#logout").show();
	$("#welcomeDiv").append("<h1>Welcome You are logged In</h1>");
	$("#sEmail").click(function(){
			var emailData=
			{
				"email":$("#searchByEmail").val()
			}
			$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/searchEmail",
			data : JSON.stringify(emailData),
			dataType : 'json',
			success : function(result) {
				if (result.status == "success") {
						$("#Res1").html("");
						$("#Res1").append("EmpId:"+result.data.empId+"<br>"+"EmpName:"+result.data.firstName+" "+result.data.lastName);
						}
				else
					 $("#Res1").append("NO SUCH Employee exists with GIVEN Email Address");
						}
			});
	});
	

});								
								
							