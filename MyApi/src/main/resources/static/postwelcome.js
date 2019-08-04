$(document).ready(function(){
	$("#searchByEmail").show();
	$("#searchByDesignation").show();
	$("#sEmail").show();
	$("#sDesignation").show();
	$("#logout").show();
	//$("#welcomeDiv").append("<h1>Welcome You are logged In</h1>");
	$("#sidePanel").click(function(){
		
		$("#sidePanel").hide();
		$("#leftPanel").show();
		$("#change").click(function(){
			var passwordData={
					"old":$("#old").val();
					"new":$("#new").val();
			}
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/changePwd",
				data : JSON.stringify(passwordData),
				dataType : 'json',
				success : function(result) {
					if (result.status == "success") {
							$("#Pwd_change_result").html("");
							$("#Pwd_change_result").append("Your Password has been Updated Successfully");
							}
					else
						$("#Pwd_change_result").append("Incorrect Password Plaese Try Again");
					$("#left_panel").hide();
					$("#sidePanel").show();
							}
				});
		});
		
		
	});
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
	$("#sDesignation").click(function(){
		var designationData=
		{
			"designation":$("#searchByDesignation").val()
		}
		console.log(designationData);
		$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/searchDesignation",
		data : JSON.stringify(designationData),
		dataType : 'json',
		success : function(result) {
			if (result.status == "success") {
				$("#Res2").html("");
						$.each(result.data,function(index,item)
								{
								$.each(item,function(key,value){
									$("#Res2").append(key+": "+value+"<br/>");
								});	
								$("#Res2").append("************************************"+"<br/>");
								}
							);
					}
			else
				 $("#Res2").append("NO SUCH Employee exists with GIVEN Designation");
					}
		});
		});
	

})								
								
							