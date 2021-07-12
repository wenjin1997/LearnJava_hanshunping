public class MiGong {
	public static void main (String[] args) {
		// 1.创建迷宫
	    // 2.规定数组中：0表示可以走，1表示障碍物

	    int[][] map = new int[8][7];
	    for(int i = 0; i < 7; i++) {
	    	map[0][i] = 1;
	    	map[7][i] = 1;
	    }
	    for(int i = 0; i < 8; i++) {
	    	map[i][0] = 1;
	    	map[i][6] = 1;
	    }
	    map[3][1] = 1;
	    map[3][2] = 1;
	    map[2][2] = 1; //测试回溯

	    // 输出当前地图
	    System.out.println("===当前地图情况===");
	    for(int i = 0; i < map.length; i++) {
	    	for(int j = 0; j < map[i].length; j++) {
	    		System.out.print(map[i][j] + " ");
	    	}
	    	System.out.println();
	    }

	    T t1 = new T();
	    t1.findWay(map, 1, 1);

	    System.out.println("\n===找路的情况===");
	    for(int i = 0; i < map.length; i++) {
	    	for(int j = 0; j < map[i].length; j++) {
	    		System.out.print(map[i][j] + " ");
	    	}
	    	System.out.println();
	    }
	}
}

class T {
	// 使用递归回溯的思想来解决老鼠出迷宫问题

	/*
	* 0 表示可以走， 1 表示障碍物， 2 表示可以走 3 表示走过，但是走不通是死路
	* 当map[6][5]=2 就说明找到通路，可以结束，否则就继续找
	* 老鼠找路的策略：下->右->上->左
	*/
	public boolean findWay(int[][] map, int i, int j) {
		if(map[6][5] == 2) {
			return true;
		} else {
			if(map[i][j] == 0) {
				map[i][j] = 2;
				// 采用 下->右->上->左
				if(findWay(map, i + 1, j)) { // 下
					return true;
				} else if(findWay(map, i, j + 1)) { // 右
					return true;
				} else if(findWay(map, i - 1, j)) { // 上
					return true;
				} else if(findWay(map, i, j - 1)) { // 左
					return true;
				} else {
					map[i][j] = 3;
					return false;
				}
			} else { // map[i][j] = 1,2,3
				return false;
			}
		}
	}

	// 老鼠找路的策略：下->右->上->左 ==> 上->右->下->左
	public boolean findWay2(int[][] map, int i, int j) {
		if(map[6][5] == 2) {
			return true;
		} else {
			if(map[i][j] == 0) {
				map[i][j] = 2;
				// 采用 下->右->上->左
				if(findWay2(map, i - 1, j)) { // 上
					return true;
				} else if(findWay2(map, i, j + 1)) { // 右
					return true;
				} else if(findWay2(map, i + 1, j)) { // 下
					return true;
				} else if(findWay2(map, i, j - 1)) { // 左
					return true;
				} else {
					map[i][j] = 3;
					return false;
				}
			} else { // map[i][j] = 1,2,3
				return false;
			}
		}
	}
}