package codecheck;

public class App {

    public static final int WORDS_MAX = 1000;
    public static final int CHAR_MAX  = 10000;
    public static final int WORDS_TOP = 3;
    
    public static void main(String[] args) {
	String startWord = args[2];
	
	String[] words = createWordsArray(args);
	displayArray(words);

	String s = answerPlayer1(args[0], startWord, words);
	System.out.println(s);
    }
    

    public static String[] createWordsArray(String[] args){
	String[] w = new String[WORDS_MAX];
	
	for (int i = WORDS_TOP, l = args.length; i < l; i++) {
	    int arrayCnt = i - WORDS_TOP;
	    if(args[i] == null){
		break;
	    }
	    w[arrayCnt] = args[i];
	}
	
	return w;
    }

    public static String answerPlayer1(String playerAI, String opponentAnswer, String[] wordsArray){
	String cmd = String.format("%s %s", playerAI, opponentAnswer);
	for(int i = 0, l = wordsArray.length; i < l; i++){
	    if(wordsArray[i] == null){
		break;
	    }
	    cmd = String.format("%s %s", cmd, wordsArray[i]);
	}

	try{
	    Runtime runtime = Runtime.getRuntime();
	    Process p = runtime.exec(cmd);
	    InputStream retStr = p.getInputStream();
	    return retStr;
	}catch(IOException e){
	    System.out.println(e);
	}
	
    }
    
    // For test
    public static int displayArray(String[] arr){
	for(int i = 0, l = arr.length; i < l; i++){
	    if(arr[i] == null){
		break;
	    }
	    System.out.println(arr[i]);
	}
	return 0;
    }
    
    public static int test(){
	System.out.println("TEST!");
	return 0;
    }
    
}
