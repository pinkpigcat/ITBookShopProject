package member.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import action.Action;
import member.order.svc.OrderDeliveryFormService;
import vo.ActionForward;
import vo.OrderBean;

public class OrderDeliveryFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		System.out.println("OrderDeliveryFormAction");
		String orderNum=request.getParameter("orderNum");
		int orderDetailNum=Integer.parseInt(orderNum);
		
		OrderDeliveryFormService orderDeliveryService =new OrderDeliveryFormService();
		OrderBean orderBean=orderDeliveryService.getOrderDetail(orderDetailNum);
//		System.out.println(		"가져온사람 이메일 확인 " + orderBean.getEmail());

		
		request.setAttribute("orderBean",orderBean);
		forward = new ActionForward();
		forward.setPath("member/OrderDeliveryDetail.jsp");
		return forward;
	}

}
