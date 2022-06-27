var landlordTable ="";
var propertyTable ="";

$(document).ready(function() {
	
	$("#add-property-form").submit(function (event) {
		event.preventDefault();
		var propertyName = $("#new-property-name").val();
		var rent = $("#new-rent").val();
		var landlordId = $("#new-landlord-id").val();
		
		var newProperty = {
			propertyName: propertyName,
			rent: rent,
			landlordId: landlordId
		}
	
		console.log(newProperty);
		if($("#new-property-name.val").val() == "" || $("#new-rent").val() == "" ||
			$("#new-landlord-id").val() == "") {
				alert("Please fill in all property fields before submitting");
		} else {
			$.ajax("http://localhost:8080/property", {
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify(newProperty)
			});
			setTimeout(() => { location.reload(); }, 1000)
				$("#new-property-name").val("");
				$("#new-rent").val("");
				$("#new-landlord-id").val("");
		}
	});
	
	$("#add-landlord-form").submit(function (event) {
		event.preventDefault();
		var firstName = $("#new-first-name").val();
		var lastName = $("#new-last-name").val();
		
		var newLandlord = {
			firstName: firstName,
			lastName: lastName
		}
		
		console.log(newLandlord);
		
		if($("#new-first-name").val() == "" || $("#new-last-name").val() == "") {
			alert("Please fill in all landlord fields before submitting");
		} else {			
			$.ajax("http://localhost:8080/landlord", {
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify(newLandlord)
			});
			setTimeout(() => { location.reload(); }, 100)
				$("#new-first-name").val("");
				$("#new-last-name").val("");
		}
	});
	
	$.get("http://localhost:8080/landlord", function(data, status) {
		console.log(data);
		allData = data;
		$.each(data, function (key, item) {
			landlordTable +=
				"<tr  id = " + item.landlordId + ">" + 
				"<td a href=" + item.landlordId + ">" + item.landlordId + "</td>" +
				"<td>" + item.firstName + "</td>" +
				"<td>" + item.lastName + "</td>" +
				"</tr>";
		});
		$("#landlord-table").append(landlordTable);
	});
	
	$.get("http://localhost:8080/property", function(data, status) {
		console.log(data);
		allData = data;
		$.each(data, function (key, item) {
			propertyTable +=
				"<tr id = " + item.propertyNo + ">" + 
				"<td>" + item.propertyNo + "</td>" +
				"<td>" + item.propertyName + "</td>" +
				"<td>" + item.rent + "</td>" +
				"<td>" + item.landlordId + "</td>" +
				"</tr>";
		});
		$("#property-table").append(propertyTable);
	});
	
	function refreshProperty() {
		$("#property-table tbody").empty();
		$("#property-table").append(propertyTable);
	}
	
	$("#rent-lookup").change(function() {
		refreshProperty();
		
		var table = document.getElementById("property-table");
		for(var i = 1, row; row = table.rows[i];) {
			console.log(row.cells[2].innerHTML);
			console.log($("#rent-lookup").val());
			if(parseFloat(row.cells[2].innerHTML) >= $("#rent-lookup").val()) {
				console.log("Removing");
				console.log(row.cells[2]);
				document.getElementById(row.cells[0].innerHTML).remove();
			}
			else {
				i++;
			}
		}
	})
});