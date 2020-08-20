package member.order.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.OrderDAO;
import vo.OrderBean;

public class OrderDeliveryFormService {

	public OrderBean getOrderDetail(int orderDetailNum) {
		

	Connection con = getConnection();
	OrderDAO dao = OrderDAO.getInstance();
	dao.setConnection(con);
		
	OrderBean orderBean =dao.getDeliveryInfo(orderDetailNum);
	System.out.println("주문번호 ---- "+orderDetailNum);
				
		close(con);
	return orderBean;
	}

}
