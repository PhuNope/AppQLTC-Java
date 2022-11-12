package information;

public class infor_DungCuHocTapMua extends infor_DungCu{

	private double GiaTien;
	private int SL;
	
	@Override
	double ThanhTien() {
		return GiaTien * SL;
	}
	
}
