package chapter03;

public class Goods2 {
    //정보 은닉의 경우, 보통 필드는 전부다 private로 막는다.
	private String name;
	private int price; 
	private int countSold;
	private int countStock;
	
	public Goods2() {} // 다양한 생성자를 만들 경우, 생성자 오버로딩이라 말 할 수 있다.
	
	public Goods2(String name, int price, int countSold, int countStock) {
		this.name = name;
		this.price = price;
		this.countSold = countSold;
		this.countStock = countStock;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price > 0)
		{
			price = 500;
		}
		this.price = price; //this가 없을 경우 지역변수에 지역변수를 다시 입히는 일이 생김.
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	
	public void showInfo() {
		System.out.println(name + ":" + price + ":" + countSold + ":" + countStock);
	}
	public int calcDiscountPrice(double discountRate) {
		return (int)(price - price*discountRate);
	}
}
