console.log("this is our console message")

const search = () => {
	console.log("searching...")
	//alert("js is activate")

	let query = $("#search-input").val();
	if (query == "") {
		$(".search-result").hide();
	} else {
		console.log(query)

		let url = 'http://localhost:8080/employee/search/' + query;
	//	var text
		fetch(url).then((response) => {
			console.log(response);

			return response.json();
		})
			.then((data) => {
				let text = '<div class =list-group>'
				data.forEach((employee) => {
					text = text + '<div>'+ employee.empName + '</div>'
					console.log("hello", text);

				});

		//if(text != null){
			text += '</div>'
			$(".search-result").html(text);
			$(".search-result").show();

	//	}		
		


			})

	}

};