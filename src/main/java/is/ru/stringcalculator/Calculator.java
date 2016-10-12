package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		
		//If number is negative we throw an exception
		if(isNegative(text))
		{
			String delimeter = ",";
			if(text.contains("//")){
				String[] arg = text.split("\\n");
				delimeter = String.valueOf(arg[0].charAt(2));
				text = arg[1];
			}
			String negativeNumbers = allNegatives(text, delimeter);
			throw new RuntimeException("Negatives not allowed: " + negativeNumbers);
		}

		if(text.equals("")){
			return 0;
		}
		else{
			//Check if there is a different delimeter
			if(text.contains("//")){
				String[] arg = text.split("\\n");
				String delimeter = String.valueOf(arg[0].charAt(2));
				System.out.println("test");
				return sum(splitNumbers(arg[1],delimeter));
			}
		 	else if(text.contains(",") || text.contains("\\n")){
				return sum(splitNumbers(text,","));
			}
			else{
				return 1;
			}
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delimeter){
	    return numbers.split(delimeter + "|\\n");
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

    private static String allNegatives(String number, String delimeter){
    	String negatives = "";
    	String[] all = splitNumbers(number, delimeter);
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