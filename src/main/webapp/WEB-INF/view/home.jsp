<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Spring MVC - Ajax</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <style>
    	body { background-color: #eee; font: helvetica; }
    	#container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
    	.green { font-weight: bold; color: green; }
    	.message { margin-bottom: 10px; }
    	label { width:70px; display:inline-block;}
    	.hide { display: none; }
    	.error { color: red; font-size: 0.8em; }
    </style>
  </head>
  <body>
	
	<div id="container">
	
		<h1>Person Page</h1>
		<p>This page demonstrates Spring MVC's powerful Ajax functionality. Retrieve a
		random person, retrieve a person by ID, or save a new person, all without page reload.
		</p>
		
		<h2>Random Person Generator</h2>
		<input type="submit" id="randomPerson" value="Get Random Person" /><br/><br/>
		<div id="personResponse"> </div>
		
		<hr/>
		
		<h2>Get By ID</h2>
		<form id="idForm">
			<div class="error hide" id="idError">Please enter a valid ID in range 0-3</div>
			<label for="personId">ID (0-3): </label><input name="id" id="personId" value="0" type="number" />
			<input type="submit" value="Get Person By ID" /> <br /><br/>
			<div id="personIdResponse"> </div>
		</form>
		
		<hr/>
		
		<h2>Submit new Person</h2>
		<form id="newPersonForm">
			<label for="nameInput">Name: </label>
			<input type="text" name="name" id="nameInput" />
			<br/>
			
			<label for="ageInput">Age: </label>
			<input type="text" name="age" id="ageInput" />
			<br/>
			<input type="submit" value="Save Person" /><br/><br/>
			<div id="personFormResponse" class="green"> </div>
		</form>
	</div>
	
	
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			// Random Person AJAX Request
			$('#randomPerson').click(function() {
				$.getJSON('${pageContext.request.contextPath}/api/person/random', function(person) {
					$('#personResponse').text(person.name + ', age ' + person.age);
				});
			});
			
			// Request Person by ID AJAX
			$('#idForm').submit(function(e) {
				var personId = +$('#personId').val();
				if(!validatePersonId(personId)) 
					return false;
				$.get('${pageContext.request.contextPath}/api/person/' + personId, function(person) {
					$('#personIdResponse').text(person.name + ', age ' + person.age);
				});
				e.preventDefault(); // prevent actual form submit
			});
			
			// Save Person AJAX Form Submit
			$('#randomPerson').click(function() {
				$.getJSON('${pageContext.request.contextPath}/api/person/random', function(person) {
					$('#personResponse').text(person.name + ', age ' + person.age);
				});
			});
			
			$('#newPersonForm').submit(function(e) {
				// will pass the form date using the jQuery serialize function
				$.post('${pageContext.request.contextPath}/api/person', $(this).serialize(), function(response) {
					$('#personFormResponse').text(response);
				});
				
				e.preventDefault(); // prevent actual form submit and page reload
			});
			
		});
		
		function validatePersonId(personId) {
			console.log(personId);
			if(personId === undefined || personId < 0 || personId > 3) {
				$('#idError').show();
				return false;
			}
			else {
				$('#idError').hide();
				return true;
			}
		}
		
	
	</script>
	
  </body>
</html>