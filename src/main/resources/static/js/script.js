const search = () => {
//console.log("searching...")

let query = $("#search-input").val();

if(query == ""){
	$(".search-result").hide();
}else{
	console.log(query)
	
	let url = 'http://localhost:8080/search/${query}';
	
	fetch(url)
	.then((response)=>{
		return response.json();
	})
	.then((data)=>{
		let text = '<div class= list-group>';
		
		data.foreach((employee)=>{
			text +=$(Employeedetails.empName)
		})
		
	});
	
	text +='</div>';
	
	$(".search-result").html(text);
	$(".search-result").show();
	
}

};