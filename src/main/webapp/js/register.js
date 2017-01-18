$( document ).ready(function() {

	//add collapse to all tags hiden and showed by select mystuff
	$('.selHide').addClass('collapse');
	
	//on change hide all divs linked to select and show only linked to selected option
	$('#userTypeSel').change(function(){
	    //Saves in a variable the wanted div
	    var selector = '.sel' + $(this).val();
	    
	    if(selector == '.selAirline'){
	    	$('#airlineSel').load('./load/selView.jsp?' + $.param({
	    		type: $(this).val()
	    	}), function(){
	    		$('#selectAirline').selectpicker('render');
	    	});
	    }else if(selector == '.selControl'){
	    	$('#airportSel').load('./load/selView.jsp?' + $.param({
	    		type: $(this).val()
	    	}), function(){
	    		$('#selectAirport').selectpicker('render');
	    	});
	    }
	
	    //hide all elements
	    $('.selHide').collapse('hide');
	    $('.selHide :input').prop('required',false);
	
	    //show only element connected to selected option
	    $(selector).collapse('show');
	    $(selector + ' :input').prop('required',true);
	    
	    if($(this).val() == '0'){
	    	$('#submit').prop('disabled', true);
	    }else{
	    	$('#submit').prop('disabled', false);
	    }
	})
	
});