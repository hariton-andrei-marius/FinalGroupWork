package start.services;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

@Configuration
@PropertySource("classpath:config.properties")
@ConfigurationProperties(prefix = "api")
@Validated
public class ApiConfiguration {
	
    @NotBlank
    private static String globalScheme, 
    	weatherAppID,weatherAuthority, weatherPath, weatherQuery,
    	cityDetailsAuthority, cityDetailsPathCities, cityDetailsQuery, 
    	cityDetailsImageUrl, cityDetailsPathImages;

	public static String getGlobalScheme() {
		return globalScheme;
	}

	public static void setGlobalScheme(String globalScheme) {
		ApiConfiguration.globalScheme = globalScheme;
	}

	public static String getWeatherAppID() {
		return weatherAppID;
	}

	public static void setWeatherAppID(String weatherAppID) {
		ApiConfiguration.weatherAppID = weatherAppID;
	}

	public static String getWeatherAuthority() {
		return weatherAuthority;
	}

	public static void setWeatherAuthority(String weatherAuthority) {
		ApiConfiguration.weatherAuthority = weatherAuthority;
	}

	public static String getWeatherPath() {
		return weatherPath;
	}

	public static void setWeatherPath(String weatherPath) {
		ApiConfiguration.weatherPath = weatherPath;
	}

	public static String getWeatherQuery() {
		return weatherQuery;
	}

	public static void setWeatherQuery(String weatherQuery) {
		ApiConfiguration.weatherQuery = weatherQuery;
	}

	public static String getCityDetailsAuthority() {
		return cityDetailsAuthority;
	}

	public static void setCityDetailsAuthority(String cityDetailsAuthority) {
		ApiConfiguration.cityDetailsAuthority = cityDetailsAuthority;
	}

	public static String getCityDetailsPathCities() {
		return cityDetailsPathCities;
	}

	public static void setCityDetailsPathCities(String cityDetailsPathCities) {
		ApiConfiguration.cityDetailsPathCities = cityDetailsPathCities;
	}

	public static String getCityDetailsQuery() {
		return cityDetailsQuery;
	}

	public static void setCityDetailsQuery(String cityDetailsQuery) {
		ApiConfiguration.cityDetailsQuery = cityDetailsQuery;
	}

	public static String getCityDetailsImageUrl() {
		return cityDetailsImageUrl;
	}

	public static void setCityDetailsImageUrl(String cityDetailsImageUrl) {
		ApiConfiguration.cityDetailsImageUrl = cityDetailsImageUrl;
	}

	public static String getCityDetailsPathImages() {
		return cityDetailsPathImages;
	}

	public static void setCityDetailsPathImages(String cityDetailsPathImages) {
		ApiConfiguration.cityDetailsPathImages = cityDetailsPathImages;
	}

  
}
