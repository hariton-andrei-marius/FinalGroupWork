package start.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather
{
	String base, name;
	int visibility, dt, id, cod;
	Object coord, weather, main, wind, clouds, sys;
	
	public String getBase()
	{
		return base;
	}
	public String getName()
	{
		return name;
	}
	public int getVisibility()
	{
		return visibility;
	}
	public int getDt()
	{
		return dt;
	}
	public int getId()
	{
		return id;
	}
	public int getCod()
	{
		return cod;
	}
	public Object getCoord()
	{
		return coord;
	}
	public Object getWeather()
	{
		return weather;
	}
	public Object getMain()
	{
		return main;
	}
	public Object getWind()
	{
		return wind;
	}
	public Object getClouds()
	{
		return clouds;
	}
	public Object getSys()
	{
		return sys;
	}
}
