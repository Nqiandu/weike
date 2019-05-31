package com.dlg.proj.demo.entity;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



public class EmpUtil {
/**ȡHttpServletRequest
 * @return
 */
public static HttpServletRequest getRequest(){
	
	ServletRequestAttributes att=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
	return 	att.getRequest();
}
/**��ȡsession
 * @return
 */
public static HttpSession getSession(){
	
	return getRequest().getSession();
}

/**��session
 * @param e
 */
public static void saveAcout(Account e){
	
	getSession().setAttribute("account", e);
}
public static void saveOrder(Order e){
	getSession().setAttribute("order", e);
}

public static Account  getAcoutFromSession(){
	Account e=(Account) getSession().getAttribute("account");
	return e;
}
public static Order  getOrderFromSession(){
		Order order= (Order) getSession().getAttribute("order");
		return order;
}


}
