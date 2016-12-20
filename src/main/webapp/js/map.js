/**
 * 
 */


function createMap(){
	var heathrow = ol.proj.fromLonLat([-0.459093681628075, 51.467772]);
	var view = new ol.View({
        center: heathrow,
        zoom: 14
      });
	var iconFeature = new ol.Feature({
		  geometry: new ol.geom.Point(heathrow),
		  name: 'Plane'
		});

		var iconStyle = new ol.style.Style({
		  image: new ol.style.Icon(/** @type {olx.style.IconOptions} */ ({
		    anchor: [0.5, 46],
		    anchorXUnits: 'fraction',
		    anchorYUnits: 'pixels',
		    opacity: 1,
		    src: '../data/plane.png'
		  }))
		});

		iconFeature.setStyle(iconStyle);

		var vectorSource = new ol.source.Vector({
		  features: [iconFeature]
		});

		var vectorLayer = new ol.layer.Vector({
		  source: vectorSource
		});

		var map = new ol.Map({
		  layers: [new ol.layer.Tile({ source: new ol.source.OSM() }), vectorLayer],
		  target: document.getElementById('map'),
		  view: view
		});
}