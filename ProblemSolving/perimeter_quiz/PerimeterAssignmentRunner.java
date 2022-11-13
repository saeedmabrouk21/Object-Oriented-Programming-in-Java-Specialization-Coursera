 

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int x = 0 ;
        for(Point y:s.getPoints()){
            
            x++;
        }
        // Put code here
        return x;
    }

    public double getAverageLength(Shape s) {
        
        return getPerimeter(s)/getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        double maxSide = 0;
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            if(currDist > maxSide){
                maxSide = currDist;
            }
            prevPt = currPt;
        }
        return maxSide;
    }

    public double getLargestX(Shape s) {
        double maxX = -999;
        for (Point currPt : s.getPoints()) {
            if(currPt.getX()>maxX){
                maxX=currPt.getX();
            }
        }

        return maxX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double maxPer = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            Shape s = new Shape(new FileResource(f));
            double vv =getPerimeter(s);
            if(vv>maxPer)
                maxPer=vv;
                
        }
        return maxPer;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int pointsNum = getNumPoints(s);
        System.out.println("Points Number = " + pointsNum);
        double average = getAverageLength(s);
        System.out.println("the average length of a side in your shape is "+average);
        double maxSide = getLargestSide(s);
        System.out.println("Largest Side = " + maxSide);
        
        double maxX = getLargestX(s);
        System.out.println("Largest x = " + maxX);
        
        double maxPer = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Per = " + maxPer);
        
        
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        double largestPerimeter = 0.0;
    	DirectoryResource dr = new DirectoryResource();
    	File temp = null;
    	for(File f : dr.selectedFiles()){
    		FileResource fr = new FileResource(f);
    		Shape s = new Shape(fr);
    		double perimeter = getPerimeter(s);
    		if(perimeter > largestPerimeter){
    			largestPerimeter = perimeter;
    			temp = f;
    		}
    	}
    	    	System.out.println(temp.getName());


        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
        
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
