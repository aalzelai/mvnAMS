/**
 * 
 */
	var iconFeatures=[]; 
	var iconStyle;
	var vectorSource;
	var vectorLayer;
	var map;
	var iconPath = 'data/plane.png';
	
	function createMap(sessionType){
		var heathrow = ol.proj.fromLonLat([-0.459093681628075, 51.467772]);
		var dataString = document.getElementById('hiddenData').value;
		var vectorLayer = [];
		var flightsData = dataString.split("%"); //Separate flights from the big string
    	map = new ol.Map({
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
    		var coordenatesPlane = flightFragments[1].split("/");
    		var angle = parseInt(flightFragments[2]);
    		if(sessionType == flightFragments[0]){
    			iconPath = 'data/planeBlue.png';
    		}else{
    			iconPath = 'data/plane.png';
    		}
			iconStyle = new ol.style.Style({
		 	        image: new ol.style.Icon(({
		 	        	 anchor: [12, 12],
		 	        	    anchorXUnits: 'pixels',
		 	        	    anchorYUnits: 'pixels',
		 	            opacity: 1,
		 	            src: iconPath,
		 	            rotation: -(angle*Math.PI/180)
		 	        }))
		 	    });
			addMarker(parseFloat(coordenatesPlane[0]), parseFloat(coordenatesPlane[1]), iconPath);
    	}
    	vectorSource = new ol.source.Vector({
    	    features: iconFeatures //add an array of features
    	});
    	vectorLayer = new ol.layer.Vector({
    	    source: vectorSource,
    	});

    	map.addLayer(vectorLayer);
    }
	
	function addMarker(lon,lat,icon) {
		var iconGeometry=new ol.geom.Point(ol.proj.transform([lon,lat], 'EPSG:4326','EPSG:3857'));
		var iconFeature = new ol.Feature({
		    geometry:iconGeometry
		});
		
		iconFeature.setStyle(iconStyle);
		iconFeatures.push(iconFeature);
	}
	
	function reloadMap(sessionType){
		var dataString = document.getElementById('hiddenData').value;
		var vectorLayer = [];
		var flightsData = dataString.split("%"); //Separate flights from the big string
		
		iconFeatures = [];
		vectorSource.clear();
		
    	for(var j = 0; j < flightsData.length - 1; j++){
    		var flightFragments = flightsData[j].split("$"); //Separate each part from the flight (id, coord1, coord2)
    		var coordenatesPlane = flightFragments[1].split("/");
    		var angle = parseInt(flightFragments[2]);
    		if(sessionType == flightFragments[0]){
    			iconPath = 'data/planeBlue.png';
    		}else{
    			iconPath = 'data/plane.png';
    		}
			iconStyle = new ol.style.Style({
		 	        image: new ol.style.Icon(({
		 	        	 anchor: [12, 12],
		 	        	    anchorXUnits: 'pixels',
		 	        	    anchorYUnits: 'pixels',
		 	            opacity: 1,
		 	            src: iconPath,
		 	            rotation: -(angle*Math.PI/180)
		 	        }))
		 	    });
			addMarker(parseFloat(coordenatesPlane[0]), parseFloat(coordenatesPlane[1]), iconPath);
    	}
    	vectorSource = new ol.source.Vector({
    	    features: iconFeatures //add an array of features
    	});
    	vectorLayer = new ol.layer.Vector({
    	    source: vectorSource,
    	});

    	map.addLayer(vectorLayer);
	}
	
	
