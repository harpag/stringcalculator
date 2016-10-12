package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		
		if(isNegative(text))
		{
			String negativeNumbers = allNegatives(text);
			throw new RuntimeException("Negatives not allowed: " + negativeNumbers);
		}

		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",|\\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        	if(toInt(number) <= 1000){
		    	total += toInt(number);
			}
		}
		return total;
    }

    private static boolean isNegative(String numbers){
    	return numbers.contains("-");
    }

    private static String allNegatives(String number){
    	String negatives = "";
    	String[] all = splitNumbers(number);
    	for(int i = 0; i < all.length; i++){
    		if(isNegative(all[i])){
    			if(isNegative(negatives)){
    				negatives = negatives + "," + all[i];
    			}
    			else{
    				negatives = negatives + all[i];
    			}
    		}
    	}
    	return negatives;
    }

}