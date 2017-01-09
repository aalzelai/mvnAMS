/**
 * 
 */

    function createMap(){
		var heathrow = ol.proj.fromLonLat([-0.459093681628075, 51.467772]);
		var point1 = ol.proj.fromLonLat([-0.509093681628075, 51.467772]);
		var dataString = document.getElementById('hiddenData').value;
		var vectorLayer = [];
		var flightsData = dataString.split("%"); //Separate flights from the big string
    	var tileLayer = new ol.layer.Tile({
    	    source: new ol.source.OSM()
    	});

    	var map = new ol.Map({
    	    layers: [tileLayer],
    	    view: new ol.View({
    	        center: heathrow,
    	        zoom: 10
    	    }),
    	    target: 'map'
    	});
    	for(var j = 0; j < flightsData.length; j++){
    		var flightFragments = flightsData[j].split("$"); //Separate each part from the flight (id, coord1, coord2)
    		var coordenatesAirport = flightFragments[1].split("/");
    		var coordenatesPlane = flightFragments[2].split("/");
    		var angle = parseInt(flightFragments[3]);
    	var features = new Array();
    	var coordinates = [[parseFloat(coordenatesAirport[0]), parseFloat(coordenatesAirport[1])],[parseFloat(coordenatesPlane[0]), parseFloat(coordenatesPlane[1])]];
    	var transformedCoordinates = new Array();

    	for (var i = 0; i < coordinates.length; ++i) {
    	    transformedCoordinates[i] = ol.proj.transform(coordinates[i], 'EPSG:4326', 'EPSG:3857');
    	    features[i] = new ol.Feature(new ol.geom.Point(transformedCoordinates[i]));
    	}

    	var source = new ol.source.Vector({
    	    features: features
    	});

    	var clusterSource = new ol.source.Cluster({
    	    distance: 40,
    	    source: source
    	});

    	var styleCache = {};
    	var clusters = new ol.layer.Vector({
    	    source: clusterSource,
    	    style: function (feature, resolution) {
    	        var size = feature.get('features').length;
    	        var style = styleCache[size];
    	        return style;
    	    }
    	});

    	map.addLayer(clusters);

    	var vectorLine = new ol.source.Vector({});

    	for (var i = 1; i < transformedCoordinates.length; i++) {
    	    var startPoint = transformedCoordinates[0];
    	    var endPoint = transformedCoordinates[i];
    	    var lineArray = [startPoint, endPoint];
    	    var featureLine = new ol.Feature({
    	        geometry: new ol.geom.LineString(lineArray)
    	    });

    	    var lineStyle = new ol.style.Style({
    	        fill: new ol.style.Fill({
    	            color: '#00FF00',
    	            weight: 7
    	        }),
    	        stroke: new ol.style.Stroke({
    	            color: '#00FF00',
    	            width: 5
    	        })
    	    });
    	    featureLine.setStyle(lineStyle);
    	    vectorLine.addFeature(featureLine);
    	    var iconStyle = new ol.style.Style({
    	        image: new ol.style.Icon(({
    	        	 anchor: [12, 12],
    	        	    anchorXUnits: 'pixels',
    	        	    anchorYUnits: 'pixels',
    	            opacity: 1,
    	            src: 'data/plane.png',
    	            rotation: -(angle*Math.PI/180)
    	        }))
    	    });
    	    var iconFeature = new ol.Feature({
    	        geometry: new ol.geom.Point(endPoint)
    	    });
    	    iconFeature.setStyle(iconStyle);
    	    vectorLine.addFeature(iconFeature);
    	}
    	vectorLayer[j] = new ol.layer.Vector({
    	    source: vectorLine
    	});
    	map.addLayer(vectorLayer[j]);
    	}
}