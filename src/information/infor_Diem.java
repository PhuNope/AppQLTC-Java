package information;

import java.util.Scanner;

public class infor_Diem {
	private float Diem1;
	private float Diem2;
	private float DiemThi;
	
	public float TrungBinh() {
		return ((Diem1 + Diem2 * 2)/3) * 0.3f + DiemThi * 0.7f;
	}
}
