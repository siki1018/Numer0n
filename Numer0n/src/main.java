import java.util.Scanner;
//配列の[0]を百の位、[1]を十の位、[2]を一の位と処理していく
public class main {
	public static void main(String[] args) {
		int n = 10;
		System.out.println("私の3桁の整数を当ててください。1から9までの数字です。");
		System.out.println(n + "回以内に当ててください。");
		
		//CPの答えを決定する
		int[] CpAns = ThreeDigitNum();
		
		/*
		//乱数の確認(後ほどコメントアウト)
		System.out.print("\n(CPの答えは");
		for(int Cp : CpAns){ System.out.print(Cp); }
		System.out.println(")");
		*/
		
		//hit、blow(hitのみ初期化しているのは後の処理の都合)
		int hit = 0;
		int blow;
		
		//ループ
		for(int i = 1; i <= n; i ++) {
			System.out.println("\n" + i + "回目");
			//答えの入力
			int[] MyAns = array();
			
			//hit加算
			hit = 0;
			for(int j = 0; j < 3 ; j ++) {
				if(CpAns[j] == MyAns[j]) { hit ++; }
			}
			
			//blow加算
			blow = 0;
			for(int Cp : CpAns) {
				for(int My : MyAns) {
					if(Cp == My) { blow ++; }
				}
			}
			blow -= hit;
			
			//hit、blowの表示
			System.out.println("HIT:" + hit + " BLOW:" + blow);
			
			//勝敗の表示
			if(hit == 3) {
				System.out.println("あなたの勝ちです！");
				break;
			}
		}
		if(hit < 3) { System.out.println("あなたの負けです…私の数字は" + CpAns + "でした。"); }
		
	}
	
	//メソッド1:各位の数字が異なる3桁の整数の生成(0は含まない)
	public static int[] ThreeDigitNum() {
		int a;
		int b;
		int c;
		do {
			a = new java.util.Random().nextInt(10);
			b = new java.util.Random().nextInt(10);
			c = new java.util.Random().nextInt(10);
		}while(a == b || b == c || c == a || a == 0 || b == 0 || c == 0);
		int[] ans = {a, b, c};
		return ans;
	}
	
	//メソッド2:数字の入力受け取りと評価、入力された数字の配列化
	public static int[] array() {
		//数字入力
		System.out.print("わたしの数字を予想して入力してください:");
		int MyAns = new Scanner(System.in).nextInt();
		//評価
		while(true) {
			int A = (int)(MyAns / 100);
			int B = (int)(MyAns -  (A * 100))/10;
			int C = MyAns - (A * 100) - (B * 10);
			
			if(1000 <= MyAns) {
				System.out.println("エラー：桁数が多いです。");
			}else if(100 > MyAns) {
				System.out.println("エラー：桁数が少ないです。");
			}else if(A == B || B == C || C == A) {
				System.out.println("エラー：数字が重複しています。");
			}else if(A == 0 || B == 0 || C == 0) {
				System.out.println("エラー：0が含まれています。");
			}else{
				break;
			}
			System.out.print("再度、予想を入力してください:");
			int MyAns01 = new Scanner(System.in).nextInt();
			MyAns = MyAns01;
		}
		//配列化
		int A = (int)(MyAns / 100);
		int B = (int)(MyAns -  (A * 100))/10;
		int C = MyAns - (A * 100) - (B * 10);
		
		int[] array = {A, B, C,};
		return array;
	}
}
