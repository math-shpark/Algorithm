package level1;

import java.util.Scanner;

public class Problem2851 {

	// 2851. ���۸�����
	public static void main(String[] args) {

		// Scanner ����
		Scanner scan = new Scanner(System.in);

		// �Է¹��� ���� ������ �迭 ����
		int[] num = new int[10];

		// �Է¹��� ���� �迭�� �����ϴ� �ݺ���
		for (int i = 0; i < 10; i++) {
			num[i] = scan.nextInt();
		}

		// �Է��� ���� ���� ���� ������ ����
		int sum = 0;

		// 100������ �Ÿ��� ���� ���� �����ϴ� �ݺ���
		for (int i = 0; i < 10; i++) {
			if (Math.abs(100 - sum) >= Math.abs(100 - (sum + num[i]))) {
				sum += num[i];
			} else {
				break; // ������ ������ �ݺ��� ����
			}
		}

		// ��� ���
		System.out.println(sum);
		
		// ������
		scan.close();
	}

}
