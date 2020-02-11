package practice03;

public class Goods {
	private String goodsName;
	private int goodsPrice;
	private int goodsCount;
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	
	public void show() {
		System.out.println(getGoodsName() + "(媛�寃� :" + getGoodsPrice() + "�썝)�씠 " + getGoodsCount() +"媛� �엯怨� �릺�뿀�뒿�땲�떎.");
	}
}
