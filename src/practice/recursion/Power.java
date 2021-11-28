package practice.recursion;

class Power {
  public static void main(String[] args) {
	  Power main = new Power();
    int result = main.power(2,-2);
    System.out.println(result);


  }

  // Question 2 - Power

  public int power(int base, int exp) {
    if (exp<0) {
      return -1;
    }
    if (exp==0 || exp==1) {
      return base;
    }
    return base * power(base, exp-1);
  }


}
