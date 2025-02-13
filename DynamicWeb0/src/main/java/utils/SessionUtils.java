package utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionUtils {

	private static String home = "Home";
	
	public static void checkSession(HttpServletRequest request, HttpServletResponse response, String errorPage) {
		HttpSession session = request.getSession(false);
		if(isSessionNotValid(session)) {
			forward(request, response, errorPage);
		}
	}

	

	private static void forward(HttpServletRequest request, HttpServletResponse response, String aPage) {
		try {
			request.getRequestDispatcher(aPage).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	private static boolean isSessionNotValid(HttpSession session) {
		return session == null;
	}


	public static <T> T getSessionAttribute(String attributeName, HttpServletRequest request) {
		return (T) request.getSession(false).getAttribute(attributeName);
	}
	public static Object getAttribute(String attributeName, HttpServletRequest request) {
		return request.getSession(false).getAttribute(attributeName);
	}
	
	public static void setAttribute(String name, Object anObject, HttpServletRequest request) {
		request.getSession(false).setAttribute(name, request);
	}

	public static HttpSession createNewSession(HttpServletRequest request) {
		return request.getSession();
	}
	

}
