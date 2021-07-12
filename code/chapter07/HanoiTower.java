public class HanoiTower {
	public static void main(String[] args) {
		Tower tower = new Tower();
		tower.move(2,'A','B','C');
	}
}

class Tower {
	// 方法
	public void move(int num, char a, char b, char c) {
		if(num == 1) {
			System.out.println(a + "->" + c);
		} else {
			// 1. 把a上面的盘移到b柱子，借助c柱
			move(num - 1, a, c, b);
			// 2.把a下面的一个盘子移到c柱子，借助b
			move(1, a, b, c);
			// 3.把b上面（num-1）个盘子移到c上面，借助a
			move(num - 1, b, a, c);
		}
	}
}