package information;

public class infor_DungCuHocTapMuon extends infor_DungCu{
	private double GiaMuon;
	private int SL;
	private int SoNgayMuon;
	@Override
	double ThanhTien() {
		return GiaMuon * SL * SoNgayMuon;
	}
	
}
