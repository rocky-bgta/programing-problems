import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchWordAWS {
	
	
	public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
		List<List<String>> result = new ArrayList<>();
		List<String> temSearchStringList = new ArrayList<>();
		
		
		if (customerQuery != null && customerQuery.length() > 2) {
			String temSearchString;
			temSearchString = customerQuery.substring(0, 2);
			temSearchStringList.add(temSearchString);
			for (int i = 2; i < customerQuery.length(); i++) {
				temSearchString+= customerQuery.substring(i, i + 1);
				temSearchStringList.add(temSearchString);
			}
			
			for (String searchKey : temSearchStringList) {
				List<String> selectedWord = new ArrayList<>();
				for (String word : repository) {
					String onlySearchWord = word.substring(0, searchKey.length());
					if (searchKey.contains(onlySearchWord)) {
						selectedWord.add(word);
					}
				}
				result.add(selectedWord.stream().sorted().limit(3).collect(Collectors.toList()));
			}
		}
		return result;
	}
	
	public static void main(String[] arg) {
		List<String> repository = new ArrayList<>();
		repository.add("mobile");
		repository.add("mouse");
		repository.add("moneypot");
		repository.add("monitor");
		repository.add("mousepad");
		searchSuggestions(repository,"mouse");
	}
	
}
