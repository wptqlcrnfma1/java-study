package practice03;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		
		for(int i=0;i<COUNT_GOODS;i++) {
			goods[i] = new Goods();
			goods[i].setGoodsName(scanner.next());
			goods[i].setGoodsPrice(scanner.nextInt());
			goods[i].setGoodsCount(scanner.nextInt());
			scanner.nextLine();
		}
		
		for(int i=0;i<COUNT_GOODS;i++) {
			goods[i].show();
		}
		scanner.close();
	}
}
