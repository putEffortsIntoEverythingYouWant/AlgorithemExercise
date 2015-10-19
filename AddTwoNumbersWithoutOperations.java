/*
add two numbers without using +
*/
public int add(int a, int b){
	while(b!=0){
		int sum = a^b;
		int carryOn = (a&b)<<1;
		a = sum;
		b = carryOn;
	}
	return a;
}
