// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 >= 0){
			for (int i = 0; i < x2; i++){
			x1++;
			}
		} else {
			for (int i = 0; i > x2; i--){
			x1++;
			}
		}
		
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 >= 0){
			for (int i = 0; i < x2; i++){
			x1--;
			}
		}else{
			for (int i = 0; i > x2; i--){
			x1++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		boolean isNegative = (x1 < 0) != (x2 < 0);
		int absX1 = x1;
		if (x1 < 0){
			absX1 = minus(0,x1);
		}
		int absX2 = x2;
		if (x2 < 0){
			absX2 = minus(0,absX2);
		}
		int result = 0;
			for (int i = 0; i < absX2; i++){
			result = plus(result, absX1);
			}
		 if (isNegative){
			return minus(0,result);
		 }
	
		return result;
		}	
		
	

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int powResult = 1;
		if (n >=0){
			for (int i = 0; i < n; i++){
			powResult = times(powResult, x);
			}
		}else {
			for (int i = 0; i < n; i--){
			powResult = times(powResult, x);
			}
		}
		return powResult;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int q = 0;
		int d = x1;
		while (d >= x2){
			d = minus(d,x2);
			q++;
		}
		return q;
	}
	
		
	

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int d = x1; 
		while (d >= x2){
			d = minus(d,x2);
	    }
		return d;	
	}
	
	
	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
	int result = 0;
	int userNumber = x;
	for (int odd = 1; userNumber >= odd; odd += 2){
		userNumber = minus(userNumber, odd);
		result++;
	}
		return result;
	}	  	 
}