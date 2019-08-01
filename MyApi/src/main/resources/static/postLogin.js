$(document).ready(
		function() {

			// SUBMIT FORM
			$("#loginEmp").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
				console.log("Data is Submitted");
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					
					empId : $("#empId").val(),
					
					password:$("#pwd").val()
					
				}
				console.log(formData);
				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/checkStatus",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							
							
						}
						
						else {
							$("#postResultDiv").html("<strong>Error</strong>");
						}
						
					},
					
				});

		}
		})