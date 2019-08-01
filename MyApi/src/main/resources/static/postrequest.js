$(document).ready(
		function() {

			// SUBMIT FORM
			$("#saveEmp").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					firstName : $("#First_Name").val(),
					lastName : $("#Last_Name").val(),
					empId : $("#emp_id").val(),
					email:$("#Email_Id").val(),
					mobileNumber:$("#Mobile_Number").val(),
					designation:$("#Designation").val(),
					password:$("#password").val(),
					security_Question:$("#security_Question").val(),
					security_answer:$("#security_Answer").val()
				}
				console.log(formData);
				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/saveEmployee",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#postResultDiv").html(
									"" + result.data.firstName+" "+result.data.lastName+" "
											+ "Post Successfully! <br>"
											+ "---> Congrats !!" + "</p>");
							$("#backLogin").show();
							/*$("#First_Name").text="";
							$("#emp_id").text="";
							$("#Email_Id").text="";
							$("#Mobile_Number").text="";
							$("#Designation").text="";
							$("#password").text="";
							$("#security_Question").text="";
							$("#security_Answer").text="";*/
							$("input:text").val("");
							$("input:password").val("");
							
						} else {
							$("#postResultDiv").html("<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}
				});

			}

		})