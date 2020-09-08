<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register a User</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">
<script>
	function validateZipCode(elementValue){
	     var zipCodePattern = /^[0-9]{5}(?:-[0-9]{4})?$/;
	     return zipCodePattern.test(elementValue);
	}
	function validateform() {
		var firstName = document.forms.regForm.firstname.value;
		var lastName = document.forms.regForm.lastname.value;
		var address1 = document.forms.regForm.address1.value;
		var address2 = document.forms.regForm.address2.value;
		var city = document.forms.regForm.city.value;
		var state = document.forms.regForm.state.value;
		var zip = document.forms.regForm.zip.value;
		var country = document.forms.regForm.country.value;

		if (firstName == null || firstName == "") {
			alert("Please enter First Name.");
			return false;
		}
		if (lastName == null || lastName == "") {
			alert("Please enter Last Name.");
			return false;
		}
		if (address1 == null || address1 == "") {
			alert("Please enter Address1.");
			return false;
		}
		if (address2 == null || address2 == "") {
			alert("Please enter Address2.");
			return false;
		}
		if (city == null || city == "") {
			alert("Please enter City.");
			return false;
		}
		if (state == null || state == "") {
			alert("Please enter State.");
			return false;
		}
		if (zip == null || zip == "") {
			alert("Please enter Zip.");
			return false;
		}
		if (!validateZipCode(zip)) {
			alert("Zip must contain only digits and can be either 5 digits or 9 digits long.");
			return false;
		}
	}
</script>
</head>
<body>
	<h1>Register a User</h1>
	<form:form id="regForm" modelAttribute="person" action="register"
		method="post">
		<table>
			<tr>
				<td colspan="3"><label class="red">*</label> denotes required
					field.</td>
			</tr>
			<tr>
				<td colspan="3" style="font-style: italic; color: green;"><pre>${successmessage}</pre></td>
			</tr>
			<tr>
				<td colspan="3" style="font-style: italic; color: red;"><pre>${failuremessage}</pre></td>
			</tr>
			<tr>
				<td><form:label path="firstname">First Name</form:label><label
					class="red">*</label></td>
				<td><form:input path="firstname" name="firstname"
						id="firstname" /></td>
				<td class="red">${error != null && error.has("fnmessage") ? error.get("fnmessage") : ""}</td>
			</tr>
			<tr>
				<td><form:label path="lastname">Last Name</form:label><label
					class="red">*</label></td>
				<td><form:input path="lastname" name="lastname" id="lastname" /></td>
				<td class="red">${error != null && error.has("lnmessage") ? error.get("lnmessage") : ""}</td>
			</tr>
			<tr>
				<td><form:label path="address1">Address1</form:label><label
					class="red">*</label></td>
				<td><form:input path="address1" name="address1" id="address1" /></td>
				<td class="red">${error != null && error.has("add1message") ? error.get("add1message") : ""}</td>
			</tr>
			<tr>
				<td><form:label path="address2">Address2</form:label><label
					class="red">*</label></td>
				<td><form:input path="address2" name="address2" id="address2" />
				<td class="red">${error != null && error.has("add2message") ? error.get("add2message") : ""}</td>
			</tr>
			<tr>
				<td><form:label path="city">City</form:label><label class="red">*</label></td>
				<td><form:input path="city" name="city" id="city" /></td>
				<td class="red">${error != null && error.has("citymessage") ? error.get("citymessage") : ""}</td>
			</tr>
			<tr>
				<td><form:label path="state">State</form:label><label
					class="red">*</label></td>
				<td><form:input path="state" name="state" id="state" /></td>
				<td class="red">${error != null && error.has("statemessage") ? error.get("statemessage") : ""}</td>
			</tr>
			<tr>
				<td><form:label path="zip">Zip</form:label><label class="red">*</label></td>
				<td><form:input path="zip" name="zip" id="zip" /></td>
				<td class="red">${error != null && error.has("zipmessage") ? error.get("zipmessage") : ""}&nbsp;
				${error != null && error.has("ziplenmessage") ? error.get("ziplenmessage") : ""}</td>
			</tr>
			<tr>
				<td><form:label path="country">Country</form:label><label
					class="red">*</label></td>
				<td><form:select path="country" name="country" id="country">
						<option id="us" name="us">United States</option>
					</form:select></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="registerBtn" name="registerBtn"
						onclick="return validateform();">Register</form:button></td>
				<td></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="/RegistrationProject/index.html">Home</a></td>
				<td></td>
			</tr>
		</table>
	</form:form>
</body>
</html>