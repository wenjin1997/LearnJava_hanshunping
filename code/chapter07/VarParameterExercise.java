public class VarParameterExercise {
	public static void main(String[] args) {
		HspMethod m = new HspMethod();
		System.out.println(m.showScore("小米", 90.0, 100.0, 70.0, 78.3, 60.1));
		System.out.println(90.0 + 100.0 + 70.0 + 78.3 + 60.1);
	}
}

class HspMethod {
	public String showScore(String name, double... score) {
		double totalScore = 0;
		for(int i = 0; i < score.length; i++) {
			totalScore += score[i];
		}
		return name + score.length + "门课的总成绩为：" + totalScore;
	}
}