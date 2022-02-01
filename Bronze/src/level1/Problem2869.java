package level1;

import java.util.Scanner;

public class Problem2869 {

	// 2869. �����̴� �ö󰡰� �ʹ�
	public static void main(String[] args) {

		// Scanner ����
		Scanner scan = new Scanner(System.in);
		
		// �ö󰡴� ����
		int up = scan.nextInt();
		// �̲������� ����
		int down = scan.nextInt();
		// ���� ����� ����
		int height = scan.nextInt();
		
		// �ö� ����
		int sum = 0;
		// �ö� �Ⱓ
		int day = 1;
		
		// ���� �ö� ������ �ݺ��ϴ� �ݺ���
		while(true) {
			
			// ���� �ö� ���� ���ϱ�
			sum += up;
			
			// ���� �������� ���� ���
			// �㿡 �̲������� ��ŭ ����
			// �ϼ� �߰�
			if(height > sum) {
				sum -= down;
				day++;
			} else {
				break; // ���� �ö� ���̰� ����� ���� ������ �������� �ݺ��� ����
			}
			
		}
		
		// ��� ���
		System.out.println(day);
		
		// ������
		scan.close();
		
	}

}
