$(document).ready(function(){
	var meta=0;
	call();
function call(param){
    $.ajax({
            type: 'GET',
            url: 'http://localhost:9098/cake/list',
            async: true,
            data: param,
            success: function(data) {
                console.log(data);
                writeTable(data)
                writeMeta(data)
            },
            error: function(error) {
                console.log('Smth went wrong...');
            }
        })
}

function writeTable(data) {
	var $container = $('#heroes-list');
	$container.empty();
	var stringTable;


	for(var i = 0; i < data.length; i++){
	stringTable+='<tr>';

	    for(var j = 0; j < 3 ; j++){
	        if( j + i < data.length){
	            stringTable+='<td><img class="card-img" src="'+data[i+j].imageUrl +'"/><td> ' + '<td><p><h4 class="masthead-brand">' + data[i+j].title + '</h4></p></br>'
	            + data[i+j].description + '<br/>Price: ' + data[i+j].price
	            + ' .руб' +'</td>';
	        }
	    }
	    i+=2;
	    stringTable+='</tr>';
	}
	$container.html(stringTable);
}


});