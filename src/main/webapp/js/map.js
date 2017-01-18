/**
 * 
 */

    
	var iconFeatures=[]; 
	var iconStyle;
	var vectorSource;
	function createMap(){
	var heathrow = ol.proj.fromLonLat([-0.459093681628075, 51.467772]);
	var iconPath = 'data/plane.png';
	var dataString = document.getElementById('hiddenData').value;
	var vectorLayer = [];
	var flightsData = dataString.split("%"); //Separate flights from the big string
    	var map = new ol.Map({
    	    layers: [
    	          new ol.layer.Tile({
    	              source: new ol.source.OSM()
    	            })
    	          ],
    	    view: new ol.View({
    	        center: heathrow,
    	        zoom: 15
    	    }),
    	    target: 'map' 
    	});
    	
    	for(var j = 0; j < flightsData.length - 1; j++){
    	var flightFragments = flightsData[j].split("$"); //Separate each part from the flight (id, coord1, coord2)
		console.log(flightFragments[1]);
		var coordenatesAirport = flightFragments[1].split("/");
		var coordenatesPlane = flightFragments[2].split("/");
		var angle = parseInt(flightFragments[3]);
		iconStyle = new ol.style.Style({
	 	        image: new ol.style.Icon(({
	 	        	 anchor: [12, 12],
	 	        	    anchorXUnits: 'pixels',
	 	        	    anchorYUnits: 'pixels',
	 	            opacity: 1,
	 	            src: 'data/plane.png',
	 	            rotation: -(angle*Math.PI/180)
	 	        }))
	 	    });
		addMarker(parseFloat(coordenatesPlane[0]), parseFloat(coordenatesPlane[1]), iconPath);
    	}
    	vectorSource = new ol.source.Vector({
    	    features: iconFeatures //add an array of features
    	});
    	var vectorLayer = new ol.layer.Vector({
    	    source: vectorSource,
    	});

    	map.addLayer(vectorLayer);
    	
    	//refresh function
    	/*window.setInterval (function () {
    		//clean the layer from any existing markers
    		vectorSource.clear();
    		    $.ajax({
    		        url:"map.action?",
    		        type:"GET",
    		        cache:false,
    		        dataType: 'json',
    		        success:function(response) {
    		             $.each(response, function(recordCount, records) {
    		                $.each(records, function(index, element) {

    		                    var createIcon=addMarker(element.LongitudePosition,element.LatitudePosition,iconPath); 
    		                });
    		            }); 
    		     //and here add the newly created features to the layer
    		     vectorSource.addFeatures(iconFeatures);

    		        }, error:function() {
    		            console.log("Connection Failed");
    		        }
    		    });
    		}, 4000);*/
    	}
function addMarker(lon,lat,icon) {


	var iconGeometry=new ol.geom.Point(ol.proj.transform([lon,lat], 'EPSG:4326','EPSG:3857'));
	var iconFeature = new ol.Feature({
	    geometry:iconGeometry
	});
	iconFeature.setStyle(iconStyle);
	iconFeatures.push(iconFeature);
	}

function reloadMap(){
	console.log("Reloading");
	var dataString = document.getElementById('hiddenData').value;
	console.log(dataString);
	//clean the layer from any existing markers
	vectorSource.clear();
}