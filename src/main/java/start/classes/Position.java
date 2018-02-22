package start.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Position
{
	String ip, country_code, country_name, region_code,
		region_name, city, zip_code, time_zone;
	double latitude, longitude;
	int metro_code;
	
	public String getIp()
	{
		return ip;
	}
	public String getCountry_code()
	{
		return country_code;
	}
	public String getCountry_name()
	{
		return country_name;
	}
	public String getRegion_code()
	{
		return region_code;
	}
	public String getRegion_name()
	{
		return region_name;
	}
	public String getCity()
	{
		return city;
	}
	public String getZip_code()
	{
		return zip_code;
	}
	public String getTime_zone()
	{
		return time_zone;
	}
	public double getLatitude()
	{
		return latitude;
	}
	public double getLongitude()
	{
		return longitude;
	}
	public int getMetro_code()
	{
		return metro_code;
	}
}
