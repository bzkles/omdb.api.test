package com.project.rest.omdb.api.test;

public class ContentMovie {

	private String title;
	private String year;
	private String imdbID;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	
	 @Override
     public String toString() {
          return    "title: "+ title
                  +"\nyear: "+ year
                  +"\nimdbID: "+ imdbID;
                
	 }
	
}
