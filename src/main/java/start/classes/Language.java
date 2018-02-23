package start.classes;

import java.util.HashMap;
import java.util.Map;

public class Language
{
	private Map<String, String> languages;
	
	public Language()
	{
		languages = new HashMap<String, String>();
		
		initialize();
	}
	
	private void initialize()
	{
		// Country code, language
		
		languages.put("AE", "ar");		// Arabic
		languages.put("EG", "ar");
		languages.put("LY", "ar");
		languages.put("KW", "ar");
		languages.put("QA", "ar");
		languages.put("BG", "bg");		// Bulgarian
		languages.put("ES-CT", "ca");	// Catalan
		languages.put("CZ", "cz");		// Czech
		languages.put("DE", "de");		// German
		languages.put("GR", "el");		// Greek
		languages.put("US", "en");		// English
		languages.put("UK", "en");
		languages.put("IR", "fa");		// Persian (Farsi)
		languages.put("AF", "fa");
		languages.put("TJ", "fa");
		languages.put("FI", "fi");		// Finnish
		languages.put("FR", "fr");		// French
		languages.put("ES-GA", "gl");	// Galician
		languages.put("HR", "hr");		// Croatian
		languages.put("HU", "hu");		// Hungarian
		languages.put("IT", "it");		// Italian
		languages.put("JP", "ja");		// Japanese
		languages.put("KR/KP", "kr");	// Korean
		languages.put("LV", "la");		// Latvian
		languages.put("LT", "lt");		// Lithuanian
		languages.put("MK", "mk");		// Macedonian
		languages.put("BE", "nl");		// Dutch
		languages.put("NL", "nl");
		languages.put("SR", "nl");
		languages.put("PL", "pl");		// Polish
		languages.put("PT", "pt");		// Portuguese
		languages.put("RO", "ro");		// Romanian
		languages.put("RU", "ru");		// Russian
		languages.put("SE", "se");		// Swedish
		languages.put("SK", "sk");		// Slovak
		languages.put("SI", "sl");		// Slovenian
		languages.put("ES", "es");		// Spanish
		languages.put("TR", "tr");		// Turkish
		languages.put("VN", "vi");		// Vietnamese
		languages.put("CN", "zh_cn");	// Chinese Simplified
		languages.put("TW", "zh_tw");	// Chinese Traditional
	}
	
	public String getLanguage(String countryCode)
	{
		return languages.get(countryCode);
	}
}
