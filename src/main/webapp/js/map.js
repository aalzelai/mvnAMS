/**
 * 
 */

    function createMap(){
		var heathrow = ol.proj.fromLonLat([-0.459093681628075, 51.467772]);
		var point1 = ol.proj.fromLonLat([-0.509093681628075, 51.467772]);
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

    	var features = new Array();
    	var coordinates = [[-0.509093681628075, 51.467772],[-0.459093681628075, 51.467772]];
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
    	        /*if (!style) {
    	            style = [new ol.style.Style({
    	                image: new ol.style.Circle({
    	                    radius: 10,
    	                    stroke: new ol.style.Stroke({
    	                        color: '#fff'
    	                    }),
    	                    fill: new ol.style.Fill({
    	                        color: '#3399CC'
    	                    })
    	                }),
    	                text: new ol.style.Text({
    	                    text: size.toString(),
    	                    fill: new ol.style.Fill({
    	                        color: '#fff'
    	                    })
    	                })
    	            })];
    	            styleCache[size] = style;
    	        }*/
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
    	    var firstPoint = coordinates[0];
    	    var secondPoint = coordinates[i];
    	    var slope = ((secondPoint[1] - firstPoint[1]) / (secondPoint[0] - firstPoint[0]));
    	    var angle = Math.atan(slope);
    	    var rotation;

    	    //Shifting the graph Origin to point of start point
    	    secondPoint[0] = secondPoint[0] - firstPoint[0];
    	    secondPoint[1] = secondPoint[1] - firstPoint[1];
    	    //Fourth quadrant
    	    if (secondPoint[0] > 0 && secondPoint[1] < 0) {
    	        rotation = (Math.PI / 2 - angle);
    	    }
    	    //Second quadrant
    	    else if (secondPoint[0] < 0 && secondPoint[1] > 0) {
    	        rotation = -(Math.PI / 2 + angle);
    	    }
    	    //Third quadrant
    	    else if (secondPoint[0] < 0 && secondPoint[1] < 0) {
    	        rotation = 3 * Math.PI / 2 - angle;
    	    }
    	    //First quadrant
    	    else if (secondPoint[0] > 0 && secondPoint[1] > 0) {
    	        rotation = angle;
    	    }
    	    var iconStyle = new ol.style.Style({
    	        image: new ol.style.Icon(({
    	        	 anchor: [12, 12],
    	        	    anchorXUnits: 'pixels',
    	        	    anchorYUnits: 'pixels',
    	            opacity: 1,
    	            src: 'data/plane.png',
    	            rotation: rotation
    	        }))
    	    });
    	    var iconFeature = new ol.Feature({
    	        geometry: new ol.geom.Point(endPoint)
    	    });
    	    iconFeature.setStyle(iconStyle);
    	    vectorLine.addFeature(iconFeature);
    	}
    	var vectorLayer = new ol.layer.Vector({
    	    source: vectorLine
    	});
    	map.addLayer(vectorLayer);


}