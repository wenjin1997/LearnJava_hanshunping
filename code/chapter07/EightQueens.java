public class EightQueens {
	public static void main(String[] args) {
		// 先生成一个二维数组表示棋盘
		int[][] map = new int[8][8];
		// 输出当前棋盘
	    System.out.println("===当前棋盘情况===");
	    for(int i = 0; i < map.length; i++) {
	    	for(int j = 0; j < map[i].length; j++) {
	    		System.out.print(map[i][j] + " ");
	    	}
	    	System.out.println();
	    }
	}
}

class Quees {
	// // 1.使用回溯递归方法解决八皇后问题，一维数组表示
	// // 2.-1 可以放置皇后 x(0<=x<=7) 表示可以走 -2 表示不能走
	// // 3.结束条件 最后一行有一个为1
	// public int[] putQueen(int[] arr, int position) {
	// 	if(arr[7] >= 0) {
	// 		return arr;
	// 	} else {
	// 		for(int i = 0; i < 8; i++) { //遍历每一行
	// 			if(arr[i] == -1) {  // 表示皇后可以走

	// 			}
	// 		}
	// 	}
	// }

	// 1.使用回溯递归方法解决八皇后问题，二维数组表示
	// 2.0 可以放置皇后 1 表示可以走 -2 表示不能走
	// 3.结束条件 最后一行有一个为1
	public boolean putQueen(int[][] map, int ii, int jj) {
		for(int i = 0; i < 8; i++) {
			if(map[7][i] == 1){
				return true;
			}
		}
		if(map[ii][jj] == 0) {
			map[ii][jj] = 1;
			for(int i = 0; i < 8; i++) {
				if(putQueen(map, ii, jj))
			}

		}

	}

}