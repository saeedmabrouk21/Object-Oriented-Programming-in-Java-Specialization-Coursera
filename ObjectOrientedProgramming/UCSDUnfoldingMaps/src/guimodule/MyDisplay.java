package guimodule;

import de.fhpotsdam.unfolding.geo.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Integer;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class MyDisplay extends PApplet{
	private UnfoldingMap map;
	public void setup() {
		size(950,600,OPENGL);
	    map = new UnfoldingMap(this,200,50,700,500,new Microsoft.AerialProvider()
);
	    map.zoomToLevel(2);
	    MapUtils.createDefaultEventDispatcher(this,map);
	    Location valloc = new Location (-38.14f,-73.03f);
	    Feature valEq = new PointFeature(valloc);
	    valEq.addProperty("title","Valdriva, Chile");
	    valEq.addProperty("magnitude","9.5");
	    valEq.addProperty("data","May 22, 1960");
	    valEq.addProperty("year",1960);
	    
	    Location valloc1 = new Location (61.02f,-147.65f);
	    Feature valEq1 = new PointFeature(valloc1);
	    valEq1.addProperty("title","Valdriva, Chile");
	    valEq1.addProperty("magnitude","9.5");
	    valEq1.addProperty("data","May 22, 1964");
	    valEq1.addProperty("year",1964);
	    
	    Location valloc2 = new Location (3.30f,95.78f);
	    Feature valEq2 = new PointFeature(valloc2);
	    valEq2.addProperty("title","Valdriva, Chile");
	    valEq2.addProperty("magnitude","9.5");
	    valEq2.addProperty("data","May 22, 2004");
	    valEq2.addProperty("year",2004);
	    
	    Location valloc3 = new Location (38.322f,142.369f);
	    Feature valEq3 = new PointFeature(valloc3);
	    valEq3.addProperty("title","Valdriva, Chile");
	    valEq3.addProperty("magnitude","9.5");
	    valEq3.addProperty("data","May 22, 2011");
	    valEq3.addProperty("year",2011);
	    
	    Location valloc4 = new Location (52.76f,160.06f);
	    Feature valEq4 = new PointFeature(valloc4);
	    valEq4.addProperty("title","Valdriva, Chile");
	    valEq4.addProperty("magnitude","9.5");
	    valEq4.addProperty("data","May 22, 1952");
	    valEq4.addProperty("year",1952);
//	   
	    
	    List<PointFeature> bigEqs = new ArrayList<PointFeature>();
	    bigEqs.add((PointFeature) valEq);
	    bigEqs.add((PointFeature)valEq1);
	    bigEqs.add((PointFeature)valEq2);
	    bigEqs.add((PointFeature)valEq3);
	    bigEqs.add((PointFeature)valEq4);
	    List<Marker> markers = new ArrayList<Marker>();
	    for(PointFeature eq:bigEqs) {
	    	Marker ab = new SimplePointMarker(eq.getLocation(),eq.getProperties());
	    	markers.add(ab);
	    }
	    int yellow = color(255,255,0);
	    int gray  = color(150,150,150);
	    for(Marker mk:markers) {
	    	if((int)(mk.getProperty("year"))>2000) {
	    		mk.setColor(yellow);
	    		
	    	}else {
	    		mk.setColor(gray);
	    	}
	    }
	    map.addMarkers(markers);
		
	}
	public void draw() {
		background(10);
	    map.draw();
	    //addKey();
		
	}
}
