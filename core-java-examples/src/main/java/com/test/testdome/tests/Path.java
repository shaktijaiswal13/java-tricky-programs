package com.test.testdome.tests;
public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public Path cd(String newPath) {
    	String updatedPath = path;
    	
    	if (newPath.matches("[a-zA-Z/.//]*")) {
    		if (newPath.equals("/")) {
    	    	return new Path("/");
    		}
    		//TODO change this, as / means root dir
    		if (newPath.startsWith("/")) {
    			newPath = newPath.substring(1);
    		}
    		String[] newPathArray = newPath.split("/");
    		for (String dir : newPathArray) {
    			System.out.println(dir);
    			if (dir.equals("..")) {
    				if (updatedPath.endsWith("/")) {
        				updatedPath = updatedPath.substring(0, updatedPath.length() - 3);
    				} else {
    					updatedPath = updatedPath.substring(0, updatedPath.length() - 2);
    				}
    				System.out.println(updatedPath);
    			} else {
    				updatedPath = updatedPath + "/" + dir;
    				System.out.println(updatedPath);
    			}
    		}
    	}
    	return new Path(updatedPath);
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        System.out.println("==============================");
        System.out.println(path.cd("../x").getPath());
        System.out.println("==============================");
        System.out.println(path.cd("../../x").getPath());
        System.out.println("==============================");
        System.out.println(path.cd("/x/y/z/").getPath());
        System.out.println("==============================");
        System.out.println(path.cd("/../../../x").getPath());

    }
}