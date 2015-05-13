<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX Employees</title>
</head>
<body>
	<h1>List of Employees</h1>
	<div id="employeeList"></div>
</body>
<script type="text/javascript">
	var httpRequest;
	if (window.XMLHttpRequest) { // Mozilla, Safari, IE7+ ...
		httpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE 6 and older
		httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	httpRequest.onreadystatechange = function() {
		if (httpRequest.readyState === 4) {
			// everything is good, the response is received
			if (httpRequest.status === 200) {
				document.getElementById("employeeList").innerHTML = httpRequest.responseText;
			} else {
				// there was a problem with the request,
				// for example the response may contain a 404 (Not Found)
				// or 500 (Internal Server Error) response code
			}
		} else {
			// still not ready
		}
	};
	httpRequest.setRequestHeader("accept","application/json");
	httpRequest.open('GET', 'employees', true);
	httpRequest.send(null);
</script>
</html>